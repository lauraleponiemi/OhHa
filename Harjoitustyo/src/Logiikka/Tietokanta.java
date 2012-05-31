
package Logiikka;

import java.util.HashMap;


public class Tietokanta {
    
    private HashMap <Joki, Integer> joet; 
    private HashMap <Jarvi, HashMap <Joki, Integer>> jarvet;
    
    public Tietokanta(){
        this.joet = new HashMap< Joki, Integer>();
        this.jarvet= new HashMap< Jarvi, HashMap <Joki, Integer>>();
    }

    public void setJarvi(Jarvi j, HashMap<Joki, Integer> joet) {
        jarvet.put(j, joet);
        
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
