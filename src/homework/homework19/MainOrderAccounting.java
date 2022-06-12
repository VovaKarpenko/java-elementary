package homework.homework19;


import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static homework.homework19.OrderStatus.*;


public class MainOrderAccounting {
    static Map<Integer, Order> orders = new HashMap<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String FILE_NAME = "/Users/vovakarpenko/Desktop/JAVA/orders.txt ";

    public static void main(String[] args) throws IOException {
        System.out.println("Уже существующие заказы:");
        readFile();
        removeContentInFile();
        System.out.println("");

        String endProgram = "";
        while (!endProgram.equalsIgnoreCase("exit")) {
            System.out.println("Напишите номер заказа");
            Integer numOrder = Integer.parseInt(reader.readLine());

            Order order = orders.get(numOrder);

            if (order == null) {
                Order order1 = newOrder(numOrder);
                orders.put(order1.getNumOrder(), order1);

                System.out.println(orders.get(numOrder));
                System.out.println("");
            } else {
                if (order.getStatus() == OrderStatus.FINISHED) {
                    System.out.println("заказ закончен!");

                    System.out.println(order);
                    System.out.println("");
                } else {
                    updateOrder(numOrder);

                    System.out.println(order);
                    System.out.println("");
                }
            }

            System.out.println("продолжить NEXT , закончить EXIT");
            endProgram = reader.readLine();
            try {
                if (!(endProgram.equalsIgnoreCase("next") || endProgram.equalsIgnoreCase("exit"))) {
                    throw new InvalidCommandException("ERROR: такой команды не существует!!");
                }
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            }

        }
        writeFile();
    }


    private static void updateOrder(Integer numOrder) throws IOException {

        OrderStatus status = orders.get(numOrder).getStatus();

        System.out.println("Нынешний статус заказа " + numOrder + ": " + status);
        printVariants(status);

        try {
            String writtenStatus = reader.readLine().toUpperCase(Locale.ROOT);
            OrderStatus writtenOrderStatus = OrderStatus.valueOf(writtenStatus);

            if (comparison(status, writtenOrderStatus)) {

                orders.get(numOrder).setStatus(writtenOrderStatus);
                orders.get(numOrder).setUpdate(LocalDateTime.now());

                System.out.println("обновление пройденно успешно");
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: такого статуса не существует!!");
        }

    }

    private static boolean comparison(OrderStatus orderStatus, OrderStatus writtenOrderStatus) {
        switch (orderStatus) {
            case NEW:
                return APPLICCABLE_FOR_NEW.contains(writtenOrderStatus);
            case IN_PROGRESS:
                return APPLICCABLE_FOR_IN_PROGRESS.contains(writtenOrderStatus);
            case FAILED:
                return APPLICCABLE_FOR_FAILED.contains(writtenOrderStatus);
        }
        return false;
    }

    private static void printVariants(OrderStatus status) {
        switch (status) {
            case NEW:
                System.out.println("в какой статус перевести [IN_PROGRESS , FINISHED , FAILED]: ");
                break;
            case IN_PROGRESS:
                System.out.println("в какой статус перевести [FINISHED , FAILED]: ");
                break;
            case FAILED:
                System.out.println("в какой статус перевести [IN_PROGRESS , FINISHED , NEW]: ");
                break;
        }
    }

    private static Order newOrder(Integer numOrder) {
        Order order = new Order(numOrder, OrderStatus.NEW, LocalDateTime.now());
        System.out.println("Заказ создан");
        System.out.println();
        return order;
    }

    private static void writeFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            for (Map.Entry<Integer, Order> order : orders.entrySet()) {
                writer.write(order.getValue().getOrderAsString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    private static void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));) {

            String line = reader.readLine();
            while (line != null) {

                Order order = Order.getOrderFromString(line);
                orders.put(order.getNumOrder(), order);
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeContentInFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(FILE_NAME);
        writer.print("");
        writer.close();
    }


}
