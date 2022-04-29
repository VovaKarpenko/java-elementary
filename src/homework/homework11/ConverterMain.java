package homework.homework11;

import java.util.Scanner;

public class ConverterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. из какой системы (цельсий , кельвин , фаренгейт) : ");
        String fromSystem = scanner.nextLine();

        System.out.print("2. градусы : ");
        double degree = scanner.nextDouble();

        System.out.print("3. в какую систему : ");
        String inSystem = scanner.nextLine();
        inSystem = scanner.nextLine();


        System.out.println(convert(fromSystem, degree, temp(inSystem)));
    }

    public static double convert(String from, double temperature, Converter in) {
        return in.convert(temperature, from);
    }


    public static Converter temp(String name) {
        switch (name) {
            case "цельсий":
                return new Celsius();
            case "кельвин":
                return new Kelvins();
            case "фаренгейт":
                return new Fahrenheytes();
        }
        return null;
    }
}
