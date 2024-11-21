package dao;

import model.Emprestimo;
import model.SituacaoEmprestimo;
import model.Ferramenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class EmprestimoDAO {

    private static final EmprestimoDAO instance = new EmprestimoDAO();

    private EmprestimoDAO() {
    }

    public static EmprestimoDAO getInstance() {
        return instance;
    }

    public boolean inserirEmprestimo(Emprestimo emprestimo) {
        String sqlEmprestimo = "INSERT INTO emprestimos (id_amigo, data_emprestimo, data_devolucao, status) VALUES (?, ?, ?, ?)";
        String sqlFerramentasEmprestadas = "INSERT INTO ferramentas_emprestadas (id_emprestimo, id_ferramenta) VALUES (?, ?)";
        String sqlAtualizaFerramenta = "UPDATE ferramentas SET status = ? WHERE id_ferramenta = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psEmprestimo = connection.prepareStatement(sqlEmprestimo, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psFerramentasEmprestadas = connection.prepareStatement(sqlFerramentasEmprestadas);
             PreparedStatement psAtualizaFerramenta = connection.prepareStatement(sqlAtualizaFerramenta)) {

            connection.setAutoCommit(false);

            psEmprestimo.setInt(1, emprestimo.getIdAmigo());
            psEmprestimo.setDate(2, emprestimo.getDataInicial());
            psEmprestimo.setDate(3, emprestimo.getDataDevolucao());
            psEmprestimo.setInt(4, SituacaoEmprestimo.ABERTO.ordinal() + 1);
            psEmprestimo.executeUpdate();

            ResultSet generatedKeys = psEmprestimo.getGeneratedKeys();
            if (generatedKeys.next()) {
                int emprestimoId = generatedKeys.getInt(1);
                for (Ferramenta ferramenta : emprestimo.getFerramentasSelecionadas()) {
                    psFerramentasEmprestadas.setInt(1, emprestimoId);
                    psFerramentasEmprestadas.setInt(2, ferramenta.getId());
                    psFerramentasEmprestadas.addBatch();

                    psAtualizaFerramenta.setBoolean(1, false);
                    psAtualizaFerramenta.setInt(2, ferramenta.getId());
                    psAtualizaFerramenta.addBatch();
                }
                psFerramentasEmprestadas.executeBatch();
                psAtualizaFerramenta.executeBatch();
            } else {
                throw new SQLException("Erro ao obter o ID do emprestimo.");
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection connection = ConexaoDB.getConnection()) {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        }
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        String sqlUpdate = "UPDATE emprestimos SET id_amigo = ?, data_emprestimo = ?, data_devolucao = ?, status = ? WHERE id_emprestimo = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlUpdate)) {

            ps.setInt(1, emprestimo.getIdAmigo());
            ps.setDate(2, emprestimo.getDataInicial());
            ps.setDate(3, emprestimo.getDataDevolucao());
            ps.setInt(4, emprestimo.getStatus().getCodigo());
            ps.setInt(5, emprestimo.getIdEmprestimo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removerEmprestimo(int idEmprestimo) {
        String sqlDeleteEmprestimo = "DELETE FROM emprestimos WHERE id_emprestimo = ?";
        String sqlDeleteFerramentas = "DELETE FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psDeleteFerramentas = connection.prepareStatement(sqlDeleteFerramentas);
             PreparedStatement psDeleteEmprestimo = connection.prepareStatement(sqlDeleteEmprestimo)) {

            connection.setAutoCommit(false);

            psDeleteFerramentas.setInt(1, idEmprestimo);
            psDeleteFerramentas.executeUpdate();

            psDeleteEmprestimo.setInt(1, idEmprestimo);
            int linhasAfetadas = psDeleteEmprestimo.executeUpdate();

            if (linhasAfetadas > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        String sqlSelectAll = "SELECT * FROM emprestimos";
        List<Emprestimo> emprestimos = new ArrayList<>();
        try (Connection connection = ConexaoDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlSelectAll)) {

            while (resultSet.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(resultSet.getInt("id_emprestimo"));
                emprestimo.setIdAmigo(resultSet.getInt("id_amigo"));
                emprestimo.setDataInicial(resultSet.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(resultSet.getDate("data_devolucao"));
                emprestimo.setStatus(SituacaoEmprestimo.values()[resultSet.getInt("status") - 1]);
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        String sqlEmprestimo = "SELECT * FROM emprestimos WHERE id_emprestimo = ?";
        String sqlFerramentas = "SELECT f.* FROM ferramentas_emprestadas fe INNER JOIN ferramentas f ON fe.id_ferramenta = f.id_ferramenta WHERE fe.id_emprestimo = ?";
        Emprestimo emprestimo = null;

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement psEmprestimo = connection.prepareStatement(sqlEmprestimo);
             PreparedStatement psFerramentas = connection.prepareStatement(sqlFerramentas)) {

            psEmprestimo.setInt(1, id);
            ResultSet rsEmprestimo = psEmprestimo.executeQuery();

            if (rsEmprestimo.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(rsEmprestimo.getInt("id_emprestimo"));
                emprestimo.setIdAmigo(rsEmprestimo.getInt("id_amigo"));
                emprestimo.setDataInicial(rsEmprestimo.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rsEmprestimo.getDate("data_devolucao"));
                emprestimo.setStatus(SituacaoEmprestimo.values()[rsEmprestimo.getInt("status") - 1]);

                psFerramentas.setInt(1, id);
                ResultSet rsFerramentas = psFerramentas.executeQuery();
                List<Ferramenta> ferramentas = new ArrayList<>();
                while (rsFerramentas.next()) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId(rsFerramentas.getInt("id_ferramenta"));
                    ferramenta.setNome(rsFerramentas.getString("nome"));
                    ferramenta.setMarca(rsFerramentas.getString("marca"));
                    ferramenta.setCusto(rsFerramentas.getDouble("custo_aquisicao"));
                    ferramenta.setStatus(rsFerramentas.getInt("status"));
                    ferramentas.add(ferramenta);
                }
                emprestimo.setFerramentasSelecionadas(ferramentas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimo;
    }

    private void executarBatch(Connection connection, String sql, List<Ferramenta> ferramentas, boolean status) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Ferramenta ferramenta : ferramentas) {
                ps.setBoolean(1, status);
                ps.setInt(2, ferramenta.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}
