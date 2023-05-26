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


public class cadastroLogin extends JFrame {
    
   //1° passo
    public JLabel lblLogin, lblSenha;
    public JTextField txtLogin, txtSenha;
    public JButton btnCadastrar;
    public JButton btnVoltar;
    
    public cadastroLogin() throws ParseException{
    
              setLayout(null);

        //---------------------------------------------Parente 1 ----------------------------------------------------------
        // 2° passo
        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
                
     
        
        btnCadastrar = new JButton("Cadastrar Login");
        
        btnVoltar = new JButton("Voltar");
        
        
        lblLogin.setBounds(10, 40, 200, 25);
        txtLogin.setBounds(80, 40, 250, 25);
        lblSenha.setBounds(10, 80, 200, 25);
        txtSenha.setBounds(80, 80, 250, 25);
        btnCadastrar.setBounds(30,160, 150, 40);
        btnVoltar.setBounds(210,160, 150, 40);
       

      
        getContentPane().add(lblLogin);
        getContentPane().add(txtLogin);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnCadastrar);
        getContentPane().add(btnVoltar);
        
      
        setSize(400, 400);
        setTitle("Cadastro Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnVoltar.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      try {cliqueVoltarLogin();}
                      catch (ParseException ex) {
                          Logger.getLogger(cadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
 });
    }
    
    private void cliqueVoltarLogin() throws ParseException{
       
       this.dispose();
       
        loginSenha loginSenha = new loginSenha ();
    }

}
