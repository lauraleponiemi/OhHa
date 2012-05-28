
package Logiikka;

import java.util.HashMap;




public class AdminJarjestelma extends Jarjestelma{
    
//    private String kayttajatunnus;
    private Tietokanta tkanta;
    private Jarjestelma jarjestelma;
    
    
    public AdminJarjestelma(Tietokanta tkanta){
            super(tkanta);
//            this.kayttajatunnus = kayttajatunnus;
            this.jarjestelma = new Jarjestelma(tkanta);
            
    }
    
    public void lisaaJoki(Joki jokujoki, int virtaus){
        tkanta.getJoet().put(jokujoki, virtaus);
        
    }
    public void lisaaJarvi(Jarvi jokujarvi){
        tkanta.getJarvet().put(jokujarvi, new HashMap <Joki, Integer>());
    }
    
    public void poistaJoki(Joki jokujoki){
        tkanta.getJoet().remove(jokujoki);
    }
    

}
