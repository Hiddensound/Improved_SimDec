package com.company.com.company;

import java.io.File;
import java.sql.*;

public class FinalfileDistance  {

	public void finalfilescore(File file1, File file2, String fint1, String fint2, double fin1, double fin2, double fin3, double fin4, String fin5, double fin6) {
		// TODO Auto-generated method stub
		Connection connect7 = null;
		Statement statement7 = null;

		//private Statement statement1 = null;
		PreparedStatement preparedStatement7 = null;
		//private PreparedStatement preparedStatement1 = null;
		ResultSet resultSet7 = null;

		
		try {
			connect7 = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/demo?"
							+ "user=root&password=");
			statement7 = connect7.createStatement();
			preparedStatement7 = connect7
					.prepareStatement("insert into  demo.finalfile_distance values (?, ?, ?, ?, ?, ? , ?, ?, ?)");
			preparedStatement7.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement7.setString(2, fint1);
			preparedStatement7.setString(3, fint2);
			preparedStatement7.setDouble(4, fin1);
			preparedStatement7.setDouble(5, fin2);
			preparedStatement7.setDouble(6, fin3);
			preparedStatement7.setDouble(7, fin4);
			preparedStatement7.setString(8, fin5);
			preparedStatement7.setDouble(9, fin6);
			preparedStatement7.executeUpdate();

			preparedStatement7 = connect7
					.prepareStatement("SELECT filenames, filestr1, filestr2, final_lev, final_jaro, final_jarow, final_dice, final_lcb, final_lcblength from demo.finalfile_distance");
			resultSet7 = preparedStatement7.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	}
}


