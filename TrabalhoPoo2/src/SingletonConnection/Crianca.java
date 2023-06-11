package SingletonConnection;

import BDObject.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author jrthi
 */
public class Crianca extends BDObject {
    
      /**
     * Construtor da classe Criança.
     * @param nome_crianca O nome da criança cadastrada.
     * @param cpf_crianca O CPF da criança cadastrada.
     * @param sangue_crianca O tipo sanguíneo da criança cadastrada.
     * @param altura_crianca A altura da criança cadastrada.
     * @param serie_crianca A série que a criança está matriculada.
     */


    SingletonConnection inst = SingletonConnection.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String cpf;
    private String sangue;
    private float altura;
    private int serie;

   /**
     * Construtor da classe Criança.
     * @param nome_crianca O nome da criança cadastrada.
     * @param cpf_crianca O CPF da criança cadastrada.
     * @param sangue_crianca O tipo sanguíneo da criança cadastrada.
     * @param altura_crianca A altura da criança cadastrada.
     * @param serie_crianca A série que a criança está matriculada.
     */

    
    public Crianca(String nome_crianca, String cpf_crianca ,String sangue_crianca,int serie_crianca, float altura_crianca) {
        nome = nome_crianca;
        cpf = cpf_crianca;
        sangue = sangue_crianca;
        altura = altura_crianca;
        serie = serie_crianca;
    }

    public Crianca() {
    }

    /**
     * Insere o cadastro da criança no banco de dados.
     */
    @Override
    public void inserir() {

        try {
            String query = "INSERT INTO crianca VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, sangue);
            pst.setFloat(4, altura);
            pst.setInt(5, serie);

            pst.executeUpdate();

            System.out.println("Inserção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir no banco de dados :" + ex);
        }
    }

     /**
     * Atualiza o cadastro de uma criança no banco de dados.
     */
    @Override
    public void atualizar() {
        try {

            String query = "UPDATE crianca SET nome_crianca = ?, sangue_crianca = ?, altura_crianca= ?, serie_crianca = ? WHERE cpf_crianca= ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, sangue);
            pst.setFloat(4, altura);
            pst.setInt(5, serie);
            
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
               JOptionPane.showMessageDialog(null,"--- Cadastro alterado com sucesso. ---");
            } else {
                JOptionPane.showMessageDialog(null,"--- Nenhum cadastro alterado. ---");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
    }

    /**
     * Deleta o cadastro de uma criança.
     * @param nome  Nome da crinça a ser deletado.
     */
         
    public void deletar(String nome) {
        try {
            String query = "DELETE FROM crianca WHERE nome_crianca = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro apagado.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cadastro apagado.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar apagar o cadastro :" + e);
        }
    }

       /**
     * Mostra as crianças cadastrados em uma tabela.
     */
    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Crianças cadastradas");
        tela.setSize(500, 300);
        tela.setResizable(false);
        
// Cria a tabela
        String[] colunas = {"Nome", "CPF","Sangue","Altura","Série"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM crianca";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String nome = rst.getString("nome_crianca");
                String cpf = rst.getString("cpf_crianca");
                String sangue = rst.getString("sangue_crianca");
                String altura = rst.getString("altura_crianca");
                String serie = rst.getString("serie_crianca");
                modelo.addRow(new Object[] { nome,cpf,sangue,altura,serie});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibir os cadastros das crianças:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         // Exibe a janela
        tela.setVisible(true);
    }

}

