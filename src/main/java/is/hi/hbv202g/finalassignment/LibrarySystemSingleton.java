package is.hi.hbv202g.finalassignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class that holds the library system.
 */
public class LibrarySystemSingleton {
    private static LibrarySystemSingleton INSTANCE;

    private ArrayList<Lending> lendings;
    private ArrayList<User> users;
    private ArrayList<Book> books;

    /**
     * Gets an instance of the library system.
     * @return The singleton instance of the library system.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    public static LibrarySystemSingleton getInstance() throws EmptyAuthorListException {
        if (INSTANCE == null) {
            INSTANCE = new LibrarySystemSingleton();
        }
        return INSTANCE;
    }

    /**
     * Constructor for the LibrarySystemSingleton class.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    private LibrarySystemSingleton() throws EmptyAuthorListException {
        this.lendings = new ArrayList<>();
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        ArrayList<Author> book1Authors = new ArrayList<>();
        book1Authors.add(new Author("J.K. Rowling"));
        Book book1 = new Book("Harry Potter", book1Authors);
        ArrayList<Author> book2Authors = new ArrayList<>();
        book2Authors.add(new Author("J.R.R. Tolkien"));
        Book book2 = new Book("The Hobbit", book2Authors);
        ArrayList<Author> book3Authors = new ArrayList<>();
        book3Authors.add(new Author("Stephen King"));
        Book book3 = new Book("It", book3Authors);
        books.add(book1); books.add(book2); books.add(book3);
    }

    /**
     * Adds a book to the library system.
     * @param title The title of the book.
     * @param authors The authors of the book.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        Book book = new Book(title, authors);
        books.add(book);
    }

    /**
     * Adds a Student user to the library system.
     * @param name The name of the user.
     * @param feePaid Whether the user has paid the fee for borrowing the book.
     */
    void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }

    /**
     * Adds a FacultyMember user to the library system.
     * @param name The name of the Faculty member.
     * @param department The department of the Faculty member.
     */
    void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    /**
     * Finds a book by title.
     * @param title The title of the book.
     * @return Either the book that matches the title, or null if none is found.
     */
    Book findBookByTitle(String title) {
        for(Book book: books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    /**
     * Finds a user by name.
     * @param name The name of the user.
     * @return Either the user that matches the name, or null if none is found.
     */
    User findUserByName(String name) {
        for(User user: users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    /**
     * Borrows a book from the library system.
     * @param user The user borrowing the book.
     * @param book The book to be borrowed.
     */
    void borrowBook(User user, Book book){
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    /**
     * Extends the due date of a lending.
     * @param facultyMember The Faculty Member authorizing the extension.
     * @param book The book to be extended.
     * @param newDueDate The new due date.
     */
    void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate){
        for(Lending lending: lendings){
            if(lending.getBook().getTitle().equals(book.getTitle())){
                lending.setDueDate(newDueDate);
            }
        }
    }

    /**
     * Adds a lending to the library system.
     * @param lending The lending to be added.
     */
    void addLending(Lending lending){
        lendings.add(lending);
    }

    /**
     * Returns a book to the library system.
     * @param user The user returning the book.
     * @param book The book to be returned.
     * @throws UserOrBookDoesNotExistException Throws if the user or book does not exist.
     */
    void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        for(Lending lending: lendings){
            if(lending.getUser().getName().equals(user.getName()) && lending.getBook().getTitle().equals(book.getTitle())){
                lendings.remove(lending);
                break;
            }
        }
    }

    /**
     * Gets the collection of lendings.
     * @return The collection of lendings.
     */
    public ArrayList<Lending> getLendings() {
        return lendings;
    }

    /**
     * Sets the collection of lendings.
     * @param lendings The collection of lendings to bee set.
     */
    public void setLendings(ArrayList<Lending> lendings) {
        this.lendings = lendings;
    }
}
