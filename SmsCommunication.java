package notification;

/**
 * This class represents a communication strategy for sending text messages.
 * It implements the CommunicationStrategy interface and provides a method for sending text messages.
 * 
 * @author E.YVIN
 */
class SmsCommunication implements CommunicationStrategy {   
    
    /**
     * Sends a text message to the specified client.
     * 
     * @param clientName the name of the client to whom the message is sent
     * @param addresse the phone number of the client
     * @param message the message content to be sent
     */
    public void envoyer(String clientName,String addresse, String message) {
        System.out.println("[SMS (" + addresse + ") -> " + clientName + "] : " + message);
    }

    /**
     * Validates whether the given address is a correct phone number for SMS communication.
     * 
     * Checks if the address starts with '06' or '07' and has a total length of 8 characters.
     * 
     * @param adresse the phone number to validate
     * @return true if the address is a valid phone number, false otherwise
     */
    @Override public boolean isCorrect(String adresse) {
        boolean correct = true;

        for (int i = 0; i < adresse.length(); i++) {
            if (!Character.isDigit(adresse.charAt(i))) {
                correct = false;
                break;
            }
        }

        if(adresse.charAt(0)=='0'
          && (adresse.charAt(1)=='6' || adresse.charAt(1)=='7')
          && adresse.length()==10
          ){
            correct = true;
        }else{
            correct = false;
        }

        return correct;
    }
}