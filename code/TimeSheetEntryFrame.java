import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class TimeSheetEntryFrame extends JFrame implements ActionListener{
  static int i=0;
  int j = 0, k = 0, zx;
  CommonDoubleFrame cdf;
  Statement  stmt, stmt1, stmt2, stmt4, stmt5, stmt6, stmt7;
  ResultSet rs, rs1, rs2;
  Connection con;
  String l, ueid, ua, l3, l4;
  JLabel jLabel1 = new JLabel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JLabel jLabel3 = new JLabel();

  JPanel jPanel1 = new JPanel();


  JLabel jLabel4 = new JLabel("Project ID");
  JLabel jLabel5 = new JLabel("CLassification");
  JLabel jLabel6 = new JLabel("Module Name");
  JLabel jLabel7 = new JLabel("Activity");
  JLabel jLabel8 = new JLabel("Task");
  JLabel jLabel9 = new JLabel("Status");
  JLabel jLabel12 = new JLabel("Total Time");

  JTextField jTextField3 = new JTextField();
  JTextField jTextField5 = new JTextField();
  JTextField jTextField6 = new JTextField();

  JComboBox jComboBox2 = new JComboBox();

  JTextField jTextField2 = new JTextField();
  JTextField jTextField4 = new JTextField();
  JTextField jTextField30 = new JTextField();

  GridLayout gridLayout1 = new GridLayout(2,9);


  JTextField jTextField10 = new JTextField();

  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();

  JButton jButton20 = new JButton();
  JButton jButton21 = new JButton();

  public TimeSheetEntryFrame(String g,String h)
    {
    ueid=g;
    ua=h;

    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    TimeSheetEntryFrame timeSheetEntryFrame1 = new TimeSheetEntryFrame("","");
  }

  private void jbInit() throws Exception {
    jLabel12.setText("Effort in hrs");
		this.setSize(700,339);
		this.setLocation(100,100);
    this.setResizable(true);
    this.setTitle("Time Sheet Entry");
    try
      {
       // Load the Driver class file
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Make a connection to the ODBC datasource xoffice
			con = DriverManager.getConnection( "jdbc:odbc:tms");
      stmt=con.createStatement();
       }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
		catch (ClassNotFoundException cnfe)
      {
			System.err.println(cnfe.getMessage());
		  }
    jTextField2.setEditable(false);
    jTextField4.setEditable(false);
    jTextField3.setEditable(false);
    jTextField5.setEditable(false);
    jTextField6.setEditable(false);
    jLabel1.setText("Shift");
    jLabel1.setBounds(new Rectangle(24, 11, 45, 34));
    jButton1.setText("Save");
    jButton1.setBounds(new Rectangle(100, 238, 117, 39));
    jButton2.setText("Cancel");
    jButton2.setBounds(new Rectangle(256, 238, 128, 41));
    jButton3.setText("Exit");
    jButton3.setBounds(new Rectangle(423, 237, 130, 41));
    jLabel3.setText("Time Sheet Details");
    jLabel3.setBounds(new Rectangle(16, 57, 137, 28));

    jPanel1.setLayout(gridLayout1);


    jPanel1.setBounds(new Rectangle(0, 91, 700, 60));
    jTextField10.setBounds(new Rectangle(62, 18, 105, 24));
    jButton4.setText("jButton4");
    jButton4.setBounds(new Rectangle(175, 17, 30, 26));
    jButton5.setText("Use");
    jButton5.setBounds(new Rectangle(213, 17, 57, 27));

    jButton20.setText("Select Project and  Module");
    jButton20.setBounds(new Rectangle(280,17,300,27));
    jButton21.setText("Use");
    jButton21.setBounds(new Rectangle(589, 17, 57, 27));


    jComboBox2.addItem("WIP");
    jComboBox2.addItem("COMPLETED");


    jPanel1.add(jLabel4);
    jPanel1.add(jLabel5);
    jPanel1.add(jLabel6);
    jPanel1.add(jLabel7);
    jPanel1.add(jLabel8);
    jPanel1.add(jLabel9);
    jPanel1.add(jLabel12);

    jPanel1.add(jTextField2);
    jPanel1.add(jTextField3);
    jPanel1.add(jTextField4);
    jPanel1.add(jTextField5);
    jPanel1.add(jTextField6);
    jPanel1.add(jComboBox2);
    jPanel1.add(jTextField30);

    this.getContentPane().add(jTextField10, null);
    this.getContentPane().add(jButton4, null);
    this.getContentPane().add(jButton5, null);

    this.getContentPane().add(jButton20, null);
    this.getContentPane().add(jButton21, null);

    this.getContentPane().setLayout(null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jButton3, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jPanel1, null);
    jButton1.addActionListener(this);
    jButton2.addActionListener(this);
    jButton3.addActionListener(this);
    jButton4.addActionListener(this);
    jButton5.addActionListener(this);

    jButton20.addActionListener(this);
    jButton21.addActionListener(this);

    jButton5.setEnabled(false);
    jButton21.setEnabled(false);
    jTextField10.setEditable(false);
// Center the window
    this.setVisible(true);
  }



  public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource() ==  jButton4)
    {
    jButton5.setEnabled(true);
    ShiftFrame f=new ShiftFrame(ua);
    l=f.ret();
    }
  if(ae.getSource() ==  jButton5)
    {
    int x=0;
    ShiftFrame f=new ShiftFrame(x,ua);
    l=f.ret();
    jTextField10.setText(""+f.s);

    }
  if(ae.getSource() ==  jButton1)
    {
    int flag=0,ok=0;
    try
      {
      stmt2=con.createStatement();
      stmt6=con.createStatement();
      stmt7=con.createStatement();
      rs2=stmt7.executeQuery("select pid,mname,effort from timesheetentry ");
      while(rs2.next())
        {
        if(jTextField2.getText().equals(rs2.getString("pid")) &&
           jTextField4.getText().equals(rs2.getString("mname")))
           {
            if( jTextField2.getText().equals("") || jTextField3.getText().equals("")||
            jTextField4.getText().equals("") ||jTextField5.getText().equals("") ||
            jTextField6.getText().equals("") ||
            jTextField10.getText().equals("")|| jTextField30.getText().equals(""))
  /*observecp1*/             JOptionPane.showMessageDialog(null,"INFORMATION INADEQUATE");
           else
              {
                String ss=rs2.getString("effort");
                int aaa=Integer.parseInt(ss);
                String rr= jTextField30.getText();
                int bbb=Integer.parseInt(rr);
                int ccc=aaa+bbb;
                String  sss;
                sss=Integer.toString(ccc);
               stmt2.executeUpdate("update timesheetentry set status='"
                          +jComboBox2.getSelectedItem()+
                          "',effort='"+sss+
                          "' where (eid = '"+ueid+"' and mname = '"+jTextField4.getText()
                          +"' and pid = "+jTextField2.getText()+")");
                          ok=1;
               JOptionPane.showMessageDialog(null,"updated successfully!");
               flag=1;
              }
           }
        }
      if(flag==0)
          {
          if( jTextField2.getText().equals("") || jTextField3.getText().equals("")||
          jTextField4.getText().equals("") ||jTextField5.getText().equals("") ||
          jTextField6.getText().equals("")|| 
          jTextField10.getText().equals(""))
              JOptionPane.showMessageDialog(null,"INFORMATION INADEQUATE");
          else
              {
              stmt2.executeUpdate("insert into timesheetentry values('"+ueid+
                             "','"+jTextField10.getText()+
                             "','"+jTextField2.getText()+
                             "','"+jTextField4.getText()+
                             "','"+jComboBox2.getSelectedItem()+
                             "','"+jTextField30.getText()+"')");
                             ok=1;
              JOptionPane.showMessageDialog(null,"saved successfully!");
              }
          }
      if(jComboBox2.getSelectedItem().equals("COMPLETED") && ok==1)
        {
         stmt4=con.createStatement();
         stmt4.executeUpdate("update moduleassignment set status='"
                              +jComboBox2.getSelectedItem()+
                          "' where (eid = '"+ueid+"' and mname = '"+jTextField4.getText()
                          +"' and pid = "+jTextField2.getText()+")");
         stmt5=con.createStatement();
         stmt5.executeUpdate("update usermaster set ma=ma-1 where eid='" +ueid+"'");

        }

      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
	finally
		{
		 jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField6.setText("");
    jTextField10.setText("");
    jTextField30.setText("");
  	}

    }
  if(ae.getSource() ==  jButton2)
    {
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField10.setText("");
    jTextField30.setText("");
    jButton21.setEnabled(false);
    jButton5.setEnabled(false);
    }
  if(ae.getSource() ==  jButton3)
    {
    this.dispose();
    }
  if(ae.getSource() ==  jButton20)
    {
    cdf=new CommonDoubleFrame("Project and Assigned Module",
    " ","select pid,mname from moduleassignment where eid = '"+ueid+"'"+
                            " and status = 'WIP' ");
    l3=cdf.ret();
    l4=cdf.rety();
    jButton21.setEnabled(true);
    }
  if(ae.getSource() ==  jButton21)
    {
    int x=0;
    cdf=new CommonDoubleFrame(x,"Project and Assigned Module",
    " ","select pid,mname from moduleassignment where eid = '"+ueid+"'"+
                            " and status = 'WIP' ");
    l3=cdf.ret();
    l4=cdf.rety();
    jTextField2.setText(""+cdf.s);
    jTextField4.setText(""+cdf.s2);
     try
      {
      stmt1=con.createStatement();
      rs1=stmt1.executeQuery("select pid,clid from launch1");
      rs=stmt.executeQuery("select * from moduleassignment");
      while(rs.next())
        {
        if(jTextField2.getText().equals(rs.getString("pid")) &&
           jTextField4.getText().equals(rs.getString("mname")))
           {
           jTextField5.setText(rs.getString("acode"));
           jTextField6.setText(rs.getString("tode"));
           }
        }
      while(rs1.next())
        {
        if(jTextField2.getText().equals(rs1.getString("pid")))
          {
          jTextField3.setText(rs1.getString("clid"));
          }
        }
      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
    }
  }
}
