package dao;

import model.Ferramenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe FerramentaDAO - Gerencia as operações de banco de dados relacionadas à tabela "ferramentas".
 * Inclui métodos para adicionar, atualizar, deletar e buscar registros, bem como calcular custos.
 */
public class FerramentaDAO {

    // Lista estática para armazenar objetos do tipo Ferramenta
    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();
    private static FerramentaDAO instance;   // Instância única da classe
    private Connection connection;

    // Construtor padrão da classe FerramentaDAO
    public FerramentaDAO() {
    }

    /**
     * Retorna a instância única da classe FerramentaDAO (Singleton).
     *
     * @return Instância única de FerramentaDAO.
     */
    public static FerramentaDAO getInstance() {
        if (instance == null) {
            instance = new FerramentaDAO(); // Cria uma nova instância, se ainda não existir.
        }
        return instance;
    }

    /**
     * Obtém o maior ID cadastrado na tabela "ferramentas".
     *
     * @return O maior ID encontrado ou 0 se não houver registros.
     * @throws SQLException Em caso de erro durante a consulta SQL.
     */
    public int pegaMaiorID() throws SQLException {
        int maior = 0;
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) AS id_ferramenta FROM ferramentas");
                    if (res.next()) {
                        maior = res.getInt("id_ferramenta");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maior;
    }

    /**
     * Recupera todos os registros da tabela "ferramentas" e os armazena na lista "MinhaLista".
     *
     * @return ArrayList contendo objetos Ferramenta.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        MinhaLista.clear();
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM ferramentas");
                    while (resposta.next()) {
                        int id = resposta.getInt("id_ferramenta");
                        String nome = resposta.getString("nome_ferramentas");
                        String marca = resposta.getString("marca");
                        double custo = resposta.getDouble("custo");
                        int status = resposta.getInt("status");
                        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
                        MinhaLista.add(objeto);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return MinhaLista;
    }

    /**
     * Insere um novo registro na tabela "ferramentas".
     *
     * @param objeto Objeto Ferramenta a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO ferramentas(id_ferramenta,nome_ferramentas,marca,custo, status) VALUES(?,?,?,?,1)";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, objeto.getId());
                    stmt.setString(2, objeto.getNome());
                    stmt.setString(3, objeto.getMarca());
                    stmt.setDouble(4, objeto.getCusto());
                    stmt.execute();
                }
                return true;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    /**
     * Deleta um registro específico da tabela "ferramentas".
     *
     * @param id ID do registro a ser deletado.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean deletaFerramentaBD(int id) {
        String sql = "DELETE FROM ferramentas WHERE id_ferramenta = ?";
        try (Connection conexao = ConexaoDB.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            System.err.println("Erro ao deletar ferramenta: " + erro.getMessage());
        }
        return false;
    }

    /**
     * Atualiza os dados de um registro específico na tabela "ferramentas".
     *
     * @param objeto Objeto Ferramenta com os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizarFerramenta(Ferramenta objeto) {
        String sql = "UPDATE ferramentas SET nome_ferramentas = ?, marca = ?, custo = ?, status = ? WHERE id_ferramenta = ?";
        try (Connection conexao = ConexaoDB.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getStatus());
            stmt.setInt(5, objeto.getId());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            System.err.println("Erro ao atualizar ferramenta: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Carrega os dados de uma ferramenta específica com base no ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Objeto Ferramenta com os dados encontrados.
     */
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try (Connection conexao = ConexaoDB.getConnection()) {
            if (conexao != null) {
                String sql = "SELECT * FROM ferramentas WHERE id_ferramenta = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    ResultSet resposta = stmt.executeQuery();
                    if (resposta.next()) {
                        objeto.setNome(resposta.getString("nome_ferramentas"));
                        objeto.setMarca(resposta.getString("marca"));
                        objeto.setCusto(resposta.getDouble("custo"));
                        objeto.setStatus(resposta.getInt("status"));
                    }
                }
            }
        } catch (SQLException erro) {
            System.err.println("Erro ao carregar ferramenta: " + erro.getMessage());
            throw new RuntimeException(erro);
        }
        return objeto;
    }

    /**
     * Atualiza o status de uma ferramenta específica com base no ID.
     *
     * @param idFerramenta ID da ferramenta a ser atualizada.
     * @param status Novo status a ser aplicado.
     * @return true se a atualização for bem-sucedida.
     * @throws SQLException Em caso de erro SQL.
     */
    public boolean atualizarStatusFerramenta(int idFerramenta, int status) throws SQLException {
        String sql = "UPDATE ferramentas SET status = ? WHERE id_ferramenta = ?";
        try (Connection conexao = ConexaoDB.getConnection()) {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, status);
                stmt.setInt(2, idFerramenta);
                int linhasAfetadas = stmt.executeUpdate();
                return linhasAfetadas > 0;
            }
        }
    }

    /**
     * Busca os IDs das ferramentas associadas a um empréstimo específico.
     *
     * @param idEmprestimo ID do empréstimo.
     * @return Lista de IDs das ferramentas associadas.
     * @throws SQLException Em caso de erro SQL.
     */
    public ArrayList<Integer> buscarFerramentasPorEmprestimo(int idEmprestimo) throws SQLException {
        ArrayList<Integer> ferramentas = new ArrayList<>();
        String sql = "SELECT id_ferramenta FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        try (Connection conexao = ConexaoDB.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEmprestimo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ferramentas.add(rs.getInt("id_ferramenta"));
                }
            }
        }
        return ferramentas;
    }

    /**
     * Calcula o custo total de todas as ferramentas cadastradas.
     *
     * @return Valor total do custo das ferramentas.
     */
    public double custoTotal() {
        String sql = "SELECT sum(custo) as custo_total FROM ferramentas";
        double custoTotal = 0;
        try (Connection connection = ConexaoDB.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                custoTotal = resultSet.getDouble("custo_total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return custoTotal;
    }
}
