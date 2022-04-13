package homework.homework10;

public class Living extends Estate {
    int subsidiesPercent;

    public Living(String nameEstate, int S, int subsidiesPercent) {
        super(nameEstate, S);
        this.subsidiesPercent = subsidiesPercent;
    }

    public void result() {
        System.out.println(this);

    }

    @Override
    public int calculateTax() {
        super.calculateTax();
        int percent = S * taxK * subsidiesPercent / 100;
        return S * taxK - percent;
    }

    @Override
    public String toString() {
        return "Living{" +
                "S=" + S +
                ", taxK=" + taxK +
                ", nameEstate='" + nameEstate + '\'' +
                ", subsidiesPercent=" + subsidiesPercent +
                '}';
    }
}
