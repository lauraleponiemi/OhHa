
package Kayttoliittyma;




public class Main {
    public static void main(String[] args) {

      Kayttoliittyma liittyma = new Kayttoliittyma();
      liittyma.lisaaTunnus("kkoivula", "porkkana");
      liittyma.lisaaTunnus("jvesanen", "karavaani");
      liittyma.lisaaTunnus("yyrjönen", "kaappaus");
      liittyma.lisaaTunnus("dsuvela", "suvisaari");
      
      liittyma.kaynnista();  
    }
}
