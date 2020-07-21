package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JScrollPane;

public class SecPortal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecPortal frame = new SecPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */public SecPortal() {}
	public SecPortal(String id) {
		String doc=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");

				PreparedStatement ps = conn.prepareStatement("select doc_ref from secinfo where sec_id =? and status =1");
				  ps.setString(1,id);
				  //JOptionPane.showMessageDialog(null,"2");
				  ResultSet res = ps.executeQuery();
				  res.next();
				   doc = res.getString(1);
				   conn.close();
		} catch (Exception e) {e.printStackTrace();} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		
		JLabel lblNewLabel_1 = new JLabel("Executive Portal\r\n");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");

				PreparedStatement ps = conn.prepareStatement("select * from appointment where app_date =? and doc_id =? and status =1 ORDER BY app_id DESC");
				  ps.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
				  ps.setString(2,doc);
				  //JOptionPane.showMessageDialog(null,doc);
				  ResultSet res = ps.executeQuery();
				  System.out.print(LocalDate.now()+"  "+id);
				  table.setModel(DbUtils.resultSetToTableModel(res));
		} catch (Exception e) {e.printStackTrace();} 
		JButton btnNewButton = new JButton("Confirm Booking");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					String choc = textField.getText();

						PreparedStatement ps = conn.prepareStatement("Update appointment set confirm =1 where pat_id=?");
						  ps.setString(1,choc);
						  //JOptionPane.showMessageDialog(null,"2");
						  if(ps.executeUpdate()!=0)
							  JOptionPane.showMessageDialog(null,"appointmnet confirmed");
						  System.out.print(LocalDate.now()+"  "+choc);
				} catch (Exception e) {e.printStackTrace();}
				SecLogIn sli= new SecLogIn();
				sli.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("LogOut\r\n");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SecLogIn sli= new SecLogIn();
				sli.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addGap(207))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(178)
					.addComponent(lblNewLabel_2)
					.addGap(34)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(236, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(218))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(284))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
