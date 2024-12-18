package org.example.models;

import java.time.LocalDate;

public class Loan {
    @Override
    public String toString() {
        return "Loan{" +
                "memberId=" + memberId +
                ", bookId=" + bookId +
                ", dueDate=" + dueDate +
                '}';
    }

    private int memberId;
    private int bookId;
    private LocalDate dueDate;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

//    public LocalDate getDueDate() {
//        return dueDate;
//    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
