package dao;

import java.util.ArrayList;
import model.Amigo;
import model.Emprestimo;
import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;

/**
 * Classe responsável por gerar relatórios baseados nas informações do sistema,
 * como os empréstimos realizados, amigos que nunca devolveram ferramentas e o custo total das ferramentas.
 * Utiliza instâncias de outras classes DAO (AmigoDAO, EmprestimoDAO, FerramentaDAO) para acessar os dados no banco de dados.
 */
public class RelatorioDAO {
    private AmigoDAO amigoDAO;  // Instância do DAO de amigos para interagir com os dados de amigos
    private EmprestimoDAO emprestimoDAO;  // Instância do DAO de empréstimos para interagir com os dados de empréstimos
    private FerramentaDAO ferramentaDAO;  // Instância do DAO de ferramentas para interagir com os dados de ferramentas
    
    /**
     * Construtor que inicializa as instâncias dos DAOs necessários para o RelatorioDAO.
     */
    public RelatorioDAO(){
        this.amigoDAO = new AmigoDAO();
        this.ferramentaDAO = new FerramentaDAO();
        this.emprestimoDAO = EmprestimoDAO.getInstance();  // Obtém a instância única de EmprestimoDAO
    }
    
    /**
     * Busca os amigos que mais realizaram empréstimos, retornando uma lista de arrays de inteiros.
     * Cada elemento do array contém informações de amigos e a quantidade de empréstimos que realizaram.
     * 
     * @return Lista de arrays de inteiros, onde cada array contém informações sobre o amigo e a quantidade de empréstimos.
     */
    public ArrayList<int[]> buscaAmigosMaisEmprestimo(){
        return emprestimoDAO.buscaAmigosMaisEmprestimos();  // Chama o método do DAO para buscar os amigos com mais empréstimos
    }
    
    /**
     * Busca todos os amigos que nunca devolveram ferramentas emprestadas.
     * 
     * @return Lista de objetos `Amigo` que nunca devolveram as ferramentas emprestadas.
     */
    public ArrayList<Amigo> amigosNuncaDevolveram(){
        ArrayList<Amigo> amigos = new ArrayList<>();  // Lista para armazenar os amigos que nunca devolveram
        ArrayList<Integer> idAmigosNaoDevolveram = emprestimoDAO.buscaEmprestimoNãoDevolvidos();  // Obtém os IDs dos amigos que não devolveram as ferramentas
        
        // Itera sobre os IDs dos amigos que não devolveram e carrega os objetos `Amigo` correspondentes
        for(int i : idAmigosNaoDevolveram){
            amigos.add(amigoDAO.carregaAmigo(i));  // Carrega o amigo pelo seu ID
        }
        
        return amigos;  // Retorna a lista de amigos que nunca devolveram
    }
    
    /**
     * Calcula o custo total de todas as ferramentas no sistema.
     * 
     * @return O custo total de todas as ferramentas.
     */
    public double custoTotal(){
        return ferramentaDAO.custoTotal();  // Chama o método do DAO de ferramentas para calcular o custo total
    }
}