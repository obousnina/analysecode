public class CanalSlack extends CanalNotificationAbstrait {

    @Override
    protected String getCoordonnee(Utilisateur utilisateur) {
        return utilisateur.getEmail();
    }

    @Override
    protected String formatMessage(String destinataire, String message) {
        return "Message Slack envoyé à " + destinataire + " : " + message;
    }
}