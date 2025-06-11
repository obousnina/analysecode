package src.main;

public class PushNotification implements CanalNotification {
    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        String deviceToken = utilisateur.getCanal("push");
        if (deviceToken != null) {
            System.out.println("Envoi de la notification push à " + deviceToken + " : " + message);
        }
    }
}
