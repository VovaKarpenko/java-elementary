package homework.homework23;

public class Genre {
     final String title;
     final String description;

    public Genre(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return   " Название: " + title + "\n" + " Описание: " + description +"\n";
    }

    public  String convertToString() {
        return title + " " + description + "\n";
    }
    public static Genre convertToGenre(String line){
      String[] infoGenre = line.split(" ");
      return new Genre(infoGenre[0],infoGenre[1]);
    }

}
