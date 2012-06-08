
package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class KirjautumisKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private JTextField salasanaKentta;
    private Jarjestelma jarjestelma;
    

    public KirjautumisKuuntelija(Jarjestelma jarjestelma, JTextField nimiKentta, JTextField salasanaKentta) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.salasanaKentta = salasanaKentta;
        
    }
    /**
     * Metodissa tarkistetaan vastaavatko annettu käyttäjätunnus siihen liitettyä salasanaa.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
      KayttoGui kg = new KayttoGui(jarjestelma);  //miksi tulee NullPointerError seuraavalta riviltä?
      if(jarjestelma.kirjautuukoSisaanGui(nimiKentta.getText(), salasanaKentta.getText())== true){
          kg.run();
      }
//      Jarjestelma j =  jarjestelma.kirjauduSisaan(nimiKentta.getText(), salasanaKentta.getText()); 
//      if(j==null){  
//          return;
//      }
      
      
        
    }
}
