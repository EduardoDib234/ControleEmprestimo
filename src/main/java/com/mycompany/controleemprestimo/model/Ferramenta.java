package com.mycompany.controleemprestimo.model;

import com.mycompany.controleemprestimo.dao.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramenta {

    private int id;         // Atributo para armazenar o ID único da ferramenta
    private String nome;    // Atributo para armazenar o nome da ferramenta
    private String marca;  // Atributo para armazenar a marca da ferramenta
    private double custo;  // Atributo para armazenar o status da ferramenta
    private String status;   // Atributo para armazenar o custo da ferramenta
    private final FerramentaDAO dao;  // Instância da classe FerramentaDAO, responsável por interagir com o banco de dados

    // Construtor padrão que inicializa a instância da classe FerramentaDAO
    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    // Construtor que inicializa a ferramenta com nome, status e custo
    public Ferramenta(String nome, String marca, double custo, String status) {
        this.dao = new FerramentaDAO();  // Inicializa a instância de FerramentaDAO
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    // Construtor que inicializa uma ferramenta com todos os atributos: id, nome, status e custo
    public Ferramenta(int id, String nome, String marca, double custo, String status) {
        this.dao = new FerramentaDAO();  // Inicializa a instância de FerramentaDAO
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    // Métodos getters (acessores) para obter os valores dos atributos
    public int getId() {
        return id;  // Retorna o ID da ferramenta
    }

    public String getNome() {
        return nome;  // Retorna o nome da ferramenta
    }

    public String getMarca() {
        return marca;  // Retorna o nome da ferramenta
    }

    public String getStatus() {
        return status;  // Retorna o status da ferramenta
    }

    public double getCusto() {
        return custo;  // Retorna o custo da ferramenta
    }

    // Métodos setters (modificadores) para modificar os valores dos atributos
    public void setId(int id) {
        this.id = id;  // Define o ID da ferramenta
    }

    public void setNome(String nome) {
        this.nome = nome;  // Define o nome da ferramenta
    }

    public void setMarca(String marca) {
        this.marca = marca;  // Define o nome da ferramenta
    }

    public void setStatus(String status) {
        this.status = status;  // Define o status da ferramenta
    }

    public void setCusto(double custo) {
        this.custo = custo;  // Define o custo da ferramenta
    }

    // Métodos Controllers para interação com o banco de dados
    // Retorna o maior ID das ferramentas armazenadas no banco de dados
    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();  // Chama o método pegaMaiorID() do DAO para obter o maior ID
    }

    // Retorna uma lista de ferramentas
    public ArrayList<Ferramenta> pegarLista() {
        return dao.getMinhaLista();  // Chama o método getMinhaLista() do DAO para obter todas as ferramentas
    }

    public boolean insertFerramenta(String nome, String marca, double custo, String status) throws SQLException {
        int id = this.maiorID() + 1;  // Obtém o maior ID e incrementa 1 para criar um novo ID
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);  // Cria um objeto Ferramenta com os dados fornecidos
        dao.inserirFerramentaBD(objeto);  // Chama o método inserirFerramentaBD() do DAO para salvar a ferramenta no banco
        return true;  // Retorna true após a inserção bem-sucedida
    }

    // Atualiza as informações de uma ferramenta no banco de dados
    public boolean updateFerramentaBD(int id, String nome, String marca, double custo, String status) throws SQLException {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);  // Cria um objeto Ferramenta com os dados atualizados
        dao.atualizarFerramenta(objeto);  // Chama o método atualizarFerramenta() do DAO para atualizar a ferramenta no banco
        return true;  // Retorna true após a atualização bem-sucedida
    }

    // Carrega uma ferramenta do banco de dados usando seu ID
    public Ferramenta pegaFerramenta(int id) {
        return dao.carregaFerramenta(id);  // Chama o método carregaFerramenta() do DAO para buscar a ferramenta no banco
    }
}
