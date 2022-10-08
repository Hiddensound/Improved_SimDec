package com.company.com.company;

import java.sql.*;

public class Update {

    public void updatetable()
    {
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
            String query = "UPDATE demo.webtable SET plagiarism = 'High' WHERE avgscores > 0.88";
            String query1 = "UPDATE demo.webtable SET plagiarism = 'Average' WHERE avgscores BETWEEN '0.70' AND '0.88'";
            String query2 = "UPDATE demo.webtable SET plagiarism = 'Low' WHERE avgscores < 0.70";
            statement4.executeUpdate(query);
            statement4.executeUpdate(query1);
            statement4.executeUpdate(query2);
            connect4.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error in db");
            e.printStackTrace();
        }

    }
}


