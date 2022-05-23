package homework.homework18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MainWorkers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Worker> comparator = new SalaryComparator();
        TreeSet<Worker> employees = new TreeSet<>(comparator.reversed());

        System.out.println("Команды: 1.new 2.exit");
        String action = reader.readLine();

        while (action.equalsIgnoreCase("new")) {

            System.out.print("Введите имя: ");
            String name = reader.readLine();

            System.out.print("Введите фамилию: ");
            String surname = reader.readLine();

            System.out.print("Введите зарплату: ");
            int salary = Integer.parseInt(reader.readLine());

            System.out.println(Arrays.toString(EmployeeType.values()));
            System.out.print("Выберите должность: ");
            String position = reader.readLine().toUpperCase(Locale.ROOT);
            EmployeeType employeeType = EmployeeType.valueOf(position);

            employees.add(new Worker(name, surname, salary, employeeType));

            System.out.println("Команды: 1.new 2.exit");
            action = reader.readLine();
            System.out.println("");
            if ((!action.equalsIgnoreCase("new")) && (!action.equalsIgnoreCase("exit"))) {
                System.out.println("Такой команды нет!");
                throw new IOException();
            }
        }
        System.out.println(employees);
    }
}
