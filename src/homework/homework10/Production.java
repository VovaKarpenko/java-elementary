package homework.homework10;

public class Production extends Estate {


    public Production(String nameEstate, int S) {
        super(nameEstate, S);

    }

    public void result() {
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "Production{" +
                "S=" + S +
                ", taxK=" + taxK +
                ", nameEstate='" + nameEstate + '\'' +
                '}';
    }
}
