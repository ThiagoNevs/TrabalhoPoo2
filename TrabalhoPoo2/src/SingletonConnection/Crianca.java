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


public class Crianca extends BDObject {

    SingletonConnection inst = SingletonConnection.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String cpf;
    private String sangue;
    private float altura;
    private int serie;

    public Crianca(String nomeCrianca, String cpfCrianca ,String sangueCrianca,int serieCrianca, float alturaCrianca) {
        nome = nomeCrianca;
        cpf = cpfCrianca;
        sangue = sangueCrianca;
        altura = alturaCrianca;
        serie = serieCrianca;
    }

    public Crianca() {
    }

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

    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Crianças cadastradas");
        tela.setSize(500, 300);
        tela.setResizable(false);
        

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
        tela.setVisible(true);
    }

}

