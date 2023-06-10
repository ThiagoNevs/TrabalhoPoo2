/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SingletonConnection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jrthi
 */
public class CriancaTest {
    
    public CriancaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class Crianca.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Crianca instance = new Crianca();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class Crianca.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Crianca instance = new Crianca();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Crianca.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String nome = "";
        Crianca instance = new Crianca();
        instance.deletar(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Crianca.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Crianca instance = new Crianca();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
