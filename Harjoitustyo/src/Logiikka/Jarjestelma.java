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
 //TODO: nämä eivät toimi :(   
    public ArrayList palautaListaJarvista(){
        ArrayList jarvet = new ArrayList();
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            jarvet.add(ejarvi);
        }       
        return jarvet;
    }
    
    public ArrayList palautaListaJoista(){
        ArrayList joet = new ArrayList();
        for (Joki e : tkanta.getJoet().keySet()) {
            joet.add(e);
        }
        return joet;
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
        AdminJarjestelma luokka = new AdminJarjestelma(tkanta, kayttotunnus);
        System.out.println(luokka.getClass().getCanonicalName());
        
        if (tunnukset.containsKey(kayttotunnus)){
            if(tunnukset.get(kayttotunnus).equals(salasana)){
                AdminJarjestelma ajarjestelma = new AdminJarjestelma(tkanta, kayttotunnus);
                return ajarjestelma;
            }                     
        }
        else if (kayttotunnus.equals("") && salasana.equals("")){
            OpiskelijaJarjestelma ojarjestelma = new OpiskelijaJarjestelma(tkanta);
            return ojarjestelma; 
        }
        return null;
    }
}
