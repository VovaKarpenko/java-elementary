package homework.homework11;

public class Kelvins implements Converter{
    @Override
    public double convert(double temperature , String from) {
        if (from.equals("цельсий")){
            return temperature + 273.15d;
        }
        if (from.equals("фаренгейт")){
            return (temperature - 32) * 5 / 9 + 273.15d;
        }
        return 0;
    }
}
