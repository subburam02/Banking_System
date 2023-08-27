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
public class Transaction extends JFrame {
	 JPanel contentPane;
	JButton Depositlbl;
	JButton withlbl; 
	JLabel  Namelbl,USERID,DATEOFBIRTH,AccType;
	 JLabel lblEmailId;
    JLabel Emailbox;
    JLabel bal_lbl;
    JButton logoutbtn;
   JButton btnTransfer;
   private JLabel lblNewLabel_1;
   private JLabel lblHomepage;
	public Transaction () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 522);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Depositlbl = new JButton("DEPOSIT");
		 Depositlbl.setBackground(Color.WHITE);
		 Depositlbl.setForeground(Color.RED);
		Depositlbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		Depositlbl.setBounds(143, 415, 127, 21);
		contentPane.add(Depositlbl);
		
		withlbl = new JButton("WITHDRAW");
		withlbl.setBackground(Color.WHITE);
		withlbl.setForeground(Color.RED);
		withlbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		withlbl.setBounds(557, 415, 178, 21);
		contentPane.add(withlbl);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(98, 87, 69, 21);
		lblNewLabel.setOpaque(true);		
		contentPane.add(lblNewLabel);
		
		
		JLabel lblUserid = new JLabel("USERID:");
		lblUserid.setBackground(Color.YELLOW);
		lblUserid.setForeground(Color.BLACK);
		lblUserid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUserid.setBounds(98, 135, 98, 21);
		lblUserid.setOpaque(true);		
		contentPane.add(lblUserid);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setBackground(Color.YELLOW);
		lblDateOfBirth.setForeground(Color.BLACK);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(98, 189, 150, 21);
		lblDateOfBirth.setOpaque(true);		
		contentPane.add(lblDateOfBirth);
		
		Namelbl = new JLabel("");
		Namelbl.setBackground(Color.GREEN);
		Namelbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Namelbl.setBounds(216, 87, 150, 21);
		Namelbl.setOpaque(true);		
		contentPane.add(Namelbl);
		
		 USERID = new JLabel("");
		 USERID.setBackground(Color.GREEN);
		USERID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		USERID.setBounds(216, 135, 150, 21);
		USERID.setOpaque(true);		
		contentPane.add(USERID);
		
		DATEOFBIRTH = new JLabel("");
		DATEOFBIRTH.setBackground(Color.GREEN);
		DATEOFBIRTH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		DATEOFBIRTH.setBounds(277, 189, 150, 21);
		DATEOFBIRTH.setOpaque(true);
		contentPane.add(DATEOFBIRTH);
		
		JLabel Acclbl = new JLabel("Account Type:");
		Acclbl.setBackground(Color.YELLOW);
		Acclbl.setForeground(Color.BLACK);
		Acclbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Acclbl.setBounds(98, 237, 150, 21);
		Acclbl.setOpaque(true);	
		contentPane.add(Acclbl);
		
		AccType = new JLabel("");
		AccType.setBackground(Color.GREEN);
		AccType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		AccType.setBounds(277, 237, 150, 21);
		AccType.setOpaque(true);		
		contentPane.add(AccType);
		
		lblEmailId = new JLabel("Email ID:");
		lblEmailId.setBackground(Color.YELLOW);
		lblEmailId.setForeground(Color.BLACK);
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmailId.setBounds(97, 285, 150, 21);
		lblEmailId.setOpaque(true);	
		contentPane.add(lblEmailId);
		
		Emailbox = new JLabel("");
		Emailbox.setBackground(Color.GREEN);
		Emailbox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Emailbox.setBounds(265, 285, 230, 21);
		Emailbox.setOpaque(true);		
		contentPane.add(Emailbox);
		
		JLabel lblBalance = new JLabel("Current Balance:");
		lblBalance.setBackground(Color.YELLOW);
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBalance.setBounds(97, 331, 150, 21);
		lblBalance.setOpaque(true);		
		contentPane.add(lblBalance);
		
		 bal_lbl = new JLabel("0");
		 bal_lbl.setBackground(Color.GREEN);
		bal_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		bal_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bal_lbl.setBounds(265, 331, 230, 21);
        bal_lbl.setOpaque(true);	
		contentPane.add(bal_lbl);
		
		
		logoutbtn = new JButton("LOGOUT");
		logoutbtn.setForeground(Color.RED);
		logoutbtn.setBackground(Color.WHITE);
		logoutbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		logoutbtn.setBounds(617, 35, 138, 29);
		contentPane.add(logoutbtn);
		
		btnTransfer = new JButton("TRANSFER");
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.setForeground(Color.RED);
		btnTransfer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnTransfer.setBounds(343, 417, 152, 21);
		contentPane.add(btnTransfer);
		
		lblHomepage = new JLabel("HOME PAGE");
		lblHomepage.setOpaque(true);
		lblHomepage.setForeground(Color.BLACK);
		lblHomepage.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblHomepage.setBackground(Color.LIGHT_GRAY);
		lblHomepage.setBounds(287, 10, 183, 39);
		contentPane.add(lblHomepage);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("Images\\bank8.jpg"));
		lblNewLabel_1.setBounds(0, 0, 885, 485);
		contentPane.add(lblNewLabel_1);
	}
}

