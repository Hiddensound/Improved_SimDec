package com.company.com.company;

import java.io.File;
import java.sql.*;

public class MathDistance {

	public void mathscores(File file1, File file2, String key15, double key11, double key12, double key13, double key14,double key16) {
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
					.prepareStatement("insert into  demo.math_distance values (?, ?, ?, ?, ?, ? , ?)");
			preparedStatement5.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement5.setDouble(2, key11);
			preparedStatement5.setDouble(3, key12);
			preparedStatement5.setDouble(4, key13);
			preparedStatement5.setDouble(5, key14);
			preparedStatement5.setString(6, key15);
			preparedStatement5.setDouble(7, key16);
			preparedStatement5.executeUpdate();

			preparedStatement5 = connect5
					.prepareStatement("SELECT filenames, math_lev, math_jaro, math_jarow, math_dice, math_lcb, math_lcblength from demo.math_distance");
			resultSet5 = preparedStatement5.executeQuery();
			connect5.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


