package homework.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        List<Estate> estates = new ArrayList<>();

        System.out.print("создать = create | показать результат = result : ");
        String input = SCANNER.nextLine();

        while ("create".equals(input)) {
            Estate estate = createEstate();
            if (estate != null) {
                estates.add(estate);
            }
            System.out.print("создать еще = create | показать результат = result : ");
            input = SCANNER.nextLine();
            input = SCANNER.nextLine();
        }

        if ("result".equals(input)) {
            for (Estate estate : estates) {
                estate.result();
            }

            System.out.println("");

            System.out.print("показать налог на недвижимость [y/n]: ");
            if (SCANNER.nextLine().equals("y")) {
                for (Estate estate : estates) {
                    System.out.println(estate.getNameEstate() + ": " + estate.calculateTax());
                }
            }
        }



    }

    public static Estate createEstate() {

        System.out.println("");
        System.out.print("какую недвижимость вы хотите выбрать [living , production , trading]: ");

        String estate = SCANNER.nextLine();

        switch (estate) {
            case "living":

                System.out.println("");
                System.out.print("[субсидии больщая семья = bigFamily | пенсионеры = pensioners | если нет = skip]: ");

                String subsidies = null;
                int percent = 0;
                while (!("bigFamily".equals(subsidies) || "pensioners".equals(subsidies) || "skip".equals(subsidies))) {

                    subsidies = SCANNER.nextLine();
                    if ("bigFamily".equals(subsidies)) {
                        percent = 15;
                    } else if ("pensioners".equals(subsidies)) {
                        percent = 10;
                    } else if ("skip".equals(subsidies)) {
                        percent = 0;
                    } else {
                        System.out.println("команда не распознана попробуйте еще раз");
                        System.out.println("субсидии больщая семья = bigFamily | пенсионеры = pensioners | если нет = skip");

                    }
                }

                System.out.print("название недвижимости: ");
                String nameLiving = SCANNER.nextLine();
                System.out.print("площадь в метрах квадратных: ");
                int SLiving = SCANNER.nextInt();
                System.out.print("недвижемость создана!");

                System.out.println("");

                return new Living(nameLiving, SLiving, percent);
            case "production":

                System.out.print("название недвижимости: ");
                String nameProduction = SCANNER.nextLine();
                System.out.print("площадь в метрах квадратных: ");
                int SProduction = SCANNER.nextInt();
                System.out.println("недвижемость создана!");

                System.out.println("");

                return new Production(nameProduction, SProduction);
            case "trading":

                System.out.print("название недвижимости: ");
                String nameTrading = SCANNER.nextLine();
                System.out.print("площадь в метрах квадратных: ");
                int STrading = SCANNER.nextInt();
                System.out.println("заработок в день: ");
                int earnings = SCANNER.nextInt();
                System.out.println("недвижемость создана!");

                System.out.println("");

                return new Trading(nameTrading, STrading, earnings);
        }
        return null;
    }
}
