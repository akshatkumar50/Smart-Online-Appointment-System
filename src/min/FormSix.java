package min;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class FormSix extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSix frame = new FormSix();
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
	public FormSix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("DocMed");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 52));
		lblNewLabel.setBounds(173, 11, 276, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Admin");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 38));
		lblNewLabel_1.setBounds(154, 97, 319, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search Admin");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_2.setBounds(58, 183, 217, 35);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(315, 183, 202, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 250, 481, 108);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Admin");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setBounds(204, 390, 165, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(347, 180, 161, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 242, 453, 117);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
