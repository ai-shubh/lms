package org.example.services;

import org.example.models.Book;
import org.example.models.LMS;
import org.example.models.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {
    Scanner userInput = new Scanner(System.in);
//    private ArrayList<Member> s.getMemberList = new ArrayList<>();

    LMS s;
    public MemberService(LMS s) {
        this.s = s;
    }

//
//    public ArrayList<Member> getMemberList() {
//        return s.getMemberList;
//    }
//
//    public void setMemberList(ArrayList<Member> memberList) {
//        this.memberList = memberList;


    public void start(){
        while (true) {

            System.out.println("Select your action");

            System.out.println("1. Add Member");
            System.out.println("2. View Member");
            System.out.println("3. Search Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Exit");



            int mops = userInput.nextInt();
            userInput.nextLine();

            if (mops == 5) {
                break;

            }

            switch (mops) {
                case 1:
                    addMember();
                    break;

                case 2:
                    viewMember();
                    break;

                case 3:
                    searchMember();
                    break;

                case 4:
                    removeMem();

                default:

                    break;


            }
        }
    }

//    public void saveBookData(ArrayList<Member> member){
//
//        Gson gson = new Gson();
//
//        try (FileWriter writer = new FileWriter(filename+".txt",false)) {
//            // Convert the ArrayList of books into a JSON string
//            String jsonString = gson.toJson(member);
//
//            // Write the JSON string to a file
//            writer.write(jsonString);
//            System.out.println("Successfully wrote books data to the file.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void addMember(){
        System.out.println("Add name of Member");
        String name = userInput.nextLine();
        System.out.println("Add ID of member");
        int memberid = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Add Contact");
        int contact = userInput.nextInt();
        userInput.nextLine();


        Member newMember = new Member(name , memberid, contact);
        s.getMemberList().add(newMember);

//        s.saveMemberToFile(memberList);

        System.out.println("Member " + name  + " added sucessfully");


    }


    public void viewMember(){


        for (int i = 0; i < s.getMemberList().size(); i++) {
            System.out.println("Member" + s.getMemberList().get(i));
        }
    }

    public void searchMember(){
        System.out.println("Enter member name or id or contact ");
        String search =userInput.nextLine();
        boolean found= false;

        for(int i=0 ; i < s.getMemberList().size(); i++) {
            if (s.getMemberList().get(i).toString().contains(search)) {
                System.out.println("Member is available in " + i + "index ");
                found = true;
            }
        }
        if (found==false){
            System.out.println("Member not found");
        }

    }

    public void removeMem(){
        System.out.println("Enter member name");
        String del =userInput.nextLine();

        for(int i=0 ; i < s.getMemberList().size(); i++) {
            if (s.getMemberList().get(i).toString().contains(del)) {
                s.getMemberList().remove(i);
                System.out.println("Member is available in " + i + "index ");

            }
        }
    }
}


