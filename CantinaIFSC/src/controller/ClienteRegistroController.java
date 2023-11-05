package controller;

import static controller.FuncionarioRegistroController.idEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.bo.Cliente;
import model.bo.Endereco;
import utilities.Utilities;
import view.ClientePesquisa;
import view.ClienteRegistro;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FeedbackENDERECO;
import model.DAO.Persiste;
import service.BairroService;
import service.ClienteService;
import service.EnderecoService;

public class ClienteRegistroController implements ActionListener {

    ClienteRegistro clienteRegistro;
    public static int codigo, codigoEndereco, idEndereco;
    
    FocusListener focus = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(!clienteRegistro.getCep().getText().equalsIgnoreCase("     -   ")){
                clienteRegistro.getCep().setText("     -   ");
            }
        }
    };

    public ClienteRegistroController(ClienteRegistro clienteRegistro) {

        this.clienteRegistro = clienteRegistro;

        this.clienteRegistro.getSair().addActionListener(this);
        this.clienteRegistro.getNovo().addActionListener(this);
        this.clienteRegistro.getGravar().addActionListener(this);
        this.clienteRegistro.getCancelar().addActionListener(this);
        this.clienteRegistro.getPesquisar().addActionListener(this);
        this.clienteRegistro.getNovoCep().addActionListener(this);
        this.clienteRegistro.getPesquisarCep().addActionListener(this);
        this.clienteRegistro.getCep().addFocusListener(focus);

        Utilities.active(true, this.clienteRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());
    }
    
    
    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {

            if (codigo != 0) {
                Cliente cliente = new Cliente();
                cliente = ClienteService.carregar(codigo);
                Utilities.active(false, clienteRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, clienteRegistro.getPainelDados());

                clienteRegistro.getId().setText(cliente.getId() + "");
                clienteRegistro.getNome().setText(cliente.getNome());
                clienteRegistro.getData().setText(cliente.getDataNascimento());
                clienteRegistro.getCpf1().setText(cliente.getCpf());
                clienteRegistro.getRg().setText(cliente.getRg());
                clienteRegistro.getMatricula().setText(cliente.getMatricula());
                clienteRegistro.getFone1().setText(cliente.getFone1());
                clienteRegistro.getFone2().setText(cliente.getFone2());
                clienteRegistro.getEmail().setText(cliente.getEmail());
                clienteRegistro.getComplemento().setText(cliente.getComplementoEndereco());

                clienteRegistro.getCep().setText(cliente.getEndereco().getCep());
                clienteRegistro.getLogradouro().setText(cliente.getEndereco().getLogradouro());
                clienteRegistro.getCidade().setText(cliente.getEndereco().getCidade().getDescricao());
                clienteRegistro.getUf().setText(cliente.getEndereco().getCidade().getUf());
                clienteRegistro.getBairro().setText(cliente.getEndereco().getBairro().getDescricao());
                clienteRegistro.getId().setEnabled(false);
                clienteRegistro.getLogradouro().setEnabled(false);

                clienteRegistro.getUf().setEnabled(false);
                clienteRegistro.getCidade().setEnabled(false);
                clienteRegistro.getBairro().setEnabled(false);
                
                if(cliente.getStatus().equalsIgnoreCase("A")){
                    clienteRegistro.getStatus().setSelectedIndex(0);
                }else{
                    clienteRegistro.getStatus().setSelectedIndex(1);
                }
                
                
                idEndereco=cliente.getEndereco().getId();
            }
        }

    };
    WindowListener disposeListenerEndereco = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = EnderecoService.carregar(codigoEndereco);
                idEndereco=endereco.getId();
                Utilities.active(false, clienteRegistro.getPainelBotoes());

                clienteRegistro.getCep().setText(endereco.getCep());
                clienteRegistro.getLogradouro().setText(endereco.getLogradouro());
                clienteRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                clienteRegistro.getUf().setText(endereco.getCidade().getUf());
                clienteRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                clienteRegistro.getLogradouro().setEnabled(false);

                clienteRegistro.getUf().setEnabled(false);
                clienteRegistro.getCidade().setEnabled(false);
                clienteRegistro.getBairro().setEnabled(false);

            }

        }

    };
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clienteRegistro.getSair()) {
            this.clienteRegistro.dispose();
        } else if (e.getSource() == this.clienteRegistro.getPesquisar()) {
            ClientePesquisa clientePesquisa = new ClientePesquisa();
            ClientePesquisaController clientePesquisaController = new ClientePesquisaController(clientePesquisa);
            clientePesquisa.addWindowListener(disposeListener);
            clientePesquisa.setVisible(true);

        } else if (e.getSource() == this.clienteRegistro.getNovo()) {
            Utilities.active(false, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.clienteRegistro.getPainelDados());

            clienteRegistro.getId().setEnabled(false);
            clienteRegistro.getLogradouro().setEnabled(false);

            clienteRegistro.getUf().setEnabled(false);
            clienteRegistro.getCidade().setEnabled(false);
            clienteRegistro.getBairro().setEnabled(false);
            
            System.out.println(this.clienteRegistro.getCep().getText());
        } else if (e.getSource() == this.clienteRegistro.getGravar()) {
            Cliente cliente = new Cliente();
            
            cliente.setNome(this.clienteRegistro.getNome().getText());
            cliente.setCpf(this.clienteRegistro.getCpf1().getText());
            cliente.setRg(this.clienteRegistro.getRg().getText());
            cliente.setMatricula(this.clienteRegistro.getMatricula().getText());
            cliente.setFone1(this.clienteRegistro.getFone1().getText());
            cliente.setFone2(this.clienteRegistro.getFone1().getText());
            cliente.setEmail(this.clienteRegistro.getEmail().getText());
            cliente.setDataNascimento(this.clienteRegistro.getData().getText());
            cliente.setComplementoEndereco(this.clienteRegistro.getComplemento().getText());
            cliente.setEndereco(EnderecoService.carregar(idEndereco));
            
            if(this.clienteRegistro.getStatus().getSelectedIndex()==0){
                cliente.setStatus("A");
            }else{
                cliente.setStatus("D");
            }
            
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);

            
            if(this.clienteRegistro.getId().getText().equalsIgnoreCase("")){
                ClienteService.adicionar(cliente);
                feedbackController.cadastroClasse(6);
            }else{
                cliente.setId(codigo);
                ClienteService.atualizar(cliente);
                feedbackController.atualizacaoClasse(6);
            }
            
            feedback.setVisible(true);
            Utilities.active(true, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());

        } else if (e.getSource() == this.clienteRegistro.getCancelar()) {
            
                            

            Utilities.active(true, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());

        } else if (e.getSource() == this.clienteRegistro.getNovoCep()) {
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);

        } else if (e.getSource() == this.clienteRegistro.getPesquisarCep()) {
            
            if(this.clienteRegistro.getCep().getText().equalsIgnoreCase("     -   ")){
                EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
                EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
                idEndereco=0;
                enderecoPesquisa.addWindowListener(disposeListenerEndereco);
                enderecoPesquisa.setVisible(true);
            }else{
                
                boolean validacao=true;
                for (Endereco enderecoAtual : EnderecoService.carregar()) {
                    if(enderecoAtual.getCep().equalsIgnoreCase(this.clienteRegistro.getCep().getText())){
                        validacao=false;
                    }
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }else{
                        Endereco enderecoPesquisa = EnderecoService.carregarCEP(this.clienteRegistro.getCep().getText());
                        idEndereco=enderecoPesquisa.getId();
                        this.clienteRegistro.getBairro().setText(enderecoPesquisa.getBairro().getDescricao());
                        this.clienteRegistro.getCidade().setText(enderecoPesquisa.getCidade().getDescricao());
                        this.clienteRegistro.getUf().setText(enderecoPesquisa.getCidade().getUf());
                        this.clienteRegistro.getLogradouro().setText(enderecoPesquisa.getLogradouro());
                        this.clienteRegistro.getCep().setText(enderecoPesquisa.getCep());
                }
                
                
                
                
            }
        }
            

    }

}
