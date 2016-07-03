/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

/**
 *
 * @author ianlong
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
