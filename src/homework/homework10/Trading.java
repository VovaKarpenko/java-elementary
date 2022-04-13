package homework.homework10;

public class Trading extends Estate {
    int earnings;

    public Trading(String nameEstate, int S, int earnings) {
        super(nameEstate, S);
        this.earnings = earnings;
    }

    public void result() {
        System.out.println(this);

    }

    @Override
    public int calculateTax() {
        super.calculateTax();
        if (earnings < 100) {
            return 0;
        }
        return S * taxK;
    }


    @Override
    public String toString() {
        return "Trading{" +
                "S=" + S +
                ", taxK=" + taxK +
                ", nameEstate='" + nameEstate + '\'' +
                ", earnings=" + earnings +
                '}';
    }
}
