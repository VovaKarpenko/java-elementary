package homework;

import java.util.Arrays;

public class CommandLineArguments {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);
        switch (args[1]) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
        }
    }
}
