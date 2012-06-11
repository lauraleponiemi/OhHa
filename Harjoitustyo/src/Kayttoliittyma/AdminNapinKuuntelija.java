/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author lleponie
 */
public class AdminNapinKuuntelija implements ActionListener {

    private KayttoGui kayttis;
    private JButton ljoet;
    private JButton ljarvet;
    private Jarjestelma jarjestelma;
    private JFrame frame;

    public AdminNapinKuuntelija(KayttoGui kayttis, Jarjestelma jarjestelma, JFrame frame, JButton ljarvet, JButton ljoet) {
        this.kayttis = kayttis;
        this.ljoet = ljoet;
        this.ljarvet = ljarvet;
        this.jarjestelma = jarjestelma;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ljoet) {
            System.out.println("lisätään joki");
            luoListakomponentin(frame.getContentPane());
            
        }
        if (ae.getSource() == ljarvet) {
            System.out.println("lisätään järvi");
        }
    }

    public void luoListakomponentin(Container container) {
        JTextArea tekstiKentta = new JTextArea();
        container.add(tekstiKentta);
        
    }
}
