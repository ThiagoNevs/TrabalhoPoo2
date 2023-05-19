/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDConnection {
  
    
    public static void cadastroParentes(String nome, String cpf, String parentesco, float mensalidade, int desconto) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/creche";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "12345");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO parentes (NOME, CPF, PARENTESCO, MENSALIDADE, DESCONTO)VALUES" + 
                    "('"+nome+"','"+cpf+"','"+parentesco+"', '"+mensalidade+"','"+desconto+"')");
        
        conexao.close();
        
    }
    public static void cadastroCrianca(String nome, String cpf, String sangue, float altura, int serie) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String urlJDBC = "jdbc:mysql://localhost:3306/creche";
        Connection conexao = (Connection) DriverManager.getConnection(urlJDBC,
                                                        "root", 
                                                        "12345");
       
        Statement comando = (Statement) conexao.createStatement();
        
            comando.execute("INSERT INTO crianca (NOME, CPF, SANGUE, ALTURA, SERIE)VALUES" + 
                    "('"+nome+"','"+cpf+"','"+sangue+"', '"+altura+"','"+serie+"')");
        
        conexao.close();
        
    }
    

}
