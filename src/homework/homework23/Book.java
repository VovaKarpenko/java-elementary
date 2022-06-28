package homework.homework23;

import java.time.LocalDateTime;

public class Book implements Writeble{
    String title;
    String description;
    LocalDateTime releaseDate;
    Genre genre;
    Author author;

    public Book(String title, String description, LocalDateTime releaseDate, Genre genre, Author author) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Название: " + title + "\n" + "Описание: " + description + "\n" + "Дата релиза: " + releaseDate + "\n" + "\n" + "Жанр: " + genre + "\n" + "Автор: " + author +"\n";
    }

    public String convertToString() {
        return   title + " " + description + " " + releaseDate + " " + genre.title + " " + genre.description + " " + author.name + " " + author.surname +"\n" ;
    }

    public static Book convertToBook(String line) {
        String[] infoBook = line.split(" ");
        return new Book(infoBook[0], infoBook[1], LocalDateTime.parse(infoBook[2]), new Genre(infoBook[3], infoBook[4]), new Author(infoBook[5], infoBook[6]));

    }

}
