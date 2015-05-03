package com.LoginProject.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO {

	protected PreparedStatement stmt;
	protected ResultSet         rs;
	protected Connection        con;
	private static final String DATABASE_NAME = "javashop";
	private static final String URI           = "com.mysql.jdbc.Driver";
	private static final String URL           = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
	private static final String USER          = "root";
	private static final String PASS          = "";
	
	public void open()throws Exception{
		Class.forName(URI);
		con = DriverManager.getConnection(URL, USER, PASS);
	}
	
	public void close()throws Exception{
		con.close();
	}
	
}

