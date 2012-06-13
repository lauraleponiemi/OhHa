package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KirjoitusIkkuna extends JFrame implements ActionListener{
        private String otsikko;
    private String teksti;

    public KirjoitusIkkuna(String otsikko, String teksti) {
        
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(400, 500));
        
        JLabel otsikkoKentta = new JLabel(otsikko);
        JLabel kysymysNimi = new JLabel("Anna järven nimi: ");
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
