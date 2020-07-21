package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DocEditDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static ResultSet find(String a) {
		try{Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
		/* JOptionPane.showMessageDialog(null,"connection succesfull"); */
		String query = "select * from doctorinfo where doc_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,a);
		ResultSet rs = ps.executeQuery();
		return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocEditDetails frame = new DocEditDetails("D01");
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
	public DocEditDetails() {}
	public DocEditDetails(String id) {
		ResultSet rs = find(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Registration Number:");
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JLabel label_1 = new JLabel("Name:\r\n");
		label_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_2 = new JLabel("Sex:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_3 = new JLabel("Age:");
		label_3.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_4 = new JLabel("City:");
		label_4.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_5 = new JLabel("State:\r\n");
		label_5.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_6 = new JLabel("Blood Group:");
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_7 = new JLabel("Contact Number:");
		label_7.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JButton button = new JButton("Back to Portal\r\n");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Doc_Portal dp=new Doc_Portal(id);
				dp.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JLabel label_8 = new JLabel("DocMed");
		label_8.setForeground(SystemColor.textHighlight);
		label_8.setFont(new Font("Verdana", Font.BOLD, 30));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setEnabled(true);
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		JLabel label_9 = new JLabel("Doctor Details");
		label_9.setForeground(new Color(50, 205, 50));
		label_9.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel label_7_1 = new JLabel("Area:");
		label_7_1.setFont(new Font("Verdana", Font.BOLD, 15));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		try {
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				textField.setText(rs.getString("name"));
				textField_1.setText(String.valueOf(rs.getInt("age")));
				textField_2.setText(String.valueOf(rs.getInt("contact")));
				textField_5.setText(rs.getString("state"));
				textField_3.setText(rs.getString("pincode"));
				textField_4.setText(rs.getString("city"));
				System.out.println(rs.getString("blood"));
				textField_6.setText(rs.getString("blood"));
				textField_7.setText(rs.getString("license"));
				if(rs.getString("sex").equals("Male"))
					radioButton.setSelected(true);
				else if(rs.getString("sex").equals("Female"))
					radioButton_1.setSelected(true);
				else 
					radioButton_2.setSelected(true);
				
					
			}
			}catch(Exception e) {}
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
				/* JOptionPane.showMessageDialog(null,"connection succesfull"); */
				int cont = Integer.parseInt(textField_2.getText());
				String city = textField_4.getText();
				String state = textField_5.getText();
				String area = textField_3.getText();
				String query = "Update doctorinfo set contact =?,city=?,state=? where doc_id=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1,cont);
				ps.setString(2,city);
				ps.setString(3,state);
				ps.setString(4,id);
				
				if(ps.executeUpdate()!=0)
				{
					JOptionPane.showMessageDialog(null,"Updated Successfully");
					Doc_Portal dp=new Doc_Portal(id);
					dp.setVisible(true);
					dispose();
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid input"); 
				} 
				
						
				}catch(Exception e) {System.out.println("exception sql");}
				
			}
		});
		btnSave.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(150)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(165)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(31)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(label)
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_7_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addGap(18)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addGap(72)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(88)
							.addComponent(btnSave))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_7, Alignment.LEADING)
							.addComponent(textField_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(218)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(314, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
