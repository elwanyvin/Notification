package notification;

/**
 * Factory class for creating communication strategies based on the mode specified.
 * 
 * @author E.YVIN
 */
class CommunicationFactory {

    /**
     * Private constructor to prevent instantiation.
     */
    private CommunicationFactory() { }

    /**
     * Creates a communication strategy based on the mode specified.
     *
     * @param mode the mode of communication, "SMS" or "MAIL" or "XMESS" or "CHAT"
     * @return a new instance of the corresponding communication strategy
     */
    public static CommunicationStrategy create(String mode) {
        if(mode.equals("SMS")) {
            return new SmsCommunication();
        }else if(mode.equals("MAIL")){
            return new MailCommunication();
        }else if(mode.equals("XMESS")){
            return new XmessCommunication();
        }else if(mode.equals("CHAT")){
            return new ComNetAdaptator();
        }else{
            return null; 
        }
    }
}