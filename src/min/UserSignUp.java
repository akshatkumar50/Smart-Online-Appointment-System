package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;

public class UserSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private String city;
	private String state;
	private String postal;
	private double latitude;
	private double longitude;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignUp frame = new UserSignUp();
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
	public UserSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("DocMed\r\n");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		
		JLabel lblNewLabel_1 = new JLabel("User Sign Up");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		
		JLabel lblNewLabel_2 = new JLabel("Name:\r\n");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sex:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Contact Number:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("City:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("State:\r\n");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Blood Group:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pre-medical Conditions:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hyper Tension", "Dibeties", "Cancer", "Cardiac Operations","Brain Hamerage","Kideny Operation"}));
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I here by give my concern that, I accept all the terms & conditions of DocMed.");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		

        try {
        URL ipapi = new URL("https://ipapi.co/latlong/");
        URLConnection c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");
        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        String location[] = reader.readLine().split(",");
        latitude = (Double.valueOf(location[0]));
        longitude = (Double.valueOf(location[1]));
        reader.close();
        
        ipapi = new URL("https://ipapi.co/postal/");
        c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");
        reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        postal = (reader.readLine());
        reader.close();
        
        ipapi = new URL("https://ipapi.co/city/");
        c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");
        reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        city = (reader.readLine());
        reader.close();
        
        ipapi = new URL("https://ipapi.co/region/");
        c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");
        reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        state = (reader.readLine());
        reader.close();}catch(IOException e) {System.out.println("IO Exception");}
        
        System.out.println(city+" "+state+" "+postal);
        System.out.println(latitude+" "+longitude);
        
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					  Class.forName("com.mysql.jdbc.Driver"); 
					  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					  //JOptionPane.showMessageDialog(null,"1");
					  PreparedStatement stmt = conn.prepareStatement("select contact from userinfo");
					  //JOptionPane.showMessageDialog(null,"2");
					  ResultSet res = stmt.executeQuery();
					 // JOptionPane.showMessageDialog(null,"3");
					String name = textField.getText();
					//JOptionPane.showMessageDialog(null,"3.1");
					int ag =Integer.parseInt(textField_1.getText()) ;
					//JOptionPane.showMessageDialog(null,"3.2");
					int cont =Integer.parseInt(textField_2.getText());
					//JOptionPane.showMessageDialog(null,"3.3");
					String city = textField_3.getText();
					//JOptionPane.showMessageDialog(null,"4");
					while(res.next()) {
						JOptionPane.showMessageDialog(null,"in loop");
							if(cont==res.getInt(1))
								{
								JOptionPane.showMessageDialog(null,"Regristration already exist");
								UserLogIn uli1= new UserLogIn();
								uli1.setVisible(true);
								dispose();
								}
					}
				//JOptionPane.showMessageDialog(null,"out loop");
					String state = textField_4.getText();
					String blo = textField_5.getText();
					String sex; 
					 if(rdbtnNewRadioButton.isSelected()){
				            sex="Male";
				        }
				        else if(rdbtnNewRadioButton_1.isSelected()){
				        	sex="Female";
				        }
				        else
				        	sex="Other";
					//JOptionPane.showMessageDialog(null,"5");
					res.last();                         // record pointer is placed on the last row
					int counter = res.getRow();
					String usr = "U0"+(++counter);
					JOptionPane.showMessageDialog(null,"usr"+usr);
					String dis = comboBox.getSelectedItem().toString();
					String pass = passwordField.getText();
					/*
					 * String posta = postal; Double lat = latitude; Double log = longitude;
					 */
					//JOptionPane.showMessageDialog(null,"checks done");
					String query = "insert into userinfo (user_id,name,age,sex,contact,blood,pincode,password,disease,city,state,lat,log)" +"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(query);

					ps.setString(1,usr);
					ps.setString(2,name);
					ps.setInt(3,ag);
					ps.setInt(5,cont);
					ps.setString(4,sex);
					ps.setString(6,blo);
					ps.setString(7,postal);
					ps.setString(8,pass);
					ps.setString(9,dis);
					ps.setString(10,city);
					ps.setString(11,state);
					ps.setDouble(12,latitude);
					ps.setDouble(13,longitude);
					//JOptionPane.showMessageDialog(null,"items placed ready to execute");
					if(chckbxNewCheckBox.isSelected())
					if(ps.executeUpdate()!=0)
							{JOptionPane.showMessageDialog(null,"Regristration Successful");
							UserLogIn uli1= new UserLogIn();
							uli1.setVisible(true);
							dispose();
							} 
					else { JOptionPane.showMessageDialog(null,"Invalid username or password");
					UserSignUp uli1= new UserSignUp();
					uli1.setVisible(true);
					dispose();
					}
					 
					 							
					}catch(Exception e1) {e1.printStackTrace();}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		JLabel lblNewLabel_10 = new JLabel("Back to Sign In");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserLogIn uli2= new UserLogIn();
				uli2.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_9_1 = new JLabel("Password:");
		lblNewLabel_9_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(225)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(66, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addGap(47))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_5)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_8)
												.addComponent(lblNewLabel_9_1)
												.addComponent(lblNewLabel_9))
											.addGap(59)))
									.addGap(13))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_7)
									.addGap(80)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnNewRadioButton_1)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField, Alignment.LEADING)
									.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordField, Alignment.LEADING)
									.addComponent(textField_5, Alignment.LEADING)
									.addComponent(textField_3, Alignment.LEADING)
									.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
									.addComponent(textField_4, Alignment.LEADING)))))
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(251)
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(248, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(243)
					.addComponent(btnNewButton)
					.addContainerGap(266, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(chckbxNewCheckBox)
					.addGap(90))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(chckbxNewCheckBox)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblNewLabel_10)
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
