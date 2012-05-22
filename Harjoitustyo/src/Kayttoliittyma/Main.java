
package Kayttoliittyma;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
      Scanner lukija = new Scanner(System.in);
      Kayttoliittyma liittyma = new Kayttoliittyma(lukija);
      liittyma.kaynnista();  
    }
}
