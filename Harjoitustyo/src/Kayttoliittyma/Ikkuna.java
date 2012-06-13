
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;






public class Ikkuna extends JFrame implements ActionListener{
    
    private String otsikko;
    private String teksti;
    
    public Ikkuna(String otsikko, String teksti){
        
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(400,500));
        JLabel otsikkoKentta = new JLabel(otsikko);
        JTextArea tekstiKentta = new JTextArea(teksti);
        tekstiKentta.setEditable(false);
//        super.add(otsikkoKentta);
        super.add(otsikkoKentta);
        super.add(tekstiKentta,BorderLayout.SOUTH);
//        
//        pack();
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        new Ikkuna(otsikko, teksti);
    }
    
    
    
    
}
