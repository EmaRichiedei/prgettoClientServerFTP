package interfacciaGrafica;

import connessione.AcquisisciCredenziali;
import core.ElencoFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SceltaFIle extends Component {
    private JPanel pulsantiPanel;
    private JButton inviaButton;
    private JButton impostazioniButton;
    private JPanel principalePanel;
    private JButton importaFileButton;
    private JLabel selezioneLabel;
    private JTextArea selezionatiTextArea;
    private JFileChooser fileChooser;

    private AcquisisciCredenziali acquisisci ;

    private boolean sicuro;
    private ElencoFile elencoFile=null;
    private File[] fileSelezionati;

    public SceltaFIle() throws IOException {

        acquisisci = new AcquisisciCredenziali(sicuro);
        impostazioniButton.addActionListener(new ModificaImpostazioni());
        inviaButton.addActionListener(acquisisci);

        fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Seleziona File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);


        importaFileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = fileChooser.showOpenDialog(SceltaFIle.this);

                if(n==JFileChooser.APPROVE_OPTION){
                    fileSelezionati= fileChooser.getSelectedFiles();
                    elencoFile = new ElencoFile(fileSelezionati);
                    selezionatiTextArea.setText(elencoFile.toString());
                    acquisisci.setElencoFile(elencoFile);

                }


            }

        });

    }

    private class ModificaImpostazioni implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // apre la finestra per modificare le impostazioni
            try {
                FinestraImpostazioni finestraImpostazini=new FinestraImpostazioni();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setSicuro(Boolean _sicuro){
        sicuro=_sicuro;
    }


    public JPanel getSceltaFilePanel(){
        return principalePanel;
    }

}
