package impostazioni;

import core.Configurazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private boolean sicuro;

    public LeggiDatiServer() {}

    public void  caricaDati() throws IOException{  //TODO inserire controllo su esistenza dei File

        // leggo il file e importo i valori
        String socket =leggi(Configurazione.FILE_CONFIGURAZIONE_SERVER);
        String sicuroStr=leggi(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA);


        int indice =-1;
        if(!isVuoto(Configurazione.FILE_CONFIGURAZIONE_SERVER)) {
            indice = socket.indexOf("|");

            indirizzoServer = socket.substring(0, indice);
            porta = socket.substring(indice + 1);
        }

        sicuro=Boolean.valueOf(sicuroStr);
    }

    public String getIndirizzoServer(){
        return indirizzoServer;
    }

    public   String getPorta(){
        return porta;
    }

    public boolean getProtocolloSicuro(){return  sicuro;}

    public String  leggi(String nomeFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
        String line ;

        line = reader.readLine();
        reader.close();

        return line;
    }

    /***
     *  restutuisce true se le informazioni cercate NON sono presenti
     *  restituisce false se le informazioni cercate sono presenti
     * @param nomeFile
     * @return
     */
    public boolean infoNonPresente(String nomeFile){
         boolean nonPresenti = true;
         File file = new File(nomeFile);

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
     * controlla se i file di configrazione del sistema sono presenti
     */
    public boolean  fileConfigurazionepresenti(){
        boolean presenti=false;

        if(isPresente(Configurazione.FILE_CONFIGURAZIONE_SERVER)){
            if(isPresente(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA)){
                presenti=true;
            }
        }
        return presenti;
    }

    public boolean isPresente(String nomeFile){
        File file = new File(nomeFile);
        return file.exists();
    }
    public boolean isVuoto(String nomeFile){
        boolean isVuoto = false;
        File file = new File(nomeFile);
        if (file.length()==0){
            isVuoto=true;
        }
        return isVuoto;
    }

}
