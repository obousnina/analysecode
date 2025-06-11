package src.main;

import java.util.HashMap;
import java.util.Map;

public class Utilisateur {
    private Map<String, String> canaux = new HashMap<>();

    public void setCanal(String canal, String identifiant) {
        canaux.put(canal, identifiant);
    }

    public String getCanal(String canal) {
        return canaux.get(canal);
    }
}
