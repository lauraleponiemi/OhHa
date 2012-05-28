package LogiikkaTestit;

import Logiikka.AdminJarjestelma;
import Logiikka.Jarjestelma;
import Logiikka.Tietokanta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class JarjestelmaTest {

    private Tietokanta tkanta;
    private Jarjestelma jarjestelma;
    File tiedosto;
    private Scanner lukija;
    private HashMap <String, String> ttunnukset;

    public JarjestelmaTest() throws FileNotFoundException {
        tiedosto = new File("tunnuksetTest.txt");
        lukija = new Scanner(tiedosto);
        ttunnukset = new HashMap <String, String>();
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
    public void yrittaaKirjautuaJarjestelmaan(){
        jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);
        AdminJarjestelma luokka = new AdminJarjestelma(tkanta);       
        Jarjestelma j = jarjestelma.kirjauduSisaan("Oopiskelija", "punavuori");
        
        assertTrue(j.getClass().equals(luokka.getClass()));
        //TODO: menee läpi, mutta onko tässä vielä jotain häikkää?
    }
    
    
}
