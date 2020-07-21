package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Scrollbar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class minor2 extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					minor2 frame = new minor2();
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
	public minor2() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(339, 138, 191, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 136, 51, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(92, 225, 135, 29);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root","");
					/* JOptionPane.showMessageDialog(null,"connection succesfull"); */
					String id = textField.getText();
					String pass = passwordField.getText();
					String query = "select doc_id,password from doctorinfo where doc_id=? and password=? and status='1'";
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1,id);
					ps.setString(2,pass);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"Login Successful");
						Doc_Portal dp = new Doc_Portal(id);
						dispose();
						dp.setVisible(true);
						
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid username or password"); 
					} 
					
							
					}catch(Exception e) {System.out.println("exception sql");}
			
			}
		});
		btnNewButton.setBounds(252, 296, 108, 32);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("DocMed");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel_2.setBackground(UIManager.getColor("PopupMenu.background"));
		lblNewLabel_2.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		lblNewLabel_2.setBounds(234, 10, 140, 51);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor's Log In");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(50, 205, 50));
		lblNewLabel_3.setBounds(231, 71, 160, 37);
		getContentPane().add(lblNewLabel_3);
		/*
		 * JLabel lblNewLabel_4 = new JLabel("Forgot Password");
		 * lblNewLabel_4.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent arg0) { Forgot_Pass_Doc fpd =
		 * new Forgot_Pass_Doc(); fpd.setVisible(true);
		 * 
		 * } }); lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		 * lblNewLabel_4.setForeground(new Color(0, 0, 255));
		 * lblNewLabel_4.setBounds(252, 353, 118, 29);
		 * getContentPane().add(lblNewLabel_4);
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(339, 225, 191, 28);
		getContentPane().add(passwordField);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 447);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
