package databaseproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author ianlong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a;
        String d ;
        String e;
        Scanner scan = new Scanner(System.in);
        DatabaseManager dbm = new DatabaseManager();
        Book book1 = new Book(1, "The Martian", "Andy Weir", 1);
        Book book2 = new Book(2, "A Course In Functional Analysis", "John Conway", 2);
        dbm.BookDatabase.put(1, book1);
        dbm.BookDatabase.put(2, book2);
        System.out.println("Welcome to my library. Type any positive number to continue.");
        while (0 != scan.nextInt()) {
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
                                    + "number to return to the front desk or type 0 to exit the library.");
                        };
                    } else {
                        System.out.println("This is not a valid number.  Type any number"
                                + " to continue");
                    }
                    break;

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
                                + " to return to the front desk or type 0 to exit the library.");
                    }
                    break;

                case 3:
                    scan.reset();
                    System.out.println("Please type the title of the"
                            + " book you wish to add.");
                    
                    if (scan.hasNextLine()) {
                        System.out.println("Please type the author of the"
                                + " book you wish to add.");};
                    d = scan.nextLine();
                    
                    
                    if (scan.hasNextLine()) {
                        System.out.println("Please type the edition of the"
                                + " book you wish to add.");};
                    
                    e = scan.nextLine();            
                    
                    
                    
                    if (scan.hasNextInt()) {
                        System.out.println("Please give the book an ID number.  "
                                + "Be careful to choose an ID number not already"
                                + " in use!");
                    }
                        int f = scan.nextInt();
                    
                    if (scan.hasNextInt()) {
                      int g = scan.nextInt();
                      if ((0 < g) && (!(dbm.BookDatabase.containsKey(g)))){
                        dbm.addBookToDatabase(g, d, e, f);
                        System.out.println("Your book has been added and its ID number is "
                                + g + ". Type any positive number to "
                                + "return to the front desk or type 0 to leave the library.");
                    }
                      else {
                         System.out.println("The number you entered is either not positive"
                                 + " or is already taken.  Type any positive number to start over.");
                      }}
                      
                      
                    break;
                case 4:
                    System.out.println("Here are all of the books currently in the library, listed by"
                            + " ID number beginning with the book with ID number 1:");
                    for (int BookID : dbm.BookDatabase.keySet()) {
                        System.out.println(dbm.BookDatabase.get(BookID).titleOfBook
                                + " has ID number " + dbm.BookDatabase.get(BookID).BookDataNumber);

                    }
                    System.out.println("Type any positive number to return to the front desk or type 0 to exit the library.");
                    break;
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
                                + " to return to the front desk or type 0 to exit the library.");
                    }
                    break;
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
                                + " to return to the front desk or type 0 to exit the library.");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You did not enter a number that we can use. "
                            + "Please try again");
                    break;
            }
        }
    }
}
