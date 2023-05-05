
package utilities;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import view.TemplateRegistro;

public class utilities {
    
    public static void active(boolean active, JPanel painel) {
        
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {   
            if(componente instanceof JButton){
                if(((JButton) componente).getActionCommand()=="0"){
                    componente.setEnabled(!active);
                    
                }
                else{
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
                ((JComboBox) componente).setSelectedIndex(-1);
            }else if (componente instanceof JRadioButton){
                ((JRadioButton) componente).setSelected(false);
            }
            componente.setEnabled(ativa);
            
            
        }
        
    }
    
}
