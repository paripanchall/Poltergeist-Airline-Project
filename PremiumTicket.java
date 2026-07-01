/**
 * The PremiumTicket class represents a ticket for the Premium passenger class.
 * This class extends the abstract Ticket class and provides concrete implementations
 * for the base price and passenger class name specific to Premium class.
 */
public class PremiumTicket extends Ticket {

    /**
     * Constructs a new PremiumTicket object.
     *
     * @param seatNumber The specific seat identifier assigned to this ticket (e.g., "A1", "F7").
     *                   Premium class offers a range of seats across rows 1-7.
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add, such as selecting a middle seat.
     */
    public PremiumTicket(String seatNumber, int addonCount) {
        // Call the constructor of the parent Ticket class to initialize the common ticket properties.
        super(seatNumber, addonCount);
    }

    /**
     * Returns the fixed base price for a Premium class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 30.
     */
    @Override
    public int getBasePrice() {
        // The base price for all Premium class tickets is set to 30.
        return 30;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "Premium", which is the designated name for this class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "Premium";
    }
}
