package com.company.com.company;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Webtable {

    public void web(File file1, File file2, double avgs, double keyb) {

        Connection connect4 = null;
        Statement statement4 = null;

        //private Statement statement1 = null;
        PreparedStatement preparedStatement4 = null;
        //private PreparedStatement preparedStatement1 = null;
        ResultSet resultSet4 = null;


        try {
            connect4 = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/demo?"
                            + "user=root&password=");
            statement4 = connect4.createStatement();
            preparedStatement4 = connect4
                    .prepareStatement("insert into  demo.webtable values (?, ?, ?)");
            preparedStatement4.setString(1, file1.getName().concat(file2.getName()));
            preparedStatement4.setDouble(2, avgs);
            preparedStatement4.setDouble(3, keyb);
          //  preparedStatement4.setDouble(3, keyb);
            preparedStatement4.executeUpdate();

            preparedStatement4 = connect4
                    .prepareStatement("SELECT filenames, avgscores, plagiarism from demo.webtable");
            resultSet4 = preparedStatement4.executeQuery();
            connect4.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error in db");
            e.printStackTrace();
        }


    }
}
