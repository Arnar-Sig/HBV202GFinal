package is.hi.hbv202g.finalassignment;

/**
 * A class that represents a student.
 * Extends the abstract User class.
 */
public class Student extends User {
    private boolean feePaid;

    /**
     * Constructor for the Student class.
     * @param name The name of the student.
     * @param feePaid Whether the user has paid the fee for borrowing a book.
     */
    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    /**
     * Returns whether the student has paid the fee for borrowing a book.
     * @return The truth value of whether the student has paid the fee for borrowing a book.
     */
    public boolean isFeePaid() {
        return feePaid;
    }

    /**
     * Sets whether the student has paid the fee for borrowing a book.
     * @param feePaid The truth value of whether the student has paid the fee for borrowing a book.
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}