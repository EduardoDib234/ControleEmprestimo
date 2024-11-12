/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleemprestimo.model;
// Definindo a classe Amigo, que representa um amigo com seus dados pessoais
public class Amigo {

    // Atributo privado que armazena o nome do amigo
    private String nome;

    // Atributo privado que armazena o número de telefone do amigo
    private String telefone;

    // Atributo privado que armazena o ID do amigo
    private int id;

    // Construtor da classe Amigo, que inicializa os atributos com os valores passados como parâmetros
    Amigo(String nome, String telefone, int id) {
        this.nome = nome;          // Inicializa o nome do amigo
        this.telefone = telefone;   // Inicializa o telefone do amigo
        this.id = id;               // Inicializa o ID do amigo
    }

    // Método público para obter o nome do amigo
    public String getNome() {
        return nome;
    }

    // Método público para definir o nome do amigo
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método público para obter o telefone do amigo
    public String getTelefone() {
        return telefone;
    }

    // Método público para definir o telefone do amigo
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método público para obter o ID do amigo
    public int getId() {
        return id;
    }

    // Método público para definir o ID do amigo
    public void setId(int id) {
        this.id = id;
    }
}

