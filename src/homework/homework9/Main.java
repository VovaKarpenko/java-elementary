package homework.homework9;

public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane("a", 4, 300);
        Train train = new Train("b", 1000, 500);
        plane.information();
        train.information();

    }
}
