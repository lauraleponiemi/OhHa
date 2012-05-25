package Kayttoliittyma;


;
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
                jarjestelmaKaynnistys();
                adminjarjestelmaKaynnistys();
            } else {
                System.out.println("Kirjautuminen onnistui. Tervetuloa selailutietokantaan!");
                jarjestelmaKaynnistys();

            }
        }
    }

    public void jarjestelmaKaynnistys() {
        System.out.println("Valitse toiminto: ");
        System.out.println("[1] Avaa lista tietokannan järvistä");
        System.out.println("[2] Avaa lista tietokannan joista");
        
        numeronKysyminen();

    }

    public void adminjarjestelmaKaynnistys() {
        System.out.println("[3] Lisää uusi järvi tai muuta järven tietoja");
        System.out.println("[4] Lisää uusi joki tai muuta joen tietoja");
        
        numeronKysyminen();
    }

    public void numeronKysyminen() {
        //TODO: miten toiminnon [x] lukeminen?
        int numero = lukija.nextInt();
        if(numero > 0){
            numeronToiminnallisuus(numero);
        }
        if(numero > 4 && numero < 7){
            jarviNumeronToiminnallisuus(numero);
        }
        if(numero > 6 && numero < 9){
            jokiNumeronToiminnallisuus(numero);
        }
        System.out.println("Et syöttänyt numeroa listasta");
    }

    public void numeronToiminnallisuus(int numero) {
//        for(int i =1; i < 5; i++){
//            
//        }
        if(numero == 1){
            jarjestelma.palautaListaJarvista();
        }
        if(numero == 2){
            jarjestelma.palautaListaJoista();
        }
        if(numero == 3){
            jarvenKysyminen();
        }
        if(numero == 4){
            joenKysyminen();
        }
    }
    
    
    public void jarvenKysyminen(){
        System.out.println("[5] Lisätään järvi ");
        System.out.println("[6] Muutetaan järven tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        numeronKysyminen();
    }
    
    
    public void jarviNumeronToiminnallisuus(int numero){
        if(numero == 5){
            
        }
        else if(numero == 6){
            
        }
    }
    
    public void joenKysyminen(){
        System.out.println("[7] Lisätään joki");
        System.out.println("[8] Muutetaan joen tietoja");
        System.out.println("[x] Palataan edelliseen valikkoon");
        numeronKysyminen();
    }
    
    public void jokiNumeronToiminnallisuus(int numero){
        if(numero == 7){
            System.out.print("Anna joen nimi: ");
            String nimi = lukija.nextLine();
            
        }
        if(numero == 8){
            
        }
    }
}
