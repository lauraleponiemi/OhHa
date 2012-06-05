/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogiikkaTestit;

import Logiikka.Jarjestelma;
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
    private Joki isoJoki;
    private Jarjestelma jarjestelma;

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
        jarjestelma = new Jarjestelma(tkanta);
        jokia = new HashMap<Joki, Integer>();
        pikkuJoki = new Joki(67,"Kalajoki");
        isoJoki= new Joki(88, "Vantaanjoki");
        jokia.put(pikkuJoki, 44);
        isoJarvi = new Jarvi(450,"Päijänne");
        tkanta.setJarvi(isoJarvi, jokia);
        
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void tallennetaanJokia() {
        tkanta.setJoki(pikkuJoki, pikkuJoki.getVirtaus());       
        assertTrue(tkanta.getJoet().containsKey(pikkuJoki));
    }
    
    @Test
    public void tallennetaanJarvi(){
        tkanta.setJarvi(isoJarvi,jokia);       
        assertTrue(tkanta.getJarvet().containsKey(isoJarvi));
    }
    
    @Test
    public void setJokiJarvelleToimii(){
        tkanta.setJokiJarvelle(isoJoki, isoJarvi);
        
        assertTrue(tkanta.getJarvet().get(isoJarvi).keySet().contains(isoJoki));
    }
}
