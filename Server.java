package notification;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a server for sending alerts to subscribers.
 * It provides methods for registering, removing, and alerting subscribers.
 * 
 * @author E.YVIN
 */
public class Server {

    /**
     * A map to store subscribers, where the key is the client name and the value is the Subscriber object.
     */
    private Map<String, Subscriber> abonnements;

    /**
     * Default constructor to initialize the abonnements map.
     */
    public Server() {
        this.abonnements = new HashMap<String, Subscriber>();
    }

    /**
     * Registers a new subscriber with the specified client name, mode, and address.
     * 
     * Validates the input parameters and checks for uniqueness of the client name.
     * If the client name is not unique or any parameter is invalid, an error message is printed.
     * Otherwise, it creates a new Subscriber and adds it to the abonnements map.
     *
     * @param clientName the name of the client to be registered
     * @param mode the communication mode, either "SMS" or "MAIL"
     * @param adr the address, either phone number or email
     */
    public void adherer(String clientName, String mode, String adr) {
        if(clientName == null || clientName.length() == 0
                || mode == null || mode.length() == 0
                || adr == null || adr.length() == 0){ 
            System.err.println("Erreur : Vos paramètres sont incorrects, veuillez recommencer.");
        
        }else if( abonnements.get(clientName) != null ) {
            System.err.println("Erreur : Ce nom n'est pas unique, veuillez entrer un autre nom.");
        } else {
            CommunicationStrategy modeCommunication = CommunicationFactory.create(mode);

            if (modeCommunication.isCorrect(adr) == false) {
                System.err.println("Erreur : Votre adresse est incorrecte, veuillez recommencer.");
            }else{
                Subscriber subscriber = new Subscriber(clientName, mode, adr);
                CommunicationAccess.setCom(mode, modeCommunication);
                abonnements.put(clientName, subscriber);
            }
        }
    }


    /**
     * Removes a subscriber with the specified client name from the abonnements map.
     * 
     * Validates the input parameter and checks for existence of the client name.
     * If the client name is invalid or doesn't exist, an error message is printed.
     * Otherwise, it removes the subscriber from the abonnements map.
     * 
     * @param clientName the name of the client to be removed
     */
    public void retirer(String clientName) {
        if(clientName == null || clientName.length() == 0) {
            System.err.println("Erreur : Le nom doit être renseigné, veuillez recommencer.");
        }else if(abonnements.get(clientName) == null) {
            System.err.println("Erreur : Ce nom n'existe pas, veuillez entrer un autre nom.");
        }else{
            abonnements.remove(clientName);
        }
        
    }

    /**
     * Sends a message to all subscribers in the abonnements map.
     * 
     * Validates the input parameter.
     * If the message is invalid or empty, an error message is printed.
     * Otherwise, it iterates over the subscribers and sends the message using the appropriate communication strategy.
     * 
     * @param message the message to be sent
     */
    public void alerter(String message){
        if(message == null || message.length() == 0) {
            System.err.println("Erreur : Le message doit être renseigné, veuillez recommencer.");
        }else{
        
            for (Subscriber subscriber : abonnements.values()) {
                String nom = subscriber.getNom();
                String adresse = subscriber.getAdresse();
                CommunicationStrategy strategy = CommunicationAccess.getCom(subscriber.getMode());

                strategy.envoyer(nom, adresse, message);
            }
        }
    }

    /**
     * Returns a list of subscribed clients.
     *
     * @return an array of strings with each element containing the client's name
     * and communication mode in the format "name adress (mode)"
     */
    public String[] getListeInscrits() {
        String[] inscrits = new String[abonnements.size()];
        int i = 0;
        for (Subscriber subscriber : abonnements.values()) {
            inscrits[i] = subscriber.getNom() + " " + subscriber.getAdresse() + " (" + subscriber.getMode() + ")";
            i++;
        }
        return inscrits;
    }
    
}