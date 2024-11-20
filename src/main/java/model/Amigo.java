package model;

import dao.AmigoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Amigo {

    private int id;  // Atributo para armazenar o ID único do amigo
    private String nome;  // Atributo para armazenar o nome do amigo
    private String telefone;  // Atributo para armazenar o telefone do amigo
    private final AmigoDAO dao;  // Instância da classe AmigoDAO, responsável por interagir com o banco de dados
    private String score;  // Atributo para armazenar o "score" (pontuação ou categoria) do amigo

    // Construtor padrão que inicializa a instância da classe AmigoDAO
    public Amigo() {
        this.dao = new AmigoDAO();
    }

    // Construtor que inicializa um amigo com nome, telefone e score
    public Amigo(String nome, String telefone, String score) {
        this.dao = new AmigoDAO();  // Inicializa a instância de AmigoDAO
        this.nome = nome;
        this.telefone = telefone;
        this.score = score;
    }

    // Construtor que inicializa um amigo com todos os atributos: id, nome, telefone e score
    public Amigo(int id, String nome, String telefone, String score) {
        this.dao = new AmigoDAO();  // Inicializa a instância de AmigoDAO
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.score = score;
    }

    // Métodos getters (acessores) para obter os valores dos atributos
    public int getId() {
        return id;  // Retorna o ID do amigo
    }

    public String getNome() {
        return nome;  // Retorna o nome do amigo
    }

    public String getTelefone() {
        return telefone;  // Retorna o telefone do amigo
    }

    public String getScore() {
        return score;  // Retorna o score do amigo
    }

    // Métodos setters (modificadores) para modificar os valores dos atributos
    public void setId(int id) {
        this.id = id;  // Define o ID do amigo
    }

    public void setNome(String nome) {
        this.nome = nome;  // Define o nome do amigo
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;  // Define o telefone do amigo
    }

    public void setScore(String score) {
        this.score = score;  // Define o score do amigo
    }

    // Métodos Controllers para interação com o banco de dados
    // Retorna o maior ID dos amigos armazenados no banco de dados
    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();  // Chama o método pegaMaiorID() do DAO para obter o maior ID
    }

    // Retorna uma lista de amigos
    public ArrayList<Amigo> pegarLista() {
        return dao.getMinhaLista();  // Chama o método getMinhaLista() do DAO para obter todos os amigos
    }

    // Insere um novo amigo no banco de dados
    public boolean insertAmigo(String nome, String telefone, String score) throws SQLException {
        int id = this.maiorID() + 1;  // Obtém o maior ID e incrementa 1 para criar um novo ID
        Amigo objeto = new Amigo(id, nome, telefone, score);  // Cria um objeto Amigo com os dados fornecidos
        dao.inserirAmigoBD(objeto);  // Chama o método inserirAmigoBD() do DAO para salvar o amigo no banco
        return true;  // Retorna true após a inserção bem-sucedida
    }

    // Atualiza as informações de um amigo no banco de dados
    public boolean updateAmigoBD(String nome, int id, String telefone, String score) throws SQLException {
        Amigo objeto = new Amigo(id, nome, telefone, score);  // Cria um objeto Amigo com os dados atualizados
        dao.atualizarAmigo(objeto);  // Chama o método atualizarAmigo() do DAO para atualizar o amigo no banco
        return true;  // Retorna true após a atualização bem-sucedida
    }

    // Carrega um amigo do banco de dados usando seu ID
    public Amigo pegaAmigo(int id) {
        return dao.carregaAmigo(id);  // Chama o método carregaAmigo() do DAO para buscar o amigo no banco
    }
}
