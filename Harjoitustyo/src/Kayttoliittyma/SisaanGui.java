package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class SisaanGui implements Runnable {

    private JFrame frame;
    Jarjestelma jarjestelma;

    public SisaanGui(Jarjestelma jarjestelma) {
        if (jarjestelma == null) {
            System.out.println("sisaanguissa parametrina null");
        }
        this.jarjestelma = jarjestelma;
        if (this.jarjestelma == null) {
            System.out.println("sisaanguissa järjestelmä null");
        }
    }
    
    /**
     * Graafisen käyttöjärjestelmän käynnistys ja ikkunan luonti. 
     */
    
    @Override
    public void run() {
        frame = new JFrame("Sisäänkirjautuminen vesistömallijärjestelmään");
        frame.setPreferredSize(new Dimension(500, 150));
       
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3,2);
        container.setLayout(layout);
        //JLabel teksti = new JLabel("Syötä käyttäjätunnus ja salasana, tai paina Enter kaksi kertaa");
        JLabel nimiTeksti = new JLabel("  Käyttäjätunnus: ");
        JTextField nimiKentta = new JTextField();
        JLabel salasanaTeksti = new JLabel("  Salasana: ");
        JPasswordField salasanaKentta = new JPasswordField();
        
        JButton loginnappi = new JButton("Login");
        SisaanKirjautumisKuuntelija kuuntelija = new SisaanKirjautumisKuuntelija(jarjestelma, nimiKentta, salasanaKentta);
        loginnappi.addActionListener(kuuntelija);
        
//        container.add(teksti, BorderLayout.NORTH);
        container.add(nimiTeksti);
        container.add(nimiKentta);
        container.add(salasanaTeksti);
        container.add(salasanaKentta);       
        container.add(new JLabel(""));
        container.add(loginnappi, BorderLayout.SOUTH);
        
    }
}
