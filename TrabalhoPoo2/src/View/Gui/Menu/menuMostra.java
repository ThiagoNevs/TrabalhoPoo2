/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jrthi
 */

public class menuMostra extends JFrame {
    
    public JButton btnMostraPais;
    public JButton btnMostraCrian;
    public JButton btnMenu;
    
    
    public menuMostra() throws ParseException{
      setLayout (null);
       
       
     btnMostraPais = new JButton ("Responsáveis");
    
     btnMostraCrian = new JButton ("Crianças");
     
     btnMenu = new JButton ("Voltar ao menu");
     
     btnMostraPais.setBounds(20,50, 200, 40);
     btnMostraCrian.setBounds(270,50, 200, 40);
     btnMenu.setBounds(150,150, 200, 40);
     
     getContentPane().add(btnMostraPais);
     getContentPane().add(btnMostraCrian);
     getContentPane().add(btnMenu);
     
        setSize(500, 300);
        setTitle("Menu de Cadastrados");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      btnMenu.addActionListener(new ActionListener(){
                  @Override
                public void actionPerformed(ActionEvent e) {
                      try {
                          cliqueMenu();
                      } catch (ParseException ex) {
                          Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              });
    
        }
                

    private void cliqueMenu()  throws ParseException{
       
       this.dispose();
        menu menu = new menu();
    }
    
    
    
}
