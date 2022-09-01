package interfacciaGrafica;

import javax.swing.*;
import java.io.IOException;

public class FinestraImpostazioni  {
    Impostazioni impo;
    public FinestraImpostazioni() throws IOException {

        JFrame frame = new JFrame("Impostazioni");
        impo =new Impostazioni(frame);
        frame.setContentPane(impo.getImpostazioniPanel());
        frame.setLocation(750,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
