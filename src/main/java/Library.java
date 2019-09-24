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
            //this.keepTrack();
            this.keepTrack(book, 1);
        }
    }

    public Book removeBook() {
        Book removedBook = null;

        if (this.bookCount() >= 1) {
            removedBook = this.books.remove(0);
            //this.keepTrack();
            this.keepTrack(removedBook, -1);
        }

        return removedBook;
    }

    public void keepTrack(Book book, Integer number) {

        if (number == 1) {
                if (this.genreCounter.containsKey(book.getGenre())) {

                    Integer value = this.genreCounter.get(book.getGenre());

                    this.genreCounter.put(book.getGenre(), value + number);

                } else {

                    this.genreCounter.put(book.getGenre(), number);

                }
        } else {
            Integer value = this.genreCounter.get(book.getGenre());

            this.genreCounter.put(book.getGenre(), value + number);

            if (this.genreCounter.get(book.getGenre()) == 0) {
                this.genreCounter.remove(book.getGenre());
            }

        }

    }



//    public void keepTrack() {
//        //needed to reset genreCounter otherwise genreCounter keeps adding to values
//        this.genreCounter.clear();
//
//        for (Book book: this.books) {
//
//            if (this.genreCounter.containsKey(book.getGenre())) {
//                Integer value = this.genreCounter.get(book.getGenre());
//                this.genreCounter.put(book.getGenre(), value + 1);
//            } else {
//                this.genreCounter.put(book.getGenre(), 1);
//            }
//        }
//    }

    public int genreCounterCount() {
        return this.genreCounter.size();
    }


    public int checkGenre(String input) {
        if (this.genreCounter.containsKey(input)) {
            return this.genreCounter.get(input);
        } else {
            return 0;
        }
    }
}
