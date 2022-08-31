package interfacciaGrafica;

import javax.swing.*;
import java.io.IOException;

public class FinestraImpostazioni  {
    public FinestraImpostazioni() throws IOException {

        JFrame frame = new JFrame("Impostazioni");
        frame.setContentPane(new Impostazioni(frame).getImpostazioniPanel());
        frame.setLocation(750,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
