package notification;

import utilitaire.ComNet;

/**
 * This class represents a communication strategy for sending messages through a communication network.
 * It implements the CommunicationStrategy interface and provides a method for sending messages.
 * It uses the ComNet class to send messages.
 * @author E.YVIN
 */
class ComNetAdaptator implements CommunicationStrategy{

    /** The communication network used to send messages. */ 
    private ComNet theCom = new ComNet();

    /**
     * Sends a message to the specified client through the communication network.
     * 
     * @param clientName the name of the client to whom the message is sent
     * @param addresse the address of the client to whom the message is sent
     * @param message the message content to be sent
     */
    public void envoyer(String clientName,String addresse, String message) {
        theCom.send(addresse, message);
        System.out.println("[CHAT (" + addresse + ") -> " + clientName + "] : " + message);
    }
}