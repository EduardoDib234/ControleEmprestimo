package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe ConexaoDB - Responsável por gerenciar a conexão com o banco de dados MySQL.
 * Fornece um método estático para obter a conexão com o banco.
 */
public class ConexaoDB {

    // URL de conexão com o banco de dados MySQL, incluindo o nome do banco
    private static final String URL = "jdbc:mysql://localhost:3306/bd_controle_emprestimo";

    // Usuário para autenticação no banco de dados
    private static final String USER = "root";

    // Senha para autenticação no banco de dados
    private static final String PASSWORD = "3.iiy:kX36eu";

    /**
     * Método estático que retorna uma conexão ativa com o banco de dados MySQL.
     *
     * @return Um objeto Connection conectado ao banco de dados.
     * @throws RuntimeException Em caso de falha na conexão com o banco de dados.
     */
    public static Connection getConnection() {
        try {
            // Retorna uma conexão utilizando as credenciais e a URL configuradas
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe o erro ocorrido
            // Lança uma exceção RuntimeException em caso de falha
            throw new RuntimeException("Erro ao conectar ao banco de dados MySQL");
        }
    }
}
