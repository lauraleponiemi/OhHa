package Kayttoliittyma;



//import java.awt.BorderLayout;
import Logiikka.Jarjestelma;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class KayttoGui implements Runnable, ActionListener {

    private JFrame frame;
    Jarjestelma jarjestelma;
    private ActionListener nkuuntelija;
    private Container container;
    JButton ljarvi;
    JButton jarvet;
    JButton joet;
    JButton ljoki;
    JButton jarvi1;
    JButton jarvi2;


    public KayttoGui(Jarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;

    }
    
    public Jarjestelma getJarjestelma(){
        return jarjestelma;
    }

    /**
     * Metodi käynnistää vesistömallijärjestelmän. Luo ikkunaan valintanappulat
     * riippuen kumman järjestelmän käyttäjä käynnistää.
     *
     */
    @Override
    public void run() {
        frame = new JFrame("Tervetuloa vesistömallijärjestelmään!");
        frame.setPreferredSize(new Dimension(500, 200));
//        frame.addActionListener(new ValintaKuuntelija(this));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoPerusKomponentit(frame.getContentPane());
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
        container.add(new JLabel("Lopeta istunto sulkemalla ikkuna "));

        jarvet = new JButton("Avaa lista tietokannan järvistä");
        joet = new JButton("Avaa lista tietokannan joista");
        jarvet.addActionListener(this);
        joet.addActionListener(this);

        container.add(jarvet);
        container.add(joet);

    }

    private void luoAdminKomponentit(Container container) {
        ljarvi = new JButton("Lisää uusi järvi tai muuta järven tietoja");
        ljoki = new JButton("Lisää uusi joki tai muuta joen tietoja");
//        nkuuntelija = new NapinKuuntelija(this, jarjestelma, frame, ljarvi, ljoki);
//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(ljarvi);
//        buttonGroup.add(ljoki);
//        actionPerformed(ActionEvent ljarvi);
        ljarvi.addActionListener(this);
        ljoki.addActionListener(this);

        container.add(ljarvi);
        container.add(ljoki);
    }

    public void luoJarviKomponentit(Container container, String nappi1, String nappi2, String otsikko) {

        JLabel otsikkoKentta = new JLabel(otsikko);
//        add(new JLabel("Valitse toiminto: "));
        jarvi1 = new JButton(nappi1);
        jarvi2 = new JButton(nappi2);
        container.add(otsikkoKentta);
        container.add(jarvi1);
        container.add(jarvi2);

        jarvi1.addActionListener(this);
        jarvi2.addActionListener(this);


    }

    /**
     * Metodi luo ikkunan johon tulostetaan valintanappulan tapahtuma.
     */
//    public void luoIkkuna(String otsikko, Integer komento, Container container) {   // miten annetaan viite tekstikenttään?
//        String nappi1 = " ";
//        String nappi2 = " ";
////        frame = new JFrame(otsikko);
////        frame.setPreferredSize(new Dimension(200, 100));
//        if (komento == 3) {
//            nappi1 = "Lisätään järvi";
//            nappi2 = "Muutetaan järven tietoja";
//        } else if (komento == 4) {
//            nappi1 = "Lisätään joki";
//            nappi2 = "Muutetaan joen tietoja";
//        }
//        NappiIkkuna nIkkuna = new NappiIkkuna(this, otsikko, nappi1, nappi2);
////        JButton ekaNappi = new JButton(nappi1);
////        JButton tokaNappi = new JButton(nappi2);
////        container.add(ekaNappi);
////        container.add(tokaNappi);
////        ekaNappi.addActionListener(this);
////        tokaNappi.addActionListener(this);
//
//        frame.setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jarvet) {
            String teksti = jarjestelma.palautaListaJarvista();
            String otsikko = "Tietokantaan tallennetut järvet ja niihin laskevat joet";
            Ikkuna tekstiIkkuna = new Ikkuna(otsikko, teksti);

        }
        if (ae.getSource() == joet) {
            String teksti = jarjestelma.palautaListaJoista();
            String otsikko = "Tietokantaan tallennetut joet";
            Ikkuna tekstiIkkuna = new Ikkuna(otsikko, teksti);
        }
        if (ae.getSource() == ljarvi) {
            String otsikko = " Järven lisäys / järven tietojen muuttaminen";
            int komento = 3;
//            luoIkkuna(otsikko, komento, container);
            String nappi1 = "Lisätään järvi";
            String nappi2 = "Muutetaan järven tietoja";
            NappiIkkuna nIkkuna = new NappiIkkuna(this, otsikko, nappi1, nappi2);
            nIkkuna.run();
        }
        if (ae.getSource() == ljoki) {
            String otsikko = " Joen lisäys / joen tietojen muuttaminen";
            int komento = 4;
//            luoIkkuna(otsikko, komento, frame);
            String nappi1 = "Lisätään joki";
            String nappi2 = "Muutetaan joen tietoja";
            NappiIkkuna nIkkuna = new NappiIkkuna(this, otsikko, nappi1, nappi2);
            nIkkuna.run();
            System.out.println("millon ollaan täällä");
        }

    }
}
