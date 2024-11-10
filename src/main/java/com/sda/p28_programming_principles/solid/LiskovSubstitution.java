package com.sda.p28_programming_principles.solid;

// SOLID
// S: Single Responsibility
// O: Open/Closed Principle
// L: Liskov Substitution Principle (LSP)
// Definition: Subtypes must be substitutable for their base types without altering the correctness of the program.
// In other words, objects of a superclass should be replaceable with objects of a subclass without affecting the functionality of the program.
public class LiskovSubstitution {

    // in this bad example, PushNotification violates LSP because it cannot be substituted for
    // the base Notification class without causing unexpected behaviour
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification push = new PushNotification();

        service.notifyUser(email, "Email message"); // works fine
        service.notifyUser(sms, "SMS message"); // works fine
        service.notifyUser(push, "Push message"); // throws exception
    }

    // base class for notifications
    static class Notification {
        public void send(String message) {
            // generic send method
        }
    }

    // subclass for email notifications
    static class EmailNotification extends Notification {
        @Override
        public void send(String message) {
            // send email logic
        }
    }

    // subclass for SMS notifications
    static class SMSNotification extends Notification {
        @Override
        public void send(String message) {
            // send SMS logic
        }
    }

    // subclass for PushNotification that introduces unexpected behaviour
    static class PushNotification extends Notification {
        @Override
        public void send(String message) {
            throw new RuntimeException("Push notifications are not supported yet");
        }
    }

    static class NotificationService {
        public void notifyUser (Notification notification, String message) {
            notification.send(message);
        }
    }


    // to fix this, we can either remove the PushNotification extension at all, or
    // we can change the implementation of the send() method inside PushNotification to send PUSH logic
    // and ensuring that it can be substituted interchangeably without affecting the behaviour of the system

}
