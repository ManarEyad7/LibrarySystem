/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Library {

    // Create an ArrayList to hold Book objects. 
    public ArrayList<Book> storge;

    /**
     * no-argument constructor
     */
    public Library() {
        storge = new ArrayList<>();
    }
    /**
     * The addBook methhod allows to add a Book object in arraylist storge
     *
     * @param b
     * @return
     */
    public Book addBook(Book b) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("\t\tThe title of book:");
        b.setTitle(keyboard.nextLine());
        System.out.print("\t\tThe author of book:");
        b.setAuthor(keyboard.nextLine());
        System.out.print("\t\tThe price of book:");
        b.setQuantity(keyboard.nextInt());
        b.setPrice(keyboard.nextFloat());
        System.out.print("\t\tThe quantity of book:");

        storge.add(b);
        return b;
    }

    /**
     * The deleteBook method allows to delete a specific book by isbn from the
     * arrayList
     *
     * @param Id The isbn / number of book
     */
    public void deleteBook(String Id) {

        if (storge.removeIf(e -> e.getBookNumber().replaceAll("\\s+", "").equalsIgnoreCase(Id))) {
            System.out.println("The book has been deleted");
        } else {
            System.out.println("Deletion failed");
        }

    }

    /**
     * toString method
     *
     * @return Information about All books stored in ArrayList.
     */
    @Override
    public String toString() {
        String results = "";
        for (int i = 0; i < storge.size(); i++) {
            Book b = storge.get(i);
            results += b.toString() + "\n";
        }
        return results;
    }

    /**
     * The find method find a specific book by title,author name, then
     * determines in any index
     *
     * @param nameBook Title of book
     * @param AuthorName Author name
     * @return The number of index
     */
    public int find(String nameBook, String AuthorName) {
        int index = -1;
        for (int i = 0; i < storge.size(); i++) {

            if (nameBook.replaceAll("\\s+", "").equalsIgnoreCase(storge.get(i).getTitle().replaceAll("\\s+", ""))
                    && AuthorName.replaceAll("\\s+", "").equalsIgnoreCase(storge.get(i).getAuthor().replaceAll("\\s+", ""))) {
                index = i;
                break;

            }

        }

        return index;
    }

    /**
     * This Search method takes two argment the title of book and the athour
     * name, then search for the book object.
     *
     * @param nameBook The title
     * @param AuthorName the Author name
     */
    public void Search(String nameBook, String AuthorName) {
        String format = "";
        for (int i = 0; i < storge.size(); i++) {

            if (nameBook.replaceAll("\\s+", "").equalsIgnoreCase(storge.get(i).getTitle().replaceAll("\\s+", ""))
                    && AuthorName.replaceAll("\\s+", "").equalsIgnoreCase(storge.get(i).getAuthor().replaceAll("\\s+", ""))) {
                format = "This book exists in the library!\n";
                format += storge.get(i);
                break;

            } else {
                format = "Sorry this book not found.";

            }

        }
        System.out.print(format + "\n");

    }

    /**
     * The Search method takes a number of book as argument, then searches for
     * it in arraylist
     *
     * @param numOfBook The number of book
     */
    public void Search(String numOfBook) {
        String format1 = null;
        for (int i = 0; i < storge.size(); i++) {
            if (numOfBook.replaceAll("\\s+", "").equalsIgnoreCase(storge.get(i).getBookNumber().replaceAll("\\s+", ""))) {
                format1 = "The book with the Isbn " + numOfBook + " exists in the library!\n";
                format1 += storge.get(i).toString();
                break;
            } else {
                format1 = "This book not found.";
            }
        }
        System.out.print(format1 + "\n");
    }

}
