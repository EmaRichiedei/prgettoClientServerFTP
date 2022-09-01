package interfacciaGrafica;

import core.ElencoFile;

import javax.swing.*;

public class AutenticazioneFinestra {

    private Autenticazione autent;
    private ElencoFile elencoFile;
    public AutenticazioneFinestra(){
        creaFinestra();

    }
    public AutenticazioneFinestra(ElencoFile _elencoFile){
        creaFinestra();
        elencoFile=_elencoFile;

    }

    public void creaFinestra(){
        JFrame frame = new JFrame("FTPSender - Autenticazione");
        autent = new Autenticazione(frame);
        //elencoFile=_elencoFile;
        autent.setElencoFile(elencoFile);

        frame.setContentPane(autent.getAuteticazionePanel());
        frame.setLocation(750,450);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setElencoFile(ElencoFile _elencoFile) {
        this.elencoFile = _elencoFile;
    }
}
