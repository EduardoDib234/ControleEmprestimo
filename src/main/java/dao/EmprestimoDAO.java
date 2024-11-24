package dao;

import model.Emprestimo;
import model.SituacaoEmprestimo;
import model.Ferramenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe EmprestimoDAO - Gerencia as operações de banco de dados relacionadas à tabela "emprestimos".
 * Inclui métodos para adicionar, atualizar, deletar e buscar registros, além de métodos auxiliares para
 * operações em lote e atualizações específicas.
 */
public class EmprestimoDAO {

    private static final EmprestimoDAO instance = new EmprestimoDAO(); // Instância única da classe (Singleton)

    // Construtor privado para garantir que a classe não seja instanciada diretamente
    private EmprestimoDAO() {
    }

    /**
     * Retorna a instância única da classe EmprestimoDAO (Singleton).
     *
     * @return Instância única de EmprestimoDAO.
     */
    public static EmprestimoDAO getInstance() {
        return instance;
    }

    /**
     * Insere um novo empréstimo no banco de dados, juntamente com as ferramentas associadas.
     * Realiza também a atualização do status das ferramentas para "indisponível".
     *
     * @param emprestimo Objeto Emprestimo a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirEmprestimo(Emprestimo emprestimo) {
        String sqlEmprestimo = "INSERT INTO emprestimos (id_amigo, data_emprestimo, data_devolucao, status, custo_total) VALUES (?, ?, ?, ?, ?)";
        String sqlFerramentasEmprestadas = "INSERT INTO ferramentas_emprestadas (id_emprestimo, id_ferramenta) VALUES (?, ?)";
        String sqlAtualizaFerramenta = "UPDATE ferramentas SET status = ? WHERE id_ferramenta = ?";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psEmprestimo = connection.prepareStatement(sqlEmprestimo, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psFerramentasEmprestadas = connection.prepareStatement(sqlFerramentasEmprestadas);
             PreparedStatement psAtualizaFerramenta = connection.prepareStatement(sqlAtualizaFerramenta)) {

            connection.setAutoCommit(false);

            // Inserir o empréstimo e obter o ID gerado
            psEmprestimo.setInt(1, emprestimo.getIdAmigo());
            psEmprestimo.setDate(2, new java.sql.Date(emprestimo.getDataInicial().getTime()));
            psEmprestimo.setDate(3, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            psEmprestimo.setInt(4, SituacaoEmprestimo.ABERTO.ordinal() + 1); // Status: "ABERTO"
            psEmprestimo.setDouble(5, emprestimo.getCustoTotal());
            psEmprestimo.executeUpdate();

            // Obter o ID do empréstimo gerado
            ResultSet generatedKeys = psEmprestimo.getGeneratedKeys();
            if (generatedKeys.next()) {
                int emprestimoId = generatedKeys.getInt(1); // ID do empréstimo gerado

                // Inserir as ferramentas associadas ao empréstimo
                for (Ferramenta ferramenta : emprestimo.getFerramentasSelecionadas()) {
                    psFerramentasEmprestadas.setInt(1, emprestimoId); // ID do empréstimo
                    psFerramentasEmprestadas.setInt(2, ferramenta.getId()); // ID da ferramenta
                    psFerramentasEmprestadas.addBatch();

                    // Atualizar o status da ferramenta para "indisponível"
                    psAtualizaFerramenta.setBoolean(1, false); // Status "indisponível"
                    psAtualizaFerramenta.setInt(2, ferramenta.getId());
                    psAtualizaFerramenta.addBatch();
                }

                // Executa o batch para as ferramentas e atualiza os status
                psFerramentasEmprestadas.executeBatch();
                psAtualizaFerramenta.executeBatch();
            } else {
                throw new SQLException("Erro ao obter o ID do empréstimo.");
            }

            // Commit da transação
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection connection = ConexaoDB.getConnection()) {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        }
    }

    /**
     * Atualiza os dados de um empréstimo existente no banco de dados.
     *
     * @param emprestimo Objeto Emprestimo contendo os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        String sqlUpdate = "UPDATE emprestimos SET id_amigo = ?, data_emprestimo = ?, data_devolucao = ?, status = ?, custo_total = ? WHERE id_emprestimo = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlUpdate)) {

            ps.setInt(1, emprestimo.getIdAmigo());
            ps.setDate(2, emprestimo.getDataInicial());
            ps.setDate(3, emprestimo.getDataDevolucao());
            ps.setInt(4, emprestimo.getStatus().getCodigo());
            ps.setInt(5, emprestimo.getIdEmprestimo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove um empréstimo e as ferramentas associadas do banco de dados.
     *
     * @param idEmprestimo ID do empréstimo a ser removido.
     * @return true se a remoção for bem-sucedida, false caso contrário.
     */
    public boolean removerEmprestimo(int idEmprestimo) {
        String sqlDeleteEmprestimo = "DELETE FROM emprestimos WHERE id_emprestimo = ?";
        String sqlDeleteFerramentas = "DELETE FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psDeleteFerramentas = connection.prepareStatement(sqlDeleteFerramentas);
             PreparedStatement psDeleteEmprestimo = connection.prepareStatement(sqlDeleteEmprestimo)) {

            connection.setAutoCommit(false);

            psDeleteFerramentas.setInt(1, idEmprestimo);
            psDeleteFerramentas.executeUpdate();

            psDeleteEmprestimo.setInt(1, idEmprestimo);
            int linhasAfetadas = psDeleteEmprestimo.executeUpdate();

            if (linhasAfetadas > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lista todos os empréstimos existentes no banco de dados.
     *
     * @return ArrayList contendo todos os objetos Emprestimo.
     */
    public ArrayList<Emprestimo> listarEmprestimos() {
        String sqlSelectAll = "SELECT * FROM emprestimos";
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        try (Connection connection = ConexaoDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlSelectAll)) {

            while (resultSet.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(resultSet.getInt("id_emprestimo"));
                emprestimo.setIdAmigo(resultSet.getInt("id_amigo"));
                emprestimo.setDataInicial(resultSet.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(resultSet.getDate("data_devolucao"));
                emprestimo.setStatus(SituacaoEmprestimo.values()[resultSet.getInt("status") - 1]);
                emprestimo.setCustoTotal(resultSet.getDouble("custo_total"));
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }

    /**
     * Busca um empréstimo específico pelo seu ID, incluindo as ferramentas associadas.
     *
     * @param id ID do empréstimo a ser buscado.
     * @return Objeto Emprestimo contendo as informações do empréstimo e das ferramentas associadas.
     */
    public Emprestimo buscarEmprestimoPorId(int id) {
        String sqlEmprestimo = "SELECT * FROM emprestimos WHERE id_emprestimo = ?";
        String sqlFerramentas = "SELECT f.* FROM ferramentas_emprestadas fe INNER JOIN ferramentas f ON fe.id_ferramenta = f.id_ferramenta WHERE fe.id_emprestimo = ?";
        Emprestimo emprestimo = null;

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psEmprestimo = connection.prepareStatement(sqlEmprestimo);
             PreparedStatement psFerramentas = connection.prepareStatement(sqlFerramentas)) {

            psEmprestimo.setInt(1, id);
            ResultSet rsEmprestimo = psEmprestimo.executeQuery();

            if (rsEmprestimo.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(rsEmprestimo.getInt("id_emprestimo"));
                emprestimo.setIdAmigo(rsEmprestimo.getInt("id_amigo"));
                emprestimo.setDataInicial(rsEmprestimo.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rsEmprestimo.getDate("data_devolucao"));
                emprestimo.setStatus(SituacaoEmprestimo.values()[rsEmprestimo.getInt("status") - 1]);
                emprestimo.setCustoTotal(rsEmprestimo.getDouble("custo_total"));

                psFerramentas.setInt(1, id);
                ResultSet rsFerramentas = psFerramentas.executeQuery();
                List<Ferramenta> ferramentas = new ArrayList<>();
                while (rsFerramentas.next()) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId(rsFerramentas.getInt("id_ferramenta"));
                    ferramenta.setNome(rsFerramentas.getString("nome_ferramentas"));
                    ferramenta.setMarca(rsFerramentas.getString("marca"));
                    ferramenta.setCusto(rsFerramentas.getDouble("custo"));
                    ferramenta.setStatus(rsFerramentas.getInt("status"));
                    ferramentas.add(ferramenta);
                }
                emprestimo.setFerramentasSelecionadas(ferramentas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimo;
    }

    /**
     * Executa um batch de operações para atualizar o status das ferramentas associadas a um empréstimo.
     *
     * @param connection Conexão com o banco de dados.
     * @param sql SQL a ser executado.
     * @param ferramentas Lista de ferramentas a serem atualizadas.
     * @param status Status a ser aplicado.
     * @throws SQLException Em caso de erro na execução do batch.
     */
    private void executarBatch(Connection connection, String sql, List<Ferramenta> ferramentas, boolean status) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Ferramenta ferramenta : ferramentas) {
                ps.setBoolean(1, status);
                ps.setInt(2, ferramenta.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    /**
     * Busca o nome de um amigo específico pelo seu ID.
     *
     * @param IdAmigo ID do amigo.
     * @return Nome do amigo, se encontrado.
     * @throws SQLException Em caso de erro na consulta SQL.
     */
    public String buscarNomeAmigoPorId(int IdAmigo) throws SQLException {
        String nomeAmigo = null;
        String sql = "SELECT nome_amigo FROM amigos WHERE id_amigo = ?";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, IdAmigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomeAmigo = rs.getString("nome_amigo");
                }
            }
        }
        return nomeAmigo;
    }

    /**
     * Atualiza a data de devolução de um empréstimo específico.
     *
     * @param idEmprestimo ID do empréstimo.
     * @param novaDataDevolucao Nova data de devolução.
     * @throws SQLException Em caso de erro na atualização.
     */
    public void atualizarDataDevolucao(int idEmprestimo, java.sql.Date novaDataDevolucao) throws SQLException {
        String sql = "UPDATE emprestimos SET data_devolucao = ? WHERE id_emprestimo = ?";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, novaDataDevolucao); // Define a nova data de devolução
            stmt.setInt(2, idEmprestimo); // Define o ID do empréstimo

            stmt.executeUpdate(); // Executa o comando de atualização
        }
    }

    /**
     * Atualiza o status de um empréstimo específico.
     *
     * @param idEmprestimo ID do empréstimo.
     * @param status Novo status a ser aplicado.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     * @throws SQLException Em caso de erro na atualização.
     */
    public boolean atualizarStatusEmprestimo(int idEmprestimo, int status) throws SQLException {
        String sql = "UPDATE emprestimos SET status = ? WHERE id_emprestimo = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, status);
            stmt.setInt(2, idEmprestimo);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a atualização foi bem-sucedida
        }
    }

    /**
     * Busca os amigos que possuem mais empréstimos, ordenando por quantidade em ordem decrescente.
     *
     * @return Lista de arrays contendo o ID do amigo e a quantidade de empréstimos.
     */
    public ArrayList<int[]> buscaAmigosMaisEmprestimos() {
        String sql = "SELECT id_amigo, COUNT(id_amigo) as qtd FROM emprestimos GROUP BY id_amigo ORDER BY COUNT(id_amigo) DESC";
        ArrayList<int[]> idAmigoEQtd = new ArrayList<>();

        try (Connection connection = ConexaoDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int idAmigo = resultSet.getInt("id_amigo");
                int qtd = resultSet.getInt("qtd");

                int[] arr = {idAmigo, qtd};
                idAmigoEQtd.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idAmigoEQtd;
    }

    /**
     * Busca todos os empréstimos que ainda não foram devolvidos (status = 3).
     *
     * @return Lista de IDs dos amigos que possuem empréstimos não devolvidos.
     */
    public ArrayList<Integer> buscaEmprestimoNãoDevolvidos() {
        String sql = "SELECT id_amigo FROM emprestimos WHERE status = 3";
        ArrayList<Integer> idAmigos = new ArrayList<>();

        try (Connection connection = ConexaoDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int idAmigo = resultSet.getInt("id_amigo");
                idAmigos.add(idAmigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idAmigos;
    }

    /**
     * Verifica se um determinado amigo possui pelo menos um empréstimo registrado.
     *
     * @param idAmigo ID do amigo.
     * @return true se o amigo possui empréstimos, false caso contrário.
     */
    public boolean verificaExisteEmprestimo(int idAmigo) {
        String sql = "SELECT COUNT(id_amigo) as qtd FROM emprestimos WHERE id_amigo = ? GROUP BY id_amigo";
        int qtd = 0;

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAmigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    qtd = rs.getInt("qtd");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (qtd > 0);
    }
}
