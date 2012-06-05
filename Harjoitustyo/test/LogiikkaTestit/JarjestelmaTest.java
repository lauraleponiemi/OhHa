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
        jarjestelma.lisaaJarvi(67, "Päijänne");

    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void lisaaJarvi() {

        assertNotNull(jarjestelma.haeJarviNimella("Päijänne"));
    }

    @Test
    public void haeJarviToimii() {
        Jarvi suojarvi = null;
        jarjestelma.lisaaJarvi(41, "Suojärvi");
        for (Jarvi jarvi : jarjestelma.getTietokanta().getJarvet().keySet()) {
            if (jarvi.getNimi().equals("Suojärvi")) {
                suojarvi = jarvi;
            }
        }
        assertEquals(jarjestelma.haeJarvi(suojarvi), "Suojärvi");
    }

    @Test
    public void lisataanMontaJarvea() {
        jarjestelma.lisaaJarvi(45, "Kumpulajärvi");
        jarjestelma.lisaaJarvi(12, "Physicumjärvi");
        jarjestelma.lisaaJarvi(34, "Chemicumjärvi");


        assertTrue(jarjestelma.onkoJarviTietokannassa("Physicumjärvi"));
    }

    @Test
    public void yrittaaLisataJoOlevaaJarvea() {
        jarjestelma.lisaaJarvi(45, "Kumpulajärvi");
        jarjestelma.lisaaJarvi(45, "Kumpulajärvi");
        //TODO ja mites tän toteuttaisi? HUOM toteuta ensin metodiin poikkeustapausten käsittely
//        assertFalse();
    }

    @Test
    public void jarvenHakeminenNimellaToimii() {

        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase() == 67);
    }

    @Test
    public void onkoJarviTietokannassa() {
        jarjestelma.lisaaJarvi(45, "Kumpulajärvi");

        assertTrue(jarjestelma.onkoJarviTietokannassa("Kumpulajärvi"));
        assertFalse(jarjestelma.onkoJarviTietokannassa("Chemicumjärvi"));
    }

    @Test
    public void lisaaJokiToimiiT() {
        jarjestelma.lisaaJoki(66, "Testijoki", "Päijänne");
        assertNotNull(jarjestelma.haeJokiNimella("Testijoki"));
    }

    @Test
    public void lisaaJokiPalauttaaOikeanJoen() {
        Joki testijoki = null;
        jarjestelma.lisaaJoki(66, "Testijoki", "Päijänne");
        for (Joki joki : jarjestelma.getTietokanta().getJoet().keySet()) {
            if (joki.getNimi().equals("Testijoki")) {
                testijoki = joki;
            }
        }
        assertTrue(testijoki.getVirtaus() == 66);
    }

    @Test
    public void haeJokiToimii() {
        Joki suojoki = null;
        jarjestelma.lisaaJoki(33, "Suojoki", "Päijänne");
        for (Joki jo : jarjestelma.getTietokanta().getJoet().keySet()) {
            if (jo.getNimi().equals("Suojoki")) {
                suojoki = jo;
            }
        }
        assertEquals(jarjestelma.haeJoki(suojoki), "Suojoki");
        assertFalse(jarjestelma.haeJoki(suojoki).equals("Päijänne"));
        assertFalse(jarjestelma.haeJoki(suojoki).equals("Kalajoki"));
    }
    
//    @Test            (käytetäänkö "palautaJoki-metodia" missään?)
//    public void palautaJokiToimii(){
//        Joki joki = new Joki(45,"Koejoki");
//        
//        assertEquals(jarjestelma.palautaJoki("Koejoki"),joki);
//    }
    
    @Test
    public void yrittaaLisataVettaJarvessaTest(){
       jarjestelma.yrittaalisataVettaJarvessa("Päijänne", 30); 
       
       assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase()==97);
       assertFalse(jarjestelma.haeJarviNimella("Päijänne").getTase()==99);
    }
    
    @Test
    public void yrittaaVahentaaVettaJarvessaTest(){
        jarjestelma.yrittaavahentaaVettaJarvessa("Päijänne", 7);
        
        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase()==60);
        assertFalse(jarjestelma.haeJarviNimella("Päijänne").getTase()==66);
    }
    

    @Test
    public void yrittaaLisataJoenVirtaustaTest() {
        jarjestelma.lisaaJoki(66, "Testijoki", "Päijänne");
        jarjestelma.yrittaalisataVirtaustaJoessa("Testijoki", 4);
        assertEquals(70, jarjestelma.haeJokiNimella("Testijoki").getVirtaus());

    }

    @Test
    public void yrittaaVahentaaJoenVirtaustaTest() {
        jarjestelma.lisaaJoki(44, "Hjoki", "Päijänne");
        jarjestelma.yrittaavahentaaVirtaustaJoessa("Hjoki", 4);

        assertTrue(jarjestelma.haeJokiNimella("Hjoki").getVirtaus() == 40);

    }
    
    

    @Test
    public void osaaPoistaaJarvenTest() {
        jarjestelma.poistaJarvi("Päijänne");
        
        assertNull(jarjestelma.haeJarviNimella("Päijänne"));
    }

    @Test
    public void osaaPoistaaJoenTest() {
        
        jarjestelma.lisaaJoki(33, "Siikajoki", "Päijänne");
        jarjestelma.poistaJoki("Siikajoki");

        assertNull(jarjestelma.haeJokiNimella("Siikajoki"));
//        assertNull(jarjestelma.haeJokiNimella("Siikajoki").getVirtaus()); //TODO miksi rikkoo?
        assertNotNull(jarjestelma.haeJarviNimella("Päijänne"));
    }

    @Test
    public void yrittaaPalauttaaListaaJoista() {
        jarjestelma.lisaaJoki(23, "Siikajoki", "Päijänne");
        jarjestelma.lisaaJoki(12, "Koskijoki", "Päijänne");
        
        assertNotNull(jarjestelma.palautaListaJoista()); 
    }
    
    @Test
    public void yrittaaPalauttaaListaaJarvista(){
        jarjestelma.lisaaJarvi(567, "Laatokka");
        jarjestelma.palautaListaJarvista();
        
        assertNotNull(jarjestelma.palautaListaJarvista());                                   //TODO miten tämä tehdään??
    }
    
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
        assertFalse(ttunnukset.get("Hharjoittelija").equals("jokusalasana"));
        assertNull(ttunnukset.get("Hhokkanen"));
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
}
