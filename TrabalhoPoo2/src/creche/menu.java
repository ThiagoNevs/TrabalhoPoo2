/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


public class menu extends JFrame{
    
    public JButton btnCadastroResp;
    public JButton btnEntrarCrian;
    
    public menu() throws ParseException{
    
              setLayout(null);
              
              
        btnCadastroResp = new JButton("Cadastrar Responsável");
        
        btnEntrarCrian = new JButton("Cadastrar Criança");
        
        
        btnCadastroResp.setBounds(20,50, 200, 40);
        btnEntrarCrian.setBounds(270,50, 200, 40);
           
        getContentPane().add(btnCadastroResp);
        getContentPane().add(btnEntrarCrian);
        
        
        setSize(500, 200);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
      btnCadastroResp.addActionListener(new ActionListener () {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      try {
                          cliqueCadastroResp();
                      } catch (ParseException ex) {
                          Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
          
      });
      
       btnEntrarCrian.addActionListener(new ActionListener () {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      try {
                          cliqueCadastroCrian();
                      } catch (ParseException ex) {
                          Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
          
      });
        
        
    }    
    
      private void cliqueCadastroResp()  throws ParseException{
       
       this.dispose();
       parentes parentes = new parentes();
    }
      
       private void cliqueCadastroCrian()  throws ParseException{
       
       this.dispose();
       crianca crianca = new crianca();
    }
      
    
}
