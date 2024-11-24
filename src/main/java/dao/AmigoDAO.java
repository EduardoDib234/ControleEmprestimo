package dao;

import model.Amigo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Classe AmigoDAO - Gerencia as operações de banco de dados relacionadas à tabela "amigos".
 * Inclui métodos para adicionar, atualizar, deletar e buscar registros, bem como recuperar o maior ID.
 */
public class AmigoDAO {

    // Lista estática para armazenar objetos do tipo Amigo
    public static ArrayList<Amigo> MinhaLista = new ArrayList<>();

    // Construtor padrão da classe AmigoDAO
    public AmigoDAO() {
    }

    /**
     * Método para pegar o maior e último ID cadastrado na tabela "amigos".
     *
     * @return O maior ID encontrado na tabela ou 0 se não houver registros.
     * @throws SQLException Em caso de erro na consulta SQL.
     */
    public int pegaMaiorID() throws SQLException {
        int maior = 0; // Inicializa o maior ID como 0
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) AS id_amigo FROM amigos");
                    if (res.next()) {
                        maior = res.getInt("id_amigo"); // Obtém o maior ID da tabela
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return maior; // Retorna o maior ID encontrado
    }

    /**
     * Método para recuperar todos os registros da tabela "amigos" e atualizar a lista "MinhaLista" com os objetos recuperados.
     *
     * @return ArrayList contendo todos os objetos Amigo.
     */
    public ArrayList<Amigo> getMinhaLista() {
        MinhaLista.clear(); // Limpa a lista para evitar dados duplicados
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM amigos");
                    while (resposta.next()) {
                        int id = resposta.getInt("id_amigo");
                        String nome = resposta.getString("nome_amigo");
                        String telefone = resposta.getString("telefone");
                        String score = resposta.getString("score");
                        Amigo objeto = new Amigo(id, nome, telefone, score);
                        MinhaLista.add(objeto); // Adiciona o objeto à lista
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return MinhaLista; // Retorna a lista com todos os amigos
    }

    /**
     * Método para inserir um novo registro na tabela "amigos".
     *
     * @param objeto Objeto Amigo a ser inserido no banco.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO amigos(nome_amigo, telefone, score) VALUES(?, ?, ?)";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, objeto.getNome());       // Nome do amigo
                    stmt.setString(2, objeto.getTelefone());   // Telefone do amigo
                    stmt.setString(3, objeto.getScore());      // Score do amigo
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
     * Método para deletar um registro específico da tabela "amigos".
     *
     * @param id ID do amigo a ser deletado.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean deletaAmigoBD(int id) {
        String sql = "DELETE FROM amigos WHERE id_amigo = ?";
        try (Connection conexao = ConexaoDB.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id); // Configura o parâmetro do ID
            int linhasAfetadas = stmt.executeUpdate(); // Executa o comando de deleção
            return linhasAfetadas > 0; // Retorna true se ao menos uma linha foi deletada
        } catch (SQLException erro) {
            System.err.println("Erro ao deletar amigo: " + erro.getMessage());
        }
        return false; // Retorna false em caso de falha
    }

    /**
     * Método para atualizar os dados de um registro existente na tabela "amigos".
     *
     * @param objeto Objeto Amigo contendo os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarAmigo(Amigo objeto) {
        String sql = "UPDATE amigos SET nome_amigo = ?, telefone = ?, score = ? WHERE id_amigo = ?";
        try (Connection conexao = ConexaoDB.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, objeto.getNome());    // Nome atualizado
            stmt.setString(2, objeto.getTelefone()); // Telefone atualizado
            stmt.setString(3, objeto.getScore());    // Score atualizado
            stmt.setInt(4, objeto.getId());          // ID do amigo
            int linhasAfetadas = stmt.executeUpdate(); // Executa a atualização
            return linhasAfetadas > 0; // Retorna true se alguma linha foi atualizada
        } catch (SQLException erro) {
            System.err.println("Erro ao atualizar amigo: " + erro.getMessage());
            return false; // Retorna false se ocorrer um erro
        }
    }

    /**
     * Método para carregar os dados de um amigo específico a partir do ID.
     *
     * @param id ID do amigo a ser carregado.
     * @return Objeto Amigo com os dados carregados do banco.
     */
    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo(); // Cria um objeto Amigo vazio
        objeto.setId(id); // Define o ID no objeto
        try (Connection conexao = ConexaoDB.getConnection()) {
            if (conexao != null) {
                String sql = "SELECT * FROM amigos WHERE id_amigo = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id); // Define o parâmetro de ID
                    ResultSet resposta = stmt.executeQuery(); // Executa a consulta
                    if (resposta.next()) {
                        objeto.setNome(resposta.getString("nome_amigo")); // Define o nome
                        objeto.setTelefone(resposta.getString("telefone")); // Define o telefone
                        objeto.setScore(resposta.getString("score")); // Define o score
                    }
                }
            }
        } catch (SQLException erro) {
            System.err.println("Erro ao carregar amigo: " + erro.getMessage()); // Exibe o erro
            throw new RuntimeException(erro); // Lança a exceção para o método chamar o erro
        }
        return objeto; // Retorna o objeto Amigo com os dados carregados
    }

    /**
     * Busca o nome de um amigo pelo seu ID.
     *
     * @param IdAmigo ID do amigo a ser buscado.
     * @return Nome do amigo, se encontrado.
     * @throws SQLException Em caso de erro na consulta SQL.
     */
    public String buscarNomeAmigoPorId(int IdAmigo) throws SQLException {
        String nomeAmigo = null;
        String sql = "SELECT nome_amigo FROM amigos WHERE id_amigo = ?";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, IdAmigo); // Configura o parâmetro ID do amigo
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomeAmigo = rs.getString("nome_amigo"); // Obtém o nome do amigo
                }
            }
        }
        return nomeAmigo;
    }
}
