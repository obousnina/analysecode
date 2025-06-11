public class CanalWhatsApp extends CanalNotificationAbstrait {

    @Override
    protected String getCoordonnee(Utilisateur utilisateur) {
        return utilisateur.getNumeroTelephone();
    }

    @Override
    protected String formatMessage(String destinataire, String message) {
        return "Message WhatsApp envoyé à " + destinataire + " : " + message;
    }
}