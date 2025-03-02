class TicketBookingSystem {
    private int availableSeats = 5; 
    public synchronized void bookTicket(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println(name + " tried to book " + seats + " seat(s), but only " + availableSeats + " are available.");
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String customerName;
    private int seats;

    public BookingThread(TicketBookingSystem system, String customerName, int seats, int priority) {
        this.system = system;
        this.customerName = customerName;
        this.seats = seats;
        setPriority(priority); 
    }

    public void run() {
        system.bookTicket(customerName, seats);
    }
}

public class Exp4Hard {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        BookingThread vip1 = new BookingThread(system, "VIP1", 2, Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP2", 1, Thread.MAX_PRIORITY);
        BookingThread user1 = new BookingThread(system, "User1", 2, Thread.NORM_PRIORITY);
        BookingThread user2 = new BookingThread(system, "User2", 1, Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        user1.start();
        user2.start();
    }
}
