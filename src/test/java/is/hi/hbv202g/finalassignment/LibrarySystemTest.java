package is.hi.hbv202g.finalassignment;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LibrarySystemTest {
    private LibrarySystem librarySystem;
    @Before
    public void setUp(){
        librarySystem = new LibrarySystem();
    }

    @Test
    public void testLibrarySystemConstructor(){
        LibrarySystem librarySystem2 = new LibrarySystem();
    }

    @Test
    public void testAddBookWithTitleAndAuthorList() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        librarySystem.addBookWithTitleAndAuthorlist("Test Title", authors);
        System.out.println(librarySystem.toString());
    }


}
