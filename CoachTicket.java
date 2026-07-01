/**
 * The CoachTicket class represents a ticket for the Coach passenger class.
 * This class extends the abstract Ticket class and provides specific details for
 * Coach tickets, such as their base price and the fact that they do not have
 * pre-assigned seats.
 */
public class CoachTicket extends Ticket {

    /**
     * Constructs a new CoachTicket object.
     * Coach class tickets are for general seating and do not have a specific seat number.
     *
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add, such as a carry-on bag.
     */
    public CoachTicket(int addonCount) {
        // Call the parent constructor with a null seat number, as seats are not assigned for this class.
        super(null, addonCount);
    }

    /**
     * Returns the fixed base price for a Coach class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 10.
     */
    @Override
    public int getBasePrice() {
        // The base price for all Coach class tickets is set to 10.
        return 10;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "Coach", which is the designated name for this class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "Coach";
    }
}
