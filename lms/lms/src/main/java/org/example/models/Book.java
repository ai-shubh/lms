package org.example.models;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    //    title, author,publication year, genre, and ISBN.

    private int ISBN;
    private String title;
    private String author;
    private int publicationyear;
    private String genre;

    private String status;


//    static String books;
    public Book(int ISBN, String title, String author, int publicationyear, String genre, String status) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.genre = genre;
        this.status= status;

    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationyear=" + publicationyear +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationyear(int publicationyear) {
        this.publicationyear = publicationyear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationyear() {
        return publicationyear;
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }


}


