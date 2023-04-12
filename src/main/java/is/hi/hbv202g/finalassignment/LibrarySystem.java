package is.hi.hbv202g.finalassignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private ArrayList<Lending> lendings;
    private ArrayList<User> users;
    private ArrayList<Book> books;
    public LibrarySystem(){
        this.lendings = new ArrayList<>();
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
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
    void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        return;
    }

    public String createLibraryTextHeader(){
        String header = """
                *******************************************
                *                                         *
                *               THE LIBRARY               *
                *                                         *
                *******************************************
                           WELCOME TO THE LIBRARY               
                """;
        return header;
    }
}
