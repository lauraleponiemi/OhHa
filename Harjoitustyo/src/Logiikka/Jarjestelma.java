package Logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jarjestelma {

    private Tietokanta tkanta;
    private Scanner lukija;
    public HashMap< String, String> tunnukset;

    public Jarjestelma(Tietokanta tkanta) {
        this.tkanta = tkanta;
        tunnukset = new HashMap<String, String>();
    }

    public Tietokanta getTietokanta() {
        return tkanta;
    }

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

    public String haeJarvi(Jarvi jarvi) {
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            if (ejarvi.equals(jarvi)) {
                return ejarvi.getNimi();
            }
        }
        return "Jarvea ei löytynyt";
    }

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

    public boolean onkoJarviTietokannassa(String nimi) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                return true;
            }
            System.out.println("Tarkista oikeinkirjoitus, tai sitten järveä ei ole tietokannassa, luo ensin järvi mihin voi liittää joen");
        }
        return false;
    }

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

    public String haeJoki(Joki joki) {
        for (Joki ejoki : tkanta.getJoet().keySet()) {
            if (ejoki.equals(joki)) {
                return ejoki.getNimi();
            }
        }
        return "Jokea ei löytynyt";
    }
    
//TODO käytetäänkö tätä metodia missään????
    public Joki palautaJoki(String nimi) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                return joki;
            }
        }
        return null;
    }

    public void lisaaVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                jarvi.lisaaVetta(vetta);
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta");
            }
        }
    }

    public void vahennaVettaJarvessa(String nimi, int vetta) {
        for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
            if (jarvi.getNimi().equals(nimi)) {
                jarvi.vahennaVetta(vetta);
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta");
            }
        }
    }

    public void lisaaJokiOlio(Joki joki) {
    }

    public void lisaaVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.lisaaVirtausta(virtausta);
            } else {
                System.out.println("Jokea ei löytynyt tietokannasta");
            }

        }
    }

    public void vahennaVirtaustaJoessa(String nimi, int virtausta) {
        for (Joki joki : tkanta.getJoet().keySet()) {
            if (joki.getNimi().equals(nimi)) {
                joki.vahennaVirtausta(virtausta);
            } else {
                System.out.println("Jokea ei löytynyt tietokannasta");
            }
        }
    }

    public void poistaJarvi(String nimi) {
        if (!tkanta.getJarvet().keySet().isEmpty()) {
            for (Jarvi jarvi : tkanta.getJarvet().keySet()) {
                if (jarvi.getNimi().equals(nimi)) {
                    tkanta.getJarvet().remove(jarvi);
                    //TODO: ^ poistaako järven vai vain joki-hashmapin?
                }
            }
        }
    }

    public void poistaJoki(String nimi) {
        if (!tkanta.getJoet().keySet().isEmpty()) {
            for (Joki joki : tkanta.getJoet().keySet()) {
                if (joki.getNimi().equals(nimi)) {
                    tkanta.getJoet().remove(joki);
                    //TODO ^poistaako joen, vai vain integerin?
                }
            }
        }
    }

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

    public void palautaListaJoista() {
        if (tkanta.getJoet().isEmpty()) {
            System.out.println("Lista joista on tyhjä");
        } else {
            for (Joki e : tkanta.getJoet().keySet()) {
                System.out.println(e);
            }
        }
    }

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
