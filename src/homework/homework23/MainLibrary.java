package homework.homework23;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MainLibrary {
    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String GENRE_FILE_NAME = "/Users/vovakarpenko/Desktop/JAVA/genre.txt ";
    private static final String AUTHOR_FILE_NAME = "/Users/vovakarpenko/Desktop/JAVA/author.txt ";
    private static final String BOOK_FILE_NAME = "/Users/vovakarpenko/Desktop/JAVA/book.txt ";

    public static void main(String[] args) throws IOException {

        List<Genre> genreList = genreDataFormFileToList(GENRE_FILE_NAME);
        List<Author> authorsList = authorDataFormFileToList(AUTHOR_FILE_NAME);
        List<Book> bookList = bookDataFormFileToList(BOOK_FILE_NAME);
        removeContentInFile(GENRE_FILE_NAME);
        removeContentInFile(AUTHOR_FILE_NAME);
        removeContentInFile(BOOK_FILE_NAME);
        String task = "";

        while (!task.equalsIgnoreCase("exit")) {

            System.out.println("Действия: genre , author , book -- Выход: exit");
            task = READER.readLine();
            switch (task) {
                case "genre":
                    System.out.println("");
                    actionWithGenre(genreList);

                    break;
                case "author":
                    System.out.println("");
                    actionWithAuthor(authorsList, bookList);
                    break;
                case "book":
                    System.out.println("");
                    actionWithBook(bookList, authorsList, genreList);
                    break;
                default:
                    if (task.equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.println("Такой каманды не существует!");
                    System.out.println("");
            }
        }
        writeInFileGenre(GENRE_FILE_NAME, genreList);
        writeInFileGenre(AUTHOR_FILE_NAME, authorsList);
        writeInFileGenre(BOOK_FILE_NAME, bookList);
    }


    public static void actionWithBook(List<Book> bookList, List<Author> authorList, List<Genre> genreList) throws IOException {
        while (true) {
            switch (askAction()) {
                case "add":
                    System.out.println("");
                    System.out.print("Название книги: ");
                    String title = READER.readLine();
                    System.out.print("Описание книги: ");
                    String description = READER.readLine();
                    int indexGenre = 0;
                    int indexAuthor = 0;
                    if (genreList.size() != 0) {
                        System.out.println("1.создать новый жанр 2.добавить жанр из тех которые есть");

                        String actionGenre = READER.readLine();

                        while (!actionGenre.equalsIgnoreCase("1") && !actionGenre.equalsIgnoreCase("2")) {
                            System.out.println("Такой камандвы не существует!");
                            System.out.println("");
                            System.out.println("1.создать новый жанр 2.добавить жанр из тех которые есть");

                            actionGenre = READER.readLine();
                        }
                        if (actionGenre.equals("2")) {
                            drawGenre(genreList);
                            System.out.print("какой жанр добавить: ");
                            indexGenre = Integer.parseInt(READER.readLine()) - 1;
                        } else {
                            System.out.println("");
                            genreList.add(askGenre(READER));
                        }
                    } else {
                        System.out.println("Жанров нет! Добавление нового жанра!");
                        System.out.println("");
                        genreList.add(askGenre(READER));
                    }
                    if (authorList.size() != 0) {
                        System.out.println("1.добавить нового автора 2.добавить автора из тех которые есть");
                        String actionAuthor = READER.readLine();
                        while (!actionAuthor.equalsIgnoreCase("1") && !actionAuthor.equalsIgnoreCase("2")) {
                            System.out.println("Такой камандвы не существует!");
                            System.out.println("");
                            System.out.println("1.добавить нового автора 2.добавить автора из тех которые есть");
                            actionAuthor = READER.readLine();
                        }

                        if (actionAuthor.equals("2")) {
                            drawAuthor(authorList, bookList);
                            System.out.print("какого автора добавить: ");
                            indexAuthor = Integer.parseInt(READER.readLine()) - 1;

                        } else {
                            System.out.println("");
                            authorList.add(askAuthor(READER));
                        }
                    } else {
                        System.out.println("Авторов нет! Добавление нового автора!");
                        System.out.println("");
                        authorList.add(askAuthor(READER));
                    }
                    System.out.println("");
                    System.out.println("Добавление завершено");
                    bookList.add(new Book(title, description, LocalDateTime.now(), genreList.get(indexGenre), authorList.get(indexAuthor)));
                    System.out.println("");
                    return;

                case "view":
                    if (bookList.size() != 0) {
                        drawBook(bookList);
                        return;
                    } else {
                        System.out.println("на данный момент книг нет");
                        break;
                    }
                case "delete":
                    drawBook(bookList);
                    System.out.println("Напишите название книгу которую нужно удалить: ");
                    String bookDelete = READER.readLine();
                    bookList = bookDelete(bookList, bookDelete);
                    System.out.println("Удаление завершено!!");
                    System.out.println("");
                    return;
                default:
                    System.out.println("Такой каманды не сеществует!");
                    System.out.println("");
            }
        }
    }

    public static List<Book> bookDelete(List<Book> bookList, String bookDelete) {
        return bookList.stream()
                .filter(book -> !book.title.equalsIgnoreCase(bookDelete))
                .collect(Collectors.toList());
    }


    public static void actionWithAuthor(List<Author> authorList, List<Book> bookList) throws IOException {
        while (true) {
            switch (askAction()) {
                case "add":
                    System.out.println("");
                    authorList.add(askAuthor(READER));
                    System.out.println("Добавление завершено");
                    System.out.println("");
                    return;
                case "view":
                    if (authorList.size() != 0) {
                        drawAuthor(authorList, bookList);
                        return;
                    } else {
                        System.out.println("На данный момент авторов нет");
                        System.out.println("");
                        break;
                    }
                case "delete":
                    if (authorList.size() != 0) {
                        drawAuthor(authorList, bookList);
                        int indexGenre = -1;

                        while (!indexValid(indexGenre, authorList.size())) {
                            System.out.print("Какого автора удалить: ");
                            indexGenre = Integer.parseInt(READER.readLine()) - 1;
                            if (indexValid(indexGenre, authorList.size())) {
                                authorList.remove(indexGenre);
                                System.out.println("Удаление завершено!!");
                                return;
                            } else {
                                System.out.println("ТАКОГО ИДЕКСА НЕ СУЩЕСТВУЕТ!!!");
                            }
                        }
                        return;
                    } else {
                        System.out.println("На данный момент авторов нет");
                        System.out.println("");
                        break;
                    }
                default:
                    System.out.println("Такой каманды не сеществует!");
                    System.out.println("");
            }
        }
    }

    public static void actionWithGenre(List<Genre> genreList) throws IOException {
        while (true) {
            switch (askAction()) {
                case "add":
                    System.out.println("");
                    genreList.add(askGenre(READER));
                    System.out.println("Добавление завершено");
                    System.out.println("");
                    return;
                case "view":
                    if (genreList.size() != 0) {
                        drawGenre(genreList);
                        return;
                    } else {
                        System.out.println("На данный момент жанров нет");
                        System.out.println("");
                        break;
                    }
                case "delete":
                    if (genreList != null) {
                        System.out.println("");
                        drawGenre(genreList);

                        int indexGenre = -1;

                        while (!indexValid(indexGenre, genreList.size())) {
                            System.out.print("Какой жанр удалить: ");
                            System.out.println("");
                            indexGenre = Integer.parseInt(READER.readLine()) - 1;
                            if (indexValid(indexGenre, genreList.size())) {
                                genreList.remove(indexGenre);
                                System.out.println("Удаление завершено!!");
                                System.out.println("");
                                return;
                            } else {
                                System.out.println("ТАКОГО ИДЕКСА НЕ СУЩЕСТВУЕТ!!!");
                            }
                        }
                        return;
                    } else {
                        System.out.println("На данный момент жанров нет");
                        System.out.println("");
                        break;
                    }
                default:
                    System.out.println("Такой каманды не сеществует!");
                    System.out.println("");
            }
        }
    }


    public static Author askAuthor(BufferedReader reader) throws IOException {

        System.out.print("имя автора: ");
        String name = reader.readLine();

        System.out.print("Фамилия автора: ");
        String surname = reader.readLine();
        return new Author(name, surname);
    }

    public static Genre askGenre(BufferedReader reader) throws IOException {

        System.out.print("Назовите жанр: ");
        String title = reader.readLine();

        System.out.print("Напишите описание: ");
        String description = reader.readLine();

        System.out.println("");

        return new Genre(title, description);
    }

    public static void drawGenre(List<Genre> genreList) {


    }

    public static void drawAuthor(List<Author> authorList, List<Book> bookList) {
        int i = 0;
        for (Author a : authorList) {
            System.out.println("");
            System.out.println(++i + "" + a);
            System.out.print(" Книги: [");
            bookList.stream().filter(book -> book.author.equals(a)).forEach(book -> System.out.print(book.title + " "));
            System.out.println("]");
        }

    }

    public static void drawBook(List<Book> bookList) {
        bookList.forEach(System.out::println);
    }

    public static String askAction() throws IOException {
        System.out.println("Что сделать?: delete , add , view");
        return READER.readLine();

    }

    public static boolean indexValid(int num, int arrSize) {
        return num <= arrSize && num >= 0;
    }


    public static void writeInFileGenre(String fileName, List<? extends Writeble> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Writeble object : list) {
                writer.write(object.convertToString());
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void removeContentInFile(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();
    }

    public static List<Genre> genreDataFormFileToList(String fileName) {

        List<Genre> genreList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {

            String line = reader.readLine();
            while (line != null) {

                Genre genre = Genre.convertToGenre(line);
                genreList.add(genre);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genreList;
    }

    public static List<Author> authorDataFormFileToList(String fileName) {

        List<Author> authorList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {

            String line = reader.readLine();
            while (line != null) {

                Author author = Author.convertToAuthor(line);
                authorList.add(author);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public static List<Book> bookDataFormFileToList(String fileName) {

        List<Book> bookList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line = reader.readLine();
            while (line != null) {

                Book book = Book.convertToBook(line);
                bookList.add(book);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}
