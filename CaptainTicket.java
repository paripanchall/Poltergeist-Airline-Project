/**
 * The CaptainTicket class represents a ticket for the exclusive Captain passenger class.
 * This class extends the abstract Ticket class and provides specific details for the
 * Captain's seat, including its fixed base price and unique seat identifier.
 */
public class CaptainTicket extends Ticket {

    /**
     * Constructs a new CaptainTicket object.
     * The Captain class has a predetermined, single seat designated as "C".
     *
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add, such as in-flight entertainment access.
     */
    public CaptainTicket(int addonCount) {
        // Call the constructor of the parent Ticket class, passing "C" as the fixed seat identifier.
        super("C", addonCount);
    }

    /**
     * Returns the fixed base price for a Captain class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 70.
     */
    @Override
    public int getBasePrice() {
        // The base price for the Captain class ticket is set to 70.
        return 70;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "Captain", which is the designated name for this exclusive class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "Captain";
    }
}
