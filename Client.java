package Project;

import java.net.Socket;
import java.sql.PreparedStatement;
import java.net.InetAddress;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class Client extends JFrame {	
	Newreg nr=new Newreg();
	Transaction tr=new Transaction();
	Deposit dr=new Deposit();
	Withdraw wd=new Withdraw();
	Transfer trans=new Transfer();
	
	private ObjectOutputStream output;
    private ObjectInputStream input;
    private String[] userdata= new String[30];
    private String message="";
    private String message1="";
    private String serverIP;
    private Socket connection;			
    private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPassword;
	private JLabel LoginSVal;
	private boolean flag;
    private int port = 9999,i;
    private String a,b,c,d,f,g;   
    private JLabel status;
    private JButton btnLogin;
    private JPasswordField passwordField;
    private int balance;
    String otp,x1;
    String x2=new String();
    String message2;
	boolean z,one;
	private JLabel lblNewLabel_1;
    public Client(String s) {
        Components();
             serverIP = s;
    }
    private void Components() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		status = new JLabel("--");
		status.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		status.setBounds(216, 24, 284, 13);
	
    	setBounds(100, 100, 692, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		status = new JLabel("--");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(64, 81, 127, 24);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(222, 84, 135, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBackground(Color.RED);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(64, 140, 127, 24);
		lblPassword.setOpaque(true);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			nr.setVisible(true);
			//setVisible(false);
		    nr.btnNewButtonReg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				{
					a=nr.textField.getText();
					b=nr.txtDateOfBirth.getText();
					if(nr.rdbtn1.isSelected())
					{
						c=nr.rdbtn1.getText();
					}
					else if(nr.rdbtn2.isSelected())
					{
						c=nr.rdbtn2.getText();
					}
					else if(nr.rdbtn3.isSelected())
					{
						c=nr.rdbtn3.getText();
					}
					else if(nr.rdbtn4.isSelected())
					{
						c=nr.rdbtn4.getText();
					}
					d=nr.textField_1.getText();
					f=nr.textField_2.getText();
					g=nr.email.getText();
					//System.out.println(a);
					sendMessage(a);
					sendMessage(b);
					sendMessage(c);
					sendMessage(d);
					sendMessage(f);
				    sendMessage(g);
				}
					
			}
				});
		}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(64, 213, 127, 24);
		contentPane.add(btnNewButton);
		
	
		contentPane.add(status);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBounds(288, 213, 127, 24);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 145, 135, 19);
		contentPane.add(passwordField);
		
		LoginSVal = new JLabel("");
		LoginSVal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LoginSVal.setBounds(134, 243, 267, 24);
		contentPane.add(LoginSVal);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images/login2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 684, 386);
		contentPane.add(lblNewLabel_1);
       /*   textField.addActionListener(new ActionListener() {
            
			public void actionPerformed(ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        }
		);
		*/
		 btnLogin.addActionListener(new ActionListener() {
	            
				public void actionPerformed(ActionEvent evt) {
					btnLoginActionPerformed(evt);
					}
	        }
			);
		 tr.logoutbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		       {
		    	   try
		    	   {
		    	   tr.setVisible(false);
		    	   System.exit(ABORT);
		    	   }
		    	   catch(Exception e3)
		    	   {
		    	     
		    	   }
					// tr.dispose();
					 //client1.visible(true);
					//return;
	 			}}});
    }
    
    
	/*	private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {
	        sendMessage(textField.getText());
			//textField.setText("");
		}
	*/	
		
	    private void btnLoginActionPerformed(ActionEvent evt) {
	    	//setVisible(false);
       sendlogin(textField.getText());
       sendlogin(new String(passwordField.getPassword()));
       
       /* try
       {
       	this.Comm();
       }
         catch(IOException ioException)
       {
            ioException.printStackTrace();
       }
       */
	  }
    public void startRunning()
    {
       try
       {   try
            {
                connection = new Socket(InetAddress.getByName(serverIP),port);
            }catch(IOException ioEception)
            {
                    JOptionPane.showMessageDialog(null,"Server Might Be Down!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            status.setText("Connected to: " + connection.getInetAddress().getHostName());


            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());

           //Comm();
            
       }
       catch(IOException ioException)
       {
            ioException.printStackTrace();
       }
    }  
    private void sendMessage(String message)
    {
        try
        {       
        	output.writeObject(message);
            output.flush();
            
        }
        catch(IOException ioException)
        {
        }
    }
    private void sendlogin(String message)
    {
        try
        {       
        	output.writeObject("Login:"+message);
            output.flush();
        }
        catch(IOException ioException)
        {
        }
    }
      
    private void Comm() throws IOException
    {
         String message="";
          int ctr=0,count=0;
         do{ 
        	 one=true;
 	          try
                 {
 		                 ctr++;
                         message = (String) input.readObject();
                         System.out.println(message);
                         if(message.contains("UserID"))
                         {
                        message=message.replace("UserID","");
                         JOptionPane.showMessageDialog(this,"Your generated user ID is "+message);
                         nr.setVisible(false);
                         }
                         else if(message.equals("YES"))
                         { 
                        	 i=0;
                        	    setVisible(false);
                        		tr.setVisible(true);
                           message1=(String)input.readObject();
                        	 while(!message1.equals("Done"))
                        	 {
                        		 userdata[i]=message1;
                        		 System.out.println(userdata[i]);
                        		 
                        		 message1=(String)input.readObject();
                        		 i++;
                        		
                        	 }
                        	 userdata[6]=(String)input.readObject();

     				 		//System.out.println(userdata[6]);
                        	 	tr.Namelbl.setText(userdata[0]);
                        	 	tr.DATEOFBIRTH.setText(userdata[1]);
                        	 	tr.AccType.setText(userdata[2]);
                        	 	tr.USERID.setText(userdata[3]);
                        	 	tr.Emailbox.setText(userdata[5]);
                        	 	tr.bal_lbl.setText(userdata[4]);
                                balance=Integer.parseInt(userdata[4]);
                             /*   tr.Balancelbl.addActionListener(new ActionListener() {
                    				public void actionPerformed(ActionEvent e) {
                    					{
                    						   JOptionPane.showMessageDialog(null,"Your Bank balance is "+balance);
                    		                      
                    					}
                    					}});
                    					*/
                                tr.Depositlbl.addActionListener(new ActionListener() {
                    				public void actionPerformed(ActionEvent e) {
                    					{
                				 			//sendMessage("OTP TIME");
                    				 		dr.setVisible(true);
                    				 		//System.out.println(userdata[6]);
                    				 	    dr.btnNewButton.addActionListener(new ActionListener() {
                    							public void actionPerformed(ActionEvent e) {
                    							{
                    				 		if(dr.textField_1.getText().equals(userdata[6]))
                    				 		{
                    				 		  //JOptionPane.showMessageDialog(null,"updated");
                    				 			
                    				 			balance=balance+Integer.parseInt(dr.textField.getText());
                    				 			//System.out.println(balance);
                    				 			sendMessage("Balance:"+(balance));
                    				 			tr.bal_lbl.setText(Integer.toString(balance));
                    				 			dr.textField.setText(Integer.toString(0));
                    				 			dr.setVisible(false);
                    				 			one=false;
                    				 		}
                    							}}});
                    					}
                    					}});
                            
                               // if(one==false)
                                //{
                                	//continue;
                                //}
                                
                                tr.withlbl.addActionListener(new ActionListener() {
                    				public void actionPerformed(ActionEvent e) {
                    					{
                    					//	sendMessage("OTP TIME");	
                    				 		wd.setVisible(true);
                    				 		//System.out.println(userdata[6]);
                    				 	    wd.btnNewButton.addActionListener(new ActionListener() {
                    							public void actionPerformed(ActionEvent e) {
                    							{

                        				 			
                    				 		if(wd.textField_1.getText().equals(userdata[6]))
                    				 		{	
                    				 		  //JOptionPane.showMessageDialog(null,"updated");
                    				 			if(balance>Integer.parseInt(wd.textField.getText()))
                    				 			{
                    				 			balance=balance-Integer.parseInt(wd.textField.getText());
                    				 			sendMessage("Balance:"+(balance));
                    				 			tr.bal_lbl.setText(Integer.toString(balance));
                    				 			wd.textField.setText(Integer.toString(0));
                    				 			one=false;
                    				 			}
                    				 			else
                    				 			{
                    				 				 JOptionPane.showMessageDialog(null,"Insufficient Balance");	
                    				 			}
                    				 		
                    				 			wd.setVisible(false);
                    				 		}
                    							}}});
                    					}
                    					
                    					}});
                                
                                //if(one==false)
                                //{
                                
                                	//continue;
                                //}
                                
                                 tr.btnTransfer.addActionListener(new ActionListener() {
                    				public void actionPerformed(ActionEvent e) {
                    					{
                    						
                				 			//sendMessage("OTP TIME");
                    						trans.setVisible(true);
                    						      trans.btnNewButton.addActionListener(new ActionListener() {
                    							public void actionPerformed(ActionEvent e) {
                    							{
                    							//	System.out.print(userdata[6]);

                    						if(trans.textField_2.getText().equals(userdata[6]))
                            			    {
                    				 		x1=trans.textField.getText();
                    				 		x2=(trans.textField_1.getText());
                    				 		balance=balance-(Integer.parseInt(x2));
                    				 		System.out.println(balance);
                    				 		z=false;
                    				 		
                    				 		//x2=trans.textField_1.getText();
                    				 		System.out.println(x2);	
                    				 		sendMessage("ID"+x1);
                    				 	
                    				 		/*	try
                    				 		{
                    				 		String x2	
                    				 		}
                    				 		catch(Exception e)
                    				 		{
                    				 			
                    				 		}
                    				 		*/
                    				 		
                            			    }
                    							}}});
                    					
                    					}}});
                                
                               
                               if(z==false)
                                {
                            	   z=true;
                            	   try
                            	   {
                            		   message2=(String)input.readObject();
                                	//System.out.println(message);
                                if(message2.equals("Proceed"))
        				 		{
                                	System.out.println("HI");
        				 			sendMessage("Balance1:"+(balance));
        				 			trans.setVisible(false);
        				 			one=false;
        				 		}
        				 
                                
        				 		
                                }
                            	   catch(Exception e2)
                            	   {
                            		   
                            	   }
                                }
                               
                           //    if(one==false)
                             //  {
                               
                               //	continue;
                               //}
                               
                             // System.out.println(balance);
                        	 LoginSVal.setText("Login Successful");
                            
                        	
     				 			 
                      //   chatArea.append("\n"+message);
                 }
                         else if(message.equals("No"))
                        		 {
                        	 JOptionPane.showMessageDialog(this,"Wrong Credentials !! TRY AGAIN");  
                        	 System.exit(ABORT);
                        		 }
    
                 }catch(ClassNotFoundException classNotFoundException)
                 {
                         
                 }
            
        }while(ctr<5);
        // if(!this.isVisible())
     	//{
     	//this.setVisible(true);
     	//this.Comm();
     	//}
    }
    //IP SPOOFING,syn flooding,port scanning
    public static void main(String[] args) 
    {
        Client client1=new Client("127.0.0.1");
        client1.startRunning();
        client1.setVisible(true);
        try
        {
        	client1.Comm();
        	
        }
          catch(IOException ioException)
        {
             ioException.printStackTrace();
        }
    }
 }