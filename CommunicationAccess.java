package notification;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides access to communication strategies based on different modes of communication.
 * 
 * @author E.YVIN
 */
class CommunicationAccess{

    /**
     * A map of communication strategies associated with different modes of communication.
     */
    private static Map<String, CommunicationStrategy> medias = new HashMap<String, CommunicationStrategy>();

    /**
     * Private constructor to prevent instantiation.
     */
    private CommunicationAccess() {
    }   

    /**
     * Sets the communication strategy associated with the given mode.
     * 
     * @param mode the mode of communication, "SMS" or "MAIL" or "XMESS" or "CHAT"
     * @param comObj the communication strategy to be associated with the mode
     */
    public static void setCom(String mode, CommunicationStrategy comObj) {
        medias.put(mode, comObj);
    }

    /**
     * Returns the communication strategy associated with the given mode.
     * 
     * @param mode the mode of communication, "SMS" or "MAIL" or "XMESS" or "CHAT"
     * @return the associated communication strategy
     */
    public static CommunicationStrategy getCom(String mode) {
        return medias.get(mode);
    }

}