package com.lldexploretest.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<ILendable> lendables = new ArrayList<>();

        Librarian librarian = new Librarian("Shiv", "shiv");
        Member member = new Member("Shiv", "Shiv");

        NovelBook novelBook = new NovelBook("The Hobbit", "James cameron");
        TextBook textBook = new TextBook("The Hobbit", "James cameron");

        books.add(novelBook);
        books.add(textBook);

        lendables.add(textBook);

        users.add(member);
        users.add(librarian);

        User shiv = users.get(1);
        lendables.getFirst().borrowBook();
        member.borrowBook();
        lendables.getFirst().returnBook();
        member.returnBook();

        Book hobbitBook = getBookByTitle(books, "The Hobbit");
        System.out.println("Title: " + hobbitBook.getTitle() + ", Author: " + hobbitBook.getAuthor());
    }

    public static Book getBookByTitle(List<Book> books, String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }
}
