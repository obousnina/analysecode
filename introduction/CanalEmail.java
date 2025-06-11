public class CanalEmail implements CanalNotification {
    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        if (utilisateur.getEmail() != null) {
            System.out.println("Email envoyé à " + utilisateur.getEmail() + " : " + message);
        }
    }
}