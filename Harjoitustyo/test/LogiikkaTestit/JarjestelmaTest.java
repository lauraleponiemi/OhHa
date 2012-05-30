package LogiikkaTestit;

import Logiikka.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class JarjestelmaTest {

    
    private Jarjestelma jarjestelma;
    File tiedosto;
    private Scanner lukija;
    private HashMap<String, String> ttunnukset;

    public JarjestelmaTest() throws FileNotFoundException {
        tiedosto = new File("tunnuksetTest.txt");
        lukija = new Scanner(tiedosto);
        ttunnukset = new HashMap<String, String>();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
       
        Tietokanta tkanta = new Tietokanta();
        jarjestelma = new Jarjestelma(tkanta);

    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void yrittaaLisataTiedostosta() {
        jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" ");
            ttunnukset.put(osat[0], osat[1]);
        }
        lukija.close();

        assertTrue(ttunnukset.get("Hharjoittelija").equals("tapanila"));
    }

    @Test
    public void onnistuuKirjautuminenJarjestelmaan() {
        jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);
        AdminJarjestelma luokka = new AdminJarjestelma(jarjestelma.getTietokanta());
        Jarjestelma j = jarjestelma.kirjauduSisaan("Oopiskelija", "punavuori");

        assertTrue(j.getClass().equals(luokka.getClass()));
        //TODO: menee läpi, mutta onko tässä vielä jotain häikkää?
    }
//
//    @Test
//    public void epaonnistuuKirjautumaanJarjestelmaan() {
//        jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);
//        OpiskelijaJarjestelma luokka = new OpiskelijaJarjestelma(tkanta);
//        Jarjestelma j = luokka.kirjauduSisaan("Oopiskelija", "punavuori");
//
//        assertFalse(j.getClass().equals(luokka.getClass()));
//        
//    }
    
    @Test
    public void lisaaJoki(){
        jarjestelma.lisaaJoki(66, "Testijoki", "Päijänne");
        Joki joki = new Joki(22, "hhh");
        assertTrue(jarjestelma.palautaJoki("Testijoki").getClass().equals(joki.getClass()));
    }
    

    @Test
    public void yrittaaLisataJoenVirtausta() {
       // Joki tjoki = new Joki(66, "Testijoki");
        jarjestelma.lisaaJoki(66, "Testijoki", "Päijänne");
        jarjestelma.lisaaVirtaustaJoessa("Testijoki", 4);
        assertEquals(70, jarjestelma.palautaJoki("Testijoki").getVirtaus());

    }
    
    
    @Test
    public void yrittaaVahentaaVirtaustaJoessa(){
        Joki tjoki = new Joki(44, "Hjoki");
        jarjestelma.lisaaJoki(44, "Hjoki", "Päijänne");
        jarjestelma.vahennaVirtaustaJoessa("Hjoki", 4);
        assertEquals(40, tjoki.getVirtaus());
        
    }
    
    @Test
    public void yrittaaPoistaaJarvea(){
        
    }
    
    @Test
    public void yrittaaPoistaaJokea(){
        
    }
    
    @Test
    public void yrittaaPalauttaaListaaJoista(){
        
    }
    
    
}
