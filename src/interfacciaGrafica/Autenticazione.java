package interfacciaGrafica;

import connessione.InviaFile;
import core.ElencoFile;
import impostazioni.LeggiDatiServer;

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

    private String utente;
    private String password;
    private boolean sicuro;
    private ElencoFile elencoFile;
    private LeggiDatiServer leggiDatiServer= new LeggiDatiServer() ;

    InviaFile invia ;
    private JFrame frame;

    public Autenticazione(JFrame frame) {
        this.frame = frame;
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

                invia.setNomeUtente(usernameTxtFild.getText());
                invia.setPassword(inserimentoPw.getText());

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
