package core;

import impostazioni.LeggiDatiServer;
import interfacciaGrafica.AutenticazioneFinestra;
import interfacciaGrafica.FinestraSceltaFile;

import java.io.IOException;

public class Main{


    public static void main(String[] args) throws IOException {

        String porta;
        String server;
        boolean connessioneSicura;
        boolean infoServerNonPresenti=true;
        boolean infoConnessioneNonPresenti=true;



        LeggiDatiServer caricaDati= new LeggiDatiServer();

        infoServerNonPresenti = caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SERVER);

        if(infoServerNonPresenti){
            AutenticazioneFinestra autenticazioneFinestra = new AutenticazioneFinestra();
        }

        infoConnessioneNonPresenti =  caricaDati.infoNonPresente(Configurazione.FILE_CONFIGURAZIONE_SICUREZZA);

        if(infoConnessioneNonPresenti){
           connessioneSicura= false;
        }

        caricaDati.caricaDati();

        connessioneSicura = caricaDati.getProtocolloSicuro();

        FinestraSceltaFile finestraSceltaFile = new FinestraSceltaFile(connessioneSicura);

    }

}
