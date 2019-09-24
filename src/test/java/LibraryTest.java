import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LibraryTest {

    Library library;
    Book book;
    //Borrower borrower;

    @Before
    public void before(){
        library = new Library("Hogwarts Library", 100);
        //book = new Book("Fantastic Beasts And Where To Find Them", "Newt Scamander", "Magizoology");
    }

    @Test
    public void startsEmpty(){
        //Given we have a library
        assertNotNull(library);
        //When library gets build
        //Then library has 0 books
        assertEquals(0, library.bookCount());
    }



}
