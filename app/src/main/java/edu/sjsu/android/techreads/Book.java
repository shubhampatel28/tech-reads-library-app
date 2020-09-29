package edu.sjsu.android.techreads;

import java.util.ArrayList;

public class Book {

    /**
     * Name of the  book
     */
    private String bookTitle;

    /**
     * Name of the  book
     */
    private String bookAuthor;

    /**
     * Image of the book
     */
    private int imageResourceID;

    private String bookDesc;
    private float numStars;

    public Book(String bookTitle, String bookAuthor, int imageResourceID, float numStars, String bookDesc) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.imageResourceID = imageResourceID;
        this.numStars = numStars;
        this.bookDesc = bookDesc;
    }

    /**
     * Get the title of the book
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Get name of the book's author
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookImage() {
        return imageResourceID;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public float getNumStars() {
        return numStars;
    }

}
