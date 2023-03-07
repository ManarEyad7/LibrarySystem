/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;
/**
 *
 * The Book class that holds general attributes about a book 
 */
public class Book {

    private String title;                        // To hold name of book.
    private String author;                      // To hold name of book author.
    private static int isbn = 100000;           // each book has unique isbn.
    private int quantity;                      // To hold quantity of book.
    private float price;                       // To hold price of book.
    private String bookNumber;                 // To hold book number.

    /**
     * no-argument constructor
     */
    public Book() {

        title = null;
        author = null;
        price = 0;
        
        bookNumber = isbn + "";
        isbn++;
    }

    /**
     * constructor with two argument
     *
     * @param title // The book's title
     * @param author // The book's author
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        price = 0;
        bookNumber = isbn + "";
        isbn++;
    }

    /**
     * the toString method
     * @return Information about the book.
     */
    @Override
    public String toString() {
        String x = String.format("%-6s|%-25s|%-22s|%6.3f|%1d",
                bookNumber, title, author, price, quantity);
        return x;
    }

    /**
     * The setTitle method stores a value in the title field
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The setAuthor method stores a value in the author field
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    /**
     * The setPrice method stores a value in the price field
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }
    /**
     *  The setPrice method stores a value in the quantity field
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * The getTitle method
     *
     * @return the value of title field.
     */
    public String getTitle() {
        return title;
    }

    /**
     * The getAuthor method
     *
     * @return the value of author field.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * The getIsbn method
     *
     * @return the value of isbn field.
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * The getPrice method
     *
     * @return the value of price field.
     */
    public float getPrice() {
        return price;
    }
    /**
     * The getBookNumber method
     * @return he value of BookNumber field.
     */
    public String getBookNumber() {
        return bookNumber;
    }
    /**
     * The getQuantity method
     * @return the value of quantity field.
     */
    public int getQuantity() {
        return quantity;
    }

    
}
