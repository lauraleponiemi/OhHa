/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogiikkaTestit;

import Logiikka.Jarvi;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lleponie
 */
public class JarviTest {
    
    private Jarvi paijanne;
    private String nimi;
    private int vtase;
    
    public JarviTest() {
        this.nimi = "Päijänne";
        this.vtase = paijanne.getTase();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        paijanne = new Jarvi(400);
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void palautetaanTase() {
         paijanne.lisaaVetta(500);
         paijanne.vahennaVetta(400);
         
         
         assertEquals(500, paijanne.getTase());
     
     }
     @Test
     public void lisataanVetta(){
        paijanne.lisaaVetta(500);
        assertEquals(900, paijanne.getTase());
     }
}
