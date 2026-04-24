import java.util.Scanner;

class CinemaEngine {
    static final int MAX_SIZE = 100;
    static Show[] shows = new Show[MAX_SIZE];
    static int showCount = 0;
    static User[] users = new User[10];
    static int userCount = 0;
    static Scanner input = new Scanner(System.in);
    static int idCounter = 501;

    static void seedData() {
        users[userCount++] = new Admin("admin", "admin");

        shows[showCount++] = new Show(idCounter++, "Inception", "09:00 AM");
        shows[showCount++] = new Show(idCounter++, "Inception", "03:00 PM");
        shows[showCount++] = new Show(idCounter++, "The Dark Knight", "06:00 PM");
        shows[showCount++] = new Show(idCounter++, "Interstellar", "01:00 PM");
    }

    static void performLogin(String role) {
        System.out.println("--- " + role + " Login ---");
        String user = getValidString("Username: ");
        String pass = getValidString("Password: ");

        User currentUser = null;
        for (int i = 0; i < userCount; i++) {
            if (users[i].username.equals(user) && users[i].password.equals(pass) && users[i].role.equals(role)) {
                currentUser = users[i];
                break;
            }
        }

        if (currentUser != null) {
            System.out.println("Login Successful!");
            currentUser.showMenu();
        } else {
            System.out.println("Login Failed!");
        }
    }

    static String getValidString(String str) {
        String s;
        while (true) {
            System.out.print(str);
            s = input.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Error: Input cannot be empty.");
        }
    }

    static int getValidIntRange(String prompt, int min, int max) {
        int val;
        while (true) {
            System.out.print(prompt);
            try {
                val = Integer.parseInt(input.nextLine());
                if (val >= min && val <= max) return val;
                System.out.println("Error: Range " + min + "-" + max);
            } catch (Exception e) {
                System.out.println("Error: Invalid number.");
            }
        }
    }

    static Show findShow(int id) {
        for (int i = 0; i < showCount; i++) {
            if (shows[i].id == id) return shows[i];
        }
        return null;
    }
}
