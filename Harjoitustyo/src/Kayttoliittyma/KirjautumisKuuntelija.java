
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
        if (jarjestelma == null) {
        System.out.println("järjestelmä null");
        }
        this.nimiKentta = nimiKentta;
        this.salasanaKentta = salasanaKentta;       
    }
    /**
     * Metodissa tarkistetaan vastaavatko annettu käyttäjätunnus siihen liitettyä salasanaa.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        KayttoGui kg = new KayttoGui(jarjestelma);
        if(nimiKentta.getText()== null && salasanaKentta.getText()== null){
            nimiKentta.getText().equals(" ");
            salasanaKentta.getText().equals(" "); 
            jarjestelma.kirjautuukoSisaan(nimiKentta.getText(), salasanaKentta.getText());
        }
        if(jarjestelma.kirjautuukoSisaan(nimiKentta.getText(), salasanaKentta.getText())== true){
          kg.run();
      }        
    }
}
