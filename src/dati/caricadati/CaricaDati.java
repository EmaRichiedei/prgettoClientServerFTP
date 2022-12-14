package dati.caricadati;

import java.io.IOException;

public interface CaricaDati {
    /*
     *   Acquisizione di dati da sorgente esterna
     *
     */

    public String leggi(String sorgente) throws IOException  ;// acquisisce i dati dalla sorgente
    public boolean infoNonPresente(String sorgente);    // controllo incrociato tra esiestenza della sorgente e della presenza di dati sulla sorgente
    public boolean isSorgenteEsistente(String sorgente);  //controlla se esiste la sorgente dei dati da caricare
    public boolean isSorgenteVuota( String sorgente);  //controlla se la sorgente ha dati


}
