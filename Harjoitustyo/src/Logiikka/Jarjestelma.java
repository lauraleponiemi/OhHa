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
    public boolean lisaaJarvi(int vesitase, String nimi) {
        if (haeJarviNimella(nimi) == null) {
            Jarvi jarvi = new Jarvi(vesitase, nimi);
            HashMap<Joki, Integer> jokia = new HashMap<Joki, Integer>();
            tkanta.setJarvi(jarvi, jokia);
            return true;
        } else {
            return false;
        }
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
        return null;
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
     * @return boolean
     */
    public boolean lisaaJoki(int virtaus, String nimi, String jnimi) {
        if (onkoJarviTietokannassa(jnimi) == true) {
            Joki joki = new Joki(virtaus, nimi);
            tkanta.setJoki(joki, virtaus);
            for (Jarvi j : tkanta.getJarvet().keySet()) {
                if (j.getNimi().equals(jnimi)) {
                    for (Joki jj : tkanta.getJarvet().get(j).keySet()) {
                        if (!tkanta.getJarvet().get(j).containsKey(jj)) {
                            tkanta.setJokiJarvelle(joki, j);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
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
        return null;
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
     * palatetaan false.
     *
     * @param nimi järven nimi
     * @param vetta lisättävä vesimäärä (>0)
     * @return boolean
     */
    public boolean yrittaalisataVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
//                jarvi.lisaaVetta(vetta);
                if(jarvi.lisaaVetta(vetta)==true){
                    return true;
                }              
            }
        }return false;
    }

    /**
     * metodi vähentää vettä järvessä. Järven nimi ja vähennettävä vesimäärä
     * annetaan parametrina ja metodi etsii järven tietokannasta. Mikäli järveä
     * ei löydy, palatetaan false.
     *
     * @param nimi järven nimi
     * @param vetta vähennetävä vesimäärä (>0)
     * @return boolean
     */
    public boolean yrittaavahentaaVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) { //TODO metodi näyttää toimivan mutta testit rikkoo
                if(jarvi.vahennaVetta(vetta)==true){
                    return true;
                }             
            } 
        }
        return false;
    }

    /**
     * Metodi lisää virtausta joessa. Parametrina saadaan joen nimi ja luku,
     * mikä lisätään virtaukseen. Jos jokea ei löydy tietokannasta,palatetaan
     * false
     *
     * @param nimi joen nimi
     * @param virtausta lisättävä virtauksen määrä (>0)
     * @return boolean
     */
    public boolean yrittaalisataVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.lisaaVirtausta(virtausta);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi vähentää virtausta joessa. Parametrina saadaan joen nimi ja luku,
     * mikä vähennetään virtauksesta. Jos jokea ei löydy tietokannasta,
     * palatetaan false
     *
     * @param nimi joen nimi
     * @param virtausta vähennettävä määrä (>0)
     * @return boolean
     */
    public boolean yrittaavahentaaVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.vahennaVirtausta(virtausta);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi poistaa järven tietokannasta. Poistettava järven nimi annetaan
     * parametrina ja metodi etsii sen nimeä vastaavan olion tietokannasta. Jos
     * järveä ei löydy, palautetaan false.
     *
     * @param nimi joen nimi, joka poistetaan
     * @return boolean
     */
    public boolean poistaJarvi(String nimi) {
        if (!tkanta.getJarvet().keySet().isEmpty()) {
            if (haeJarviNimella(nimi) != null) {
                Jarvi poistettavaJarvi = haeJarviNimella(nimi);
                tkanta.getJarvet().remove(poistettavaJarvi);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi poistaa joen tietokannasta. Poistettava joen nimi annetaan
     * parametrina ja metodi etsii sen nimeä vastaavan olion tietokannasta. Jos
     * jokea ei löydy, palautetaan false.
     *
     * @param nimi joen nimi, joka poistetaan
     * @return boolean
     */
    public boolean poistaJoki(String nimi) {
        if (!tkanta.getJoet().keySet().isEmpty()) {
            if (haeJokiNimella(nimi) != null) {
                Joki poistettavaJoki = haeJokiNimella(nimi);
                tkanta.getJoet().remove(poistettavaJoki);
                //TODO poistaako joen myös järvien hashmapista?
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa lista tietokantaan tallennetuista järvistä ja siihen
     * liittyvistä joista. Jos tietokannassa ei ole yhtään järveä, siitä
     * ilmoitetaan syötteessä.
     */
    public String palautaListaJarvista() {
        if (tkanta.getJarvet().isEmpty()) {
            return "Lista järvistä on tyhjä";

        } else {
            String teksti = "";
            for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
                if (!tkanta.getJarvet().keySet().isEmpty()) {
                    teksti = teksti + "\n" + ejarvi + "\n" + "Siihen laskevat joet: ";
                    for (Joki joki : tkanta.getJarvet().get(ejarvi).keySet()) {
                        teksti = teksti + joki;
                        teksti = teksti + ", ";
                    }
                }
                teksti = teksti + "\n";
            }
            return teksti;
        }
    }

    /**
     * Metodi palauttaa lista tietokantaan tallennetuista joista. Jos
     * tietokannassa ei ole yhtään jokea, siitä ilmoitetaan syötteessä.
     */
    public String palautaListaJoista() {
        if (tkanta.getJoet().isEmpty()) {
            return "Lista joista on tyhjä";
        } else {
            String teksti = "";
            for (Joki e : tkanta.getJoet().keySet()) {
                teksti = teksti + e + "\n";
            }
            return teksti;
        }

    }

    /**
     * Metodi lisää tunnukset annetusta tiedostosta järjestelmään. Järjestelmään
     * ei voi luoda tunnuksia, sillä ne ovat tiedostossa. Metodi saa
     * parametrinaan tiedoston, josta tunnukset luetaan. Metodi heitää
     * poikkeuksen ja paluttaa false, jos tiedoston lukeminen epäonnistuu. Jos
     * tiedoston lukeminen onnistuu, se lukee tiedostosta käyttäjätunnuksen ja
     * salasanan kahtena osana ja tallentaa sen HashMap:iin. Sitten se sulkee
     * lukijan ja palauttaa true
     *
     * @param tiedosto tiedosto, missä käyttäjätunnus- salasanat parit ovat
     * @return boolean
     */
    public boolean lisaaTunnuksetTiedostosta(File tiedosto) {
        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            return false;
        }
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(" ");
            tunnukset.put(osat[0], osat[1]);
            System.out.println(tunnukset);
        }
        lukija.close();
        return true;

    }

    /**
     * Metodi luo annettujen syötteiden perusteella järjestelmän. Jos
     * käyttäjätunnus ja salasana täsmäävät tunnukset- HashMap:iin, metodi luo
     * adminjärjestelmän. Jos käyttäjä syöttää tyhjän salasana, että
     * käyttäjätunnuskentän, metodi luo opiskelijajarjestelman. Jos
     * kirjautuminen epäonnistuu, järjestelma palauttaa null:in.
     *
     * @param kayttotunnus käyttäjän syöttämä käyttötunnus jota verrataan
     * tiedoston tunnukseen
     * @param salasana käyttäjän syöttämä salasana, jota verrataan annettua
     * käyttötunnusta tiedostossa vastaavaan salasanaan
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
