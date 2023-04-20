package is.hi.hbv202g.finalassignment;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorTest.class,
        BookTest.class,
        StudentTest.class,
        FacultyMemberTest.class,
        LendingTest.class,
        LibrarySystemSingletonTest.class
})
public class AllTests {
    @AfterClass
    public static void tearDownAfterClass() {
        ResultStorageSingleton instance = ResultStorageSingleton.getInstance();
        System.out.println(instance.toString());
    }
}

