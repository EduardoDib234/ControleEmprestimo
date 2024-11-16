package com.mycompany.controleemprestimo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_controle_emprestimo";
    private static final String USER = "root";
    private static final String PASSWORD = "3.iiy:kX36eu";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados MySQL");
        }
    }
}
