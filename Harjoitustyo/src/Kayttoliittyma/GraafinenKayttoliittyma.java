package Kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GraafinenKayttoliittyma {

    public void GraafinenKayttoliittyma() {
    }

    private void luoLiittyma(Container container) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);

        JLabel nimiTeksti = new JLabel("Käyttäjätunnus");
        JTextField nimiKentta = new JTextField();
        JLabel salasanaTeksti = new JLabel("Salasana");
        JTextField salasanaKentta = new JTextField();

        JButton lisaaNappi = new JButton("Login");

        container.add(nimiKentta);
        container.add(salasanaKentta);
        container.add(nimiTeksti);
        container.add(salasanaTeksti);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }
}
