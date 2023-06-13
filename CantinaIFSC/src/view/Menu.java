/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.Persiste;
import controller.BairroRegistroController;
import controller.CarteirinhaRegistroController;
import controller.CidadeRegistroController;
import controller.ClienteRegistroController;
import controller.EnderecoRegistroController;
import controller.FornecedorRegistroController;
import controller.FuncionarioRegistroController;
import controller.ProdutoRegistroController;
import javax.swing.JOptionPane;
import utilities.Utilities;

/**
 *
 * @author iury.marques
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form TemplateRegistro
     */
    public Menu() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        Persiste.getInstance();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fotoMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadastros = new javax.swing.JMenu();
        funcionario = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenuItem();
        fornecedores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cidade = new javax.swing.JMenuItem();
        bairro = new javax.swing.JMenuItem();
        endereco = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        produto = new javax.swing.JMenuItem();
        carteirinha = new javax.swing.JMenuItem();
        movimentacao = new javax.swing.JMenu();
        relatorios = new javax.swing.JMenu();
        ajuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1099, 708));

        fotoMenu.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/INSTITUTO FEDERAL DE SANTA CATARINA (3).png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout fotoMenuLayout = new javax.swing.GroupLayout(fotoMenu);
        fotoMenu.setLayout(fotoMenuLayout);
        fotoMenuLayout.setHorizontalGroup(
            fotoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fotoMenuLayout.setVerticalGroup(
            fotoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, Short.MAX_VALUE)
        );

        Menu.setPreferredSize(new java.awt.Dimension(284, 40));

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/ifsc-logo24px.png"))); // NOI18N
        jMenu1.setBorderPainted(false);
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Menu.add(jMenu1);

        cadastros.setBackground(new java.awt.Color(42, 96, 65));
        cadastros.setText("Cadastros");

        funcionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-person-cook-16.png"))); // NOI18N
        funcionario.setText("Funcionários");
        funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioActionPerformed(evt);
            }
        });
        cadastros.add(funcionario);

        clientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-busts-in-silhouette-16.png"))); // NOI18N
        clientes.setText("Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        cadastros.add(clientes);

        fornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        fornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-delivery-truck-16.png"))); // NOI18N
        fornecedores.setText("Fornecedores");
        fornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedoresActionPerformed(evt);
            }
        });
        cadastros.add(fornecedores);
        cadastros.add(jSeparator1);

        cidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        cidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-world-map-16.png"))); // NOI18N
        cidade.setText("Cidades");
        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });
        cadastros.add(cidade);

        bairro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        bairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-houses-16.png"))); // NOI18N
        bairro.setText("Bairros");
        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });
        cadastros.add(bairro);

        endereco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        endereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-casa-16.png"))); // NOI18N
        endereco.setText("Endereços");
        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });
        cadastros.add(endereco);
        cadastros.add(jSeparator2);

        produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-hot-beverage-16.png"))); // NOI18N
        produto.setText("Produtos");
        produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoActionPerformed(evt);
            }
        });
        cadastros.add(produto);

        carteirinha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        carteirinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsMenu/icons8-identification-card-16.png"))); // NOI18N
        carteirinha.setText("Carteirinhas");
        carteirinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carteirinhaActionPerformed(evt);
            }
        });
        cadastros.add(carteirinha);

        Menu.add(cadastros);

        movimentacao.setText("Movimentaçoes");
        Menu.add(movimentacao);

        relatorios.setText("Relatórios");
        Menu.add(relatorios);

        ajuda.setText("ajuda");
        Menu.add(ajuda);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed
       FuncionarioRegistro funcionario = new FuncionarioRegistro();
       FuncionarioRegistroController funcionarioController=new FuncionarioRegistroController(funcionario);
       funcionario.setVisible(true);
    }//GEN-LAST:event_funcionarioActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        ClienteRegistro cliente = new ClienteRegistro();
        ClienteRegistroController clienteRegistroController=new ClienteRegistroController(cliente);
        cliente.setVisible(true);
    }//GEN-LAST:event_clientesActionPerformed

    private void fornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedoresActionPerformed
        FornecedorRegistro fornecedor = new FornecedorRegistro();
        FornecedorRegistroController fornecedorRegistroController=new FornecedorRegistroController(fornecedor);
        fornecedor.setVisible(true);
    }//GEN-LAST:event_fornecedoresActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        CidadeRegistro cidade = new CidadeRegistro();
        CidadeRegistroController cidadeController=new CidadeRegistroController(cidade);
        cidade.setVisible(true);
    }//GEN-LAST:event_cidadeActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        BairroRegistro bairro = new BairroRegistro();
        BairroRegistroController bairroController= new BairroRegistroController(bairro);
        bairro.setVisible(true);
    }//GEN-LAST:event_bairroActionPerformed

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        EnderecoRegistro endereco = new EnderecoRegistro();
        EnderecoRegistroController enderecoController=new EnderecoRegistroController(endereco);
        endereco.setVisible(true);
    }//GEN-LAST:event_enderecoActionPerformed

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
        ProdutoRegistro produto = new ProdutoRegistro();
        ProdutoRegistroController produtoRegistroController=new ProdutoRegistroController(produto);
        produto.setVisible(true);
    }//GEN-LAST:event_produtoActionPerformed

    private void carteirinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carteirinhaActionPerformed
        CarteirinhaRegistro carteirinha = new CarteirinhaRegistro();
        CarteirinhaRegistroController carteirinhaRegistroController=new CarteirinhaRegistroController(carteirinha);
        carteirinha.setVisible(true);
    }//GEN-LAST:event_carteirinhaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu ajuda;
    private javax.swing.JMenuItem bairro;
    private javax.swing.JMenu cadastros;
    private javax.swing.JMenuItem carteirinha;
    private javax.swing.JMenuItem cidade;
    private javax.swing.JMenuItem clientes;
    private javax.swing.JMenuItem endereco;
    private javax.swing.JMenuItem fornecedores;
    private javax.swing.JPanel fotoMenu;
    private javax.swing.JMenuItem funcionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu movimentacao;
    private javax.swing.JMenuItem produto;
    private javax.swing.JMenu relatorios;
    // End of variables declaration//GEN-END:variables
}
