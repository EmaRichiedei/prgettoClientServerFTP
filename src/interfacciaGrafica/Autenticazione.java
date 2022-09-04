package interfacciaGrafica;

import connessione.InviaFile;
import core.ElencoFile;
import impostazioni.LeggiDatiServer;
import impostazioni.aggiorna_dati.CambioUtente;
import impostazioni.aggiorna_dati.CaricaServerSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Autenticazione {

    private JPasswordField inserimentoPw;
    private JTextField usernameTxtFild;
    private JButton autemticaBtn;
    private JPanel autenticazionePanel;
    private JCheckBox salvaCredenziali;

    private String utente;
    private String password;
    private boolean sicuro;
    private ElencoFile elencoFile;
    private LeggiDatiServer leggiDatiServer= CaricaServerSingleton.getInstance();

    InviaFile invia ;
    private JFrame frame;

    public Autenticazione(JFrame frame) throws IOException {
        this.frame = frame;

        leggiDatiServer.caricaDati();

        String a=leggiDatiServer.getNomeUtente();

        usernameTxtFild.setText(a);
        inserimentoPw.setText(leggiDatiServer.getPassword());
        //ElencoFile _elencoFile
        invia= new InviaFile(sicuro,elencoFile);

        invia.setServer(leggiDatiServer.getIndirizzoServer());
        invia.setPorta (leggiDatiServer.getPorta());

        autemticaBtn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                  utente=usernameTxtFild.getText();
                  password =inserimentoPw.getText();

                  invia.setNomeUtente(utente);
                  invia.setPassword(password);

                if(salvaCredenziali.isSelected()){
                    //salva credenziali Utente

                    CambioUtente cambioUtente = new CambioUtente();
                    cambioUtente.scriviDatiUtente(utente,password);

                }

                try {

                    invia.inoltra(elencoFile);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
                frame.setVisible(false);

            }
        });
    }


    public String getPassword (){
        return password;
    }
    public String getNomeUtente(){
        return utente;
    }

    public void setElencoFile(ElencoFile elencoFile) {
        this.elencoFile = elencoFile;
    }

    public JPanel getAuteticazionePanel(){
        return autenticazionePanel;
    }


}
