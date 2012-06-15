/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author lleponie
 */
public class Jarvi implements Comparable{
    
    
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
        }if(vetta >vesitase){
            vesitase = 0;
            return true;
        }
        else
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
    /**
     * Metodi vertailee saatua oliota ja luokan olioilmentymää keskenään
     * @param t
     * @return int  
     */
    @Override
    public int compareTo(Object t) {
        Jarvi verrattava = (Jarvi) t;
        return this.nimi.compareTo(verrattava.getNimi());
        
    }
    
    
}
