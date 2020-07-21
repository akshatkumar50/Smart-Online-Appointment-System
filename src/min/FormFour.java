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
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class FormFour extends JFrame {

	private JPanel contentPane;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFour frame = new FormFour();
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
	public FormFour() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Delete Doctor");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(242, 62, 202, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Licence Number:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(27, 183, 278, 35);
		contentPane.add(lblNewLabel_2);
		
		search = new JTextField();
		search.setBounds(315, 183, 271, 33);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/minor","root",""); 
				String lic = search.getText();
				String query = "Update doctorinfo set status = 0 where license=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1,lic);
				 if(ps.executeUpdate()!=0) {
					JOptionPane.showMessageDialog(null,"Deleted Successful");
					
					FormTwo f2= new FormTwo();
					f2.setVisible(true);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null,"No suc doctor avaliable"); 
				} 
				
						
				}catch(Exception e) {System.out.println("exception sql");}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(155, 314, 165, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBackToPortal = new JButton("Back to portal");
		btnBackToPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					FormTwo uli1= new FormTwo();
					uli1.setVisible(true);
					dispose();
			}
		});
		btnBackToPortal.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBackToPortal.setBounds(372, 316, 165, 23);
		contentPane.add(btnBackToPortal);
	}
}
