/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SingletonConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jrthi
 * Esta classe representa a inserção de dados a partir de arquivos no banco de dados.
 * Implementa a interface Runnable para executar a inserção em uma thread separada.
 */
public class Arquivo implements Runnable {

    SingletonConnection inst = SingletonConnection.getInstance();
    Connection con = inst.getConexao();
    private final String ARQUIVO = "C:\\Users\\jrthi\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoPoo2\\TrabalhoPoo2\\insere.txt";
    private final String ARQUIVOCRIANCA = "C:\\Users\\jrthi\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoPoo2\\TrabalhoPoo2\\insereCrianca.txt";
    private final String ARQUIVOPARENTES = "C:\\Users\\jrthi\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoPoo2\\TrabalhoPoo2\\insereParentes.txt";



      /**
     * Executa a inserção dos dados dos arquivos no banco de dados em uma thread separada.
     */
    @Override
    public void run() {
        Thread Monitor = new Thread(() -> {
            try {
                System.out.println("iniciada");
                BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
                BufferedReader leitorCrianca = new BufferedReader (new FileReader (ARQUIVOCRIANCA));
                BufferedReader leitorParentes = new BufferedReader(new FileReader(ARQUIVOPARENTES));

                String linha = null;
                String leitorCrianca = null;
                String leitorParentes = null;

                while (true) {
                    linha = leitor.readLine();
                    leitorCrianca = leitorCrianca.readLine();
                    leitorParentes = leitorParentes.readLine();
                   
                    if (linha != null) {
                        inserirLogin(linha);
                        
                    } 
                    
                    if (leitorCrianca != null){
                        inserirBancoCrianca(leitorCrianca);

                    }
                    if(leitorParentes != null) {
                        inserirBancoParentes(leitorParentes);

                    }
                    Thread.sleep(2000); 
                    
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao executar a thread " + e);
            }
        });
        Monitor.start();
    }

    /**
     * Insere os valores no banco de dados para a tabela de login.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
    private void inserirLogin(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

            if (valoresSeparados.length == 2) {
                System.out.println("Tamanho do array" + valoresSeparados.length);
                String queryUsuario = "INSERT INTO login VALUES (?, ?)";
                PreparedStatement pst = con.prepareStatement(queryUsuario);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());

                pst.executeUpdate();
                System.out.println("Valores inseridos no banco: " + valores);
                JOptionPane.showMessageDialog(null, "O login " + valoresSeparados[0] +" foi adicionado com sucesso");
            

            }
        
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de login:" + e);
        }
        
        limparArquivo();
    }
    
     /**
     * Insere os valores no banco de dados para a tabela de crianca.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
    
     private void inserirBancoCrianca(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

           if (valoresSeparados.length == 5) {

                String query = "INSERT INTO crianca VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());
                pst.setString(3, valoresSeparados[2]);
                pst.setFloat(4, Float.parseFloat((String)valoresSeparados[3].trim()));
                pst.setInt(5, Integer.parseInt((String)valoresSeparados[4].trim()));

                pst.executeUpdate();

                System.out.println("Inserção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");
                JOptionPane.showMessageDialog(null, "A criança " + valoresSeparados[0] +" foi adicionado com sucesso");

            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de beneficiarios:" + e);
        }
        limparArquivoCrianca();

    }
     
      /**
     * Insere os valores no banco de dados para a tabela de parentes.
     *
     * @param valores Os valores a serem inseridos no banco de dados.
     */
     
     private void inserirBancoParentes(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

          if (valoresSeparados.length == 5) {
                String query = "INSERT INTO parentes VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1].trim());
                pst.setString(3, valoresSeparados[2]);
                pst.setFloat(4, Float.parseFloat((String)valoresSeparados[3].trim()));
                pst.setInt(5, Integer.parseInt((String)valoresSeparados[4].trim()));
                int resultado = pst.executeUpdate();
                
                System.out.println("Inserção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");
                JOptionPane.showMessageDialog(null, "O parente " + valoresSeparados[0] +" foi adicionada com sucesso");

          }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados na tabela de Empresa:" + e);
        }
        limparArquivoParentes();

    };
     
        /**
     * Limpa o conteúdo do arquivo de entrada.
     */
     
         private void limparArquivo() {
        try {
            try (FileWriter writer = new FileWriter(ARQUIVO)) {
                writer.write("");
            }
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
         
   /**
     * Limpa o conteúdo do arquivo de entrada de crianca.
     */
         private void limparArquivoCrianca() {
        try {
            FileWriter writer = new FileWriter(ARQUIVOCRIANCA);
            writer.write("");
            writer.close();
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
         
   /**
     * Limpa o conteúdo do arquivo de entrada de parentes.
     */
         
         private void limparArquivoParentes() {
        try {
            FileWriter writer = new FileWriter(ARQUIVOPARENTES);
            writer.write("");
            writer.close();
            System.out.println("Arquivo limpo");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar o arquivo: " + e);
        }
    }
}
    
