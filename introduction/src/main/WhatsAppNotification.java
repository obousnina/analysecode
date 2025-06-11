package src.main;

public class WhatsAppNotification implements CanalNotification {
    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        String whatsappNumber = utilisateur.getCanal("whatsapp");
        if (whatsappNumber != null) {
            System.out.println("Envoi du message WhatsApp à " + whatsappNumber + " : " + message);
        }
    }
}
