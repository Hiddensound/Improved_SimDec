package com.company.com.company;

import java.sql.*;

public class Maxmin {

    public void maxminscore()
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
            String query = "SELECT filenames, keywordscore, identifierscore, mathscore, numscore, logscore, otheropscore from demo.avgscores WHERE avgscore > 0.85";
            ResultSet rs = statement4.executeQuery(query);
            while (rs.next())
            {
                System.out.println("filenames : " + rs.getString(1));
                System.out.println("keywordscore :" + rs.getString(2));
                System.out.println("identifierscore :" + rs.getString(3));
                System.out.println("mathscore :" + rs.getString(4));
                System.out.println("numscore :" + rs.getString(5));
                System.out.println("logscore :" + rs.getString(6));
                System.out.println("otheropscore :" + rs.getString(7));
            }

            connect4.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error in db");
            e.printStackTrace();
        }

    }
}


