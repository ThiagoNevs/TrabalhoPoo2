/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creche;

import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class menu extends JFrame{
    
    public JButton btnCadastro;
    public JButton btnEntrar;
    
    public menu() throws ParseException{
    
              setLayout(null);


     
        
        btnCadastro = new JButton("Cadastrar Responsável");
        
        btnEntrar = new JButton("Cadastrar Criança");
        
        
       
        btnCadastro.setBounds(20,50, 200, 40);
        btnEntrar.setBounds(270,50, 200, 40);
       

      
       
        getContentPane().add(btnCadastro);
        getContentPane().add(btnEntrar);
        
      
        setSize(500, 200);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }    
    
    
}
