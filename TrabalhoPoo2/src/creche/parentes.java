/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package creche;

import DBConnection.BDConnection;
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
public class parentes extends JFrame {
        public JLabel lblNome, lblCpf, lblgrau,lblmensalidade,lbldesconto;
        public JTextField txtNome;
        public JFormattedTextField ftxtCpf;    
        public JTextField txtgrau;
        public JComboBox cmensalidade;
        public JComboBox jdesconto;
        public JButton btnEnviar;
        public JButton buttonProx;
        public JButton btnMenu;
    
       private String[] scmensalidade = {"1000.50", "950.50", "800.20", "600.25", "400.99","275.50"};
       private String[] sjdesconto = {"0", "25", "50", "75", "100"};

   
               public parentes() throws ParseException{
   
       setLayout(null);
       
       lblNome = new JLabel("Nome:");
       txtNome = new JTextField();
       lblCpf = new JLabel("CPF:");
       ftxtCpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
       lblgrau = new JLabel("Grau de parentesco:");
       txtgrau = new JTextField();
       
       lblmensalidade = new JLabel("Valor mensalidade:");
       cmensalidade = new JComboBox(scmensalidade);
       lbldesconto = new JLabel("Valor em desconto:");
       jdesconto = new JComboBox(sjdesconto);
       btnEnviar = new JButton("Enviar");
       buttonProx = new JButton("Prox. Pág.");
       btnMenu = new JButton("Menu");
      
       
       
       lblNome.setBounds(10, 10, 200, 25);
       txtNome.setBounds(70, 10, 250, 25);
       lblCpf.setBounds(10, 60, 200, 25);
       ftxtCpf.setBounds(70, 60, 250, 25);
       lblgrau.setBounds(10, 110, 200, 25);
       txtgrau.setBounds(135, 110, 185, 25);
       lbldesconto.setBounds(10,160, 200, 25);
       jdesconto.setBounds(120, 190, 200, 25);
       lblmensalidade.setBounds(10, 230, 200 , 25);
       cmensalidade.setBounds(120, 260, 200, 25);
       btnEnviar.setBounds(155, 300, 100, 40);
       buttonProx.setBounds(30, 300, 115, 40);
       btnMenu.setBounds(270, 300, 100, 40);
       
       getContentPane().add(lblNome);
       getContentPane().add(txtNome);
       getContentPane().add(lblCpf);
       getContentPane().add(ftxtCpf);
       getContentPane().add(lblgrau);
       getContentPane().add(txtgrau);
       getContentPane().add(lbldesconto);
       getContentPane().add(jdesconto);
       getContentPane().add(lblmensalidade);
       getContentPane().add(cmensalidade);
       getContentPane().add(btnEnviar);
       getContentPane().add(buttonProx);
       getContentPane().add(btnMenu);

       
       setSize(400, 400);
       setTitle("Cadastro Responsável");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
       btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueBtnEnviar();
            }
        });
       
       buttonProx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueProxPage();
                } catch (ParseException ex) {
                    Logger.getLogger(parentes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
       btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueMenu();
                } catch (ParseException ex) {
                    Logger.getLogger(parentes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

      
      private void cliqueBtnEnviar(){
        String nome = txtNome.getText(),
               cpf =ftxtCpf.getText();
        String parentesco = txtgrau.getText();
        int desconto =Integer.parseInt((String) jdesconto.getSelectedItem());
        float mensalidade = Float.parseFloat((String) cmensalidade.getSelectedItem());
        
     
               
        
        System.out.println("nome completo: " + nome);
        System.out.println("cpf : " + cpf);
        System.out.println("grau de parentesco : " + parentesco);
        System.out.println("mensalidade: " + mensalidade);
        System.out.println("desconto: " + desconto);



        try(PrintWriter pw = new PrintWriter(new File("cadastroParentes.txt"))){
            pw.println("nome : " + nome);
            pw.println("cpf : " + cpf);
            pw.println("parentesco : " + parentesco);
            pw.println("mensalidade : " + mensalidade);
            pw.println("desconto : " + desconto);
          

        }catch(FileNotFoundException e){
            System.out.println("Arquivo nÃo existe");
        }
        try {
             BDConnection.cadastroParentes(nome, cpf, parentesco, mensalidade, desconto);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
   private void cliqueProxPage() throws ParseException{
       
       this.dispose();
      crianca crianca = new crianca();
   
    }
    
   private void cliqueMenu()  throws ParseException{
       
       this.dispose();
        menu menu = new menu();
    }
}
