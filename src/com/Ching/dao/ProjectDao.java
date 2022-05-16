package com.Ching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Ching.model.Consumer;
import com.Ching.model.Project;
import com.Ching.model.Schedule;

public class ProjectDao {

	//???
	public int add(Connection con,Project project) throws Exception{

		
		//sql???
		//String sql_1="select * from freelance where Free_Id=?";//????????????
		//PreparedStatement pstmt1 = con.prepareStatement(sql_1);
		
		//pstmt1.setString(1, freelance.getFree_Id());
		//ResultSet rs1 = pstmt1.executeQuery();//??????	
		
			
		String sql_2 = "insert into project values(?,?,?,?,?)";//???????
		PreparedStatement pstmt2 = con.prepareStatement(sql_2);
		
		pstmt2.setString(1, project.getPro_Id());
		pstmt2.setString(2, project.getPro_Time());
		pstmt2.setString(3, project.getPro_Con_Id());
		pstmt2.setString(4, project.getPro_Free_Id());
		pstmt2.setString(5, project.getPro_Content());
		
		return pstmt2.executeUpdate() ;
			
		
	}
	
	//???
			public ResultSet list(Connection con,Project project)throws Exception {
				StringBuffer sb = new StringBuffer("select * from project");
				
				
				if (project.getPro_Time()!=null) {
					sb.append(" and Pro_Time like '%"+project.getPro_Time()+"%'");
					
				}
				PreparedStatement pstmt2 = con.prepareStatement(sb.toString().replace("and", "where"));
				
				return pstmt2.executeQuery();
			}
			
			
			//???
			public int delete(Connection con,String Pro_Id) throws Exception{
				String sql="delete from project where Pro_Id=?";
						PreparedStatement pstm=con.prepareStatement(sql);
				pstm.setString(1, Pro_Id);
				return pstm.executeUpdate();
				
			}
		
		
		
		//???
		public int update(Connection con,Project project)throws Exception {
			String sql="update project set Pro_Id=?,Pro_Time=?,Pro_Free_Id=?,Pro_Con_Id=?,Pro_Content=? where Pro_Id=?";
			PreparedStatement pstm=con.prepareStatement(sql);
	        pstm.setString(1, project.getPro_Id());
	        pstm.setString(2, project.getPro_Time());
	        pstm.setString(3, project.getPro_Free_Id());
	        pstm.setString(4, project.getPro_Con_Id());
	        pstm.setString(5, project.getPro_Content());
	        
	        
	        pstm.setString(6, project.getPro_Id());
	        
	        return pstm.executeUpdate();
		}
	
	
	
	
	
}
