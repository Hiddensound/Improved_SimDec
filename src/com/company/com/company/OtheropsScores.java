package com.company.com.company;

import java.io.File;
import java.sql.*;

public class OtheropsScores  {

	public void otheropsscores(File file1, File file2, String key11115, double key11111, double key11112, double key11113, double key11114,double key11116) {
		// TODO Auto-generated method stub
		Connection connect6 = null;
		Statement statement6 = null;

		//private Statement statement1 = null;
		PreparedStatement preparedStatement6 = null;
		//private PreparedStatement preparedStatement1 = null;
		ResultSet resultSet6 = null;

		
		try {
			connect6 = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/demo?"
							+ "user=root&password=");
			statement6 = connect6.createStatement();
			preparedStatement6 = connect6
					.prepareStatement("insert into  demo.otherops_distance values (?, ?, ?, ?, ?, ? , ?)");
			preparedStatement6.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement6.setDouble(2, key11111);
			preparedStatement6.setDouble(3, key11112);
			preparedStatement6.setDouble(4, key11113);
			preparedStatement6.setDouble(5, key11114);
			preparedStatement6.setString(6, key11115);
			preparedStatement6.setDouble(7, key11116);
			preparedStatement6.executeUpdate();

			preparedStatement6 = connect6
					.prepareStatement("SELECT filenames, otherops_lev, otherops_jaro, otherops_jarow, otherops_dice, otherops_lcb, otherops_lcblength from demo.otherops_distance");
			resultSet6 = preparedStatement6.executeQuery();
			connect6.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


