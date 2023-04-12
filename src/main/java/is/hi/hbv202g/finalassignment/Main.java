package is.hi.hbv202g.finalassignment;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        System.out.println(librarySystem.createLibraryTextHeader());
            System.out.println("What would you like to do?");
            System.out.println("1. Add Book");
            System.out.println("2. Add Student");
            System.out.println("3. Add Faculty Member");
            System.out.println("4. Find Book");
            System.out.println("5. Find Student");
            System.out.println("6. Find Faculty Member");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");

    }
}