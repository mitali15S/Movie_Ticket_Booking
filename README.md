🎬 LuxeCinema Ticket Booking System
A robust, console-based Java application for managing movie schedules and seat reservations. This system uses a role-based architecture (Admin & Customer) with strict input validation to ensure a crash-free user experience.

🚀 Key Features
👤 User Roles
Admin: Can add new movies, create multiple showtimes for existing movies, and view real-time booking analytics.

Customer: Can browse available shows, view visual seating charts, and book multiple tickets in a single transaction.

🛠️ System Logic
Strict Array Management: Built entirely using standard Java arrays (no ArrayList) to demonstrate core memory management and fixed-size data handling.

Dynamic Scheduling: Supports adding extra screen times for the same movie (e.g., Inception at 9 AM and 3 PM) with independent seating grids.

Visual Seating Grid: Displays a 5x8 coordinate system where [ ] represents available seats and [X] represents booked ones.

🛡️ Input Validation
Data Integrity: Prevents crashes from non-integer inputs using try-catch blocks.

Range Enforcement: Ensures all selections (Menu, Rows, Columns) stay within valid bounds.

Format Checking: Uses Regular Expressions (Regex) to force a strict HH:MM AM/PM time format for movie scheduling.

Default Admin Credentials:

Username: admin

Password: admin

📊 Technical Constraints
Max Movies: 100

Theater Capacity: 40 Seats (5 Rows x 8 Columns)

Storage: Volatile (Data resets when the program is closed)

📝 OOP Concepts Used
Inheritance: Admin and Customer extend the base User class.

Polymorphism: Method overriding for showMenu().

Encapsulation: Data hiding within the Show and User objects.
