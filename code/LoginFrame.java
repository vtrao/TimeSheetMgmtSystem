import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane.*;
import javax.swing.JFrame;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener
  {
  ResultSet rs;
	Connection con;
	Statement stmt;
	static String username;
  String password;
	static String userid;
  static String s;
	String tableName;
	String attributeDetail;
	JLabel uid, pwd1;
	JTextField tfuid;
	JPasswordField tfpwd1;
  JButton jbok, jbcancel, jbexit;

	public LoginFrame()
	  {
		super("Login Window");
		rs=null;
		con=null;
		stmt=null;
  	this.setSize(370,220);
		this.setLocation(350,250);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(uid = new JLabel("User ID "));
		this.getContentPane().add(pwd1 = new JLabel("Password "));
  	this.getContentPane().add(tfuid = new JTextField(15));
	  this.getContentPane().add(tfpwd1 = new JPasswordField(10));
		this.getContentPane().add(jbok = new JButton("Ok"));
		this.getContentPane().add(jbcancel = new JButton("Cancel"));
		this.getContentPane().add(jbexit = new JButton("Exit"));
		this.setVisible(true);
    uid.setBounds(20, 30, 98, 25);
		tfuid.setBounds(136, 30, 183, 25);
		pwd1.setBounds(20,70,110,25);
		tfpwd1.setBounds(136,70,110,25);
		jbok.setBounds(30,155,80,25);
		jbcancel.setBounds(130,155,100,25);
		jbexit.setBounds(250,155,80,25);
		tfpwd1.setEchoChar('*');

		// Add ActionListener to the Button
		jbok.addActionListener(this);
		jbcancel.addActionListener(this);
		jbexit.addActionListener(this);
		tfuid.requestFocus();

         }
public void actionPerformed(ActionEvent ae)
	{
           try
		{
		// Load the Driver class file
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		// Make a connection to the ODBC datasource xoffice
		con = DriverManager.getConnection( "jdbc:odbc:tms");//, "scott", "tiger");
		// Create the statement
		 stmt = con.createStatement();
		// Use the created statement to CREATE the database table
		// Create Title Table
		rs=stmt.executeQuery("SELECT username,pwd,ua,eid FROM usermaster");
		if(ae.getActionCommand().equals("Ok"))
			{
			username = tfuid.getText();
			password = tfpwd1.getText();
			while(rs.next())
				{
				if(username.equals(rs.getString("username")))
					{
					if(password.equals(rs.getString("pwd")))
						{
        				        s= rs.getString("ua");
				                userid =rs.getString("eid");
				                this.dispose();
				                MainWindow m=new MainWindow(userid,s,username);
				                }
				         else
						{
						tfpwd1.setText("");
						tfpwd1.requestFocus();
						JOptionPane.showMessageDialog(null,"ENTER CORRECT PASSWORD ");
						}
              				}
   				}
		         }
			else if(ae.getActionCommand().equals("Cancel"))
				{
				tfuid.setText("");
				tfpwd1.setText("");
				}

			else if(ae.getSource()==jbexit)
				{
			        System.exit(0);
				}
  		}
		catch (SQLException sqle) 
			{
			System.err.println(sqle.getMessage());
			}
		catch (ClassNotFoundException cnfe) 
			{
			System.err.println(cnfe.getMessage());
			}
		catch (Exception e) 
			{
			System.err.println(e.getMessage());
			}
		finally 
			{
			try 
				{
				if ( con != null ) 
					{
					// Close the connection no matter what
					con.close();
					}
				}
			catch (SQLException sqle) 
				{
				System.err.println(sqle.getMessage());
	     			}
			}
	}
public static void main(String[] args)
	 {
 	  LoginFrame s=new LoginFrame();
 	 }
}




