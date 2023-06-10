/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Menu;

import View.Gui.Login.loginSenha;
import View.Gui.Parentes.inserirParentes;
import SingletonConnection.Crianca;
import SingletonConnection.Parentes;
import View.Gui.Crianca.atualizarCrianca;
import View.Gui.Crianca.deletarCrianca;
import View.Gui.Crianca.inserirCrianca;
import View.Gui.Parentes.atualizarParentes;
import View.Gui.Parentes.deletarParentes;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class menu extends JFrame {

    private final JButton btn_cadCrianca, btn_cadParentes;
    private final JButton btn_mostrarCrianca, btn_mostrarParentes;
    private final JButton btn_alterarCrianca, btn_alterarParentes;
    private final JButton btn_deletaCrianca, btn_deletaParentes, btn_sair;

    public menu() {
      
        setLayout(null);
       
        
        btn_cadCrianca = new JButton("Cadastrar Criança");
        btn_cadParentes = new JButton("Cadastrar Parentes");
       

        btn_mostrarCrianca = new JButton("Mostrar Criança");
        btn_mostrarParentes = new JButton("Mostrar Parentes");
        
        
        btn_alterarCrianca = new JButton("Atualizar Criança");
        btn_alterarParentes = new JButton("Atualizar Parentes");
       

        btn_deletaCrianca = new JButton("Deletar Criança");
        btn_deletaParentes = new JButton("Deletar Parentes");
      
        btn_sair = new JButton("Sair");

        btn_cadCrianca.setBounds(20, 20, 150, 30);
        btn_cadParentes.setBounds(20, 60, 150, 30);
       btn_mostrarCrianca.setBounds(20, 140, 150, 30);
        btn_mostrarParentes.setBounds(20, 180, 150, 30);
        
        btn_alterarCrianca.setBounds(300, 20, 150, 30);
        btn_alterarParentes.setBounds(300, 60, 150, 30);
        
        btn_deletaCrianca.setBounds(300, 140, 150, 30);
        btn_deletaParentes.setBounds(300, 180, 150, 30);
        
        btn_sair.setBounds(300, 300, 150, 30);

    
        getContentPane().add(btn_cadCrianca);
        getContentPane().add(btn_cadParentes);
        
        getContentPane().add(btn_mostrarCrianca);
        getContentPane().add(btn_mostrarParentes);
        
        getContentPane().add(btn_alterarCrianca);
        getContentPane().add(btn_alterarParentes);
        
        getContentPane().add(btn_deletaCrianca);
        getContentPane().add(btn_deletaParentes);
  
        add(btn_sair);

        setSize(500, 400);
        setTitle("Menu");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
             
        btn_cadCrianca.addActionListener((ActionEvent e) -> {
            try {
                inserirCrianca();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_mostrarCrianca.addActionListener((ActionEvent e) -> {
            mostrarCrianca();
        });

        btn_alterarCrianca.addActionListener((ActionEvent e) -> {
            atualizarCrianca();
        });
        
        btn_deletaCrianca.addActionListener((ActionEvent e) -> {
            deletarCrianca();
        });

        
        btn_cadParentes.addActionListener((ActionEvent e) -> {
            try {
                inserirParentes();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_alterarParentes.addActionListener((ActionEvent e) -> {
            try {
                atualizarParentes();
            } catch (ParseException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
               
        btn_deletaParentes.addActionListener((ActionEvent e) -> {
            deletarParentes();
        });

        btn_mostrarParentes.addActionListener((ActionEvent e) -> {
            try {
                mostrarParentes();
            } catch (ParseException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         btn_sair.addActionListener((ActionEvent e) -> {
            try {
                sair();
            } catch (ParseException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });


    }

   
    private void inserirCrianca() throws ParseException {
        this.dispose();
        inserirCrianca inserirCrianca = new inserirCrianca();
    }

    private void mostrarCrianca() {
        Crianca crianca = new Crianca();
        crianca.mostrar();
    }

    private void atualizarCrianca() {

        try {
            this.dispose();
            atualizarCrianca atualizarCrianca = new atualizarCrianca();
        } catch (ParseException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deletarCrianca() {
        this.dispose();
        deletarCrianca deletarCrianca = new deletarCrianca();
    }

    
    private void inserirParentes() throws ParseException {
        this.dispose();
        inserirParentes inserirParentes = new inserirParentes();
    }

    private void mostrarParentes() throws ParseException {
        Parentes parentes = new Parentes();
        parentes.mostrar();
    }

    private void atualizarParentes() throws ParseException {
        this.dispose();

        atualizarParentes atualizarparentes = new atualizarParentes();       
    }

    private void deletarParentes() {
        this.dispose();
        deletarParentes deletarParentes = new deletarParentes();
    }

   
    private void sair() throws ParseException {
        this.dispose();
        loginSenha login = new loginSenha();
    }
}
