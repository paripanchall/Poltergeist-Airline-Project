/**
 * The SteerageTicket class represents a ticket for the Steerage passenger class.
 * This class extends the abstract Ticket class and provides specific details for
 * Steerage tickets, which are the most basic and do not have assigned seats.
 */
public class SteerageTicket extends Ticket {

    /**
     * Constructs a new SteerageTicket object.
     * Steerage class tickets are for standing-room only and do not have a specific seat number.
     *
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add, such as holding a carry-on bag.
     */
    public SteerageTicket(int addonCount) {
        // Call the parent constructor with a null seat number, as seats are not assigned for this class.
        super(null, addonCount);
    }

    /**
     * Returns the fixed base price for a Steerage class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 5.
     */
    @Override
    public int getBasePrice() {
        // The base price for all Steerage class tickets is set to 5.
        return 5;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "Steerage", which is the designated name for this class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "Steerage";
    }
}
