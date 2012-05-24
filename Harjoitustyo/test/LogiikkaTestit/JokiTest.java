/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogiikkaTestit;

import Logiikka.Joki;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lleponie
 */
public class JokiTest {
    
    private Joki jokuJoki;
    private String nimi;
    
    public JokiTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        jokuJoki = new Joki(55, "Aurajoki");
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void muutaVirtausta() {
        jokuJoki.lisaaVirtausta(34);
        jokuJoki.vahennaVirtausta(4);
        
        assertEquals(85, jokuJoki.getVirtaus());
    }
    
    @Test
    public void yrittaaMuuttaaVirtaustaNegatiiviseksi(){
        jokuJoki.lisaaVirtausta(-40);
        jokuJoki.vahennaVirtausta(40);
        assertTrue(jokuJoki.getVirtaus()== 15);
    }
    
    
    
    
    
}
