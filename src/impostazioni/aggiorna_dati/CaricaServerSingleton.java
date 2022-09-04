package impostazioni.aggiorna_dati;

import impostazioni.LeggiDatiServer;

public class CaricaServerSingleton {
    private static LeggiDatiServer leggiDati;

    private CaricaServerSingleton(){}

    public static LeggiDatiServer getInstance(){
        if(leggiDati==null){
            leggiDati=new LeggiDatiServer();
        }
        return leggiDati;
    }
}
