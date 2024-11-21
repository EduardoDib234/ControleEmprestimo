package model;

public enum SituacaoEmprestimo {
    ABERTO(1, "Em aberto"),
    INATIVO(2, "Inativo"),
    ATRASADO(3, "Atrasado");

    private final int codigo;
    private final String descricao;

    SituacaoEmprestimo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoEmprestimo porCodigo(int codigo) {
        for (SituacaoEmprestimo situacao : SituacaoEmprestimo.values()) {
            if (situacao.getCodigo() == codigo) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("Código de situação inválido: " + codigo);
    }

    @Override
    public String toString() {
        return descricao;
    }
}