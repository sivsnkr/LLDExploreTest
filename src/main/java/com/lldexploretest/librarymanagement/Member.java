package com.lldexploretest.librarymanagement;

public class Member extends User {

    private int bookCount = 0;

    private static final int MEMBER_BOOK_LIMIT = 5;

    public Member(String name, String email) {
        super(name, email);
    }

    public void borrowBook() {
        if(bookCount < MEMBER_BOOK_LIMIT) {
            bookCount++;
            System.out.println("Book borrowed successfully by : " + super.getUserId());
        }else {
            System.out.println("Cannot borrow more than " + MEMBER_BOOK_LIMIT + " books");
        }
    }

    public void returnBook() {
        if(bookCount > 0) {
            bookCount--;
            System.out.println("Book returned successfully by : " + super.getUserId());
        }else {
            System.out.println("No books to return");
        }
    }

    public boolean canBorrow() {
        return bookCount < MEMBER_BOOK_LIMIT;
    }
}
