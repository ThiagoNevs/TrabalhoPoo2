/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Crianca;

import SingletonConnection.Crianca;
import View.Gui.Menu.menu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jrthi
 */
public class deletarCrianca extends JFrame{

    private final  JLabel lbl_delete;
    private final  JTextField txtNome;
    private final JButton btn_dlt;
    private final JButton btn_vlt;
    
    public deletarCrianca() {
        setLayout(null);
      
        
        lbl_delete = new JLabel("Digite o nome da criança:");
        txtNome = new JTextField("");
        
        btn_dlt = new JButton("Deletar");
        btn_vlt = new JButton("Voltar");
        
       
       
        
        lbl_delete.setBounds(10, 40, 200, 25);
        txtNome.setBounds(160, 40, 250, 25);
        btn_dlt.setBounds(40,90, 150, 40);
        btn_vlt.setBounds(240,90, 150, 40);
       
        
        
        getContentPane().add(lbl_delete);
        getContentPane().add(txtNome);
        getContentPane().add(btn_dlt);
        getContentPane().add(btn_vlt);
        
        
        
        setSize(450, 200);
        setTitle("Deletar Cadastro Criança");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          btn_dlt.addActionListener((ActionEvent e) -> {
            deletar();
        });
        
        btn_vlt.addActionListener((ActionEvent e) -> {
            voltarMenu();
        });
        
    
    }
    
    private void deletar(){
      
       String nome = txtNome.getText();
       Crianca crianca = new Crianca();
       crianca.deletar(nome);
    }
    
    private void voltarMenu(){
        this.dispose();
        menu menu = new menu();
    }
    
}
