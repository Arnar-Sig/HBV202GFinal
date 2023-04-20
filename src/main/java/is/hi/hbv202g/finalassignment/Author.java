package is.hi.hbv202g.finalassignment;

/**
 * A class that represents an author of a book.
 */
public class Author {
    private String name;

    /**
     * Constructs a new Author class.
     * @param name The name of the author.
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Returns The name of the author.
     * @return The name of the author.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the author.
     * @param name The name of the author.
     */
    public void setName(String name) {
        this.name = name;
    }
}
