import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name){
        this.name = name;
        this.collection = new ArrayList<Book>();
    }

    public int collectionCount() {
        return this.collection.size();
    }

    public void addBookToCollection(Book book) {
        this.collection.add(book);
    }


    public void takeBook(Library library) {
        if (library.bookCount() > 0) {
            Book borrowedBook = library.removeBook();
            this.addBookToCollection(borrowedBook);
        }
    }
}
