package org.example;

import org.example.models.Book;
import org.example.models.Loan;
import org.example.models.Member;
import org.example.models.LMS;
import org.example.services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        LMS data = new LMS();

        SearchService searchService = new SearchService();
        BookService bookService = new BookService(data);
        MemberService memberService = new MemberService(data);
        LoanService loanService = new LoanService(data);
        SaveService saveService = new SaveService(data);
        ReportService reportService = new ReportService(data);
//        LoadDataService loadDataService = new LoadDataService(saveService,bookService , memberService , loanService);
        saveService.loadDatafromFile();
        while (true) {

            System.out.println("Select your action");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Lending and Returning Books");
            System.out.println("4. Report Generation");
            System.out.println("5. Search and Filter");
            System.out.println("6. Help");
            System.out.println("7. Exit");


            Scanner userInput = new Scanner(System.in);

            int operation = userInput.nextInt();
            userInput.nextLine();

            if(operation==7){
//                ArrayList<Book> bookList = bookService.getBookList();
//                LMS lms = new LMS();
//                //or
//                lms.setBookList(bookList);
////                saveService.saveBookToFile(bookList);
////
//                ArrayList<Member> memberList = memberService.getMemberList();
//                data.setMemberList(memberList);
//                saveService.saveMemberToFile(memberList);
//
//                ArrayList<Loan> loanList = loanService.getLoanList();
//                data.setLoanList(loanList);
//                saveService.saveLoanToFile(loanList);
//                saveService.saveAll(data.getBookList(), memberList, loanList);

                saveService.saveAll();
//                ...................................
//                saveService.saveAllData(bookList,memberList,loanList);
                //save in file
                break;

            }

            switch (operation) {
                case 1:
                    bookService.start();

                    break;

                case 2:
                        memberService.start();

                    break;

                case 3:
                        loanService.start();
                    break;

                case 4:
                        reportService.start();

                    break;
                case 5:

                    searchService.search(data);

                    break;
                case 6:

                    break;

                default:

                    break;


            }

        }
    }


    //save data

    //load data
    //bookService.setBooklist(booklist)
}
