package homework.homework11;

public class Celsius implements Converter {
    @Override
    public double convert(double temperature, String from) {
        if (from.equals("фаренгейт")) {
            return (temperature - 32) * 5 / 9;
        }
        if (from.equals("кельвин")) {
            return temperature - 273.15d;
        }
        return 0;
    }
}
