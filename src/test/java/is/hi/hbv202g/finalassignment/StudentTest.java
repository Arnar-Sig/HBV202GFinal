package is.hi.hbv202g.finalassignment;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Test
    public void testStudentConstructor() {
        Student student = new Student("John Doe", false);
    }

    @Test
    public void testIsFeePaid() {
        Student student = new Student("John Doe", false);
        student.isFeePaid();
    }
    @Test
    public void testStudentSetFeePaid() {
        Student student = new Student("John Doe", false);
        student.setFeePaid(true);
    }

    @Test
    public void testUserConstructorByUsingStudentSubclass() {
        User user = new Student("John Doe", false);
    }

    @Test
    public void testUserGetAndSetNameByUsingStudentSubclass() {
        User user = new Student("John Doe", false);
        assertEquals("John Doe", user.getName());
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }
}
