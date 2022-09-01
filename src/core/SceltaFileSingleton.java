package core;

import interfacciaGrafica.FinestraSceltaFile;

import java.io.IOException;

public class SceltaFileSingleton {
    private static   FinestraSceltaFile finestraSceltaFile =null; //è un singleton
    private SceltaFileSingleton (){}

    public  static FinestraSceltaFile getFinestraFile(boolean sicuro) throws IOException {
        if(finestraSceltaFile==null){
            finestraSceltaFile= new FinestraSceltaFile(sicuro);
        }
        return finestraSceltaFile;
    }

}
