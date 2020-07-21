package min;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.Toolkit;

public class FormTwo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTwo frame = new FormTwo();
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
	public void close() {
		WindowEvent winclose =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
	}
	public FormTwo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 750, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel.setBounds(303, 10, 161, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Dashboard");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(255, 63, 256, 32);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormThree f3= new FormThree();
				f3.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(28, 135, 207, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Doctor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormFour f4= new FormFour();
				f4.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton_1.setBounds(28, 224, 207, 44);
		contentPane.add(btnNewButton_1);
		
	
		
		Panel panel = new Panel();
		panel.setBounds(404, 135, 287, 44);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Total Doctors Registered:");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		Label label = new Label("XYZ");
		panel.add(label);
		label.setBackground(new Color(255, 255, 255));
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JButton btnNewButton_1_1 = new JButton("Log out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormOne f4= new FormOne();
				f4.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1_1.setBounds(28, 293, 207, 44);
		contentPane.add(btnNewButton_1_1);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");

				PreparedStatement ps = conn.prepareStatement("select count(*) from doctorinfo where status=1");
				  //JOptionPane.showMessageDialog(null,"2");
				  ResultSet res = ps.executeQuery();
				  while(res.next())
				  {System.out.print(res.getInt(1));
					  label.setText(String.valueOf(res.getInt(1)));
				  }
				   
				  conn.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}
