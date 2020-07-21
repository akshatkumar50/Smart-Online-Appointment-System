package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ShowAppointment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAppointment frame = new ShowAppointment();
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
	public ShowAppointment() {}
	public ShowAppointment(String id) {
		//String id = "U02";
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("DocMed");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JLabel lblShwoAppointments = new JLabel("Show Appointments\r\n");
		lblShwoAppointments.setForeground(new Color(50, 205, 50));
		lblShwoAppointments.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Select time period:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Verdana", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Today's", "All"}));
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		
		JButton btnNewButton = new JButton("Back to Portal");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserPortal up= new UserPortal(id);
				up.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		 
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					String choc = comboBox.getSelectedItem().toString();
					
					if(choc.equals("Today's"))
					{
						PreparedStatement ps = conn.prepareStatement("select * from appointment where app_date =? and pat_id =? and status =1 ORDER BY app_id DESC");
						  ps.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
						  ps.setString(2,id);
						  JOptionPane.showMessageDialog(null,"2");
						  ResultSet res = ps.executeQuery();
						  System.out.print(LocalDate.now()+"  "+id);
						  table.setModel(DbUtils.resultSetToTableModel(res));
						  
					}
					else if(choc.equals("All"))
					{
						PreparedStatement ps = conn.prepareStatement("select * from appointment where  pat_id =?  and status =1  ORDER BY app_id DESC");
						  ps.setString(1,id);
						  JOptionPane.showMessageDialog(null,"2");
						  ResultSet res = ps.executeQuery();
						  System.out.print(LocalDate.now()+"  "+id);
						  table.setModel(DbUtils.resultSetToTableModel(res));
						  
					}
				} catch (Exception e) {e.printStackTrace();} 
				  
				
				
				
				/*
				 * UserPortal up= new UserPortal(); up.setVisible(true); dispose();
				 */
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(238))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblShwoAppointments, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(169))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(43)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnNewButton)
					.addGap(147))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblShwoAppointments, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
