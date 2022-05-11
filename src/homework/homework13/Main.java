package homework.homework13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Действия: add , remove , exit");
        String action = scanner.nextLine();
        System.out.println("");

        while (!action.equals("exit")) {

            if (action.equals("add")) {
                addProduct(products);
            }


            if (action.equals("remove")) {
                removeProduct(products);
            }


            System.out.println("Действия: add , remove , exit");
            action = scanner.nextLine();
            action = scanner.nextLine();
            System.out.println("");
        }
        System.out.println(products);
    }

    public static ArrayList addProduct(ArrayList products) {


        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество продукта: ");
        int amount = scanner.nextInt();
        System.out.print("Введите вес продукта: ");
        int weight = scanner.nextInt();
        System.out.print("Введите цену продукта: ");
        int price = scanner.nextInt();

        products.add(new Product(name, amount, weight, price));

        return products;
    }

    public static ArrayList removeProduct(ArrayList products) {
        System.out.print("Ввдите название продукта который хотите удалить: ");
        String name = scanner.nextLine();
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getName().equals(name)) {
                productIterator.remove();
            }
        }

        System.out.println("");
        System.out.println("Продукт "+ name + " удален");
        System.out.println("");

        return products;
    }

}

