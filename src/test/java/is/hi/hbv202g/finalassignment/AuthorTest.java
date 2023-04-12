package is.hi.hbv202g.finalassignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {


    @Test
    public void testAuthorConstructor() {
        Author author = new Author("John");
        Author author2 = new Author("John Doe");
    }

    @Test
    public void testGetName(){
        Author author = new Author("John");
        assertEquals("John", author.getName());
    }

    @Test
    public void testSetName(){
        Author author = new Author("John");
        author.setName("Jane");
        assertEquals("Jane", author.getName());
    }
}
