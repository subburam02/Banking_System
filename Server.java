package Project;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import java.net.Socket;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Server extends JFrame{
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;	
	 private ServerSocket server;
	 private int totalClients = 50;
	 private int id[],z;
	 private int count1=0;
	 private String[] users= new String[30]; //store client new user info
	 private String[] Name= new String[30];
	 private String[] DateofBirth= new String[30];
	 private String[] AccountType= new String[30];
	 private String[] MobileNumber= new String[30];
	 private String[] Password= new String[30];
	 private int[] UserID= new int[30]; 
	 private int[] AccountBalance= new int[30];
	 private String[] email= new String[30];
	 private String[] login= new String[30];
	 private String[] password= new String[30];
	 private String[] loginrcv= new String[30];
	 private String sql,sql1,sql2,sql3;
	 private String host,user,pass,to;
	 private Connection conn;
	 private int port=9999;
	 private JLabel lblNewLabel_1 = new JLabel("Waiting for clients");
	 private JLabel lblNewLabel_1_1 = new JLabel("Waiting for Database Connection");
	 private  Session session;
	 //private  MimeMessage mess;
	 private String balance1;
	 private  PreparedStatement stmt,stmt1,stmt2,stmt3;
	private   ResultSet rs,rs1;
	private int res=0;
	private int k,m,counttotal;
	private int check=0;
	private int b;
	private String xdate;
	private JButton btnNewButton;
	static Logs l=new Logs();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    private final JButton btnStop = new JButton("STOP");
    
    public Server() {
        Components();
    }
    
    public void dbconnection()
    {
    	 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	             conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/project","root", "");
	            lblNewLabel_1_1.setText("Database connected");
	            sql = "insert into users(Name,DateofBirth,AccountType,MobileNumber,Password,UserID,AccountBalance,EmailID) values(?,?,?,?,?,?,?,?)";
	        }
	        catch(Exception e) {
	         	JOptionPane.showMessageDialog(this,"Do not connect to DB - Error:"+e);
	        }
    }
    public void dblogin()
    {int j=0;
    	 try
         {
         String wd="SELECT Name,DateOfBirth,AccountType,MobileNumber,Password,UserID,EmailID,AccountBalance from users";
         	stmt  = conn.prepareStatement(wd); 
         	counttotal=0;
         	 rs=stmt.executeQuery();// loop through the result set
                  while (rs.next()) {
                	  counttotal++;
                	 Name[j]=rs.getString("Name");
                 	DateofBirth[j]=rs.getString("DateofBirth");
                 	AccountType[j]=rs.getString("AccountType");
                 	MobileNumber[j]=rs.getString("MobileNumber");
                 	Password[j]=rs.getString("Password");
                 	UserID[j]=rs.getInt("UserID");
                 	AccountBalance[j]=rs.getInt("AccountBalance");
                     login[j]=rs.getString("UserID");
                     password[j]=rs.getString("Password");
                     email[j]=rs.getString("EmailId");
                    j++;
                  }
         	}
         	 catch (SQLException e) {
         		JOptionPane.showMessageDialog(this,"Error:"+e);
                      }
            
    }
    public void email(String recv,String strsub,String strbody)
    {
    	dblogin();
    	 host="localhost";  
			
		   user="email_id";  
		   pass="password";  
		    
		   Properties props = new Properties();  
		   props.put("mail.smtp.host","smtp.gmail.com");  
		   props.put("mail.smtp.port","587");  
		   props.put("mail.smtp.auth", "true");  
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.ssl.trust","*");
		   props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		 		     Session session = Session.getInstance(props,
			          new javax.mail.Authenticator() {
			            
			            //override the getPasswordAuthentication method
			            protected PasswordAuthentication
			                           getPasswordAuthentication() {
			                                        
			                return new PasswordAuthentication(user,
			                                                 pass);
			            }
			          });
			try {
	             
	            Message message2 = new MimeMessage(session);   
	             
	            message2.setFrom(new InternetAddress("personalmailid@gmail.com"));
	              
	            message2.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(recv));
	            System.out.println(recv);
	            message2.setSubject(strsub);
	            message2.setText(strbody);
	 
	            Transport.send(message2);         
	 
	            System.out.println("MAIL SENT");
			}
		    catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
    }
    public void Running()
    {
        try
        {
            server=new ServerSocket(port,totalClients);
            while(true)
            {
                try
                {
                    connection=server.accept();		
                    lblNewLabel_1.setText(" Now Connected to "+connection.getInetAddress().getHostName());
                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                    Comm();

                }catch(EOFException eofException)
                {
                }
            }
        }
        catch(IOException ioException)
        {
                ioException.printStackTrace();
        }
    }
    
   private void Comm() throws IOException
   {
        String message="";
        int max=2000000;
		int min=1000000;
		int cnt1=0;
		b = (int)(Math.random()*(max-min+1)+min);
        int i=0,j=0,k,ctr=0;
       do {
    	   message="";
	       try
                {
	    		dblogin();
		           ctr++;
	                    message = (String) input.readObject();
                        if(message.contains("Login:"))                            //Login Path
                        {
                        	String message1=message.replace("Login:","");
                        	loginrcv[j]=message1;
                        	//System.out.println(message1);
                        	j++;
                        		if(j==2)
                        	{
                        		for(k=0;k<login.length;k++)
                        		{
                        			if(loginrcv[0].equals(login[k]))
                        			{
                        				if(loginrcv[1].equals(password[k]))
                        				{
                        					check=1;
                        					m=k;
                        				xdate=(formatter.format(new Date()));
                        				 
                        				 do
                                        	{
                        					// System.out.println("Entering...");
                        						dblogin(); //update from database
                                        		count1++;
                                          //Name,DateofBirth,AccountType,MobileNumber,Password,UserID,AccountBalance
                                        	sendMessage("YES");
                        					sendMessage(Name[k]);
                        					sendMessage(DateofBirth[k]);
                        					sendMessage(AccountType[k]);
                        					sendMessage(Integer.toString(UserID[k]));
                        					sendMessage(Integer.toString(AccountBalance[k]));	
                        					sendMessage(email[k]);	                      					
                        					sendMessage("Done");
                        					 int max1=2000;
                        					int min1=1000;
                        						int otp= (int)(Math.random()*(max1-min1+1)+min1);
                        					//	System.out.println(otp);
                        					sendMessage(Integer.toString(otp));
                        			
                        						email(email[k],"Transaction OTP","OTP for your transaction is"+Integer.toString(otp));
                        						
                        						        String rcvmessage=(String)input.readObject();
                        					            if(rcvmessage.contains("Balance:")==true) 
                        		                        {
                        					            	try
                        					            	{
                        					            		if(cnt1==0)
                        					            		{
                        					            		 l.textArea.append("\n"+Name[m]+" has signed in at " +xdate +"\n");	
                        					            		}
                        					            		 cnt1++;
                        					            		 stmt1=null;
                        					            	res=Integer.parseInt(loginrcv[0]);
                        		                        	String message3=rcvmessage.replace("Balance:","");
                        		                        	xdate=(formatter.format(new Date()));
                                             				
                                           				 l.textArea.append("\n\n"+Name[m]+" of user id "+ UserID[m]+" has updated his balance at" +xdate+"\n");
                                           				 l.textArea.append("\nOLD ACCCOUNT BALANCE:"+AccountBalance[m]);
                        		                        	
                        		                        	 sql1 = "UPDATE users set AccountBalance="+Integer.parseInt(message3)+" where UserID="+res+";";
                        		                        	
                        		                         l.textArea.append("\nNEW ACCCOUNT BALANCE:"+message3);
                             		                        	
                        		                        	  stmt1 = conn.prepareStatement(sql1);	
       
                        		                        	 int a=stmt1.executeUpdate();
                              	                        	 stmt1.close();
                        		                            }
                        					            	catch(SQLException e)
                        					            	{
                        					            		JOptionPane.showMessageDialog(this,"Error:"+e);
                        					            	}
                        		                        }
                        					            
                        					            else if(rcvmessage.contains("ID")==true)   //transfer
                        					            {
                        					        		if(cnt1==0)
                    					            		{
                    					            		 l.textArea.append("\n"+Name[m]+" has signed in at " +xdate +"\n");	
                    					            		}
                    					            		 cnt1++;
                        					           	 
                        					            String message4=rcvmessage.replace("ID","");
                        		                        	for(int v=0;v<counttotal;v++)
                        		                        	{
                        		                        		//System.out.println(message4);
                        		                        		if(login[v].equals(message4)==true)
                        		                        		{
                        		                        			
                        		                        			  z=AccountBalance[v];
                        		                        			sendMessage("Proceed");
                        		                        			  String rcvmessage_1=(String)input.readObject();
                                      					            if(rcvmessage_1.contains("Balance1:")==true) 
                                      		                        {
                                      					            	try
                                      					            	{
                                      					            		 stmt2=null;
                                      					            		 
                                      					            		 dblogin();
                                      					                 int y1=Integer.parseInt(loginrcv[0]);
                                      		                        	String message5=rcvmessage_1.replace("Balance1:","");
                                      		                        	xdate=(formatter.format(new Date()));
                                                         				 l.textArea.append("\n\n"+Name[m]+" of user id "+ UserID[m]+" has updated his balance at" +xdate);
                                                         				 l.textArea.append("\nOLD ACCCOUNT BALANCE:"+AccountBalance[m]);
                                      		                        	//System.out.println(res);
                                      		                        	 sql2 = "UPDATE users set AccountBalance="+Integer.parseInt(message5)+" where UserID="+y1+";";
                                      		                        	
                                      		                          // stmt1.execute(sql1);
                                      		                         l.textArea.append("\nNEW ACCCOUNT BALANCE:"+message5);
                                      		                         int diff=AccountBalance[m]-Integer.parseInt(message5);
                                      		                       sql3 = "UPDATE users set AccountBalance="+(AccountBalance[v]+diff)+" where UserID="+UserID[v]+";";
                                 		                        	 	  stmt2 = conn.prepareStatement(sql2);	
                                                                        int a=stmt2.executeUpdate();
                                      		                        	 //System.out.println(a);
                                      		                        	 stmt2.close();
                                     		                        	  stmt3 = conn.prepareStatement(sql3);	
                                     		                             
                                       		                        	 int e=stmt3.executeUpdate();
                                       		                        	 stmt3.close();
                                       		                        	 l.textArea.append("\n\n"+Name[v]+" of user id "+ UserID[v]+" has been credited with "+diff+" at"+xdate+"\n");
                                                           				 l.textArea.append("\nOLD ACCCOUNT BALANCE:"+z);
                                                           				 l.textArea.append("\nNEW ACCCOUNT BALANCE:"+(AccountBalance[v]+diff));
                                       		                        	
                                       		                        	email(email[v],"AMOUNT CREDITED TO YOUR ACCOUNT","Rs "+diff+" has been transferred to your account from "+Name[m]+" whose User ID "+UserID[m]);                      	
                                       		                            }
                                      					            	
                                      					            	catch(SQLException e)
                                      					            	{
                                      					            		System.out.println(e);
                                      					            	}
                                      		                        }
                                      					           
                        		                        			
                        		                        		}
                        		                        
                        		                        	}
                        					            }		
                        					            
                        					            	
                        					 
                        					    
                                        	}while(ctr<5);
                        					}
                        			}
                        		}
                        		if(check==0)
                        		{
                        			sendMessage("No") ;
                        			
                        		}
                        	}
                        }
                        	
                        			
                        		//return;

                       /* else if(message.contains("Balance:")==true) 
                        {
                        	String message1=message.replace("Balance:","");
                        	
                        	 String sql1 = "UPDATE AccountBalance
                        	         stmt.executeUpdate(sql1);
                        	        
                        
                     //   chatArea.append("\n"+message);
                        }
                        */
                        else   //NewUser Path
                        {
                    //    do
                      //  {
                        users[i]=message;
                        i++;
                        if(i==6)
                        {
                        	break;
                        }
                       // }
                        //while(i<6);
                        
                    //    System.out.println(message);
                       	}
                }
	       catch(ClassNotFoundException classNotFoundException)
           {
                   
           }
                             
                     //   chatArea.append("\n"+message);
                        
	            
      }while(ctr<6);
  try
       {
  //     	Comm();
       PreparedStatement pst=null;
       pst = conn.prepareStatement(sql);
       pst.setString(1,users[0]);
       pst.setString(2,users[1]);
       pst.setString(3,users[2]);
       pst.setString(4,users[3]);
       pst.setString(5,users[4]);
       pst.setInt(6,b);
       pst.setInt(7,0);
       pst.setString(8,users[5]);
   	   pst.execute();
       email(users[5],"ACCOUNT CREATED SUCCESSFULLY","Generated UserID of your account is "+b); //work
	    sendMessage("UserID"+Integer.toString(b));
      
       //pst.execute(sql); 
       }
       catch(Exception e) 
       {
       	JOptionPane.showMessageDialog(this,"Enter proper data:");
       	System.out.println(e);
       }
	       System.out.print(xdate);
      
   }
  /* private void loginChat() throws IOException
   {
	   String message1="";
   }
         do{ 
	try
                {
	                    message1=(String) input.readObject();
                        System.out.println(message1);
                        i++;
                     //   chatArea.append("\n"+message);
                }catch(ClassNotFoundException classNotFoundException)
                {
                        
                }
           
       }while(ctr<5);
    */
    private void Components() {
     	     getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
    		getContentPane().setLayout(null);
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setBounds(100, 100, 691, 400);
    		btnStop.setFont(new Font("Times New Roman", Font.BOLD, 20));
    		btnStop.setBounds(417, 300, 123, 42);
    		
    		getContentPane().add(btnStop);
    		lblNewLabel_1.setForeground(Color.RED);
    		lblNewLabel_1.setBackground(Color.WHITE);
    	
    		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
    		lblNewLabel_1.setBounds(49, 68, 374, 54);
    		lblNewLabel_1.setOpaque(true); 	
    		getContentPane().add(lblNewLabel_1);
    		
    		
    		lblNewLabel_1_1.setForeground(Color.RED);
    		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    		lblNewLabel_1_1.setBackground(Color.WHITE);
    		lblNewLabel_1_1.setBounds(49, 152, 288, 54);
    		lblNewLabel_1_1.setOpaque(true);
    		getContentPane().add(lblNewLabel_1_1);
    		
    		btnNewButton = new JButton("LOGS");
    		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
    		btnNewButton.setBounds(154, 300, 123, 42);
    		getContentPane().add(btnNewButton);
    		
    		JLabel lblNewLabel = new JLabel("New label");
    		lblNewLabel.setForeground(Color.WHITE);
    		lblNewLabel.setIcon(new ImageIcon("Images/server5.jpg"));
    		lblNewLabel.setBounds(0, 0, 667, 363);
    		getContentPane().add(lblNewLabel);
    		
    		  this.btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					{
						l.setVisible(true);
						
		 			}}});
    		
    		this.btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				{
					try
					{
				server.close();
				//setVisible(false);
				dispose();
					}
					catch(IOException io)
					{
					}
	 			}}});
		
    			
        } 
    /*
      public static void main(String[] args) 
     
	{
		Server myServer=new Server();
         myServer.startRunning();
	}
	*/
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
    public static void main(String[] args) throws Exception {
               			Server frame = new Server();
					    frame.setVisible(true);
					    frame.dbconnection();
					    frame.Running();
					   
					   // frame.Comm();
					    			       
				} 
    }