/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author lleponie
 */
public class Jarvi {
    
    
    private String nimi;
    private int vesitase;
    
    public Jarvi(int vesitase, String nimi){
        this.vesitase = vesitase;
        this.nimi = nimi;
    }

    /**
     * Metodi lisaa vetta jarveen. Parametrina annettu "vetta" lisätään jarven taseeseen.
     * 
     * @param vetta lisättävä vesimäärä (> 0)
     */
    public boolean lisaaVetta(int vetta){
        if(vetta < 0){
//            vetta = 0;
            return false;
        }
        vesitase = vesitase + vetta;
        return true;
        
    }
    
    /**
     * metodi vähentää vettä järvestä. Parametrina annettu "vetta" vähennetään jarven taseesta.
     * @param vetta vähennettävä vesimäärä (> 0)
     */
    public boolean vahennaVetta(int vetta){
        if(vesitase >= vetta){
            vesitase = vesitase -vetta;
            return true;
        }
        else
//            vesitase = 0;
            return false;
    }
    
    public String getNimi(){
        return nimi;
    }
    public int getTase(){
        return vesitase;
    }
    
    public String toString(){
        return nimi+"("+ vesitase+")" ;
    }
    
    
}
