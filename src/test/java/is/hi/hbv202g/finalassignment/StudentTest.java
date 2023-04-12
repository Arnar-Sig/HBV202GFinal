package is.hi.hbv202g.finalassignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testStudentConstructor() {
        Student student = new Student("John Doe", false);
    }

    @Test
    public void testStudentSetFeePaidAndIsFeePaid() {
        Student student = new Student("John Doe", false);
        assertFalse(student.isFeePaid());
        student.setFeePaid(true);
        assertTrue(student.isFeePaid());
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
