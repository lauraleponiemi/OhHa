package Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NapinKuuntelija implements KeyListener {

    private KayttoGui kayttis;

    /**
     * Metodi antaa saamansa tapahtumat kayttoliittyman aktiivisen ikkunan
     * valintakuuntelijalle.
     *
     * @param kayttis Kayttoliittyma, jota kuuntelija kuuntelee
     */
    public NapinKuuntelija(KayttoGui kayttis) {
        this.kayttis = kayttis;
    }

    /**
     * Ei tee mitaan.
     *
     * @param ke Nappaintapahtuma nappaimen painalluksesta
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Antaa napintapahtuman edelleen kayttoliittyman aktiivisen ikkunan
     * napinkuuntelijalle.
     *
     * @param ke Napin tapahtuma napin painamisesta
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        
        
        
        
    }

    /**
     * Ei tee mitaan.
     *
     * @param ke Nappitapahtuma napin vapauttamisesta
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
