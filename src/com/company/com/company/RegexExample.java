package com.company.com.company;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class RegexExample
{ 
	
	  public void comments( File file1, File file2) {
		
	    try {
			// The RE pattern
			Pattern patt = Pattern.compile("\\/\\/");
			Pattern patt1 = Pattern.compile("^\\/\\*");
			// A FileReader (see the I/O chapter)
   /*String str = "C:\\Users\\batma\\Downloads\\forlex.txt";
			String str1 = "C:\\Users\\batma\\Downloads\\testupdate3\\Bari0696876Assignment3\\AQ1.c";*/
			//String str1 = "";
   // @SuppressWarnings("resource")
			//BufferedReader r = new BufferedReader(new FileReader(str));
   // try (BufferedReader r1 = new BufferedReader(new FileReader(str1))) {
			//}
 
			//-----------------------------------------------------------------------------
			File f = file1;
			File f1 = file2;
			Scanner filescanner = new Scanner(f);
			Scanner filescanner1 = new Scanner(f1);
			
			int linenu = 0;
			int lineu1 = 0;
			while(filescanner.hasNextLine())
			{
				System.out.println(filescanner.nextLine());
				linenu++;
				
			}
			
			while(filescanner1.hasNextLine())
			{
				System.out.println(filescanner1.nextLine());
				lineu1++;
				
			}
			filescanner.close();
			filescanner1.close();
			System.out.println("lines: " + linenu);
			System.out.println("\n");
			System.out.println("lines: " + lineu1);
			
			//--------------------------------------file1-----------------------------------------
			// For each line of input, try matching in it.
			String line;
			String s1 = null;
			long total=0;
			int lcount=0;
			
			List<Pattern> listnew= new ArrayList<>();
			listnew.add(patt);
			listnew.add(patt1);
			
			int linecount=0;
			for(Pattern pattern:listnew) 
			{
			System.out.println("\npattern start\n");
			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(new FileReader(f));
			
			while ((line = r.readLine()) != null) {
				lcount+=1;
			  // For each match in the line, extract and print it.
			  Matcher m = pattern.matcher(line);
			  while (m.find()) {
				  linecount+=1;
			    // Simplest method:
			    // System.out.println(m.group(0));

			    // Get the starting position of the text
			    int start = m.start(0);
			    // Get ending position
			    //int end = m.end(0);
			    // Print whatever matched.
			    // Use CharacterIterator.substring(offset, end);
			    System.out.println("The comment Analysis for the file 1:" + file1.getName() ); 
			    s1 = line.substring(start);
			    System.out.println(s1);
			    total = line.substring(start).length();
			    System.out.println("The length of the comment " + total+ "the line number is:"+ lcount);
			  }
			  
			}
			}
			System.out.println("The total comments identified with this files: " + linecount);
  
			Connection connect3 = null;
			Statement statement3 = null;
			PreparedStatement preparedStatement3 = null;
			//private PreparedStatement preparedStatement3 = null;
			ResultSet resultSet3 = null;
				connect3 = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/demo?"
								+ "user=root&password=root");
				statement3 = connect3.createStatement();
				preparedStatement3 = connect3
						.prepareStatement("insert into  demo.com values (?, ?, ?, ?)");
				preparedStatement3.setString(1, file1.getName().concat(file2.getName()));
				preparedStatement3.setString(2, s1);
				preparedStatement3.setLong(3, total);
				preparedStatement3.setLong(4, lcount);
				preparedStatement3.executeUpdate();

				preparedStatement3 = connect3
						.prepareStatement("SELECT filename, comment, length, linenumber from demo.com");
				resultSet3 = preparedStatement3.executeQuery();
				connect3.close();
  //----------------------------------------file2---------------------------------------------------------
  //-------------------------------------------------------------------------------
			// For each line of input, try matching in it.
 /*   String line1;
			int linecount1 = 0;
			
			while ((line1 = r1.readLine()) != null) {
				
			  // For each match in the line, extract and print it.
			  Matcher m1 = patt.matcher(line1);
			  while (m1.find()) {
				  linecount1+=1;
			    // Simplest method:
			    // System.out.println(m.group(0));

			    // Get the starting position of the text
			    int start1 = m1.start(0);
			    // Get ending position
			    //int end = m.end(0);
			    // Print whatever matched.
			    // Use CharacterIterator.substring(offset, end);
			    System.out.println("The comment Analysis for the file 2:" + str1 );
			    System.out.println(line1.substring(start1));
			    long total1 = line1.substring(start1).length();
			    System.out.println("The length of the comment " + total1);
			  }
			}
			System.out.println("The total comments identified with this files: " + linecount1);*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in db");
			e.printStackTrace();
		}
	    
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	
		
	  }
	}
