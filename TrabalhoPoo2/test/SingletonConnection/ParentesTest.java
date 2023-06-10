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
public class ParentesTest {
    
    public ParentesTest() {
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
     * Test of inserir method, of class Parentes.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Parentes instance = new Parentes();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class Parentes.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Parentes instance = new Parentes();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Parentes.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String nome = "";
        Parentes instance = new Parentes();
        instance.deletar(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Parentes.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Parentes instance = new Parentes();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
