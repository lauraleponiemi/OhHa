
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
      Kayttoliittyma liittyma = new Kayttoliittyma(jarjestelma);
      jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);
      
      Joki kjoki = new Joki(15, "Kalajoki");
      Joki hjoki = new Joki(44, "Haapajoki");
      Jarvi jjarvi = new Jarvi(67, "Saimaa");
      HashMap <Joki, Integer> joet = new HashMap <Joki, Integer>();
      joet.put(hjoki, 15);
      joet.put(hjoki, 44);
      HashMap <Jarvi,HashMap<Joki, Integer>> jarvet = new HashMap <Jarvi, HashMap<Joki, Integer>>();
      jarvet.put(jjarvi, joet);
      tkanta.setJoet(joet);
      tkanta.setJarvet(jarvet);
      
      liittyma.kaynnista();  
    }
}
