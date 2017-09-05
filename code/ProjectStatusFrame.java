import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
public class ProjectStatusFrame extends JFrame   implements ActionListener,ItemListener
  {
  Connection con;
  Statement stmt, stmt1, stmt2, stmt4;
  ResultSet rs, rs1, rs2, rs4;
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JTextField jTextField3 = new JTextField();

  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout(2,3);

  JLabel jLabel5 = new JLabel("    Project ID");
  JLabel jLabel6 = new JLabel("    Revision Number");
  JLabel jLabel7 = new JLabel("    Project Name");

  JTextField jTextField5=new JTextField();
  JTextField jTextField6=new JTextField();
  JComboBox   jComboBox1=new JComboBox();
  JComboBox   jComboBox20=new JComboBox();

  public ProjectStatusFrame() {
    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ProjectStatusFrame projectStatusFrame1 = new ProjectStatusFrame();
  }

  private void jbInit() throws Exception
    {
    this.setSize(600,300);
		this.setLocation(100,100);
    this.setResizable(true);
    this.setTitle("Project Status");
    try
      {
       // Load the Driver class file
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Make a connection to the ODBC datasource xoffice
			con = DriverManager.getConnection( "jdbc:odbc:tms");//, "scott", "tiger");
      stmt=con.createStatement();
      rs=stmt.executeQuery("select distinct pid from launch1");
      while(rs.next())
        {
        jComboBox1.addItem(rs.getString("pid"));
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
    jButton1.setText("Show");
    jButton1.setBounds(new Rectangle(73, 215, 103, 35));
    jButton2.setText("Cancel");
    jButton2.setBounds(new Rectangle(228, 219, 94, 33));
    jButton3.setText("Exit");
    jButton3.setBounds(new Rectangle(369, 218, 94, 34));
    jLabel1.setText("PlanVs Actual Module Taskwise");
    jLabel1.setBounds(new Rectangle(10, 4, 188, 32));
    jLabel2.setText("Project Initiation Date");
    jLabel2.setBounds(new Rectangle(12, 132, 123, 33));
    jLabel3.setText("Revision Initiation Date");
    jLabel3.setBounds(new Rectangle(289, 138, 135, 24));
    jLabel4.setText("Customer Name");
    jLabel4.setBounds(new Rectangle(11, 165, 98, 27));
    jTextField1.setBounds(new Rectangle(147, 137, 132, 24));
    jTextField2.setBounds(new Rectangle(422, 136, 135, 25));
    jTextField3.setBounds(new Rectangle(144, 170, 411, 22));

    jPanel1.setLayout(gridLayout1);
    jPanel1.setBounds(new Rectangle(11, 34, 548, 60));
    this.getContentPane().setLayout(null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton3, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel5);
    jPanel1.add(jLabel6);
    jPanel1.add(jLabel7);
    jPanel1.add(jComboBox1);
    jPanel1.add(jComboBox20);
    jPanel1.add(jTextField5);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jTextField1, null);
    this.getContentPane().add(jTextField2, null);
    this.getContentPane().add(jTextField3, null);
    jButton1.addActionListener(this);
    jButton2.addActionListener(this);
    jButton3.addActionListener(this);
    jComboBox1.addItemListener(this);

 // Center the window
    this.setVisible(true);
    this.setBackground(new Color(100, 106, 106));
    jTextField1.setEditable(false);
    jTextField2.setEditable(false);
    jTextField3.setEditable(false);
    jTextField5.setEditable(false);

  }
public void itemStateChanged(ItemEvent ie)
  {
    String s=(String)ie.getItem();
  try
    {
     jComboBox20.removeAllItems();
     stmt4=con.createStatement();
     rs4=stmt4.executeQuery("select rno from launch1 where pid="
                               +jComboBox1.getSelectedItem()+"");
    while(rs4.next())
     {
     jComboBox20.addItem(rs4.getString("rno"));
     }
    }
  catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
  }
public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource() == jButton1)
    {
     jTextField3.setText("");
    jTextField5.setText("");

    try
      {
      stmt1=con.createStatement();
      rs1=stmt1.executeQuery("select * from launch1");
      while(rs1.next())
        {
        if(jComboBox1.getSelectedItem().equals(rs1.getString("pid"))
            && jComboBox20.getSelectedItem().equals(rs1.getString("rno")) )
          {
          jTextField1.setText(rs1.getString("pidt"));
          jTextField2.setText(rs1.getString("ridate"));
          jTextField6.setText(rs1.getString("cid"));
          }
        }
      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
     try
      {
      stmt2=con.createStatement();
      rs2=stmt2.executeQuery("select * from customerdetails");
      while(rs2.next())
        {
        if(jTextField6.getText().equals(rs2.getString("cid")))
          {
          jTextField3.setText(rs2.getString("ciddesc"));
          jTextField5.setText(rs2.getString("cpiddesc"));
          }
        }
      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
     }
  if(ae.getSource() == jButton2)
    {
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jComboBox20.removeAllItems();
    jTextField5.setText("");
    }
  if(ae.getSource() == jButton3)
     {
     this.dispose();
     }
   }
}

