/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package creche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
 * @author midia
 */
public class crianca extends JFrame {
        public JLabel lblNome, lblCpf, lbltipoSangue,lblaltura,lblserie;
        public JTextField txtNome;
        public JFormattedTextField ftxtCpf;    
        public JTextField txttipoSangue;
        public JComboBox caltura;
        public JComboBox jserie;
        public JButton btnEnviar2;
        public JButton buttonAnt;
        public JButton btnMenu;
    
       private final String[] scaltura = {"1.51", "1.45", "1.42", "1.39", "1.33","1.20"};
       private final String[] sjserie = {"1","2", "3" ,"4" , "5"};

   
               public crianca() throws ParseException{
   
       setLayout(null);
       
       lblNome = new JLabel("Nome:");
       txtNome = new JTextField();
       lblCpf = new JLabel("CPF:");
       ftxtCpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
       lbltipoSangue = new JLabel("Tipo Sangue:");
       txttipoSangue = new JTextField();
       
       lblaltura = new JLabel("Altura:");
       caltura = new JComboBox(scaltura);
       lblserie = new JLabel("Série:");
       jserie = new JComboBox(sjserie);
       btnEnviar2 = new JButton("Enviar");
       buttonAnt = new JButton("Prox. Pág.");
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
       caltura.setBounds(90, 230, 200, 25);
       buttonAnt.setBounds(30, 300, 115, 40);
       btnEnviar2.setBounds(155, 300, 100, 40);
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
       getContentPane().add(caltura);
       getContentPane().add(btnEnviar2);
       getContentPane().add(buttonAnt);
       getContentPane().add(btnMenu);

       
       setSize(400, 400);
       setTitle("Cadastro Criança");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
           btnEnviar2.addActionListener((ActionEvent e) -> {
           cliqueBtnEnviar();
       });
       
       buttonAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueProxPage();
                } catch (ParseException ex) {
                    Logger.getLogger(crianca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueMenu();
                } catch (ParseException ex) {
                    Logger.getLogger(crianca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }

      
      private void cliqueBtnEnviar(){
        String nome = txtNome.getText(),
               cpf =ftxtCpf.getText();
        String sangue = txttipoSangue.getText();
        int serie =Integer.parseInt((String) jserie.getSelectedItem());
        float altura = Float.parseFloat((String) caltura.getSelectedItem());
        
     
               
        
        System.out.println("nome completo: " + nome);
        System.out.println("cpf : " + cpf);
        System.out.println("tipo Sangue: " + sangue);
        System.out.println("altura: " + altura);
        System.out.println("serie: " + serie);



        try(PrintWriter pw = new PrintWriter(new File("cadastrocianca.txt"))){
            pw.println("nome : " + nome);
            pw.println("cpf : " + cpf);
            pw.println("Tipo Sangue : " + sangue);
            pw.println("altura : " + altura);
            pw.println("serie : " + serie);
          

        }catch(FileNotFoundException e){
            System.out.println("Arquivo nÃo existe");
        }
        
    }
      
   private void cliqueProxPage()  throws ParseException{
       
       this.dispose();
       parentes parentes = new parentes();
    }
    
   private void cliqueMenu()  throws ParseException{
       
       this.dispose();
        menu menu = new menu();
    }
}
