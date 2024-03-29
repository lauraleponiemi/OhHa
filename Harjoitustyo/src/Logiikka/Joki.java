package Logiikka;

public class Joki {
/**
 * Joen nimi
 */
    private String nimi;
    /**
     * Joen virtaus
     */
    private int virtaus;

    public Joki(int virtaus, String nimi) {
        this.virtaus = virtaus;
        this.nimi = nimi;
    }

    /**
     * Metodi lisää virtausta joessa. Parametrina saatu "virtausta" lisätään
     * joen nykyiseen virtaukseen.
     *
     * @param virtausta virtausta lisättävä veden määrä (> 0)
     */
    public void lisaaVirtausta(int virtausta) {
        if (0 < virtausta) {
            virtaus = virtaus + virtausta;
        }
    }

    /**
     * Metodi vähentää virtausta joessa parametrina annetun määrän. Jos
     * vähennettävä määrä on enemmän kuin joen virtaus on tällä hetkellä, siitä
     * ilmoitetaan syötteessä. Virtausta ei voi muuttaa negatiiviseksi
     *
     * @param virtausta määrä, joka vähennetään nykyisestä virtaus-arvosta.
     */
    public void vahennaVirtausta(int virtausta) {
        if (virtausta > 0) {
            if (virtaus - virtausta >= 0) {
                virtaus = virtaus - virtausta;
            }
            if (virtaus - virtausta < 0) {
                virtaus = 0;
            }
        }
    }

    public String getNimi() {
        return nimi;
    }

    public int getVirtaus() {
        return virtaus;
    }

    @Override
    public String toString() {
        return nimi + "(" + virtaus + ")";
    }
}
