class Show {
    int id; String name, time;
    boolean[][] seats = new boolean[5][8];
    Show(int id, String name, String time) { this.id = id; this.name = name; this.time = time; }

    void displayGrid() {
        System.out.println("\n--- Seating Chart: " + name + " (" + time + ") ---");
        System.out.println("      1  2  3  4  5  6  7  8");
        for (int r = 0; r < 5; r++) {
            System.out.print("R" + (r + 1) + "  ");
            for (int c = 0; c < 8; c++) System.out.print(seats[r][c] ? "[X]" : "[ ]");
            System.out.println();
        }
    }
}