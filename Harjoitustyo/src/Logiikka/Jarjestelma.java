package Logiikka;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Jarjestelma {

    private Tietokanta tkanta;
    private Scanner lukija;
    private HashMap< String, String> tunnukset;

    public Jarjestelma(Tietokanta tkanta) {
        this.tkanta = tkanta;
        tunnukset = new HashMap<String, String>();
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

    public void lisaaTunnuksetTiedostosta(File tiedosto) {
        Scanner lukija = null;
        String kayttajatunnus;
        String salasana;

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
            System.out.println(osat);
        }
//        System.out.println(tunnukset.get("Lleponiemi"));
        lukija.close();

    }


    public void kirjauduSisaan(String kayttotunnus, String salasana) {
        while (true) {
            kayttotunnus = lukija.nextLine();
            salasana = lukija.nextLine();
  
            
            for (String ktunnus : tunnukset.keySet()) {
                if (ktunnus.equals(kayttotunnus) && salasana.equals(tunnukset.get(ktunnus))) {
                    AdminJarjestelma ajarjestelma = new AdminJarjestelma(tkanta, kayttotunnus);
                    System.out.println("Kirjautuminen onnistui. Tervetuloa tutkijoiden tietokantaan!");
                }
                else if(kayttotunnus.equals(" ") && salasana.equals(" ")){
                    OpiskelijaJarjestelma ojarjestelma = new OpiskelijaJarjestelma(tkanta);
                    System.out.println("Kirjautuminen onnistui. Tervetuloa selailutietokantaan!");
                }else{
                    System.out.println("Kirjautuminen epäonnistui");
                }
                    
            }
        }

    }
}
