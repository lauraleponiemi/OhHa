
package Kayttoliittyma;

import Logiikka.Jarjestelma;
import Logiikka.Tietokanta;
import java.io.File;




public class Main {
    public static void main(String[] args) {
      
      File tiedosto = new File("tunnukset.txt");  
        
      Tietokanta tkanta = new Tietokanta();  
      Jarjestelma jarjestelma = new Jarjestelma(tkanta);  
      Kayttoliittyma liittyma = new Kayttoliittyma(jarjestelma);
      jarjestelma.lisaaTunnuksetTiedostosta(tiedosto);
      jarjestelma.palautaListaJarvista();
      jarjestelma.palautaListaJoista();
      
      liittyma.kaynnista();  
    }
}
