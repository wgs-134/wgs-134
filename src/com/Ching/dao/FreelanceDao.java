package com.Ching.dao;

import java.sql.Connection;

import com.Ching.model.Freelance;
import com.Ching.util.StringUtil;

import java.sql.ResultSet;
import java.sql.PreparedStatement;

//????????Dao??
public class FreelanceDao {


	
	//???
	public int add(Connection con,Freelance freelance) throws Exception{
		
		
		//sql???
		//String sql_1="select * from freelance where Free_Id=?";//????????????
		//PreparedStatement pstmt1 = con.prepareStatement(sql_1);
		
		//pstmt1.setString(1, freelance.getFree_Id());
		//ResultSet rs1 = pstmt1.executeQuery();//??????	
		
			
		String sql_2 = "insert into freelance values(?,?,?,?,?)";//???????
		PreparedStatement pstmt2 = con.prepareStatement(sql_2);
		
		pstmt2.setString(1, freelance.getFree_Id());
		pstmt2.setString(2, freelance.getFree_Name());
		pstmt2.setString(3, freelance.getFree_Phone());
		pstmt2.setString(4, freelance.getFree_Addr());
		pstmt2.setString(5, freelance.getFree_Type());
		
		return pstmt2.executeUpdate() ;
			
		
	}
	
	
	//???
	public ResultSet list(Connection con,Freelance freelance)throws Exception {
		StringBuffer sb = new StringBuffer("select * from freelance");
		
		
		if (freelance.getFree_Type()!=null) {
			sb.append(" and Free_Type like '%"+freelance.getFree_Type()+"%'");
			
		}
		PreparedStatement pstmt2 = con.prepareStatement(sb.toString().replace("and", "where"));
		
		return pstmt2.executeQuery();
	}
	
	//???
		public int delete(Connection con,String Free_Id) throws Exception{
			String sql="delete from freelance where Free_Id=?";
					PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, Free_Id);
			return pstm.executeUpdate();
			
		}
	
	
	
	//???
	public int update(Connection con,Freelance freelance)throws Exception {
		String sql="update freelance set Free_Id=?,Free_Type=?,Free_Name=?,Free_Phone=?,Free_Addr=? where Free_Id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1, freelance.getFree_Id());
        pstm.setString(2, freelance.getFree_Type());
        pstm.setString(3, freelance.getFree_Name());
        pstm.setString(4, freelance.getFree_Phone());
        pstm.setString(5, freelance.getFree_Addr());
        
        
        pstm.setString(6, freelance.getFree_Id());
        
        return pstm.executeUpdate();
	}
	
	
	
	
	
	
	
	
	

	
}
