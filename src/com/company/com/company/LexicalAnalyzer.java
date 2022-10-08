package com.company.com.company;

import java.io.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;


@SuppressWarnings("unused")
public class LexicalAnalyzer {

	/**
	 * @param args the command line arguments
	 * @throws java.io.FileNotFoundException
	 */
	private Connection connect = null;
	private final Connection connect1 = null;
	private Statement statement = null;
	private final Connection connect2 = null;
	private final Statement statement2 = null;

	//private Statement statement1 = null;
	private PreparedStatement preparedStatement = null;
	private final PreparedStatement preparedStatement1 = null;
	//private PreparedStatement preparedStatement1 = null;
	private ResultSet resultSet = null;
	private final ResultSet resultSet2 = null;
	// private ResultSet resultSet1 = null;

	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/demo?"
							+ "user=root&password=");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			//statement1 = connect1.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from demo.comments");
			writeResultSet(resultSet);

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect
					.prepareStatement("insert into  demo.comments values (default, ?, ?, ?, ? , ?, ?)");
			// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, "Test");
			preparedStatement.setString(2, "emailtest");
			preparedStatement.setString(3, "TestWebpage");
			preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			preparedStatement.setString(5, "TestSummary");
			preparedStatement.setString(6, "TestComment");
			preparedStatement.executeUpdate();

			resultSet = statement
					.executeQuery("select * from demo .comments");
			writeMetaData(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		//  Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {

		Connection connect1 = null;
		Statement statement1 = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet1 = null;
//===========================================================================================================================================
		//Take code input from file
		//Scanner reader = new Scanner(new File("F:\\Lakehead Subjects\\Thesis_summer_spring2020\\cfiles\\student1\\Q1.cpp"));
		//Scanner reader1 = new Scanner(new File("F:\\Lakehead Subjects\\Thesis_summer_spring2020\\cfiles\\student2\\Assignment2Question1.c"));

		//String path1 = "C:\\Users\\batma\\Downloads\\33944-38111 - Wesley D'Ipp	oliti - May 13, 2019 901 PM - D'Ippoliti - 0694648 - Assignment 2\\D'Ippoliti - 0694648 - Assignment 2";
		/*String path1 = "C:\\Users\\batma\\Downloads\\33944-38111 - Wesley D'Ippoliti - May 13, 2019 901 PM - D'Ippoliti - 0694648 - Assignment 2\\D'Ippoliti - 0694648 - Assignment 2";

		File folder1 = new File(path1);
		System.out.println(folder1.listFiles());
		List<File> filesList1 = Arrays.asList(folder1.listFiles());

		for(File f1: filesList1) {
			System.out.println(f1.getName());
			for(File f2: filesList1) {
				if(!(f1.getName().equals(f2.getName()))) {
					//System.out.println(f2.getName());*/

		//String listOfHashMaps=['']
//=======================================================================================================================================

/*		String path1 = "C:\\Users\\batma\\Downloads\\testupdate3";

		final File folder1 = new File(path1);
		List<File> filesList1 = Arrays.asList(folder1.listFiles());

		for(int y=0;y<filesList1.size();y++)
		{
			System.out.println(filesList1.get(y).getName());

		System.out.println(filesList1.get(y));
		List<File> newList1 = Arrays.asList(filesList1.get(y).listFiles());
		System.out.println(newList1);
		System.out.print(filesList1.size());


			//File f1=

			for(int i=0;i<newList1.size();i++) {
				System.out.println("\nSTART COMARISION OF ");
				System.out.println(newList1.get(i).getName());
				List<Map<String, Integer>> combinedHM = new ArrayList<>();


				for(int j=0;j<filesList1.size();j++) {

					List<File> newList = Arrays.asList(filesList1.get(j).listFiles());
					System.out.println("\nCOMPARED THE BELOW");
					System.out.println(newList1.get(i).getName());
					System.out.println(newList.get(i).getName());
					RegexExample rf=new RegexExample();
					rf.comments(newList1.get(i), newList.get(i));


			//		System.out.println(reader);
			//		System.out.println(reader1);

					Scanner reader = new Scanner(newList1.get(i));
				    Scanner reader1 = new Scanner(newList.get(i));*/
					/*Scanner reader = new Scanner(f1);
					Scanner reader1 = new Scanner(f2);
					System.out.println("============================================");
					System.out.println(f1.getName());
					System.out.println(f2.getName());
					System.out.println("============================================");*/
		//ArrayList for lexemes and HashTable for the Symbol Table

		//==================================================================================

		String path1 = "C:\\Users\\Ajinkya\\Documents\\newz1_cpp";

		File folder1 = new File(path1);
		System.out.println(folder1.listFiles());
		List<File> foldlist1 = Arrays.asList(folder1.listFiles());
		File[] filesList1 = folder1.listFiles();

		for(File f1: filesList1) {
			System.out.println(f1.getName());
			for(File f2: filesList1) {
				if(!(f1.getName().equals(f2.getName()))) {
					//System.out.println(f2.getName());

					FileInputStream reader = new FileInputStream(f1);
					FileInputStream reader1 = new FileInputStream(f2);
					System.out.println("============================================");
					System.out.println(f1.getName());
					System.out.println(f2.getName());
					System.out.println("============================================");
					ArrayList<String> lines = new ArrayList<>();
					ArrayList<String> lines1 = new ArrayList<>();
					Map<String, List<String>> symbolTable = new HashMap<String, List<String>>();
					Map<String, List<String>> symbolTable1 = new HashMap<String, List<String>>();
					//ystem.out.println("yeahhh");
					//System.out.println(f1.getName().matches("\\s$"));
					//System.out.println(f1.getName().substring(f1.getName().length() - 1));
					//System.out.println(f1.getName().endsWith("c"));

					if(f1.getName().endsWith("c") && f2.getName().endsWith("c"))
					{

						ANTLRInputStream input = new ANTLRInputStream((reader));
						ANTLRInputStream input1 = new ANTLRInputStream((reader1));
						CLexer lexer = new CLexer(input);
						CLexer lexer1 = new CLexer(input1);
						//CParser parser = new CParser(input);

						Token token = lexer.nextToken();

						while (token.getType() != CLexer.EOF) {
							//System.out.println(token.getText());
							token = lexer.nextToken();
							List<String> list = Arrays.asList(token.getText());
							lines.addAll(list);
						}

						Token token1 = lexer1.nextToken();

						while (token1.getType() != CLexer.EOF) {
							//System.out.println(token.getText());
							token1 = lexer1.nextToken();
							List<String> list1 = Arrays.asList(token1.getText());
							lines1.addAll(list1);
						}
					}
					else if(f1.getName().endsWith("cpp") && f2.getName().endsWith("cpp")) {

						ANTLRInputStream inputcpp = new ANTLRInputStream((reader));
						ANTLRInputStream input1cpp = new ANTLRInputStream((reader1));
						cpp lexer = new cpp(inputcpp);
						cpp lexer1 = new cpp(input1cpp);
						//CParser parser = new CParser(input);

						Token token = lexer.nextToken();

						while (token.getType() != cpp.EOF) {
							//System.out.println(token.getText());
							token = lexer.nextToken();
							List<String> list = Arrays.asList(token.getText());
							lines.addAll(list);
						}

						Token token1 = lexer1.nextToken();

						while (token1.getType() != cpp.EOF) {
							//System.out.println(token.getText());
							token1 = lexer1.nextToken();
							List<String> list1 = Arrays.asList(token1.getText());
							lines1.addAll(list1);
						}
					}


					//Add values from ArrayList to HashMap Key keywords
					List<String> keywords = new ArrayList<String>();
					if (lines.contains("int") || lines.contains("float") || lines.contains("if") || lines.contains("else") || lines.contains("auto") || lines.contains("struct") || lines.contains("bool") || lines.contains("break") || lines.contains("long") || lines.contains("switch") || lines.contains("case") || lines.contains("enum") ||
							lines.contains("register") || lines.contains("typedef") || lines.contains("char") || lines.contains("extern") || lines.contains("return") || lines.contains("union") || lines.contains("const") ||
							lines.contains("short") || lines.contains("unsigned") || lines.contains("continue") || lines.contains("for") || lines.contains("signed") || lines.contains("void") || lines.contains("default") || lines.contains("goto") || lines.contains("sizeof") || lines.contains("volatile") || lines.contains("do") || lines.contains("static") ||
							lines.contains("while") || lines.contains("asm") || lines.contains("this") || lines.contains("new") || lines.contains("operator") || lines.contains("throw") || lines.contains("explicit") || lines.contains("private") || lines.contains("true") || lines.contains("export") || lines.contains("protected") || lines.contains("try") ||
							lines.contains("public") || lines.contains("catch") || lines.contains("false") || lines.contains("typeid") || lines.contains("typename") || lines.contains("class") || lines.contains("union") || lines.contains("friend") || lines.contains("const_cast") || lines.contains("using") || lines.contains("virtual")
							|| lines.contains("inline") || lines.contains("delete") || lines.contains("static_cast") || lines.contains("wchar_t") || lines.contains("double") || lines.contains("mutable") || lines.contains("namespace") || lines.contains("template")) {

						if (lines.contains("int")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "int");
							//System.out.println(keyCount);
							index = lines.indexOf("int");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}

						}
						if (lines.contains("float")) {
							int index = 0;
							int intCount =Collections.frequency(lines, "float");
							index = lines.indexOf("float");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("if")) {
							int index = 0;
							int intCount =Collections.frequency(lines, "if");
							index = lines.indexOf("if");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("else")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "else");
							index = lines.indexOf("else");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("auto")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "auto");
							index = lines.indexOf("auto");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("struct")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "struct");
							index = lines.indexOf("struct");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("bool")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "bool");
							index = lines.indexOf("bool");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("break")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "break");
							index = lines.indexOf("break");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("long")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "long");
							index = lines.indexOf("long");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("switch")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "switch");
							index = lines.indexOf("switch");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("case")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "case");
							index = lines.indexOf("case");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("enum")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "enum");
							index = lines.indexOf("enum");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("register")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "register");
							index = lines.indexOf("register");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("typedef")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "typedef");
							index = lines.indexOf("typedef");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("char")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "char");
							index = lines.indexOf("char");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("extern")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "extern");
							index = lines.indexOf("extern");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("return")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "return");
							index = lines.indexOf("return");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("union")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "union");
							index = lines.indexOf("union");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("const")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "const");
							index = lines.indexOf("const");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("short")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "short");
							index = lines.indexOf("short");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("unsigned")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "unsigned");
							index = lines.indexOf("unsigned");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("continue")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "continue");
							index = lines.indexOf("continue");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("for")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "for");
							index = lines.indexOf("for");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("signed")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "signed");
							index = lines.indexOf("signed");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("void")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "void");
							index = lines.indexOf("void");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("default")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "default");
							index = lines.indexOf("default");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("goto")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "goto");
							index = lines.indexOf("goto");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}

						if (lines.contains("sizeof")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "sizeof");
							index = lines.indexOf("sizeof");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("volatile")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "volatile");
							index = lines.indexOf("volatile");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("do")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "do");
							index = lines.indexOf("do");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("static")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "static");
							index = lines.indexOf("static");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("while")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "while");
							index = lines.indexOf("while");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("asm")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "asm");
							index = lines.indexOf("asm");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("this")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "this");
							index = lines.indexOf("this");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("new")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "new");
							index = lines.indexOf("new");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("operator")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "operator");
							index = lines.indexOf("operator");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("throw")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "throw");
							index = lines.indexOf("throw");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("explicit")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "explicit");
							index = lines.indexOf("explicit");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("private")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "private");
							index = lines.indexOf("private");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("true")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "true");
							index = lines.indexOf("true");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("export")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "export");
							index = lines.indexOf("export");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("protected")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "protected");
							index = lines.indexOf("protected");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("try")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "try");
							index = lines.indexOf("try");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("public")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "public");
							index = lines.indexOf("public");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("catch")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "catch");
							index = lines.indexOf("catch");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("false")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "false");
							index = lines.indexOf("false");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("typeid")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "typeid");
							index = lines.indexOf("typeid");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("typename")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "typename");
							index = lines.indexOf("typename");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("class")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "class");
							index = lines.indexOf("class");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("union")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "union");
							index = lines.indexOf("union");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("friend")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "friend");
							index = lines.indexOf("friend");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("const_cast")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "const_cast");
							index = lines.indexOf("const_cast");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("using")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "using");
							index = lines.indexOf("using");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("virtual")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "virtual");
							index = lines.indexOf("virtual");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("inline")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "inline");
							index = lines.indexOf("inline");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("delete")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "delete");
							index = lines.indexOf("delete");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("static_cast")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "static_cast");
							index = lines.indexOf("static_cast");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("wchar_t")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "wchar_t");
							index = lines.indexOf("wchar_t");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("double")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "double");
							index = lines.indexOf("double");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("mutable")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "mutable");
							index = lines.indexOf("mutable");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("namespace")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "namespace");
							index = lines.indexOf("namespace");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
						if (lines.contains("template")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "template");
							index = lines.indexOf("template");
							for(int p=0;p<intCount;p++) {
								keywords.add(lines.get(index));
							}
						}
					}
					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Keywords", keywords);

					//Add values from ArrayList to HashMap Key keywords
					List<String> operators = new ArrayList<String>();
					if (lines.contains("=") || lines.contains("-") || lines.contains("+") || lines.contains("*") || lines.contains("/") || lines.contains("%") || lines.contains("++") || lines.contains("--")) {
						if (lines.contains("=")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "=");
							index = lines.indexOf("=");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("-")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "-");
							index = lines.indexOf("-");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("+")) {
							int index = 0;
							int intCount=Collections.frequency(lines, "+");
							index = lines.indexOf("+");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("*")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "*");
							index = lines.indexOf("*");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("/")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "/");
							index = lines.indexOf("/");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("%")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "%");
							index = lines.indexOf("%");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("++")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "++");
							index = lines.indexOf("++");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
						if (lines.contains("--")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "--");
							index = lines.indexOf("--");
							for(int p=0;p<intCount;p++) {
								operators.add(lines.get(index));
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Math Operators", operators);

					//Add values from ArrayList to HashMap Key keywords
					List<String> logical = new ArrayList<String>();
					if (lines.contains("<") || lines.contains(">") || lines.contains("<=") || lines.contains(">=") || lines.contains("==") || lines.contains("!=") || lines.contains("?")
							|| lines.contains(">>") || lines.contains("<<") || lines.contains("&&") || lines.contains("||") || lines.contains("!") || lines.contains("^") || lines.contains("~") || lines.contains("|") || lines.contains("&")) {
						if (lines.contains("<")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "<");
							index = lines.indexOf("<");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains(">")) {
							int index = 0;
							int intCount = Collections.frequency(lines, ">");
							index = lines.indexOf(">");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("<=")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "<=");
							index = lines.indexOf("<=");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains(">=")) {
							int index = 0;
							int intCount = Collections.frequency(lines, ">=");
							index = lines.indexOf(">=");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains(">>")) {
							int index = 0;
							int intCount = Collections.frequency(lines, ">>");
							index = lines.indexOf(">>");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("<<")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "<<");
							index = lines.indexOf("<<");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("&&")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "&&");
							index = lines.indexOf("&&");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("||")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "||");
							index = lines.indexOf("||");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("!")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "!");
							index = lines.indexOf("!");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("^")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "^");
							index = lines.indexOf("^");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("~")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "~");
							index = lines.indexOf("~");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("|")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "|");
							index = lines.indexOf("|");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
						if (lines.contains("&")) {
							int index = 0;
							int intCount = Collections.frequency(lines, "&");
							index = lines.indexOf("&");
							for(int p=0;p<intCount;p++) {
								logical.add(lines.get(index));
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Logical Operators", logical);

					//Convert the array list into an array
					String [] linesArray = lines.toArray(new String [0]);

					//Add values from ArrayList to HashMap Key keywords
					List<String> digits = new ArrayList<String>();
					for (int count = 0;  count < linesArray.length; count++) {
						if (linesArray[count].matches("\\d+|\\d+\\.\\d+")) {  //Use regex here for numbers
							digits.add(linesArray[count]);
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Numerical Values", digits);

					//Add values from ArrayList to HashMap Key keywords
					List<String> identifiers = new ArrayList<String>();
					for (int count = 0;  count < linesArray.length; count++) {
						if (linesArray[count].matches("\\w+|\"[A-za-z\\s:\\d]+\"") /*&& linesArray[count].matches("".+[a-zA-Z]"")*/ && !linesArray[count].matches("\\d+") && !linesArray[count].matches("int|float|if|else|auto|struct|bool|break|long|switch|case|enum|register|typedef|char|extern|return|union|const|short|unsigned|continue|for|signed|void|default|goto|sizeof|volatile|do|static|while|asm|this|new|operator|throw|explicit|private|true|export|protected|try|public|catch|false|typeid|typename|class|union|friend|const_cast|using|virtual|inline|delete|static_cast|wchar_t|double|mutable|namespace|template")) {  //Use regex here for variables
							if (!identifiers.contains(linesArray[count])) {
								identifiers.add(linesArray[count]);
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Identifiers", identifiers);

					//Add values from ArrayList to HashMap Key keywords
					List<String> others = new ArrayList<String>();
					for (int count = 0;  count < linesArray.length; count++) {
						if (linesArray[count].matches("\\(|\\)|\\{|\\}|\\[|\\]")) {  //Use regex here for variables
							if (!identifiers.contains(linesArray[count])) {
								others.add(linesArray[count]);
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable.put("Others", others);

					//Prints the ArrayList
					System.out.print("The Lexemes for file1: ");
					System.out.println(lines);
					System.out.println(lines.size());

					System.out.println();

					//Prints the Symbol Table
					for (Map.Entry<String, List<String>> entry : symbolTable.entrySet()) {
						String key = entry.getKey();
						List<String> values = entry.getValue();
						System.out.print(key + ": ");
						System.out.println(values);
					}
					System.out.println("-------------------------------------------------------------------");
					List<String> keywordsfile2 = new ArrayList<String>();
					if (lines1.contains("int") || lines1.contains("float") || lines1.contains("if") || lines1.contains("else") || lines1.contains("auto") || lines1.contains("struct") || lines1.contains("bool") || lines1.contains("break") || lines1.contains("long") || lines1.contains("switch") || lines1.contains("case") || lines1.contains("enum") ||
							lines1.contains("register") || lines1.contains("typedef") || lines1.contains("char") || lines1.contains("extern") || lines1.contains("return") || lines1.contains("union") || lines1.contains("const") ||
							lines1.contains("short") || lines1.contains("unsigned") || lines1.contains("continue") || lines1.contains("for") || lines1.contains("signed") || lines1.contains("void") || lines1.contains("default") || lines1.contains("goto") || lines1.contains("sizeof") || lines1.contains("volatile") || lines1.contains("do") || lines1.contains("static") ||
							lines1.contains("while") || lines1.contains("asm") || lines1.contains("this") || lines1.contains("new") || lines1.contains("operator") || lines1.contains("throw") || lines1.contains("explicit") || lines1.contains("private") || lines1.contains("true") || lines1.contains("export") || lines1.contains("protected") || lines1.contains("try") ||
							lines1.contains("public") || lines1.contains("catch") || lines1.contains("false") || lines1.contains("typeid") || lines1.contains("typename") || lines1.contains("class") || lines1.contains("union") || lines1.contains("friend") || lines1.contains("const_cast") || lines1.contains("using") || lines1.contains("virtual")
							|| lines1.contains("inline") || lines1.contains("delete") || lines1.contains("static_cast") || lines1.contains("wchar_t") || lines1.contains("double") || lines1.contains("mutable") || lines1.contains("namespace") || lines1.contains("template")) {
						if (lines1.contains("int")) {
							//System.out.println(lines1);
							int intCount=Collections.frequency(lines1, "int");
							int index = 0;
							index = lines1.indexOf("int");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("float")) {
							int index = 0;
							int intCount=Collections.frequency(lines1, "float");
							index = lines1.indexOf("float");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("if")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "if");
							index = lines1.indexOf("if");
							for(int p=0;p<intCount;p++ ) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("else")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "else");
							index = lines1.indexOf("else");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}

						if (lines1.contains("auto")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "auto");
							index = lines1.indexOf("auto");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("struct")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "struct");
							index = lines1.indexOf("struct");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("bool")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "bool");
							index = lines1.indexOf("bool");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("break")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "break");
							index = lines1.indexOf("break");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("long")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "long");
							index = lines1.indexOf("long");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("switch")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "switch");
							index = lines1.indexOf("switch");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("case")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "case");
							index = lines1.indexOf("case");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("enum")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "enum");
							index = lines1.indexOf("enum");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("register")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "register");
							index = lines1.indexOf("register");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("typedef")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "typedef");
							index = lines1.indexOf("typedef");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("char")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "char");
							index = lines1.indexOf("char");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("extern")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "extern");
							index = lines1.indexOf("extern");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("return")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "return");
							index = lines1.indexOf("return");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("union")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "union");
							index = lines1.indexOf("union");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("const")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "const");
							index = lines1.indexOf("const");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("short")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "short");
							index = lines1.indexOf("short");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("unsigned")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "unsigned");
							index = lines1.indexOf("unsigned");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("continue")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "continue");
							index = lines1.indexOf("continue");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("for")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "for");
							index = lines1.indexOf("for");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("signed")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "signed");
							index = lines1.indexOf("signed");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("void")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "void");
							index = lines1.indexOf("void");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("default")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "default");
							index = lines1.indexOf("default");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("goto")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "goto");
							index = lines1.indexOf("goto");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("sizeof")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "sizeof");
							index = lines1.indexOf("sizeof");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("volatile")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "volatile");
							index = lines1.indexOf("volatile");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("do")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "do");
							index = lines1.indexOf("do");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("static")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "static");
							index = lines1.indexOf("static");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("while")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "while");
							index = lines1.indexOf("while");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("asm")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "asm");
							index = lines1.indexOf("asm");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("this")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "this");
							index = lines1.indexOf("this");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("new")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "new");
							index = lines1.indexOf("new");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("operator")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "operator");
							index = lines1.indexOf("operator");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("throw")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "throw");
							index = lines1.indexOf("throw");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("explicit")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "explicit");
							index = lines1.indexOf("explicit");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("private")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "private");
							index = lines1.indexOf("private");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("true")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "true");
							index = lines1.indexOf("true");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("export")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "export");
							index = lines1.indexOf("export");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("protected")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "protected");
							index = lines1.indexOf("protected");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("try")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "try");
							index = lines1.indexOf("try");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("public")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "public");
							index = lines1.indexOf("public");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("catch")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "catch");
							index = lines1.indexOf("catch");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("false")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "false");
							index = lines1.indexOf("false");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("typeid")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "typeid");
							index = lines1.indexOf("typeid");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("typename")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "typename");
							index = lines1.indexOf("typename");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("class")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "class");
							index = lines1.indexOf("class");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("union")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "union");
							index = lines1.indexOf("union");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("friend")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "friend");
							index = lines1.indexOf("friend");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("const_cast")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "const_cast");
							index = lines1.indexOf("const_cast");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("using")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "using");
							index = lines1.indexOf("using");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("virtual")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "virtual");
							index = lines1.indexOf("virtual");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("inline")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "inline");
							index = lines1.indexOf("inline");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("delete")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "delete");
							index = lines1.indexOf("delete");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("static_cast")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "static_cast");
							index = lines1.indexOf("static_cast");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("wchar_t")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "wcahr_t");
							index = lines1.indexOf("wchar_t");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("double")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "double");
							index = lines1.indexOf("double");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("mutable")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "mutable");
							index = lines1.indexOf("mutable");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("namespace")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "namespace");
							index = lines1.indexOf("namespace");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("template")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "template");
							index = lines1.indexOf("template");
							for(int p=0;p<intCount;p++) {
								keywordsfile2.add(lines1.get(index));
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Keywords_file2", keywordsfile2);

					//Add values from ArrayList to HashMap Key keywords
					List<String> operatorsfile2 = new ArrayList<String>();
					if (lines1.contains("=") || lines1.contains("-") || lines1.contains("+") || lines1.contains("*") || lines1.contains("/") || lines1.contains("%") || lines1.contains("++") || lines1.contains("--")) {
						if (lines1.contains("=")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "=");
							index = lines1.indexOf("=");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("-")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "-");
							index = lines1.indexOf("-");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("+")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "+");
							index = lines1.indexOf("+");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("*")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "*");
							index = lines1.indexOf("*");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("/")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "/");
							index = lines1.indexOf("/");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("%")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "%");
							index = lines1.indexOf("%");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("++")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "++");
							index = lines1.indexOf("++");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("--")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "--");
							index = lines1.indexOf("--");
							for(int p=0;p<intCount;p++) {
								operatorsfile2.add(lines1.get(index));
							}
						}
						/*if (lines1.contains("%c")) {
				int index = 0;
				int intCount = Collections.frequency(lines1, "%c");
				index = lines1.indexOf("%c");
				for(int p=0;p<intCount;p++) {
				operatorsfile2.add(lines1.get(index));
			}
			}*/
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Math Operators_file2", operatorsfile2);

					//Add values from ArrayList to HashMap Key keywords
					List<String> logicalfile2 = new ArrayList<String>();
					if (lines1.contains("<") || lines1.contains(">") || lines1.contains("<=") || lines1.contains(">=") || lines1.contains("==") || lines1.contains("!=") || lines1.contains("?")
							|| lines1.contains(">>") || lines1.contains("<<") || lines1.contains("&&") || lines1.contains("||") || lines1.contains("!") || lines1.contains("^") || lines1.contains("~") || lines1.contains("|") || lines1.contains("&")) {
						if (lines1.contains("<")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "<");
							index = lines1.indexOf("<");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains(">")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, ">");
							index = lines1.indexOf(">");
							for(int p=0;p<intCount;p++ ) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("<=")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "<=");
							index = lines1.indexOf("<=");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains(">=")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, ">=");
							index = lines1.indexOf(">=");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains(">>")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, ">=");
							index = lines1.indexOf(">>");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("<<")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, ">=");
							index = lines1.indexOf("<<");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("&&")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "&&");
							index = lines1.indexOf("&&");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("||")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "||");
							index = lines1.indexOf("||");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("!")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "!");
							index = lines1.indexOf("!");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("^")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "^");
							index = lines1.indexOf("^");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("~")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "~");
							index = lines1.indexOf("~");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("|")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "|");
							index = lines1.indexOf("|");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
						if (lines1.contains("&")) {
							int index = 0;
							int intCount = Collections.frequency(lines1, "&");
							index = lines1.indexOf("&");
							for(int p=0;p<intCount;p++) {
								logicalfile2.add(lines1.get(index));
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Logical Operators_file2", logicalfile2);

					//Convert the array list into an array
					String [] linesArray1 = lines1.toArray(new String [0]);

					//Add values from ArrayList to HashMap Key keywords
					List<String> digits1 = new ArrayList<String>();
					for (int count = 0;  count < linesArray1.length; count++) {
						if (linesArray1[count].matches("\\d+|\\d+\\.\\d+")) {  //Use regex here for numbers
							digits1.add(linesArray1[count]);
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Numerical Values_file2", digits1);

					//Add values from ArrayList to HashMap Key keywords
					List<String> identifiersfile2 = new ArrayList<String>();
					for (int count = 0;  count < linesArray1.length; count++) {
						if (linesArray1[count].matches("\\w+|\"[A-za-z\\s:\\d]+\"") && !linesArray1[count].matches("\\d+") && !linesArray1[count].matches("int|float|if|else|auto|struct|bool|break|long|switch|case|enum|register|typedef|char|extern|return|union|const|short|unsigned|continue|for|signed|void|default|goto|sizeof|volatile|do|static|while|asm|this|new|operator|throw|explicit|private|true|export|protected|try|public|catch|false|typeid|typename|class|union|friend|const_cast|using|virtual|inline|delete|static_cast|wchar_t|double|mutable|namespace|template")) {  //Use regex here for variables
							if (!identifiersfile2.contains(linesArray1[count])) {
								identifiersfile2.add(linesArray1[count]);
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Identifiersfile2", identifiersfile2);

					//Add values from ArrayList to HashMap Key keywords
					List<String> othersfile2 = new ArrayList<String>();
					for (int count = 0;  count < linesArray1.length; count++) {
						if (linesArray1[count].matches("\\(|\\)|\\{|\\}|\\[|\\]")) {  //Use regex here for variables
							if (!identifiersfile2.contains(linesArray1[count])) {
								othersfile2.add(linesArray1[count]);
							}
						}
					}

					//Put the ArrayLists in HashMap for particular Keys
					symbolTable1.put("Others_file2", othersfile2);

					//Prints the ArrayList
					System.out.println();
					System.out.print("The Lexemes for file 2: ");
					System.out.println(lines1);

					System.out.println();

					//Prints the Symbol Table
					for (Map.Entry<String, List<String>> entry : symbolTable1.entrySet()) {
						String key = entry.getKey();
						List<String> values1 = entry.getValue();
						System.out.print(key + ": ");
						System.out.println(values1);
					}

					System.out.println();
					/*System.out.println("Let's check if the lexemes are equal");
					System.out.print("The lexemes for file1 are:");
					System.out.println(lines);
					System.out.println();
					System.out.print("The lexemes for file2 are:");
					System.out.println(lines1);

					System.out.println();
					System.out.println("Accessing 20th element from Lexeme list one:");
					String a1 = lines.get(1);
					String a2 = lines1.get(1);
					System.out.println(a1);

					System.out.println();
					System.out.println("Accessing 20th element from Lexeme list two:");
					System.out.println(a2);

					System.out.println();
					System.out.println("Comparing Elements from list one and two:");
					System.out.println(a1.equals(a2));*/
					System.out.println();
					System.out.print("Print out both the Symbol Tables in array list format:\n");
					System.out.println(symbolTable1);
					System.out.println(symbolTable.get("Identifiers"));
					//System.out.println(a1.equals(a2));

					List<String> list1= symbolTable.get("Identifiers");
					List<String> list2= symbolTable1.get("Identifiersfile2");

					//Print and compare Identifiers
					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> la = new ArrayList<String>(list1);
					System.out.println("Printing Identifiers list from file 1\r\n");
					System.out.println(la);

					ArrayList<String> lb = new ArrayList<String>(list2);
					System.out.println("Printing Identifiers list from file 2\r\n");
					System.out.println(lb);
					System.out.println();

					/*ArrayList<String> com = new ArrayList<String>(la);
					com.retainAll(lb);
					System.out.println(" 100.0 * com / la = " + (la.size() == 0 ? 0 : 100.0 * com.size() / la.size()));
					System.out.println(" 100.0 * com / lb = " + (lb.size() == 0 ? 0 : 100.0 * com.size() / lb.size()));

					ArrayList<String> com1 = new ArrayList<String>(lb);
					com.retainAll(la);
					System.out.println(" 100.0 * com1 / la = " + (la.size() == 0 ? 0 : 100.0 * com1.size() / la.size()));
					System.out.println(" 100.0 * com1 / lb = " + (lb.size() == 0 ? 0 : 100.0 * com.size() / lb.size()));*/


					lb.retainAll(la);

					System.out.println("Common elements in both list:\n ");
					System.out.println(lb);

					HashSet set = new HashSet();
					for(int k = 0; k < la.size(); k++){
						set.add(la.get(k));
					}

					double counter = 0;
					for(int p = 0; p < lb.size(); p++){
						if(set.contains(lb.get(p))){
							counter++;
						}
					}

					System.out.println("Match percentage between arrays : " + counter/lb.size()*100);

					List<String> listkey= symbolTable.get("Keywords");
					List<String> listkeynew= symbolTable1.get("Keywords_file2");

					//System.out.println(list1);
					//System.out.println(list2);
					//==========================================================================================================

					ArrayList<String> k1 = new ArrayList<String>(listkey);
					System.out.println("\nPrinting Keywords list from file 1\r\n");
					System.out.println(k1);

					Set<String> distinct = new HashSet<>(k1);
					Map<String, Integer> keylist1 = new HashMap<String, Integer>();

					for (String s: distinct) {
						System.out.println(s + ": " + Collections.frequency(k1, s));
						keylist1.put(s, Collections.frequency(k1,s));
					}

					System.out.println(keylist1);
				/*	if(j+1==filesList1.size())
						combinedHM.add(keylist1);*/


					ArrayList<String> k2 = new ArrayList<String>(listkeynew);
					System.out.println("\nPrinting keywords list from file 2\r\n");
					System.out.println(k2);
					System.out.println();

					Set<String> distinct1 = new HashSet<>(k2);
					Map<String, Integer> keylist3 = new HashMap<String, Integer>();

					for (String s1: distinct1) {
						System.out.println(s1 + ": " + Collections.frequency(k2, s1));
						keylist3.put(s1, Collections.frequency(k2,s1));
					}
					System.out.println(keylist3);

					double keycount=0;
					for (Map.Entry mapElement : keylist1.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylist3.containsKey(key))
						{
							secondvalue=keylist3.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with value\"" + value + "/");
							keycount++;
						}
						else { System.out.println("No similarities detected for \"" + key + "\" in both the files");
						}
					}

					String k37 = k1.toString();
					String k47 = k2.toString();
					levenstein rf1 =new levenstein();
					System.out.println("\n");
					rf1.printSimilarity(k37,k47);
					double key1 = rf1.similarity(k37, k47);
					double key2 = rf1.jaro_distance(k37, k47);
					double key3 = rf1.jaro_Winkler(k37, k47);
					double key4 = rf1.diceCoefficientOptimized(k37, k47);
					String key5 = rf1.longestCommonSubstring(k37, k47);
					double key6 = rf1.longestSubstr(k37, k47);



					ScoreData sd = new ScoreData();
					//sd.scores(newList1.get(i), newList.get(i), key5, key1, key2, key3, key4, key6);
					sd.scores(f1, f2, key5, key1, key2, key3, key4, key6);
					//sd.scores(newList1.get(i), newList.get(i), key5, key1, key2, key3, key4, key6);

					System.out.println("\n");
					System.out.println(rf1.jaro_distance(k37, k47) + " is the jaro distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(k37, k47) + " is the jaro-Winkler distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(k37, k47) + " is the Sorensen Dice Coefficient between keyword lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(k37, k47) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k37, k47));


					Cosine cs = new Cosine();
					double cosinescore = cs.Cosine_Similarity_Score(k37, k47);
					System.out.println("\n" + cosinescore);

					/*GreedyStringTiling gs = new GreedyStringTiling();
					gs.run(k37, k47, 1,(float)0.4);*/

					long keyocc = (long) (keycount/4*100);
				/*	System.out.println("\nThe Similarity percentage betweem two files for keywords is " + keyocc +" %\n");
					k1.retainAll(k2);
					System.out.println("\nCommon elements in both list:\n ");
					System.out.println(k1);*/


					double keyw1 = (key1 + key2 + key3 + key4 + cosinescore) / 5;

					//Print and compare Math Operators============================================================================

					List<String> listmath= symbolTable.get("Math Operators");
					List<String> listmathnew= symbolTable1.get("Math Operators_file2");

					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> m1 = new ArrayList<String>(listmath);
					System.out.println("\nPrinting Math Operators list from file 1\r\n");
					System.out.println(m1);

					Set<String> distinct2 = new HashSet<>(m1);
					Map<String, Integer> keylist4 = new HashMap<String, Integer>();

					for (String s1: distinct2) {
						System.out.println(s1 + ": " + Collections.frequency(m1, s1));
						keylist4.put(s1, Collections.frequency(m1,s1));
					}
					System.out.println(keylist4);
					/*if(j+1==filesList1.size())
					combinedHM.add(keylist4);*/

					ArrayList<String> m2 = new ArrayList<String>(listmathnew);
					System.out.println("Printing Math Operators list from file 2\r\n");
					System.out.println(m2);
					System.out.println();

					Set<String> distinct3 = new HashSet<>(m2);
					Map<String, Integer> keylist5 = new HashMap<String, Integer>();

					for (String s1: distinct3) {
						System.out.println(s1 + ": " + Collections.frequency(m2, s1));
						keylist5.put(s1, Collections.frequency(m2,s1));
					}
					System.out.println(keylist5);

					double count=0;
					for (Map.Entry mapElement : keylist4.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylist5.containsKey(key))
						{
							secondvalue=keylist5.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with\"" + value);
							count++;

						}
						else { System.out.println("Similarity not detected \"" + key + "\" in the files");
						}
					}

					String k57 = m1.toString();
					String k67 = m2.toString();
					System.out.println("\n");
					rf1.printSimilarity(k57,k67);
					System.out.println("\n");
					System.out.println(rf1.jaro_distance(k57, k67) + " is the jaro distance between math operators lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(k57, k67) + " is the jaro-Winkler distance between math operators lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(k57, k67) + " is the Sorensen Dice Coefficient between math operators lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(k57, k67) + "]" + " is the longest common substring between math operators lists with length " + rf1.longestSubstr(k57, k67));
					//rf1.similarity(k57,k67);
					double key11 = rf1.similarity(k57, k67);
					double key12 = rf1.jaro_distance(k57, k67);
					double key13 = rf1.jaro_Winkler(k57, k67);
					double key14 = rf1.diceCoefficientOptimized(k57, k67);
					String key15 = rf1.longestCommonSubstring(k57, k67);
					double key16 = rf1.longestSubstr(k57, k67);

					MathDistance md = new MathDistance();
					//	md.mathscores(newList1.get(i), newList.get(i), key15, key11, key12, key13, key14, key16);
					md.mathscores(f1, f2, key15, key11, key12, key13, key14, key16);
					//sd.scores(newList1.get(i), newList.get(i), key5, key1, key2, key3, key4, key6);


					double cosinescore_math = cs.Cosine_Similarity_Score(k57, k67);
					System.out.println("\n" + cosinescore_math);

					long math1 = (long) (count/4*100);
			/*		System.out.println("\nThe Similarity percentage between two files for Math operators is  " + math1 + " %\n");

					m2.retainAll(m1);

					System.out.println("Common elements in both list:\n ");
					System.out.println(m2);*/

					double keym2 = (key11 + key12 + key13 + key14 + cosinescore_math) / 5;

					//===========================================================================================================
					//Print and compare Numerical Values
					List<String> listnum= symbolTable.get("Numerical Values");
					List<String> listnumnew= symbolTable1.get("Numerical Values_file2");

					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> n1 = new ArrayList<String>(listnum);
					System.out.println("\nPrinting Numerical Values list from file 1\r\n");
					System.out.println(n1);

					Set<String> distinct4 = new HashSet<>(n1);
					Map<String, Integer> keylist6 = new HashMap<String, Integer>();

					for (String s1: distinct4) {
						System.out.println(s1 + ": " + Collections.frequency(n1, s1));
						keylist6.put(s1, Collections.frequency(n1,s1));
					}
					System.out.println(keylist6);
					/*if(j+1==filesList1.size())
					combinedHM.add(keylist6);
					System.out.println();*/

					ArrayList<String> n2 = new ArrayList<String>(listnumnew);
					System.out.println("Printing Numerical Values list from file 2\r\n");
					System.out.println(n2);
					System.out.println();

					Set<String> distinct5 = new HashSet<>(n2);
					Map<String, Integer> keylist7 = new HashMap<String, Integer>();

					for (String s1: distinct5) {
						System.out.println(s1 + ": " + Collections.frequency(n2, s1));
						keylist7.put(s1, Collections.frequency(n2,s1));
					}
					System.out.println(keylist7);

					Set<String> numset = new HashSet<>();
					numset.addAll(distinct4);
					numset.addAll(distinct5);

					System.out.println(numset);
					double sizeset = numset.size();
					System.out.println(sizeset);

					double numcount=0;
					for (Map.Entry mapElement : keylist6.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylist7.containsKey(key))
						{
							secondvalue=keylist7.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with value \"" + value + "\"");
							numcount++;
						}
						else { System.out.println("Similarity not detected for \"" + key + "\" in the files");
						}
					}


					String k77 = n1.toString();
					String k87 = n2.toString();
					System.out.println("\n");
					rf1.printSimilarity(k77,k87);
					System.out.println("\n");
					System.out.println(rf1.jaro_distance(k77, k87) + " is the jaro distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(k77, k87) + " is the jaro-Winkler distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(k77, k87) + " is the Sorensen Dice Coefficient between keyword lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(k77, k87) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k77, k87));
					double key111 = rf1.similarity(k77, k87);
					double key112 = rf1.jaro_distance(k77, k87);
					double key113 = rf1.jaro_Winkler(k77, k87);
					double key114 = rf1.diceCoefficientOptimized(k77, k87);
					String key115 = rf1.longestCommonSubstring(k77, k87);
					double key116 = rf1.longestSubstr(k77, k87);

					NumericalScores ns = new NumericalScores();
					//ns.numericalscore(newList1.get(i), newList.get(i), key115, key111, key112, key113, key114, key116);
					ns.numericalscore(f1, f2, key115, key111, key112, key113, key114, key116);
					//sd.scores(newList1.get(i), newList.get(i), key5, key1, key2, key3, key4, key6);

					double cosinescore_numerical = cs.Cosine_Similarity_Score(k77, k87);
					System.out.println("\n" + cosinescore_numerical);

					long numcount1 = (long) (numcount/sizeset *100);
					/*System.out.println("\nThe Similarity percentage between two files for numerical operators is " + numcount1 + " %\n");
					n1.retainAll(n2);

					System.out.println("Common elements in both list:\n ");
					System.out.println(n1);*/

					double keyn3 = (key111 + key112 + key113 + key114 + cosinescore_numerical) / 5;

					//===================================================================================================================
					//Print and compare Logical Operators
					List<String> listlog= symbolTable.get("Logical Operators");
					List<String> listlognew= symbolTable1.get("Logical Operators_file2");

					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> o1 = new ArrayList<String>(listlog);
					System.out.println("\nPrinting Logical Operators list from file 1\r\n");
					System.out.println(o1);
					if(o1.size() == 0)
					{
						System.out.println("No Logical Operator found in File1");
					}

					Set<String> distinct6 = new HashSet<>(o1);
					Map<String, Integer> keylist8 = new HashMap<String, Integer>();

					for (String s1: distinct6) {
						System.out.println(s1 + ": " + Collections.frequency(o1, s1));
						keylist8.put(s1, Collections.frequency(o1,s1));
					}
					//System.out.println(keylist8);
					/*if(j+1==filesList1.size())
					combinedHM.add(keylist8);*/

					ArrayList<String> o2 = new ArrayList<String>(listlognew);
					System.out.println("Printing Logical Operators list from file 2\r\n");
					System.out.println(o2);
					System.out.println();
					if(o2.size() == 0)
					{
						System.out.println("No Logical Operator found in File12");
					}

					Set<String> distinct7 = new HashSet<>(o2);
					Map<String, Integer> keylist9 = new HashMap<String, Integer>();

					for (String s1: distinct7) {
						System.out.println(s1 + ": " + Collections.frequency(o2, s1));
						keylist9.put(s1, Collections.frequency(o2,s1));
					}
					System.out.println(keylist9);

					double logocc = 0;
					for (Map.Entry mapElement : keylist8.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylist9.containsKey(key))
						{
							secondvalue=keylist9.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with value \"" + value + "\"");
							logocc++;
						}
						else { System.out.println("Similarity not detected for \"" + key + "\" in the files");
						}
					}

					String k97 = o1.toString();
					String k107 = o2.toString();
					System.out.println("\n");
					rf1.printSimilarity(k97,k107);
					System.out.println("\n");
					System.out.println(rf1.jaro_distance(k97, k107) + " is the jaro distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(k97, k107) + " is the jaro-Winkler distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(k97, k107) + " is the Sorensen Dice Coefficient between keyword lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(k97, k107) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k97, k107));
					double key1111 = rf1.similarity(k97, k107);
					double key1112 = rf1.jaro_distance(k97, k107);
					double key1113 = rf1.jaro_Winkler(k97, k107);
					double key1114 = rf1.diceCoefficientOptimized(k97, k107);
					String key1115 = rf1.longestCommonSubstring(k97, k107);
					double key1116 = rf1.longestSubstr(k97, k107);

					LogicalScores ls = new LogicalScores();
					//ls.logicalscores(newList1.get(i), newList.get(i), key1115, key1111, key1112, key1113, key1114, key1116);
					ls.logicalscores(f1, f2, key1115, key1111, key1112, key1113, key1114, key1116);

					double cosinescore_logical = cs.Cosine_Similarity_Score(k77, k87);
					System.out.println("\n" + cosinescore_logical);

					/*long logcount = (long) (logocc/4*100);
					System.out.println("\nThe similarity percentage between two files for logical operators is " + logcount + " %\n");

					o2.retainAll(o1);

					System.out.println("Common elements in both list:\n ");
					System.out.println(o2);*/

					double keylog4 = (key1111 + key1112 + key1113 + key1114 + cosinescore_logical) / 5;

					//=============================================================================================================
					//Print and compare Other literals
					List<String> listothers= symbolTable.get("Others");
					List<String> listothersnew= symbolTable1.get("Others_file2");

					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> op1 = new ArrayList<String>(listothers);
					System.out.println("\nPrinting Other Operators list from file 1\r\n");
					System.out.println(op1);

					Set<String> distinct8 = new HashSet<>(op1);
					Map<String, Integer> keylist10 = new HashMap<String, Integer>();

					for (String s1: distinct8) {
						System.out.println(s1 + ": " + Collections.frequency(op1, s1));
						keylist10.put(s1, Collections.frequency(op1,s1));
					}
					System.out.println(keylist10);
					/*if(j+1==filesList1.size())
					combinedHM.add(keylist10);*/

					ArrayList<String> op2 = new ArrayList<String>(listothersnew);
					System.out.println("Printing Other Operators list from file 2\r\n");
					System.out.println(op2);
					System.out.println();

					Set<String> distinct9 = new HashSet<>(op2);
					Map<String, Integer> keylist11 = new HashMap<String, Integer>();

					for (String s1: distinct9) {
						System.out.println(s1 + ": " + Collections.frequency(op2, s1));
						keylist11.put(s1, Collections.frequency(op2,s1));
					}
					System.out.println(keylist11);

					double otherocc = 0;
					for (Map.Entry mapElement : keylist10.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylist11.containsKey(key))
						{
							secondvalue=keylist11.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with value \"" + value + "\"");
							otherocc++;
						}
						else { System.out.println("Similarity not detected for \"" + key + "\" in the files");
						}
					}

					String k117 = op1.toString();
					String k127 = op2.toString();
					System.out.println("\n");
					rf1.printSimilarity(k117,k127);
					System.out.println("\n");
					System.out.println(rf1.jaro_distance(k117, k127) + " is the jaro distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(k117, k127) + " is the jaro-Winkler distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(k117, k127) + " is the Sorensen Dice Coefficient between keyword lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(k117, k127) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k117, k127));

					double key11111 = rf1.similarity(k117, k127);
					double key11112 = rf1.jaro_distance(k117, k127);
					double key11113 = rf1.jaro_Winkler(k117, k127);
					double key11114 = rf1.diceCoefficientOptimized(k117, k127);
					String key11115 = rf1.longestCommonSubstring(k117, k127);
					double key11116 = rf1.longestSubstr(k117, k127);

					double cosinescore_othersop = cs.Cosine_Similarity_Score(k117, k127);
					System.out.println("\n" + cosinescore_othersop);

					OtheropsScores os = new OtheropsScores();
					//os.otheropsscores(newList1.get(i), newList.get(i), key11115, key11111, key11112, key11113, key11114, key11116);
					os.otheropsscores(f1, f2, key11115, key11111, key11112, key11113, key11114, key11116);


					double keyop6 = (key11111 + key11112 + key11113 + key11114 + cosinescore_othersop) / 5;



				   long opcount = (long) (otherocc/15*100);
					System.out.println("\nThe Similarity percentage between two files for other operators is " + opcount + " %\n");
					op2.retainAll(op1);

					System.out.println("\nCommon elements in both list:\n");
					System.out.println(op2);

					long total = (long) ((keycount + count + otherocc + logocc) / 27 * 100);
					long dis = 100 - total;
					System.out.println("\nThe Similarity percentage for Keywords, Math operators, logical operators and other operators between two files is " + total + " %\n");
					System.out.println("\nDissimilarity between two files is " + dis + " %\n");



					//================================================================================================================================================================

					List<String> listiden= symbolTable.get("Identifiers");
					List<String> listiden2= symbolTable1.get("Identifiersfile2");

					//System.out.println(list1);
					//System.out.println(list2);

					ArrayList<String> id1 = new ArrayList<String>(listiden);
					System.out.println("\nPrinting identifiers list from file 1\r\n");
					System.out.println(id1);
					if(id1.size() == 0)
					{
						System.out.println("No identifier found in File1");
					}

					Set<String> distinctid = new HashSet<>(id1);
					Map<String, Integer> keylistid = new HashMap<String, Integer>();

					for (String s1: distinctid) {
						System.out.println(s1 + ": " + Collections.frequency(id1, s1));
						keylistid.put(s1, Collections.frequency(id1,s1));
					}
					//System.out.println(keylist8);
					/*if(j+1==filesList1.size())
					combinedHM.add(keylist8);*/

					ArrayList<String> id2 = new ArrayList<String>(listiden2);
					System.out.println("Printing identifiers list from file 2\r\n");
					System.out.println(id2);
					System.out.println();
					if(id2.size() == 0)
					{
						System.out.println("No identifier found in File2");
					}

					Set<String> distinctid2 = new HashSet<>(id2);
					Map<String, Integer> keylistid2 = new HashMap<String, Integer>();

					for (String s1: distinctid2) {
						System.out.println(s1 + ": " + Collections.frequency(id2, s1));
						keylistid2.put(s1, Collections.frequency(id2,s1));
					}
					System.out.println(keylistid2);

					double logoccid = 0;
					for (Map.Entry mapElement : keylistid2.entrySet()) {
						String key = (String)mapElement.getKey();

						int value = (int) mapElement.getValue();
						int secondvalue=0;
						if (keylistid2.containsKey(key))
						{
							secondvalue=keylistid2.get(key);
						}

						if(value==secondvalue) {
							System.out.println("Similarity detected for \"" +  key + "\" in both the files with value \"" + value + "\"");
							logoccid++;
						}
						else { System.out.println("Similarity not detected for \"" + key + "\" in the files");
						}
					}

					String id97 = id1.toString();
					String id107 = id2.toString();
					System.out.println("\n");
					rf1.printSimilarity(id97,id107);
					System.out.println("\n");
					System.out.println(rf1.jaro_distance(id97, id107) + " is the jaro distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.jaro_Winkler(id97, id107) + " is the jaro-Winkler distance between keyword lists");
					System.out.println("\n");
					System.out.println(rf1.diceCoefficientOptimized(id97, id107) + " is the Sorensen Dice Coefficient between keyword lists");
					System.out.println("\n");
					System.out.println("[" + rf1.longestCommonSubstring(id97, id107) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k97, k107));
					double keyid11 = rf1.similarity(id97, id107);
					double keyid12 = rf1.jaro_distance(id97, id107);
					double keyid13 = rf1.jaro_Winkler(id97, id107);
					double keyid14 = rf1.diceCoefficientOptimized(id97, id107);
					String keyid15 = rf1.longestCommonSubstring(id97, id107);
					double keyid16 = rf1.longestSubstr(id97, id107);

					IdentScore ids = new IdentScore();
					//ls.logicalscores(newList1.get(i), newList.get(i), key1115, key1111, key1112, key1113, key1114, key1116);
					ids.identifierscore(f1, f2, keyid15, keyid11, keyid12, keyid13, keyid14, keyid16);

					double cosinescore_identifier = cs.Cosine_Similarity_Score(id97, id107);
					System.out.println("\n" + cosinescore_identifier);

					long logcount = (long) (logocc/4*100);
					System.out.println("\nThe similarity percentage between two files for logical operators is " + logcount + " %\n");
     				id2.retainAll(id1);

					System.out.println("Common elements in both list:\n ");
					System.out.println(id2);

					double keyident = (keyid11 + keyid12 + keyid13 + keyid14 + cosinescore_identifier) / 5;

					double avgs = (keyw1 + keyident + keym2 + keyn3 + keylog4 + keyop6) / 6;



					Avgscores av = new Avgscores();
					av.avg(f1, f2, keyw1, keyident, keym2, keyn3, keylog4, keyop6, avgs);

					double keyb = 0;

					Webtable wb = new Webtable();
					wb.web(f1, f2, avgs, keyb);


                    String fint1 = k37.concat(k57.concat(k77.concat(k97.concat(k117.concat(id97)))));
                    String fint2 = k47.concat(k67.concat(k87.concat(k107.concat(k127.concat(id107)))));

                    System.out.println("\n" + fint1);
                    System.out.println("\n" + fint2);
                    System.out.println("\n");
                    rf1.printSimilarity(fint1,fint2);
                    System.out.println("\n");
                    System.out.println(rf1.jaro_distance(fint1, fint2) + " is the jaro distance between keyword lists");
                    System.out.println("\n");
                    System.out.println(rf1.jaro_Winkler(fint1, fint2) + " is the jaro-Winkler distance between keyword lists");
                    System.out.println("\n");
                    System.out.println(rf1.diceCoefficientOptimized(fint1, fint2) + " is the Sorensen Dice Coefficient between keyword lists");
                    System.out.println("\n");
                    System.out.println("[" + rf1.longestCommonSubstring(fint1, fint2) + "]" + " is the longest common substring between keyword lists with length " + rf1.longestSubstr(k117, k127));
                    double cosinescore_final = cs.Cosine_Similarity_Score(fint1, fint2);
                    System.out.println("\n" + cosinescore_final);

                    double fin1 = rf1.similarity(fint1, fint2);
                    double fin2 = rf1.jaro_distance(fint1, fint2);
                    double fin3 = rf1.jaro_Winkler(fint1, fint2);
                    double fin4 = rf1.diceCoefficientOptimized(fint1, fint2);
                    String fin5 = rf1.longestCommonSubstring(fint1, fint2);
                    double fin6 = rf1.longestSubstr(fint1, fint2);


                    FinalfileDistance fd = new FinalfileDistance();
                    //fd.finalfilescore(newList1.get(i), newList.get(i), fint1, fint2, fin1, fin2, fin3, fin4, fin5, fin6);
                    fd.finalfilescore(f1, f2, fint1, fint2, fin1, fin2, fin3, fin4, fin5, fin6);


                    //================================================================================================================================================================

					try {
						connect1 = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/demo?"
										+ "user=root&password=");
						statement1 = connect1.createStatement();
						preparedStatement1 = connect1
								.prepareStatement("insert into  demo.scores values (?, ?, ?, ?, ?, ? , ?, ?)");
						//preparedStatement1.setString(1, newList.get(i).getName().concat(newList1.get(i).getName()));
						preparedStatement1.setString(1, f1.getName().concat(f2.getName()));
						preparedStatement1.setLong(2, keyocc);
						preparedStatement1.setLong(3, math1);
						preparedStatement1.setLong(4, numcount1);
						preparedStatement1.setLong(5, logcount);
						preparedStatement1.setLong(6, opcount);
						preparedStatement1.setLong(7, total);
						preparedStatement1.setLong(8, dis);
						preparedStatement1.executeUpdate();

						preparedStatement1 = connect1
								.prepareStatement("SELECT filenames, keywordscore, mathopscore, numericalscore, logicalscore, otheropscore, totalsimilarity, totaldissimilarity from demo.scores");
						resultSet1 = preparedStatement1.executeQuery();
						connect1.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("error in db");
						e.printStackTrace();
					}


					//--------------------------------------------------------------------------------------//

			/*	System.out.println(filesList1.get(y).getName()+"|"+newList1.get(i).getName());
				System.out.println(combinedHM.size());

				for (Map<String, Integer> hm : combinedHM) {
					System.out.println(hm.size());
					try {

					connect1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?"+ "user=root&password=root");
					statement1 = connect1.createStatement();
					connect1.setAutoCommit(false);
					preparedStatement1 = connect1.prepareStatement("insert into  demo.keywords values (?, ?, ?)");

					for (Map.Entry mapElement : hm.entrySet()) {
						String key = (String)mapElement.getKey();
						int value = ((int)mapElement.getValue());
						preparedStatement1.setString(1,filesList1.get(y).getName()+"|"+newList1.get(i).getName());
						preparedStatement1.setString(2, key);
						preparedStatement1.setLong(3, value);
						preparedStatement1.addBatch();
					}
					preparedStatement1.executeBatch();
					connect1.commit();
					System.out.println("Records inserted......");
					//preparedStatement1.setNString(1, );
					//preparedStatement1.setLong(2, keyocc);
					//preparedStatement1.executeUpdate();

					preparedStatement1 = connect1
							.prepareStatement("SELECT filenames, keylist1, keylist2 from demo.keywords");
					resultSet1 = preparedStatement1.executeQuery();
					connect1.close();


					}
					catch (SQLException e) {
						System.out.println("error in db");
						e.printStackTrace();
					}

				}*/



				}


				//System.out.println("Completed comparision against "+f1.getName());
			}
		}
		Maxmin mn = new Maxmin();
		mn.maxminscore();

		Update up = new Update();
		up.updatetable();

		long startTime = System.nanoTime();
		//code
		long endTime = System.nanoTime();
		System.out.println("Running time:  "+(endTime - startTime) + " ns");
	}
}
