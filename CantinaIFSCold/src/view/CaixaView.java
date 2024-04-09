/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mony
 */
public class CaixaView extends javax.swing.JFrame {

    /**
     * Creates new form Caixa
     */
    public CaixaView() {
        initComponents();
    }


    public JButton getAbrirCaixa() {
        return abrirCaixa;
    }

    public void setAbrirCaixa(JButton abrirCaixa) {
        this.abrirCaixa = abrirCaixa;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JButton getNovoCaixa() {
        return novoCaixa;
    }

    public void setNovoCaixa(JButton novoCaixa) {
        this.novoCaixa = novoCaixa;
    }

    public JLabel getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura.setText(dataAbertura);
    }

    public JLabel getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento.setText(dataFechamento);
    }

    public JButton getFecharCaixa() {
        return fecharCaixa;
    }

    public void setFecharCaixa(JButton fecharCaixa) {
        this.fecharCaixa = fecharCaixa;
    }

    public JTextField getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(JTextField idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public JTextField getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(JTextField nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public JLabel getStatusCaixa() {
        return statusCaixa;
    }

    public void setStatusCaixa(String statusCaixa) {
        this.statusCaixa.setText(statusCaixa);
    }

    public JTextField getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(JTextField valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public JLabel getValorCedula() {
        return valorCedula;
    }

    public void setValorCedula(String valorCedula) {
        this.valorCedula.setText(valorCedula);
    }

    public JLabel getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(String valorCredito) {
        this.valorCredito.setText(valorCredito);
    }

    public JLabel getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(String valorDebito) {
        this.valorDebito.setText(valorDebito);
    }

    public JPanel getPainelStatus() {
        return painelStatus;
    }

    public void setPainelStatus(JPanel painelStatus) {
        this.painelStatus = painelStatus;
    }

    public JButton getPesquisarFuncionario() {
        return pesquisarFuncionario;
    }

    public void setPesquisarFuncionario(JButton pesquisarFuncionario) {
        this.pesquisarFuncionario = pesquisarFuncionario;
    }

    public JLabel getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(String valorFechamento) {
        this.valorFechamento.setText(valorFechamento);
    }

    public JPanel getPainelGeral() {
        return PainelGeral;
    }

    public void setPainelGeral(JPanel PainelGeral) {
        this.PainelGeral = PainelGeral;
    }
    
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelGeral = new javax.swing.JPanel();
        painelTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idFuncionario = new javax.swing.JTextField();
        nomeFuncionario = new javax.swing.JTextField();
        valorAbertura = new javax.swing.JTextField();
        painelStatus = new javax.swing.JPanel();
        abrirCaixa = new javax.swing.JButton();
        pesquisarFuncionario = new javax.swing.JButton();
        fecharCaixa = new javax.swing.JButton();
        statusCaixa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        dataAbertura = new javax.swing.JLabel();
        dataFechamento = new javax.swing.JLabel();
        valorDebito = new javax.swing.JLabel();
        valorCredito = new javax.swing.JLabel();
        valorCedula = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        valorFechamento = new javax.swing.JLabel();
        novoCaixa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        painelTitulo.setBackground(new java.awt.Color(42, 96, 65));

        jLabel2.setBackground(new java.awt.Color(236, 200, 174));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENDA");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/ifsc-logo.png"))); // NOI18N

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(517, 517, 517)
                .addComponent(jLabel3)
                .addGap(16, 16, 16))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Fechamento de caixa");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel4.setText("Abertura de caixa");

        idFuncionario.setBackground(new java.awt.Color(231, 231, 231));
        idFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idFuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idFuncionario.setToolTipText("");
        idFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 3, true));
        idFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFuncionarioActionPerformed(evt);
            }
        });

        nomeFuncionario.setBackground(new java.awt.Color(231, 231, 231));
        nomeFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomeFuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeFuncionario.setToolTipText("");
        nomeFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 3, true));
        nomeFuncionario.setEnabled(false);

        valorAbertura.setBackground(new java.awt.Color(231, 231, 231));
        valorAbertura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        valorAbertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valorAbertura.setToolTipText("");
        valorAbertura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(231, 231, 231), 3, true));
        valorAbertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorAberturaActionPerformed(evt);
            }
        });

        painelStatus.setBackground(new java.awt.Color(219, 58, 52));
        painelStatus.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelStatusLayout = new javax.swing.GroupLayout(painelStatus);
        painelStatus.setLayout(painelStatusLayout);
        painelStatusLayout.setHorizontalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        painelStatusLayout.setVerticalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        abrirCaixa.setBackground(new java.awt.Color(42, 96, 65));
        abrirCaixa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        abrirCaixa.setForeground(new java.awt.Color(255, 255, 255));
        abrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/confirme.png"))); // NOI18N
        abrirCaixa.setText("Abrir caixa");
        abrirCaixa.setActionCommand("0");
        abrirCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 96, 65), 10, true));
        abrirCaixa.setBorderPainted(false);
        abrirCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        abrirCaixa.setIconTextGap(10);
        abrirCaixa.setPreferredSize(new java.awt.Dimension(186, 66));
        abrirCaixa.setVerifyInputWhenFocusTarget(false);
        abrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCaixaActionPerformed(evt);
            }
        });

        pesquisarFuncionario.setBackground(new java.awt.Color(0, 145, 173));
        pesquisarFuncionario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pesquisarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        pesquisarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/lupa.png"))); // NOI18N
        pesquisarFuncionario.setText("Pesquisar");
        pesquisarFuncionario.setActionCommand("0");
        pesquisarFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 145, 173), 1, true));
        pesquisarFuncionario.setBorderPainted(false);
        pesquisarFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pesquisarFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pesquisarFuncionario.setIconTextGap(10);
        pesquisarFuncionario.setInheritsPopupMenu(true);
        pesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarioActionPerformed(evt);
            }
        });

        fecharCaixa.setBackground(new java.awt.Color(219, 58, 52));
        fecharCaixa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fecharCaixa.setForeground(new java.awt.Color(255, 255, 255));
        fecharCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/cancelar.png"))); // NOI18N
        fecharCaixa.setText("Fechar caixa");
        fecharCaixa.setActionCommand("0");
        fecharCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 58, 52), 1, true));
        fecharCaixa.setBorderPainted(false);
        fecharCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        fecharCaixa.setIconTextGap(10);
        fecharCaixa.setPreferredSize(new java.awt.Dimension(186, 66));
        fecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharCaixaActionPerformed(evt);
            }
        });

        statusCaixa.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        statusCaixa.setForeground(new java.awt.Color(255, 255, 255));
        statusCaixa.setText("Fechado");

        jPanel3.setBackground(new java.awt.Color(231, 231, 231));
        jPanel3.setPreferredSize(new java.awt.Dimension(2, 472));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nome do funcionário");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Valor inicial do caixa");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Data de abertura:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Data de fechamento:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Valor em Débito:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Valor em Crédito:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Valor em Cédula:");

        dataAbertura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataAbertura.setText("00/00/0000");

        dataFechamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataFechamento.setText("00/00/0000");

        valorDebito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valorDebito.setText("0.00");

        valorCredito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valorCredito.setText("0.00");

        valorCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valorCedula.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Valor fechamento:");

        valorFechamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valorFechamento.setText("0.00");

        novoCaixa.setBackground(new java.awt.Color(0, 145, 173));
        novoCaixa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        novoCaixa.setForeground(new java.awt.Color(255, 255, 255));
        novoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/adicionar (1).png"))); // NOI18N
        novoCaixa.setText("Novo caixa");
        novoCaixa.setActionCommand("1");
        novoCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 145, 173), 1, true));
        novoCaixa.setBorderPainted(false);
        novoCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        novoCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        novoCaixa.setIconTextGap(10);
        novoCaixa.setInheritsPopupMenu(true);
        novoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel4))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(abrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(dataAbertura)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PainelGeralLayout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(dataFechamento))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PainelGeralLayout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(43, 43, 43)
                                            .addComponent(valorDebito))
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PainelGeralLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(39, 39, 39)
                                            .addComponent(valorCredito))
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PainelGeralLayout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(43, 43, 43)
                                            .addComponent(valorCedula))
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PainelGeralLayout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(35, 35, 35)
                                            .addComponent(valorFechamento))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152))))
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(PainelGeralLayout.createSequentialGroup()
                                        .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pesquisarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7)
                            .addComponent(valorAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(statusCaixa))
                            .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(539, 539, 539)
                        .addComponent(novoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusCaixa))
                .addGap(30, 30, 30)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelGeralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dataAbertura))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dataFechamento))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(valorDebito))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(valorCredito))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(valorCedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(valorFechamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecharCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(abrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(novoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFuncionarioActionPerformed

    private void valorAberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorAberturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorAberturaActionPerformed

    private void abrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCaixaActionPerformed

    }//GEN-LAST:event_abrirCaixaActionPerformed

    private void pesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarioActionPerformed

    }//GEN-LAST:event_pesquisarFuncionarioActionPerformed

    private void fecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharCaixaActionPerformed

    }//GEN-LAST:event_fecharCaixaActionPerformed

    private void novoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novoCaixaActionPerformed

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
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaixaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JButton abrirCaixa;
    private javax.swing.JLabel dataAbertura;
    private javax.swing.JLabel dataFechamento;
    private javax.swing.JButton fecharCaixa;
    private javax.swing.JTextField idFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField nomeFuncionario;
    private javax.swing.JButton novoCaixa;
    private javax.swing.JPanel painelStatus;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JButton pesquisarFuncionario;
    private javax.swing.JLabel statusCaixa;
    private javax.swing.JTextField valorAbertura;
    private javax.swing.JLabel valorCedula;
    private javax.swing.JLabel valorCredito;
    private javax.swing.JLabel valorDebito;
    private javax.swing.JLabel valorFechamento;
    // End of variables declaration//GEN-END:variables
}
