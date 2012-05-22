package Logiikka;

public class Jarjestelma {

    private Tietokanta tkanta;
    private String jarvi;
    private String joki;

    public Jarjestelma(Tietokanta tkanta) {
        this.tkanta = tkanta;
        this.jarvi = jarvi;
        this.joki = joki;
    }

    public String haeJarvi() {
        for (Jarvi ejarvi : tkanta.getJarvet().keySet()) {
            if (ejarvi.equals(jarvi)) {
                return ejarvi.toString();
            }
        }
        return "Jarvea ei löytynyt";
    }

    public String haeJoki(){
        for (Joki ejoki : tkanta.getJoet().keySet()){
            if(ejoki.equals(joki)){
                return ejoki.toString();
            }
        }
        return "Jokea ei löytynyt";
    

    
    
}
}