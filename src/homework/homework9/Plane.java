package homework.homework9;

public class Plane extends Transport {
    private int age;

    public Plane(String name, int age, int weight) {
        super(weight, name);
        this.age = age;
    }


    private void soundPlane() {
        System.out.println("oooooooo");
    }

    public void information() {
        System.out.println("Plane");
        System.out.println("name " + name);
        System.out.println("вес " + weight);
        System.out.println("age " + age);
        System.out.print("Plane sound ");
        soundPlane();

    }
}
