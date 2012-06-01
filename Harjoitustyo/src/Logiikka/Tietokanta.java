
package Logiikka;

import java.util.HashMap;


public class Tietokanta {
    
    /**
     * lista joista. Integer on kyseisen joen virtaus
     */
    private HashMap <Joki, Integer> joet; 
    
    /**
     * lista järvistä ja niihin liittyvistä joista
     */
    private HashMap <Jarvi, HashMap <Joki, Integer>> jarvet;
    
    /**
     * Konstruktorissa luodaan HashMap joille, ja järville ja joille, kun luokasta luodaan ilmentymä
     */
    public Tietokanta(){
        this.joet = new HashMap< Joki, Integer>();
        this.jarvet= new HashMap< Jarvi, HashMap <Joki, Integer>>();
    }

    /**
     * Metodi tallentaa parametrina saadun järven ja joet tietokantaan. 
     * Metodi saa parametrina jarven ja HashMapin järveen liittyvistä joista
     * @param j parametrina saatu jarvi
     * @param joet HashMap joista jotka liittyvät järveen
     */
    public void setJarvi(Jarvi j, HashMap<Joki, Integer> joet) {
        jarvet.put(j, joet);
        
    }
    
    /**
     * Metodi tallentaa saadun jokitaulukon tietokantaan. Tämä on varmuustiedosto, jos järven poiston
     * yhteydessä joet poistuisivat, ne löytyvät myös täältä.
     * @param joet parametrina saatu lista joista ja niiden virtauksista
     */
    public void setJoet(HashMap<Joki, Integer> joet) {
        this.joet = joet;
    }

    public HashMap<Jarvi, HashMap<Joki, Integer>> getJarvet() {
        return jarvet;
    }

    public HashMap<Joki, Integer> getJoet() {
        return joet;
    }
    
}
