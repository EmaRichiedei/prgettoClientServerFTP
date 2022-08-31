package impostazioni;

public class CambioSicurezza {
    String nomeFile ="config.txt";
    ScriviFile scrivi = new ScriviFile();

    public void aggiornaProtocollo(boolean _sicuro){
        scrivi.scrivi(String.valueOf(_sicuro),nomeFile);
    }

}
