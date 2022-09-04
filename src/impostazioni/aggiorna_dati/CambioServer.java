package impostazioni.aggiorna_dati;

import core.Configurazione;
import dati.salvadati.ScriviFile;

import java.io.IOException;


/***
 *  permette all'utente di cambiare le impostazioni di server destinazione e porta
 */
public class CambioServer{
    /*
      *leggo un file di testo in cui son contenute le informazioni nel formato
             *  ip|porta
             * sito|porta
         in entrambi i casi tutti le componenti del socket sono salvate come stringhe

      *  inserisco i nuovi valori
      * confermo la scelta

    */
    final static String NOMEFILE = Configurazione.FILE_CONFIGURAZIONE_SERVER;
    private String indServer = null;
    private String porta = null;
    private String nuovoIndServer = null ;
    private String nuovaPorta =null;

    public void cambio() throws IOException {

        ScriviFile scriviFile = new ScriviFile ();
        String nuovoSocket = null;

        nuovoSocket=nuovoIndServer+"|"+nuovaPorta ;

        scriviFile.scrivi(nuovoSocket,NOMEFILE);

    }

    public void setNuovaPorta(String _nuovaPorta){
        nuovaPorta=_nuovaPorta;
    }

    public void setNuovoIndServer (String _nuovoIndServer){
        nuovoIndServer=_nuovoIndServer;
    }

}



