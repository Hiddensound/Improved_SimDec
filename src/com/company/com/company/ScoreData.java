package com.company.com.company;

import java.io.File;
import java.sql.*;

public class ScoreData {

	public void scores(File file1, File file2, String key5, double key1, double key2, double key3, double key4,double key6) {
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
					.prepareStatement("insert into  demo.distance values (?, ?, ?, ?, ?, ? , ?)");
			preparedStatement4.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement4.setDouble(2, key1);
			preparedStatement4.setDouble(3, key2);
			preparedStatement4.setDouble(4, key3);
			preparedStatement4.setDouble(5, key4);
			preparedStatement4.setString(6, key5);
			preparedStatement4.setDouble(7, key6);
			preparedStatement4.executeUpdate();

			preparedStatement4 = connect4
					.prepareStatement("SELECT filenames, keyword_lev, jaro_dis, jaro_wink, dice, longest_sub, lcb_length from demo.distance");
			resultSet4 = preparedStatement4.executeQuery();
			connect4.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


