import java.util.ArrayList;
import java.util.List;

/**
 * The SeatMap class is responsible for managing the state of the aircraft's seating and capacity.
 * It tracks which seats have been sold and maintains a count of passengers in classes
 * without assigned seating, such as Steerage and Coach.
 * This class enforces the seating rules defined in the project requirements.
 */
public class SeatMap {
    // A list to store the identifiers of all seats that have been purchased.
    private List<String> soldSeats;
    // A counter for the number of tickets sold for the Steerage class.
    private int steeragePassengerCount;
    // A counter for the number of tickets sold for the Coach class.
    private int coachPassengerCount;

    /**
     * Initializes a new SeatMap object.
     * It sets up an empty list for sold seats and initializes passenger counts for
     * Steerage and Coach classes to zero.
     */
    public SeatMap() {
        this.soldSeats = new ArrayList<>();
        this.steeragePassengerCount = 0;
        this.coachPassengerCount = 0;
    }

    /**
     * Increments the count of passengers in the Steerage class by one.
     */
    public void addSteeragePassenger() {
        steeragePassengerCount++;
    }

    /**
     * Increments the count of passengers in the Coach class by one.
     */
    public void addCoachPassenger() {
        coachPassengerCount++;
    }

    /**
     * Retrieves the current number of tickets sold for the Steerage class.
     *
     * @return The total number of Steerage passengers.
     */
    public int getSteeragePassengerCount() {
        return steeragePassengerCount;
    }

    /**
     * Retrieves the current number of tickets sold for the Coach class.
     *
     * @return The total number of Coach passengers.
     */
    public int getCoachPassengerCount() {
        return coachPassengerCount;
    }

    /**
     * Records a seat as being sold by adding its identifier to the list of sold seats.
     *
     * @param seatIdentifier The alphanumeric code for the seat (e.g., "A1", "F").
     */
    public void sellSeat(String seatIdentifier) {
        soldSeats.add(seatIdentifier.toUpperCase());
    }

    /**
     * Checks whether a specific seat has already been sold.
     *
     * @param seatIdentifier The alphanumeric code for the seat.
     * @return true if the seat is in the sold list, false otherwise.
     */
    public boolean isSeatSold(String seatIdentifier) {
        return soldSeats.contains(seatIdentifier.toUpperCase());
    }

    /**
     * Validates if a given seat identifier is valid for the Business class.
     * As per requirements, Business class is restricted to middle seats (columns 'B' or 'E') in rows 1 through 7.
     *
     * @param seatIdentifier The alphanumeric seat code to validate.
     * @return true if the seat is a valid Business class seat, false otherwise.
     */
    public boolean isValidBusinessSeat(String seatIdentifier) {
        String upperCaseSeat = seatIdentifier.toUpperCase();
        if (upperCaseSeat.length() != 2) return false;
        char column = upperCaseSeat.charAt(0);
        char row = upperCaseSeat.charAt(1);
        // Check if the column is 'B' or 'E' and the row is between '1' and '7'.
        return (column == 'B' || column == 'E') && (row >= '1' && row <= '7');
    }

    /**
     * Validates if a given seat identifier is valid for the Premium class.
     * As per requirements, Premium class passengers must choose an Aisle (C, D) or Window (A, F) seat.
     *
     * @param seatIdentifier The alphanumeric seat code to validate.
     * @return true if the seat is a valid Premium class seat, false otherwise.
     */
    public boolean isValidPremiumSeat(String seatIdentifier) {
        String upperCaseSeat = seatIdentifier.toUpperCase();
        if (upperCaseSeat.length() != 2) return false;
        char column = upperCaseSeat.charAt(0);
        char row = upperCaseSeat.charAt(1);
        // Check if the column is a window ('A', 'F') or an aisle ('C', 'D') and the row is between '1' and '7'.
        return (column == 'A' || column == 'F' || column == 'C' || column == 'D') && (row >= '1' && row <= '7');
    }

    /**
     * Displays a visual representation of the aircraft's current seating arrangement as specified in the requirements.
     * It marks available seats with their identifiers and sold seats with placeholders.
     * It also shows the current capacity status for the standing-room classes.
     */
    public void displaySeatMap() {
        System.out.println(" -----------------------**-----------");
        System.out.println(" / | " + getStandardSeatDisplay("F1") + " " + getStandardSeatDisplay("F2") + " " + getStandardSeatDisplay("F3") + " " + getStandardSeatDisplay("F4") + " " + getStandardSeatDisplay("F5") + " " + getStandardSeatDisplay("F6") + " " + getStandardSeatDisplay("F7"));
        System.out.println("/  | " + getStandardSeatDisplay("E1") + " " + getStandardSeatDisplay("E2") + " " + getStandardSeatDisplay("E3") + " " + getStandardSeatDisplay("E4") + " " + getStandardSeatDisplay("E5") + " " + getStandardSeatDisplay("E6") + " " + getStandardSeatDisplay("E7"));
        System.out.println(getSpecialSeatDisplay("F") + "| " + getStandardSeatDisplay("D1") + " " + getStandardSeatDisplay("D2") + " " + getStandardSeatDisplay("D3") + " " + getStandardSeatDisplay("D4") + " " + getStandardSeatDisplay("D5") + " " + getStandardSeatDisplay("D6") + " " + getStandardSeatDisplay("D7"));
        System.out.println(getSpecialSeatDisplay("C") + "| " + getStandardSeatDisplay("C1") + " " + getStandardSeatDisplay("C2") + " " + getStandardSeatDisplay("C3") + " " + getStandardSeatDisplay("C4") + " " + getStandardSeatDisplay("C5") + " " + getStandardSeatDisplay("C6") + " " + getStandardSeatDisplay("C7"));
        System.out.println("\\  | " + getStandardSeatDisplay("B1") + " " + getStandardSeatDisplay("B2") + " " + getStandardSeatDisplay("B3") + " " + getStandardSeatDisplay("B4") + " " + getStandardSeatDisplay("B5") + " " + getStandardSeatDisplay("B6") + " " + getStandardSeatDisplay("B7"));
        System.out.println(" \\ | " + getStandardSeatDisplay("A1") + " " + getStandardSeatDisplay("A2") + " " + getStandardSeatDisplay("A3") + " " + getStandardSeatDisplay("A4") + " " + getStandardSeatDisplay("A5") + " " + getStandardSeatDisplay("A6") + " " + getStandardSeatDisplay("A7"));
        System.out.println(" -----------------------**-----------");
        System.out.println();
        System.out.println("Steerage Tickets Sold: " + steeragePassengerCount + " / 493");
        System.out.println("Coach Tickets Sold: " + coachPassengerCount + " / 200");
    }

    /**
     * Generates the display string for a standard cabin seat (e.g., "A1", "B2").
     *
     * @param seatIdentifier The seat code to check.
     * @return "[XX]" if the seat is sold, or "[seatIdentifier]" (e.g., "[A1]") if available.
     */
    private String getStandardSeatDisplay(String seatIdentifier) {
        return isSeatSold(seatIdentifier) ? "[XX]" : "[" + seatIdentifier + "]";
    }

    /**
     * Generates the display string for a special single-letter seat (e.g., "F" for First Class).
     *
     * @param seatIdentifier The seat code to check.
     * @return "[X]" if the seat is sold, or "[seatIdentifier]" (e.g., "[F]") if available.
     */
    private String getSpecialSeatDisplay(String seatIdentifier) {
        return isSeatSold(seatIdentifier) ? "[X]" : "[" + seatIdentifier + "]";
    }
}
