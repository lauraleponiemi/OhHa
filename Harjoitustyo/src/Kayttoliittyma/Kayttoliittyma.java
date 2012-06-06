package Kayttoliittyma;



import Logiikka.*;
import java.util.Scanner;


import java.util.Scanner;
import Logiikka.AdminJarjestelma;

import Logiikka.Jarjestelma;



public class Kayttoliittyma {

    /**
     * Järjestelmän käyttäjän syöttämä käyttötunnus sisäänkirjautumista varten
     */
    private String kayttotunnus;
    /**
     * Käyttäjän syöttämä salasana järjestelmään kirjautumisen yhteydessä
     */
    private String salasana;
    /**
     * Luokan Jarjestelma oliomuuttuja jarjestelma, jossa tapahtuu ohjelman
     * toiminnallisuus
     */
    private Jarjestelma jarjestelma;
    /**
     * Javan valmis luokka Scanner:in oliomuuttuja, joka lukee käyttäjän
     * syötteitä
     */
    private Scanner lukija;

    /**
     * Luokan Kayttoliittyma konstruktori, jossa tallennetaan parametrina saatu
     * jarjestelma sekä käyttäjän syötteitä lukeva Scanner-luokan olio lukija.
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
     * Metodi printtaa tervehdystekstin ja kaynnistaa järjestelmän metodin
     * "kayttajanKysyminen()". Metodi tulostaa tervehdystekstin ja
     * kirjautumisinformaation, sekä käynnistää metodin "kayttajaKysyminen()",
     * joka kysyy käyttäjän käyttötunnusta ja salasanaa sekä päästää käyttäjän
     * sisään joko tutkijatietokantaan (käyttötunnuksilla)tahi
     * opiskelijatietokantaan (painamalla "enter"-nappia 2 kertaa)
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
        if (komento == '1' || komento == '2' || komento == '3' || komento == '4') {
            numeronToiminnallisuus(komento);
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
        if (toiminto == '1') {
            System.out.println(jarjestelma.palautaListaJarvista());
            if(jarjestelma.palautaListaJarvista()==null){
                System.out.println("Lista järvistä oli tyhjä.");
            }
        }
        if (toiminto == '2') {
            System.out.println(jarjestelma.palautaListaJoista());
            if(jarjestelma.palautaListaJoista()==null){
                System.out.println("Lista joista on tyhjä.");
            }
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
        if (komento == 'x') {
            syotteenKysyminen(komento);
        }jarviNumeronToiminnallisuus(komento);
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
            char komento = lukija.next().charAt(0);
            if (komento == 'x') {
                syotteenKysyminen(komento);
            }
            jarviTietojenMuuttaminen(komento);


        }
    }

    private void jarviTietojenMuuttaminen(char komento) {

        if (komento == 'a') {
            System.out.print("Anna järven nimi, joka poistetaan: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            if (jarjestelma.poistaJarvi(nimi) == false) {
                System.out.println("Järveä ei löytynyt tietokannasta");
            } else {
                System.out.println("Järvi poistettu tietokannasta");
            }
        }

        if (komento == 'b') {
            System.out.print("Anna järven nimi, jonka vesitasetta lisätään: :  ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna lisättävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            if (jarjestelma.yrittaalisataVettaJarvessa(nimi, vesimaara) == true) {
                System.out.println("Järven vesitasetta lisätty.");
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta tai antamasi luku ei kelpaa");
            }

        }
        if (komento == 'c') {
            System.out.print("Anna järven nimi, jonka vesitasetta vähennetään:  ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna vähennettävä vesimäärä: ");
            int vesimaara = lukija.nextInt();
            if (jarjestelma.yrittaavahentaaVettaJarvessa(nimi, vesimaara) == true) {
                System.out.println("Järven vesitasetta vähennetty");
            } else {
                System.out.println("Järveä ei löytynyt tietokannasta tai antamasi luku ei kelpaa.");
            }
        }
//        else if (komento == 'x') {
//            syotteenKysyminen(komento);
//        }


    }

    private void joenKysyminen() {
        System.out.println("[7] Lisätään joki");
        System.out.println("[8] Muutetaan joen tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        char komento = lukija.next().charAt(0);
        if (komento == 'x') {
            syotteenKysyminen(komento);
        }
        jokiNumeronToiminnallisuus(komento);

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
//            if(jarjestelma.lisaaJoki(virtaus, nimi, jnimi)==false){
//                System.out.println("Joki on jo tietokannassa.");
//            }else{
//                System.out.println("Joki lisätty tietokantaan.");
//            }
        }
        if (toiminto == '8') {
            System.out.println("[d] Joen poistaminen tietokannasta");
            System.out.println("[e] Joen virtauksen lisääminen");
            System.out.println("[f] Joen virtauksen vähentäminen");
            System.out.println("[x] Palataan alkuvalikkoon");
            char komento = lukija.next().charAt(0);
            if (komento == 'x') {
                syotteenKysyminen(komento);
            }
            jokiTietojenMuuttaminen(komento);


        }
    }

    private void jokiTietojenMuuttaminen(char komento) {
        if (komento == 'd') {
            System.out.print("Anna poistettavan joen nimi: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna järven nimi, johon joki laskee: ");
            String jnimi = lukija.nextLine();
            if (jarjestelma.poistaJoki(nimi, jnimi) == false) {
                System.out.println("Jokea ei löytynyt tietokannasta" + "\n");
            } else {
                System.out.println("Joki poistettu tietokannasta" + "\n");
            }

        }
        if (komento == 'e') {
            System.out.print("Anna joen nimi, jonka virtausta lisätään: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna lisättävä määrä:");
            int virtaus = lukija.nextInt();
//            lukija.nextLine();
            if (jarjestelma.yrittaalisataVirtaustaJoessa(nimi, virtaus) == false) {
                System.out.println("Jokea ei löytynyt tietokannasta tai antamasi luku ei kelpaa." + "\n");
            } else {
                System.out.println("Joen virtausta lisätty." + "\n");
            }
        }
        if (komento == 'f') {
            System.out.print("Anna joen nimi, jonka virtausta vähennetään: ");
            lukija.nextLine();
            String nimi = lukija.nextLine();
            System.out.print("Anna vähennettävä määrä: ");
            int virtaus = lukija.nextInt();
//            lukija.nextLine();
            if (jarjestelma.yrittaavahentaaVirtaustaJoessa(nimi, virtaus) == false) {
                System.out.println("Jokea ei löytynyt tietokannasta." + "\n");
            } else {             //TODO miksei löydä tietokannassa olevaa jokea :(
                System.out.println("Joen virtausta vähennetty." + "\n");
            }
        }
    }
}
