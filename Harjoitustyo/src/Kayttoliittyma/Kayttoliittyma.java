package Kayttoliittyma;

;


import Logiikka.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
import Logiikka.Jarjestelma;
import java.util.Scanner;
import java.util.Scanner;
import Logiikka.Jarjestelma;
import Logiikka.Tietokanta;
import java.util.Scanner;
import java.util.Scanner;
import Logiikka.AdminJarjestelma;
import Logiikka.Jarjestelma;
import java.util.Scanner;
import java.util.Scanner;
import Logiikka.Jarjestelma;
import java.util.Scanner;
import java.util.Scanner;



public class Kayttoliittyma {

    private String kayttotunnus;
    private String salasana;
    private Jarjestelma jarjestelma;
    private Scanner lukija;

    public Kayttoliittyma(Jarjestelma jarjestelma) {

        this.jarjestelma = jarjestelma;
        lukija = new Scanner(System.in);

    }

    public void kaynnista() {
        System.out.println("Tervetuloa vesistömallijärjestelmään!");
        System.out.println("Jos olet rekisteröitynyt käyttäjä, voit kirjautua järjestelmään.");
        System.out.println("Jätä kentät tyhjäksi ja paina \"Enter\" jos et ole rekisteröitynyt käyttäjä");

        kayttajanKysyminen();
    }

    public void kayttajanKysyminen() {

        System.out.print("Käyttäjätunnus: ");
        kayttotunnus = lukija.nextLine();
        System.out.print("Salasana: ");
        salasana = lukija.nextLine();

        Jarjestelma luokka = jarjestelma.kirjauduSisaan(kayttotunnus, salasana);

        if (luokka == null) {
            System.out.println("Kirjautuminen epäonnistui.");
        } else if (luokka.getClass().getCanonicalName().equals("Logiikka.AdminJarjestelma")) {
            System.out.println("Kirjautuminen onnistui. Tervetuloa tutkijoiden tietokantaan!");
            while (true) {
                jarjestelmaTulostus();
                adminjarjestelmaTulostus();
                jarjestelma = new AdminJarjestelma(jarjestelma.getTietokanta());
                char komento = lukija.next().charAt(0);
                if (komento == '0') {
                    System.out.println("Olet poistunut järjestelmästä, tervetuloa uudelleen!");
                    return;
                } else {
                    syotteenKysyminen(komento);
                }
            }

        } else {
            System.out.println("Kirjautuminen onnistui. Tervetuloa selailutietokantaan!");
            while (true) {
                jarjestelmaTulostus();
                jarjestelma = new OpiskelijaJarjestelma(jarjestelma.getTietokanta());
                char komento = lukija.next().charAt(0);
                if (komento == '0') {
                    System.out.println("Olet poistunut järjestelmästä, tervetuloa uudelleen!");
                    return;
                } else {
                    syotteenKysyminen(komento);
                }
            }
        }
    }

    public void jarjestelmaTulostus() {
        System.out.println("Valitse toiminto: ");
        System.out.println("[0] Lopetus");
        System.out.println("[1] Avaa lista tietokannan järvistä");
        System.out.println("[2] Avaa lista tietokannan joista");
    }

    public void adminjarjestelmaTulostus() {
        System.out.println("[3] Lisää uusi järvi tai muuta järven tietoja");
        System.out.println("[4] Lisää uusi joki tai muuta joen tietoja");
    }

    public void syotteenKysyminen(char komento) {

//        char komento = lukija.next().charAt(0);
//        for (int i = 1; i < 5; i++) {
//            System.out.println("täällä ollaan");
//            if (komento == (char) i) {
//                numeronToiminnallisuus(komento);
//            }
//        }
        if (komento == '1' || komento == '2' || komento == '3' || komento == '4') {
 
            numeronToiminnallisuus(komento);
        }

        if (AdminJarjestelma.class.isInstance(jarjestelma)) {

            if (komento == '5' || komento == '6') {
                jarviNumeronToiminnallisuus(komento);
            }
            if (komento == '7' || komento == '8') {
                jokiNumeronToiminnallisuus(komento);
            }
        }

        if (komento == 'x') {
            jarjestelmaTulostus();
            if (AdminJarjestelma.class.isInstance(jarjestelma)) {
                adminjarjestelmaTulostus();
            }
            syotteenKysyminen(komento);
        } 
        else 
            System.out.println("Et syöttänyt numeroa listasta");
        

    }



    public void numeronToiminnallisuus(char toiminto) {
//        for(int i =1; i < 5; i++){
//            
//        }
        if (toiminto == '1') {
            jarjestelma.palautaListaJarvista();
        }
        if (toiminto == '2') {
            jarjestelma.palautaListaJoista();
        }
        if (toiminto == '3' && AdminJarjestelma.class.isInstance(jarjestelma)) {
            jarvenKysyminen();
        }
        if (toiminto == '4' && AdminJarjestelma.class.isInstance(jarjestelma)) {
            joenKysyminen();
        }
    }

    public void jarvenKysyminen() {
        System.out.println("[5] Lisätään järvi ");
        System.out.println("[6] Muutetaan järven tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        char komento = lukija.next().charAt(0);
        syotteenKysyminen(komento);
    }

    public void jarviNumeronToiminnallisuus(char toiminto) {
        if (toiminto == '5') {
            System.out.print("Anna järven nimi: ");
            String nimi = lukija.nextLine();
            System.out.print("Anna järven vesitase: ");           
            int vesitase = lukija.nextInt();
            jarjestelma.lisaaJarvi(vesitase, nimi);


        } else if (toiminto == '6') {
            System.out.println("[a] Järven poistaminen tietokannasta");
            System.out.println("[b] Järven vesitaseen lisääminen");
            System.out.println("[c] Järven vesitaseen vähentäminen");
            System.out.println("[x] Palataan alkuvalikkoon");
            jarviTietojenMuuttaminen();
        }
    }

    public void jarviTietojenMuuttaminen() {
        char komento = lukija.next().charAt(0);
        if (komento == 'a') {
            System.out.print("Anna järven nimi, joka poistetaan: ");
            String nimi = lukija.nextLine();
            jarjestelma.poistaJarvi(nimi);
        }

        if (komento == 'b') {
            System.out.print("Anna järven nimi, jonka vesitasetta lisätään: :  ");
            String nimi = lukija.nextLine();
            System.out.print("Anna lisättävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            //TODO veden lisääminen: tehdäänkö järjestelmään metodi veden lisäämiselle vai metodi joka käyttää järven metodi "lisääVetta"?
            //vai miten
        }
        if (komento == 'c') {
            System.out.print("Anna järven nimi, jonka vesitasetta vähennetään:  ");
            String nimi = lukija.nextLine();
            System.out.print("Anna vähennettävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            //TODO ks. ongelma yllä
        } else if (komento == 'x') {
            syotteenKysyminen(komento);
        }


    }

    public void joenKysyminen() {
        System.out.println("[7] Lisätään joki");
        System.out.println("[8] Muutetaan joen tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        char komento = lukija.next().charAt(0);
        syotteenKysyminen(komento);
    }

    public void jokiNumeronToiminnallisuus(char toiminto) {
        if (toiminto == '7') {
            System.out.print("Anna joen nimi: ");
            String nimi = lukija.nextLine();
            System.out.print("Anna virtaus: ");
            int virtaus = lukija.nextInt();
            jarjestelma.lisaaJoki(virtaus, nimi);
            //TODO tee lisaaJoki-metodi jarjestelma-luokkaan
        }
        if (toiminto == '8') {
            System.out.println("[d] Joen poistaminen tietokannasta");
            System.out.println("[e] Joen virtauksen lisääminen");
            System.out.println("[f] Joen virtauksen vähentäminen");
            System.out.println("[x] Palataan alkuvalikkoon");

        }
    }
    
    public void jokiTietojenMuuttaminen(){
        char komento = lukija.next().charAt(0);
        if(komento == 'd'){
            
        }
        if(komento == 'e'){
            
        }
        if(komento == 'f'){
            
        }
        if(komento == 'x'){
            
        }
    }
}
