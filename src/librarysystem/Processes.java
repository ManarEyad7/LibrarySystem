/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.Scanner;

/**
 * The Processes class This class performs the processes that the student needs,
 * such as borrowing and returning the book.
 */
public class Processes {

    Library BorrowReturn;
    Book BorrowReturnBook;

    /**
     * constructor with two arguments
     *
     * @param Object1
     * @param Object2
     */
    public Processes(Book Object1, Library Object2) {

        BorrowReturnBook = Object1;
        BorrowReturn = Object2;
    }

    /**
     * * The borrowbook method takes the Title,author name as argument to
     * allows to student for borrowing a book.
     *
     * @param nameBook
     * @param nameathor
     * @return The Book object after update quantity
     */
    public Book borrowbook(String nameBook, String nameathor) {
        int f = BorrowReturn.find(nameBook, nameathor);
        if (f != -1) {
            if (BorrowReturn.storge.get(f).getQuantity() > 0) {
                int n = BorrowReturn.storge.get(f).getQuantity() - 1;
                BorrowReturn.storge.get(f).setQuantity(n);
                BorrowReturnBook.setBookNumber(BorrowReturn.storge.get(f).getBookNumber());
                BorrowReturnBook.setTitle(BorrowReturn.storge.get(f).getTitle());
                BorrowReturnBook.setAuthor(BorrowReturn.storge.get(f).getAuthor());
                BorrowReturnBook.setQuantity(BorrowReturn.storge.get(f).getQuantity());
                BorrowReturnBook.setPrice(BorrowReturn.storge.get(f).getPrice());

            }
        } else {
            System.out.println("\t\tThis book with title : " + nameBook + "\t Author : "
                    + nameathor + "\n\t\tis NOT avlible to borrow.");

        }
        return BorrowReturnBook;
    }

    /**
     * The returnbook method allows to return the book that has been borrow it.
     */
    public void returnbook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The name of book");
        String nameBook = scan.nextLine();
        System.out.println("Enter The name of author");
        String nameathor = scan.nextLine();
        int f = BorrowReturn.find(nameBook, nameathor);
        if (f != -1) {

            int n = BorrowReturn.storge.get(f).getQuantity() + 1;
            BorrowReturn.storge.get(f).setQuantity(n);
            System.out.println("The book was returned successfully"
                    + BorrowReturn.storge.get(f).getQuantity());

        } else {
            System.out.println("The return book process did not complete successfully");
        }

    }

}
