package homework.homework10;

public class Estate {
    int S;
    int taxK = 1000;
    String nameEstate;

    public Estate(String nameEstate , int S) {
        this.nameEstate = nameEstate;
        this.S = S;
    }

    public String getNameEstate() {
        return nameEstate;
    }

    public int calculateTax (){
        return S*taxK;
    }

    public void result() {
        System.out.println(this);

    }
    @Override
    public String toString() {
        return "Estate{" +
                "S=" + S +
                ", taxK=" + taxK +
                ", nameEstate='" + nameEstate + '\'' +
                '}';
    }
}
