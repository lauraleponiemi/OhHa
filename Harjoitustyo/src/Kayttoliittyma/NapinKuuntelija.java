package Kayttoliittyma;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NapinKuuntelija implements ActionListener {

    private KayttoGui kayttis;
    private JButton joet;
    private JButton lopeta;
    private JButton jarvet;
 
    private JFrame frame;

    /**
     * Metodi antaa saamansa tapahtumat kayttoliittyman aktiivisen ikkunan
     * valintakuuntelijalle.
     *
     * @param kayttis Kayttoliittyma, jota kuuntelija kuuntelee
     */
    public NapinKuuntelija(KayttoGui kayttis, JFrame frame, JButton lopeta, JButton jarvet, JButton joet) {
        this.kayttis = kayttis;
        this.joet = joet;
        this.lopeta = lopeta;
        this.jarvet = jarvet;
       
        this.frame = frame;
    }

/**
 * Reagoi napin painalukseen 
 * @param ae 
 */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == joet) {
            System.out.println("lista joista");

        }
        if (ae.getSource() == jarvet) {
            System.out.println("lista järvistä");
        }
        if (ae.getSource() == lopeta) {
            System.out.println("lopeta ohjelma");
            
        }
    }


}
