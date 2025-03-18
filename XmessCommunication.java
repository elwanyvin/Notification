package notification;

/**
 * This class represents a communication strategy for sending messages using the Xmess protocol.
 * It implements the CommunicationStrategy interface and provides a method for sending messages.
 * 
 * @author E.YVIN
 */
class XmessCommunication implements CommunicationStrategy{
    
    /**
     * Sends a message using the Xmess protocol to the specified client.
     * 
     * @param clientName the name of the client to whom the message is sent
     * @param addresse the address of the client to whom the message is sent
     * @param message the message content to be sent
     */
    public void envoyer(String clientName,String addresse, String message) {
        System.out.println("[XMESS (" + addresse + ") -> " + clientName + "] : " + message);
    }
}