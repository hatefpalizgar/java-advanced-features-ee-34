package com.sda.p28_programming_principles.solid;

// SOLID
// S: Single Responsibility
// O: Open/Closed Principle
// L: Liskov Substitution Principle (LSP)
// I: Interface Segregation(ISP)
// D: Dependency Inversion
// Definition: High-level modules should not depend on low-level modules.
// Both should depend on abstractions.
// Abstractions should not depend on details; details should depend on abstractions.
public class DependencyInversion {

    static class EmailService {
        public void sendEmail(String message) {
            // send email
        }
    }

    // high-level module NotificationService depends on a low-level module EmailService
    // Downside is, any change in the dependency(EmailService) will impact the NotificationService
    // NotificationService IS TIGHTLY COUPLED TO EmailService
    static class NotificationService {
        private EmailService service = new EmailService(); // dependency on EmailService

        public void notify(String message) {
            service.sendEmail(message);
        }
    }

    // to avoid tight coupling (which is a bad thing and we have to always avoid tight coupling)
    // we prefer to change above code to provide LOOSE COUPLING (which is a good thing)
    interface MessageService {
        void sendMessage(String message);
    }

    static class EmailServiceV2 implements MessageService {
        @Override
        public void sendMessage(String message) {
            // send email
        }
    }

    static class SMSService implements MessageService {
        @Override
        public void sendMessage(String message) {
            // send SMS
        }
    }

    // Now, NotificationServiceV2 depends on the MessageService abstraction, allowing flexibility
    // NotificationServiceV2 IS LOOSELY COUPLED TO MessageService
    static class NotificationServiceV2 {
        private MessageService messageService;

        public NotificationServiceV2(MessageService messageService) {
            this.messageService = messageService;
        }

        public void notify(String message) {
            messageService.sendMessage(message);
        }

    }


}
