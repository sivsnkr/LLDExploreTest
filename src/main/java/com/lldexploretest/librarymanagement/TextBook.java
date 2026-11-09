package com.lldexploretest.librarymanagement;

public class TextBook extends Book implements ILendable {

    private int availableCount = 1;

    public TextBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void borrowBook() {
        if(availableCount > 0) {
            availableCount--;
            System.out.println("Book borrowed successfully, title: " + super.getTitle() + ", author: " + super.getAuthor());
        }else {
            System.out.println("No books available");
        }
    }

    @Override
    public void returnBook() {
        if(availableCount == 0) {
            availableCount++;
            System.out.println("Book returned successfully, title: " + super.getTitle() + ", author: " + super.getAuthor());
        }else {
            System.out.println("Book already returned");
        }
    }
}
