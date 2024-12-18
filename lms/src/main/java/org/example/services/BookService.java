package org.example.services;

import com.google.gson.Gson;
import org.example.models.Book;
import org.example.models.LMS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {

    Scanner userInput = new Scanner(System.in);
//    private ArrayList<Book> bookList = new ArrayList<>();
//    SaveService s;
//
    LMS l;
    public BookService(LMS l) {
        this.l = l;
    }
//
//    public ArrayList<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList( ArrayList<Book> bookList) {
//
//        this.bookList = bookList;
//    }

    public void start(){
        while (true) {

            System.out.println("Select your action");

            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");



            int bops = userInput.nextInt();
            userInput.nextLine();

            if (bops == 5) {
                break;

            }

            switch (bops) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    removeBook();

                default:

                    break;


            }
        }
    }


    public void addBook(){
        System.out.println("Add ISBN of the book");
        int ISBN = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Add title of the book");
        String title = userInput.nextLine();
        System.out.println("Add author of the book");
        String author = userInput.nextLine();
        System.out.println("Add publication year");
        int publicationyear = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Add genre of the book");
        String genre = userInput.nextLine();
        System.out.println("Setting status as available by default");
        String status = "Availabe";




        Book newBook = new Book(ISBN, title, author, publicationyear, genre, status);
//        bookList.add(newBook);
        l.getBookList().add(newBook);
//        System.out.println(l.getBookList().get(l.getBookList().size() - 1));
        System.out.println("Book " + title + " added sucessfully");

//        s.saveBookToFile(bookList);

    }

    public void viewBook(){


        for (int i = 0; i < l.getBookList().size(); i++) {
            System.out.println("Book " + l.getBookList().get(i).getTitle());
        }
    }

//    private String get(String title) {

//        return title;..........get(title)
//    }

    public void searchBook(){
        System.out.println("Enter title or author name of book ");
        String search =userInput.nextLine();
        boolean found= false;

        for(int i=0 ; i < l.getBookList().size(); i++) {
            if (l.getBookList().get(i).toString().contains(search)) {
                System.out.println("Book is available in " + i + "index ");
                found = true;
            }
        }
        if (found==false){
            System.out.println("Book not found");
        }

    }

    public void removeBook(){
        System.out.println("Enter title or author name of book you want to remove");
        String del =userInput.nextLine();

        for(int i=0 ; i < l.getBookList().size(); i++) {
            if (l.getBookList().get(i).toString().contains(del)) {
                l.getBookList().remove(i);
                System.out.println("Book is available in " + i + "index ");

            }
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : l.getBookList()) {
            if (book.getISBN() == bookId) {
                return book;
            }
        }
        return null; // If no book with the given ID is found
    }


}
