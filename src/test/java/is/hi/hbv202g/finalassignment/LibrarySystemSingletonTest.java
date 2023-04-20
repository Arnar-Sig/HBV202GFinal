package is.hi.hbv202g.finalassignment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibrarySystemSingletonTest {

    private LibrarySystemSingleton librarySystemSingleton;

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Before
    public void setUp() throws EmptyAuthorListException {
        librarySystemSingleton = LibrarySystemSingleton.getInstance();
    }

    @Test
    public void testLibrarySystemAddBookWithTitleAndAuthorList() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        librarySystemSingleton.addBookWithTitleAndAuthorlist("Test Title", authors);
    }

    @Test
    public void testLibrarySystemAddStudentUser(){
        librarySystemSingleton.addStudentUser("John Doe", false);
    }

    @Test
    public void testLibrarySystemAddFacultyMemberUser(){
        librarySystemSingleton.addFacultyMemberUser("John Doe", "Biology Department");
    }

    @Test
    public void testLibrarySystemFindBookByTitle(){
        librarySystemSingleton.findBookByTitle("Test Title");
    }

    @Test
    public void testLibrarySystemFindUserByName() {
        librarySystemSingleton.findUserByName("John Doe");
    }

    @Test
    public void testLibrarySystemBorrowBook() throws EmptyAuthorListException {
        Student student = new Student("John Doe", false);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book = new Book("Test Title", authors);
        librarySystemSingleton.borrowBook(student, book);
    }

    @Test
    public void testLibrarySystemExtendLending() throws EmptyAuthorListException {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Biology Department");
        Author author = new Author("John Doe");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book("Test Title", authors);
        librarySystemSingleton.extendLending(facultyMember, book, LocalDate.now().plusDays(30));
    }

    @Test
    public void testLibrarySystemReturnBook() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        Student student = new Student("John Doe", true);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book = new Book("Test Title", authors);
        librarySystemSingleton.returnBook(student, book);
    }

    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testLibrarySystemThrowUserOrBookDoesNotExistException() throws UserOrBookDoesNotExistException {
        throw new UserOrBookDoesNotExistException("User or book does not exist");
    }
}
