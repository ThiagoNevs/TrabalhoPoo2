/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Gui.Verificacao;

import SingletonConnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jrthi
 */
public class Verificacao {

    SingletonConnection inst = SingletonConnection.getInstance();
    Connection con = inst.getConexao();

    public Verificacao(String nome, String senha) {

    }

    public boolean Acessa(String nome, String senha) {

        try {
            String query = "SELECT * FROM login WHERE nome_login =? AND senha_login=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro:" + ex);
        }
        return false;
    }
}

