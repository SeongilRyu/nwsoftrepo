package com.nwsoft.java7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TryWithResources {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String qry = "select * from users";
		String jdbcurl="jdbc:oracle:thin:@" + "hostname:" + "port:" + "database" ;
		String dbuser="user1";
		String dbpass="pass1";
		
		
		try (Connection conn = DriverManager.getConnection(jdbcurl, dbuser, dbpass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(qry)){
			while (rs.next()) {
				String user = rs.getString("user");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				
				System.out.println(user + pass + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
