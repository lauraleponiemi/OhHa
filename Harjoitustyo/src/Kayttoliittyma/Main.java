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
        File jtiedosto = new File("jarvet.txt");
        Tietokanta tkanta = new Tietokanta();
        Jarjestelma jarjestelma = new Jarjestelma(tkanta);
        
        Kayttoliittyma liittyma = new Kayttoliittyma(jarjestelma);
        
        SisaanGui sliittyma = new SisaanGui(jarjestelma);
        
        if (jarjestelma.yrittaaLisataTunnuksetTiedostosta(tiedosto) == false) {
            System.out.println("Tunnuksien lisääminen tiedostosta epäonnistui");
        }
        if(jarjestelma.yrittaaLisataJarvetTiedostosta(jtiedosto) == false){
            System.out.println("Järvien ja jokien lisääminen tiedostosta epäonnistui");
        }
        
        //liittyma.kaynnista();
        sliittyma.run();
    }
}
