/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author iury.marques
 */
public class CarteirinhaRegistro extends javax.swing.JFrame {

    /**
     * Creates new form TemplateRegistro
     */
    public CarteirinhaRegistro() {
        initComponents();

        
    }

    public JTextField getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(JTextField codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public JFormattedTextField getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(JFormattedTextField dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public JPanel getPainelBotoes() {
        return PainelBotoes;
    }

    public JPanel getPainelDados() {
        return PainelDados;
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

    public JFormattedTextField getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(JFormattedTextField data) {
        this.dataCancelamento = data;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JFormattedTextField getjCriacao() {
        return dataCriacao;
    }

    public void setCriacao(JFormattedTextField jFormattedTextField1) {
        this.dataCriacao = jFormattedTextField1;
    }

    public JTextField getMatricula() {
        return codigoBarra;
    }

    public void setMatricula(JTextField matricula) {
        this.codigoBarra = matricula;
    }

    public JTextField getNome() {
        return nomeCliente;
    }

    public void setNome(JTextField nome) {
        this.nomeCliente = nome;
    }

    public JTextField getRg() {
        return idCliente;
    }

    public void setRg(JTextField rg) {
        this.idCliente = rg;
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
        PainelDados = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        nomeCliente = new javax.swing.JTextField();
        idCliente = new javax.swing.JTextField();
        codigoBarra = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        dataCancelamento = new javax.swing.JFormattedTextField();
        dataCriacao = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        pesquisar = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        gravar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        PainelTitulo.setBackground(new java.awt.Color(42, 96, 65));

        jLabel2.setBackground(new java.awt.Color(236, 200, 174));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CADASTRO DE CARTEIRINHA");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/ifsc-logo.png"))); // NOI18N

        javax.swing.GroupLayout PainelTituloLayout = new javax.swing.GroupLayout(PainelTitulo);
        PainelTitulo.setLayout(PainelTituloLayout);
        PainelTituloLayout.setHorizontalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(177, 177, 177)
                .addComponent(jLabel3)
                .addGap(15, 15, 15))
        );
        PainelTituloLayout.setVerticalGroup(
            PainelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTituloLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(31, 31, 31))
        );

        PainelDados.setBackground(new java.awt.Color(255, 255, 255));

        id.setBackground(new java.awt.Color(231, 231, 231));
        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setActionCommand("0");
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        id.setSelectionColor(new java.awt.Color(42, 96, 65));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        nomeCliente.setBackground(new java.awt.Color(231, 231, 231));
        nomeCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomeCliente.setActionCommand("2");
        nomeCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        nomeCliente.setSelectionColor(new java.awt.Color(42, 96, 65));

        idCliente.setBackground(new java.awt.Color(231, 231, 231));
        idCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idCliente.setActionCommand("2");
        idCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        idCliente.setSelectionColor(new java.awt.Color(42, 96, 65));

        codigoBarra.setBackground(new java.awt.Color(231, 231, 231));
        codigoBarra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        codigoBarra.setActionCommand("0");
        codigoBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 10, true));
        codigoBarra.setSelectionColor(new java.awt.Color(42, 96, 65));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("CODIGO DE BARRA");

        status.setBackground(new java.awt.Color(231, 231, 231));
        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Desativo" }));
        status.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 1, true));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("DATA DE CRIAÇÃO");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("DATA DE CANCELAMENTO");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("NOME DO CLIENTE");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setText("ID DO CLIENTE");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("ID");

        dataCancelamento.setBackground(new java.awt.Color(231, 231, 231));
        dataCancelamento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 1, true));
        try {
            dataCancelamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataCancelamento.setActionCommand("0");
        dataCancelamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dataCancelamento.setSelectionColor(new java.awt.Color(42, 96, 65));

        dataCriacao.setBackground(new java.awt.Color(231, 231, 231));
        dataCriacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 231, 231)));
        try {
            dataCriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataCriacao.setActionCommand("0");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("STATUS");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout PainelDadosLayout = new javax.swing.GroupLayout(PainelDados);
        PainelDados.setLayout(PainelDadosLayout);
        PainelDadosLayout.setHorizontalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDadosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31)
                    .addComponent(jLabel26)
                    .addComponent(dataCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(id))
                .addGap(46, 46, 46)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addComponent(jLabel27)
                    .addComponent(idCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(dataCancelamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PainelDadosLayout.createSequentialGroup()
                            .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(codigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19)
                            .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
            .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PainelDadosLayout.setVerticalGroup(
            PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDadosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel18)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addComponent(PainelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed

    }//GEN-LAST:event_novoActionPerformed

    private void gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarActionPerformed

    }//GEN-LAST:event_gravarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

    }//GEN-LAST:event_cancelarActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed

    }//GEN-LAST:event_idActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed

    }//GEN-LAST:event_pesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(CarteirinhaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarteirinhaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarteirinhaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarteirinhaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarteirinhaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelDados;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigoBarra;
    private javax.swing.JFormattedTextField dataCancelamento;
    private javax.swing.JFormattedTextField dataCriacao;
    private javax.swing.JButton gravar;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JButton novo;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton sair;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
