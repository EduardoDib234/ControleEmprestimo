package view;

import model.Emprestimo;
import model.Amigo;
import model.Ferramenta;
import dao.AmigoDAO;
import dao.FerramentaDAO;
import dao.EmprestimoDAO;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmMenuCadastrarEmprestimo extends javax.swing.JFrame {

    Emprestimo emprestimo = new Emprestimo();
    private AmigoDAO amigoDAO;
    private FerramentaDAO ferramentaDAO;
    private EmprestimoDAO emprestimoDAO;
    private ArrayList<Ferramenta> listFerramentas;
    private ArrayList<Ferramenta> listFerramentasSelecionadas;

    public FrmMenuCadastrarEmprestimo() {
        initComponents();
        this.amigoDAO = new AmigoDAO();
        this.carregaTabelaAmigo();
        this.ferramentaDAO = new FerramentaDAO();
        this.carregaTabelaFerramenta1();
        this.emprestimoDAO = EmprestimoDAO.getInstance();
        this.listFerramentas = new ArrayList<>();
        this.listFerramentasSelecionadas = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTCustoTotal = new javax.swing.JTextField();
        jBCadastrar1 = new javax.swing.JButton();
        jTtelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTScore = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTFerramentas1 = new javax.swing.JTable();
        jTIdamigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAmigos = new javax.swing.JTable();
        jTNomeamigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTFerramentas = new javax.swing.JTable();
        jBCancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTCustoTotal.setEditable(false);
        jTCustoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCustoTotalActionPerformed(evt);
            }
        });

        jBCadastrar1.setText("Cadastrar");
        jBCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrar1ActionPerformed(evt);
            }
        });

        jTtelefone.setEditable(false);

        jLabel9.setText("Data de emprestimo:");

        jLabel8.setText("Score");

        jTScore.setEditable(false);

        jLabel10.setText("Data de devoluçao:");

        jLabel5.setText("ID:");

        jLabel16.setText("Amigo selecionado:");

        jTFerramentas1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTFerramentas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFerramentas1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTFerramentas1);

        jTIdamigo.setEditable(false);

        jLabel17.setText("Nome:");

        jLabel2.setText("Ferramentas selecionadas:");

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
        jTAmigos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTAmigosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAmigos);

        jTNomeamigo.setEditable(false);

        jLabel3.setText("Informações do emprestimo");

        jLabel18.setText("telefone:");

        jLabel4.setText("Custo Total:");

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
        jTFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFerramentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTFerramentas);

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel18)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(1, 1, 1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTScore, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(jTtelefone)
                                            .addComponent(jTNomeamigo)
                                            .addComponent(jTIdamigo)))
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(119, 119, 119))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTIdamigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNomeamigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTCustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCustoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCustoTotalActionPerformed

    }//GEN-LAST:event_jTCustoTotalActionPerformed

    private void jBCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrar1ActionPerformed
    try {
        // Verifica se o ID do amigo está preenchido
        if (this.jTIdamigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um amigo!");
            return;
        }

        // Verifica se a lista de ferramentas selecionadas está vazia
        if (listFerramentasSelecionadas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione pelo menos uma ferramenta!");
            return;
        }
        
        if(emprestimoDAO.verificaExisteEmprestimo(Integer.parseInt(jTIdamigo.getText()))){
            JOptionPane.showMessageDialog(null, "Esse amigo possui um ou mais empréstimos!");
        }

        // Define automaticamente a data de empréstimo para o dia atual
        Date dataAtual = new Date();
        jDateChooser1.setDate(dataAtual);
        jDateChooser1.setEnabled(false); // Desativa a edição da data de empréstimo pelo usuário

        Date dataInicio = jDateChooser1.getDate();
        Date dataFinal = jDateChooser2.getDate();

        // Verificar se a data de devolução foi selecionada
        if (dataFinal == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione a data de devolução!");
            return;
        }

        // Verificar se a data de devolução é anterior à data de empréstimo
        if (dataFinal.before(dataInicio)) {
            JOptionPane.showMessageDialog(null, "A data de devolução não pode ser anterior à data de empréstimo!");
            return;
        }

        // Verificar se o período de empréstimo excede 90 dias
        long diferencaMilissegundos = dataFinal.getTime() - dataInicio.getTime();
        long diferencaDias = diferencaMilissegundos / (1000 * 60 * 60 * 24); // Converter para dias

        if (diferencaDias > 90) {
            JOptionPane.showMessageDialog(null, "O período de empréstimo não pode exceder 90 dias!");
            return;
        }

        // Conversão das datas para SQL
        java.sql.Date sqlDataInicio = new java.sql.Date(dataInicio.getTime());
        java.sql.Date sqlDataFinal = new java.sql.Date(dataFinal.getTime());

        int idAmigo = Integer.parseInt(jTIdamigo.getText());
        double custoTotal = Double.parseDouble(jTCustoTotal.getText());

        // Realiza o cadastro do empréstimo
        if (this.emprestimo.inserirEmprestimo(idAmigo, custoTotal, listFerramentasSelecionadas, sqlDataInicio, sqlDataFinal)) {
            JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
            this.carregaTabelaAmigo();
            this.carregaTabelaFerramenta1();

            // Limpar os campos
            this.jTCustoTotal.setText("");
            this.jTIdamigo.setText("");
            this.jTNomeamigo.setText("");
            this.jTScore.setText("");
            this.jTtelefone.setText("");

            // Limpar a tabela jTFerramentas
            DefaultTableModel modelo = (DefaultTableModel) jTFerramentas.getModel();
            modelo.setRowCount(0); // Remove todas as linhas

            // Limpar lista de ferramentas associada
            listFerramentasSelecionadas.clear();
        }
    } catch (Exception e) {
        e.printStackTrace(); // Exibe a exceção no console
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o empréstimo: " + e.getMessage());
    }
    }//GEN-LAST:event_jBCadastrar1ActionPerformed

    private void jTFerramentas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFerramentas1MouseClicked
        if (this.jTFerramentas1.getSelectedRow() != -1) {
            // Captura os dados da linha selecionada
            int id = Integer.parseInt(this.jTFerramentas1.getValueAt(this.jTFerramentas1.getSelectedRow(), 0).toString());
            String nome = this.jTFerramentas1.getValueAt(this.jTFerramentas1.getSelectedRow(), 1).toString();
            String marca = this.jTFerramentas1.getValueAt(this.jTFerramentas1.getSelectedRow(), 2).toString();
            double custo = Double.parseDouble(this.jTFerramentas1.getValueAt(this.jTFerramentas1.getSelectedRow(), 3).toString());
            int status = 1;  // Se status for fixo como 1, você pode deixá-lo assim.

            // Verifica se a ferramenta já foi selecionada
            boolean ferramentaSelecionada = listFerramentasSelecionadas.stream()
                    .anyMatch(ferramenta -> ferramenta.getId() == id);

            // Se a ferramenta ainda não foi selecionada, adiciona à lista
            if (!ferramentaSelecionada) {
                Ferramenta ferramenta = new Ferramenta(id, nome, marca, custo, status);
                listFerramentasSelecionadas.add(ferramenta);
                atualizaTabelaFerramentaSelecionada();
            }
            this.jTFerramentas1.setDefaultEditor(Object.class, null);

            // Desabilitar a edição na JTable
            DefaultTableModel modelo = (DefaultTableModel) this.jTFerramentas1.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    this.jTFerramentas1.getColumnModel().getColumn(j).setCellEditor(null); // Remove o editor de célula
                }
            }
        }
    }//GEN-LAST:event_jTFerramentas1MouseClicked

    private void jTAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAmigosMouseClicked
        try {
            int selectedRow = this.jTAmigos.getSelectedRow(); // Índice da linha selecionada
            if (selectedRow != -1) {
                // Captura os valores das colunas da linha selecionada
                String id = this.jTAmigos.getValueAt(selectedRow, 0).toString();
                String nome = this.jTAmigos.getValueAt(selectedRow, 1).toString();
                String telefone = this.jTAmigos.getValueAt(selectedRow, 2).toString();
                String score = this.jTAmigos.getValueAt(selectedRow, 3).toString();

                // Preenche os campos de texto
                this.jTIdamigo.setText(id);
                this.jTNomeamigo.setText(nome);
                this.jTtelefone.setText(telefone);
                this.jTScore.setText(score);

                // Habilitar campos de texto para edição
                if (!this.jTIdamigo.isEnabled()) {
                    this.jTIdamigo.setEnabled(true);
                    this.jTNomeamigo.setEnabled(true);
                    this.jTtelefone.setEnabled(true);
                    this.jTScore.setEnabled(true);
                }

                // Remover editor de células da JTable para que ela não seja editável
                this.jTAmigos.setDefaultEditor(Object.class, null); // Impede a edição de células

                // Opcional: Exibir informações no console para depuração
                System.out.println("Linha selecionada: " + selectedRow);
                System.out.println("ID: " + id + ", Nome: " + nome + ", Telefone: " + telefone + ", Score: " + score);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao selecionar amigo: " + e.getMessage());
            e.printStackTrace(); // Exibe o erro no console para depuração
        }
    }//GEN-LAST:event_jTAmigosMouseClicked

    private void jTFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFerramentasMouseClicked
        // Verifica se a linha clicada é válida (se uma linha foi realmente selecionada)
        int linhaSelecionada = this.jTFerramentas.getSelectedRow();
        if (linhaSelecionada != -1) {
            // Captura o ID da ferramenta selecionada na tabela (primeira coluna)
            int id = Integer.parseInt(this.jTFerramentas.getValueAt(linhaSelecionada, 0).toString());

            // Remove a ferramenta da lista de ferramentas selecionadas
            boolean ferramentaRemovida = false;
            for (int i = 0; i < listFerramentasSelecionadas.size(); i++) {
                if (listFerramentasSelecionadas.get(i).getId() == id) {
                    listFerramentasSelecionadas.remove(i);
                    ferramentaRemovida = true;
                    break;
                }
            }

            // Se a ferramenta foi removida, atualize a tabela
            if (ferramentaRemovida) {
                // Atualiza a tabela de ferramentas selecionadas
                atualizaTabelaFerramentaSelecionada();
                JOptionPane.showMessageDialog(null, "Ferramenta removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover a ferramenta.");
            }
        }
    }//GEN-LAST:event_jTFerramentasMouseClicked

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        FrmMenuPrincipal objeto = new FrmMenuPrincipal();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTAmigosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTAmigosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAmigosAncestorAdded

    public void carregaTabelaAmigo() {
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

    public void carregaTabelaFerramenta1() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTFerramentas1.getModel();
        modelo.setNumRows(0);  // Limpa a tabela antes de recarregar

        ArrayList<Ferramenta> minhalista = ferramentaDAO.getMinhaLista();  // Lista de Ferramentas

        String change;
        for (Ferramenta a : minhalista) {
            if (a.getStatus() == 1) {
                change = "Disponível";
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getMarca(),
                    a.getCusto(),
                    change
                });
            }
        }
    }

    public void atualizaTabelaFerramentaSelecionada() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTFerramentas.getModel();
        modelo.setNumRows(0);  // Limpa a tabela antes de recarregar

        String change;
        for (Ferramenta a : listFerramentasSelecionadas) {
            change = "Disponível";
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getMarca(),
                a.getCusto(),
                change
            });
        }

        double custoTotal = 0;
        for (Ferramenta ferramenta : listFerramentasSelecionadas) {
            custoTotal += ferramenta.getCusto();
        }

        this.jTCustoTotal.setText(String.valueOf(custoTotal));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuCadastrarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar1;
    private javax.swing.JButton jBCancelar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTAmigos;
    private javax.swing.JTextField jTCustoTotal;
    private javax.swing.JTable jTFerramentas;
    private javax.swing.JTable jTFerramentas1;
    private javax.swing.JTextField jTIdamigo;
    private javax.swing.JTextField jTNomeamigo;
    private javax.swing.JTextField jTScore;
    private javax.swing.JTextField jTtelefone;
    // End of variables declaration//GEN-END:variables
}
