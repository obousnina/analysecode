public abstract class CanalNotificationAbstrait implements CanalNotification {

    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        String destinataire = getCoordonnee(utilisateur);
        if (destinataire != null) {
            System.out.println(formatMessage(destinataire, message));
        }
    }

    protected abstract String getCoordonnee(Utilisateur utilisateur);

    protected abstract String formatMessage(String destinataire, String message);

}