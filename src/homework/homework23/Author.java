package homework.homework23;



public class Author {
    public final String name;
    public final String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

   public String convertToString() {
        return name + " " + surname + "\n";
    }

    @Override
    public String toString() {
        return  " Имя: " + name + "\n" + " Фамилия: " + surname;
    }
    public static Author convertToAuthor(String line){
        String[] infoGenre = line.split(" ");
        return new Author(infoGenre[0],infoGenre[1]);

    }
}
