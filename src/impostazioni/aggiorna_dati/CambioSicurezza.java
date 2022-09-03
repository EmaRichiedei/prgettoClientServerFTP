package impostazioni.aggiorna_dati;

import core.Configurazione;
import salvadati.ScriviFile;

public class CambioSicurezza {
    String nomeFile = Configurazione.FILE_CONFIGURAZIONE_SICUREZZA;
    ScriviFile scrivi = new ScriviFile();

    public void aggiornaProtocollo(boolean _sicuro){
        scrivi.scrivi(String.valueOf(_sicuro),nomeFile);
    }

}
