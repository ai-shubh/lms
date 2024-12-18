package org.example.models;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {

        //name, member ID, and contact information.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    private String name;
        private int memberid;
        private int contact;

        public Member( String name,  int memberid, int contact) {
            this.name= name;
            this.memberid = memberid;
            this.contact= contact;

        }

        public String toString() {
            return "name: " + name + ", memberid: " + memberid + ", Contact: " + contact ;
        }


    }

