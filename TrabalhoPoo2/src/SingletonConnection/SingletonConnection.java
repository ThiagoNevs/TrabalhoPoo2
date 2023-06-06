/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SingletonConnection;


import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonConnection {

    public static void cadastroCrianca(String nome, String cpf, String sangue, float altura, int serie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        private java.sql.Connection conexao;
    
    private static final String urlJDBC = "jdbc:mysql://localhost:3306/creche";
    private static final String usuario = "root";
    private static final String senha = "12345";
    
    
    private static SingletonConnection instance;
    
    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro na conexão" + ex.getMessage());
        }
    }

    public static synchronized SingletonConnection getInstance() {

        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public synchronized java.sql.Connection getConexao() {
        return this.conexao;
    }
}






