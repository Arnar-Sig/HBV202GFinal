package is.hi.hbv202g.finalassignment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorTest.class,
        BookTest.class,
        StudentTest.class,
        FacultyMemberTest.class,
        LendingTest.class,
        LibrarySystemTest.class

})
public class AllTests {
}