package com.mycompany.controleemprestimo.model;

import com.mycompany.controleemprestimo.dao.AmigoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Amigo {
    private int id;
    private String nome;
    private String telefone;
    private final AmigoDAO dao;

    public Amigo() {
        this.dao = new AmigoDAO();
    }

    public Amigo(String nome, String telefone) {
        this.dao = new AmigoDAO();
        this.nome = nome;
        this.telefone = telefone;
    }

    public Amigo(int id, String nome, String telefone) {
        this.dao = new AmigoDAO();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Métodos Controllers //
    // Retorna o maior ID da base de dados
    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();
    }

    // Retorna uma lista de amigos
    public ArrayList<Amigo> pegarLista() {
        return dao.getMinhaLista();
    }

    // Insere um amigo no banco
    public boolean insertAmigo(String nome, String telefone) throws SQLException {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.inserirAmigoBD(objeto);
        return true;
    }

    // Atualiza as informações de um amigo no banco
    public boolean updateAmigoBD(String nome, int id, String telefone) throws SQLException {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.atualizarAmigo(objeto);
        return true;
    }

    // Carrega um amigo pelo ID
    public Amigo pegaAmigo(int id) {
        return dao.carregaAmigo(id);
    }
}
