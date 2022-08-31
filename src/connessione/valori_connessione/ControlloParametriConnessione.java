package connessione.valori_connessione;

public  class ControlloParametriConnessione {
    /***
     * controlla se una stringa inserita è un indirizzo IPv4 valido
     *
     * @param indirizzoIp
     * @return
     */
    public static boolean isIndirizzoIp(String indirizzoIp){
        boolean isIp= false;
        boolean bytevalido=false;
        int indice =-1;
        String sottoStringIndirizzo=null;
        String appoggio;
        int byteAppoggio=-1;
        int contatore=0;  // conta quanti blocchi di bytes sono presenti nella stringa indirizzo

        appoggio=indirizzoIp;
        indice = indirizzoIp.indexOf(".");

        while (indice > 0 ) {

            sottoStringIndirizzo = appoggio.substring(0, indice);
            appoggio=appoggio.substring(indice+1);

            contatore++;
            byteAppoggio = Integer.valueOf(sottoStringIndirizzo);

            if (byteAppoggio >= 256) {
                bytevalido = false;
                return false;
            }else {
                bytevalido = true;
            }
            /*
            sottoStringIndirizzo = appoggio.substring(0,indice);
            appoggio=appoggio.substring(indice+1);
            */
            indice = appoggio.indexOf(".");
        }

        if(contatore==3 && bytevalido==true){
            isIp=true;
        }


        return isIp;
    }

}
