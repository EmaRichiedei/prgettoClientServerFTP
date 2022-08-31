package interfacciaGrafica;

import javax.swing.*;
import java.io.IOException;

public class FinestraSceltaFile {
    private boolean sicuro;

    public  FinestraSceltaFile(boolean protocollo) throws IOException {
        JFrame frame = new JFrame("FTPSender");
        SceltaFIle sceltaFIle = new SceltaFIle();
        sceltaFIle.setSicuro(sicuro);

        frame.setContentPane( sceltaFIle.getSceltaFilePanel());
        frame.setLocation(750,450);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
