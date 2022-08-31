package core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/***
   *   Classe per la gestione dei file, si presuppone che nell'elenco dei file non ci siano die file con lo stesso nome
   */

public class ElencoFile {

    private  ArrayList<File> elencoFile = new ArrayList<>();

    public ElencoFile(File[] files){
        Collections.addAll(elencoFile,files);
    }

    public ArrayList<File> getElencoFile() {
        return elencoFile;
    }

    public boolean isPresente(String nomeFile){
        boolean presente= false;
        for(int i =0;i< elencoFile.size();i++){
            if(elencoFile.get(i).getName().equals(nomeFile)){
                presente= true;
                break;
            }
        }
        return presente;
    }

    public int numeroFile(){
        return elencoFile.size();
    }

    public File getFile(String nomeFile){
        File file= null;
        for (int i =0; i < elencoFile.size(); i++ ){
            if(elencoFile.get(i).getName().equals(nomeFile)){
                file = elencoFile.get(i);
            }
        }
        return file;
    }

    public String getPathFile(int i){
         String pathFile= null;
         pathFile = elencoFile.get(i).getPath();
         return pathFile;
    }
    @Override
    public String toString() {

        StringBuffer elencoNomiFile = new StringBuffer();
        for (int i=0 ; i<numeroFile();i++){
            elencoNomiFile.append(elencoFile.get(i).getName()+"\n");
        }
        return String.valueOf(elencoNomiFile);
    }

    public String getNomeFile(int i) {
        String nomeFile = elencoFile.get(i).getName();
        return nomeFile;
    }
}
