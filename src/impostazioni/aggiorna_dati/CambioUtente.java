package impostazioni.aggiorna_dati;

import core.Configurazione;
import salvadati.ScriviFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    /***
     * importo i dati dell'utente dal file "utente.txt" e li restituisco in un unica srtringa nel formato
     *
     *     nomeUtente|password
     *
     * @param nomeFile
     * @return
     * @throws IOException
     */
    public String leggiDatiUtente(String nomeFile) throws  IOException{

        String token=null;

        BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
        String line ;

        token = reader.readLine();
        reader.close();

        return token;
    }

    public String getPassword() throws IOException {
        String token = leggiDatiUtente(Configurazione.FILE_CONFIGURAZIONE_UTENTE);
        String password = token.substring(token.indexOf("|")+1)  ;
        return password;
    }

    public String getNomeUtente() throws  IOException{
        String token = leggiDatiUtente(Configurazione.FILE_CONFIGURAZIONE_UTENTE);
        String nomeUtente = token.substring(0,token.indexOf("|"))  ;
        return nomeUtente;

    }


}


