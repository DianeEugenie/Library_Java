import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCounter;

    public Library(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.books = new ArrayList<Book>();
        this.genreCounter = new HashMap<String, Integer>();
    }

    public int bookCount() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.bookCount() < this.capacity) {
            this.books.add(book);
            if (!this.genreCounter.containsKey(book.getGenre())) {
                String genre = book.getGenre();
                Integer count = 1;
                this.genreCounter.put(genre, count);
            } else {
                String genre = book.getGenre();
                Integer count = this.genreCounter.get(genre);
                this.genreCounter.put(genre, count + 1);
            }
        }
    }

    public Book removeBook() {
        if (this.bookCount() >= 1) {
            return this.books.remove(0);
        }

        return null;
    }


    public int genreCounterCount() {
        return this.genreCounter.size();
    }


    public int checkGenre(String input) {
        return this.genreCounter.get(input);
    }
}
