package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FormFive extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFive frame = new FormFive();
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
	public FormFive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	

		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 52));
		lblNewLabel.setBounds(197, 29, 277, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Admin");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 34));
		lblNewLabel_1.setBounds(207, 115, 304, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_2.setBounds(128, 212, 97, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_3.setBounds(128, 259, 97, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No:");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(83, 306, 182, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_7.setBounds(93, 358, 151, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("User Id:");
		lblNewLabel_8.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_8.setBounds(114, 400, 137, 35);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password:");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_9.setBounds(93, 446, 151, 40);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Add Admin");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setBounds(238, 510, 151, 32);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(343, 216, 168, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(343, 267, 168, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 312, 168, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(343, 355, 168, 31);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(343, 397, 168, 33);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(343, 444, 168, 32);
		contentPane.add(passwordField);
	}
}

