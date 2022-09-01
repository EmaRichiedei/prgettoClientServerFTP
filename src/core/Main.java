package core;

import impostazioni.LeggiDatiServer;
import interfacciaGrafica.FinestraImpostazioni;
import interfacciaGrafica.FinestraSceltaFile;

import java.io.IOException;

public class Main{


    public static void main(String[] args) throws IOException {

        boolean infoAggiornate=false;
        boolean connessioneSicura=false;
        boolean infoServerNonPresenti=true;
        boolean infoConnessioneNonPresenti=true;
        //FinestraSceltaFile finestraSceltaFile =null;
        FinestraImpostazioni finImpo = null;



        LeggiDatiServer caricaDati= new LeggiDatiServer();

        infoServerNonPresenti = caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SERVER);
        // carico le informazioni relative al protocolloda utilizzare
        infoConnessioneNonPresenti =  caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA);

        if(infoConnessioneNonPresenti){
            connessioneSicura= false;
        }

        if(infoServerNonPresenti){
            finImpo= new FinestraImpostazioni();

        }else{
            // finestraSceltaFile = new FinestraSceltaFile(connessioneSicura);
            FinestraSceltaFile fi = SceltaFileSingleton.getFinestraFile(connessioneSicura);
        }

        if(infoConnessioneNonPresenti==false) {
            caricaDati.caricaDati();
        }else{

        }

        connessioneSicura = caricaDati.getProtocolloSicuro();



    }

}
