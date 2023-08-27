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

public class Transfer extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JButton btnNewButton ;
    JTextField textField_2;
    private JLabel lblTransferToAnother;

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

	/**
	 * Create the frame.
	 */
	public Transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField.setBounds(306, 69, 126, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter USER ID of receiver");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 63, 192, 32);
		lblNewLabel.setOpaque(true);		
		contentPane.add(lblNewLabel);
		
		JLabel OTPlbl = new JLabel("Enter Amount to be sent:");
		OTPlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		OTPlbl.setBounds(40, 139, 192, 32);
		OTPlbl.setOpaque(true);		
		contentPane.add(OTPlbl);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(306, 145, 126, 19);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(218, 253, 118, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterTheOtpshared = new JLabel("Enter the OTP(Shared via EMAIL)");
		lblEnterTheOtpshared.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterTheOtpshared.setBounds(40, 211, 248, 32);
		lblEnterTheOtpshared.setOpaque(true);	
		contentPane.add(lblEnterTheOtpshared);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(306, 217, 126, 19);
		contentPane.add(textField_2);
		
		lblTransferToAnother = new JLabel("TRANSFER TO ANOTHER ACCOUNT");
		lblTransferToAnother.setOpaque(true);
		lblTransferToAnother.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblTransferToAnother.setBounds(96, 10, 310, 32);
		contentPane.add(lblTransferToAnother);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\bank9.jpg"));
		lblNewLabel_1.setBounds(0, 0, 489, 305);
		contentPane.add(lblNewLabel_1);
	}
}