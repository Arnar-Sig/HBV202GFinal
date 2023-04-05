package is.hi.hbv202g.finalassignment;

import java.util.List;

public class Book{
    private String title;
    private List<Author> authors;
    public Book(String title, List<Author> authors) throws EmptyAuthorListException{
        this.title = title;
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        this.authors = authors;
    }
    void addAuthor(Author author) {
        this.authors.add(author);
    }

    public List<Author> getAuthors() throws EmptyAuthorListException{
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        return authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if(authors.size()==0){
            throw new EmptyAuthorListException("No authors");
        }
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
