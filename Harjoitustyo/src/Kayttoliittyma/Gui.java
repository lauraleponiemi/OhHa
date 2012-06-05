package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Gui implements Runnable {

    private JFrame frame;
    Jarjestelma jarjestelma;

    public void Gui(Jarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Sisäänkirjautuminen vesistömallijärjestelmään");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);
//        JLabel teksti = new JLabel("Syötä käyttäjätunnus ja salasana, tai paina Enter kaksi kertaa");
        JLabel nimiTeksti = new JLabel("Käyttäjätunnus");
        JTextField nimiKentta = new JTextField();
        JLabel salasanaTeksti = new JLabel("Salasana");
        JTextField salasanaKentta = new JTextField();
        
        JButton loginnappi = new JButton("Login");
        HenkilonLisaysKuuntelija kuuntelija = new HenkilonLisaysKuuntelija(jarjestelma, nimiKentta, salasanaKentta);
        loginnappi.addActionListener(kuuntelija);
        
//        container.add(teksti);
        container.add(nimiKentta);
        container.add(salasanaKentta);
        container.add(nimiTeksti);
        container.add(salasanaTeksti);
        container.add(new JLabel(""));
        container.add(loginnappi, BorderLayout.SOUTH);
        
    }
}
