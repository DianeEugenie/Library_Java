import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Book book;

    @Before
    public void before(){
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



}
