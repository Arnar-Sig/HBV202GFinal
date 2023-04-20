package is.hi.hbv202g.finalassignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static LibrarySystem librarySystem;

    public static void main(String[] args) throws EmptyAuthorListException, InterruptedException {
        librarySystem = LibrarySystem.getInstance();
        scanner = new Scanner(System.in);
        System.out.println(createLibraryTextHeader());

        while(true){
            CliMainMenu();
            String input = "";
            input = scanner.nextLine();

            if(input.equals("1") || input.toLowerCase().contains("borrow")){
                CliBorrowBook();
            }
            if(input.equals("2") || input.toLowerCase().contains("return")){
                CliReturnBook();
            }
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
        }



    }



    private static void CliBorrowBook() {
        while(true){
            System.out.println("What is the title of the book you wish to borrow?");
            System.out.println("You can type \"exit\" to go back to the main menu.");
            String input = "";
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")){
                return;
            }
            Book foundBook = librarySystem.findBookByTitle(input);
            if(foundBook == null){
                System.out.println("Book not found");
            }else{
                ArrayList<Lending> lendings = librarySystem.getLendings();
                for(Lending lending: lendings) {
                    if (lending.getBook().getTitle().equals(foundBook.getTitle())) {
                        System.out.println("Book is already boorwed.");
                        try{
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return;
                    }
                }
                System.out.println("Please enter your name:");
                input = scanner.nextLine();
                Student user = new Student(input, true);
                librarySystem.borrowBook(user, foundBook);
                lendings = librarySystem.getLendings();
                for(Lending lending: lendings) {
                    if (lending.getBook().getTitle().equals(foundBook.getTitle())) {
                        System.out.println("Congratulations, you have borrowed the book " + foundBook.getTitle() +  " and your due date is: " + lending.getDueDate() + ".");
                        try{
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return;
                    }
                }
            }
        }
    }

    private static void CliReturnBook() throws InterruptedException {
        while(true){
            System.out.println("What is the title of the book you wish to return?");
            System.out.println("You can type \"exit\" to go back to the main menu.");
            String input = "";
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")){
                return;
            }
            Book foundBook = librarySystem.findBookByTitle(input);
            if(foundBook == null){
                System.out.println("Book not found");
                try{
                    Thread.sleep(2000);
                    return;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("Please enter your name:");
                input = scanner.nextLine();
                Student user = new Student(input, true);
                ArrayList<Lending> lendings = librarySystem.getLendings();
                boolean found = false;
                for(Lending lending: lendings){
                    if(lending.getUser().getName().equals(user.getName())){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("User not found");
                    try{
                        Thread.sleep(2000);
                        return;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    librarySystem.returnBook(user, foundBook);
                    System.out.println("Book returned.");
                    Thread.sleep(2000);
                } catch (UserOrBookDoesNotExistException | InterruptedException e) {
                    System.out.println("Book or user does not exist.");
                    Thread.sleep(2000);
                    return;
                }
            }
        }
    }



    private static String createLibraryTextHeader(){
        String header = """
                *******************************************
                *                                         *
                *               THE LIBRARY               *
                *                                         *
                *******************************************        
                """;
        return header;
    }

    /**
     *
     */
    private static void CliMainMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("You can type \"exit\" to end the program.");
        System.out.println();
    }
}