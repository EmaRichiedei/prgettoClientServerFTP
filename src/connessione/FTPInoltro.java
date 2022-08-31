package connessione;

import core.ElencoFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public interface FTPInoltro {

    public ElencoFile elencoFile = null;

    public void inviaFile(ElencoFile elencoFilefile) throws URISyntaxException, IOException;
    public void autenticati(String server,String porta, String utente, String password) throws IOException;
    public void inviaSingoloFile(File file, String nomeFile) throws IOException;

}
