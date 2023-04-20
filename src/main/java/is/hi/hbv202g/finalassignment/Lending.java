package is.hi.hbv202g.finalassignment;

import java.time.LocalDate;

/**
 * A class that represents a lending.
 */
public class Lending {
    private LocalDate dueDate;
    private Book book;
    private User user;

    /**
     * Constructs a new Lending class.
     * @param book The book to lend.
     * @param user The user to lend the book to.
     */
    public Lending(Book book, User user){
        this.book = book;
        this.user = user;
        dueDate = LocalDate.now().plusDays(30);
    }

    /**
     * Returns the date the book is due.
     * @return The date the book is due.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the date the book is due.
     * @param dueDate The date to set.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the book being lent.
     * @return The book.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book being lent.
     * @param book The book to set.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Sets the user who is being lent the book.
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the user who is being lent the book.
     * @return The user who is being lent the book.
     */
    public User getUser() {
        return user;
    }

}
