package com.company.com.company;

import java.io.File;
import java.sql.*;

public class IdentScore {

    public void identifierscore(File file1, File file2, String keyid15, double keyid11, double keyid12, double keyid13, double keyid14, double keyid16) {
        // TODO Auto-generated method stub
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
                    .prepareStatement("insert into  demo.identifier_score values (?, ?, ?, ?, ?, ? , ?)");
            preparedStatement4.setString(1, file1.getName().concat(file2.getName()));
            preparedStatement4.setDouble(2, keyid11);
            preparedStatement4.setDouble(3, keyid12);
            preparedStatement4.setDouble(4, keyid13);
            preparedStatement4.setDouble(5, keyid14);
            preparedStatement4.setString(6, keyid15);
            preparedStatement4.setDouble(7, keyid16);
            preparedStatement4.executeUpdate();

            preparedStatement4 = connect4
                    .prepareStatement("SELECT filenames, iden_lev, iden_jaro, iden_jarowink, iden_dice, iden_lcb, iden_lcb_length from demo.identifier_score");
            resultSet4 = preparedStatement4.executeQuery();
            connect4.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error in db");
            e.printStackTrace();
        }
    }
}

