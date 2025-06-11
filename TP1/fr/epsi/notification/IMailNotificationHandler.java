package fr.epsi.notification;

import fr.epsi.user.User;

public interface IMailNotificationHandler {

    String getEmailAddress(User user);

}
