/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

/**
 *
 * @author jrthi
 */
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


public class Parentes extends BDObject {

    SingletonConnection inst = SingletonConnection.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String cpf;
    private String parentesco;
    private float mensalidade;
    private int desconto;

    public Parentes(String nome_parentes, String cpf_parentes ,String parentesco_parentes, float mensalidade_parentes, int desconto_parentes) {
        nome = nome_parentes;
        cpf = cpf_parentes;
        parentesco = parentesco_parentes;
        mensalidade = mensalidade_parentes;
        desconto = desconto_parentes;
    }

    public Parentes() {
    }

    @Override
    public void inserir() {

        try {
            String query = "INSERT INTO crianca VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, parentesco);
            pst.setFloat(4, mensalidade);
            pst.setInt(5, desconto);

            pst.executeUpdate();

            System.out.println("Inserção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void atualizar() {
        try {

            String query = "UPDATE parentes SET nome_parentes = ?, parentesco_parentes = ?, mensalidade_parentes= ?, desconto_parentes = ? WHERE cpf_parentes= ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, parentesco);
            pst.setFloat(4, mensalidade);
            pst.setInt(5, desconto);
            
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

    public void deletar(String nome) {
        try {
            String query = "DELETE FROM crianca WHERE nome_parentes = ?";
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

    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Parentes cadastradas");
        tela.setSize(500, 300);
        tela.setResizable(false);
        
// Cria a tabela
         String[] colunas = {"Nome", "CPf","Parentesco","Mensalidade","Desconto"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM parentes";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                String nome = rst.getString("nome_parentes");
                String cpf = rst.getString("cpf_parentes");
                String parentesco = rst.getString("parentesco_parentes");
                String mensalidade = rst.getString("mensalidade_parentes");
                String desconto = rst.getString("desconto_parentes");
                modelo.addRow(new Object[] { nome,cpf,parentesco,mensalidade,desconto});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibir os cadastros dos parentes:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Exibe a janela
        tela.setVisible(true);
    }

}
