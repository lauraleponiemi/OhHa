package Kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NappiIkkuna extends JFrame implements ActionListener, Runnable {

    private JFrame frame;
    private String nappi1;
    private String nappi2;
    private String otsikko;
    private KayttoGui kayttis;
    
    

    public NappiIkkuna(KayttoGui kayttis, String otsikko, String nappi1, String nappi2) {
        this.otsikko = otsikko;
        this.nappi1 = nappi1;
        this.nappi2 = nappi2;
        this.kayttis = kayttis;
    }

    @Override
    public void run() {
        frame = new JFrame(otsikko);
        frame.setBackground(Color.WHITE);
        frame.setPreferredSize(new Dimension(200, 100));
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        frame.setLayout(layout);
        kayttis.luoJarviKomponentit(this,nappi1, nappi2, otsikko);  ///frame.getContentPane()
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource()== ekaNappi){
//            
//        }
//        if(ae.getSource()== tokaNappi){
//            
//        }
        
    }
}
