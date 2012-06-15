package Kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NappiIkkuna extends JFrame implements ActionListener, Runnable {

    private JFrame frame;
    private String nappi1;
    private String nappi2;
    private String nappi3;
    private String otsikko;
    private KayttoGui kayttis;
    private JButton jnappi1;
    private JButton jnappi2;
    private JButton jnappi3;

    public NappiIkkuna(KayttoGui kayttis, String otsikko, String nappi1, String nappi2) {
        this.otsikko = otsikko;
        this.nappi1 = nappi1;
        this.nappi2 = nappi2;
        this.kayttis = kayttis;

    }

    public NappiIkkuna(KayttoGui kayttis, String otsikko, String nappi1, String nappi2, String nappi3) {
        this.otsikko = otsikko;
        this.nappi1 = nappi1;
        this.nappi2 = nappi2;
        this.nappi3 = nappi3;
        this.kayttis = kayttis;
    }

    @Override
    public void run() {
        setTitle(otsikko);
        super.setPreferredSize(new Dimension(200, 100));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        jnappi1 = new JButton(nappi1);
        jnappi2 = new JButton(nappi2);
        getContentPane().add(jnappi1);
        getContentPane().add(jnappi2);
        if (nappi3 != null) {
            jnappi3 = new JButton(nappi3);
            getContentPane().add(jnappi3);
            
        }
      
//        jnappi3.addActionListener(this);
        jnappi1.addActionListener(this);
        jnappi2.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jnappi1 && ae.getActionCommand().equals("Lisätään järvi")) {
            System.out.println("täällä");
            String otsikko = "Järven lisääminen";
            String kysymys1 = "Anna järven nimi: ";
            String kysymys2 = "Anna järven vesitase: ";
            String nappi = "Lisää järvi";
            KirjoitusIkkuna kIkkuna = new KirjoitusIkkuna(kayttis.getJarjestelma(), otsikko, kysymys1, kysymys2, nappi);
            kIkkuna.run();
        }
        if (ae.getSource() == jnappi1 && ae.getActionCommand().equals("Lisätään joki")) {
            String otsikko = "Joen lisääminen";
            String kysymys1 = "Anna joen nimi: ";
            String kysymys2 = "Anna joen virtaus: ";
            String kysymys3 = "Anna järven nimi, mihin joki lisätään: ";
            String nappi = "Lisää joki";
            KirjoitusIkkuna kIkkuna = new KirjoitusIkkuna(kayttis.getJarjestelma(), otsikko, kysymys1, kysymys2, kysymys3, nappi);
            kIkkuna.run();
        }
        if (ae.getSource() == jnappi2 && ae.getActionCommand().equals("Muutetaan järven tietoja")) {
            System.out.println("järvitietoja muutetaan");
            String jaOtsikko = "Järvitietojen muuttaminen";
            String jaNappi1 = "Järven poistaminen tietokannasta";
            String jaNappi2 = "Järven vesitaseen lisääminen";
            String jaNappi3 = "Järven vesitaseen vähentäminen";
            NappiIkkuna nIkkuna = new NappiIkkuna(kayttis, jaOtsikko, jaNappi1, jaNappi2, jaNappi3);
            // avaa ikkunan, missä lista järven muutosvaihtoehdoista
        }
        if (ae.getSource() == jnappi2 && ae.getActionCommand().equals("Muutetaan joen tietoja")) {
            System.out.println("jokitietoja muutetaan");
            String joOtsikko = "Jokitietojen muuttaminen";
            String joNappi1 = "Joen poistaminen tietokannasta";
            String joNappi2 = "Joen virtauksen lisääminen";
            String joNappi3 = "Joen virtauksen vähentäminen";

            // avaa ikkunan jokimuutos vaihtoehdoista
        }


    }
}
