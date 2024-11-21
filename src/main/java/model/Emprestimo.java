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
    private Integer idEmprestimo;
    private Integer idAmigo;
    private Date dataInicial;
    private Date dataDevolucao;
    private SituacaoEmprestimo status;
    private Amigo amigo;
    private List<Ferramenta> ferramentasSelecionadas;
    private final EmprestimoDAO dao;

    // Construtor padrão
    public Emprestimo() {
        this.ferramentasSelecionadas = new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    // Construtor com parâmetros
    public Emprestimo(Integer idAmigo, Date dataInicial, Date dataDevolucao, SituacaoEmprestimo status, List<Ferramenta> ferramentasSelecionadas) {
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    public Emprestimo(Integer idEmprestimo, Integer idAmigo, Date dataInicial, Date dataDevolucao, SituacaoEmprestimo status, Amigo amigo, List<Ferramenta> ferramentasSelecionadas) {
        this.idEmprestimo = idEmprestimo;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.amigo = amigo;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = EmprestimoDAO.getInstance();
    }

    // Getters and setters
    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
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

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
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

    public boolean inserirEmprestimo(int idAmigo, List<Ferramenta> ferramentasSelecionadas, Date dataInicial, Date dataDevolucao) {
        Emprestimo objeto = new Emprestimo(idAmigo, dataInicial, dataDevolucao, SituacaoEmprestimo.ABERTO, ferramentasSelecionadas);
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

    public double calcularTotalEmprestimo() {
        double totalEmprestimo = 0.0;
        for (Ferramenta ferramenta : ferramentasSelecionadas) {
            totalEmprestimo += ferramenta.getCusto();
        }
        return totalEmprestimo;
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
            if (emprestimo.getIdAmigo().equals(idAmigo)) {
                sucesso &= removerEmprestimo(emprestimo.getIdEmprestimo());
            }
        }
        return sucesso;
    }
}
