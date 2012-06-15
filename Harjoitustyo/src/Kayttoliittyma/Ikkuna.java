
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;






public class Ikkuna extends JFrame implements ActionListener{
    
    private String otsikko;
    private String teksti;
    
    public Ikkuna(String otsikko, String teksti){
        
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(300,600));
        JLabel otsikkoKentta = new JLabel(otsikko);
        JTextArea tekstiKentta = new JTextArea(teksti);
        JScrollPane sp = new JScrollPane(tekstiKentta);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);       
        tekstiKentta.setEditable(false);     
        super.add(otsikkoKentta);
        super.getContentPane().add(sp);
        pack();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        new Ikkuna(otsikko, teksti);
    }
    
    
    
    
}
