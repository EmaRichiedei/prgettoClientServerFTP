package connessione;

import core.ElencoFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/***
 * Questa classe utilizza in protocollo SFTP per l'inoltro dei file
 */
public class FTPSicura implements FTPInoltro {

    public FTPSicura() {
        super();
    }

    @Override
    public void inviaFile(ElencoFile elencoFile) throws URISyntaxException, IOException {

    }

    @Override
    public void autenticati(String server,String porta, String utente, String password) throws IOException {

    }

    @Override
    public void inviaSingoloFile(File file, String nomeFile) throws IOException {

    }
}
