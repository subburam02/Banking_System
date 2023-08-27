package Project;

import java.awt.*;
import java.lang.Math;  
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JOptionPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.JRadioButton;
//import javax.swing.JScrollBar;
//import java.awt.List;
//import javax.swing.border.LineBorder;
//import java.awt.Color;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent; 
public class Newreg extends JFrame {
	 JPanel contentPane;
	JTextField textField;
	 JTextField textField_1;
	 JTextField txtDateOfBirth;
	 JTextField textField_2;
	JButton btnNewButtonReg;
	JRadioButton rdbtn1,rdbtn2,rdbtn3,rdbtn4;
	 JTextField email;
	 private JLabel lblNewLabel_3;
	public Newreg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(267, 53, 160, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 321, 150, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your Name:");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 53, 166, 19);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Phone Number:");
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(36, 319, 236, 18);
		lblNewLabel_1.setOpaque(true);		
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choose your account type");
		lblNewLabel_1_1.setBackground(Color.PINK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(35, 133, 209, 18);
		lblNewLabel_1_1.setOpaque(true);	
		contentPane.add(lblNewLabel_1_1);
		
		 rdbtn1 = new JRadioButton("Savings Account");
		 rdbtn1.setBackground(Color.YELLOW);
		rdbtn1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdbtn1.setBounds(270, 133, 150, 21);
		contentPane.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("Salary Account");
		rdbtn2.setBackground(Color.YELLOW);
		rdbtn2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdbtn2.setBounds(435, 133, 150, 21);
		contentPane.add(rdbtn2);
		
		 rdbtn3 = new JRadioButton("FD Account");
		 rdbtn3.setBackground(Color.YELLOW);
		rdbtn3.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdbtn3.setBounds(270, 177, 150, 21);
		contentPane.add(rdbtn3);
		
		 rdbtn4 = new JRadioButton("NRI Account\r\n");
		 rdbtn4.setBackground(Color.YELLOW);
		rdbtn4.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdbtn4.setBounds(435, 177, 150, 21);
		contentPane.add(rdbtn4);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth\r\n:");
		lblDateOfBirth.setBackground(Color.PINK);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDateOfBirth.setBounds(35, 90, 166, 19);
		lblDateOfBirth.setOpaque(true);
		
		contentPane.add(lblDateOfBirth);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtDateOfBirth.setText("");
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(267, 82, 174, 27);
		contentPane.add(txtDateOfBirth);
		
		JLabel lblNewUserRegisteration = new JLabel("NEW USER REGISTERATION");
		lblNewUserRegisteration.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewUserRegisteration.setBounds(132, 10, 295, 19);
		lblNewUserRegisteration.setOpaque(true);	
		contentPane.add(lblNewUserRegisteration);
		
		JLabel lblNewLabel_2 = new JLabel("Set your Password:\r\n");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(35, 370, 209, 19);
		lblNewLabel_2.setOpaque(true);	
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(267, 372, 160, 19);
		contentPane.add(textField_2);
		
		 btnNewButtonReg = new JButton("SUBMIT\r\n");
		 btnNewButtonReg.setForeground(Color.RED);
		/*btnNewButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int max=200000;
			int min=100000;
			int b = (int)(Math.random()*(max-min+1)+min);
			//Users s=new Users(textField.getText(),txtDateOfBirth.getText());
			JOptionPane.showMessageDialog(Newreg.this,"your generated new user id is "+b);
			}
		});
		*/
		btnNewButtonReg.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButtonReg.setBounds(314, 420, 127, 21);
		contentPane.add(btnNewButtonReg);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter your E-mail:");
		lblNewLabel_1_2.setBackground(Color.PINK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(35, 243, 236, 18);
		lblNewLabel_1_2.setOpaque(true);		
		contentPane.add(lblNewLabel_1_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(277, 243, 150, 19);
		contentPane.add(email);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("Images\\bank2.jpg"));
		lblNewLabel_3.setBounds(0, 0, 786, 451);
		lblNewLabel_3.setOpaque(true);	
		contentPane.add(lblNewLabel_3);
	}
}
