package model;

import dao.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramenta {

    private int id;         // ID único da ferramenta
    private String nome;    // Nome da ferramenta
    private String marca;   // Marca da ferramenta
    private double custo;   // Custo da ferramenta
    private int status;     // Status da ferramenta (1: Disponível, 2: Indisponível, etc.)
    private final FerramentaDAO dao;  // Instância da classe FerramentaDAO para interação com o banco de dados
    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }
    public Ferramenta(String nome, String marca, double custo, int status) {
        this.dao = new FerramentaDAO();
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    public Ferramenta(int id, String nome, String marca, double custo, int status) {
        this.dao = new FerramentaDAO();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();
    }

    public ArrayList<Ferramenta> pegarLista() {
        return dao.getMinhaLista();
    }

    public boolean insertFerramenta(String nome, String marca, double custo, int status) throws SQLException {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
        dao.inserirFerramentaBD(objeto);
        return true;
    }

    public boolean updateFerramentaBD(int id, String nome, String marca, double custo, int status) throws SQLException {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
        dao.atualizarFerramenta(objeto);
        return true;
    }

    public Ferramenta pegaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }
}
