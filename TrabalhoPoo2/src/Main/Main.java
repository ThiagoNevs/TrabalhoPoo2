/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import SingletonConnection.Arquivo;
import View.Gui.Login.loginSenha;
import java.text.ParseException;

/**
 *
 * @author midia
 */
public class Main {
    public static void main(String[] args) throws ParseException{
        
        Arquivo arquivo = new Arquivo();
        Thread thread = new Thread(arquivo);
        thread.start();
        
      loginSenha loginsenha = new loginSenha();
    }
}
