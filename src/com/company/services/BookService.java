package com.company.services;

import com.company.dao.Const;
import com.company.dao.DatabaseHandler;
import com.company.entities.Book;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class BookService {

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public boolean addBook(Book book) {
        if (databaseHandler.addBook(book)) {
            System.out.println("book has been saved");
            return true;
        } else
            System.out.println("book hasn't been saved");
        return false;
    }

    public Book getBook(int id) {
        ResultSet resultSet = databaseHandler.getBook(id);

        Book book=null;
        try {
            while (!resultSet.next()) {

                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                 book = new Book(id, name, author);

                System.out.println(book.toString());


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        return book;
    }

    public ArrayList<Book> getAllBook()
    {
        ResultSet resultSet = databaseHandler.getAllBook();
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            while (!resultSet.next()) {

                int id=resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                Book book = new Book(id, name, author);


                System.out.println(book.toString());
                books.add(book);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public boolean deleteBook(int id)
    {
       if( databaseHandler.deleteBook(id))
       {
           System.out.println("book has been removed");
           return true;
       }
       else return false;

    }






}


