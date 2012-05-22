
package Kayttoliittyma;

import java.util.HashMap;
import java.util.Scanner;


public class Kayttoliittyma {
    private Scanner lukija;
    
    HashMap < String, String> tunnukset;
    
    
    public Kayttoliittyma(Scanner lukija){
        this.lukija = lukija;
        this.tunnukset = new HashMap < String, String>();
    }

    
    public void kirjauduSisaan(){
        while(true){
            String kayttotunnus = lukija.nextLine();
            String salasana = lukija.nextLine();
            
            for (String ktunnus : tunnukset.keySet()) {
                if(ktunnus.equals(kayttotunnus)&& salasana.equals(tunnukset.get(ktunnus))){
                    kaynnista();
                }
            }
        }
        
    }
    
    public void kaynnista(){
        
    }
    
    public boolean onkoSalasanaOikein(){
        return false;
    }
    
    
    
    
    
}
