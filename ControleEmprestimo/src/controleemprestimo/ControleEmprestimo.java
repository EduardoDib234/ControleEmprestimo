import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Ferramenta {
    private String nome;
    private String marca;
    private double custoAquisicao;

    public Ferramenta(String nome, String marca, double custoAquisicao) {
        this.nome = nome;
        this.marca = marca;
        this.custoAquisicao = custoAquisicao;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoAquisicao() {
        return custoAquisicao;
    }

    @Override
    public String toString() {
        return nome + " (Marca: " + marca + ", Custo: R$ " + custoAquisicao + ")";
    }
}

class Amigo {
    private String nome;
    private String telefone;

    public Amigo(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " (Telefone: " + telefone + ")";
    }
}

class Emprestimo {
    private Amigo amigo;
    private List<Ferramenta> ferramentas;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Amigo amigo, List<Ferramenta> ferramentas, Date dataEmprestimo) {
        this.amigo = amigo;
        this.ferramentas = ferramentas;
        this.dataEmprestimo = dataEmprestimo;
    }

    public void devolve(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtivo() {
        return dataDevolucao == null;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public double custoTotal() {
        return ferramentas.stream().mapToDouble(Ferramenta::getCustoAquisicao).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Emprestimo: ").append(amigo.getNome()).append(", Ferramentas: ");
        for (Ferramenta f : ferramentas) {
            sb.append(f.getNome()).append(", ");
        }
        sb.append("Data do Empréstimo: ").append(dataEmprestimo);
        if (dataDevolucao != null) {
            sb.append(", Data de Devolução: ").append(dataDevolucao);
        } else {
            sb.append(", Empréstimo Ativo");
        }
        return sb.toString();
    }
}

class GerenciadorDeEmprestimos {
    private List<Ferramenta> ferramentas;
    private List<Amigo> amigos;
    private List<Emprestimo> emprestimos;

    public GerenciadorDeEmprestimos() {
        ferramentas = new ArrayList<>();
        amigos = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void adicionarFerramenta(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
    }

    public void adicionarAmigo(Amigo amigo) {
        amigos.add(amigo);
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void relatorioFerramentas() {
        System.out.println("Relatório de Ferramentas:");
        for (Ferramenta f : ferramentas) {
            System.out.println("- " + f);
        }
    }

    public void relatorioEmprestimosAtivos() {
        System.out.println("Empréstimos Ativos:");
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo()) {
                System.out.println("- " + e);
            }
        }
    }

    public void relatorioEmprestimosRealizados() {
        System.out.println("Todos os Empréstimos Realizados:");
        for (Emprestimo e : emprestimos) {
            System.out.println("- " + e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorDeEmprestimos gerenciador = new GerenciadorDeEmprestimos();
        Scanner scanner = new Scanner(System.in);

        // Adicionando ferramentas
        gerenciador.adicionarFerramenta(new Ferramenta("Furadeira", "Marca A", 200.0));
        gerenciador.adicionarFerramenta(new Ferramenta("Serra", "Marca B", 150.0));
        gerenciador.adicionarFerramenta(new Ferramenta("Chave de Fenda", "Marca C", 30.0));

        // Adicionando amigos
        gerenciador.adicionarAmigo(new Amigo("João", "1234-5678"));
        gerenciador.adicionarAmigo(new Amigo("Maria", "8765-4321"));

        // Menu de opções
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Relatório de Ferramentas");
            System.out.println("3. Relatório de Empréstimos Ativos");
            System.out.println("4. Relatório de Empréstimos Realizados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do amigo: ");
                    String nomeAmigo = scanner.nextLine();
                    Amigo amigo = gerenciador.amigos.stream().filter(a -> a.getNome().equals(nomeAmigo)).findFirst().orElse(null);
                    if (amigo == null) {
                        System.out.println("Amigo não encontrado!");
                        break;
                    }

                    List<Ferramenta> ferramentasEmprestadas = new ArrayList<>();
                    System.out.print("Quantas ferramentas deseja emprestar? ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    for (int i = 0; i < quantidade; i++) {
                        System.out.print("Nome da ferramenta " + (i + 1) + ": ");
                        String nomeFerramenta = scanner.nextLine();
                        Ferramenta ferramenta = gerenciador.ferramentas.stream().filter(f -> f.getNome().equals(nomeFerramenta)).findFirst().orElse(null);
                        if (ferramenta != null) {
                            ferramentasEmprestadas.add(ferramenta);
                        } else {
                            System.out.println("Ferramenta não encontrada!");
                        }
                    }

                    Emprestimo emprestimo = new Emprestimo(amigo, ferramentasEmprestadas, new Date());
                    gerenciador.registrarEmprestimo(emprestimo);
                    System.out.println("Empréstimo registrado com sucesso!");
                    break;

                case 2:
                    gerenciador.relatorioFerramentas();
                    break;

                case 3:
                    gerenciador.relatorioEmprestimosAtivos();
                    break;

                case 4:
                    gerenciador.relatorioEmprestimosRealizados();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
