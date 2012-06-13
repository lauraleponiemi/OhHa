package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NapinKuuntelija implements ActionListener {

    private KayttoGui kayttis;
    private JButton joet;
    private Jarjestelma jarjestelma;
    private JButton jarvet;
    private JFrame frame;

    /**
     * Metodi antaa saamansa tapahtumat kayttoliittyman aktiivisen ikkunan
     * valintakuuntelijalle.
     *
     * @param kayttis Kayttoliittyma, jota kuuntelija kuuntelee
     */
    public NapinKuuntelija(KayttoGui kayttis, Jarjestelma jarjestelma, JFrame frame, JButton jarvet, JButton joet) {
        this.kayttis = kayttis;
        this.joet = joet;
        this.jarvet = jarvet;
        this.frame = frame;
        this.jarjestelma = jarjestelma;
    }

    /**
     * Reagoi napin painallukseen
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Avaa lista tietokannan järvistä")) {
            String teksti = jarjestelma.palautaListaJarvista();
            String otsikko = "Tietokantaan tallennetut järvet ja niihin laskevat joet";
            Ikkuna tekstiIkkuna = new Ikkuna(otsikko, teksti);
        }

        if (ae.getActionCommand().equals("Avaa lista tietokannan joista")) {
            String teksti = jarjestelma.palautaListaJoista();
            String otsikko = "Tietokantaan tallennetut joet";
            Ikkuna tekstiIkkuna = new Ikkuna(otsikko, teksti);
        }
        if (ae.getActionCommand().equals("Lisää uusi järvi tai muuta järven tietoja")) {
            String otsikko = "Järven lisäys / järven tietojen muuttaminen";
            int komento = 3;
            kayttis.luoIkkuna(otsikko, komento,frame);
        }
        if (ae.getActionCommand().equals("Lisää uusi joki tai muuta joen tietoja")) {
            String otsikko = "Joen lisäys / joen tietojen muuttaminen";
            int komento = 4;
            kayttis.luoIkkuna(otsikko, komento,frame);
        }
        if (ae.getActionCommand().equals("Lisätään järvi")) {
            
        }
        if (ae.getActionCommand().equals("Muutetaan järven tietoja")) {
            
        }
        if (ae.getActionCommand().equals("Lisätään joki")) {
            
        }
        if (ae.getActionCommand().equals("Muutetaan joen tietoja")) {
            
        }

    }
}
