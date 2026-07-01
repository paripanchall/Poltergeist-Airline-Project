/**
 * The Main class serves as the primary entry point for the Poltergeist Airways Ticketing System.
 * Its responsibility is to initialize and launch the application.
 */
public class Main {

    /**
     * The main method that is executed when the program starts.
     * It creates a new instance of the TicketingSystem and calls its start method
     * to begin the user interaction loop.
     *
     * @param commandLineArgs An array of strings representing command-line arguments.
     *                        This parameter is not used in this application.
     */
    public static void main(String[] commandLineArgs) {
        // Create a new instance of the main ticketing system.
        TicketingSystem ticketingApplication = new TicketingSystem();
        
        // Start the ticketing application, which will display the main menu and handle user input.
        ticketingApplication.start();
    }
}
