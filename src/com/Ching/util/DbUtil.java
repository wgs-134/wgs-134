package com.Ching.util;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DbUtil {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/serviceplatform?useSSL=false&characterEncoding=utf8&allowPublicKeyRetrieval=true";
	private String  dbUserName = "root";
	private String  dbPassword = "559913";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	public  Connection getCon()throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	    return con;
	
	}
	
	
	public void closeCon(Connection con)throws Exception {
		if (con!=null) {
			con.close();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
			
			
			
		}
		
		
		
		
		
		
		
			
		
	}
	

}
