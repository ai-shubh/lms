package org.example.services;

import org.example.models.Book;
import org.example.models.LMS;
import org.example.models.Loan;
import org.example.models.Member;


import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ReportService {
     Scanner userInput = new Scanner(System.in);

   LMS l;
    public ReportService(LMS l) {

        this.l = l;
    }

    public void start(){
        while (true) {

            System.out.println("Select your action");

            System.out.println("1. View Available Books");
            System.out.println("2. View Borrowed Books");
            System.out.println("3. Exit");



            int bops = userInput.nextInt();
            userInput.nextLine();

            if (bops == 3) {
                break;

            }

            switch (bops) {
                case 1:
                    viewAvailableBooks();
                    break;

                case 2:
                    viewBorrowedBooks();
                    break;
            }
        }
    }

    public void viewAvailableBooks(){

        for ( Book book: l.getBookList()){
            if(book.getStatus().equals("Available")) {
                System.out.println(book +"is Available");
            }
//            if(book.getStatus().equals("Not Available")) {
//                System.out.println(book + "not availabe");
//            }
        }
    }

    public void viewBorrowedBooks() {



        for (Loan loans : l.getLoanList()) {
            // memberid
            // bookid

            Optional<Member> memberO = l.getMemberList().stream().filter(m -> m.getMemberid() == loans.getMemberId()).findFirst();
            if (memberO.isEmpty()) {
                break;
            }

            Member member = memberO.get();


            Optional<Book> bookO = l.getBookList().stream().filter(m -> m.getISBN() == loans.getMemberId()).findFirst();
            if (bookO.isEmpty()) {
                break;
            }

            Book book = bookO.get();

            System.out.println("Member name is " +member.getName() + " and book he has borrowed is " +book.getTitle());


        }


//            for (Member member : m1.memberList){
//                break;
//            }
//
//
//            for (Book book : b1.getBookList()){
//                break;
//                if (book.getISBN() == loans.getBookId() && member.getMemberid() == loans.getMemberId()){
//                    System.out.println("Member name is " +member.getName() + " and book he has borrowed is " +book.getTitle());
//                }
//            }


//print getname
        }
    }


//
//                    for (Loan loans : l1.loanList){
//                        for (Member member : m1.memberList){
//                            for (Book book : b1.getBookList()){
//                                if (book.getISBN() == loans.getBookId() && member.getMemberid() == loans.getMemberId()){
//                                    System.out.println("Member name is " +member.getName() + " and book he has borrowed is " +book.getTitle());
//                                }
//                            }
//                    }
//                    }
//    }




