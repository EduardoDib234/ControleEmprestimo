package view;

import javax.swing.JOptionPane;

public class FrmMenuAcesso extends javax.swing.JFrame {

    public FrmMenuAcesso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();
        jBEntrar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setText("Senha:");

        jTLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Login:");

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBEntrar1.setText("Entrar");
        jBEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrar1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cadastro de ferramentas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBCancelar)
                                .addGap(40, 40, 40)
                                .addComponent(jBEntrar1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPSenha)
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3)))))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBEntrar1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLoginActionPerformed

    }//GEN-LAST:event_jTLoginActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrar1ActionPerformed
        // Obtém os valores inseridos nos campos de login e senha
        String login = this.jTLogin.getText();
        char[] senha = this.jPSenha.getPassword();  // Captura a senha digitada como um array de caracteres

        // Converte o array de caracteres para uma string para comparação
        String senhaStr = new String(senha);

        // Verifica se o login e a senha estão corretos
        if (login.equals("root") && senhaStr.equals("root123")) {
            // Caso os dados estejam corretos, abre o FrmMenuPrincipal
            FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
            menuPrincipal.setVisible(true);

            // Fecha a tela de login
            this.dispose();
        } else {
            // Caso o login ou a senha estejam incorretos, exibe um aviso
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Tente novamente.");
        }
    }

// Método para associar o ActionListener ao botão de login
    private void adicionarActionListenerAoBotaoLogin() {
        jBEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrar1ActionPerformed(evt);
            }
        });
    }//GEN-LAST:event_jBEntrar1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuAcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEntrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTLogin;
    // End of variables declaration//GEN-END:variables
}
