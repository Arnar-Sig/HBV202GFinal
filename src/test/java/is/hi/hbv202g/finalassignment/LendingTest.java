package is.hi.hbv202g.finalassignment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class LendingTest {

    private Book book;
    private Lending lending;

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Before
    public void testCreateLending() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("J. R. R. Tolkien"));
        book = new Book("The Lord of the Rings", authors);
        Student student = new Student("Student", false);
        lending = new Lending(book, student);
    }

    @Test
    public void testLendingConstructor() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book2 = new Book("Test Book", authors);
        Student student = new Student("Student", false);
        Lending lending2 = new Lending(book2, student);
        LocalDate timeNow = LocalDate.now();
        lending2.setDueDate(timeNow);
        assertEquals(book2, lending2.getBook());
        assertEquals(student, lending2.getUser());
        assertEquals(timeNow, lending2.getDueDate());
    }

    @Test
    public void testLendingSetAndGetDueDate(){
        LocalDate dueDate = LocalDate.now().plusDays(30);
        lending.setDueDate(dueDate);
        assertEquals(dueDate, lending.getDueDate());
    }

    @Test
    public void testLendingSetAndGetBook() throws EmptyAuthorListException {
        assertEquals(book, lending.getBook());
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book2 = new Book("Test Book", authors);
        lending.setBook(book2);
        assertEquals(book2, lending.getBook());
    }

    @Test
    public void testLendingSetAndGetUser() {
        Student student1 = new Student("Student1", false);
        lending.setUser(student1);
        assertEquals(student1, lending.getUser());
        Student student2 = new Student("Student2", false);
        lending.setUser(student2);
        assertEquals(student2, lending.getUser());
    }
}
