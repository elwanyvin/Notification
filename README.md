# Notification

Overview

The Alert Notification Service is a Java-based system that allows users to subscribe to notifications and receive alerts via different communication methods. The service is designed with extensibility in mind, allowing additional communication methods to be added seamlessly.

Features

Users can subscribe to receive notifications using a preferred communication mode.

Available communication modes: SMS, Email, XMESS (social network), and CHAT.

Centralized management of communication instances to optimize resource usage.

Defensive programming principles applied, ensuring robust parameter validation.

Supports dynamic modification of communication strategies at runtime.


Architecture

The system is composed of multiple classes organized within two packages:

notification package

Server: Manages user subscriptions and sends alerts.

Subscriber: Stores user information (name, communication mode, address).

CommunicationFactory: Creates appropriate communication strategy instances.

CommunicationStrategy (interface): Defines the structure for all communication methods.

MailCommunication: Implements email notifications.

SmsCommunication: Implements SMS notifications.

XmessCommunication: Implements XMESS notifications.

ComNetAdapter: Adapts an external ComNet class to integrate CHAT messaging.

CommunicationAccess: Ensures a single instance per communication mode for efficiency.


utilitaire package

ComNet: External class offering CHAT message functionality.


Usage

Subscribing to alerts

Server server = new Server();
server.adherer("Alice", "SMS", "0633343536");
server.adherer("Bob", "MAIL", "bob@orange.fr");

Sending an alert

server.alerter("Emergency Alert!");

Unsubscribing a user

server.retirer("Bob");

Getting the list of subscribers

String[] subscribers = server.getListeInscrits();
for (String s : subscribers) {
    System.out.println(s);
}

Implementation Notes

The CommunicationAccess class ensures each communication mode has a single instance, reducing memory usage.

The ComNetAdapter integrates an external ComNet class, adapting it to fit the system.

The isCorrect(String address) method in CommunicationStrategy validates addresses before subscription.

The system follows the Factory Design Pattern for creating communication strategy instances.



This final version of the Alert Notification Service is optimized for maintainability, extensibility, and efficiency.

