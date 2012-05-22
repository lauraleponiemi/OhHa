
package Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class HenkilonLisaysKuuntelija implements ActionListener {

    private HenkiloDAO henkiloDao;
    private JTextField nimiKentta;
    private JTextField salasanaKentta;

    public HenkilonLisaysKuuntelija(HenkiloDAO henkiloDao, JTextField nimiKentta, JTextField salasanaKentta) {
        this.henkiloDao = henkiloDao;
        this.nimiKentta = nimiKentta;
        this.salasanaKentta = salasanaKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Henkilo henkilo = new Henkilo(nimiKentta.getText(), salasanaKentta.getText());
        this.henkiloDao.talleta(henkilo);
    }
}
