/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogiikkaTestit;

import Logiikka.Jarvi;
import Logiikka.Joki;
import Logiikka.Tietokanta;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lleponie
 */
public class TietokantaTest {

    private Tietokanta tkanta;
    private HashMap<Joki, Integer> jokia;
    private Jarvi isoJarvi;
    private Joki pikkuJoki;

    public TietokantaTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        tkanta = new Tietokanta();
        jokia = new HashMap<Joki, Integer>();
        pikkuJoki = new Joki(67,"Kalajoki");
        jokia.put(pikkuJoki, 44);
        isoJarvi = new Jarvi(450,"Päijänne");

        
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void tallennetaanJokia() {
        tkanta.setJoet(jokia);       
        assertTrue(tkanta.getJoet().containsKey(pikkuJoki));
    }
    
    @Test
    public void tallennetaanJarvi(){
        tkanta.setJarvi(isoJarvi,jokia);       
        assertTrue(tkanta.getJarvet().containsKey(isoJarvi));
    }
}
