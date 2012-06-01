package Kayttoliittyma;

;







import Logiikka.*;
import java.util.Scanner;


import java.util.Scanner;
import Logiikka.AdminJarjestelma;

import Logiikka.Jarjestelma;




public class Kayttoliittyma {
/**
*   Järjestelmän käyttäjän syöttämä käyttötunnus sisäänkirjautumista varten
*/
    private String kayttotunnus;
/**
*   Käyttäjän syöttämä salasana järjestelmään kirjautumisen yhteydessä
*/
    private String salasana;
/**
*   Luokan Jarjestelma oliomuuttuja jarjestelma, jossa tapahtuu ohjelman toiminnallisuus 
*/    
    private Jarjestelma jarjestelma;
/**
*   Javan valmis luokka Scanner:in oliomuuttuja, joka lukee käyttäjän syötteitä
*/   
    private Scanner lukija;

    /**
     * Luokan Kayttoliittyma konstruktori, jossa tallennetaan parametrina saatu jarjestelma
     * sekä käyttäjän syötteitä lukeva Scanner-luokan olio lukija. 
     * 
     * @param jarjestelma annetaan järjestelmä jolla käyttöliittymä toimii
     * 
     * 
     */
    public Kayttoliittyma(Jarjestelma jarjestelma) {

        this.jarjestelma = jarjestelma;
        lukija = new Scanner(System.in);

    }

    /**
     * Metodi printtaa tervehdystekstin ja kaynnistaa järjestelmän metodin "kayttajanKysyminen()". 
     * Metodi tulostaa tervehdystekstin ja kirjautumisinformaation, 
     * sekä käynnistää metodin "kayttajaKysyminen()", joka kysyy käyttäjän käyttötunnusta ja
     * salasanaa sekä päästää käyttäjän sisään joko tutkijatietokantaan (käyttötunnuksilla)tahi opiskelijatietokantaan
     * (painamalla "enter"-nappia 2 kertaa)
     */
    public void kaynnista() {
        System.out.println("Tervetuloa vesistömallijärjestelmään!");
        System.out.println("Jos olet rekisteröitynyt käyttäjä, voit kirjautua järjestelmään.");
        System.out.println("Jätä kentät tyhjäksi ja paina \"Enter\" jos et ole rekisteröitynyt käyttäjä");

        kayttajanKysyminen();
    }

    private void kayttajanKysyminen() {

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

    private void jarjestelmaTulostus() {
        System.out.println("Valitse toiminto: ");
        System.out.println("[0] Lopetus");
        System.out.println("[1] Avaa lista tietokannan järvistä");
        System.out.println("[2] Avaa lista tietokannan joista");
    }

    private void adminjarjestelmaTulostus() {
        System.out.println("[3] Lisää uusi järvi tai muuta järven tietoja");
        System.out.println("[4] Lisää uusi joki tai muuta joen tietoja");
    }

    private void syotteenKysyminen(char komento) {

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
            komento = lukija.next().charAt(0);
            if (komento == '0') {
                System.out.println("Olet poistunut järjestelmästä, tervetuloa uudelleen!");
                syotteenKysyminen(komento);
            } else {
                System.out.println("Et syöttänyt numeroa listasta");
            }

        }
        }

    

    private void numeronToiminnallisuus(char toiminto) {
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

    private void jarvenKysyminen() {
        System.out.println("[5] Lisätään järvi ");
        System.out.println("[6] Muutetaan järven tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        char komento = lukija.next().charAt(0);
        syotteenKysyminen(komento);
    }

    private void jarviNumeronToiminnallisuus(char toiminto) {
        if (toiminto == '5') {
            System.out.print("Anna järven nimi: ");
            lukija.nextLine();
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

    private void jarviTietojenMuuttaminen() {
        char komento = lukija.next().charAt(0);
        if (komento == 'a') {
            System.out.print("Anna järven nimi, joka poistetaan: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            jarjestelma.poistaJarvi(nimi);
        }

        if (komento == 'b') {
            System.out.print("Anna järven nimi, jonka vesitasetta lisätään: :  ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna lisättävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            //TODO veden lisääminen: tehdäänkö järjestelmään metodi veden lisäämiselle vai metodi joka käyttää järven metodi "lisääVetta"?
            //vai miten
        }
        if (komento == 'c') {
            System.out.print("Anna järven nimi, jonka vesitasetta vähennetään:  ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna vähennettävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            //TODO ks. ongelma yllä
        } else if (komento == 'x') {
            syotteenKysyminen(komento);
        }


    }

    private void joenKysyminen() {
        System.out.println("[7] Lisätään joki");
        System.out.println("[8] Muutetaan joen tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        char komento = lukija.next().charAt(0);
        syotteenKysyminen(komento);
    }

    private void jokiNumeronToiminnallisuus(char toiminto) {
        if (toiminto == '7') {
            System.out.print("Anna joen nimi: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna virtaus: ");           
            int virtaus = lukija.nextInt();
            System.out.print("Anna järven nimi, mihin joki laskee:");
            lukija.nextLine();
            String jnimi = lukija.nextLine();
            jarjestelma.lisaaJoki(virtaus, nimi, jnimi);
        }
        if (toiminto == '8') {
            System.out.println("[d] Joen poistaminen tietokannasta");
            System.out.println("[e] Joen virtauksen lisääminen");
            System.out.println("[f] Joen virtauksen vähentäminen");
            System.out.println("[x] Palataan alkuvalikkoon");

        }
    }

    private void jokiTietojenMuuttaminen() {
        char komento = lukija.next().charAt(0);
        if (komento == 'd') {
            System.out.print("Anna poistettavan joen nimi: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            jarjestelma.poistaJoki(nimi);
        }
        if (komento == 'e') {
            System.out.print("Anna joen nimi, jonka virtausta lisätään:");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna lisättävä määrä:");
            int virtaus = lukija.nextInt();
            //TODO: tee metodi virtauksen lisäämiseen
        }
        if (komento == 'f') {
            System.out.print("Anna joen nimi, jonka virtausta vähennetään:");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna vähennettävä määrä:");
            int virtaus = lukija.nextInt();
            //TODO: tee virtauksen vähentäminen
        }
        if (komento == 'x') {
            syotteenKysyminen(komento);
        }
    }
}
