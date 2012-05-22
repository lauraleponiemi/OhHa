/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaTestit;

import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;


public class KayttoliittymaTest {
    
    private Kayttoliittyma kayttis;
    private Scanner lukija;
    
    public KayttoliittymaTest() {
        this.kayttis = kayttis;
        
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        lukija = new Scanner(System.in);
        kayttis = new Kayttoliittyma();
    }
    
    @After
    public void tearDown() {
        
        
    }
//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {
     
     
     }
}
