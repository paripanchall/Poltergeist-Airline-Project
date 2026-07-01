/**
 * The Ticket class is an abstract base class that defines the common structure and
 * functionality for all types of passenger tickets in the airline system. It encapsulates
 * core attributes like fees, seat assignment, and price calculation.
 */
public abstract class Ticket {
    // A constant representing the mandatory fee for boarding.
    protected final int MANDATORY_BOARDING_FEE = 500;
    
    // A constant representing the mandatory fee for oxygen availability.
    protected final int MANDATORY_OXYGEN_FEE = 1000;
    
    // A constant representing the mandatory Value Added Tax (VAT).
    protected final int VALUE_ADDED_TAX = 1500;
    
    // A constant representing the cost associated with each optional add-on.
    protected final int FEE_PER_ADDON = 100;

    // The identifier for the passenger's assigned seat (e.g., "A1"). Can be null for classes without assigned seating.
    protected String assignedSeat;
    
    // The total number of optional add-ons selected by the passenger.
    protected int addonCount;

    /**
     * Constructs a new Ticket object.
     *
     * @param seatNumber   The identifier for the assigned seat. This can be null if the ticket
     *                     is for a class without pre-assigned seating (e.g., Coach).
     * @param numberOfAddons The quantity of optional services or features the passenger has purchased.
     */
    public Ticket(String seatNumber, int numberOfAddons) {
        this.assignedSeat = seatNumber;
        this.addonCount = numberOfAddons;
    }

    /**
     * An abstract method that must be implemented by subclasses to provide the base price
     * for their specific ticket class.
     *
     * @return The base price of the ticket as an integer.
     */
    public abstract int getBasePrice();

    /**
     * An abstract method that must be implemented by subclasses to provide the name
     * of their specific passenger class.
     *
     * @return A string representing the name of the passenger class (e.g., "Business", "First").
     */
    public abstract String getPassengerClass();

    /**
     * Calculates the total final price of the ticket.
     * This is determined by summing the base price, the total cost of all add-ons,
     * and all mandatory fees.
     *
     * @return The final calculated price of the ticket as an integer.
     */
    public int calculateTotalPrice() {
        int totalMandatoryFees = MANDATORY_BOARDING_FEE + MANDATORY_OXYGEN_FEE + VALUE_ADDED_TAX;
        int totalAddonCost = addonCount * FEE_PER_ADDON;
        return getBasePrice() + totalAddonCost + totalMandatoryFees;
    }

    /**
     * Prints a detailed, formatted summary of the ticket to the console.
     * The summary includes the passenger class, seat number (if applicable), a breakdown
     * of the costs (base price, add-ons, fees), and the final total price.
     */
    public void printTicketDetails() {
        System.out.println("Passenger Class: " + getPassengerClass());
        if (assignedSeat != null && !assignedSeat.isEmpty()) {
            System.out.println("Seat: " + assignedSeat);
        }
        System.out.println("Base Price: $" + getBasePrice());
        System.out.println("Add-ons Selected: " + addonCount + " ($" + (addonCount * FEE_PER_ADDON) + ")");
        System.out.println("Mandatory Fees: $" + (MANDATORY_BOARDING_FEE + MANDATORY_OXYGEN_FEE + VALUE_ADDED_TAX));
        System.out.println("Final Total: $" + calculateTotalPrice());
        System.out.println("-------------------------------------------------");
    }
}
