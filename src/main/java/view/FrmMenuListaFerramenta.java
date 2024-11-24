package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.FerramentaDAO;
import model.Ferramenta;

public class FrmMenuListaFerramenta extends javax.swing.JFrame {

    private FerramentaDAO ferramentaDAO;

    public FrmMenuListaFerramenta() {
        initComponents();
        this.ferramentaDAO = new FerramentaDAO();
        this.carregaTabela();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTFerramentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTStatus = new javax.swing.JTextField();
        jBAtualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBCancelar = new javax.swing.JButton();
        jBRemover = new javax.swing.JButton();
        jBReparo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Ferramentas");

        jTFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Custo", "Status"
            }
        ));
        jTFerramentas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTFerramentasAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFerramentas);

        jLabel1.setText("Atualizar ferramenta");

        jLabel2.setText("ID:");

        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        jLabel4.setText("Marca:");

        jLabel6.setText("Custo:");

        jLabel7.setText("Status:");

        jTStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTStatusActionPerformed(evt);
            }
        });

        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBRemover.setText("Remover");
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        jBReparo.setText("Reparo");
        jBReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReparoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jBCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBReparo)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAtualizar)
                            .addComponent(jBCancelar)
                            .addComponent(jBRemover)
                            .addComponent(jBReparo))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        FrmMenuPrincipal objeto = new FrmMenuPrincipal();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFerramentasMouseClicked
        // Verifica se há uma linha selecionada
        if (this.jTFerramentas.getSelectedRow() != -1) {
            // Captura os valores das colunas da linha selecionada
            Object idObj = this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 0);
            Object nomeObj = this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 1);
            Object marcaObj = this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 2);
            Object custoObj = this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 3);
            Object statusObj = this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 4);

            // Verifique se os objetos não são null antes de acessar os valores
            if (idObj != null && nomeObj != null && marcaObj != null && custoObj != null && statusObj != null) {
                // Preenche os campos de texto com os valores capturados
                this.jTId.setText(idObj.toString());
                this.jTNome.setText(nomeObj.toString());
                this.jTMarca.setText(marcaObj.toString());
                this.jTStatus.setText(statusObj.toString());
                this.jTCusto.setText(custoObj.toString());

                // Desabilita a edição do campo ID
                this.jTId.setEnabled(false);
                this.jTStatus.setEnabled(false);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados da ferramenta inválidos. Tente novamente.");
            }
        }
    }//GEN-LAST:event_jTFerramentasMouseClicked

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        try {
            // Obtém e valida os dados dos campos de texto
            int id = Integer.parseInt(this.jTId.getText().trim());
            String nome = this.jTNome.getText().trim();
            String marca = this.jTMarca.getText().trim();
            double custo = Double.parseDouble(this.jTCusto.getText().trim());
            int status;


            // Validações básicas
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo Nome não pode estar vazio!");
                return;
            }
            if (marca.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "O campo Marca não pode estar vazio!");
                return;
            }
            if (custo <= 0) {
                JOptionPane.showMessageDialog(rootPane, "O custo deve ser maior que zero!");
                return;
            }
            if (this.jTStatus.getText().equals("Disponível")) {
                status = 1;
            } else {
                status = 0;
            }

            // Cria o objeto Ferramenta com os dados validados
            Ferramenta ferramentaAtualizado = new Ferramenta(id, nome, marca, custo, status);
            if (this.ferramentaDAO.atualizarFerramenta(ferramentaAtualizado)) {
                // Limpa os campos da interface
                this.jTNome.setText("");
                this.jTMarca.setText("");
                this.jTCusto.setText("");
                this.jTStatus.setText("");
                this.jTId.setText("");

                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(rootPane, "Ferramenta atualizada com sucesso!");
            } else {
                // Exibe mensagem de erro caso a atualização falhe
                JOptionPane.showMessageDialog(rootPane, "Falha ao atualizar a ferramenta. Verifique os dados e tente novamente.");
            }
        } catch (NumberFormatException e) {
            // Tratamento para erros de conversão de número
            JOptionPane.showMessageDialog(rootPane, "Erro ao converter um dos valores numéricos. Verifique os campos ID e Custo!");
        } catch (Exception e) {
            // Tratamento para outros erros gerais
            JOptionPane.showMessageDialog(rootPane, "Erro inesperado: " + e.getMessage());
        }
        carregaTabela();
    }//GEN-LAST:event_jBAtualizarActionPerformed

    private void jBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverActionPerformed
        try {
            int id = 0;
            // Verifica se uma linha foi selecionada
            if (this.jTFerramentas.getSelectedRow() == -1) {
                throw new Exception("Primeiro selecione uma ferramenta para APAGAR.");
            } else {
                // Obtém o ID do amigo selecionado na tabela
                id = Integer.parseInt(this.jTFerramentas.getValueAt(this.jTFerramentas.getSelectedRow(), 0).toString());
            }

            // Confirmação do usuário para exclusão
            Object[] options = {"Sim", "Não"};
            int resposta_usuario = JOptionPane.showOptionDialog(
                    null,
                    "Tem certeza que deseja APAGAR essa ferramenta?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            // Se o usuário confirmar a exclusão
            if (resposta_usuario == 0) {
                if (this.ferramentaDAO.deletaFerramentaBD(id)) {
                    // Limpa os campos da interface
                    this.jTNome.setText("");
                    this.jTMarca.setText("");
                    this.jTCusto.setText("");
                    this.jTStatus.setText("");
                    this.jTId.setText("");

                    JOptionPane.showMessageDialog(rootPane, "Ferramenta Deletada!");
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // Atualiza a tabela após a exclusão
        }
    }//GEN-LAST:event_jBRemoverActionPerformed

    private void jTStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTStatusActionPerformed

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdActionPerformed

    private void jTFerramentasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTFerramentasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFerramentasAncestorAdded

    private void jBReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReparoActionPerformed
        
    }//GEN-LAST:event_jBReparoActionPerformed
    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTFerramentas.getModel();
        modelo.setNumRows(0);  // Limpa a tabela antes de recarregar

        ArrayList<Ferramenta> minhalista = ferramentaDAO.getMinhaLista();  // Lista de Ferramentas

        // Verifica se a lista não está vazia
        if (minhalista == null || minhalista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma ferramenta encontrada.");
            return;
        }
        String change = "";
        for (Ferramenta a : minhalista) {
            if (a.getStatus() == 1) {
                change = "Disponível";
            } else if(a.getStatus() == 0){
                change = "Indisponível";
            } else { 
                change = "Reparo";

                    }
            modelo.addRow(new Object[]{                
                a.getId(),
                a.getNome(),
                a.getMarca(),
                a.getCusto(),
                change
            });
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuListaFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JButton jBReparo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCusto;
    private javax.swing.JTable jTFerramentas;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTMarca;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTStatus;
    // End of variables declaration//GEN-END:variables
}
