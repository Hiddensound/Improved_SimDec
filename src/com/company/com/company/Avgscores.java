package com.company.com.company;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Avgscores {
	
	public void avg(File file1, File file2,  double keyw1, double keyident, double keym2, double keyn3, double keylog4, double keyop6, double avgs) {

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
					.prepareStatement("insert into  demo.avgscores values (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement4.setString(1, file1.getName().concat(file2.getName()));
			preparedStatement4.setDouble(2, keyw1);
			preparedStatement4.setDouble(3, keyident);
			preparedStatement4.setDouble(4, keym2);
			preparedStatement4.setDouble(5, keyn3);
			preparedStatement4.setDouble(6, keylog4);
			preparedStatement4.setDouble(7, keyop6);
			preparedStatement4.setDouble(8, avgs);
			preparedStatement4.executeUpdate();

			preparedStatement4 = connect4
					.prepareStatement("SELECT filenames, keywordscore, identifierscore,  mathscore, numscore, logscore, otheropscore, avgscore from demo.avgscores");
			resultSet4 = preparedStatement4.executeQuery();
			connect4.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	
	
	}
}
