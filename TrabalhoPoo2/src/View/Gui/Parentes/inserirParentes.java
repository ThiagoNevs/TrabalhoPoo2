/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package View.Gui.Parentes;

import SingletonConnection.Parentes;
import View.Gui.Crianca.inserirCrianca;
import View.Gui.TelaPadrao.TelaPadrao;
import creche.menu;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
public class inserirParentes extends TelaPadrao {
        private final JLabel lblNome, lblCpf, lblgrau,lblmensalidade,lbldesconto;
        private final JTextField txtNome;
        private final JFormattedTextField ftxtCpf;    
        private final JTextField txtgrau;
        private final JComboBox cmensalidade;
        private final JComboBox jdesconto;
        private final JButton btnEnviar;
        private final JButton btnProx;
        private final JButton btnMenu;
    
       private String[] scmensalidade = {"1000.50", "950.50", "800.20", "600.25", "400.99","275.50"};
       private String[] sjdesconto = {"0", "25", "50", "75", "100"};

   
               public inserirParentes() throws ParseException{
   
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
       btnProx = new JButton("Prox. Pág.");
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
       btnProx.setBounds(30, 300, 115, 40);
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
       getContentPane().add(btnProx);
       getContentPane().add(btnMenu);

       
       setSize(400, 400);
       setTitle("Cadastro Responsável");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        

         btnEnviar.addActionListener((ActionEvent e) -> {
            try{
                cadastrarParentes();
            }catch(ParseException ex){
                System.out.println("Ocorreu um erro ao cadastrar no banco de dados :" + e);
            }
        });
        
         btnMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnMenu();
                } catch (ParseException ex) {
                    System.out.println("Ocorreu um erro ao mudar de tela :" + e);
                }
            }
        });
         
        btnProx.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    trocaTela();
                } catch (ParseException ex) {
                    System.out.println("Ocorreu um erro ao mudar de tela :" + e);
                }
            }
        });

    }
    
    private void trocaTela() throws ParseException{
        this.dispose();
        inserirCrianca inserirCrianca = new inserirCrianca();
    }
    private void btnMenu() throws ParseException{
        this.dispose();
        menu menu = new menu();
    }
    
    
    
    private void cadastrarParentes()throws ParseException{
        String nome = txtNome.getText(),
        cpf =ftxtCpf.getText();
        String parentesco = txtgrau.getText();
        int desconto =Integer.parseInt((String) jdesconto.getSelectedItem());
        float mensalidade = Float.parseFloat((String) cmensalidade.getSelectedItem());
        try {
            Parentes parentes = new Parentes(nome, cpf, parentesco, mensalidade, desconto);
            parentes.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
        
        
    }
    
}

