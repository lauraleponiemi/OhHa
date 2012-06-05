
package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class HenkilonLisaysKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private JTextField salasanaKentta;
    private Jarjestelma jarjestelma;

    public HenkilonLisaysKuuntelija(Jarjestelma jarjestelma, JTextField nimiKentta, JTextField salasanaKentta) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.salasanaKentta = salasanaKentta;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        jarjestelma.kirjauduSisaan(nimiKentta.getText(), salasanaKentta.getText());
//        if(0>r){
//            
//        }
        
    }
}
