package Kayttoliittyma;

import Logiikka.AdminJarjestelma;
import Logiikka.Jarjestelma;
import Logiikka.OpiskelijaJarjestelma;
import Logiikka.Tietokanta;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Kayttoliittyma {

    private String kayttotunnus;
    private String salasana;
    private Jarjestelma jarjestelma;
    private Scanner lukija;
    

    public Kayttoliittyma(Jarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
       lukija = new Scanner(System.in);

    }

//    public void rekisteroidu() {
//        System.out.println("Anna käyttäjätunnus:");
//        System.out.println("Anna salasana:");
//        String kayttotunnus = lukija.nextLine();
//        String salasana = lukija.nextLine();
//        if(salasana.length() < 6 || kayttotunnus.length() < 8){
//            System.out.println("Käyttötunnuksesi pituuden tulee olla vähintään 8 kirjainta, ja salasanasi vähintään 6 kirjainta pitkä.");
//        }else
//        tunnukset.put(kayttotunnus, salasana); 
//
//    }
    public void kaynnista() {
        System.out.println("Tervetuloa vesistömallijärjestelmään!");
        System.out.println("Jos olet rekisteröitynyt käyttäjä, voit kirjautua järjestelmään.");
        System.out.println("Jätä kentät tyhjäksi ja paina Enter jos et ole rekisteröitynyt käyttäjä");
        
        kayttajanKysyminen();


    }

    public void kayttajanKysyminen() {
        while (true) {
            System.out.print("Käyttäjätunnus: ");
            kayttotunnus = lukija.nextLine();
            System.out.print("Salasana: ");
            salasana = lukija.nextLine();
            
           
            Jarjestelma luokka =jarjestelma.kirjauduSisaan(kayttotunnus, salasana);
                      
            if(luokka==null){
               System.out.println("Kirjautuminen epäonnistui."); 
            }
            else if(luokka.getClass().getCanonicalName().equals("Logiikka.AdminJarjestelma")){
                System.out.println("Kirjautuminen onnistui. Tervetuloa tutkijoiden tietokantaan!");
            }
            else{             
               System.out.println("Kirjautuminen onnistui. Tervetuloa selailutietokantaan!");
            }
            
        }
        
    }
//
//    private void luoLiittyma(Container container) {
//        GridLayout layout = new GridLayout(3, 2);
//        container.setLayout(layout);
//
//        JLabel nimiTeksti = new JLabel("Käyttäjätunnus");
//        JTextField nimiKentta = new JTextField();
//        JLabel salasanaTeksti = new JLabel("Salasana");
//        JTextField salasanaKentta = new JTextField();
//
//        JButton lisaaNappi = new JButton("Login");
//
//        container.add(nimiKentta);
//        container.add(salasanaKentta);
//        container.add(nimiTeksti);
//        container.add(salasanaTeksti);
//        container.add(new JLabel(""));
//        container.add(lisaaNappi);
//    }
}
