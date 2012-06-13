package Kayttoliittyma;

import Logiikka.Jarjestelma;
import Logiikka.Jarvi;
import Logiikka.Joki;
import Logiikka.Tietokanta;
import java.io.File;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        File tiedosto = new File("tunnukset.txt");

        Tietokanta tkanta = new Tietokanta();
        Jarjestelma jarjestelma = new Jarjestelma(tkanta);
        //KayttoGui gui = new KayttoGui(jarjestelma);
        //Kayttoliittyma liittyma = new Kayttoliittyma(jarjestelma);
        SisaanGui sliittyma = new SisaanGui(jarjestelma);
        if (jarjestelma.lisaaTunnuksetTiedostosta(tiedosto) == false) {
            System.out.println("Tunnuksien lisääminen tiedostosta epäonnistui");
        }
        Joki kjoki = new Joki(15, "Kalajoki");
        Joki hjoki = new Joki(44, "Haapajoki");
        Jarvi jjarvi = new Jarvi(67, "Saimaa");
        HashMap joet = new HashMap<Joki, Integer>();
        
        tkanta.setJoki(hjoki, hjoki.getVirtaus());
        tkanta.setJoki(kjoki, kjoki.getVirtaus());
//        jarjestelma.lisaaJaLuoJarvi(jjarvi.getTase(), jjarvi.getNimi());
        jarjestelma.lisaaJaLuoJarvi(88, "Päijänne");
        tkanta.setJarvi(jjarvi,joet);
        tkanta.setJokiJarvelle(hjoki, jjarvi);
        tkanta.setJokiJarvelle(kjoki, jjarvi);



        //liittyma.kaynnista();
        sliittyma.run();
        //gui.run();
    }
}
