package com.mycompany.controleemprestimo.dao;

import com.mycompany.controleemprestimo.model.Amigo;
import com.mycompany.controleemprestimo.dao.ConexaoDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AmigoDAO {

    // Lista estática para armazenar objetos do tipo Amigo
    public static ArrayList<Amigo> MinhaLista = new ArrayList<>();

    // Construtor padrão da classe AmigoDAO
    public AmigoDAO() {
    }

    /**
     * Método para pegar o maior e último ID cadastrado na tabela "amigos".
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
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) AS id_amigo FROM amigos");
                    // Verifica se há resultado e armazena o valor do maior ID
                    if (res.next()) {
                        maior = res.getInt("id_amigo");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return maior; // Retorna o maior ID encontrado
    }

    /**
     * Método para recuperar todos os registros da tabela "amigos" e 
     * atualiza a lista "MinhaLista" com os objetos recuperados.
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
                    // Itera sobre os resultados e cria objetos Amigo
                    while (resposta.next()) {
                        int id = resposta.getInt("id_amigo");
                        String nome = resposta.getString("nome");
                        String telefone = resposta.getString("telefone");

                        Amigo objeto = new Amigo(id, nome, telefone);
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
     * @return true se a inserção foi bem-sucedida, false caso contrário.
     */
    public boolean inserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO amigos(nome, telefone) VALUES(?, ?)";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, objeto.getNome());
                    stmt.setString(2, objeto.getTelefone());
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
     * @return true se a exclusão foi bem-sucedida, false caso contrário.
     */
    public boolean deletaAmigoBD(int id) {
        String sql = "DELETE FROM amigos WHERE id_amigo = ?";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    int linhasAfetadas = stmt.executeUpdate(); // Executa o comando de deleção
                    return linhasAfetadas > 0; // Verifica se alguma linha foi afetada
                }
            }
        } catch (SQLException erro) {
            erro.printStackTrace(); // Exibe o erro em caso de exceção SQL
        }
        return false; // Retorna false se a exclusão falhou
    }

    /**
     * Método para atualizar os dados de um registro existente na tabela "amigos".
     * 
     * @param objeto Objeto Amigo contendo os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarAmigo(Amigo objeto) {
        String sql = "UPDATE amigos SET nome = ?, telefone = ? WHERE id_amigo = ?";
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, objeto.getNome());
                    stmt.setString(2, objeto.getTelefone());
                    stmt.setInt(3, objeto.getId());
                    int linhasAfetadas = stmt.executeUpdate(); // Executa o comando de atualização
                    return linhasAfetadas > 0; // Verifica se alguma linha foi afetada
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro); // Lança exceção em caso de erro
        }
        return false; // Retorna false se a atualização falhou
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
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                String sql = "SELECT * FROM amigos WHERE id_amigo = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id); // Define o parâmetro de ID
                    ResultSet resposta = stmt.executeQuery(); // Executa a consulta
                    if (resposta.next()) {
                        objeto.setNome(resposta.getString("nome"));
                        objeto.setTelefone(resposta.getString("telefone"));
                    }
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro); // Lança exceção em caso de erro
        }
        return objeto; // Retorna o objeto Amigo com os dados carregados
    }
}

