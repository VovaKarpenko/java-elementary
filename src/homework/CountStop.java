package homework;

import java.util.Scanner;

public class CountStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        int count = 0;
        int result = 0;

        while (!(text.equalsIgnoreCase("stop"))) {
            result += count;
            text = scanner.nextLine();
            try {
                count = Integer.parseInt(text);
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.println(result);
    }
}
