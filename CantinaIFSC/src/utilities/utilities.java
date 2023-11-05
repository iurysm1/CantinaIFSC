
package utilities;

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
            }else if(componente instanceof JFormattedTextField){
                ((JFormattedTextField) componente).setText("");
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
    
   
    
    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    
}
