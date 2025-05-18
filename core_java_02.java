import java.util.*;
class Ticket {
    private int ticketId;
    private String passengerName;
    private String source;
    private String destination;
    private String travelDate;
    public Ticket(int ticketId, String passengerName, String source, String destination, String travelDate) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
    }
    public int getTicketId() {
        return ticketId;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public String getTravelDate() {
        return travelDate;
    }
    public void setPassengerName(String name) {
        this.passengerName = name;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String toString() {
        return "TicketID: " + ticketId +
                ", Name: " + passengerName +
                ", From: " + source +
                ", To: " + destination +
                ", Date: " + travelDate;
    }
}
class TicketManager {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    public void bookTicket(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
        System.out.println("Ticket booked successfully.");
    }
    public Ticket viewTicket(int ticketId) {
        return tickets.get(ticketId);
    }
    public void viewAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }
        for (Ticket t : tickets.values()) {
            System.out.println(t);
        }
    }
    public void updateTicket(int ticketId, String name, String source, String destination) {
        Ticket t = tickets.get(ticketId);
        if (t != null) {
            t.setPassengerName(name);
            t.setSource(source);
            t.setDestination(destination);
            System.out.println("Ticket updated.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }
    public void cancelTicket(int ticketId) {
        if (tickets.remove(ticketId) != null) {
            System.out.println("Ticket canceled.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }
}
public class core_java_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketManager manager = new TicketManager();
        while (true) {
            System.out.println("\n--- Ticketing System Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket by ID");
            System.out.println("3. View All Tickets");
            System.out.println("4. Update Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter Travel Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    Ticket ticket = new Ticket(id, name, source, dest, date);
                    manager.bookTicket(ticket);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID: ");
                    int tid = sc.nextInt();
                    Ticket t = manager.viewTicket(tid);
                    System.out.println(t != null ? t : "Ticket not found.");
                    break;
                case 3:
                    manager.viewAllTickets();
                    break;
                case 4:
                    System.out.print("Enter Ticket ID: ");
                    int upId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Source: ");
                    String newSrc = sc.nextLine();
                    System.out.print("Enter New Destination: ");
                    String newDst = sc.nextLine();
                    manager.updateTicket(upId, newName, newSrc, newDst);
                    break;
                case 5:
                    System.out.print("Enter Ticket ID: ");
                    int delId = sc.nextInt();
                    manager.cancelTicket(delId);
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
