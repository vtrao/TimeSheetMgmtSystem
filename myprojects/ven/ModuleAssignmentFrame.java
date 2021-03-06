 package ven;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import java.awt.*;
import com.sun.java.swing.JFrame;
import java.io.*;

public class ModuleAssignmentFrame extends JFrame implements ActionListener, ItemListener
  {
  String l, l2;
  CommonDoubleFrame p1;
  CommonDoubleFrame p2;
  Connection con;
  ResultSet rs, rs1, rs2, rs3, rs4;
  Statement stmt, stmt1, stmt2, stmt3, stmt4, stmt5, stmt6;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField jTextField3 = new JTextField();
  JTextField jTextField4 = new JTextField();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
  JButton jButton6 = new JButton();
  JButton jButton7 = new JButton();
  JLabel jLabel6 = new JLabel("  Activity");
  JLabel jLabel7 = new JLabel("  Task");
  JLabel jLabel8 = new JLabel("  ModuleName");
  JLabel jLabel9 = new JLabel("  Employee");
  JLabel jLabel10 = new JLabel("  TimeInHours");
  JLabel jLabel11 = new JLabel("   ScheduleStartDate");
  JTextField jTextField5 = new JTextField();
  JTextField jTextField6 = new JTextField();
  JComboBox jComboBox1=new JComboBox();
  JComboBox jComboBox2=new JComboBox();
  JComboBox jComboBox3=new JComboBox();
  JComboBox jComboBox4=new JComboBox();

  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout(2,6);

  public ModuleAssignmentFrame() {
    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ModuleAssignmentFrame moduleAssignmentFrame1 = new ModuleAssignmentFrame();
  }

  private void jbInit() throws Exception {
	  this.setSize(662,402);
		this.setLocation(100,100);
    this.setResizable(true);
    this.setTitle("ModuleAssignment");
    try
      {
       // Load the Driver class file
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Make a connection to the ODBC datasource xoffice
			con = DriverManager.getConnection( "jdbc:odbc:tms");//, "scott", "tiger");
      stmt=con.createStatement();
      stmt5=con.createStatement();
      }
		catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
		catch (ClassNotFoundException cnfe)
      {
			System.err.println(cnfe.getMessage());
		  }
    jLabel1.setText("Project Internal Number");
    jLabel1.setBounds(new Rectangle(11, 19, 139, 30));
    jLabel2.setText("Revision Number");
    jLabel2.setBounds(new Rectangle(11, 54, 129, 34));
    jLabel3.setText("Project Initiation Date");
    jLabel3.setBounds(new Rectangle(384, 18, 130, 29));
    jLabel4.setText("Revision Initiation Date");
    jLabel4.setBounds(new Rectangle(384, 52, 133, 35));
    jButton1.setText("Save");
    jButton1.setBounds(new Rectangle(116, 281, 98, 45));
    jButton2.setText("Cancel");
    jButton2.setBounds(new Rectangle(262, 282, 98, 43));
    jButton3.setText("Exit");
    jButton3.setBounds(new Rectangle(405, 281, 99, 45));
    jTextField1.setBounds(new Rectangle(158, 24, 107, 24));
    jTextField2.setBounds(new Rectangle(158, 61, 105, 24));
    jLabel5.setText("Assignment Details");
    jLabel5.setBounds(new Rectangle(8, 97, 125, 31));
    jTextField3.setBounds(new Rectangle(511, 23, 121, 23));
    jTextField4.setBounds(new Rectangle(512, 59, 121, 24));
    jButton4.setText("jButton4");
    jButton4.setBounds(new Rectangle(278, 24, 24, 23));
    jButton5.setText("jButton5");
    jButton5.setBounds(new Rectangle(279, 59, 24, 23));
    jButton6.setText("Use");
    jButton6.setBounds(new Rectangle(311, 22, 58, 25));
    jButton7.setText("Use");
    jButton7.setBounds(new Rectangle(312, 58, 57, 24));
    jPanel1.setLayout(gridLayout1);
    jPanel1.setBounds(new Rectangle(20, 139, 602, 60));
    this.getContentPane().setLayout(null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton3, null);
    this.getContentPane().add(jTextField1, null);
    this.getContentPane().add(jTextField2, null);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(jTextField3, null);
    this.getContentPane().add(jTextField4, null);
    this.getContentPane().add(jButton4, null);
    this.getContentPane().add(jButton5, null);
    this.getContentPane().add(jButton6, null);
    this.getContentPane().add(jButton7, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel6);
    jPanel1.add(jLabel7);
    jPanel1.add(jLabel8);
    jPanel1.add(jLabel9);
    jPanel1.add(jLabel10);
    jPanel1.add(jLabel11);
    jPanel1.add(jComboBox1);
    jPanel1.add(jComboBox2);
    jPanel1.add(jComboBox3);
    jPanel1.add(jComboBox4);
    jPanel1.add(jTextField5);
    jPanel1.add(jTextField6);
    jButton4.addActionListener(this);
    jButton5.addActionListener(this);
    jButton6.addActionListener(this);
    jButton7.addActionListener(this);
    jButton1.addActionListener(this);
    jButton2.addActionListener(this);
    jButton3.addActionListener(this);

    jComboBox3.addItemListener(this);

    jButton6.setEnabled(false);
    jButton7.setEnabled(false);
    jTextField1.setEditable(false);
    jTextField2.setEditable(false);
    jTextField3.setEditable(false);
    jTextField4.setEditable(false);
    jTextField5.setEditable(false);
    this.addMouseMotionListener(new l());
// Center the window
    this.setVisible(true);
  }
 public class l extends MouseMotionAdapter
  {
  public void mouseMoved(MouseEvent me)
    {

    }
   } 

  public void itemStateChanged(ItemEvent ie)
  {
    String s=(String)ie.getItem();
  try
    {
    jComboBox4.removeAllItems();
    jComboBox1.removeAllItems();
    jComboBox2.removeAllItems();
    stmt4=con.createStatement();

     rs3=stmt4.executeQuery("select * from timeestimation where mname='"+s+"' and pid ="+
                            jTextField1.getText()+"");

     while(rs3.next())
     {
     jTextField5.setText(rs3.getString("time"));
     jComboBox4.addItem(rs3.getString("rescode"));
     jComboBox1.addItem(rs3.getString("acode"));
     jComboBox2.addItem(rs3.getString("tcode"));
     }
    }
  catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
  }
  public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource()== jButton1)
    {
    try
      {
      if( jTextField1.getText().equals("") || jTextField2.getText().equals("")||
          jTextField5.getText().equals("") ||jTextField6.getText().equals("") ||
          jTextField3.getText().equals("") || jTextField4.getText().equals(""))
          JOptionPane.showMessageDialog(null,"INFORMATION ADEQUATE");
      else
      stmt2=con.createStatement();
      stmt2.executeUpdate("insert into moduleassignment values('"+jTextField1.getText()+
                             "','"+jComboBox1.getSelectedItem()+
                             "','"+jComboBox2.getSelectedItem()+
                             "','"+jComboBox3.getSelectedItem()+
                             "','"+jComboBox4.getSelectedItem()+
                             "','"+jTextField5.getText()+
                             "','"+jTextField6.getText()+
                             "','WIP')");
      stmt5.executeUpdate("update timeestimation set assignvalue = 1"+
                    " where pid ="+jTextField1.getText()+
                    " and mname= '"+jComboBox3.getSelectedItem()+
                    "' and tcode= '"+jComboBox2.getSelectedItem()+
                    "' and acode= '"+jComboBox1.getSelectedItem()+
                    "' and rescode= '"+jComboBox4.getSelectedItem()+"'");

      JOptionPane.showMessageDialog(null,"SAVED SUCCESSFULLY!");
      }
  	catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
    try
      {
      stmt3=con.createStatement();
      stmt3.executeUpdate( "update usermaster set ma=ma+1 where eid='"+
                          jComboBox4.getSelectedItem()+"'");
      }
  	catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }

  finally
  {
            jComboBox3.removeAllItems();
    jComboBox1.removeAllItems();
    jComboBox2.removeAllItems();
    jComboBox4.removeAllItems();
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jButton6.setEnabled(false);
    jButton7.setEnabled(false);
  }
  }
  if(ae.getSource()== jButton2)
    {
    jComboBox3.removeAllItems();
    jComboBox1.removeAllItems();
    jComboBox2.removeAllItems();
    jComboBox4.removeAllItems();
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jButton6.setEnabled(false);
    jButton7.setEnabled(false);
    }
  if(ae.getSource()== jButton3)
    {
    this.dispose();
    }
  if(ae.getSource()== jButton4)
    {
    p1=new CommonDoubleFrame("Project Number And Project Initiation Date",
                 "   Project Internal  Number        |   Project Initiation Date",
                   "select distinct pid,pidt from launch1");
    l=p1.ret();
    l2=p1.rety();
    jButton6.setEnabled(true);
    }
  if(ae.getSource()== jButton6)
    {
    int x=0;
    p1=new CommonDoubleFrame(x,"Project Number And Project Initiation Date",
                 "   Project Internal  Number        |   Project Initiation Date",
                   "select distinct pid,pidt from launch1");
    l=p1.ret();
    l2=p1.rety();
    jTextField1.setText(""+p1.s);
    jTextField3.setText(""+p1.s2);
    jComboBox1.removeAllItems();
    jComboBox2.removeAllItems();
    jComboBox3.removeAllItems();
    try
      {
      stmt1=con.createStatement();
      rs1=stmt1.executeQuery("select mname,acode,tcode,pid from timeestimation where assignvalue=0");
      while(rs1.next())
        {
        if(jTextField1.getText().equals(rs1.getString("pid")))
          {
          jComboBox3.addItem(rs1.getString("mname"));
          }
        }
      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
      try
    {
    rs4=stmt4.executeQuery("select * from Launch1 where pid ="+jTextField1.getText()+"");

     while(rs4.next())
     {
     jTextField6.setText(rs4.getString("ssdt"));
     }
     }
     catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
    }
  if(ae.getSource()== jButton5)
    {
    p2=new CommonDoubleFrame("Revision Number And Revision Initiation Date",
                 "   Revision  Number         |   Revision Initiation Date",
                 "select rno,ridate from launch1 where pid="+jTextField1.getText()+"");
    l=p2.ret();
    l2=p2.rety();
    jButton7.setEnabled(true);
    }
  if(ae.getSource()== jButton7)
    {
    int x=0;
    p2=new CommonDoubleFrame(x,"Revision Number And Revision Initiation Date",
                 "   Revision  Number         |   Revision Initiation Date",
                 "select rno,ridate from launch1 where pid="+jTextField1.getText()+"");
    l=p2.ret();
    l2=p2.rety();
    jTextField2.setText(""+p2.s);
    jTextField4.setText(""+p2.s2);

    }
  }
}