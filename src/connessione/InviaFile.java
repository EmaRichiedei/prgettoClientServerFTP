package connessione;

import core.ElencoFile;

import java.io.IOException;
import java.net.URISyntaxException;

public class InviaFile {

    private boolean sicuro;
    private FTPInoltro inoltro ;
    private  String nomeUtente;
    private String password;
    private String server;
    private  String porta;

    private ElencoFile fileDaInviare;

    public  InviaFile (boolean _sicuro, ElencoFile daInviare){
        sicuro = _sicuro;
        fileDaInviare=daInviare;
    }



    public void setNomeUtente(String _nomeUtente){
        nomeUtente=_nomeUtente;
    }

    public void setPassword(String _password) {
        password = _password;
    }

    public  void inoltra (ElencoFile elencoFile) throws IOException, URISyntaxException {
        if(sicuro==false){
            // utilizzo il protocollo FTP

            inoltro= new FTPNonSicura();
            inoltro.autenticati(server,porta,nomeUtente,password);
            inoltro.inviaFile(elencoFile);


        }else{
            //utilizzo protocollo SFTP
            inoltro= new FTPSicura();
        }
    }
    public void setServer(String _server){
        server=_server;
    }
    public void setPorta(String _porta){
        porta=_porta;
    }
}