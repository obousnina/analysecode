
###  **Sujet TP1 : Système de gestion de notifications multicanal**

#### Contexte :

Une application Java gère l’envoi de notifications à des utilisateurs, en fonction de leurs préférences. Ces notifications peuvent être envoyées :

* par email,
* par SMS,
* ou via une application mobile (push notification).

Voici le code initial simplifié (fourni aux étudiants) :

```java
public class NotificationManager {

    public void envoyerNotification(Utilisateur utilisateur, String message) {
        if (utilisateur.getEmail() != null) {
            System.out.println("Envoi de l’email à " + utilisateur.getEmail() + " : " + message);
        }

        if (utilisateur.getNumeroTelephone() != null) {
            System.out.println("Envoi du SMS à " + utilisateur.getNumeroTelephone() + " : " + message);
        }

        if (utilisateur.getDeviceToken() != null) {
            System.out.println("Envoi de la notification push à " + utilisateur.getDeviceToken() + " : " + message);
        }
    }
}
```

Et la classe utilisateur :

```java
public class Utilisateur {
    private String email;
    private String numeroTelephone;
    private String deviceToken;

    // Getters, setters, constructeur
}
```

---


* Identifier les problèmes de conception (couplage, duplication, ....).
* Proposer une architecture orientée interface/abstraction.
* Travailler avec les tests unitaires et mocks.
* Penser évolutivité : ajout d’un canal « WhatsApp », « Slack », etc. sans modifier le code existant.

