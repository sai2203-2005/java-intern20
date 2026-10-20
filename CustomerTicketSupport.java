import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ticket {
    private int ticketId;
    private String customerName;
    private String issue;

    public Ticket(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
    }

    public int getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId
                + " | Customer: " + customerName
                + " | Issue: " + issue;
    }
}

public class CustomerTicketSupport {

    private static Queue<Ticket> ticketQueue = new LinkedList<>();
    private static int nextTicketId = 101;

    // Add a new customer ticket
    public static void raiseTicket(
            String customerName, String issue) {

        Ticket ticket = new Ticket(
                nextTicketId++, customerName, issue);

        ticketQueue.offer(ticket);

        System.out.println("Ticket created successfully!");
        System.out.println(ticket);
    }

    // Process the oldest ticket
    public static void processTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
            return;
        }

        Ticket ticket = ticketQueue.poll();

        System.out.println("Processing ticket:");
        System.out.println(ticket);
        System.out.println("Ticket resolved successfully.");
    }

    // Display all pending tickets
    public static void displayTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }

        System.out.println("\nPending tickets (FIFO):");

        for (Ticket ticket : ticketQueue) {
            System.out.println(ticket);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== CUSTOMER TICKET SUPPORT ===");
            System.out.println("1. Raise a ticket");
            System.out.println("2. Process next ticket");
            System.out.println("3. View pending tickets");
            System.out.println("4. View next ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Describe your issue: ");
                    String issue = sc.nextLine();

                    if (name.isBlank() || issue.isBlank()) {
                        System.out.println(
                                "Name and issue cannot be empty.");
                        break;
                    }

                    raiseTicket(name, issue);
                    break;

                case 2:
                    processTicket();
                    break;

                case 3:
                    displayTickets();
                    break;

                case 4:
                    Ticket next = ticketQueue.peek();

                    if (next == null) {
                        System.out.println("No pending tickets.");
                    } else {
                        System.out.println("Next ticket:");
                        System.out.println(next);
                    }
                    break;

                case 5:
                    System.out.println("Exiting support system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
