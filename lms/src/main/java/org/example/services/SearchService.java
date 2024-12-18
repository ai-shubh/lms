package org.example.services;

import org.example.models.LMS;
import org.example.models.Member;

import java.util.Scanner;

public class SearchService {
    Scanner userInput = new Scanner(System.in);

    public void search(LMS lms){

        System.out.println("Enter title or author name of book ");
        String search =userInput.nextLine();
        boolean found= false;

        for(int i=0 ; i < lms.getBookList().size(); i++) {
            if (lms.getBookList().get(i).toString().contains(search)) {
                System.out.println("Book is available in " + lms.getBookList().get(i) + " index ");
                found = true;
            }
        }


        boolean member= false;

        for(int i=0 ; i < lms.getMemberList().size(); i++) {
            if (lms.getMemberList().get(i).toString().contains(search)) {
                System.out.println("Member is available in " + i + " index ");
                member = true;
            }
        }
        if (member==false || found== false){
            System.out.println("Member & Book not found");
        }


    }

}


