package homework.homework19;

import com.sun.media.sound.InvalidFormatException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


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

            if (orders.get(numOrder) == null) {
                newOrder(numOrder);

                System.out.println(orders.get(numOrder).toString());
                System.out.println("");
            } else {
                if (orders.get(numOrder).status == OrderStatus.FINISHED) {
                    System.out.println("заказ закончен!");

                    System.out.println(orders.get(numOrder).toString());
                    System.out.println("");
                } else {
                    updateOrder(numOrder);

                    System.out.println(orders.get(numOrder).toString());
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

        for (Map.Entry<Integer, Order> order : orders.entrySet()) {
            writeFile(order.getValue().info() + "\n");
        }
    }


    private static void updateOrder(Integer numOrder) throws IOException {
        System.out.println("Нынешний статус заказа " + numOrder + ": " + orders.get(numOrder).getStatus());

        String status;
        OrderStatus orderStatus;

        try {
            printVariants(numOrder);
            status = reader.readLine().toUpperCase(Locale.ROOT);
            orderStatus = OrderStatus.valueOf(status);
            if (orders.get(numOrder).status.equals(OrderStatus.NEW) && (orderStatus.equals(OrderStatus.FAILED) || orderStatus.equals(OrderStatus.IN_PROGRESS) || orderStatus.equals(OrderStatus.FINISHED)) || orders.get(numOrder).status.equals(OrderStatus.IN_PROGRESS) && (orderStatus.equals(OrderStatus.FAILED) || orderStatus.equals(OrderStatus.FINISHED)) || orders.get(numOrder).status.equals(OrderStatus.FAILED) && (orderStatus.equals(OrderStatus.IN_PROGRESS) || orderStatus.equals(OrderStatus.FINISHED) || orderStatus.equals(OrderStatus.NEW))){
                orders.get(numOrder).setStatus(orderStatus);
                orders.get(numOrder).setUpdate(LocalDateTime.now());

                System.out.println("обновление пройденно успешно");
            }else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: такого статуса не существует!!");
        }

    }

    private static void printVariants(int numOrder) {
        switch (orders.get(numOrder).status) {
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

    private static void newOrder(Integer numOrder) {
        orders.put(numOrder, new Order(numOrder, OrderStatus.NEW, LocalDateTime.now()));
        System.out.println("Заказ создан");
        System.out.println();
    }

    private static void writeFile(String orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(orders);

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    private static void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();

            while (line != null) {

                String[] arrInfo = line.split(" ");

                OrderStatus orderStatus = OrderStatus.valueOf(arrInfo[1]);


                orders.put(Integer.parseInt(arrInfo[0]), new Order(Integer.parseInt(arrInfo[0]), orderStatus, LocalDateTime.parse(arrInfo[2])));

                if (arrInfo.length == 4) {

                    orders.get(Integer.parseInt(arrInfo[0])).setUpdate(LocalDateTime.parse(arrInfo[3]));
                }

                System.out.println(line);

                line = reader.readLine();
            }
            reader.close();
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
