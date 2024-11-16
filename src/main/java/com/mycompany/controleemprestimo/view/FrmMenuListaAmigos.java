package com.mycompany.controleemprestimo.view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import com.mycompany.controleemprestimo.model.Amigo;
import com.mycompany.controleemprestimo.dao.AmigoDAO;

public class FrmMenuListaAmigos extends javax.swing.JFrame {

    private AmigoDAO amigoDAO;

    public FrmMenuListaAmigos() {
        initComponents();
        this.amigoDAO = new AmigoDAO();
        this.carregaTabela();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAmigos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBRemover = new javax.swing.JButton();
        jTId = new javax.swing.JTextField();
        jBAtualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jBCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTTelefone = new javax.swing.JTextField();
        jCBScore = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Amigos");

        jTAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Score"
            }
        ));
        jTAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAmigos);

        jLabel1.setText("Atualizar Amigos");

        jLabel2.setText("ID:");

        jBRemover.setText("Remover");
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        jTNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone:");

        jCBScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alto", "Medio", "Baixo"}));
        jCBScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBScoreActionPerformed(evt);
            }
        });

        jLabel5.setText("Score:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jBCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBAtualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jCBScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(426, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(142, 142, 142)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(417, 417, 417)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBRemover)
                    .addComponent(jBAtualizar))
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jTTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(105, 105, 105)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverActionPerformed
        try {
            int id = 0;
            // Verifica se uma linha foi selecionada
            if (this.jTAmigos.getSelectedRow() == -1) {
                throw new Exception("Primeiro selecione um amigo para APAGAR.");
            } else {
                // Obtém o ID do amigo selecionado na tabela
                id = Integer.parseInt(this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 0).toString());
            }

            // Confirmação do usuário para exclusão
            Object[] options = {"Sim", "Não"};
            int resposta_usuario = JOptionPane.showOptionDialog(
                    null,
                    "Tem certeza que deseja APAGAR esse amigo?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            // Se o usuário confirmar a exclusão
            if (resposta_usuario == 0) {
                if (this.amigoDAO.deletaAmigoBD(id)) {
                    // Limpa os campos da interface
                    this.jTNome.setText("");
                    this.jTTelefone.setText("");
                    this.jTId.setText("");
                    this.jCBScore.setSelectedIndex(0); // Reseta a JComboBox para o primeiro item

                    JOptionPane.showMessageDialog(rootPane, "Amigo Deletado!");
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // Atualiza a tabela após a exclusão
        }
    }//GEN-LAST:event_jBRemoverActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        FrmMenuAmigos objeto = new FrmMenuAmigos();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        try {
            int id = 0;
            String nome = "";
            String telefone = "";
            String score = "";

            // Verifica se uma linha foi selecionada
            if (this.jTAmigos.getSelectedRow() == -1) {
                throw new Exception("Primeiro selecione um amigo para atualizar.");
            } else {
                id = Integer.parseInt(this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 0).toString());
            }

            // Validação do campo Nome
            if (this.jTNome.getText().length() < 6 || this.jTNome.getText().length() > 30) {
                JOptionPane.showMessageDialog(null, "Você deve colocar seu nome completo!");
            } else {
                nome = this.jTNome.getText();
            }

            // Validação do campo Telefone
            if (this.jTTelefone.getText().length() < 9 || this.jTTelefone.getText().length() > 11) {
                throw new Exception("Telefones devem conter o dígito 9 + DDD para ser aceito!");
            } else {
                telefone = this.jTTelefone.getText();
            }

            // Captura do valor selecionado na JComboBox
            score = (String) this.jCBScore.getSelectedItem();

            // Atualização do amigo
            Amigo amigoAtualizado = new Amigo(id, nome, telefone, score);
            if (this.amigoDAO.atualizarAmigo(amigoAtualizado)) {
                // Limpa os campos da interface
                this.jTNome.setText("");
                this.jTTelefone.setText("");
                this.jTId.setText("");
                this.jCBScore.setSelectedIndex(0); // Reseta a JComboBox para o primeiro item

                JOptionPane.showMessageDialog(rootPane, "Amigo atualizado!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // Atualiza a tabela após a atualização
        }

    }//GEN-LAST:event_jBAtualizarActionPerformed

    private void jTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeActionPerformed
        jTTelefone.requestFocusInWindow();
    }//GEN-LAST:event_jTNomeActionPerformed

    private void jTAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAmigosMouseClicked
        if (this.jTAmigos.getSelectedRow() != -1) {
            // Captura os valores das colunas da linha selecionada
            String id = this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 0).toString();
            String nome = this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 1).toString();
            String telefone = this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 2).toString();
            String score = this.jTAmigos.getValueAt(this.jTAmigos.getSelectedRow(), 3).toString(); // Captura o valor do score

            // Preenche os campos de texto com os valores capturados
            this.jTId.setText(id);
            this.jTNome.setText(nome);
            this.jTTelefone.setText(telefone);

            // Configura o item selecionado na JComboBox de acordo com o valor capturado
            this.jCBScore.setSelectedItem(score);

            // Desabilita a edição do campo ID
            this.jTId.setEnabled(false);
        }
    }//GEN-LAST:event_jTAmigosMouseClicked

    private void jCBScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBScoreActionPerformed

    }//GEN-LAST:event_jCBScoreActionPerformed
    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTAmigos.getModel();
        modelo.setNumRows(0);  // Limpar a tabela antes de recarregar

        ArrayList<Amigo> minhalista = amigoDAO.getMinhaLista();  // Lista de amigos
        for (Amigo a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getTelefone(),
                a.getScore(),});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuListaAmigos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JComboBox<String> jCBScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAmigos;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTTelefone;
    // End of variables declaration//GEN-END:variables
}
