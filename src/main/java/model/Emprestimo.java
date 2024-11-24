package model;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * A classe Emprestimo representa o empréstimo de ferramentas a um amigo,
 * contendo as informações do empréstimo, como data de início, data de devolução,
 * custo total, status e ferramentas selecionadas.
 */
public class Emprestimo {

    /**
     * ID do empréstimo.
     */
    private int idEmprestimo;

    /**
     * ID do amigo que realizou o empréstimo.
     */
    private int idAmigo;

    /**
     * Custo total do empréstimo.
     */
    private double custoTotal;

    /**
     * Data de início do empréstimo.
     */
    private Date dataInicial;

    /**
     * Data de devolução do empréstimo.
     */
    private Date dataDevolucao;

    /**
     * Status atual do empréstimo.
     */
    private SituacaoEmprestimo status;

    /**
     * Lista de ferramentas que foram emprestadas.
     */
    private List<Ferramenta> ferramentasSelecionadas;

    /**
     * Objeto DAO para manipulação de dados no banco de dados.
     */
    private EmprestimoDAO dao;

    /**
     * Construtor padrão da classe Emprestimo.
     * Inicializa a lista de ferramentas e o objeto DAO.
     */
    public Emprestimo() {
        this.ferramentasSelecionadas = new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    /**
     * Construtor parametrizado da classe Emprestimo.
     * Inicializa os atributos com os valores fornecidos.
     * 
     * @param idAmigo ID do amigo que realiza o empréstimo.
     * @param custoTotal Custo total do empréstimo.
     * @param dataInicial Data de início do empréstimo.
     * @param dataDevolucao Data de devolução do empréstimo.
     * @param status Status atual do empréstimo.
     * @param ferramentasSelecionadas Lista de ferramentas emprestadas.
     */
    public Emprestimo(int idAmigo, double custoTotal, Date dataInicial, Date dataDevolucao, SituacaoEmprestimo status, List<Ferramenta> ferramentasSelecionadas) {
        this.idAmigo = idAmigo;
        this.custoTotal = custoTotal;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    /**
     * Construtor parametrizado da classe Emprestimo, incluindo o ID do empréstimo.
     * 
     * @param idEmprestimo ID do empréstimo.
     * @param idAmigo ID do amigo que realiza o empréstimo.
     * @param custoTotal Custo total do empréstimo.
     * @param dataInicial Data de início do empréstimo.
     * @param dataDevolucao Data de devolução do empréstimo.
     * @param status Status atual do empréstimo.
     * @param ferramentasSelecionadas Lista de ferramentas emprestadas.
     */
    public Emprestimo(int idEmprestimo, int idAmigo, double custoTotal, Date dataInicial, Date dataDevolucao, SituacaoEmprestimo status, List<Ferramenta> ferramentasSelecionadas) {
        this.idEmprestimo = idEmprestimo;
        this.idAmigo = idAmigo;
        this.custoTotal = custoTotal;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    // Getters and setters

    /**
     * Retorna o ID do empréstimo.
     */
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * Define o ID do empréstimo.
     */
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /**
     * Retorna o ID do amigo que realizou o empréstimo.
     */
    public int getIdAmigo() {
        return idAmigo;
    }

    /**
     * Define o ID do amigo que realizou o empréstimo.
     */
    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    /**
     * Retorna o custo total do empréstimo.
     */
    public double getCustoTotal() {
        return custoTotal;
    }

    /**
     * Define o custo total do empréstimo.
     */
    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    /**
     * Retorna a data inicial do empréstimo.
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * Define a data inicial do empréstimo.
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * Retorna a data de devolução do empréstimo.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data de devolução do empréstimo.
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Retorna o status atual do empréstimo.
     */
    public SituacaoEmprestimo getStatus() {
        return status;
    }

    /**
     * Define o status atual do empréstimo.
     */
    public void setStatus(SituacaoEmprestimo status) {
        this.status = status;
    }

    /**
     * Retorna a lista de ferramentas selecionadas para o empréstimo.
     */
    public List<Ferramenta> getFerramentasSelecionadas() {
        return ferramentasSelecionadas;
    }

    /**
     * Define a lista de ferramentas selecionadas para o empréstimo.
     */
    public void setFerramentasSelecionadas(List<Ferramenta> ferramentasSelecionadas) {
        this.ferramentasSelecionadas = ferramentasSelecionadas;
    }

    // Métodos auxiliares

    /**
     * Adiciona uma ferramenta à lista de ferramentas selecionadas.
     * 
     * @param ferramenta A ferramenta a ser adicionada.
     */
    public void adicionarFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas == null) {
            ferramentasSelecionadas = new ArrayList<>();
        }
        ferramentasSelecionadas.add(ferramenta);
    }

    /**
     * Remove uma ferramenta da lista de ferramentas selecionadas.
     * 
     * @param ferramenta A ferramenta a ser removida.
     */
    public void removerFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas != null) {
            ferramentasSelecionadas.remove(ferramenta);
        }
    }

    /**
     * Lista todos os empréstimos registrados no sistema.
     * 
     * @return Lista de empréstimos.
     */
    public List<Emprestimo> listarEmprestimos() {
        return dao.listarEmprestimos();
    }

    /**
     * Insere um novo empréstimo no sistema.
     * 
     * @param idAmigo ID do amigo que realiza o empréstimo.
     * @param custoTotal Custo total do empréstimo.
     * @param ferramentasSelecionadas Lista de ferramentas emprestadas.
     * @param dataInicial Data de início do empréstimo.
     * @param dataDevolucao Data de devolução do empréstimo.
     * @return true se o empréstimo foi inserido com sucesso, false caso contrário.
     */
    public boolean inserirEmprestimo(int idAmigo, double custoTotal, List<Ferramenta> ferramentasSelecionadas, Date dataInicial, Date dataDevolucao) {
        Emprestimo objeto = new Emprestimo(idAmigo, custoTotal, dataInicial, dataDevolucao, SituacaoEmprestimo.ABERTO, ferramentasSelecionadas);
        return dao.inserirEmprestimo(objeto);
    }

    /**
     * Retorna a quantidade de ferramentas emprestadas em um empréstimo específico.
     * 
     * @param id ID do empréstimo.
     * @return Quantidade de ferramentas.
     */
    public int qtdFerramentasEmprestimo(int id) {
        Emprestimo emprestimo = dao.buscarEmprestimoPorId(id);
        return emprestimo != null ? emprestimo.getFerramentasSelecionadas().size() : 0;
    }

    /**
     * Calcula o tempo restante para a devolução de um empréstimo.
     * 
     * @param dataInicial Data de início do empréstimo.
     * @param dataDevolucao Data de devolução do empréstimo.
     * @return O tempo restante em dias.
     */
    public long calcularTempoRestante(Date dataInicial, Date dataDevolucao) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dtInicialStr = sdf.format(dataInicial);
        String dtDevolucaoStr = sdf.format(dataDevolucao);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicialLD = LocalDate.parse(dtInicialStr, formatter);
        LocalDate dataDevolucaoLD = LocalDate.parse(dtDevolucaoStr, formatter);
        return ChronoUnit.DAYS.between(LocalDate.now(), dataDevolucaoLD);
    }

    /**
     * Busca um empréstimo pelo seu ID.
     * 
     * @param id ID do empréstimo.
     * @return Objeto Emprestimo correspondente ao ID ou null se não encontrado.
     */
    public Emprestimo buscarEmprestimoPorId(int id) {
        return dao.buscarEmprestimoPorId(id);
    }

    /**
     * Atualiza as informações de um empréstimo no sistema.
     * 
     * @param emprestimo Objeto Emprestimo com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        return dao.atualizarEmprestimo(emprestimo);
    }

    /**
     * Lista todas as ferramentas associadas a um empréstimo específico.
     * 
     * @param idEmprestimo ID do empréstimo.
     * @return Lista de ferramentas emprestadas.
     */
    public List<Ferramenta> listarFerramentasEmprestimo(int idEmprestimo) {
        Emprestimo emprestimo = dao.buscarEmprestimoPorId(idEmprestimo);
        return emprestimo != null ? emprestimo.getFerramentasSelecionadas() : new ArrayList<>();
    }

    /**
     * Calcula o valor total do empréstimo, somando o custo das ferramentas emprestadas.
     * 
     * @return Valor total do empréstimo.
     */
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        List<Ferramenta> ferramentas = listarFerramentasEmprestimo(this.idEmprestimo);
        for (Ferramenta ferramenta : ferramentas) {
            valorTotal += ferramenta.getCusto();
        }
        return valorTotal;
    }

    /**
     * Remove um empréstimo pelo ID.
     * 
     * @param id ID do empréstimo.
     * @return true se o empréstimo foi removido com sucesso, false caso contrário.
     */
    public boolean removerEmprestimo(int id) {
        return dao.removerEmprestimo(id);
    }

    /**
     * Remove todos os empréstimos associados a um amigo específico.
     * 
     * @param idAmigo ID do amigo.
     * @return true se todos os empréstimos foram removidos com sucesso, false caso contrário.
     */
    public boolean removerEmprestimosPorAmigo(int idAmigo) {
        List<Emprestimo> emprestimos = listarEmprestimos();
        boolean sucesso = true;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getIdAmigo() == idAmigo) {
                sucesso &= removerEmprestimo(emprestimo.getIdEmprestimo());
            }
        }
        return sucesso;
    }

    /**
     * Calcula o tempo restante até a devolução de um empréstimo em dias.
     * 
     * @param dataInicial Data inicial do empréstimo.
     * @param dataDevolucao Data final do empréstimo.
     * @return O número de dias restantes.
     */
    public long tempoRestante(LocalDate dataInicial, LocalDate dataDevolucao) {
        if (dataInicial == null || dataDevolucao == null) {
            throw new IllegalArgumentException("Datas não podem ser nulas.");
        }
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao)) {
            return 0; // Já passou da data de devolução
        }
        return ChronoUnit.DAYS.between(hoje, dataDevolucao);
    }
}
