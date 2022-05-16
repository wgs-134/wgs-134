package com.Ching.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Ching.dao.FreelanceDao;
import com.Ching.model.Consumer;
import com.Ching.model.Freelance;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FreelanceManageInterFrm extends JInternalFrame {
	private JTable FreelanceTable;
	
	private DbUtil dbUtil=new DbUtil();
	private FreelanceDao freelanceDao=new FreelanceDao();	
	private JTextField s_FreelanceTypeTxt;
	private JTextField FreelanceIdTxt;
	private JTextField FreelanceTypeTxt;
	private JTextField FreelanceNameTxt;
	private JTextField FreelancePhoneIxt;
	
	private JTextArea FreelanceAddrTxt;

	/**
	 * Launch the application .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreelanceManageInterFrm frame = new FreelanceManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FreelanceManageInterFrm() {
		setBackground(new Color(0, 0, 153));
		getContentPane().setBackground(new Color(0, 102, 153));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u81EA\u7531\u804C\u4E1A\u8005\u7BA1\u7406");
		setBounds(100, 100, 646, 639);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7C7B\u522B\uFF1A");
		
		s_FreelanceTypeTxt = new JTextField();
		s_FreelanceTypeTxt.setColumns(10);
		
		
		//��ѯ��ť
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreelanceSearchActionPerformed(e);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(FreelanceManageInterFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_FreelanceTypeTxt, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_FreelanceTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		FreelanceIdTxt = new JTextField();
		FreelanceIdTxt.setEditable(false);
		FreelanceIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\uFF1A");
		
		FreelanceTypeTxt = new JTextField();
		FreelanceTypeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		
		FreelanceNameTxt = new JTextField();
		FreelanceNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\uFF1A");
		
		FreelancePhoneIxt = new JTextField();
		FreelancePhoneIxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5730\u5740\uFF1A");
		
		FreelanceAddrTxt = new JTextArea();
		
		//�޸İ�ť
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreelanceUpdateActionEvent();
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FreelanceManageInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		
		
		//ɾ����ť
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FreelanceDeleteActionEvent();
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(FreelanceManageInterFrm.class.getResource("/images/\u5220 \u9664 .png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(FreelanceIdTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(FreelanceNameTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
									.addGap(38)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(FreelanceTypeTxt, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
										.addComponent(FreelancePhoneIxt, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
								.addComponent(FreelanceAddrTxt, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(88))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(FreelanceIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FreelanceTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(FreelanceNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(FreelancePhoneIxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(FreelanceAddrTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		//�����
		FreelanceTable = new JTable();
		FreelanceTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FreelanceTableMousePressed(e);
			
				
			}
		});
		FreelanceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7C7B\u522B", "\u59D3\u540D", "\u7535\u8BDD", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		FreelanceTable.getColumnModel().getColumn(0).setPreferredWidth(44);
		FreelanceTable.getColumnModel().getColumn(1).setPreferredWidth(41);
		FreelanceTable.getColumnModel().getColumn(4).setPreferredWidth(133);
		scrollPane.setViewportView(FreelanceTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Freelance());
		FreelanceAddrTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
	}
	
	
	//ɾ���¼�
	protected void FreelanceDeleteActionEvent() {
		// TODO Auto-generated method stub
		String Free_Id =FreelanceIdTxt.getText();
		if (StringUtil.isEmpty(Free_Id)) {
			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���ļ�¼��");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if (n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=    freelanceDao.delete(con, Free_Id);
				
				if (deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					this.resetValue();
					this.fillTable(new Freelance());
					
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		}
	}

	//�޸��¼�
	private void FreelanceUpdateActionEvent() {
		// TODO Auto-generated method stub
		
		String Free_Id =FreelanceIdTxt.getText();
		String Free_Type =FreelanceTypeTxt.getText();
		String Free_Name =FreelanceNameTxt.getText();
		String Free_Phone =FreelancePhoneIxt.getText();
		String Free_Addr =FreelanceAddrTxt.getText();
		
		if (StringUtil.isEmpty(Free_Id)) {
			JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵļ�¼��");
			return;
		}
		
		if (StringUtil.isEmpty(Free_Type)) {
			JOptionPane.showMessageDialog(null, "����ְҵ�������Ϊ�գ�");
			return;
		}
		
		if (StringUtil.isEmpty(Free_Name)) {
			JOptionPane.showMessageDialog(null, "����ְҵ����������Ϊ�գ�");
			return;
		}
		
		if (StringUtil.isEmpty(Free_Phone)) {
			JOptionPane.showMessageDialog(null, "����ְҵ�ߵ绰����Ϊ�գ�");
			return;
		}
		
		if (StringUtil.isEmpty(Free_Addr)) {
			JOptionPane.showMessageDialog(null, "����ְҵ�ߵ�ַ����Ϊ�գ�");
			return;
		}
		
		
		
		Freelance freelance=new Freelance(Free_Id, Free_Type, Free_Name, Free_Phone, Free_Addr);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNumber=  freelanceDao.update(con, freelance);
			
			if (modifyNumber==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				this.resetValue();
				this.fillTable(new Freelance());
				
			}else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	//������¼�
	private void FreelanceTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		int row= FreelanceTable.getSelectedRow();
		FreelanceIdTxt.setText( (String)FreelanceTable.getValueAt(row, 0));  
		FreelanceTypeTxt.setText( (String)FreelanceTable.getValueAt(row, 1));  
		FreelanceNameTxt.setText((String)FreelanceTable.getValueAt(row, 2));
		FreelancePhoneIxt.setText((String)FreelanceTable.getValueAt(row, 3));
		FreelanceAddrTxt.setText((String)FreelanceTable.getValueAt(row, 4));
		
		
	}

	//��ѯ����
	private void FreelanceSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_Free_Type=this.s_FreelanceTypeTxt.getText(); 
		Freelance freelance=new Freelance();
		freelance.setFree_Type(s_Free_Type);
		this.fillTable(freelance);
	}

	//��ʼ�����
	
	private void fillTable(Freelance freelance) {
		DefaultTableModel dtm=(DefaultTableModel)FreelanceTable.getModel();
		dtm.setRowCount(0);//��������Ϊ0
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs  = freelanceDao.list(con, freelance);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Free_Id"));
				v.add(rs.getString("Free_Type"));
				v.add(rs.getString("Free_Name"));
				v.add(rs.getString("Free_Phone"));
				v.add(rs.getString("Free_Addr"));
				dtm.addRow(v);

			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	//���ñ�
		private void resetValue() {
			this.FreelanceNameTxt.setText("");
			this.FreelancePhoneIxt.setText("");
			this.FreelanceAddrTxt.setText("");
			this.FreelanceIdTxt.setText("");
			this.FreelanceTypeTxt.setText("");
			
		}
}
