/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author iury.marques
 */
public class ProdutoPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form TemplateRegistro
     */
    public ProdutoPesquisa() {
        initComponents();
    }

    public JButton getSair() {
        return sair;
    }

    public JTextField getPesquisa() {
        return pesquisa;
    }

    public JButton getPesquisar() {
        return pesquisar;
    }

    public JTable getTabelaDados() {
        return tabelaDados;
    }

    public JButton getCarregar() {
        return carregar;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PainelGeral = new javax.swing.JPanel();
        PainelTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        sair = new javax.swing.JButton();
        carregar = new javax.swing.JButton();
        PainelPesquisa = new javax.swing.JPanel();
        pesquisa = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        PainelDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        PianelFoto = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        PainelTitulo.setBackground(new java.awt.Color(42, 96, 65));

        jLabel2.setBackground(new java.awt.Color(236, 200, 174));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUTOS");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/ifsc-logo.png"))); // NOI18N

        javax.swing.GroupLayout PainelTituloLayout = new javax.swing.GroupLayout(PainelTitulo);
        PainelTitulo.setLayout(PainelTituloLayout);
        PainelTituloLayout.setHorizontalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(496, 496, 496)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );
        PainelTituloLayout.setVerticalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addGroup(PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelTituloLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6))
                    .addGroup(PainelTituloLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PainelBotoes.setBackground(new java.awt.Color(255, 255, 255));

        sair.setBackground(new java.awt.Color(219, 58, 52));
        sair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sair.setForeground(new java.awt.Color(255, 255, 255));
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/sair (1).png"))); // NOI18N
        sair.setText("Sair");
        sair.setActionCommand("1");
        sair.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        sair.setIconTextGap(10);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        carregar.setBackground(new java.awt.Color(0, 145, 173));
        carregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        carregar.setForeground(new java.awt.Color(255, 255, 255));
        carregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/seta-para-baixo.png"))); // NOI18N
        carregar.setText("Carregar");
        carregar.setActionCommand("1");
        carregar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        carregar.setIconTextGap(10);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelBotoesLayout.createSequentialGroup()
                .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        PainelPesquisa.setBackground(new java.awt.Color(255, 255, 255));

        pesquisa.setBackground(new java.awt.Color(231, 231, 231));
        pesquisa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pesquisa.setForeground(new java.awt.Color(153, 153, 153));
        pesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));

        pesquisar.setBackground(new java.awt.Color(40, 150, 90));
        pesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/lupa.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.setActionCommand("1");
        pesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pesquisar.setIconTextGap(10);

        javax.swing.GroupLayout PainelPesquisaLayout = new javax.swing.GroupLayout(PainelPesquisa);
        PainelPesquisa.setLayout(PainelPesquisaLayout);
        PainelPesquisaLayout.setHorizontalGroup(
            PainelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisar)
                .addGap(19, 19, 19))
        );
        PainelPesquisaLayout.setVerticalGroup(
            PainelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPesquisaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PainelDados.setBackground(new java.awt.Color(255, 255, 255));
        PainelDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tabelaDados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Código de barras", "Preço"
            }
        ));
        tabelaDados.setMaximumSize(new java.awt.Dimension(190, 80));
        tabelaDados.setMinimumSize(new java.awt.Dimension(190, 80));
        jScrollPane1.setViewportView(tabelaDados);
        if (tabelaDados.getColumnModel().getColumnCount() > 0) {
            tabelaDados.getColumnModel().getColumn(0).setMinWidth(40);
            tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelaDados.getColumnModel().getColumn(0).setMaxWidth(40);
            tabelaDados.getColumnModel().getColumn(3).setMinWidth(60);
            tabelaDados.getColumnModel().getColumn(3).setPreferredWidth(60);
            tabelaDados.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout PainelDadosLayout = new javax.swing.GroupLayout(PainelDados);
        PainelDados.setLayout(PainelDadosLayout);
        PainelDadosLayout.setHorizontalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelDadosLayout.setVerticalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/galeria-de-imagens 32.png"))); // NOI18N

        javax.swing.GroupLayout PianelFotoLayout = new javax.swing.GroupLayout(PianelFoto);
        PianelFoto.setLayout(PianelFotoLayout);
        PianelFotoLayout.setHorizontalGroup(
            PianelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PianelFotoLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        PianelFotoLayout.setVerticalGroup(
            PianelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PianelFotoLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(foto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PainelGeralLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(PainelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PianelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(PainelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PianelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

    }//GEN-LAST:event_sairActionPerformed

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
            java.util.logging.Logger.getLogger(TemplateRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemplateRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemplateRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemplateRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and displayfoto form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TemplateRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelDados;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JPanel PainelPesquisa;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JPanel PianelFoto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton carregar;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
