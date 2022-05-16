package com.Ching.dao;

import java.sql.Connection;

import com.Ching.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class UserDao {
	//��½��֤
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		
		//sql��䣺��ѯ��Ӧ�û�
		String sql = "select * from user where User_Name=?and password=?"; 
		PreparedStatement pstmt = con.prepareStatement(sql); 
		
		pstmt.setString(1, user.getUser_Name());//���ܽ��洫�������û���
		pstmt.setString(2, user.getPassword());//���ܽ��洫����������
		
		ResultSet rs = pstmt.executeQuery();//��ѯ���
		if (rs.next()) {
			resultUser = new User();
			resultUser.setUser_Id(rs.getInt("User_Id"));
			resultUser.setUser_Name(rs.getString("User_Name"));
			resultUser.setUser_Type(rs.getInt("User_Type"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
	
	
	
}
