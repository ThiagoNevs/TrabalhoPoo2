/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Crianca;

import SingletonConnection.Crianca;
import View.Gui.TelaPadrao.TelaPadrao;
import creche.menu;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author jrthi
 */
public class atualizarCrianca extends TelaPadrao {
    
        private final JLabel lblNome;
        private final JLabel lblCpf;
        private final JLabel lbltipoSangue;
        private final JLabel lblaltura,lblserie;
        private final JTextField txtNome;
        private final JFormattedTextField ftxtCpf;    
        private final JTextField txttipoSangue;
        private final JComboBox jaltura;
        private final JComboBox jserie;
        private final JButton btnAtualizar;
        private final JButton btnMenu;
    
       private final String[] saltura = {"1.51", "1.45", "1.42", "1.39", "1.33","1.20"};
       private final String[] sjserie = {"1","2", "3" ,"4" , "5"};

   
               public atualizarCrianca() throws ParseException{
   
       setLayout(null);
       
       lblNome = new JLabel("Nome:");
       txtNome = new JTextField();
       lblCpf = new JLabel("CPF:");
       ftxtCpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
       lbltipoSangue = new JLabel("Tipo Sangue:");
       txttipoSangue = new JTextField();
       
       lblaltura = new JLabel("Altura:");
       jaltura = new JComboBox(saltura);
       lblserie = new JLabel("Série:");
       jserie = new JComboBox(sjserie);
       btnAtualizar = new JButton("Atualizar");
       btnMenu = new JButton("Menu");
       
    
       lblNome.setBounds(10, 10, 200, 25);
       txtNome.setBounds(70, 10, 250, 25);
       lblCpf.setBounds(10, 60, 200, 25);
       ftxtCpf.setBounds(70, 60, 250, 25);
       lbltipoSangue.setBounds(10, 110, 200, 25);
       txttipoSangue.setBounds(90, 110, 230, 25);
       lblserie.setBounds(10,160, 200, 25);
       jserie.setBounds(90, 160, 200, 25);
       lblaltura.setBounds(10, 230, 200 , 25);
       jaltura.setBounds(90, 230, 200, 25);
       btnAtualizar.setBounds(155, 300, 100, 40);
       btnMenu.setBounds(270, 300, 100, 40);
       
       
       getContentPane().add(lblNome);
       getContentPane().add(txtNome);
       getContentPane().add(lblCpf);
       getContentPane().add(ftxtCpf);
       getContentPane().add(lbltipoSangue);
       getContentPane().add(txttipoSangue);
       getContentPane().add(lblserie);
       getContentPane().add(jserie);
       getContentPane().add(lblaltura);
       getContentPane().add(jaltura);
       getContentPane().add(btnAtualizar);
       getContentPane().add(btnMenu);
        
        setSize(400, 400);
       setTitle("Atualize o cadastro");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
           btnAtualizar.addActionListener((ActionEvent e) -> {
            atualizar();
            voltar();
         });
        
        btnMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
    }
    
    private void voltar() {
        this.dispose();
        menu menu = new menu();
    }
    private void atualizar(){
        
        String nome = txtNome.getText(),
                 cpf =ftxtCpf.getText();
        String sangue = txttipoSangue.getText();
        int serie =Integer.parseInt((String) jserie.getSelectedItem());
        float altura = Float.parseFloat((String) jaltura.getSelectedItem());
        
        new Crianca(nome, cpf, sangue, serie, altura).atualizar();
    }
}

