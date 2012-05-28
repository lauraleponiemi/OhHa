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
    public void vahennaVirtausta() {        
        jokuJoki.vahennaVirtausta(4);       
        assertEquals(51, jokuJoki.getVirtaus());
    }
    @Test
    public void lisaaVirtausta(){
        jokuJoki.lisaaVirtausta(34);
        assertEquals(89, jokuJoki.getVirtaus());
    }
    
    @Test
    public void yrittaaMuuttaaVirtaustaNegatiiviseksi(){
        jokuJoki.lisaaVirtausta(-40);
        jokuJoki.vahennaVirtausta(40);
        assertTrue(jokuJoki.getVirtaus()== 15);
    }
    
    @Test
    public void lisataanVirtaustaNollalla(){
        jokuJoki.lisaaVirtausta(0);
        assertTrue(jokuJoki.getVirtaus()== 55);
    }
    
    
    
    
    
}
