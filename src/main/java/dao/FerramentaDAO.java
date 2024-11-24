package dao;

import model.Ferramenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FerramentaDAO {

    // Lista estática para armazenar objetos do tipo Ferramenta
    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();
    private static FerramentaDAO instance;   // Instância única da classe
    private Connection connection;

    // Construtor padrão da classe FerramentaDAO
    public FerramentaDAO() {

    }

    public static FerramentaDAO getInstance() {
        if (instance == null) {
            // Se a instância não existir, cria uma nova
            instance = new FerramentaDAO();

        }
        return instance;

    }

    /**
     * Método para pegar o maior e último ID cadastrado na tabela "ferramentas".
     *
     * @return o maior ID encontrado na tabela ou 0 se não houver registros.
     * @throws SQLException em caso de erro na consulta SQL.
     */
    public int pegaMaiorID() throws SQLException {
        int maior = 0; // Inicializa o maior ID como 0
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                // Cria um Statement para executar a consulta SQL
                try ( Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) AS id_ferramenta FROM ferramentas");
                    // Verifica se há resultado e armazena o valor do maior ID
                    if (res.next()) {
                        maior = res.getInt("id_ferramenta");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return maior; // Retorna o maior ID encontrado
    }

    /**
     * Método para recuperar todos os registros da tabela "ferramentas" e
     * atualiza a lista "MinhaLista" com os objetos recuperados.
     *
     * @return ArrayList contendo todos os objetos Ferramenta.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        MinhaLista.clear(); // Limpa a lista para evitar dados duplicados
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try ( Statement stmt = conexao.createStatement()) {
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM ferramentas");
                    // Itera sobre os resultados e cria objetos Ferramenta
                    while (resposta.next()) {
                        int id = resposta.getInt("id_ferramenta");
                        String nome = resposta.getString("nome_ferramentas");
                        String marca = resposta.getString("marca");
                        double custo = resposta.getDouble("custo");
                        int status = resposta.getInt("status");
                        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
                        MinhaLista.add(objeto); // Adiciona o objeto à lista
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return MinhaLista; // Retorna a lista com todas as ferramentas
    }

    /**
     * Método para inserir um novo registro na tabela "ferramentas".
     *
     * @param objeto Objeto Ferramenta a ser inserido no banco.
     * @return true se a inserção foi bem-sucedida, false caso contrário.
     */
    public boolean inserirFerramentaBD(Ferramenta objeto) {
        // Adicione o campo "status" e "custo" na consulta
        String sql = "INSERT INTO ferramentas(id_ferramenta,nome_ferramentas,marca,custo, status) VALUES(?,?,?,?,1)";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try ( PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    // Configure os valores dos placeholders na ordem correta
                    stmt.setInt(1, objeto.getId());
                    stmt.setString(2, objeto.getNome());
                    stmt.setString(3, objeto.getMarca());
                    stmt.setDouble(4, objeto.getCusto());

                    stmt.execute(); // Executa o comando de inserção
                }
                return true; // Retorna true se a inserção foi bem-sucedida
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro); // Lança exceção em caso de erro
        }
        return false; // Retorna false se a inserção falhou
    }

    /**
     * Método para deletar um registro específico da tabela "ferramentas".
     *
     * @param id ID da ferramenta a ser deletada.
     * @return true se a exclusão foi bem-sucedida, false caso contrário.
     */
    public boolean deletaFerramentaBD(int id) {
        String sql = "DELETE FROM ferramentas WHERE id_ferramenta = ?";
        try ( Connection conexao = ConexaoDB.getConnection();  PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id); // Configura o parâmetro do ID
            int linhasAfetadas = stmt.executeUpdate(); // Executa o comando de deleção

            // Retorna true se ao menos uma linha foi deletada
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            System.err.println("Erro ao deletar ferramenta: " + erro.getMessage());
        }
        return false; // Retorna false em caso de falha
    }

    /**
     * Método para atualizar os dados de um registro existente na tabela
     * "ferramentas".
     *
     * @param objeto Objeto Ferramenta contendo os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarFerramenta(Ferramenta objeto) {
        String sql = "UPDATE ferramentas SET nome_ferramentas = ?, marca = ?, custo = ?, status = ? WHERE id_ferramenta = ?";
        try ( Connection conexao = ConexaoDB.getConnection();  PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Configura os parâmetros para a consulta
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getStatus());
            stmt.setInt(5, objeto.getId());

            // Executa a atualização e verifica se houve alteração
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se alguma linha foi atualizada
        } catch (SQLException erro) {
            System.err.println("Erro ao atualizar ferramenta: " + erro.getMessage());
            return false; // Retorna false se ocorrer um erro
        }
    }

    /**
     * Método para carregar os dados de uma ferramenta específica a partir do
     * ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Objeto Ferramenta com os dados carregados do banco.
     */
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta(); // Cria um objeto Ferramenta vazio
        objeto.setId(id); // Define o ID no objeto
        try ( Connection conexao = ConexaoDB.getConnection()) {
            if (conexao != null) {
                String sql = "SELECT * FROM ferramentas WHERE id_ferramenta = ?";
                try ( PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id); // Define o parâmetro de ID
                    ResultSet resposta = stmt.executeQuery(); // Executa a consulta

                    // Se encontrar a ferramenta no banco de dados, popula o objeto
                    if (resposta.next()) {
                        objeto.setNome(resposta.getString("nome_ferramentas"));
                        objeto.setMarca(resposta.getString("marca"));
                        objeto.setCusto(resposta.getDouble("custo"));
                        objeto.setStatus(resposta.getInt("status"));
                    }
                }
            }
        } catch (SQLException erro) {
            System.err.println("Erro ao carregar ferramenta: " + erro.getMessage()); // Exibe o erro
            throw new RuntimeException(erro); // Lança a exceção para o método chamar o erro
        }
        return objeto; // Retorna o objeto Ferramenta com os dados carregados
    }

    public boolean atualizarStatusFerramenta(int idFerramenta, int status) throws SQLException {
        String sql = "UPDATE ferramentas SET status = ? WHERE id_ferramenta = ?";
        try ( Connection conexao = ConexaoDB.getConnection()) {

            try ( PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, status);
                stmt.setInt(2, idFerramenta);

                int linhasAfetadas = stmt.executeUpdate();
                return linhasAfetadas > 0; // Retorna true se a atualização foi bem-sucedida
            }
        }
    }

    public ArrayList<Integer> buscarFerramentasPorEmprestimo(int idEmprestimo) throws SQLException {
        // Lista para armazenar os IDs das ferramentas associadas ao empréstimo
        ArrayList<Integer> ferramentas = new ArrayList<>();

        // Consulta SQL para buscar todas as ferramentas associadas ao empréstimo
        String sql = "SELECT id_ferramenta FROM ferramentas_emprestadas WHERE id_emprestimo = ?";

        // Tentativa de obter a conexão e executar a consulta
        try ( Connection conexao = ConexaoDB.getConnection(); // Abre a conexão com o banco
                  PreparedStatement stmt = conexao.prepareStatement(sql)) { // Prepara a consulta

            stmt.setInt(1, idEmprestimo); // Passa o id do empréstimo como parâmetro na consulta

            try ( ResultSet rs = stmt.executeQuery()) { // Executa a consulta e obtém o resultado
                // Itera sobre o conjunto de resultados (ResultSet)
                while (rs.next()) {
                    // Adiciona cada id de ferramenta encontrado à lista
                    ferramentas.add(rs.getInt("id_ferramenta"));
                }
            }
        }

        // Retorna a lista com os IDs das ferramentas
        return ferramentas;
    }
}
