/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Parentes;

import SingletonConnection.Parentes;
import creche.menu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jrthi
 */
/**
 *
 * @author jrthi
 */
public class deletarParentes extends JFrame{

    private final  JLabel lbl_delete;
    private final  JTextField txtNome;
    private final JButton btn_dlt;
    private final JButton btn_vlt;
    
    public deletarParentes() {
             
        setLayout(null);
        
        lbl_delete = new JLabel("Digite o nome do parente:");
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
        setTitle("Deletar Cadastro Responsável");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          btn_dlt.addActionListener((ActionEvent e) -> {
            deletarParente();
        });
        
        btn_vlt.addActionListener((ActionEvent e) -> {
            voltarMenu();
        });
        
    
    }
    
    private void deletarParente(){
      
       String nome = txtNome.getText();
       Parentes parentes = new Parentes();
       parentes.deletar(nome);
    }
    
    private void voltarMenu(){
        this.dispose();
        menu menu = new menu();
    }
    
}
