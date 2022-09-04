package dati.caricadati;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeggiFile implements CaricaDati{
    /*
     * la sorgente dei dati è un file di configurazione
     */

    /***
     * carica i dati da un file preciso
      * @param sorgente
     * @return
     */
    @Override
    public String leggi(String sorgente) throws IOException {
        String token;
        File file = new File(sorgente);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line ;
        line = reader.readLine();
        reader.close();
        return line;

    }

    /***
     *  verifico l'esistenza delle infromazioni di configurazione incorciando esistenza del file e della presenza dei dati sul file
     * @param sorgente
     * @return
     */

    @Override
    public boolean infoNonPresente( String sorgente) {
        boolean nonPresenti = true;
        File file = new File(sorgente);

        if(file.exists()) {       // per prima cosa controllo se il file esiste
            // file esiste

            if (file.length() == 0) {
                //il file è vuoto
                // quindi NON sono presenti informazioni
                nonPresenti = true;
            } else {
                // il file non è vuoto e sono presenti informazioni
                nonPresenti = false;
            }
        }else{
            //file non esiste, quindi le informazioni non sono presenti
            nonPresenti=true;
        }

        return  nonPresenti;
    }

    /***
     * controllo se il file di configurazione esiste
     * @param sorgente
     * @return
     */

    @Override
    public boolean isSorgenteEsistente(String sorgente) {
        File file = new File(sorgente);
        return file.exists();

    }

    /***
     * controllo se il file di configurazione è vuoto
     * @param sorgente
     * @return
     */

    @Override
    public boolean isSorgenteVuota(String sorgente) {
        boolean isVuoto = false;
        File file = new File(sorgente);
        if (file.length()==0){
            isVuoto=true;
        }
        return isVuoto;
    }
}
