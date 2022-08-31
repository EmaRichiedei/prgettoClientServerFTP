package interfacciaGrafica;

import impostazioni.CambioServer;
import impostazioni.CambioSicurezza;
import impostazioni.LeggiDatiServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Impostazioni {

    private JTextField serverTxt;
    private JTextField portaTxt;
    private JRadioButton ftpRbtn;
    private JRadioButton sftpRbtn;

    private ButtonGroup sceltaSicurezza = new ButtonGroup();
    private JButton salvaBtn;

    private JPanel impostazioniView;

    private String serverInserito;
    private String portaInserita;

    private String porta;
    private String server;
    private boolean sicuro;

    LeggiDatiServer caricaDati= new LeggiDatiServer();
    CambioSicurezza aggiorna = new CambioSicurezza();
    private JFrame frame;

    public Impostazioni(JFrame frame)  throws  IOException {
        this.frame = frame;

        configurazioneIniziale();  // carico le configurazioni iniziali
        salvaBtn.addActionListener(new SalvaDati());

        sceltaSicurezza.add(sftpRbtn);
        sceltaSicurezza.add(ftpRbtn);

        sftpRbtn.setActionCommand("sftp");
        ftpRbtn.setActionCommand("ftp");

        serverTxt.setText(server);
        portaTxt.setText(porta);


        if (sicuro) {
             sftpRbtn.setSelected(true);
             ftpRbtn.setSelected(false);
        } else{
            ftpRbtn.setSelected(true);
            sftpRbtn.setSelected(false);

    }

    }


    private class SalvaDati implements ActionListener {

        public SalvaDati() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CambioServer cambio = new CambioServer();

            String sicuroStr = sceltaSicurezza.getSelection().getActionCommand();

            serverInserito = serverTxt.getText();
            portaInserita = portaTxt.getText();

            if(sicuroStr.equals("ftp")){
                sicuro=false;
            }else{
                sicuro=true;
            }

            aggiorna.aggiornaProtocollo(sicuro);

            cambio.setNuovaPorta(portaInserita);
            cambio.setNuovoIndServer(serverInserito);


            porta=portaInserita;
            server=serverInserito;
            try {
                cambio.cambio();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            frame.setVisible(false);


        }
    }


    private void configurazioneIniziale (){
        porta = caricaDati.getPorta();
        server = caricaDati.getIndirizzoServer();
        sicuro= caricaDati.getProtocolloSicuro();
    }


    public JPanel getImpostazioniPanel (){
        return impostazioniView;
    }
}
