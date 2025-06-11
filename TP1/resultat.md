## Réponses

**Problèmes de conception du code initial :**
- **Couplage fort** : NotificationManager gère directement tous les canaux.
- **Duplication** : le même code est répété pour chaque canal (if).
- **Difficilement extensible** : impossible d'ajouter un canal (WhatsApp, Slack) sans modifier la classe NotificationManager
- **Pas de tests unitaires possibles** : pas d'abstraction pour injecter des mocks

**Solution proposée :**
- Créer une interface `NotificationChannel` avec `envoyerNotification(Utilisateur, String)`.
- Chaque canal (Email, SMS, Push) implémente cette interface.
- `NotificationManager` utilise une liste de canaux injectés.
- Permet d'ajouter un canal facilement et de tester chaque canal séparément

Voici l'arborescence attendue :

```
notifications/
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── notifications/
    │   │           ├── channels/         # Implémentations des canaux (Email, SMS, Push)
    │   │           ├── interfaces/       # Interface NotificationChannel
    │   │           ├── model/           # Classe Utilisateur
    │   │           ├── service/         # NotificationManager
    │   │           └── Main.java        # Point d'entrée de l'application
    │   └── test/
    │       └── java/
    │           └── notifications/
    │               ├── channels/         # Tests des canaux
    │               └── service/         # Tests du NotificationManager