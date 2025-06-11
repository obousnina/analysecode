import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Utilisateur user = new Utilisateur("jacquesChirak@mail-elysee.com", "0753512453", "Iphone-12-Jacques");

        NotificationManager manager = new NotificationManager(Arrays.asList(
                new CanalEmail(),
                new CanalSMS(),
                new CanalPush(),
                new CanalWhatsApp(),
                new CanalSlack()
        ));

        manager.envoyerNotification(user, "Bienvenue dans notre application !");
    }
}
