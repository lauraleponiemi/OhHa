package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KayttoGui implements Runnable {

    private JFrame frame;
    Jarjestelma jarjestelma;
    private KeyListener nkuuntelija;

    public KayttoGui(Jarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
        NapinKuuntelija nkuuntelija = new NapinKuuntelija(this);
    }

    @Override
    public void run() {
        frame = new JFrame("Tervetuloa vesistömallijärjestelmään!");
        frame.setPreferredSize(new Dimension(500, 200));
//        frame.addActionListener(new ValintaKuuntelija(this));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoPerusKomponentit(frame.getContentPane());
        luoAdminKomponentit(frame.getContentPane());
        if (jarjestelma.onkoAdminJarjestelma() == true) {
            luoAdminKomponentit(frame.getContentPane());
        }
//       NapinKuuntelija nkuuntelija = new NapinKuuntelija(this);

        frame.pack();
        frame.setVisible(true);
    }

    private void luoPerusKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Valitse toiminto: "));

        JButton lopeta = new JButton(" Lopetus");
        JButton jarvet = new JButton(" Avaa lista tietokannan järvistä");
        JButton joet = new JButton(" Avaa lista tietokannan joista");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(lopeta);
        buttonGroup.add(jarvet);
        buttonGroup.add(joet);
        
        lopeta.addActionListener(nkuuntelija);
        jarvet.addActionListener(nkuuntelija);
        joet.addActionListener(nkuuntelija);
        
        container.add(lopeta);
        container.add(jarvet);
        container.add(joet);
    }

    private void luoAdminKomponentit(Container container) {
        JButton ljarvi = new JButton(" Lisää uusi järvi tai muuta järven tietoja");
        JButton ljoki = new JButton(" Lisää uusi joki tai muuta joen tietoja");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ljarvi);
        buttonGroup.add(ljoki);

        container.add(ljarvi);
        container.add(ljoki);
    }

}
