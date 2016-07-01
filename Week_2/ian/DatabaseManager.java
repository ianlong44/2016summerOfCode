/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

import java.util.HashMap;

/**
 *
 * @author ianlong
 */
public class DatabaseManager {

    HashMap<Integer, Book> BookDatabase = new HashMap<>();

    public void addBookToDatabase(String title, String author, int edition) 
    {Book newBook = new Book(BookDatabase.size() + 1, title, author, edition);
        BookDatabase.put(BookDatabase.size() + 1, newBook);
    }

    public void removeBookFromDatabase(int bookNumber) {
        BookDatabase.remove(bookNumber);
    }

    public void searchForBook(int bookNumber) {
        if (bookNumber > BookDatabase.size() || bookNumber < 0) {
            System.out.println("That is not a valid book ID number.  Stupid.");
        } else {
            System.out.println("The book you're looking for is " + BookDatabase.get(bookNumber).titleOfBook
                    + ". If you would like to withdraw it, type 1.  Otherwise, type 2.");
        };

    }

}
