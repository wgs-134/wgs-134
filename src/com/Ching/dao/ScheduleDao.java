package com.Ching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Ching.model.Consumer;
import com.Ching.model.Project;
import com.Ching.model.Schedule;

public class ScheduleDao {

	
	//���
			public int add(Connection con,Schedule schedule) throws Exception{

				
				//sql���
				//String sql_1="select * from freelance where Free_Id=?";//��ѯ����Ƿ����
				//PreparedStatement pstmt1 = con.prepareStatement(sql_1);
				
				//pstmt1.setString(1, freelance.getFree_Id());
				//ResultSet rs1 = pstmt1.executeQuery();//��ѯ���	
				
					
				String sql_2 = "insert into schedule values(?,?,?)";//�������
				PreparedStatement pstmt2 = con.prepareStatement(sql_2);
				
				pstmt2.setString(1, schedule.getSch_Id());
				pstmt2.setString(2, schedule.getSch_Time());
				pstmt2.setString(3, schedule.getSch_Free_Id());
				
				
				return pstmt2.executeUpdate() ;
					
				
			}
			
			//��ѯ
			public ResultSet list(Connection con,Schedule schedule)throws Exception {
				StringBuffer sb = new StringBuffer("select * from schedule");
				
				
				if (schedule.getSch_Id()!=null) {
					sb.append(" and Sch_Id like '%"+schedule.getSch_Id()+"%'");
					
				}
				PreparedStatement pstmt2 = con.prepareStatement(sb.toString().replace("and", "where"));
				
				return pstmt2.executeQuery();
			}
	
	
			//ɾ��
			public int delete(Connection con,String Sch_Id) throws Exception{
				String sql="delete from schedule where Sch_Id=?";
						PreparedStatement pstm=con.prepareStatement(sql);
				pstm.setString(1, Sch_Id);
				return pstm.executeUpdate();
				
			}
		
		
		
		//�޸�
		public int update(Connection con,Schedule schedule)throws Exception {
			String sql="update schedule set Sch_Id=?,Sch_Free_Id=?,Sch_Time=?where Sch_Id=?";
			PreparedStatement pstm=con.prepareStatement(sql);
	        pstm.setString(1, schedule.getSch_Id());
	        pstm.setString(2, schedule.getSch_Free_Id());
	        pstm.setString(3, schedule.getSch_Time());
	        
	        
	        
	        pstm.setString(4, schedule.getSch_Id());
	        
	        return pstm.executeUpdate();
		}
			
			
	
	
}
