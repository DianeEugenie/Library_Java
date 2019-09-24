import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LibraryTest {

    Library library;
    Book book;
    Book book2;
    Book book3;
    Book book4;


    @Before
    public void before(){
        library = new Library("Hogwarts Library", 4);
        book = new Book("Fantastic Beasts And Where To Find Them", "Newt Scamander", "Magizoology");
        book2 = new Book("The Standard Book of Spells Year 1", "Miranda Goshawk", "Charms");
        book3 = new Book("Achievements in Charming", "Miranda Goshawk", "Charms");
        book4 = new Book("The Dark Forces: A Guide To Self-Protection", "Quentin Trimble", "Defence Against The Dark Arts");
    }

    @Test
    public void startsEmpty(){
        //Given we have a library
        assertNotNull(library);
        //When library gets build
        //Then library has 0 books
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddBook(){
        //Give we have a library
        assertNotNull(library);
        //AND we have a book
        assertNotNull(book);
        //When book is added to library
        library.addBook(book);
        //Then library has 1 book
        assertEquals(1, library.bookCount());
    }

    @Test
    public void canAddBook__IfStockFull(){
        //Given we have a library
        assertNotNull(library);
        //AND our stock is full (capacity 4)
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        //When book is added to library
        library.addBook(book);
        //Then library still has stock 4;
        assertEquals(4, library.bookCount());
    }

    @Test
    public void canRemoveBook(){
        //Given we have a library
        assertNotNull(library);
        //AND the library has a book;
        library.addBook(book);
        //When book is removed
        library.removeBook();
        //Then Library has no stock;
        assertEquals(0, library.bookCount());
    }


    @Test
    public void canTrackBooksByGenre(){
        //Given we have a library
        assertNotNull(library);
        //AND the library has several books
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        //When we check the books by genre
        library.checkGenre("Charms");
        //Then we should get returned a HashMap of key (genre) value pairs (number)
        assertEquals(3, library.genreCounterCount());
        assertEquals(2, library.checkGenre("Charms"));
    }



}
