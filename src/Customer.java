
class Customer extends User {
    Customer() { super("Guest", "", "Customer"); }
    @Override
    void showMenu() {
        while (true) {
            System.out.println("\n[ CUSTOMER MENU ]");
            System.out.println("1. Browse Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Return");

            int choice = CinemaEngine.getValidIntRange(" Select Choice: ", 1, 3);
            if (choice == 3) break;

            if (choice == 1) {
                for (int i = 0; i < CinemaEngine.showCount; i++)
                    System.out.println("ID: " + CinemaEngine.shows[i].id + " | " + CinemaEngine.shows[i].name + " (" + CinemaEngine.shows[i].time + ")");
            } else if (choice == 2) {
                for (int i = 0; i < CinemaEngine.showCount; i++)
                    System.out.println("ID: " + CinemaEngine.shows[i].id + " | " + CinemaEngine.shows[i].name + " (" + CinemaEngine.shows[i].time + ")");
                String name = CinemaEngine.getValidString("Your Name: ");
                int id = CinemaEngine.getValidIntRange("Enter Show ID: ", 501, 600);
                Show s = CinemaEngine.findShow(id);
                if (s != null) {
                    s.displayGrid();
                    int qty = CinemaEngine.getValidIntRange("How many tickets? ", 1, 10);
                    for (int i = 0; i < qty; i++) {
                        int r = CinemaEngine.getValidIntRange("Row (1-5): ", 1, 5) - 1;
                        int c = CinemaEngine.getValidIntRange("Col (1-8): ", 1, 8) - 1;
                        if (!s.seats[r][c]) {
                            s.seats[r][c] = true;
                            System.out.println("Ticket #" + (i+1) + " Reserved!");
                        } else System.out.println("Seat Taken! Skipping...");
                    }
                }
            }
        }
    }
}
