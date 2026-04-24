class Admin extends User {
    Admin(String u, String p) { super(u, p, "Admin"); }

    @Override
    void showMenu() {
        while (true) {
            System.out.println("\n--- ADMIN PANEL ---");
            System.out.println("1. Add New Movie & Time");
            System.out.println("2. Add Extra Time for Existing Movie");
            System.out.println("3. View Analytics");
            System.out.println("4. Logout");

            int choice = CinemaEngine.getValidIntRange(" Select Choice: ", 1, 4);
            if (choice == 4) break;

            switch (choice) {
                case 1:
                    String name = CinemaEngine.getValidString("Movie Name: ");
                    String time = getValidTime();
                    CinemaEngine.shows[CinemaEngine.showCount++] = new Show(CinemaEngine.idCounter++, name, time);
                    System.out.println("Movie Added.");
                    break;
                case 2:
                    System.out.println("--- Current Schedule ---");
                    for (int i = 0; i < CinemaEngine.showCount; i++)
                        System.out.println("ID: " + CinemaEngine.shows[i].id + " | " + CinemaEngine.shows[i].name);

                    int id = CinemaEngine.getValidIntRange("Enter Movie ID: ", 501, 600);
                    Show s = CinemaEngine.findShow(id);
                    if (s != null) {
                        String t = getValidTime();
                        CinemaEngine.shows[CinemaEngine.showCount++] = new Show(CinemaEngine.idCounter++, s.name, t);
                        System.out.println("Extra time added.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- BOOKING REPORT ---");
                    for (int i = 0; i < CinemaEngine.showCount; i++) {
                        Show sh = CinemaEngine.shows[i];
                        int b = 0;
                        for(boolean[] row : sh.seats) for(boolean st : row) if(st) b++;
                        System.out.println(sh.name + " [" + sh.time + "] | Booked: " + b + "/40");
                    }
                    break;
            }
        }
    }

    private String getValidTime() {
        while (true) {
            System.out.print("Time (HH:MM AM/PM): ");
            String t = CinemaEngine.input.nextLine();
            if (t.matches("(0[1-9]|1[0-2]):[0-5][0-9] (AM|PM)")) return t;
            System.out.println("Format Error! Use 08:30 PM");
        }
    }
}

