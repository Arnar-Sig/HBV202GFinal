package is.hi.hbv202g.finalassignment;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {
    @Rule
    public TestResultPrinter testResultPrinter = new TestResultPrinter();

    @Test
    public void testAuthorConstructor() {
        Author author = new Author("John");
        Author author2 = new Author("John Doe");
    }

    @Test
    public void testAuthorSetAndGetName(){
        Author author = new Author("John");
        author.setName("Jane");
        assertEquals("Jane", author.getName());
    }
}
