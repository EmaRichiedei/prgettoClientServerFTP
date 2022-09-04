package core;

import impostazioni.LeggiDatiServer;
import impostazioni.aggiorna_dati.CaricaServerSingleton;
import interfacciaGrafica.FinestraImpostazioni;
import interfacciaGrafica.FinestraSceltaFile;

import java.io.IOException;

public class Main{


    public static void main(String[] args) throws IOException {

        boolean connessioneSicura=false;
        boolean infoServerNonPresenti=true;
        boolean infoConnessioneNonPresenti=true;

        //FinestraSceltaFile finestraSceltaFile =null;
        FinestraImpostazioni finImpo = null;

        //LeggiDatiServer caricaDati= new LeggiDatiServer();
         LeggiDatiServer caricaDati =CaricaServerSingleton.getInstance();

        infoServerNonPresenti = caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SERVER);
        // carico le informazioni relative al protocolloda utilizzare
        infoConnessioneNonPresenti =  caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA);

        if(infoConnessioneNonPresenti){
            connessioneSicura= false;
        }

        if(infoServerNonPresenti){
            finImpo= new FinestraImpostazioni();

        }else{

            FinestraSceltaFile fi = SceltaFileSingleton.getFinestraFile(connessioneSicura);
        }

        if(infoConnessioneNonPresenti==false) {
            caricaDati.caricaDati();
        }
        connessioneSicura = caricaDati.getProtocolloSicuro();



    }

}
