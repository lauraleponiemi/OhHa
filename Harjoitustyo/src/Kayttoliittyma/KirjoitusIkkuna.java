package Kayttoliittyma;

import Logiikka.Jarjestelma;
import java.awt.Dimension;
import javax.swing.*;

public class KirjoitusIkkuna extends JFrame implements Runnable {

    private String otsikko;
    private JButton jnappi1;
    private String nappi;
    private String kysymys2;
    private String kysymys1;
    private String kysymys3;
    JLabel kysymysJarvenNimi;
    private Jarjestelma jarjestelma;
    private JTextField jarvenNimiKentta;

    public KirjoitusIkkuna(Jarjestelma jarjestelma, String otsikko, String kysymys1, String kysymys2, String nappi) {
        this.otsikko = otsikko;
        this.kysymys1 = kysymys1;
        this.kysymys2 = kysymys2;
        this.nappi = nappi;
        this.jarjestelma = jarjestelma;
    }

    public KirjoitusIkkuna(Jarjestelma jarjestelma, String otsikko, String kysymys1, String kysymys2, String kysymys3, String nappi) {
        this.otsikko = otsikko;
        this.kysymys1 = kysymys1;
        this.kysymys2 = kysymys2;
        this.kysymys3 = kysymys3;
        this.nappi = nappi;
        this.jarjestelma = jarjestelma;
    }
    /**
     * Metodi luo kirjoitusikkunan, mihin voi syöttää järven/joen tiedot.
     * joen kysymiseen tarvitaan järven nimi, mihin se liitetään
     */
    @Override
    public void run() {
        setTitle(otsikko);
        super.setPreferredSize(new Dimension(200, 100));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel kysymysNimi = new JLabel(kysymys1);
        JTextField nimiKentta = new JTextField();
        JLabel kysymysTase = new JLabel(kysymys2);
        JTextField taseKentta = new JTextField();
        
        if (kysymys3 != null) {    
            kysymysJarvenNimi = new JLabel(kysymys3);
            jarvenNimiKentta = new JTextField();
            add(kysymysJarvenNimi);
            add(jarvenNimiKentta);
        }
        jnappi1 = new JButton(nappi);

        getContentPane().add(jnappi1);
        add(kysymysNimi);
        add(nimiKentta);
        add(kysymysTase);
        add(taseKentta);
        String nimi = nimiKentta.getText();
        LisaysKuuntelija lk = new LisaysKuuntelija(jarjestelma,nimiKentta,taseKentta);
        jnappi1.addActionListener(lk);
        pack();
        setVisible(true);
        

    }
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if(ae.getActionCommand().equals("Lisää järvi")){
//            System.out.println("lisätään järvi");
//        }
//        if(ae.getActionCommand().equals("Lisää joki")){
//            System.out.println("lisätään joki");
//        }
//    }
}
