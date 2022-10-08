package com.company.com.company;

import java.io.File;
import java.sql.*;

public class NumericalScores {

	public void numericalscore(File file1, File file2, String key115, double key111, double key112, double key113, double key114,double key116) {
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
					.prepareStatement("insert into  demo.num_distance values (?, ?, ?, ?, ?, ? , ?)");
			preparedStatement4.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement4.setDouble(2, key111);
			preparedStatement4.setDouble(3, key112);
			preparedStatement4.setDouble(4, key113);
			preparedStatement4.setDouble(5, key114);
			preparedStatement4.setString(6, key115);
			preparedStatement4.setDouble(7, key116);
			preparedStatement4.executeUpdate();

			preparedStatement4 = connect4
					.prepareStatement("SELECT filenames, num_lev, num_jaro, num_jarow, num_dice, num_lcb, num_lcblength from demo.num_distance");
			resultSet4 = preparedStatement4.executeQuery();
			connect4.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


