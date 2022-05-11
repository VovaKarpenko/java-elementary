package homework.homework13;

public class Product {
    String name;
    int amount;
    int weight;
    int price;

    public String getName() {
        return name;
    }

    public Product(String name, int amount, int weight, int price) {
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        this.price = price;

        System.out.println("");
        System.out.println("Продукт "+ name + " создан");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }


}
