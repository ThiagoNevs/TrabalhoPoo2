/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BDObject;

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
public class BDObjectTest {
    
    public BDObjectTest() {
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
     * Test of inserir method, of class BDObject.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        BDObject instance = new BDObjectImpl();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class BDObject.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        BDObject instance = new BDObjectImpl();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class BDObject.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        BDObject instance = new BDObjectImpl();
        instance.deletar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarTodos method, of class BDObject.
     */
    @Test
    public void testDeletarTodos() {
        System.out.println("deletarTodos");
        BDObject instance = new BDObjectImpl();
        instance.deletarTodos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class BDObject.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        BDObject instance = new BDObjectImpl();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BDObjectImpl extends BDObject {
    }
    
}
