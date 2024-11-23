package model;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class Emprestimo {
    private int idEmprestimo;
    private int idAmigo;
    private double custoTotal;
    private Date dataInicial;
    private Date dataDevolucao;
    private SituacaoEmprestimo status;
    private List<Ferramenta> ferramentasSelecionadas;
    private EmprestimoDAO dao;

    // Construtor padrão
    public Emprestimo() {
        this.ferramentasSelecionadas = new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    // Construtor com parâmetros
    public Emprestimo(int idAmigo, double custoTotal, Date dataInicial, Date dataDevolucao, SituacaoEmprestimo status, List<Ferramenta> ferramentasSelecionadas) {
        this.idAmigo = idAmigo;
        this.custoTotal = custoTotal;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

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
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }
    
    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public SituacaoEmprestimo getStatus() {
        return status;
    }

    public void setStatus(SituacaoEmprestimo status) {
        this.status = status;
    }

    public List<Ferramenta> getFerramentasSelecionadas() {
        return ferramentasSelecionadas;
    }

    public void setFerramentasSelecionadas(List<Ferramenta> ferramentasSelecionadas) {
        this.ferramentasSelecionadas = ferramentasSelecionadas;
    }

    // Adiciona uma ferramenta à lista de ferramentas selecionadas
    public void adicionarFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas == null) {
            ferramentasSelecionadas = new ArrayList<>();
        }
        ferramentasSelecionadas.add(ferramenta);
    }

    // Remove uma ferramenta da lista de ferramentas selecionadas
    public void removerFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas != null) {
            ferramentasSelecionadas.remove(ferramenta);
        }
    }

    /* Métodos */
    public List<Emprestimo> listarEmprestimos() {
        return dao.listarEmprestimos();
    }

public boolean inserirEmprestimo(int idAmigo, double custoTotal, List<Ferramenta> ferramentasSelecionadas, Date dataInicial, Date dataDevolucao) {
    // Cria o objeto de Emprestimo
    Emprestimo objeto = new Emprestimo(idAmigo, custoTotal, dataInicial, dataDevolucao, SituacaoEmprestimo.ABERTO, ferramentasSelecionadas);

    // Chama o DAO para inserir o empréstimo e as ferramentas
    return dao.inserirEmprestimo(objeto);
}


    public int qtdFerramentasEmprestimo(int id) {
        Emprestimo emprestimo = dao.buscarEmprestimoPorId(id);
        return emprestimo != null ? emprestimo.getFerramentasSelecionadas().size() : 0;
    }

    public long calcularTempoRestante(Date dataInicial, Date dataDevolucao) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dtInicialStr = sdf.format(dataInicial);
        String dtDevolucaoStr = sdf.format(dataDevolucao);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicialLD = LocalDate.parse(dtInicialStr, formatter);
        LocalDate dataDevolucaoLD = LocalDate.parse(dtDevolucaoStr, formatter);
        return ChronoUnit.DAYS.between(LocalDate.now(), dataDevolucaoLD);
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        return dao.buscarEmprestimoPorId(id);
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        return dao.atualizarEmprestimo(emprestimo);
    }

    public List<Ferramenta> listarFerramentasEmprestimo(int idEmprestimo) {
        Emprestimo emprestimo = dao.buscarEmprestimoPorId(idEmprestimo);
        return emprestimo != null ? emprestimo.getFerramentasSelecionadas() : new ArrayList<>();
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        List<Ferramenta> ferramentas = listarFerramentasEmprestimo(this.idEmprestimo);
        for (Ferramenta ferramenta : ferramentas) {
            valorTotal += ferramenta.getCusto();
        }
        return valorTotal;
    }

    public boolean removerEmprestimo(int id) {
        return dao.removerEmprestimo(id);
    }

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
}
