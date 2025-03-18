package notification;

/**
 * This class represents a communication strategy for sending email messages.
 * It implements the CommunicationStrategy interface and provides a method for sending email messages.
 *
 * @author E.YVIN
 */
class MailCommunication implements CommunicationStrategy {
    
    /**
     * Sends an email message to the specified client.
     *
     * @param clientName the name of the client to whom the message is sent
     * @param addresse the email address of the client
     * @param message the message content to be sent
     */
    public void envoyer(String clientName,String addresse, String message) {
        System.out.println("[MAIL (" + addresse + ") -> " + clientName + "] : " + message);
    }
}