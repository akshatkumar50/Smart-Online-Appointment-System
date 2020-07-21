package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SecSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecSignUp frame = new SecSignUp();
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
	public SecSignUp() {}
	public SecSignUp(String id) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("DocMed\r\n");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JLabel lblSecratarySignUp = new JLabel("Executive Sign Up");
		lblSecratarySignUp.setForeground(new Color(50, 205, 50));
		lblSecratarySignUp.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("Name:\r\n");
		label_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("Age:");
		label_3.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("Sex:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton.setBackground(Color.WHITE);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton_1.setBackground(Color.WHITE);
		
		JRadioButton radioButton_2 = new JRadioButton("Other");
		radioButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton_2.setBackground(Color.WHITE);
		
		JLabel label_5 = new JLabel("Contact Number:");
		label_5.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_6 = new JLabel("City:");
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_7 = new JLabel("State:\r\n");
		label_7.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_8 = new JLabel("Blood Group:");
		label_8.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel label_9 = new JLabel("Password:");
		label_9.setFont(new Font("Verdana", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		
		JButton button = new JButton("Sign Up");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					  Class.forName("com.mysql.jdbc.Driver"); 
					  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					  //JOptionPane.showMessageDialog(null,"1");
					  PreparedStatement stmt = conn.prepareStatement("select contact from secinfo");
					  //JOptionPane.showMessageDialog(null,"2");
					  ResultSet res = stmt.executeQuery();
					  //JOptionPane.showMessageDialog(null,"3");
					String name = textField.getText();
					//JOptionPane.showMessageDialog(null,"3.1");
					int ag =Integer.parseInt(textField_1.getText()) ;
					//JOptionPane.showMessageDialog(null,"3.2");
					int cont =Integer.parseInt(textField_2.getText());
					//JOptionPane.showMessageDialog(null,"3.3");
					String city = textField_3.getText();
					//JOptionPane.showMessageDialog(null,"4");
					while(res.next()) {
						//JOptionPane.showMessageDialog(null,"in loop");
							if(cont==res.getInt(1))
								{
								JOptionPane.showMessageDialog(null,"Regristration already exist");
								Doc_Portal dp= new Doc_Portal(id);
								dp.setVisible(true);
								dispose();
								}
					}
				JOptionPane.showMessageDialog(null,"out loop");
					String state = textField_4.getText();
					String blo = textField_5.getText();
					String sex; 
					 if(radioButton.isSelected()){
				            sex="Male";
				        }
				        else if(radioButton_1.isSelected()){
				        	sex="Female";
				        }
				        else
				        	sex="Other";
					//JOptionPane.showMessageDialog(null,"5");
					res.last();                         // record pointer is placed on the last row
					int counter = res.getRow();
					String usr = "S0"+(++counter);
					JOptionPane.showMessageDialog(null,"usr: "+usr);
					String pass = passwordField.getText();
					/*
					 * String posta = postal; Double lat = latitude; Double log = longitude;
					 */
					//JOptionPane.showMessageDialog(null,"checks done");
					String query = "insert into secinfo (sec_id,name,age,sex,contact,blood,password,city,state,status,doc_ref)" +"values (?,?,?,?,?,?,?,?,?,1,?)";
					PreparedStatement ps = conn.prepareStatement(query);

					ps.setString(1,usr);
					ps.setString(2,name);
					ps.setInt(3,ag);
					ps.setInt(5,cont);
					ps.setString(4,sex);
					ps.setString(6,blo);
					ps.setString(7,pass);
					ps.setString(8,city);
					ps.setString(9,state);
					ps.setString(10,id);
					//JOptionPane.showMessageDialog(null,"items placed ready to execute");
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
		button.setFont(new Font("Verdana", Font.BOLD, 15));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Doc_Portal up= new Doc_Portal(id);
				up.setVisible(true);
				dispose();
				
			}
		});
		JButton btnBackToPortal = new JButton("Back to Portal");
		btnBackToPortal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Doc_Portal up= new Doc_Portal(id);
				up.setVisible(true);
				dispose();
				
			}
		});
		
		btnBackToPortal.setFont(new Font("Verdana", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(161)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(86)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(101)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(101)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(101)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(85)
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addGap(80)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(185)
							.addComponent(lblSecratarySignUp))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(btnBackToPortal, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSecratarySignUp, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBackToPortal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}