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

    public String haeJarvi(Jarvi jarvi) {
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            if (ejarvi.equals(jarvi)) {
                return ejarvi.toString();
            }
        }
        return "Jarvea ei löytynyt";
    }

    public String haeJoki(Joki joki) {
        for (Joki ejoki : tkanta.getJoet().keySet()) {
            if (ejoki.equals(joki)) {
                return ejoki.toString();
            }
        }
        return "Jokea ei löytynyt";

    }

    public void lisaaJarvi(int vesitase, String nimi) {
        Jarvi jarvi = new Jarvi(vesitase, nimi);
        HashMap<Joki, Integer> jokia = new HashMap<Joki, Integer>();
        HashMap<Jarvi, HashMap<Joki, Integer>> uudenJarvenMap = new HashMap<Jarvi, HashMap<Joki, Integer>>();
        uudenJarvenMap.put(jarvi, jokia);
        tkanta.setJarvet(uudenJarvenMap);
    }

    public void lisaaJoki(int virtaus, String nimi) {
        Joki joki = new Joki(virtaus, nimi);
        HashMap<Joki, Integer> jokia = new HashMap<Joki, Integer>();
        jokia.put(joki, virtaus);
        //TODO
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
        //TODO miksi palauttaa saman tulostuksen kuin järvissä?????



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
//            System.out.println(osat);
        }
//        System.out.println(tunnukset.get("Lleponiemi"));
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
