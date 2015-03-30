package com.nwsoft.java7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.spi.SyncProviderException;

public class JavaDataSet {
	static Connection conn;
	/**
	 * C#의 DataSet과 거의 유사하다.--Good
	 */
	static CachedRowSet crs=null;
	public static void main(String[] args) {
		
		String jdbcurl="jdbc:oracle:thin:@" + "hostname:" + "port:" + "database" ;
		String dbuser="user1";
		String dbpass="pass1";
		try {
			 conn = DriverManager.getConnection(jdbcurl, dbuser, dbpass);
			 queryWithRowSet();
			 updateData();
			 syncWithDatabase();
			 
		} catch (java.sql.SQLException e) {
			System.out.println(e);
		} finally  {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
				

	}

	private static void queryWithRowSet() {
		//crs = new CachedRowSetImpl(); //없다 왜?
		//crs = new CachedRowSet(); //추상클래스다. method정의 많이 해야 한다.
		RowSetFactory factory;
		try {
			factory = RowSetProvider.newFactory();
			crs = factory.createCachedRowSet();
			/** 다음으로 연결도 가능하다.
			 * crs.setUrl("jdbc:oracle");
			 * crs.setUsername("user1");
			 * crs.setPassword("pass1");
			 */
			crs.setCommand("select * from users");
			int[] keys = {1};
			crs.setKeyColumns(keys);
			crs.execute(conn);
			
			while (crs.next()) {
				System.out.println(crs.getString("col1") + "\n" 
						+ crs.getString("col2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static boolean updateData() {
		boolean returnValue = false;
		try {
			crs.beforeFirst();
			while(crs.next()) {
				if (crs.getString("user_recId").equals("IZ")) {
					System.out.println("Update...");
					crs.updateString("desc", "Deleted");
					crs.updateRow();
				}
			}
			returnValue=true;
		} catch (SQLException e) {
			returnValue = false;
			e.printStackTrace();
		}
		
		return returnValue;
	}

	private static void syncWithDatabase() {
		try {
			crs.acceptChanges(conn);
			
		} catch (SyncProviderException e) {
			e.printStackTrace();
		} finally  {
			if (crs != null) {
				try {
					crs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
