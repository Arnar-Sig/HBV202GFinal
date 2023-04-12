package is.hi.hbv202g.finalassignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class FacultyMemberTest {

    @Test
    public void testFacultyMemberConstructor() {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Main Department");
    }

    @Test
    public void testFacultyMemberSetAndGetDepartment() {
        FacultyMember facultyMember = new FacultyMember("John Doe", "Engineering Department");
        assertEquals("Engineering Department", facultyMember.getDepartment());
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
