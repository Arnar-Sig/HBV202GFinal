package is.hi.hbv202g.finalassignment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Before
    public void testCreateBook() throws EmptyAuthorListException{
        ArrayList<Author> listOfAuthors = new ArrayList<>();
        listOfAuthors.add(new Author("John"));
        listOfAuthors.add(new Author("Jane"));
        book = new Book("The Adventures Of John And Jane", listOfAuthors);
    }

    @Test
    public void testBookConstructor() throws EmptyAuthorListException {
        ArrayList<Author> newAuthors = new ArrayList<>();
        newAuthors.add(new Author("New Author"));
        book = new Book("New Book", newAuthors);
        assertEquals("New Book", book.getTitle());
        assertEquals(newAuthors, book.getAuthors());
    }

    @Test
    public void testBookAddAuthor() {
        Author author2 = new Author("Jane");
        book.addAuthor(author2);
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testBookConstructorWithException() throws EmptyAuthorListException {
        ArrayList<Author> emptyListOfAuthors = new ArrayList<>();
        book = new Book("Adventures of John", emptyListOfAuthors);
    }

    @Test
    public void testBookSetAndGetAuthors() throws EmptyAuthorListException {
        ArrayList<Author> newAuthors = new ArrayList<>();
        newAuthors.add(new Author("New Author 1"));
        newAuthors.add(new Author("New Author 2"));
        book.setAuthors(newAuthors);
        assertEquals(newAuthors, book.getAuthors());
    }

    @Test(expected = EmptyAuthorListException.class)
    public void testBookSetAuthorsWithException() throws EmptyAuthorListException {
        ArrayList<Author> emptyListOfAuthors = new ArrayList<>();
        book.setAuthors(emptyListOfAuthors);
    }

    @Test
    public void testBookSetAndGetTitle() {
        book.setTitle("Huckleberry Finn");
        assertEquals("Huckleberry Finn", book.getTitle());
    }


}
