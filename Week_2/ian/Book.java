/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

/**
 * Reading from the keyboard or a file
 *
 * This is an example used on our Java Programming courses to provide early
 * access to user input, and supporting also input from a file so that each
 * program that uses it can be demonstrated in a batch mode.
 *
 */
public class Book {

    int BookDataNumber;
    String titleOfBook;
    String authorOfBook;
    int editionNumberOfBook;

    public Book(int DatabaseNumber, String title, String author, int editionNumber) {
        BookDataNumber = DatabaseNumber;
        titleOfBook = title;
        authorOfBook = author;
        editionNumberOfBook = editionNumber;
    }

}
