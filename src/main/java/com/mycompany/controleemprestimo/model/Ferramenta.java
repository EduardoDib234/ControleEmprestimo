package com.mycompany.controleemprestimo.model;

public class Ferramenta {

    // Atributo privado para armazenar o ID da ferramenta
    private int id;
    // Atributo privado para armazenar o nome da ferramenta
    private String nome;
    // Atributo privado para armazenar a marca da ferramenta
    private String marca;
    // Atributo privado para armazenar o custo da ferramenta
    private double custo;
    // Atributo privado que indica o status da ferramenta (true para disponível, false para indisponível)
    private boolean status;

    // Construtor da classe, inicializa todos os atributos com valores passados como parâmetros
    Ferramenta(int id, String nome, String marca, double custo, boolean status) {
        this.id = id;           // Inicializa o ID da ferramenta
        this.nome = nome;       // Inicializa o nome da ferramenta
        this.marca = marca;     // Inicializa a marca da ferramenta
        this.custo = custo;     // Inicializa o custo da ferramenta
        this.status = status;   // Inicializa o status da ferramenta
    }

    // Método público para obter o valor do ID da ferramenta
    public int getId() {
        return id;
    }

    // Método público para definir o valor do ID da ferramenta
    public void setId(int id) {
        this.id = id;
    }

    // Método público para obter o nome da ferramenta
    public String getNome() {
        return nome;
    }

    // Método público para definir o nome da ferramenta
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método público para obter a marca da ferramenta
    public String getMarca() {
        return marca;
    }

    // Método público para definir a marca da ferramenta
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método público para obter o custo da ferramenta
    public double getCusto() {
        return custo;
    }

    // Método público para definir o custo da ferramenta
    public void setCusto(double custo) {
        this.custo = custo;
    }

    // Método público para obter o status da ferramenta (disponível ou indisponível)
    public boolean isStatus() {
        return status;
    }

    // Método público para definir o status da ferramenta
    public void setStatus(boolean status) {
        this.status = status;
    }
}
