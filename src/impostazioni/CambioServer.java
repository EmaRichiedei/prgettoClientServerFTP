package impostazioni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    final static String NOMEFILE = "server.txt";
    private String indServer = null;
    private String porta = null;
    private String nuovoIndServer = null ;
    private String nuovaPorta =null;

    public void cambio() throws IOException {

        //LeggiDatiServer leggiDatiServer = new LeggiDatiServer();
        ScriviFile scriviFile = new ScriviFile ();
        String nuovoSocket = null;

        //indServer = leggiDatiServer.getIndirizzoServer();
       // porta= leggiDatiServer.getPorta();

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



