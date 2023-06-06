
package View.Gui.Crianca;

import SingletonConnection.Crianca;
import View.Gui.Parentes.inserirParentes;
import View.Gui.TelaPadrao.TelaPadrao;
import creche.menu;
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
 * @author jrthi
 */
public class inserirCrianca extends TelaPadrao {

        private final JLabel lblNome;
        private final JLabel lblCpf;
        private final JLabel lbltipoSangue;
        private final JLabel lblaltura,lblserie;
        private final JTextField txtNome;
        private final JFormattedTextField ftxtCpf;    
        private final JTextField txttipoSangue;
        private final JComboBox jaltura;
        private final JComboBox jserie;
        private final JButton btnEnviar;
        private final JButton btnAnt;
        private final JButton btnMenu;
    
       private final String[] saltura = {"1.51", "1.45", "1.42", "1.39", "1.33","1.20"};
       private final String[] sjserie = {"1","2", "3" ,"4" , "5"};

   
               public inserirCrianca() throws ParseException{
   
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
       btnEnviar = new JButton("Enviar");
       btnAnt = new JButton("Prox. Pág.");
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
       btnAnt.setBounds(30, 300, 115, 40);
       btnEnviar.setBounds(155, 300, 100, 40);
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
       getContentPane().add(btnEnviar);
       getContentPane().add(btnAnt);
       getContentPane().add(btnMenu);

        
        setSize(400, 400);
       setTitle("Cadastro Criança");
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
         btnEnviar.addActionListener((ActionEvent e) -> {
            try{
                cadastrarCrianca();
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
         
        btnAnt.addActionListener(new ActionListener(){
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
        inserirParentes inserirParentes = new inserirParentes();
    }
    private void btnMenu() throws ParseException{
        this.dispose();
        menu menu = new menu();
    }
    
    private void cadastrarCrianca()throws ParseException{
         String nome = txtNome.getText(),
                 cpf =ftxtCpf.getText();
        String sangue = txttipoSangue.getText();
        int serie =Integer.parseInt((String) jserie.getSelectedItem());
        float altura = Float.parseFloat((String) jaltura.getSelectedItem());


       
        try {
            Crianca crianca = new Crianca(nome, cpf, sangue, serie, altura);
            crianca.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
        
        
    }
    
}
