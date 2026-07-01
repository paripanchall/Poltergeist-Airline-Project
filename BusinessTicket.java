/**
 * The BusinessTicket class represents a ticket for the Business passenger class.
 * This class extends the abstract Ticket class and provides concrete implementations
 * for the base price and passenger class name specific to Business class.
 */
public class BusinessTicket extends Ticket {

    /**
     * Constructs a new BusinessTicket object.
     *
     * @param seatNumber The specific seat identifier assigned to this ticket (e.g., "B3").
     *                   For Business class, this is expected to be a middle seat.
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add to their ticket, such as extra baggage.
     */
    public BusinessTicket(String seatNumber, int addonCount) {
        // Call the constructor of the parent Ticket class to initialize the common ticket properties.
        super(seatNumber, addonCount);
    }

    /**
     * Returns the fixed base price for a Business class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 20.
     */
    @Override
    public int getBasePrice() {
        // The base price for all Business class tickets is set to 20.
        return 20;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "Business", which is the designated name for this class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "Business";
    }
}
