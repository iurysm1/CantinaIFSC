
package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CidadeRegistro extends javax.swing.JFrame {


    public CidadeRegistro() {
        initComponents();
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JButton getGravar() {
        return gravar;
    }

    public JButton getNovo() {
        return novo;
    }

    public JButton getPesquisar() {
        return pesquisar;
    }

    public JButton getSair() {
        return sair;
    }


    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getNomeDoBairro() {
        return nomeDoBairro;
    }

    public void setNomeDoBairro(JTextField nomeDoBairro) {
        this.nomeDoBairro = nomeDoBairro;
    }

    public JTextField getUf() {
        return uf;
    }

    public void setUf(JTextField uf) {
        this.uf = uf;
    }

    public JPanel getPainelBotoes() {
        return PainelBotoes;
    }

    public JPanel getPainelDados() {
        return PainelDados;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelGeral = new javax.swing.JPanel();
        PainelTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        pesquisar = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        gravar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        PainelDados = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        nomeDoBairro = new javax.swing.JTextField();
        uf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        PainelTitulo.setBackground(new java.awt.Color(42, 96, 65));

        jLabel2.setBackground(new java.awt.Color(236, 200, 174));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CADASTRO DE CIDADE");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/ifsc-logo.png"))); // NOI18N

        javax.swing.GroupLayout PainelTituloLayout = new javax.swing.GroupLayout(PainelTitulo);
        PainelTitulo.setLayout(PainelTituloLayout);
        PainelTituloLayout.setHorizontalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(240, 240, 240)
                .addComponent(jLabel3)
                .addGap(15, 15, 15))
        );
        PainelTituloLayout.setVerticalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addGroup(PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelTituloLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(PainelTituloLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PainelBotoes.setBackground(new java.awt.Color(255, 255, 255));

        pesquisar.setBackground(new java.awt.Color(40, 150, 90));
        pesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/lupa.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.setActionCommand("1");
        pesquisar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 150, 90), 1, true), null));
        pesquisar.setBorderPainted(false);
        pesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pesquisar.setIconTextGap(10);
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        novo.setBackground(new java.awt.Color(0, 145, 173));
        novo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        novo.setForeground(new java.awt.Color(255, 255, 255));
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/adicionar (1).png"))); // NOI18N
        novo.setText("Novo");
        novo.setActionCommand("1");
        novo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 145, 173), 1, true));
        novo.setBorderPainted(false);
        novo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        novo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        novo.setIconTextGap(10);
        novo.setInheritsPopupMenu(true);
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        gravar.setBackground(new java.awt.Color(42, 96, 65));
        gravar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        gravar.setForeground(new java.awt.Color(255, 255, 255));
        gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/confirme.png"))); // NOI18N
        gravar.setText("Gravar");
        gravar.setActionCommand("0");
        gravar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 96, 65), 10, true));
        gravar.setBorderPainted(false);
        gravar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gravar.setIconTextGap(10);
        gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(219, 58, 52));
        cancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/cancelar.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setActionCommand("0");
        cancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 58, 52), 1, true));
        cancelar.setBorderPainted(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cancelar.setIconTextGap(10);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        sair.setBackground(new java.awt.Color(219, 58, 52));
        sair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sair.setForeground(new java.awt.Color(255, 255, 255));
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/sair (1).png"))); // NOI18N
        sair.setText("Sair");
        sair.setActionCommand("2");
        sair.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 58, 52), 1, true));
        sair.setBorderPainted(false);
        sair.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        sair.setIconTextGap(10);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        PainelDados.setBackground(new java.awt.Color(255, 255, 255));

        id.setBackground(new java.awt.Color(231, 231, 231));
        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setActionCommand("1");
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        id.setSelectionColor(new java.awt.Color(42, 96, 65));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        nomeDoBairro.setBackground(new java.awt.Color(231, 231, 231));
        nomeDoBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomeDoBairro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        nomeDoBairro.setSelectionColor(new java.awt.Color(42, 96, 65));

        uf.setBackground(new java.awt.Color(231, 231, 231));
        uf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        uf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        uf.setSelectionColor(new java.awt.Color(42, 96, 65));
        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("UF");

        status.setBackground(new java.awt.Color(231, 231, 231));
        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Desativo" }));
        status.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 1, true));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("STATUS");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("NOME");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("ID");

        javax.swing.GroupLayout PainelDadosLayout = new javax.swing.GroupLayout(PainelDados);
        PainelDados.setLayout(PainelDadosLayout);
        PainelDadosLayout.setHorizontalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDadosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelDadosLayout.createSequentialGroup()
                        .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(609, 609, 609)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelDadosLayout.createSequentialGroup()
                        .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(nomeDoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(273, 273, 273)
                        .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelDadosLayout.setVerticalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDadosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PainelDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       
    }//GEN-LAST:event_cancelarActionPerformed

    private void gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarActionPerformed
        
    }//GEN-LAST:event_gravarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
       
    }//GEN-LAST:event_novoActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed

    }//GEN-LAST:event_idActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
      
    }//GEN-LAST:event_sairActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed

    }//GEN-LAST:event_pesquisarActionPerformed

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed

    }//GEN-LAST:event_ufActionPerformed

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
            java.util.logging.Logger.getLogger(CidadeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CidadeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CidadeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CidadeRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CidadeRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelDados;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton gravar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nomeDoBairro;
    private javax.swing.JButton novo;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField uf;
    // End of variables declaration//GEN-END:variables
}
