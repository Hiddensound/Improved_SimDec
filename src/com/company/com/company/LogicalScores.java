package com.company.com.company;

import java.io.File;
import java.sql.*;

public class LogicalScores  {

	public void logicalscores(File file1, File file2, String key1115, double key1111, double key1112, double key1113, double key1114,double key1116) {
		// TODO Auto-generated method stub
		Connection connect5 = null;
		Statement statement5 = null;

		//private Statement statement1 = null;
		PreparedStatement preparedStatement5 = null;
		//private PreparedStatement preparedStatement1 = null;
		ResultSet resultSet5 = null;

		
		try {
			connect5 = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/demo?"
							+ "user=root&password=");
			statement5 = connect5.createStatement();
			preparedStatement5 = connect5
					.prepareStatement("insert into  demo.logical_distance values (?, ?, ?, ?, ?, ? , ?)");
			preparedStatement5.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement5.setDouble(2, key1111);
			preparedStatement5.setDouble(3, key1112);
			preparedStatement5.setDouble(4, key1113);
			preparedStatement5.setDouble(5, key1114);
			preparedStatement5.setString(6, key1115);
			preparedStatement5.setDouble(7, key1116);
			preparedStatement5.executeUpdate();

			preparedStatement5 = connect5
					.prepareStatement("SELECT filenames, logical_lev, logical_jaro, logical_jarow, logical_dice, logical_lcb, logical_lcblength from demo.logical_distance");
			resultSet5 = preparedStatement5.executeQuery();
			connect5.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


