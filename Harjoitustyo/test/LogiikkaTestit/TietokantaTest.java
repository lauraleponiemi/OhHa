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
    private HashMap<Jarvi, HashMap<Joki, Integer>> jarvia;
    private Jarvi pikkuJarvi;
    private Joki pikkuJoki;

    public TietokantaTest() {
//        this.tkanta = tkanta;
//        this.jokia = jokia;
//        this.pikkuJarvi = pikkuJarvi;
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
        pikkuJarvi = new Jarvi(450);
        jarvia = new HashMap<Jarvi, HashMap<Joki, Integer>>();
        pikkuJoki = new Joki(67);
    }

    @After
    public void tearDown() {
//        tkanta.setJarvet(jarvia);
//        tkanta.setJoet(jokia);
//        tkanta.getJarvet();
//        tkanta.getJoet();

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void tallennetaanJokiaJaJarvia() {
        jokia.put(pikkuJoki, 145);
        tkanta.setJoet(jokia);
        jarvia.put(pikkuJarvi, jokia);
        tkanta.setJarvet(jarvia);
        tkanta.getJarvet();
        

        assertTrue(jokia.get(pikkuJoki)== 145);
    }
}
