package model;

import java.util.ArrayList;  // Importa a classe ArrayList para armazenar uma lista de objetos Ferramenta

public class Emprestimo {

    private ArrayList<Ferramenta> ferramentas = new ArrayList<>();  // Lista para armazenar as ferramentas emprestadas
    private int id;  // ID único para o empréstimo
    private int idamigo;  // ID do amigo que realizou o empréstimo

    // Construtor que inicializa um objeto Emprestimo com um ID e o ID do amigo
    public Emprestimo(int id, int idamigo) {
        this.id = id;  // Atribui o ID do empréstimo
        this.idamigo = idamigo;  // Atribui o ID do amigo que fez o empréstimo
    }

    // Método getter para retornar a lista de ferramentas associadas ao empréstimo
    public ArrayList<Ferramenta> getFerramentas() {
        return ferramentas;  // Retorna a lista de ferramentas
    }

    // Método setter para definir a lista de ferramentas associadas ao empréstimo
    public void setFerramentas(ArrayList<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;  // Atribui uma nova lista de ferramentas ao empréstimo
    }

    // Método getter para retornar o ID do empréstimo
    public int getId() {
        return id;  // Retorna o ID do empréstimo
    }

    // Método setter para definir o ID do empréstimo
    public void setId(int id) {
        this.id = id;  // Atribui um novo ID ao empréstimo
    }

    // Método getter para retornar o ID do amigo que fez o empréstimo
    public int getIdamigo() {
        return idamigo;  // Retorna o ID do amigo que fez o empréstimo
    }

    // Método setter para definir o ID do amigo que fez o empréstimo
    public void setIdamigo(int idamigo) {
        this.idamigo = idamigo;  // Atribui um novo ID ao amigo que fez o empréstimo
    }
}
