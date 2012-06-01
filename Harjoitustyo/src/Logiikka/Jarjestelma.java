package Logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jarjestelma {

    private Tietokanta tkanta;
    private Scanner lukija;
    private HashMap< String, String> tunnukset;

    /**
     * Jarjestelman konstruktori ottaa parametrinään tietokannan, tallentaa sen
     * ja luo HashMapin käyttäjätunnuksille
     *
     * @param tkanta
     */
    public Jarjestelma(Tietokanta tkanta) {
        this.tkanta = tkanta;
        tunnukset = new HashMap<String, String>();
    }

    /**
     * Metodi palauttaa järjestelmän käyttämän tietokannan olion
     *
     * @return tkanta
     */
    public Tietokanta getTietokanta() {
        return tkanta;
    }

    /**
     * Metodi lisaa jarven tietokantaansa. Se luo uuden olion, joka saa
     * parametrikseen annetun nimen ja vesi taseen. Jarveen voi liittyä myös
     * monia jokia, joten luodaan sitä varten HashMap johon voi tallentaa
     * joki-olioita ja sen virtauksen. Järvet tallennetaan siis tietokantaan
     * metodilla joka saa jarvi-olion ja juuri luodun Hashmapin
     *
     * @param vesitase jarvelle parametrina annettu vesitase
     * @param nimi jarvelle annettu nimi
     */
    public void lisaaJarvi(int vesitase, String nimi) {
//        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
//            if (jarvi.getNimi().equals(nimi)) {
//                System.out.println("Järvi on jo tietokannassa. Siirry muuttamaan järven tietoja.");
//            } else {
        Jarvi jarvi = new Jarvi(vesitase, nimi);
        HashMap<Joki, Integer> jokia = new HashMap<Joki, Integer>();
        tkanta.setJarvi(jarvi, jokia);
// TODO miksei kommentoitu koodi toimi ??
//            }
//        }

    }

    /**
     * Metodi hakee tietokannasta jarvi-olin ja palauttaa sen nimen.
     *
     * @param jarvi
     * @return jarven nimi
     */
    public String haeJarvi(Jarvi jarvi) {
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            if (ejarvi.equals(jarvi)) {
                return ejarvi.getNimi();
            }
        }
        return "Jarvea ei löytynyt";
    }

    /**
     * Metodi hakee jarven nimen, kun sille annetaan jarvi-olio.
     *
     * @param nimi jarven nimi
     * @return Jarvi jarvi nimen omistava jarvi-olio
     */
    public Jarvi haeJarviNimella(String nimi) {
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            if (ejarvi.getNimi().equals(nimi)) {
                return ejarvi;
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta");
            }
        }
        return null;
    }

    /**
     * Metodi etsii jarvea tietokannasta sen nimella. Jos jarvea ei löytynyt, se
     * palauttaa false, jos löytyy, se palauttaa true.
     *
     * @param nimi
     * @return boolean
     */
    public boolean onkoJarviTietokannassa(String nimi) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                return true;
            }
            System.out.println("Tarkista oikeinkirjoitus, tai sitten järveä ei ole tietokannassa, luo ensin järvi mihin voi liittää joen");
        }
        return false;
    }

    /**
     * Metodi lisää järjestelmään joen. Jos joki on jo tietokannassa, siitä
     * ilmoitetaan syötteessä.
     *
     * @param virtaus joelle annettu virtaus
     * @param nimi joelle annettu nimi
     * @param jnimi järven nimi, johon joki laskee
     */
    public void lisaaJoki(int virtaus, String nimi, String jnimi) {
        if (onkoJarviTietokannassa(jnimi) == true) {
            Joki joki = new Joki(virtaus, nimi);
            HashMap<Joki, Integer> jokia = new HashMap<Joki, Integer>();
            jokia.put(joki, virtaus);
            tkanta.setJoet(jokia);
//            tkanta.setJarvi(haeJarviNimella("jnimi"), jokia.put(joki, virtaus));
            for (Jarvi j : tkanta.getJarvet().keySet()) {
                if (j.getNimi().equals(jnimi)) {
                    for (Joki jj : tkanta.getJarvet().get(j).keySet()) {
                        if (!tkanta.getJarvet().get(j).containsKey(jj)) {
                            tkanta.getJarvet().get(j).put(joki, virtaus);
                        } else {
                            System.out.println("Joki on jo tietokannassa.");
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi hakee joen nimen, kun sille annetaan jokiolio. Jos jokea ei löydy,
     * siitä ilmoitetaan syötteessä.
     *
     * @param joki
     * @return String joen nimi
     */
    public String haeJoki(Joki joki) {
        for (Joki ejoki : tkanta.getJoet().keySet()) {
            if (ejoki.equals(joki)) {
                return ejoki.getNimi();
            }
        }
        return "Jokea ei löytynyt";
    }

//TODO Käytetään tällä hetkellä lähinnä testauksessa..
    /**
     * Metodi palauttaa jokiolion, kun annetaan parametrina joen nimi.
     *
     * @param nimi joen nimi
     * @return Joki joki
     */
    public Joki haeJokiNimella(String nimi) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                return joki;
            }
        }
        return null;
    }

    /**
     * Metodi lisää vettä järvessä. Järven nimi ja lisättävä vesimäärä annetaan
     * parametrina ja metodi etsii järven tietokannasta. Mikäli järveä ei löydy,
     * siitä ilmoitetaan syötteessä.
     *
     * @param nimi järven nimi
     * @param vetta lisättävä vesimäärä (>0)
     */
    public void lisaaVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                jarvi.lisaaVetta(vetta);
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta. Luo ensin järvi");
            }
        }
    }

    /**
     * metodi vähentää vettä järvessä. Järven nimi ja vähennettävä vesimäärä
     * annetaan parametrina ja metodi etsii järven tietokannasta. Mikäli järveä
     * ei löydy, siitä ilmoitetaan syötteessä.
     *
     * @param nimi järven nimi
     * @param vetta vähennetävä vesimäärä (>0)
     */
    public void vahennaVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                jarvi.vahennaVetta(vetta);
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta");
            }
        }
    }

//    public void lisaaJokiOlio(Joki joki) {
//    }
    /**
     * Metodi lisää virtausta joessa. Parametrina saadaan joen nimi ja luku,
     * mikä lisätään virtaukseen. Jos jokea ei löydy tietokannasta, siitä
     * ilmoitetaan syötteessä.
     *
     * @param nimi joen nimi
     * @param virtausta lisättävä virtauksen määrä (>0)
     */
    public void lisaaVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.lisaaVirtausta(virtausta);
            } else {
                System.out.println("Jokea ei löytynyt tietokannasta");
            }

        }
    }

    /**
     * Metodi vähentää virtausta joessa. Parametrina saadaan joen nimi ja luku,
     * mikä vähennetään virtauksesta. Jos jokea ei löydy tietokannasta, siitä
     * ilmoitetaan syötteessä.
     *
     * @param nimi joen nimi
     * @param virtausta vähennettävä määrä (>0)
     */
    public void vahennaVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.vahennaVirtausta(virtausta);
            } else {
                System.out.println("Jokea ei löytynyt tietokannasta");
            }
        }
    }

    /**
     * Metodi poistaa järven tietokannasta. Poistettava järven nimi annetaan
     * parametrina ja metodi etsii sen nimeä vastaavan olion tietokannasta. Jos
     * järveä ei löydy, siitä ilmoitetaan syötteessä.
     *
     * @param nimi joen nimi, joka poistetaan
     */
    public void poistaJarvi(String nimi) {
        if (!tkanta.getJarvet().keySet().isEmpty()) {
            for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
                if (jarvi.getNimi().equals(nimi)) {
                    tkanta.getJarvet().remove(jarvi);
                    //TODO: ^ poistaako järven vai vain joki-hashmapin?
                } else {
                    System.out.println("Järveä ei löytynyt tietokannasta");
                }
            }
        }
    }

    /**
     * Metodi poistaa joen tietokannasta. Poistettava joen nimi annetaan
     * parametrina ja metodi etsii sen nimeä vastaavan olion tietokannasta. Jos
     * jokea ei löydy, siitä ilmoitetaan syötteessä.
     *
     * @param nimi joen nimi, joka poistetaan
     */
    public void poistaJoki(String nimi) {
        if (!tkanta.getJoet().keySet().isEmpty()) {
            for (Joki joki : tkanta.getJoet().keySet()) {
                if (joki.getNimi().equals(nimi)) {
                    tkanta.getJoet().remove(joki);
                    //TODO ^poistaako joen, vai vain integerin?
                }else {
                    System.out.println("Jokea ei löytynyt tietokannasta");
                }
            }
        }
    }

    /**
     * Metodi palauttaa lista tietokantaan tallennetuista järvistä ja siihen liittyvistä joista. 
     * Jos tietokannassa ei ole yhtään järveä, siitä ilmoitetaan syötteessä. 
     */    
    public void palautaListaJarvista() {
        if (tkanta.getJarvet().isEmpty()) {
            System.out.println("Lista järvistä on tyhjä");

        } else {
            for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
                if (!tkanta.getJarvet().keySet().isEmpty()) {
                    for (Joki joki : tkanta.getJarvet().get(ejarvi).keySet()) {
                        System.out.println(ejarvi + "\n" + "   järveen laskevat joet: " + joki);
                    }
                }
            }
        }
    }
    /**
     * Metodi palauttaa lista tietokantaan tallennetuista joista.
     * Jos tietokannassa ei ole yhtään jokea, siitä ilmoitetaan syötteessä.
     */
    public void palautaListaJoista() {
        if (tkanta.getJoet().isEmpty()) {
            System.out.println("Lista joista on tyhjä");
        } else {
            for (Joki e : tkanta.getJoet().keySet()) {
                System.out.println(e);
            }
        }
    }

    /**
     * Metodi lisää tunnukset annetusta tiedostosta järjestelmään. Järjestelmään ei voi luoda
     * tunnuksia, sillä ne ovat tiedostossa. Metodi saa parametrinaan tiedoston, josta tunnukset 
     * luetaan. Metodi heitää poikkeuksen jos tiedoston lukeminen epäonnistuu, mutta jos onnistuu,
     * se lukee tiedostosta käyttäjätunnuksen ja salasanan kahtena osana ja tallentaa sen HashMap:iin.
     * Sitten se sulkee lukija
     * @param tiedosto tiedosto, missä käyttäjätunnus- salasanat parit ovat
     */    
    public void lisaaTunnuksetTiedostosta(File tiedosto) {

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
            return;
        }
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" ");
            tunnukset.put(osat[0], osat[1]);
            System.out.println(tunnukset);
        }
        lukija.close();

    }
    
    /**
     * Metodi luo annettujen syötteiden perusteella järjestelmän. Jos käyttäjätunnus ja 
     * salasana täsmäävät tunnukset- HashMap:iin, metodi luo adminjärjestelmän. Jos käyttäjä syöttää 
     * tyhjän salasana, että käyttäjätunnuskentän, metodi luo opiskelijajarjestelman. Jos kirjautuminen epäonnistuu,
     * järjestelma palauttaa null:in.
     * @param kayttotunnus käyttäjän syöttämä käyttötunnus jota verrataan tiedoston tunnukseen
     * @param salasana käyttäjän syöttämä salasana, jota verrataan annettua käyttötunnusta tiedostossa vastaavaan salasanaan
     * @return Jarjestelma 
     */
    public Jarjestelma kirjauduSisaan(String kayttotunnus, String salasana) {
//        AdminJarjestelma luokka = new AdminJarjestelma(tkanta);
//        System.out.println(luokka.getClass().getCanonicalName());

        if (tunnukset.containsKey(kayttotunnus)) {
            if (tunnukset.get(kayttotunnus).equals(salasana)) {
                AdminJarjestelma ajarjestelma = new AdminJarjestelma(tkanta);
                return ajarjestelma;
            }
        } else if (kayttotunnus.equals("") && salasana.equals("")) {
            OpiskelijaJarjestelma ojarjestelma = new OpiskelijaJarjestelma(tkanta);
            return ojarjestelma;
        }
        return null;
    }
}
