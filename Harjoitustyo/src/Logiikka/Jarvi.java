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
    
    public Jarvi(int vesitase){
        this.nimi = nimi;
        this.vesitase = vesitase;
        
    }
    
    public void lisaaVetta(int vetta){
        vesitase = vesitase + vetta;
    }
    
    public void vahennaVetta(int vetta){
        if(vesitase >= vetta){
            vesitase = vesitase -vetta;
        }
        else
            vesitase = 0;
    }
    
    public String getNimi(){
        return nimi;
    }
    public int getTase(){
        return vesitase;
    }
    
    public String toString(){
        return nimi+"; vesitase tässä järvessä on "+ vesitase +" kuutiometriä";
    }
    
    
}
