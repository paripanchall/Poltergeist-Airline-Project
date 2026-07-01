/**
 * The FirstTicket class represents a ticket for the premium First passenger class.
 * This class extends the abstract Ticket class and provides specific details for the
 * First class seat, including its fixed base price and unique seat identifier.
 */
public class FirstTicket extends Ticket {

    /**
     * Constructs a new FirstTicket object.
     * The First class has a predetermined, single seat designated as "F".
     *
     * @param addonCount The number of optional features or services the passenger has
     *                   chosen to add, such as access to flight controls.
     */
    public FirstTicket(int addonCount) {
        // Call the constructor of the parent Ticket class, passing "F" as the fixed seat identifier.
        super("F", addonCount);
    }

    /**
     * Returns the fixed base price for a First class ticket before any additional options.
     *
     * @return An integer representing the base price, which is 50.
     */
    @Override
    public int getBasePrice() {
        // The base price for the First class ticket is set to 50.
        return 50;
    }

    /**
     * Returns the name of the passenger class for this ticket.
     *
     * @return A String literal "First", which is the designated name for this premium class.
     */
    @Override
    public String getPassengerClass() {
        // This method provides the specific passenger class name.
        return "First";
    }
}
