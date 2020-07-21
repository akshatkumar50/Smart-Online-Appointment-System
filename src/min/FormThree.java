package min;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
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
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FormThree extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField contact;
	private JTextField licence;
	private JTextField blood;
	private JTextField address;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThree frame = new FormThree();
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
	public FormThree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 650, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel.setBounds(253, 10, 158, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Doctor");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(243, 66, 168, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(170, 131, 81, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3.setBounds(190, 178, 70, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_4.setBounds(110, 269, 131, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("License Id:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5.setBounds(120, 316, 131, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_6.setBounds(100, 358, 151, 40);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_7.setBounds(144, 409, 132, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Password:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_9.setBounds(120, 572, 122, 40);
		contentPane.add(lblNewLabel_9);
		
		name = new JTextField();
		name.setBounds(317, 138, 168, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(317, 177, 168, 32);
		contentPane.add(age);
		age.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(317, 269, 168, 32);
		contentPane.add(contact);
		contact.setColumns(10);
		
		licence = new JTextField();
		licence.setBounds(317, 316, 168, 32);
		contentPane.add(licence);
		licence.setColumns(10);
		
		blood = new JTextField();
		blood.setBounds(317, 362, 168, 32);
		contentPane.add(blood);
		blood.setColumns(10);
		
		address = new JTextField();
		address.setBounds(317, 407, 168, 31);
		contentPane.add(address);
		address.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(317, 581, 168, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Sex:");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(190, 223, 50, 36);
		contentPane.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(317, 219, 168, 32);
		contentPane.add(textField);
		
		JLabel lblNewLabel_6_1 = new JLabel("State:");
		lblNewLabel_6_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(173, 490, 67, 28);
		contentPane.add(lblNewLabel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(317, 493, 168, 32);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("City:");
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(190, 448, 57, 32);
		contentPane.add(lblNewLabel_5_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(317, 448, 168, 32);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Pincode:");
		lblNewLabel_6_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_6_1_1.setBounds(144, 530, 98, 32);
		contentPane.add(lblNewLabel_6_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(317, 535, 168, 32);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_9_1 = new JLabel("Latitude:");
		lblNewLabel_9_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_9_1.setBounds(139, 615, 101, 40);
		contentPane.add(lblNewLabel_9_1);
		

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(317, 665, 168, 32);
		contentPane.add(textField_4);
		
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Longitude:");
		lblNewLabel_9_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_9_1_1.setBounds(120, 665, 131, 40);
		contentPane.add(lblNewLabel_9_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(317, 624, 168, 32);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					  Class.forName("com.mysql.jdbc.Driver"); 
					  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					  //JOptionPane.showMessageDialog(null,"1");
					  PreparedStatement stmt = conn.prepareStatement("select license from doctorinfo");
					 // JOptionPane.showMessageDialog(null,"2");
					  ResultSet res = stmt.executeQuery();
					  //JOptionPane.showMessageDialog(null,"3");
					String nadoc = name.getText();
					int ag =Integer.parseInt(age.getText()) ;
					int cont =Integer.parseInt(contact.getText());
					String lic = licence.getText();
					//JOptionPane.showMessageDialog(null,"4");
					while(res.next()) {
						//JOptionPane.showMessageDialog(null,"in loop");
							if(lic.equalsIgnoreCase(res.getString(1)))
								{
								JOptionPane.showMessageDialog(null,"Regristration already exist");
								FormThree f3= new FormThree();
								f3.setVisible(true);
								dispose();
								}
					}
				//	JOptionPane.showMessageDialog(null,"out loop");
					String blo = blood.getText();
					String adds = address.getText();
					//JOptionPane.showMessageDialog(null,"5");
					res.last();                         // record pointer is placed on the last row
					int counter = res.getRow();
					String usr = "D0"+(++counter);
					String sex = textField.getText();
					String city = textField_2.getText();
					String state = textField_1.getText();
					int pin = Integer.parseInt(textField_3.getText());
					Double lat = Double.parseDouble(textField_5.getText());
					Double log = Double.parseDouble(textField_4.getText());
					String ads = address.getText();
					//JOptionPane.showMessageDialog(null,"usr"+usr);
					String pass = passwordField.getText();
					//JOptionPane.showMessageDialog(null,"checks done");
					String query = "insert into doctorinfo (doc_id,name,age,sex,contact,license,blood,password,pincode,status,city,state,lat,log,address)" +"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(query);

					ps.setString(1,usr);
					ps.setString(2,nadoc);
					ps.setInt(3,ag);
					ps.setString(4,sex);
					ps.setInt(5,cont);
					ps.setString(6,lic);
					ps.setString(7,blo);
					
					ps.setString(8,pass);
					ps.setInt(9,pin);
					ps.setInt(10,1);
					ps.setString(11,city);
					ps.setString(12,state);
					ps.setDouble(13,lat);
					ps.setDouble(14,log);
					ps.setString(15,ads);
					//JOptionPane.showMessageDialog(null,"items placed ready to execute");
					if(ps.executeUpdate()!=0)
							{
							JOptionPane.showMessageDialog(null,"DOC id:"+usr+"\nRegristration Successful");
							FormTwo f2= new FormTwo();
							f2.setVisible(true);
							dispose();
							} 
					else { JOptionPane.showMessageDialog(null,"Invalid Inputs");
					FormThree uli1= new FormThree();
					uli1.setVisible(true);
					dispose();
					}
					 
					 							
					}catch(Exception e1) {e1.printStackTrace();}
			}
		});
		btnNewButton.setBounds(154, 706, 151, 32);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnBackToPortal = new JButton("Back to Portal");
		btnBackToPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					FormTwo uli1= new FormTwo();
					uli1.setVisible(true);
					dispose();
			}
		});
		btnBackToPortal.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBackToPortal.setBounds(356, 708, 183, 32);
		contentPane.add(btnBackToPortal);
		
		
		
		
		
	}
}
