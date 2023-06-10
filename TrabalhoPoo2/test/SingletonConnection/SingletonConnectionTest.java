/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SingletonConnection;

import java.sql.Connection;
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
public class SingletonConnectionTest {
    
    public SingletonConnectionTest() {
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
     * Test of cadastroCrianca method, of class SingletonConnection.
     */
    @Test
    public void testCadastroCrianca() {
        System.out.println("cadastroCrianca");
        String nome = "";
        String cpf = "";
        String sangue = "";
        float altura = 0.0F;
        int serie = 0;
        SingletonConnection.cadastroCrianca(nome, cpf, sangue, altura, serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class SingletonConnection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SingletonConnection expResult = null;
        SingletonConnection result = SingletonConnection.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConexao method, of class SingletonConnection.
     */
    @Test
    public void testGetConexao() {
        System.out.println("getConexao");
        SingletonConnection instance = null;
        Connection expResult = null;
        Connection result = instance.getConexao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
