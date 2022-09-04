package impostazioni.aggiorna_dati;

import core.Configurazione;
import dati.salvadati.ScriviFile;

public class CambioUtente {

    public CambioUtente(){}

    /***
     * scrivi i dati dell'utente sul file "utente.txt"
     * @param usernsame
     * @param pw
     */
    public void scriviDatiUtente(String usernsame,String pw){
        ScriviFile scrivi = new ScriviFile();

        String token =usernsame+"|"+pw;
        scrivi.scrivi(token, Configurazione.FILE_CONFIGURAZIONE_UTENTE);
    }



}


