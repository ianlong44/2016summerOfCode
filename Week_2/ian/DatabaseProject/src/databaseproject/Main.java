package databaseproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.io.*;
import java.io.File;

/**
 *
 * @author ianlong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// This first bit of code accesses the existing library/database of books from a text file.
        File file = new File("/Users/ianlong/SummerProgramming/2016SummerOfCode/2016summerOfCode/Week_2/ian/DatabaseProject/BookDatabase.txt");
        int a;
        String d;
        String e;
        DatabaseManager dbm = new DatabaseManager();
        try {
            Scanner scanner = new Scanner(System.in);
            scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                int bookNum1 = scanner.nextInt();
                scanner.nextLine();
                scanner.nextLine();
                String titleTitle = scanner.nextLine();
                String authorAuthor = scanner.nextLine();
                int edition = scanner.nextInt();
                Book newBook = new Book(bookNum1, titleTitle, authorAuthor, edition);
                dbm.BookDatabase.put(bookNum1, newBook);

            }
            scanner.close();
        } catch (IOException exx) {
            System.out.println("Something's not quite right...");
        };

        /* This is a switch statement which brings the user to the library's front desk.  From there,
    they can access information about any of the books in the library or add/remove books from
    the library.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to my library. Type any positive number to continue.");
        while (-1 != scan.nextInt()) {
            System.out.println("You are at the front desk. What would you like to do?");
            System.out.println("Your options are:");
            System.out.println("1) Search for a book.");
            System.out.println("2) Remove a book from the library.");
            System.out.println("3) Add a book to the library.");
            System.out.println("4) Print all the books in the library.");
            System.out.println("5) Find the author of a book with a given ID number");
            System.out.println("6) Find the edition number of a book with a given ID number");
            System.out.println("0) Exit the Library");
            System.out.println("Please enter the corresponding number");
            a = scan.nextInt();
            d = scan.nextLine();
            switch (a) {
 
  // This case allows the user to search for a book if they know its ID number.              
                
                case 1:
                    System.out.println("Please type the BookID number for the book you"
                            + " wish to find.");
                    int b = scan.nextInt();
                    if (dbm.BookDatabase.containsKey(b)) {
                        dbm.searchForBook(b);
                        int g = scan.nextInt();
                        if (g == 1) {
                            dbm.removeBookFromDatabase(b);
                            System.out.println("It's yours! Type any number to continue.");
                        } else {
                            System.out.println("Okay, I'll put it back. Type any "
                                    + "number to return to the front desk.");
                        };
                    } else {
                        System.out.println("This is not a valid number.  Type any number"
                                + " to continue");
                    }
                    break;

// This case allows a book to be removed from the library/database.

                case 2:
                    System.out.println("Please type the BookID number for the book you"
                            + " wish to remove.");
                    int c = scan.nextInt();
                    if (dbm.BookDatabase.containsKey(c)) {
                        System.out.println("You've checked out "
                                + dbm.BookDatabase.get(c).titleOfBook + ". Type any "
                                + "number to continue.");
                        dbm.removeBookFromDatabase(c);
                    } else {
                        System.out.println("This is not a valid number.  Type any number"
                                + " to return to the front desk.");
                    }
                    break;

/* This case allows the user to add a new book to the library by supplying its title,
   author, and edition and assigning it an ID number.*/
                    
                case 3:
                    scan.reset();
                    System.out.println("Please type the title of the"
                            + " book you wish to add.");

                    if (scan.hasNextLine()) {
                        System.out.println("Please type the author of the"
                                + " book you wish to add.");
                    }
                    ;
                    d = scan.nextLine();

                    if (scan.hasNextLine()) {
                        System.out.println("Please type the edition of the"
                                + " book you wish to add.");
                    }
                    ;

                    e = scan.nextLine();

                    if (scan.hasNextInt()) {
                        System.out.println("Please give the book an ID number.  "
                                + "Be careful to choose an ID number not already"
                                + " in use!");
                    }
                    int f = scan.nextInt();

                    if (scan.hasNextInt()) {
                        int g = scan.nextInt();
                        if ((0 < g) && (!(dbm.BookDatabase.containsKey(g)))) {
                            dbm.addBookToDatabase(g, d, e, f);
                            System.out.println("Your book has been added and its ID number is "
                                    + g + ". Type any positive number to "
                                    + "return to the front desk.");
                        } else {
                            System.out.println("The number you entered is either not positive"
                                    + " or is already taken.  Type any positive number to return to "
                                    + "the front desk and start over.");
                        }
                    }

                    break;
 
// This case allows the user to list all books in the library and their ID numbers.
                
                case 4:
                    System.out.println("Here are all of the books currently in the library, listed by"
                            + " ascending ID number:");
                    for (int BookID : dbm.BookDatabase.keySet()) {
                        System.out.println(dbm.BookDatabase.get(BookID).titleOfBook
                                + " has ID number " + dbm.BookDatabase.get(BookID).BookDataNumber);

                    }
                    System.out.println("Type any positive number to return to the front desk.");
                    break;
                    
// This case allows the user to find the author of a book if they know its ID number.        
                    
                case 5:
                    System.out.println("Please type the BookID number for the book "
                            + "whose author you wish to find.");
                    int g = scan.nextInt();
                    if (dbm.BookDatabase.containsKey(g)) {
                        System.out.println("The author of "
                                + dbm.BookDatabase.get(g).titleOfBook + " is "
                                + dbm.BookDatabase.get(g).authorOfBook + ". Type any "
                                + "number to continue.");
                    } else {
                        System.out.println("This is not a valid number.  Type any number"
                                + " to return to the front desk.");
                    }
                    break;
                    
// This case allows the user to find the author of a book if they know its ID number. 
                    
                case 6:
                    System.out.println("Please type the BookID number for the book "
                            + "whose edition you wish to find.");
                    int h = scan.nextInt();
                    if (dbm.BookDatabase.containsKey(h)) {
                        System.out.println("The edition number of "
                                + dbm.BookDatabase.get(h).titleOfBook + " is "
                                + dbm.BookDatabase.get(h).editionNumberOfBook + ". Type any "
                                + "number to continue.");
                    } else {
                        System.out.println("This is not a valid number.  Type any number"
                                + " to return to the front desk.");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");

                    file.getParentFile().mkdirs();

                    try {
                        PrintWriter writer = new PrintWriter(file);

                        for (int bookNumber : dbm.BookDatabase.keySet()) {
                            writer.println(bookNumber);
                            writer.println(dbm.BookDatabase.get(bookNumber).BookDataNumber);
                            writer.println(dbm.BookDatabase.get(bookNumber).titleOfBook);
                            writer.println(dbm.BookDatabase.get(bookNumber).authorOfBook);
                            writer.println(dbm.BookDatabase.get(bookNumber).editionNumberOfBook);
                        }

                        writer.close();

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    ;

                    System.exit(0);
                    break;
               
// This case deals with the fact that the user might not type something that makes sense. 
                    
                default:
                    System.out.println("You did not enter a number that we can use. "
                            + "Please try again");
                    break;
            }
        }
    }
}
