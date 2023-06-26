package controller;

import static controller.FuncionarioRegistroController.idEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.bo.Endereco;
import model.bo.Fornecedor;
import utilities.Utilities;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FeedbackENDERECO;
import view.FornecedorPesquisa;
import view.FornecedorRegistro;

public class FornecedorRegistroController implements ActionListener {

    FornecedorRegistro fornecedorRegistro;
    public static int codigo, codigoEndereco, idEndereco;

    public FornecedorRegistroController(FornecedorRegistro fornecedorRegistro) {
        this.fornecedorRegistro = fornecedorRegistro;

        this.fornecedorRegistro.getNovo().addActionListener(this);
        this.fornecedorRegistro.getGravar().addActionListener(this);
        this.fornecedorRegistro.getCancelar().addActionListener(this);
        this.fornecedorRegistro.getPesquisar().addActionListener(this);
        this.fornecedorRegistro.getSair().addActionListener(this);
        this.fornecedorRegistro.getPesquisarCep().addActionListener(this);
        this.fornecedorRegistro.getAdicionarCep().addActionListener(this);

        Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());

    }

    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = DAO.Persiste.fornecedores.get(codigo - 1);
                Utilities.active(false, fornecedorRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, fornecedorRegistro.getPainelDados());

                fornecedorRegistro.getId().setText(fornecedor.getId() + "");
                fornecedorRegistro.getNome().setText(fornecedor.getNome());// ou razao social
                fornecedorRegistro.getEmail().setText(fornecedor.getEmail());
                fornecedorRegistro.getCnpj().setText(fornecedor.getCnpj());
                fornecedorRegistro.getFone1().setText(fornecedor.getFone1());
                fornecedorRegistro.getFone2().setText(fornecedor.getFone2());
                fornecedorRegistro.getInscricaoEstadual().setText(fornecedor.getInscricaoestadual());

                fornecedorRegistro.getCep().setText(fornecedor.getEndereco().getCep());
                fornecedorRegistro.getUf().setText(fornecedor.getEndereco().getCidade().getUf());
                fornecedorRegistro.getCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
                fornecedorRegistro.getBairro().setText(fornecedor.getEndereco().getBairro().getDescricao());
                fornecedorRegistro.getLogradouro().setText(fornecedor.getEndereco().getLogradouro());
                fornecedorRegistro.getComplemento().setText(fornecedor.getComplementoEndereco());

                fornecedorRegistro.getId().setEnabled(false);
                fornecedorRegistro.getUf().setEnabled(false);
                fornecedorRegistro.getCidade().setEnabled(false);
                fornecedorRegistro.getBairro().setEnabled(false);
                fornecedorRegistro.getLogradouro().setEnabled(false);
            }
        }
    };
    WindowListener disposeListenerEndereco=new WindowAdapter() {
    
        @Override
        public void windowClosed(WindowEvent e){
            if(codigoEndereco!=0){
                Endereco endereco = new Endereco();
                endereco=DAO.Persiste.enderecos.get(codigoEndereco-1);
                idEndereco=endereco.getId()-1;
                
                fornecedorRegistro.getCep().setText(endereco.getCep());
                fornecedorRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                fornecedorRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                fornecedorRegistro.getUf().setText(endereco.getCidade().getUf());
                fornecedorRegistro.getLogradouro().setText(endereco.getLogradouro());
            }
            
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fornecedorRegistro.getNovo()) {
            Utilities.active(false, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.fornecedorRegistro.getPainelDados());

            fornecedorRegistro.getId().setEnabled(false);
            fornecedorRegistro.getUf().setEnabled(false);
            fornecedorRegistro.getCidade().setEnabled(false);
            fornecedorRegistro.getBairro().setEnabled(false);
            fornecedorRegistro.getLogradouro().setEnabled(false);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getGravar()) {
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setId(DAO.Persiste.fornecedores.size()+1);
            fornecedor.setInscricaoestadual(this.fornecedorRegistro.getInscricaoEstadual().getText());
            fornecedor.setNome(this.fornecedorRegistro.getNome().getText());
            fornecedor.setEmail(this.fornecedorRegistro.getEmail().getText());
            fornecedor.setCnpj(this.fornecedorRegistro.getCnpj().getText());
            fornecedor.setFone1(this.fornecedorRegistro.getFone1().getText());
            fornecedor.setFone2(this.fornecedorRegistro.getFone2().getText());
            fornecedor.setComplementoEndereco(this.fornecedorRegistro.getComplemento().getText());
            
            fornecedor.setEndereco(DAO.Persiste.enderecos.get(idEndereco));
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            if(this.fornecedorRegistro.getId().getText().equalsIgnoreCase("")){
                DAO.Persiste.fornecedores.add(fornecedor);
                feedbackController.codigoFB=8;
                feedbackController.cadastroClasse();
            }else{
                int index=Integer.parseInt(this.fornecedorRegistro.getId().getText())-1;
                
                DAO.Persiste.fornecedores.get(index).setNome(this.fornecedorRegistro.getNome().getText());
                DAO.Persiste.fornecedores.get(index).setInscricaoestadual(this.fornecedorRegistro.getInscricaoEstadual().getText());
                DAO.Persiste.fornecedores.get(index).setEmail(this.fornecedorRegistro.getEmail().getText());
                DAO.Persiste.fornecedores.get(index).setCnpj(this.fornecedorRegistro.getCnpj().getText());
                DAO.Persiste.fornecedores.get(index).setFone1(this.fornecedorRegistro.getFone1().getText());
                DAO.Persiste.fornecedores.get(index).setFone2(this.fornecedorRegistro.getFone2().getText());
                DAO.Persiste.fornecedores.get(index).setEndereco(DAO.Persiste.enderecos.get(idEndereco));
                DAO.Persiste.fornecedores.get(index).setComplementoEndereco(this.fornecedorRegistro.getComplemento().getText());
                
                feedbackController.codigoFB=8;
                feedbackController.atualizacaoClasse();
            }
            
            feedback.setVisible(true);
            Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getCancelar()) {
            Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getSair()) {
            this.fornecedorRegistro.dispose();
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getPesquisar()) {
            FornecedorPesquisa fornecedorPesquisa = new FornecedorPesquisa();
            FornecedorPesquisaController fornecedorPesquisaController = new FornecedorPesquisaController(fornecedorPesquisa);
            fornecedorPesquisa.addWindowListener(disposeListener);
            fornecedorPesquisa.setVisible(true);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getAdicionarCep()) {
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getPesquisarCep()) {
            boolean validacao=true;
            if(this.fornecedorRegistro.getCep().getText().equalsIgnoreCase("")){
            EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.addWindowListener(disposeListenerEndereco);
            enderecoPesquisa.setVisible(true);
            
        }else{
             validacao=true;
                for (Endereco enderecoAtual : DAO.Persiste.enderecos) {
                    if(enderecoAtual.getCep().equalsIgnoreCase(this.fornecedorRegistro.getCep().getText())){
                        idEndereco=enderecoAtual.getId()-1;
                        this.fornecedorRegistro.getCep().setText(enderecoAtual.getCep());
                        this.fornecedorRegistro.getBairro().setText(enderecoAtual.getBairro().getDescricao());
                        this.fornecedorRegistro.getCidade().setText(enderecoAtual.getCidade().getDescricao());
                        this.fornecedorRegistro.getLogradouro().setText(enderecoAtual.getLogradouro());
                        this.fornecedorRegistro.getUf().setText(enderecoAtual.getCidade().getDescricao());
                        validacao=false;
                    }
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }   
            }
        }
    }

}
