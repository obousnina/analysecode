package fr.epsi.notification;

import fr.epsi.user.User;

public interface ISMSNotificationHandler {

    String getPhoneNumber(User user);

}
