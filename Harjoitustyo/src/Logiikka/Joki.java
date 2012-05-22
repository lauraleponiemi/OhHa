
package Logiikka;


public class Joki {
    
    private String nimi;
    private int virtaus;
    
    
    public Joki(){
        this.nimi = nimi;
        this.virtaus = virtaus;
    }
    
    public void lisaaVirtausta(int virtausta){
        if(0 < virtausta){
            virtaus = virtaus + virtausta;
        }
    }
    public void vahennaVirtausta(int virtausta){
        if(virtaus-virtausta > 0){
            virtaus = virtaus - virtausta;
        }else
            System.out.println("Virtausta ei voi muuttaa negatiiviseksi");
        
    }
    
    public String getNimi(){
        return nimi;
    }
    
    public int getVirtaus(){
        return virtaus;
    }
    
    public String toString(){
        return nimi+"; virtaus tässä joessa on "+virtaus+" kuutioneliömetriä";
    }
    
    
}
