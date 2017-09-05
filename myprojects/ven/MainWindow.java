package ven;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import java.awt.*;
import com.sun.java.swing.JFrame;
import java.io.*;

class MainWindow extends JFrame
  {
  BorderLayout borderLayout1 = new BorderLayout();
  LoginFrame l;
  static String uname;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  static String ueid,ua;
  JMenu jMenu2 = new JMenu();
  JMenu jMenu3 = new JMenu();
  JMenu jMenu4 = new JMenu();
  JMenu jMenu5 = new JMenu();
  JMenu jMenu6 = new JMenu();
  JMenu jMenu8 = new JMenu();
  JMenu jMenu9 = new JMenu();
  JMenu jMenu10 = new JMenu();

  JMenuBar jMenuBar1 = new JMenuBar();
  JMenuItem jMenuItem3 = new JMenuItem();

 public MainWindow(String lk,String llk,String lllk)
  {
  ueid=lk;//userid
  ua=llk;//user authentication
  uname=lllk;//user name
  }
 public MainWindow()
  {
  try
    {
    this.setResizable(true);
    this.setTitle("Time Sheet Management System");
    this.getContentPane().setLayout(borderLayout1);
    jMenu2.setToolTipText("Only to Project Managers and Project Leaders");
    jMenu2.setMnemonic('P');
    jMenu2.setText("Project Launch");
    jMenu3.setToolTipText("Only to Project Managers and Project Leaders");
    jMenu3.setMnemonic('T');
    jMenu3.setText("Time Estimation");
    jMenu4.setToolTipText(" Only to Project Managers and Project Leaders");
    jMenu4.setMnemonic('M');
    jMenu4.setText("Module Assignment");
    jMenu5.setToolTipText("For All Users");
    jMenu5.setMnemonic('S');
    jMenu5.setText("Time Sheet Entry");
    jMenu5.setDelay(200);
    jMenu6.setToolTipText("Only to Project Managers and Project Leaders");
    jMenu6.setMnemonic('Z');
    jMenu6.setText("Project Status");
    jMenu8.setToolTipText("For All Users");
    jMenu8.setMnemonic('C');
    jMenu8.setText("Change Password");
    jMenu9.setToolTipText("For All Users");
    jMenu9.setMnemonic('O');
    jMenu9.setText("Log Out");
    jMenu10.setToolTipText("Help !");
    jMenu10.setMnemonic('H');
    jMenu10.setText("Help");
//Menu Items
    jMenuItem3.setText("About Time Sheet Management System (TMS)");
    jMenuBar1.setForeground(Color.red);
    jMenuBar1.setOpaque(false);
    jMenu10.add(jMenuItem3);
//adding menus to menu bar
    jMenuBar1.add(jMenu2);
    jMenuBar1.add(jMenu3);
    jMenuBar1.add(jMenu4);
    jMenuBar1.add(jMenu5);
    jMenuBar1.add(jMenu6);
    jMenuBar1.add(jMenu8);
    jMenuBar1.add(jMenu9);
    jMenuBar1.add(jMenu10);
//inserting image
    ImageIcon icoBaseScreen = new ImageIcon("Basescreen.jpg");
    JLabel jLabel1 = new JLabel(icoBaseScreen);
    jLabel1.setBounds(0,0,screenSize.width, screenSize.height);
//Menu listeners
    jMenu2.addMouseListener(new m2());
    jMenu3.addMouseListener(new m3());
    jMenu4.addMouseListener(new m4());
    jMenu5.addMouseListener(new m5());
    jMenu6.addMouseListener(new m6());
    jMenu8.addMouseListener(new m8());
    jMenu9.addMouseListener(new m9());
//menu item action listeners
    jMenuItem3.addActionListener(new mi3());
//panels
    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(null);
    jPanel1.add(jLabel1);
// Add On Frame
    this.getContentPane().add(jMenuBar1, BorderLayout.NORTH);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
// Center the window
    this.setSize(screenSize);
    this.setVisible(true);
      jMenu2.setEnabled(false);
      jMenu5.setEnabled(false);
      jMenu3.setEnabled(false);
      jMenu4.setEnabled(false);
      jMenu6.setEnabled(false);
      jMenu8.setEnabled(false);
      jMenu9.setEnabled(false);
    this.addMouseMotionListener(new mm());
    }
  catch(Exception e)
	{
	e.printStackTrace();
	}
 }
 class mm extends MouseMotionAdapter
    {
    public void mouseMoved(MouseEvent me)
      {
      if(ua.equals("1") || ua.equals("2"))
     	 {
	      jMenu2.setEnabled(true);
	      jMenu5.setEnabled(true);
	      jMenu3.setEnabled(true);
	      jMenu4.setEnabled(true);
	      jMenu6.setEnabled(true);
	      jMenu8.setEnabled(true);
	      jMenu9.setEnabled(true);
	 }
      else
     	 {
	      jMenu2.setVisible(false);
	      jMenu5.setEnabled(true);
	      jMenu3.setVisible(false);
	      jMenu4.setVisible(false);
	      jMenu6.setVisible(false);
	      jMenu8.setEnabled(true);
	      jMenu9.setEnabled(true);
	 }
      }
    }
 class m2 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	             	ProjectLaunchFrame f=new ProjectLaunchFrame();
      		     	}
     	  }
  class m3 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	               	TimeEstimationFrame t= new TimeEstimationFrame();
	         	}
          }
  class m4 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	               	ModuleAssignmentFrame m=new ModuleAssignmentFrame();
	          	}
          }
  class m5 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	               	TimeSheetEntryFrame tm= new TimeSheetEntryFrame(ueid,ua);
	          	}
          }
  class m6 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	               	ProjectStatusFrame ps=new ProjectStatusFrame();
	          	}
          }
  class m8 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	        	{
	               	ChangePasswordFrame ch= new ChangePasswordFrame(uname);
	          	}
          }
class m9 extends MouseAdapter
	  {
	  public void mouseClicked(MouseEvent e)
	       	{
             	  Logout lg=new Logout();
         	}
     	  }
  class mi3 implements ActionListener
  	{
	  String s="                                  TSM System is a module of Project Management System"+
    "\nTSM system focuses on the management of proper flow of work as per time and the successful completion\n"
    +" of the project with in the estimated time."+" The users of this management system are from various\n"+ "authentication levels right from project manager to developers."+" So many features of the system are\n" +"inactive to some users basing on their authentication levels.\n"+
    "				                      The TSM system starts with a login screen querying\n"+
    "for username and  password. And basing upon the user logged on, the system will respond with appropriate\n"+ "menu items active and some inactive. The system should provide this user privilege and basing on the user\n" +"master table contents. The system should provide the flexibility in changing the password of a particular\n" +"user.";
  	public void actionPerformed(ActionEvent e)
	  	{
		   JOptionPane.showMessageDialog(null,s,
                                            "TimeSheet ManagementSystem",JOptionPane.INFORMATION_MESSAGE);
		}
    }
  public static void main(String args[])
    {
    MainWindow m=new MainWindow();
    LoginFrame l=new LoginFrame();
    }
}

