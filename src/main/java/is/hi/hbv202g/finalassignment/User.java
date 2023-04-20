package is.hi.hbv202g.finalassignment;

/**
 * An abstract class that represents a user.
 */
public abstract class User {
    private String name;

    /**
     * Constructor for the User class.
     * @param name The name of the user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
