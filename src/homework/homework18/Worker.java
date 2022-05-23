package homework.homework18;



public class Worker {
    String name;
    String surname;
    int salary;
    EmployeeType position;

    public Worker(String name, String surname, int salary, EmployeeType position) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
