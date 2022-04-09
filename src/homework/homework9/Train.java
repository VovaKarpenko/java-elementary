package homework.homework9;

public class Train extends Transport {
    private int speed;


    public Train(String name, int weight, int speed) {
        super(weight, name);
        this.speed = speed;
    }

    private void soundTrain() {
        System.out.println("tendentendentend");
    }

    public void information() {
        System.out.println("Train");
        System.out.println("name " + name);
        System.out.println("вес " + weight);
        System.out.println("speed " + speed);
        System.out.print("Train sound: ");
        soundTrain();
    }
}
