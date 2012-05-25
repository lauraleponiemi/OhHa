
package Logiikka;

import java.util.HashMap;


public class Tietokanta {
    
    private HashMap <Joki, Integer> joet; 
    private HashMap <Jarvi, HashMap <Joki, Integer>> jarvet;
    
    public Tietokanta(){
        this.joet = new HashMap< Joki, Integer>();
        this.jarvet= new HashMap< Jarvi, HashMap <Joki, Integer>>();
    }

    public void setJarvet(HashMap<Jarvi, HashMap<Joki, Integer>> jarvet) {
        this.jarvet = jarvet;
    }

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
