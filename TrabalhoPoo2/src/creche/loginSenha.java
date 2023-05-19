/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creche;

import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
                
     
        
        btnCadastro = new JButton("Cadastrar Login");
        
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
        
      
        setSize(400, 400);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    
   
    
}   


