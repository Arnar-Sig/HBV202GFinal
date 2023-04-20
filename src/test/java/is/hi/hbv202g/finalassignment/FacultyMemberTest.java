package is.hi.hbv202g.finalassignment;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacultyMemberTest {

    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Test
    public void testFacultyMemberConstructor() {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Biology Department");
        assertEquals("John Doe", facultyMember.getName());
        assertEquals("Biology Department", facultyMember.getDepartment());
    }

    @Test
    public void testFacultyMemberSetAndGetDepartment() {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Engineering Department");
        facultyMember.setDepartment("Science Department");
        assertEquals("Science Department", facultyMember.getDepartment());
    }

    @Test
    public void testUserConstructorByUsingFacultyMemberSubclass() {
        User user = new FacultyMember("John Doe", "Engineering Department");
    }

    @Test
    public void testUserGetAndSetNameByUsingFacultyMemberSubclass() {
        User user = new FacultyMember("John Doe", "Engineering Department");
        assertEquals("John Doe", user.getName());
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }
}
