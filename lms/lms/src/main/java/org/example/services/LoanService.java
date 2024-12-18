package org.example.services;
import org.example.models.LMS;
import org.example.services.BookService;
import org.example.models.Loan;

import org.example.models.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class LoanService {

    static Scanner userInput = new Scanner(System.in);

//    public ArrayList<Loan> getLoanList() {
//        return loanList;
//    }
//
//    public void setLoanList(ArrayList<Loan> loanList) {
//        this.loanList = loanList;
//    }
//
//    private ArrayList<Loan> loanList = new ArrayList<>();
//    SaveService s;

    LMS l ;

    public LoanService(LMS l) {
        this.l = l;
//        this.s = s;

    }

public void start(){
    while (true) {

        System.out.println("Select your action");

        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. Late Book");

        System.out.println("4. Exit");



        int bops = userInput.nextInt();
        userInput.nextLine();

        if (bops == 4) {
            break;

        }

        switch (bops) {
            case 1:
                borrowBook();
                break;

            case 2:
                returnBook();
                break;
            case 3:
                lateReturn();
                break;
        }
    }
    }
    public void borrowBook(){



        System.out.println("ID of Member");
        int memberId =userInput.nextInt();
        userInput.nextLine();

//            System.out.println("Name of Member");
//            String bmember =userInput.nextLine();

        System.out.println("Id of book");
        int bookId =userInput.nextInt();
        userInput.nextLine();

//       imp boolean bookfound=false;
//        for (Book books : b1.getBookList()){
//        bookfound = true;
//        if ( bookId==books.getISBN()){
//            if ((books.getStatus().equals("Available"))){
//                 continue;
//            }
//            else{
//                System.out.println("Book Not Available");
//                break;
//
//        }
//        }
//        if(!bookfound){
//            System.out.println("Book not found");
//
//        }

//            System.out.println("Book you want to borrow");
//            String bbook =userInput.nextLine();

        Book bookfound = null;
        for (Book books : l.getBookList()){
            if ( bookId==books.getISBN()) {
                bookfound = books;
                break;
            }
        }
        if(bookfound == null){
            System.out.println("Book not found");

        }

        if (!bookfound.getStatus().equals("Available")) {
            System.out.println("Book Not Available");
        }

        //            System.out.println("Book you want to borrow");
        //            String bbook =userInput.nextLine();


        System.out.println("Enter due date (yyyy-MM-dd):");
        String duedate = userInput.nextLine();

        try {
            // Parse the date using DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(duedate, formatter);
            System.out.println("You entered the date: " + date);

            Loan loan = new Loan();
            loan.setMemberId(memberId);
            loan.setBookId(bookId);
            loan.setDueDate(date);
            l.getLoanList().add(loan);

            bookfound.setStatus("Not Available");
//
//            s.saveLoanToFile(loanList);
//            s.saveBookToFile(b1.getBookList());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
//b1.updateBookToNotAvailable(bookfound)
// booklist.get(i).set(bookfound)
//        imp for (Loan loans : loanList) {
//            for ( Book book: b1.getBookList()){
//                if(loans.getBookId()== book.getISBN()){
//                     book.setStatus("Not Availabe");
//        }}}




    }

    public void returnBook(){

        System.out.println("ID of Member");
        int memberId =userInput.nextInt();
        userInput.nextLine();

//            System.out.println("Name of Member");
//            String bmember =userInput.nextLine();

        System.out.println("Id of book");
        int bookId =userInput.nextInt();
        userInput.nextLine();

//            System.out.println("Book you want to borrow");
//            String bbook =userInput.nextLine();

        System.out.println("Enter due date");
       try{
           String duedate =userInput.nextLine();
        LocalDate date = LocalDate.parse(duedate);
        System.out.println("You entered the date: " + date);
       }
        catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }



            for ( Book book: l.getBookList()) {
                if (bookId == book.getISBN()) {
                    book.setStatus("Available");



            }
        }
    }

     public void lateReturn () {
//         ReportService j=new ReportService();

//             for (Loan loan : getLoanList()) {
//                 if (loan.getDueDate().isAfter(LocalDate.now())){
//                     loan.setBookFlag("Red");
////                     or
//                     Optional<Book> book = b1.getBookList().stream().filter(m -> m.getISBN() == loan.getBookId()).findFirst();
//
//                     Book booki = book.get();
//                     booki.


//                 }
//         }
    }
}
