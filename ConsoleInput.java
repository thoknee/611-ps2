import java.util.Scanner;

public class ConsoleInput implements Input{
    private final Scanner sc;

    public ConsoleInput(Scanner sc) { 
        this.sc = sc; 
    }

    public String isLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Please enter a non-empty value.");
        }
    }

    public int isInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();       // avoids nextInt newline issues
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("It must be an integer."); }
        }
    }

    public int intInRange(String prompt, int lo, int hi) {
        while (true) {
            int v = isInt(prompt);
            if (v >= lo && v <= hi) return v;
            System.out.println("Please enter a value between " + lo + " and " + hi + ".");
        }
    }

    public int intAtLeast(String prompt, int lo) {
        while (true) {
            int v = isInt(prompt);
            if (v >= lo) return v;
            System.out.println("Please enter a value >= " + lo + ".");
        }
    }
}
