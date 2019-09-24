import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BorrowerTest {

    Borrower borrower;
    Book book;
    Library library;

    @Before
    public void before(){
        library = new Library("Hogwarts Library", 2);
        borrower = new Borrower("Luna");
        book = book = new Book("Fantastic Beasts And Where To Find Them", "Newt Scamander", "Magizoology");
    }

    @Test
    public void hasNoBooksBeforeBorrowing(){
        //Given we have a borrower
        assertNotNull(borrower);
        //AND a book
        assertNotNull(book);
        //When borrower goes to library
        //Borrower has no book in collection
        assertEquals(0, borrower.collectionCount());
    }

    @Test
    public void canAddBookToCollection(){
        //Given we have a borrower
        assertNotNull(borrower);
        //AND we have a book
        assertNotNull(book);
        //When borrower takes a book
        borrower.addBookToCollection(book);
        //Then borrower has 1 book in collection
        assertEquals(1, borrower.collectionCount());
    }

    @Test
    public void canTakeBookFromLibrary(){
        //Given we have a borrower
        assertNotNull(borrower);
        //AND a library
        assertNotNull(library);
        //AND a book in the library
        library.addBook(book);
        //When borrower takes a book from the library
        borrower.takeBook(library);
        //Then library has no books left in collection
        assertEquals(0, library.bookCount());

    }



}
