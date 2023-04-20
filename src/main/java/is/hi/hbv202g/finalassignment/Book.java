package is.hi.hbv202g.finalassignment;

import java.util.List;

/**
 * A class that represents a book.
 */
public class Book{
    private String title;
    private List<Author> authors;

    /**
     * Constructor for the Book class.
     * @param title The name of the book.
     * @param authors The name of the authors.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    public Book(String title, List<Author> authors) throws EmptyAuthorListException{
        this.title = title;
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        this.authors = authors;
    }

    /**
     * Adds an author to the list of authors.
     * @param author The author to add.
     */
    void addAuthor(Author author) {
        this.authors.add(author);
    }

    /**
     * Returns the authors of the book.
     * @return List of authors.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    public List<Author> getAuthors() throws EmptyAuthorListException{
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        return authors;
    }

    /**
     * Sets the names of the authors.
     * @param authors The authors to be set.
     * @throws EmptyAuthorListException Throws if the list of authors is empty.
     */
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        this.authors = authors;
    }

    /**
     * Sets the title of the book.
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }
}
