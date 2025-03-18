package notification;

/**
 * This class represents a subscriber to receive alerts from a server.
 * It has a name, a communication mode, an address, and a communication strategy.
 * 
 * @author E.YVIN
 */
class Subscriber{
    /**Name of the subscriber */
    private String nom;

    /**Mode of communication, either "SMS" or "MAIL" */
    private String mode;

    /**Address of the subscriber */
    private String adresse;


    /**
     * Constructor
     * @param nom the name of the subscriber
     * @param mode the mode of communication
     * @param adr the address of the subscriber
     */
    public Subscriber(String nom, String mode, String adr) {
        if(nom == null){
            System.out.println("Subscriber: Le nom ne peut pas être null.");
        }else if(nom.length() == 0){
            System.out.println("Subscriber: Le nom ne peut pas être vide.");
        }else{
            this.nom = nom;
        }

        if(mode == null){
            System.out.println("Subscriber: Le mode ne peut pas être null.");
        }else if(mode.length() == 0){
            System.out.println("Subscriber: Le mode ne peut pas être vide.");
        }else{
            this.mode = mode;
        }

        if(adr == null){
            System.out.println("Subscriber: L'adresse ne peut pas être null.");
        }else if(adr.length() == 0){
            System.out.println("Subscriber: L'adresse ne peut pas être vide.");
        }else{
            this.adresse = adr;
        }
    }

    /**
     * Returns the name of this subscriber.
     *
     * @return the name of the subscriber
     */
    public String getNom() {
        return nom;
    }

    /**
     * Returns the communication mode of this subscriber.
     *
     * @return the mode of communication, either "SMS" or "MAIL"
     */
    public String getMode() {
        return mode;
    }

    /**
     * Returns the address of this subscriber.
     *
     * @return the address, either phone number or email
     */
    public String getAdresse() {
        return adresse;
    }
}