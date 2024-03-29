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
    File tyhjatiedosto;
    File jtiedosto;
    private Scanner lukija;
    private HashMap<String, String> ttunnukset;
    Tietokanta tkanta;

    public JarjestelmaTest() throws FileNotFoundException {
        tyhjatiedosto = new File("vaarattunnukset.txt");
        jtiedosto = new File("jarvetTest.txt");
        tiedosto = new File("tunnuksetTest.txt");
        lukija = new Scanner(tiedosto);
        ttunnukset = new HashMap<String, String>();
        tkanta = new Tietokanta();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        jarjestelma = new Jarjestelma(tkanta);
        jarjestelma.lisaaJaLuoJarvi(67, "Päijänne");

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
    public void lisataanMontaJarvea() {
        jarjestelma.lisaaJaLuoJarvi(45, "Kumpulajärvi");
        jarjestelma.lisaaJaLuoJarvi(12, "Physicumjärvi");
        jarjestelma.lisaaJaLuoJarvi(34, "Chemicumjärvi");


        assertTrue(jarjestelma.onkoJarviTietokannassa("Physicumjärvi"));
    }

    @Test
    public void yrittaaLisataJoOlevaaJarvea() {
        jarjestelma.lisaaJaLuoJarvi(45, "Kumpulajärvi");
        assertFalse(jarjestelma.lisaaJaLuoJarvi(56, "Kumpulajärvi"));
        assertFalse(jarjestelma.lisaaJaLuoJarvi(45, "Kumpulajärvi"));
    }

    @Test
    public void yrittaaLisataJarveaNegatiivisellaTaseella() {
        assertFalse(jarjestelma.lisaaJaLuoJarvi(-45, "Kumpulajärvi"));
    }

    @Test
    public void yrittaaLisataJarveaNollaTaseella() {
        assertFalse(jarjestelma.lisaaJaLuoJarvi(0, "Kumpulajärvi"));
    }

    @Test
    public void haeJarviToimii() {
        Jarvi suojarvi = null;
        jarjestelma.lisaaJaLuoJarvi(41, "Suojärvi");
        for (Jarvi jarvi : jarjestelma.getTietokanta().getJarvet().keySet()) {
            if (jarvi.getNimi().equals("Suojärvi")) {
                suojarvi = jarvi;
            }
        }
        assertEquals(jarjestelma.haeJarvi(suojarvi), "Suojärvi");
    }

    @Test
    public void jarvenHakeminenNimellaToimii() {

        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase() == 67);
    }

    @Test
    public void onkoJarviTietokannassa() {
        jarjestelma.lisaaJaLuoJarvi(45, "Kumpulajärvi");

        assertTrue(jarjestelma.onkoJarviTietokannassa("Kumpulajärvi"));
        assertFalse(jarjestelma.onkoJarviTietokannassa("Chemicumjärvi"));
    }

    @Test
    public void lisaaJokiToimii() {
        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Päijänne");
        assertNotNull(jarjestelma.haeJokiNimella("Testijoki"));
    }

    @Test
    public void lisaaJokiToimii2() {
        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(33, "Hjoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(12, "Djoki", "Päijänne");
        assertNotNull(jarjestelma.haeJokiNimella("Hjoki"));
    }

    @Test
    public void lisaaJokiEiToimiJosJarveaEiOlemassa() {
//        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Testijarvi");
        assertFalse(jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Testijarvi"));
    }

    @Test
    public void yrittaaLisataJoOlevaaJokea() {
        jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Päijänne");
        assertFalse(jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Päijänne"));
    }

    @Test
    public void yrittaaLisataJoOlevaaJokea2() {
        jarjestelma.lisaaJaLuoJarvi(45, "Kumpulajärvi");
        jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Päijänne");
        assertFalse(jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Kumpulajärvi"));

    }

    @Test
    public void yrittaaLisataJoOlevaaJokeaEiOlevaanJarveen() {
        jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Päijänne");
        assertFalse(jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Testijärvi"));
    }

    @Test
    public void yrittaaLisataUuttaJokeaEiOlevaanJarveen() {
        assertFalse(jarjestelma.lisaaJaLuoJoki(45, "Testijoki", "Testijärvi"));
    }

    @Test
    public void lisattyJokiLoytyyMyosJarvenMapista() {
        Joki jjoki = null;
        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Päijänne");
        for (Jarvi jarv : jarjestelma.getTietokanta().getJarvet().keySet()) {
            if (jarv.getNimi().equals("Päijänne")) {
                for (Joki j : jarjestelma.getTietokanta().getJarvet().get(jarv).keySet()) {
                    if (j.getNimi().equals("Testijoki")) {
                        jjoki = j;
                    }
                }
            }
        }
        assertEquals(jjoki.getNimi(), "Testijoki");
    }

    @Test
    public void lisaaJokiPalauttaaOikeanJoen() {
        Joki testijoki = null;
        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Päijänne");
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
        jarjestelma.lisaaJaLuoJoki(33, "Suojoki", "Päijänne");
        for (Joki jo : jarjestelma.getTietokanta().getJoet().keySet()) {
            if (jo.getNimi().equals("Suojoki")) {
                suojoki = jo;
            }
        }
        assertEquals(jarjestelma.haeJoki(suojoki), "Suojoki");
        assertFalse(jarjestelma.haeJoki(suojoki).equals("Päijänne"));
        assertFalse(jarjestelma.haeJoki(suojoki).equals("Kalajoki"));
    }

    @Test
    public void yrittaaLisataVettaJarvessaTest() {
        jarjestelma.yrittaalisataVettaJarvessa("Päijänne", 30);

        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase() == 97);
        assertFalse(jarjestelma.haeJarviNimella("Päijänne").getTase() == 99);
    }

    @Test
    public void yrittaaVahentaaVettaJarvessaTest() {
        jarjestelma.yrittaavahentaaVettaJarvessa("Päijänne", 7);

        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase() == 60);
        assertFalse(jarjestelma.haeJarviNimella("Päijänne").getTase() == 66);
    }

    @Test
    public void yrittaaVahentaaLiikaaVettaJarvesta() {
        jarjestelma.yrittaavahentaaVettaJarvessa("Päijänne", 99);
        assertTrue(jarjestelma.haeJarviNimella("Päijänne").getTase() == 0);
    }

    @Test
    public void yrittaaLisataJoenVirtaustaTest() {
        jarjestelma.lisaaJaLuoJoki(66, "Testijoki", "Päijänne");
        jarjestelma.yrittaalisataVirtaustaJoessa("Testijoki", 4);
        assertEquals(70, jarjestelma.haeJokiNimella("Testijoki").getVirtaus());

    }

    @Test
    public void yrittaaVahentaaJoenVirtaustaTest() {
        jarjestelma.lisaaJaLuoJoki(44, "Hjoki", "Päijänne");
        jarjestelma.yrittaavahentaaVirtaustaJoessa("Hjoki", 4);

        assertTrue(jarjestelma.haeJokiNimella("Hjoki").getVirtaus() == 40);

    }

    @Test
    public void yrittaaVahentaaLiikaaVirtausta() {
        jarjestelma.lisaaJaLuoJoki(44, "Hjoki", "Päijänne");
        jarjestelma.yrittaavahentaaVirtaustaJoessa("Hjoki", 99);
        assertTrue(jarjestelma.haeJokiNimella("Hjoki").getVirtaus() == 0);

    }

    @Test
    public void lisaaMontaJokeaJaVahentaaKeskimmaista() {
        jarjestelma.lisaaJaLuoJoki(44, "Hjoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(45, "Kalajoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(22, "Fjoki", "Päijänne");
        jarjestelma.yrittaavahentaaVirtaustaJoessa("Kalajoki", 20);

        assertTrue(jarjestelma.haeJokiNimella("Kalajoki").getVirtaus() == 25);
    }

    @Test
    public void osaaPoistaaJarvenTest() {
        jarjestelma.poistaJarvi("Päijänne");

        assertNull(jarjestelma.haeJarviNimella("Päijänne"));
    }

    @Test
    public void osaaPoistaaJarvenEiPoistaKaikkia() {
        jarjestelma.lisaaJaLuoJarvi(34, "Silakkajärvi");
        jarjestelma.poistaJarvi("Päijänne");

        assertNotNull(jarjestelma.palautaListaJarvista());
    }

    @Test
    public void osaaPoistaaJoenTest() {

        jarjestelma.lisaaJaLuoJoki(33, "Siikajoki", "Päijänne");
        jarjestelma.poistaJoki("Siikajoki", "Päijänne");

        assertNull(jarjestelma.haeJokiNimella("Siikajoki"));

    }

    @Test
    public void eiPoistaJokeaJosAnnetaanVaaraJarvi() {
        jarjestelma.lisaaJaLuoJarvi(44, "Saimaa");
        jarjestelma.lisaaJaLuoJoki(33, "Siikajoki", "Päijänne");

        assertFalse(jarjestelma.poistaJoki("Siikajoki", "Saimaa"));
    }

    @Test
    public void osaaPoistaaJoenEiPoistaKaikkia() {
        jarjestelma.lisaaJaLuoJoki(33, "Siikajoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(33, "Haukijoki", "Päijänne");
        jarjestelma.poistaJoki("Siikajoki", "Päijänne");

        assertNotNull(jarjestelma.haeJokiNimella("Haukijoki"));
        assertNotNull(jarjestelma.palautaListaJoista());
    }

    @Test
    public void palauttaaListanJoista() {
        jarjestelma.lisaaJaLuoJoki(23, "Siikajoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(12, "Koskijoki", "Päijänne");

        assertNotNull(jarjestelma.palautaListaJoista());
    }

    @Test
    public void palauttaaNullinJosTyhjaListaJokia() {
        jarjestelma.lisaaJaLuoJoki(23, "Siikajoki", "Päijänne");
        jarjestelma.lisaaJaLuoJoki(12, "Koskijoki", "Päijänne");
        jarjestelma.poistaJoki("Siikajoki", "Päijänne");
        jarjestelma.poistaJoki("Koskijoki", "Päijänne");
        assertNull(jarjestelma.palautaListaJoista());
    }

    @Test
    public void palauttaaListanJarvista() {
        jarjestelma.lisaaJaLuoJarvi(567, "Laatokka");
        jarjestelma.palautaListaJarvista();

        assertNotNull(jarjestelma.palautaListaJarvista());                                   //TODO miten tämä tehdään??
    }
    

    @Test
    public void palauttaaNullinJosTyhjaListaJarvia() {
        jarjestelma.poistaJarvi("Päijänne");
        assertNull(jarjestelma.palautaListaJarvista());
    }

    @Test
    public void yrittaaLisataTunnuksiaTiedostosta() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);

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
    public void yrittaaLisataJarviaJaJokiaTiedostosta() {
        jarjestelma.yrittaaLisataJarvetTiedostosta(jtiedosto);
        lukija.close();
        assertTrue(jarjestelma.haeJarviNimella("Kallavesi").getTase()==47);
        assertTrue(jarjestelma.haeJokiNimella("Hjoki").getVirtaus()==1);

    }

//    @Test
//    public void yrittaaLukeaTyhjastaTiedostosta(){
//        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tyhjatiedosto);
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            String[] osat = rivi.split(" ");
//            ttunnukset.put(osat[0], osat[1]);
//        }
//        lukija.close();
//        
//        assertNull(ttunnukset.get("Hharjoittelija").equals("tapanila"));
//    }
    @Test
    public void onnistuuKirjautuminenJarjestelmaan() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("Oopiskelija", "punavuori");
        assertTrue(kj);

    }

    @Test
    public void epaonnistuuKirjautumaanJarjestelmaan() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("Oopiskelija", "tapanila");
        assertFalse(kj);

    }

    @Test
    public void epaonnistuuKirjautumaanSisaan2() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("Oopiskelija", "");
        assertFalse(kj);
    }

    @Test
    public void onnistuuKirjautumaanSelailuJarjestelmaan() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("", "");
        assertTrue(kj);
    }

    @Test
    public void onAdminJarjestelmaTesti() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("Oopiskelija", "punavuori");
        assertTrue(jarjestelma.onkoAdminJarjestelma());
    }

    @Test
    public void eiAdminJarjestelmaTesti() {
        jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto);
        Boolean kj = jarjestelma.kirjautuukoSisaan("", "");
        assertFalse(jarjestelma.onkoAdminJarjestelma());
    }
}
