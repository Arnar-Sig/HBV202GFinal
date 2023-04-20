package is.hi.hbv202g.finalassignment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibrarySystemTest {

    private LibrarySystem librarySystem;

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Before
    public void testCreateLibrarySystem(){
        librarySystem = new LibrarySystem();
    }

    @Test
    public void testLibrarySystemConstructor(){
        LibrarySystem librarySystem2 = new LibrarySystem();
    }

    @Test
    public void testLibrarySystemAddBookWithTitleAndAuthorList() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        librarySystem.addBookWithTitleAndAuthorlist("Test Title", authors);
    }

    @Test
    public void testLibrarySystemAddStudentUser(){
        librarySystem.addStudentUser("John Doe", false);
    }

    @Test
    public void testLibrarySystemAddFacultyMemberUser(){
        librarySystem.addFacultyMemberUser("John Doe", "Biology Department");
    }

    @Test
    public void testLibrarySystemFindBookByTitle(){
        librarySystem.findBookByTitle("Test Title");
    }

    @Test
    public void testLibrarySystemFindUserByName() {
        librarySystem.findUserByName("John Doe");
    }

    @Test
    public void testLibrarySystemBorrowBook() throws EmptyAuthorListException {
        Student student = new Student("John Doe", false);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book = new Book("Test Title", authors);
        librarySystem.borrowBook(student, book);
    }

    @Test
    public void testLibrarySystemExtendLending() throws EmptyAuthorListException {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Biology Department");
        Author author = new Author("John Doe");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book("Test Title", authors);
        librarySystem.extendLending(facultyMember, book, LocalDate.now().plusDays(30));
    }

    @Test
    public void testLibrarySystemReturnBook() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        Student student = new Student("John Doe", true);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book = new Book("Test Title", authors);
        librarySystem.returnBook(student, book);
    }

    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testLibrarySystemThrowUserOrBookDoesNotExistException() throws UserOrBookDoesNotExistException {
        throw new UserOrBookDoesNotExistException("User or book does not exist");
    }

}
