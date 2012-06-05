package Kayttoliittyma;

import Logiikka.Jarjestelma;
import Logiikka.Jarvi;
import Logiikka.Joki;
import Logiikka.Tietokanta;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        File tiedosto = new File("tunnukset.txt");

        Tietokanta tkanta = new Tietokanta();
        Jarjestelma jarjestelma = new Jarjestelma(tkanta);
        Kayttoliittyma liittyma = new Kayttoliittyma(jarjestelma);
//      Gui liittyma = new Gui();
        if (jarjestelma.lisaaTunnuksetTiedostosta(tiedosto) == false) {
            System.out.println("Tunnuksien lisääminen tiedostosta epäonnistui");
        }
        Joki kjoki = new Joki(15, "Kalajoki");
        Joki hjoki = new Joki(44, "Haapajoki");
        Jarvi jjarvi = new Jarvi(67, "Saimaa");
        tkanta.setJoki(hjoki, hjoki.getVirtaus());
        tkanta.setJoki(kjoki, kjoki.getVirtaus());
        jarjestelma.lisaaJarvi(67, "Saimaa");
        jarjestelma.lisaaJarvi(88, "Päijänne");
        tkanta.setJokiJarvelle(hjoki, jjarvi);
        tkanta.setJokiJarvelle(kjoki, jjarvi);



        liittyma.kaynnista();
//      liittyma.run();
    }
}
