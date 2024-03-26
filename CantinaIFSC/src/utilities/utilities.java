
package utilities;

import controller.FeedbackEnderecoController;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.text.MaskFormatter;
import view.FeedbackENDERECO;

public class Utilities {
    
    public static void active(boolean active, JPanel painel) {
        
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {   
            if(componente instanceof JButton){
                if(((JButton) componente).getActionCommand()=="0"){
                    componente.setEnabled(!active);
                    
                }
                else if(((JButton) componente).getActionCommand()=="1"){
                componente.setEnabled(active);}
                
            }
            
            
        }
        
    }
    
    public static void limpaComponentes(boolean ativa, JPanel painel) {
        
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {
            
            if(componente instanceof JTextField){
                ((JTextField) componente).setText("");
                ((JTextField) componente).setBackground(new Color(231,231,231));
               ((JTextField) componente).setBorder(BorderFactory.createLineBorder(new Color(231,231,231), 10, true));
            }else if(componente instanceof JFormattedTextField){
                ((JFormattedTextField) componente).setBackground(new Color(231,231,231));
                ((JFormattedTextField) componente).setText("");
                ((JFormattedTextField) componente).setBorder(BorderFactory.createLineBorder(new Color(231,231,231), 10, true));
            }else if (componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedIndex(0);
            }else if (componente instanceof JRadioButton){
                ((JRadioButton) componente).setSelected(false);
            }
            componente.setEnabled(ativa);
            
            
        }
        
    }
    
    public static java.sql.Date stringToDate(String data){
        
        java.sql.Date dataSQL = null;

        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(data);
            
            dataSQL = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataSQL;
        
    }
    
    public static String stringToDateTime(String Antigadata) throws ParseException{
        
        Date dataSQL = null;

        
        SimpleDateFormat old = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date utilDate = old.parse(Antigadata);
        
        return newDate.format(utilDate);
        
    }
    
     public static String converterFormato(String dataHoraOriginal) {
        try {
            // Criar um objeto SimpleDateFormat para o formato de entrada
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            // Converter a string de data e hora para um objeto Date
            Date data = formatoEntrada.parse(dataHoraOriginal);

            // Criar um objeto SimpleDateFormat para o formato de saída desejado
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            // Formatar a data no novo formato
            return formatoSaida.format(data);

        } catch (ParseException e) {
            // Tratar exceções de análise (por exemplo, formato de entrada inválido)
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static boolean isDataEmpty(JTextField... campos){
        
        boolean verify = false;
        for (JTextField campo : campos) {
            
            if(campo.getText().equals("")||campo.getBackground().equals(new Color(248,199,197))){
              campo.setBackground(new Color(248,199,197));
              campo.setBorder(BorderFactory.createLineBorder(new Color(248,199,197), 10, true));
              campo.setText("*Campo obrigatório*");
              verify=true;
            }
        }   
        return verify;
    }
    
    public static boolean isFormattedDataEmpty(JFormattedTextField... campos){
        
        boolean verify = false;
        for (JFormattedTextField campo : campos) {
            
            
            if(campo.getValue()==null||campo.getBackground().equals(new Color(248,199,197))){
              campo.setBackground(new Color(248,199,197));
              campo.setBorder(BorderFactory.createLineBorder(new Color(248,199,197), 10, true));
              campo.setText("*Campo obrigatório*");
              verify=true;
            }
        }   
        return verify;
    }
    
    
    
    public static void turnTextFieldRed(JTextField textField){
       if(textField.getText().trim().isEmpty()){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
           textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
       }
       
       
    }
    public static void turnTextFieldGray(JTextField textField){
        Color corErro = new Color(231,231,231);
        if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setText(null);

        }
        textField.setBackground(corErro);
        textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
           
       
    }
    
    public static void turnCepTextFieldRed(JFormattedTextField textField){
        
        String maskString=textField.getText();
        
       if(textField.getValue()==null){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
           textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
       }
       
    }
    public static void turnCepTextFieldGray(JFormattedTextField textField){
        
        
        Color corErro = new Color(231,231,231);
        if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
            textField.setValue(null);
        }
        textField.setBackground(corErro);
        textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
        
        
    }
    
    public static void turnCpfTextFieldRed(JFormattedTextField textField){
       if(textField.getText().equalsIgnoreCase("   .   .   -  ")){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
           textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
       }
       
    }
    public static void turnDateTextFieldGray(JFormattedTextField textField){
       Color corErro = new Color(231,231,231); 
       if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setValue(null);

        }
       textField.setBackground(corErro);
       textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
    }
    
    public static void turnPhoneTextFieldRed(JFormattedTextField textField){
       if(textField.getText().trim().isEmpty()){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
           textField.setBorder(BorderFactory.createLineBorder(corErro, 10, true));
       }
       
    }
    public static void turnPhoneTextFieldGray(JFormattedTextField textField){
       Color corErro = new Color(231,231,231); 
       if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setValue(null);

        }
       textField.setBackground(corErro);
    }
   
   
    
    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    public static void feedbackErros(int condicao){
        FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                FeedbackEnderecoController.codigoFB=condicao;
                feedbackEnderecoController.atualizacaoLabel();
                feedbackENDERECO.setVisible(true);
    }
    
     
}
