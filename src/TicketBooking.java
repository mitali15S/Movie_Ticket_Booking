import java.util.Scanner;

class TicketBooking {
    public static void main(String[] args) {
        CinemaEngine.seedData();

        while (true) {
            System.out.println("=============================");
            System.out.println("    Welcome To LuxeCinema    ");
            System.out.println("=============================");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");

            int choice = CinemaEngine.getValidIntRange(" Enter Choice : ", 1, 3);

            switch (choice) {
                case 1: CinemaEngine.performLogin("Admin"); break;
                case 2: new Customer().showMenu(); break;
                case 3:
                    System.out.println("Thank you for visiting LuxeCinema");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}




