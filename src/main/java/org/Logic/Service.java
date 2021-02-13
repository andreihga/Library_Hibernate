package org.Logic;

import org.Entity.Book;
import org.Repository.BookDAO;
import org.Repository.UserDAO;

import java.util.List;
import java.util.Scanner;

public class Service {
    BookDAO bookDAO = new BookDAO();
    UserDAO userDAO = new UserDAO();
    Scanner scanner = new Scanner(System.in);

    public void insertBook() {
        System.out.println("You will insert the book name here: ");
        String bookName = scanner.next();
        System.out.println("You will insert the book author here: ");
        scanner.nextLine();
        String authorName = scanner.nextLine();
        Book book = new Book(bookName, authorName);
        bookDAO.insertBook(book);
    }

    public void getAllBooks() {
        System.out.println("you about to get all books");
        List<Book> listOfAllBooks = bookDAO.getAllBooks();
        for (Book book : listOfAllBooks) {
            System.out.println(book);
        }
    }

    public void getBookByName() {
        System.out.print("Insert the name of the book you are looking for: ");
        String bookName = scanner.next();
        List<Book> listOfBooksByName = bookDAO.getBookByName(bookName);
        for (Book book : listOfBooksByName) {
            System.out.println(book);
        }
    }
    public void updateBook(){
        System.out.println("To be built...");
    }

    public void deleteBook(){
        System.out.println("To be built...");
    }

    public void authentication(){
        authenticationMenu();
        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("You will log in.");
            case 2:
                System.out.println("You will create now an account :)");
            default:
                System.out.println("That's not a valid command.Try again!");
                authentication();
        }
    }

    public void logIn(){
        System.out.println("Enter username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        boolean loginStatus = userDAO.login(username,password);
        if(!loginStatus){
            System.out.println("Username or password incorrect.");
            logIn();
        }
        else System.out.println("Log in successfully");
    }

    public void doCommand() {
        commandList();
        System.out.println("Choose a command: ");
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                insertBook();
                break;
            case 2:
                getAllBooks();
                break;
            case 3:
                getBookByName();
                break;
            case 4:
                logIn();
                //updateBook();
                break;
            case 5:
                deleteBook();
                break;
            default:
                System.out.println("That's not a valid command.Try again!");
                doCommand();
        }
    }

    public void commandList() {
        System.out.println("1. Insert a book");
        System.out.println("2. Get all books");
        System.out.println("3. Search for a book");
        System.out.println("4. Update a book");
        System.out.println("5. Delete a book");
    }

    public void authenticationMenu(){
        System.out.println("1. Login");
        System.out.println("2. Sign up");
    }

}
