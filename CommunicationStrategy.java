package notification;

/**
 * This interface represents a communication strategy for sending messages.
 * 
 * @author E.YVIN
 */
interface CommunicationStrategy {
    /**
     * Sends a message to the specified client.
     * 
     * @param clientName the name of the client to whom the message is sent
     * @param addresse the address of the client to whom the message is sent
     * @param message the message content to be sent
     */
    public abstract void envoyer(String clientName,String addresse, String message);

    /**
     * Checks if the given address is a valid address for this communication strategy.
     * For most communication strategies, this method will return true.
     * However, some communication strategies may have specific requirements for the address.
     * For example, a communication strategy for sending SMS messages may require the address to start with '06' or '07'.
     * 
     * @param adresse the address to be checked
     * @return true if the address is valid, false otherwise
     */
    public default boolean isCorrect(String adresse) {
        return true;
    }
}   