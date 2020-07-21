package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDetailsEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetailsEdit frame = new UserDetailsEdit();
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
	public static ResultSet find(String a) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
		/* JOptionPane.showMessageDialog(null,"connection succesfull"); */
		String query = "select * from userinfo where user_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,a);
		ResultSet rs = ps.executeQuery();
		return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UserDetailsEdit() {}
	public UserDetailsEdit(String id) {
		ResultSet rs = find(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Name:\r\n");
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setEnabled(true);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Age:");
		label_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("Sex:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton.setEnabled(false);
		radioButton.setBackground(Color.WHITE);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton_1.setEnabled(false);
		radioButton_1.setBackground(Color.WHITE);
		
		JRadioButton radioButton_2 = new JRadioButton("Other");
		radioButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		radioButton_2.setEnabled(false);
		radioButton_2.setBackground(Color.WHITE);
		
		JLabel label_3 = new JLabel("Contact Number:");
		label_3.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("City:");
		label_4.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("State:\r\n");
		label_5.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblArea = new JLabel("Pincode:");
		lblArea.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		JLabel label_4_1 = new JLabel("Blood:");
		label_4_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		try {
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				textField.setText(rs.getString("name"));
				textField_1.setText(String.valueOf(rs.getInt("age")));
				textField_2.setText(String.valueOf(rs.getInt("contact")));
				textField_4.setText(rs.getString("state"));
				textField_5.setText(rs.getString("pincode"));
				textField_6.setText(rs.getString("blood"));
				textField_3.setText(rs.getString("city"));
				if(rs.getString("sex").equals("Male"))
					radioButton.setSelected(true);
				else if(rs.getString("sex").equals("Female"))
					radioButton_1.setSelected(true);
				else 
					radioButton_2.setSelected(true);
				
					
			}
			}catch(Exception e) {}
		
		JButton button = new JButton("Back to Portal\r\n");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserPortal up= new UserPortal(id);
				up.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel lblEditUserDetails = new JLabel("Edit User Details");
		lblEditUserDetails.setForeground(new Color(50, 205, 50));
		lblEditUserDetails.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel label_8 = new JLabel("DocMed");
		label_8.setForeground(SystemColor.textHighlight);
		label_8.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("Save Changes\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
				/* JOptionPane.showMessageDialog(null,"connection succesfull"); */
				int cont = Integer.parseInt(textField_2.getText());
				String blood = textField_6.getText();
				String city = textField_3.getText();
				String state = textField_4.getText();
				
				String query = "Update userinfo set contact =?,blood =?,city=?,state=? where user_id=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1,cont);
				ps.setString(3,city);
				ps.setString(4,state);
				ps.setString(2,blood);
				ps.setString(5,id);
				
				if(ps.executeUpdate()!=0)
				{
					JOptionPane.showMessageDialog(null,"Updated Successfully");
					UserPortal up=new UserPortal(id);
					up.setVisible(true);
					dispose();
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid username or password"); 
				} 
				
						
				}catch(Exception e) {System.out.println("exception sql");}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(277)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(247)
							.addComponent(lblEditUserDetails)))
					.addContainerGap(255, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addGap(95))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(btnNewButton)
					.addGap(157))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblArea)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(label_4_1)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)))
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEditUserDetails, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblArea, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
