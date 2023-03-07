/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * This program demonstrates the Book , Library , and Processes classes. It is a
 * library system that allows students to search in different ways for a
 * specific book and borrow books, and it allows to the librarian to add and
 * delete books, also to show all books in the library store
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int options; // For User's options input
        int choice; // For User's choice input

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Open the file 
        File file = new File("Archives.txt");
        Scanner inputFile = new Scanner(file);

        // Create an instance of the FileWriter class to append data.
        // Create a PrintWriter object to write data to the Archives file
        FileWriter fwriter = new FileWriter("Archives.txt", true);
        PrintWriter outputFile = new PrintWriter(fwriter);
       
        // Opent anthor file to print infrmation of student
        FileWriter returnBoroww = new FileWriter("Students.txt", true);
        PrintWriter reading = new PrintWriter(returnBoroww);

        // Create an instance of the Book class 
        Book book = new Book();

        // Create an instance of the Library class 
        Library library = new Library();

        // Create an instance of the Processes class with book and library object.
        Processes processes = new Processes(book, library);

        // Read the Archives file 
        //Reading each line as one Book object, then add each Book in the library 
        while (inputFile.hasNext()) {

            Book bookInstorge = new Book();
            String str = inputFile.nextLine();
            String[] num = str.split("[|]");

            bookInstorge.setBookNumber(num[0]);
            bookInstorge.setTitle(num[1]);
            bookInstorge.setAuthor(num[2]);
            bookInstorge.setPrice(Float.parseFloat(num[3]));
            bookInstorge.setQuantity(Integer.parseInt(num[4]));

            library.storge.add(bookInstorge);
        }

        // Close the file.
        inputFile.close();
        
        // Prompt user to the program and displaying the menu 
        menu();
        // Prompt user to enter the choice
        System.out.print("\t\tEnter the choice: ");
        options = keyboard.nextInt();

        //  Validate the number entered
        while (options != 1 && options != 2 && options != 3) {
            menu();
            // Prompt user to enter the choice
            System.out.print("\t\tEnter the choice: ");
            options = keyboard.nextInt();
        }

        if (options == 1) {
            do {
                menuOfStudentServices();
                System.out.print("\t\tEnter the choice:");
                choice = keyboard.nextInt();
                // Consume the remaining newline character.
                keyboard.nextLine();
                switch (choice) {
                    case 1:

                        System.out.print("\t\tEnter isbn to search:");
                        String isbnNum = keyboard.nextLine();
                        System.out.println("------------------------------------"
                                + "---------------------------------------");
                        library.Search(isbnNum);
                        break;
                    case 2:

                        System.out.print("\t\tEnter Title Name: ");
                        String nameBook;
                        nameBook = keyboard.nextLine();
                        System.out.print("\t\tEnter Author Name: ");
                        String name3 = keyboard.nextLine();
                        System.out.println("------------------------------------"
                                + "---------------------------------------");
                        library.Search(nameBook, name3);

                        break;
                    case 3:
                        Student student;
                        System.out.print("\t\tPlease Enter Your Name: ");
                        String nameStudent = keyboard.nextLine();
                        System.out.print("\t\tPlease Enter Your Phone Number: ");
                        String phoneNumber = keyboard.nextLine();
                        // Create an instance of the Student class.
                        student = new Student(nameStudent, phoneNumber);
                        System.out.println("-----------------------------Book Information------------------------------");
                        System.out.print("\t\tEnter Title Name:");
                        String h = keyboard.nextLine();
                        System.out.print("\t\tEnter Author Name:");
                        String b = keyboard.nextLine();
                        Book sbook;// = new Book();
                        sbook = processes.borrowbook(h, b);

                        if (sbook.getTitle() != null) {
                            System.out.println("===========================================================================");
                            System.out.println("This book with title : " + sbook.getTitle() + "\tAuthor : "
                                    + sbook.getAuthor() + "\n\t\t\tis avlible to borrow.");

                            String format = "------------------------Book Borrow Information ------------------------\n";
                            format += "Name of Student : " + student.getNameStudent()
                                    + "\t\tThe phone Number : " + student.getPhoneNumber()
                                    + "\nThe Book Title: " + sbook.getTitle()
                                    + "The Author name: " + sbook.getAuthor()
                                    + "\n\t(Hint : You should to return a book after five days.)";
                            System.out.println(format);
                            String readformat = String.format("%-15s|%15s|%-22s|%-20s|%8d|",
                                    student.getNameStudent(), student.getPhoneNumber(), sbook.getTitle(), sbook.getAuthor(),
                                    sbook.getQuantity());
                            reading.println(readformat);

                            reading.close();
                            outputFile = new PrintWriter("Archives.txt");
                            outputFile.println(library.toString());

                        }

                        break;

                    case 4:

                        reading.close();
                        outputFile.close();
                        System.exit(0);
                        break;

                }
                if (choice != 3 && choice != 2 && choice != 1 && choice != 4) {
                    System.out.println("\t\tThe user input was not correct!!\n"
                            + "\t\tThe program will exit");
                    System.exit(0);
                }
            } while (choice == 2 || choice == 1);
            outputFile.close();
            // The librarian services
        } else if (options == 2) {

            do {
                menuOfLibrarianServices();
                System.out.print("\t\tEnter the choice: ");
                choice = keyboard.nextInt();

                switch (choice) {
                    case 1:

                        book = new Book();
                        library.addBook(book);
                        outputFile.println(book.toString());
                        System.out.println("\tThe book has been added successfully");

                        break;

                    case 2:
                        keyboard.nextLine();
                        System.out.print("Enter the ISBN of book you want to delete:");
                        String removeId = keyboard.nextLine();
                        library.deleteBook(removeId);
                        outputFile = new PrintWriter("Archives.txt");
                        outputFile.println(library.toString());

                        break;

                    case 3:
                        String header = String.format("%-6s|%-25s|%-22s|%-6s|%3s\n",
                                "ISBN", "Title", "Author", "Price", "Quantity");
                        System.out.print(header + library.toString());
                        break;

                    case 4:
                        System.exit(0);
                        break;

                }
                outputFile.close();
            } while (choice == 3 || choice == 2 || choice == 1);

        }

    }

    /**
     * The menu method displays a menu .
     */
    public static void menu() {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\t\tWelcome to the Library System");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\t\tEnter \"1\"  For Student Services.\n"
                + "\t\tEnter \"2\"  For librarian services.\n"
                + "\t\tEnter \"3\"  For exiting the program.");
    }

    /**
     * The menuOfStudentServices method displays menu Of Students Services.
     */
    public static void menuOfStudentServices() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\t\tEnter \"1\" To Search for a Book(by ISBN).\n"
                + "\t\tEnter \"2\" To Search for a Book(by Name of Book and Athour).\n"
                + "\t\tEnter \"3\" To Borrow a Book.\n"
                + "\t\tEnter \"4\" To Exit from the Program.\n");
    }

    /**
     * The menuOfLibrarianServices method displays menu Of Librarian Services.
     */
    public static void menuOfLibrarianServices() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\t\tEnter \"1\" To Add a Book.\n"
                + "\t\tEnter \"2\" To Delete a Book.\n"
                + "\t\tEnter \"3\" To Show all Books.\n"
                + "\t\tEnter \"4\" To Exit from the Program.\n");
    }

}
