package com.company;

import com.company.entities.Book;
import com.company.services.BookService;

public class Main {

    public static void main(String[] args) {

        BookService bookService = new BookService();
        Book book = new Book(100,"lerning java","K. Horstman");
        bookService.addBook(book);
        bookService.getAllBook();
        bookService.getBook(100);
        bookService.deleteBook(100);
    }
}
