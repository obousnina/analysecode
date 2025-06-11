public class CanalSMS extends CanalNotificationAbstrait {

    @Override
    protected String getCoordonnee(Utilisateur utilisateur) {
        return utilisateur.getNumeroTelephone();
    }

    @Override
    protected String formatMessage(String destinataire, String message) {
        return "SMS envoyé à " + destinataire + " : " + message;
    }

}