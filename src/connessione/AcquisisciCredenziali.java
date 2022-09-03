package connessione;

import core.ElencoFile;
import interfacciaGrafica.AutenticazioneFinestra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AcquisisciCredenziali implements  ActionListener{

    private boolean sicuro;
    private String username;
    private String password;
    private ElencoFile elencoFile ;



    public AcquisisciCredenziali(boolean _sicuro) throws IOException {
        sicuro=_sicuro;
    }

        @Override
        public void actionPerformed(ActionEvent e)  {
            /*permette l'invio dei dati
             * acquisico le credenziali dell'utente
             * invio i file mediante il protocollo scelto
             */
            try {
                AutenticazioneFinestra autenticazioneFinestra = new AutenticazioneFinestra(elencoFile);
            }catch (IOException ef){

            }




        }

    public void setElencoFile(ElencoFile elencoFile) {
        this.elencoFile = elencoFile;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
