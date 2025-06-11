public class CanalPush extends CanalNotificationAbstrait {

    @Override
    protected String getCoordonnee(Utilisateur utilisateur) {
        return utilisateur.getDeviceToken();
    }

    @Override
    protected String formatMessage(String destinataire, String message) {
        return "Push envoyé à " + destinataire + " : " + message;
    }
}