/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Login;

import View.Gui.Verificacao.Verificacao;
import creche.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        
        
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Logar();

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a ação :" + ex);
                }
            }
        });
        
        btnCadastro.addActionListener((ActionEvent e) -> {
            try {
                this.dispose();
                CadastrarLogin();

            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao carregar a tela de cadastro :" + ex);
            }
        });

      
    }

    
    private  synchronized void Logar() throws ParseException {
        String nome = txtLogin.getText();
        String senha = txtSenha.getText();

        Verificacao verificacao = new Verificacao(nome, senha);

       
        if (verificacao.Acessa(nome, senha) == true) {
            this.dispose();
            menu menu = new menu();

        }

    }
    
    private void CadastrarLogin() throws ParseException {
        cadastroLogin cadastrologin = new cadastroLogin();
        
    }


    public void run() {
        try {
            this.Logar();
        } catch (ParseException ex) {
            Logger.getLogger(loginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
