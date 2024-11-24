package view;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class FrmMenuListaEmprestimo extends javax.swing.JFrame {

    private final EmprestimoDAO emprestimoDAO = EmprestimoDAO.getInstance();
    private final FerramentaDAO ferramentaDAO = FerramentaDAO.getInstance();

    public FrmMenuListaEmprestimo() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela
        carregaTabela();
    }

    /**
     * Método responsável por carregar os dados de empréstimos na tabela.
     */
    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTemprestimo.getModel();
        modelo.setNumRows(0); // Limpa a tabela antes de preencher

        // Obtém a lista de empréstimos do DAO
        ArrayList<Emprestimo> minhalista = emprestimoDAO.listarEmprestimos();

        for (Emprestimo emprestimo : minhalista) {
            double valorTotal = emprestimo.calcularValorTotal();
            String situacaoEmprestimo;

            // Define o status textual com base no código do status
            switch (emprestimo.getStatus().getCodigo()) {
                case 1:
                    situacaoEmprestimo = "Em aberto";
                    break;
                case 2:
                    situacaoEmprestimo = "Finalizado";
                    break;
                case 3:
                    situacaoEmprestimo = "Atrasado";
                    break;
                default:
                    situacaoEmprestimo = "Desconhecido";
                    break;
            }

            // Cálculo do tempo restante
            long diasRestantes = emprestimo.tempoRestante(
                    emprestimo.getDataInicial().toLocalDate(),
                    emprestimo.getDataDevolucao().toLocalDate()
            );

            String nomeAmigo = "";
            try {
                // Tenta obter o nome do amigo
                nomeAmigo = emprestimoDAO.buscarNomeAmigoPorId(emprestimo.getIdAmigo());
            } catch (SQLException e) {
                // Caso ocorra um erro na consulta ao banco, exibe um erro no console
                e.printStackTrace(); // Exibe o stack trace do erro
                nomeAmigo = "Erro ao buscar nome"; // Mensagem padrão caso haja erro
            }

            // Adiciona os dados na tabela
            modelo.addRow(new Object[]{
                emprestimo.getIdEmprestimo(),
                nomeAmigo,
                emprestimo.qtdFerramentasEmprestimo(emprestimo.getIdEmprestimo()),
                emprestimo.getCustoTotal(),
                emprestimo.getDataInicial(),
                emprestimo.getDataDevolucao(),
                diasRestantes,
                situacaoEmprestimo
            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTemprestimo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("     Gerenciado de emprestimos");

        jTemprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "amigo", "quantidade ferramentas", "custo", "data_emprestimo", "data_devolução", "dias restantes", "status"
            }
        ));
        jTemprestimo.setToolTipText("");
        jTemprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTemprestimoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTemprestimo);

        jButton1.setText("Ferramentas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Amigos");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar emprestimo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Estender emprestimo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Devolver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmMenuListaAmigo objeto = new FrmMenuListaAmigo();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmMenuListaFerramenta objeto = new FrmMenuListaFerramenta();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmMenuCadastrarEmprestimo objeto = new FrmMenuCadastrarEmprestimo();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FrmMenuPrincipal objeto = new FrmMenuPrincipal();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// Pega o índice da linha selecionada na tabela
int selectedRow = this.jTemprestimo.getSelectedRow();

if (selectedRow != -1) { // Verifica se alguma linha foi selecionada
    // Obtenha o ID do empréstimo da linha selecionada (exemplo: coluna 0 contém o ID do empréstimo)
    int idEmprestimo = (Integer) this.jTemprestimo.getValueAt(selectedRow, 0);

    try {
        // Busca todas as ferramentas associadas ao ID do empréstimo
        ArrayList<Integer> ferramentasAssociadas = ferramentaDAO.buscarFerramentasPorEmprestimo(idEmprestimo);

        if (ferramentasAssociadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Este empréstimo não possui ferramentas associadas.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Processa cada ferramenta associada
        for (int idFerramenta : ferramentasAssociadas) {
            // Lógica para devolver a ferramenta e atualizar seu status, por exemplo
            
            // Atualiza o status da ferramenta para "disponível"
            ferramentaDAO.atualizarStatusFerramenta(idFerramenta, 1); // 1 significa "disponível"
        }

        // Atualiza o status do empréstimo para "finalizado" (por exemplo, status 2)
        emprestimoDAO.atualizarStatusEmprestimo(idEmprestimo, 2); // 2 seria "finalizado"

        JOptionPane.showMessageDialog(this, "Ferramentas devolvidas e empréstimo finalizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        // Atualiza a tabela após a operação
        carregaTabela();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(this, "Selecione um empréstimo para devolver as ferramentas.", "Aviso", JOptionPane.WARNING_MESSAGE);
}

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTemprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTemprestimoMouseClicked
        if (this.jTemprestimo.getSelectedRow() != -1) {
            // Captura o valor da coluna da data de devolução (supondo que a data esteja na 6ª coluna, ajuste se necessário)
            String dataDevolucaoStr = this.jTemprestimo.getValueAt(this.jTemprestimo.getSelectedRow(), 5).toString();

            try {
                // Converte a string para uma data
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Formato da data no banco de dados
                java.util.Date dataDevolucao = format.parse(dataDevolucaoStr);

                // Preenche o jDateChooser com a data
                this.jDateChooser.setDate(dataDevolucao);

            } catch (ParseException e) {
                // Trate o erro de conversão de data
                System.out.println("Erro ao converter a data: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_jTemprestimoMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Verifica se há uma linha selecionada
        if (this.jTemprestimo.getSelectedRow() != -1) {
            // Captura o ID do empréstimo da linha selecionada
            int idEmprestimo = Integer.parseInt(this.jTemprestimo.getValueAt(this.jTemprestimo.getSelectedRow(), 0).toString());

            // Captura a data selecionada no jDateChooser
            java.util.Date dataSelecionada = this.jDateChooser.getDate();  // Obtemos a data do jDateChooser

            if (dataSelecionada != null) {
                // Converte a data para o formato Date SQL (java.sql.Date)
                java.sql.Date dataDevolucaoSQL = new java.sql.Date(dataSelecionada.getTime());

                // Atualiza a data de devolução no banco de dados
                try {
                    // Chama o DAO para atualizar a data de devolução
                    emprestimoDAO.atualizarDataDevolucao(idEmprestimo, dataDevolucaoSQL);

                    // Atualiza a tabela após a alteração
                    carregaTabela(); // Método que recarrega a tabela com os dados mais recentes

                    JOptionPane.showMessageDialog(this, "Data de devolução atualizada com sucesso!");

                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar a data de devolução.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma data.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para atualizar!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBExcluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuListaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTemprestimo;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
