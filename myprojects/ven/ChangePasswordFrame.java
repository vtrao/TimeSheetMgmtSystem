package ven;
import java.awt.*;
import com.sun.java.swing.*;
import java.awt.event.* ;
import com.sun.java.swing.JFrame;
import java.sql.*;

public class ChangePasswordFrame extends JFrame implements ActionListener{
  ResultSet rs, rs1;
  Connection con;
  Statement stmt;
  String username;
  String password;
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JPasswordField jPasswordField1 = new JPasswordField();
  JPasswordField jPasswordField2 = new JPasswordField();
  JPasswordField jPasswordField3 = new JPasswordField();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();

  public ChangePasswordFrame(String uname)
    {
    jTextField1.setEditable(false);
    jTextField1.setText(uname);
    try  
	{
        jbInit();
        }
    catch (Exception e) 
	{
         e.printStackTrace();
        }
    }

  public static void main(String[] args) 
	{
    	 ChangePasswordFrame changePasswordFrame1 = new ChangePasswordFrame("");
  	}

  private void jbInit() throws Exception 
    {
    rs=null;
    con=null;
    stmt=null;
    rs1=null;
    this.setSize(445,250);
    this.setLocation(350,250);
    this.setResizable(true);
    this.setTitle("Change Password");
    this.getContentPane().setLayout(null);
    jLabel1.setText("UserName");
    jLabel1.setBounds(new Rectangle(78, 37, 88, 20));
    jTextField1.setBounds(new Rectangle(210, 31, 149, 24));
    jLabel2.setText("Old Password");
    jLabel2.setBounds(new Rectangle(74, 65, 120, 31));
    jLabel3.setText("New Password");
    jLabel3.setBounds(new Rectangle(74, 99, 117, 27));
    jLabel4.setText("Confirm Password");
    jLabel4.setBounds(new Rectangle(74, 128, 132, 32));
    jPasswordField1.setBounds(new Rectangle(209, 66, 129, 26));
    jPasswordField2.setBounds(new Rectangle(209, 103, 131, 24));
    jPasswordField3.setBounds(new Rectangle(210, 137, 134, 26));
    jButton1.setText("Ok");
    jButton1.setBounds(new Rectangle(46, 183, 96, 37));
    jButton1.addActionListener(this);
    jButton2.setText("Reset");
    jButton2.setBounds(new Rectangle(189, 182, 91, 38));
    jButton2.addActionListener(this);
    jButton3.setText("Exit");
    jButton3.setBounds(new Rectangle(313, 183, 92, 37));
    jButton3.addActionListener(this);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jTextField1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jPasswordField1, null);
    this.getContentPane().add(jPasswordField2, null);
    this.getContentPane().add(jPasswordField3, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton3, null);
// Center the window
     this.setVisible(true);
     jTextField1.requestFocus();
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
			rs=stmt.executeQuery("SELECT username,pwd FROM usermaster");
			if(ae.getActionCommand().equals("Ok"))
				{
					username = jTextField1.getText();
					password = jPasswordField1.getText();
					while(rs.next())
						{
						if(username.equals(rs.getString("username")))
							{
							if(password.equals(rs.getString("pwd")))
								{
                if(jPasswordField2.getText().equals(jPasswordField3.getText()))
                  {
                  String d=jPasswordField2.getText();
                  jPasswordField1.setText("");
                  jPasswordField2.setText("");
                  jPasswordField3.setText("");
                  stmt.executeUpdate("update usermaster set pwd = '"+
                                      d+"' where ( username = '" + username +
                                            "' and pwd =  '" + password + "' )");
                  JOptionPane.showMessageDialog(null,"Password changed","",JOptionPane.INFORMATION_MESSAGE);
                  }
                else
				        	{
					        jPasswordField2.setText("");
					        jPasswordField3.setText("");
                  JOptionPane.showMessageDialog(null,"Password Mismatch");
					        jPasswordField2.requestFocus();
					        }
                }
              else
		{
		JOptionPane.showMessageDialog(null,"ENTER CORRECT PASSWORD ");
                jPasswordField1.setText("");
		}
			                  }
                       			}
 
	                               }
		else if(ae.getActionCommand().equals("Exit"))
				{
			        this.dispose();
			        }
		else if(ae.getActionCommand().equals("Reset"))
				{
			         jPasswordField1.setText("");
			         jPasswordField2.setText("");
			         jPasswordField3.setText("");
			         jTextField1.requestFocus();
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

}

