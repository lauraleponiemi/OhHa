package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class LisaysKuuntelija implements ActionListener {

    private Jarjestelma jarjestelma;
    private JTextField nimiKentta;
    private JTextField maaraKentta;
    private JTextField jarviNimiKentta;
    private int i;
    private String nimi;
    private String jnimi;

    public LisaysKuuntelija(Jarjestelma jarjestelma, JTextField nimiKentta, JTextField maaraKentta) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.maaraKentta = maaraKentta;
        nimi = nimiKentta.getText();
    }

    public LisaysKuuntelija(Jarjestelma jarjestelma, JTextField nimiKentta, JTextField maaraKentta, JTextField jarviNimiKentta) {
        this.jarjestelma = jarjestelma;
        this.nimiKentta = nimiKentta;
        this.maaraKentta = maaraKentta;
        this.jarviNimiKentta = jarviNimiKentta;
        nimi = nimiKentta.getText();
        jnimi = jarviNimiKentta.getText();
    }

    public void muuttaaTekstikentanNumeroksi(JTextField nimiKentta, JTextField maaraKentta) {
        try {
            i = Integer.parseInt(maaraKentta.getText());
            System.out.println("luku: " + i);
        } catch (NumberFormatException x) {
            System.out.println("Error : " + x.getMessage());
        }
    }

    public void muuttaaTekstikentanStringiksi() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Lisää järvi")) {
            System.out.println("lisätään järvi");
            jarjestelma.lisaaJaLuoJarvi(i, nimi);
        }
        if (ae.getActionCommand().equals("Lisää joki")) {
            System.out.println("lisätään joki");
            jarjestelma.lisaaJaLuoJoki(i, nimi, jnimi);

        }
    }
}
