package com.company.dao;

import com.company.entities.Book;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public String getDbConnection() throws ClassNotFoundException ,SQLException
    {
       return "ok";

    }
    public boolean addBook(Book book) {

        String insert = "INSERT INTO" + Const.BOOK_TABLE + "(" + Const.BOOK_ID + ","
                + Const.BOOK_NAME + "," + Const.BOOK_AUTHOR + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement prepStmt = getDbConnection().prepareStatement(insert);
            prepStmt.setString(1, String.valueOf(book.getId()));
            prepStmt.setString(2, book.getName());
            prepStmt.setString(3, book.getAuthor());

            prepStmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
       return false;
    }

    public boolean deleteBook(int id) {

        String delete = " DELETE FROM " + Const.BOOK_TABLE + "WHERE"
                +Const.BOOK_ID +"=?";
boolean success=false;

        try {
            PreparedStatement prepStmt = getDbConnection().prepareStatement(delete);
            prepStmt.setString(1, String.valueOf(id));


            prepStmt.executeUpdate();

            success= true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();

        }
        return success;
    }

    public ResultSet getBook(int id) {


        ResultSet resultSet=null;
        String select ="Select * FROM"+Const.BOOK_TABLE+ "WHERE"
                +Const.BOOK_ID +"=?";


        try {
            PreparedStatement prepStmt = getDbConnection().prepareStatement(select);
            prepStmt.setString(1, String.valueOf(id));

           resultSet= prepStmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return  resultSet;
    }

    public ResultSet getAllBook( ) {

        ResultSet resultSet=null;
        String select ="Select * FROM "+Const.BOOK_TABLE;

        try {
            PreparedStatement prepStmt = getDbConnection().prepareStatement(select);


            resultSet= prepStmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

}
