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
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jrthi
 */
public class loginSenha extends JFrame {
    
 //1° passo
    public JLabel lblLogin, lblSenha;
    public JTextField txtLogin, txtSenha;
    public JButton btnCadastro;
    public JButton btnEntrar;
    
    public loginSenha() throws ParseException{
    
              setLayout(null);

        //---------------------------------------------Parente 1 ----------------------------------------------------------
        // 2° passo
        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
                
     
        
        btnCadastro = new JButton("Cadastrar");
        
        btnEntrar = new JButton("Entrar");
        
        
        lblLogin.setBounds(10, 40, 200, 25);
        txtLogin.setBounds(80, 40, 250, 25);
        lblSenha.setBounds(10, 80, 200, 25);
        txtSenha.setBounds(80, 80, 250, 25);
        btnCadastro.setBounds(30,160, 150, 40);
        btnEntrar.setBounds(210,160, 150, 40);
       

      
        getContentPane().add(lblLogin);
        getContentPane().add(txtLogin);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnCadastro);
        getContentPane().add(btnEntrar);
        
      
        setSize(400, 300);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        btnCadastro.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      try { cliqueCadastrar();
                      } catch (ParseException ex) {
                          Logger.getLogger(loginSenha.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
            
        });
        
        
    }
    
     private void cliqueCadastrar()  throws ParseException{
       
       this.dispose();
       
       cadastroLogin cadastroLogin = new cadastroLogin();
     }
   
}

