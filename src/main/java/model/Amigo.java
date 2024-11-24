package model;

import dao.AmigoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe que representa um Amigo no sistema.
 * Esta classe contém os atributos de um amigo, bem como os métodos para interagir com o banco de dados
 * por meio da classe `AmigoDAO`. 
 */
public class Amigo {

    private int id;  // Atributo para armazenar o ID único do amigo
    private String nome;  // Atributo para armazenar o nome do amigo
    private String telefone;  // Atributo para armazenar o telefone do amigo
    private final AmigoDAO dao;  // Instância da classe AmigoDAO, responsável por interagir com o banco de dados
    private String score;  // Atributo para armazenar o "score" (pontuação ou categoria) do amigo

    /**
     * Construtor padrão que inicializa a instância da classe AmigoDAO.
     * Atributos 'id', 'nome', 'telefone' e 'score' não são inicializados.
     */
    public Amigo() {
        this.dao = new AmigoDAO();
    }

    /**
     * Construtor que inicializa um amigo com nome, telefone e score.
     * 
     * @param nome Nome do amigo.
     * @param telefone Telefone do amigo.
     * @param score Score ou categoria do amigo.
     */
    public Amigo(String nome, String telefone, String score) {
        this.dao = new AmigoDAO();  // Inicializa a instância de AmigoDAO
        this.nome = nome;
        this.telefone = telefone;
        this.score = score;
    }

    /**
     * Construtor que inicializa um amigo com todos os atributos: id, nome, telefone e score.
     * 
     * @param id ID único do amigo.
     * @param nome Nome do amigo.
     * @param telefone Telefone do amigo.
     * @param score Score ou categoria do amigo.
     */
    public Amigo(int id, String nome, String telefone, String score) {
        this.dao = new AmigoDAO();  // Inicializa a instância de AmigoDAO
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.score = score;
    }

    // Métodos getters (acessores) para obter os valores dos atributos

    /**
     * Obtém o ID do amigo.
     * 
     * @return O ID do amigo.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do amigo.
     * 
     * @return O nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o telefone do amigo.
     * 
     * @return O telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Obtém o score do amigo.
     * 
     * @return O score do amigo.
     */
    public String getScore() {
        return score;
    }

    // Métodos setters (modificadores) para modificar os valores dos atributos

    /**
     * Define o ID do amigo.
     * 
     * @param id O novo ID do amigo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Define o nome do amigo.
     * 
     * @param nome O novo nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o telefone do amigo.
     * 
     * @param telefone O novo telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Define o score do amigo.
     * 
     * @param score O novo score do amigo.
     */
    public void setScore(String score) {
        this.score = score;
    }

    // Métodos Controllers para interação com o banco de dados

    /**
     * Obtém o maior ID dos amigos armazenados no banco de dados.
     * 
     * @return O maior ID dos amigos no banco de dados.
     * @throws SQLException Se ocorrer um erro de SQL durante a consulta.
     */
    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();  // Chama o método pegaMaiorID() do DAO para obter o maior ID
    }

    /**
     * Retorna uma lista com todos os amigos armazenados no banco de dados.
     * 
     * @return Lista de objetos `Amigo` representando todos os amigos no banco de dados.
     */
    public ArrayList<Amigo> pegarLista() {
        return dao.getMinhaLista();  // Chama o método getMinhaLista() do DAO para obter todos os amigos
    }

    /**
     * Insere um novo amigo no banco de dados.
     * 
     * @param nome Nome do amigo.
     * @param telefone Telefone do amigo.
     * @param score Score ou categoria do amigo.
     * @return true se a inserção foi bem-sucedida, false caso contrário.
     * @throws SQLException Se ocorrer um erro de SQL durante a inserção.
     */
    public boolean insertAmigo(String nome, String telefone, String score) throws SQLException {
        int id = this.maiorID() + 1;  // Obtém o maior ID e incrementa 1 para criar um novo ID
        Amigo objeto = new Amigo(id, nome, telefone, score);  // Cria um objeto Amigo com os dados fornecidos
        dao.inserirAmigoBD(objeto);  // Chama o método inserirAmigoBD() do DAO para salvar o amigo no banco
        return true;  // Retorna true após a inserção bem-sucedida
    }

    /**
     * Atualiza as informações de um amigo no banco de dados.
     * 
     * @param nome Nome atualizado do amigo.
     * @param id ID do amigo a ser atualizado.
     * @param telefone Telefone atualizado do amigo.
     * @param score Score atualizado do amigo.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     * @throws SQLException Se ocorrer um erro de SQL durante a atualização.
     */
    public boolean updateAmigoBD(String nome, int id, String telefone, String score) throws SQLException {
        Amigo objeto = new Amigo(id, nome, telefone, score);  // Cria um objeto Amigo com os dados atualizados
        dao.atualizarAmigo(objeto);  // Chama o método atualizarAmigo() do DAO para atualizar o amigo no banco
        return true;  // Retorna true após a atualização bem-sucedida
    }

    /**
     * Carrega um amigo do banco de dados utilizando seu ID.
     * 
     * @param id ID do amigo a ser carregado.
     * @return O objeto `Amigo` correspondente ao ID fornecido.
     */
    public Amigo pegaAmigo(int id) {
        return dao.carregaAmigo(id);  // Chama o método carregaAmigo() do DAO para buscar o amigo no banco
    }
}
