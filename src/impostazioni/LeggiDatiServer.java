package impostazioni;

import core.Configurazione;
import dati.caricadati.LeggiFile;

import java.io.IOException;

public class LeggiDatiServer {
    /***
     * legge i dati di indirizzo server e porta da un file di configurazione


     *leggo un file di testo in cui son contenute le informazioni nel formato
             *  ip|porta
             * sito|porta
    in entrambi i casi tutti le componenti del socket sono salvate come stringhe
    */

    private String indirizzoServer = null;
    private String porta = null;
    private String nomeUtente=null;
    private String password=null;
    private boolean sicuro;

    LeggiFile leggi= new LeggiFile();

    public LeggiDatiServer() {
    }

    public void  caricaDati() throws IOException{

        // leggo il file e importo i valori
        String socket=null;
        String sicuroStr = null;
        String datiUtenti=null;

        socket = leggi.leggi(Configurazione.FILE_CONFIGURAZIONE_SERVER);
        sicuroStr= leggi.leggi(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA);
        datiUtenti=leggi.leggi(Configurazione.FILE_CONFIGURAZIONE_UTENTE);

        splitSocket(socket);
        splitUtente(datiUtenti);

        sicuro=Boolean.valueOf(sicuroStr);

    }

    /***
     *   divide il socket nomeUtente|password nelle due informazioni differenti
     */

    private void splitUtente(String datiUtenti) {
        int indice =-1;
        if(!leggi.isSorgenteVuota(Configurazione.FILE_CONFIGURAZIONE_SERVER)) {
            indice = datiUtenti.indexOf("|");

            nomeUtente = datiUtenti.substring(0, indice);
            password = datiUtenti.substring(indice + 1);
        }
    }

    /***
     *  restutuisce true se le informazioni cercate NON sono presenti
     *  restituisce false se le informazioni cercate sono presenti
     * @param nomeFile
     * @return
     */
    public boolean infoNonPresente(String nomeFile){
         return leggi.infoNonPresente(nomeFile);
    }

    /***
     * controlla se i file di configrazione del sistema sono presenti
     */
    public boolean  fileConfigurazionepresenti(){
        boolean presenti=false;

        if(leggi.isSorgenteEsistente(Configurazione.FILE_CONFIGURAZIONE_SERVER)){
            if(leggi.isSorgenteEsistente(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA)){
                presenti=true;
            }
        }
        return presenti;
    }

    /***
     * divide il socket ip|porta nelle due informazioni differenti
     * @param socket
     */

    public void splitSocket(String socket){
        int indice =-1;
        if(!leggi.isSorgenteVuota(Configurazione.FILE_CONFIGURAZIONE_SERVER)) {
            indice = socket.indexOf("|");

            indirizzoServer = socket.substring(0, indice);
            porta = socket.substring(indice + 1);
        }
}

    public String getNomeUtente(){
        return nomeUtente;
    }

    public String getIndirizzoServer(){
        return indirizzoServer;
    }

    public String getPorta(){
        return porta;
    }

    public boolean getProtocolloSicuro(){return  sicuro;}

    public String getPassword() {
        return password;
    }
}
