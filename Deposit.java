package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Deposit extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JButton btnNewButton ;
	private JLabel lblNewLabel_1;
	private JLabel lblDeposit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Deposit() {
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField.setBounds(258, 69, 96, 19);
		contentPane.add(textField);
		
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Deposit Amount:");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 63, 163, 32);
		lblNewLabel.setOpaque(true);		
		contentPane.add(lblNewLabel);
		
		JLabel OTPlbl = new JLabel("Enter OTP(sent to email)");
		OTPlbl.setBackground(Color.CYAN);
		OTPlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		OTPlbl.setBounds(40, 139, 192, 32);
		OTPlbl.setOpaque(true);			
		contentPane.add(OTPlbl);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(258, 145, 96, 19);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(135, 198, 119, 32);
		contentPane.add(btnNewButton);
		
		lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setOpaque(true);
		lblDeposit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblDeposit.setBackground(Color.CYAN);
		lblDeposit.setBounds(135, 10, 79, 32);
		contentPane.add(lblDeposit);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\bank12.jpg"));
		lblNewLabel_1.setBounds(0, 0, 383, 263);
		contentPane.add(lblNewLabel_1);
	}
}
