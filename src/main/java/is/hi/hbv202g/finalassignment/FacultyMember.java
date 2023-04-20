package is.hi.hbv202g.finalassignment;

/**
 * A class that represents a faculty member.
 * Extends the abstract User class.
 */
public class FacultyMember extends User{
    private String department;

    /**
     * Constructs a new FacultyMember class.
     * @param name The name of the faculty member.
     * @param department The department of the faculty member.
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    /**
     * Returns The department of the faculty member.
     * @return The department of the faculty member.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the faculty member.
     * @param department The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
