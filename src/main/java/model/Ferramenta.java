package model;

import dao.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe que representa uma ferramenta no sistema de gerenciamento de empréstimos.
 * 
 * Responsável por encapsular os atributos de uma ferramenta e fornecer métodos
 * para manipulação e persistência dos dados relacionados no banco de dados.
 */
public class Ferramenta {

    // Atributos da ferramenta
    private int id;             // ID único da ferramenta
    private String nome;        // Nome da ferramenta
    private String marca;       // Marca da ferramenta
    private double custo;       // Custo associado à ferramenta
    private int status;         // Status da ferramenta (1: Disponível, 2: Indisponível, etc.)
    private final FerramentaDAO dao;  // Objeto de acesso ao banco de dados (DAO) para a tabela de ferramentas

    /**
     * Construtor padrão da classe Ferramenta.
     * Inicializa o objeto FerramentaDAO para interagir com o banco de dados.
     */
    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    /**
     * Construtor para inicializar uma ferramenta sem ID.
     * 
     * @param nome   Nome da ferramenta.
     * @param marca  Marca da ferramenta.
     * @param custo  Custo associado à ferramenta.
     * @param status Status da ferramenta.
     */
    public Ferramenta(String nome, String marca, double custo, int status) {
        this.dao = new FerramentaDAO();
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    /**
     * Construtor para inicializar uma ferramenta com todos os atributos.
     * 
     * @param id     ID único da ferramenta.
     * @param nome   Nome da ferramenta.
     * @param marca  Marca da ferramenta.
     * @param custo  Custo associado à ferramenta.
     * @param status Status da ferramenta.
     */
    public Ferramenta(int id, String nome, String marca, double custo, int status) {
        this.dao = new FerramentaDAO();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
    }

    // Métodos de acesso (getters e setters)
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

    // Métodos de interação com o banco de dados

    /**
     * Obtém o maior ID registrado no banco de dados para a tabela de ferramentas.
     * 
     * @return O maior ID encontrado no banco de dados.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public int maiorID() throws SQLException {
        return dao.pegaMaiorID();
    }

    /**
     * Recupera uma lista de todas as ferramentas registradas no banco de dados.
     * 
     * @return Uma lista de objetos Ferramenta.
     */
    public ArrayList<Ferramenta> pegarLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova ferramenta no banco de dados.
     * 
     * @param nome   Nome da ferramenta.
     * @param marca  Marca da ferramenta.
     * @param custo  Custo associado à ferramenta.
     * @param status Status da ferramenta.
     * @return True se a inserção foi bem-sucedida.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean insertFerramenta(String nome, String marca, double custo, int status) throws SQLException {
        int id = this.maiorID() + 1; // Gera o próximo ID
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
        dao.inserirFerramentaBD(objeto);
        return true;
    }

    /**
     * Atualiza os dados de uma ferramenta no banco de dados.
     * 
     * @param id     ID único da ferramenta.
     * @param nome   Nome atualizado da ferramenta.
     * @param marca  Marca atualizada da ferramenta.
     * @param custo  Custo atualizado da ferramenta.
     * @param status Status atualizado da ferramenta.
     * @return True se a atualização foi bem-sucedida.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean updateFerramentaBD(int id, String nome, String marca, double custo, int status) throws SQLException {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
        dao.atualizarFerramenta(objeto);
        return true;
    }

    /**
     * Recupera uma ferramenta específica com base no ID fornecido.
     * 
     * @param id O ID da ferramenta desejada.
     * @return Um objeto Ferramenta correspondente ao ID, ou null se não encontrado.
     */
    public Ferramenta pegaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }
}
