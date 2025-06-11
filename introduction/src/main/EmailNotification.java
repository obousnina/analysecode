package src.main;

public class EmailNotification implements CanalNotification {
    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        String email = utilisateur.getCanal("email");
        if (email != null) {
            System.out.println("Envoi de l’email à " + email + " : " + message);
        }
    }
}
