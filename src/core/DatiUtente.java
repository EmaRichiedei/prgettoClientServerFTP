package core;

public class DatiUtente {
    private String nomeUtente=null;
    private String password=null;
    public DatiUtente(){

    }
    public DatiUtente(String _nomeUtente,String _password){
        nomeUtente=_nomeUtente;
        password=_password;
    }

    public String getPassword() {
        return password;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }
    public void salvaUtenti(){

    }
}
