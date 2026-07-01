import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The TicketingSystem class serves as the core of the application, handling user interactions,
 * managing the ticket purchasing workflow, and maintaining a record of all transactions,
 * as specified in the application requirements.
 */
public class TicketingSystem {
    public static final int MAX_COACH_SEATS = 200;
    public static final int MAX_STEERAGE_SEATS = 493;
    // A list to store all tickets that have been successfully purchased, fulfilling requirement 2.2.
    private List<Ticket> ticketPurchaseLog;
    // The SeatMap object that manages the state of the aircraft's seating.
    private SeatMap aircraftSeatMap;
    // A Scanner object to read input from the user via the console.
    private Scanner userInputScanner;

    /**
     * Initializes a new TicketingSystem. It creates a new list for purchased tickets,
     * instantiates the seat map, and sets up a scanner for standard input.
     */
    public TicketingSystem() {
        this.ticketPurchaseLog = new ArrayList<>();
        this.aircraftSeatMap = new SeatMap();
        this.userInputScanner = new Scanner(System.in);
    }

    /**
     * Starts the main interactive loop for the ticketing application.
     * This method displays the main menu and processes user choices until the user decides to exit,
     * fulfilling requirement 5.
     */
    public void start() {
        boolean isSystemExiting = false;
        while (!isSystemExiting) {
            System.out.println("*******************************************");
            System.out.println("*     Poltergeist Airways Main Menu     *");
            System.out.println("*******************************************");
            System.out.println("*                                         *");
            System.out.println("*   1. Add a new ticket                   *");
            System.out.println("*   2. Display current seat map           *");
            System.out.println("*   3. Exit                               *");
            System.out.println("*                                         *");
            System.out.println("*******************************************");
            System.out.print("Enter your choice: ");

            String menuSelection = userInputScanner.nextLine();

            switch (menuSelection) {
                case "1":
                    processNewTicketPurchase();
                    break;
                case "2":
                    aircraftSeatMap.displaySeatMap();
                    break;
                case "3":
                    System.out.println("Thank you for choosing Poltergeist Airways. Good luck!");
                    isSystemExiting = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    /**
     * Manages the process of creating and purchasing a new ticket. It prompts the user
     * to select a passenger class, delegates to the appropriate handler for that class,
     * and if successful, adds the new ticket to the purchase log.
     */
    private void processNewTicketPurchase() {
        System.out.println("\nSelect Passenger Class:");
        System.out.println("1. Steerage ($5)");
        System.out.println("2. Coach ($10)");
        System.out.println("3. Business ($20)");
        System.out.println("4. Premium ($30)");
        System.out.println("5. First ($50)");
        System.out.println("6. Captain ($70)");
        System.out.print("Enter class choice: ");

        String passengerClassSelection = userInputScanner.nextLine();
        Ticket newlyCreatedTicket = null;

        switch (passengerClassSelection) {
            case "1":
                newlyCreatedTicket = createSteerageTicket();
                break;
            case "2":
                newlyCreatedTicket = createCoachTicket();
                break;
            case "3":
                newlyCreatedTicket = createBusinessTicket();
                break;
            case "4":
                newlyCreatedTicket = createPremiumTicket();
                break;
            case "5":
                newlyCreatedTicket = createFirstClassTicket();
                break;
            case "6":
                newlyCreatedTicket = createCaptainTicket();
                break;
            default:
                System.out.println("Invalid class choice. Returning to main menu.");
                return;
        }

        if (newlyCreatedTicket != null) {
            ticketPurchaseLog.add(newlyCreatedTicket);
            System.out.println("\nTicket successfully purchased!");
            newlyCreatedTicket.printTicketDetails();
        }
    }

    /**
     * Handles the specific logic for creating a Steerage class ticket.
     * It checks for capacity and creates a ticket if space is available.
     *
     * @return A new SteerageTicket, or null if the class is full.
     */
    private Ticket createSteerageTicket() {
        if (aircraftSeatMap.getSteeragePassengerCount() >= MAX_STEERAGE_SEATS) {
            System.out.println("Steerage class is full.");
            return null;
        }
        int addonCount = promptForYesNoOption("Would you like to hold your carry-on bag instead of standing on it for an additional fee?");
        aircraftSeatMap.addSteeragePassenger();
        return new SteerageTicket(addonCount);
    }

    /**
     * Handles the specific logic for creating a Coach class ticket.
     * It checks for capacity and creates a ticket if space is available.
     *
     * @return A new CoachTicket, or null if the class is full.
     */
    private Ticket createCoachTicket() {
        if (aircraftSeatMap.getCoachPassengerCount() >= MAX_COACH_SEATS) {
            System.out.println("Coach class is full.");
            return null;
        }
        int addonCount = promptForYesNoOption("Would you like to bring 1 carry-on bag for an additional fee?");
        aircraftSeatMap.addCoachPassenger();
        return new CoachTicket(addonCount);
    }

    /**
     * Handles the specific logic for creating a Business class ticket.
     * It prompts the user to select a valid seat for this class.
     *
     * @return A new BusinessTicket, or null if the user cancels the seat selection.
     */
    private Ticket createBusinessTicket() {
        int addonCount = promptForYesNoOption("Would you like to bring a second carry-on bag for an additional fee?");
        String selectedSeat = promptForValidSeat("Business");
        if (selectedSeat == null) return null; // User cancelled
        return new BusinessTicket(selectedSeat, addonCount);
    }

    /**
     * Handles the specific logic for creating a Premium class ticket.
     * It prompts the user to select a valid seat for this class.
     *
     * @return A new PremiumTicket, or null if the user cancels the seat selection.
     */
    private Ticket createPremiumTicket() {
        int addonCount = promptForYesNoOption("Would you like to select a middle seat instead for an additional fee?");
        String selectedSeat = promptForValidSeat("Premium");
        if (selectedSeat == null) return null; // User cancelled
        return new PremiumTicket(selectedSeat, addonCount);
    }

    /**
     * Handles the specific logic for creating a First class ticket.
     * It checks if the single, exclusive First class seat is available.
     *
     * @return A new FirstTicket, or null if the seat is already sold.
     */
    private Ticket createFirstClassTicket() {
        if (aircraftSeatMap.isSeatSold("F")) {
            System.out.println("First class is already booked.");
            return null;
        }
        int addonCount = promptForYesNoOption("Would you like to use the Yoke and rudder pedals for an additional fee?");
        aircraftSeatMap.sellSeat("F");
        return new FirstTicket(addonCount);
    }

    /**
     * Handles the specific logic for creating a Captain class ticket.
     * It checks if the single, exclusive Captain's seat is available.
     *
     * @return A new CaptainTicket, or null if the seat is already sold.
     */
    private Ticket createCaptainTicket() {
        if (aircraftSeatMap.isSeatSold("C")) {
            System.out.println("Captain class is already booked.");
            return null;
        }
        int addonCount = promptForYesNoOption("Would you like in-flight access to YouTube for an additional fee?");
        aircraftSeatMap.sellSeat("C");
        return new CaptainTicket(addonCount);
    }

    /**
     * A helper method to display a yes/no question to the user and get their response.
     *
     * @param promptMessage The question to display.
     * @return 1 if the user responds with 'y' (yes), and 0 for any other response.
     */
    private int promptForYesNoOption(String promptMessage) {
        System.out.print(promptMessage + " (y/n): ");
        String userResponse = userInputScanner.nextLine().trim().toLowerCase();
        return userResponse.equals("y") ? 1 : 0;
    }

    /**
     * Prompts the user to enter a seat selection, validates it against the rules for the
     * specified passenger class, and checks for availability. It also includes the special
     * door plug disclaimer as required.
     *
     * @param ticketClassName The name of the passenger class for which a seat is being selected (e.g., "Business").
     * @return A string with the valid seat identifier, or null if the user chooses to 'exit'.
     */
    private String promptForValidSeat(String ticketClassName) {
        while (true) {
            aircraftSeatMap.displaySeatMap();
            System.out.print("Enter seat selection (or 'exit' to cancel): ");
            String seatSelection = userInputScanner.nextLine().trim().toUpperCase();

            if (seatSelection.equalsIgnoreCase("exit")) {
                return null; // User chose to cancel the operation.
            }

            // Fulfills requirement 4.1: Display a disclaimer for seats A5 and F5.
            if (seatSelection.equals("A5") || seatSelection.equals("F5")) {
                System.out.println("\n[DISCLAIMER] You have selected a seat next to a door plug on a Boeing 737 MAX 9. If the door plug blows out mid-flight, it is your fault for having bad vibes. Do you accept these risks?");
                System.out.print("(y/n): ");
                if (!userInputScanner.nextLine().trim().toLowerCase().equals("y")) {
                    System.out.println("Seat selection cancelled. Please choose another seat.");
                    continue; // Restart the loop to prompt for a new seat.
                }
            }

            // Check if the seat has already been sold.
            if (aircraftSeatMap.isSeatSold(seatSelection)) {
                System.out.println("Seat " + seatSelection + " is already purchased. Please choose another.");
                continue;
            }

            // Validate the seat against Business class rules from requirement 4.
            if (ticketClassName.equals("Business") && !aircraftSeatMap.isValidBusinessSeat(seatSelection)) {
                System.out.println("Invalid seat for Business class. You must choose a middle seat (B or E) in rows 1-7.");
                continue;
            }

            // Validate the seat against Premium class rules from requirement 4.
            if (ticketClassName.equals("Premium") && !aircraftSeatMap.isValidPremiumSeat(seatSelection)) {
                System.out.println("Invalid seat for Premium class. You must choose an Aisle (C, D) or Window (A, F) seat.");
                continue;
            }

            // If all checks pass, sell the seat and return the selection.
            aircraftSeatMap.sellSeat(seatSelection);
            return seatSelection;
        }
    }
}
