package is.hi.hbv202g.finalassignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private static LibrarySystem INSTANCE;


    private ArrayList<Lending> lendings;
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public static LibrarySystem getInstance() throws EmptyAuthorListException {
        if (INSTANCE == null) {
            INSTANCE = new LibrarySystem();
        }
        return INSTANCE;
    }

    private LibrarySystem() throws EmptyAuthorListException {
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

    void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        Book book = new Book(title, authors);
        books.add(book);
    }
    void addStudentUser(String name, boolean feePaid) {
        Student student = new Student(name, feePaid);
        users.add(student);
    }
    void addFacultyMemberUser(String name, String department) {
        FacultyMember facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }
    Book findBookByTitle(String title) {
        for(Book book: books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
    User findUserByName(String name) {
        for(User user: users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
    void borrowBook(User user, Book book){
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }
    void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate){
        for(Lending lending: lendings){
            if(lending.getBook().getTitle().equals(book.getTitle())){
                lending.setDueDate(newDueDate);
            }
        }
    }

    void addLending(Lending lending){
        lendings.add(lending);
    }

    void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        return;
    }

    public ArrayList<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(ArrayList<Lending> lendings) {
        this.lendings = lendings;
    }

}
