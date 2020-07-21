package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class SecDelete extends JFrame {

	private JPanel contentPane;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecDelete frame = new SecDelete();
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
	public SecDelete() {}
	public SecDelete(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 646, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel.setBounds(263, 10, 156, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Executive");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(242, 62, 202, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Executive Contact:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(27, 183, 278, 35);
		contentPane.add(lblNewLabel_2);
		
		search = new JTextField();
		search.setBounds(259, 185, 271, 33);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Executive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root",""); 
				String lic = search.getText();
				String query = "Update secinfo set status = 0 where contact=? and doc_ref=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1,lic);
				ps.setString(2,id);
				 if(ps.executeUpdate()!=0) {
					JOptionPane.showMessageDialog(null,"Deleted Successful");
					Doc_Portal up= new Doc_Portal(id);
					up.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"No such secratory avaliable"); 
				} 
				
						
				}catch(Exception e) {System.out.println("exception sql");}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(132, 314, 202, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBackToPortal = new JButton("back to portal");
		btnBackToPortal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Doc_Portal up= new Doc_Portal(id);
				up.setVisible(true);
				dispose();
				
			}
		});
		btnBackToPortal.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBackToPortal.setBounds(354, 314, 202, 23);
		contentPane.add(btnBackToPortal);
	}
}
