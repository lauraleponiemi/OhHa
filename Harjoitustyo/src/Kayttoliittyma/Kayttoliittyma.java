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
import Logiikka.AdminJarjestelma;
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
        while (true) {
            System.out.print("Käyttäjätunnus: ");
            kayttotunnus = lukija.nextLine();
            System.out.print("Salasana: ");
            salasana = lukija.nextLine();

            Jarjestelma luokka = jarjestelma.kirjauduSisaan(kayttotunnus, salasana);

            if (luokka == null) {
                System.out.println("Kirjautuminen epäonnistui.");
            } else if (luokka.getClass().getCanonicalName().equals("Logiikka.AdminJarjestelma")) {
                System.out.println("Kirjautuminen onnistui. Tervetuloa tutkijoiden tietokantaan!");
                jarjestelmaTulostus();
                adminjarjestelmaTulostus();
                jarjestelma = new AdminJarjestelma(jarjestelma.getTietokanta());
                numeronKysyminen();

            } else {
                System.out.println("Kirjautuminen onnistui. Tervetuloa selailutietokantaan!");
                jarjestelmaTulostus();
                jarjestelma = new OpiskelijaJarjestelma(jarjestelma.getTietokanta());
                numeronKysyminen();
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

    public void numeronKysyminen() {

        String komento = lukija.nextLine();
        for (int i = 1; i < 5; i++) {
            if (komento.equals(i)) {
                numeronToiminnallisuus(komento);
            }
        }
        if (AdminJarjestelma.class.isInstance(jarjestelma)) {

            if (komento.equals("5") || komento.equals("6")) {
                jarviNumeronToiminnallisuus(komento);
            }
            if (komento.equals("7") || komento.equals("8")) {
                jokiNumeronToiminnallisuus(komento);
            }
        } else if (komento.equals("x")) {
            jarjestelmaTulostus();
            if (AdminJarjestelma.class.isInstance(jarjestelma)) {
                adminjarjestelmaTulostus();
            }
            numeronKysyminen();
        } else {
            System.out.println("Et syöttänyt numeroa listasta");
        }
        
        
    }

    public void numeronToiminnallisuus(String toiminto) {
//        for(int i =1; i < 5; i++){
//            
//        }
        if (toiminto.equals("1")) {
            jarjestelma.palautaListaJarvista();
        }
        if (toiminto.equals("2")) {
            jarjestelma.palautaListaJoista();
        }
        if (toiminto.equals("3") && AdminJarjestelma.class.isInstance(jarjestelma)) {
            jarvenKysyminen();
        }
        if (toiminto.equals("4") && AdminJarjestelma.class.isInstance(jarjestelma)) {
            joenKysyminen();
        }
    }

    public void jarvenKysyminen() {
        System.out.println("[5] Lisätään järvi ");
        System.out.println("[6] Muutetaan järven tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        numeronKysyminen();
    }

    public void jarviNumeronToiminnallisuus(String toiminto) {
        if (toiminto.equals("5") ) {
        } else if (toiminto.equals("6")) {
        }
    }

    public void joenKysyminen() {
        System.out.println("[7] Lisätään joki");
        System.out.println("[8] Muutetaan joen tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        numeronKysyminen();
    }

    public void jokiNumeronToiminnallisuus(String toiminto) {
        if (toiminto.equals("7")) {
            System.out.print("Anna joen nimi: ");
            String nimi = lukija.nextLine();

        }
        if (toiminto.equals("8")) {
        }
    }
}
