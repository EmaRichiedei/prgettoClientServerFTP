package connessione;

import core.ElencoFile;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

/***
 * utilizzo del protocollo FTP per l'invio dei file
 */

public class FTPNonSicura implements FTPInoltro {


    FTPClient ftpClient ;

    public FTPNonSicura() {
        super();
    }

    /***
     * invia ogni file dell'elenco sul server destinazione
     * @param elencoFile
     * @throws URISyntaxException
     * @throws IOException
     */

    @Override
    public void inviaFile(ElencoFile elencoFile) throws URISyntaxException, IOException {

        File file;
        String nuovoNomeFile;
        String pathFile;
        for(int i =0 ;i<elencoFile.numeroFile();i++) {
            pathFile =elencoFile.getPathFile(i);  //ritorno il path del file in i-esima posizione nell'elenco
            nuovoNomeFile = elencoFile.getNomeFile(i);
            file = new File(elencoFile.getPathFile(i));

            inviaSingoloFile(file,nuovoNomeFile);
        }
    }

    @Override
    public void autenticati(String server,String por, String utente, String password )throws IOException {

        String port1="2121";
        int porta = Integer.valueOf(port1);
        String server1="192.168.1.35";
        boolean ipCorretto=false;
        /*
        ipCorretto=ControlloParametriConnessione.isIndirizzoIp(server1);

        if(ipCorretto == false) {
            // se ip non corretto persuppongo che si tratti di un indirizzo web, quindi devo tradurlo in indirizzo ip
            ConversioneIP.convertiIP(server);
        }*/
        ftpClient = new FTPClient();
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        ftpClient.connect(server1, porta);
        //ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

        int reply = ftpClient.getReplyCode();

        if(ftpClient.isConnected()){
            System.out.println("connesso");
        }

        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new IOException("Exception in connecting to FTP Server");  //TODO sostituire con una finestra grafica
        }

        ftpClient.login(utente, password);
    }

    void close() throws IOException {
        ftpClient.disconnect();
    }
   @Override
    /***
     * Salva il file selezionato sul server destinazione con nome indicato da nomeFile
     *
     * @param file - file da inviare al server
     * @param nomeFile - nome con cui salvare il file sul server destinazione
     * @throws IOException
     */
    public void inviaSingoloFile(File file, String nomeFile) throws IOException {
       //ftpClient.storeFileStream(nomeFile);
       FileInputStream daCaricare =  new FileInputStream(file);
       ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
       ftpClient.storeFile(nomeFile, daCaricare);


   }



}
