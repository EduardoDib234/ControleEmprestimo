package com.mycompany.controleemprestimo.view;

import javax.swing.JOptionPane;
import com.mycompany.controleemprestimo.model.Ferramenta;
import javax.swing.JComboBox;

public class FrmMenuCadastrarFerramentas extends javax.swing.JFrame {

    Ferramenta objeto = new Ferramenta();

    public FrmMenuCadastrarFerramentas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFMarca = new javax.swing.JTextField();
        JTFCusto = new javax.swing.JTextField();
        JTFStatus = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Ferramenta");

        jLabel1.setText("Nome:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Custo:");

        jLabel4.setText("Status:");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        JTFStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFStatusActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFCusto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFStatus))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFNome))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(JBCancelar)
                        .addGap(38, 38, 38)
                        .addComponent(JBCadastrar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBCadastrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed

        int id = 0;           // Inicializa a variável id (será gerado ou fornecido pelo sistema)
        String nome = "";     // Inicializa a variável para armazenar o nome
        String marca = "";    // Inicializa a variável para armazenar a marca
        double custo = 0.0;   // Inicializa a variável para armazenar o custo
        String status = "";   // Inicializa a variável para armazenar o status

        try {
           // Validação do campo Nome
            if (this.JTFNome.getText().length() < 1 || this.JTFNome.getText().length() > 30) {
                JOptionPane.showMessageDialog(null, "Você deve colocar o completo da sua ferramenta!");
            } else {
                nome = this.JTFNome.getText();
            }

            // Validação do campo Telefone
            if (this.JTFMarca.getText().length() < 1 || this.JTFMarca.getText().length() > 11) {
                throw new Exception("O nome da Marca deve conter pelo menos 2 letras");
            } else {
                marca = this.JTFMarca.getText();
            }

            // Validação do campo status
            if (this.JTFCusto.getText().length() < 1 || this.JTFCusto.getText().length() > 11) {
                throw new Exception("O custo da sua ferramenta deve conter pelo menos 1 digito!");
            } else {
                custo = Double.parseDouble(this.JTFCusto.getText());;
            }
            if (this.JTFMarca.getText().length() < 1 || this.JTFMarca.getText().length() > 11) {
                throw new Exception("O nome da Marca deve conter entre 2 e 11 caracteres.");
            } else {
                status = this.JTFStatus.getText().trim().toLowerCase(); // Remove espaços e converte para minúsculas
                if (!status.equals("disponível") && !status.equals("indisponível")) {
                    throw new Exception("O status deve ser 'disponível' ou 'indisponível'.");
                }
            }

            // Se todos os campos forem válidos, então prossegue com a inserção
            if (this.objeto.insertFerramenta(nome, marca, custo, status)) {
                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(rootPane, "Ferramenta cadastrada com sucesso!");

                // Limpa os campos da interface
                this.JTFNome.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                this.JTFStatus.setText(""); // Reseta o JTextField de status

                // Abre outro formulário, se necessário
                FrmMenuFerramentas objeto = new FrmMenuFerramentas();
                objeto.setVisible(true);
                this.dispose(); // Fecha a janela atual
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a ferramenta. Tente novamente.");
            }

        } catch (Exception ex) {
            // Captura e exibe qualquer erro ocorrido durante a execução
            System.out.println("Erro: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed

    }//GEN-LAST:event_JTFNomeActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        FrmMenuFerramentas objeto = new FrmMenuFerramentas();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTFStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFStatusActionPerformed

    }//GEN-LAST:event_JTFStatusActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuCadastrarFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
