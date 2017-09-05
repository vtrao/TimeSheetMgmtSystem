import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import java.util.Date;

public class ProjectLaunchFrame extends JFrame implements ActionListener{
    CommonDoubleFrame cdf, cdfr, pl, pm;
    CDFrame cd;
    PTypeFrame pt;
    String l, l2, l3, l4, l5;
    CFrame cf;
    private Connection con;
    private ResultSet rs, rs1, rs2, rs3;
    private Statement stmt, stmt1, stmt2, stmt3, stmt4;
    JPanel jPanel1 = new JPanel();
	  JPanel jPanel2 = new JPanel();
	  JPanel jPanel3 = new JPanel();
	  JPanel jPanel4 = new JPanel();
	  JLabel jLabel1 = new JLabel();
	  JLabel jLabel2 = new JLabel();
	  JLabel jLabel3 = new JLabel();
	  JLabel jLabel4 = new JLabel();
	  JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
	  JButton jButton3 = new JButton();
	  JLabel jLabel5 = new JLabel();
	  JLabel jLabel6 = new JLabel();
	  JLabel jLabel7 = new JLabel();
	  JLabel jLabel8 = new JLabel();
	  JLabel jLabel9 = new JLabel();
	  JLabel jLabel10 = new JLabel();
	  JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
	  JTextField jTextField3 = new JTextField();
	  JTextField jTextField4 = new JTextField();
	  JTextField jTextField5 = new JTextField();
	  JTextField jTextField6 = new JTextField();
	  JLabel jLabel11 = new JLabel();
	  JLabel jLabel12 = new JLabel();
	  JLabel jLabel13 = new JLabel();
	  JTextField jTextField7 = new JTextField();
	  JTextField jTextField8 = new JTextField();
	  JTextField jTextField9 = new JTextField();
	  JTextField jTextField10 = new JTextField();
	  JLabel jLabel14 = new JLabel();
	  JLabel jLabel15 = new JLabel();
	  JTextField jTextField11 = new JTextField();
	  JTextField jTextField12 = new JTextField();
	  JTextField jTextField13 = new JTextField();
	  JTextField jTextField14 = new JTextField();
	  JLabel jLabel16 = new JLabel();
	  JLabel jLabel17 = new JLabel();
	  JTextField jTextField15 = new JTextField();
	  JLabel jLabel18 = new JLabel();
	  JLabel jLabel19 = new JLabel();
	  JTextField jTextField16 = new JTextField();
    JButton jButton4 = new JButton();
    JButton jButton5 = new JButton();
    JButton jButton6 = new JButton();
    JButton jButton7 = new JButton();
    JButton jButton8 = new JButton();
    JButton jButton9 = new JButton();
    JButton jButton10 = new JButton();
    JButton jButton11 = new JButton();
    JButton jButton12 = new JButton();
    JButton jButton13 = new JButton();
    JButton jButton14 = new JButton();
    JButton jButton15 = new JButton();
    JButton jButton16 = new JButton();
    JButton jButton17 = new JButton();
    JTextField jTextField17 = new JTextField();
    JTextField jTextField18 = new JTextField();
    JTextField jTextField19 = new JTextField();
    JTextField jTextField20 = new JTextField();
    JTextField jTextField21 = new JTextField();
    JLabel jLabel20 = new JLabel();
    JLabel jLabel21 = new JLabel();



	  public ProjectLaunchFrame()
		  {
      try
        {
         // Load the Driver class file
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		  	// Make a connection to the ODBC datasource xoffice
			  con = DriverManager.getConnection( "jdbc:odbc:tms");//, "scott", "tiger");
        }
		  catch (SQLException sqle)
        {
			  System.err.println(sqle.getMessage());
        }
		  catch (ClassNotFoundException cnfe)
        {
			  System.err.println(cnfe.getMessage());
		    }
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
		    ProjectLaunchFrame projectLaunchFrame1 = new ProjectLaunchFrame();
      }

	  private void jbInit() throws Exception
		  {
  	    this.setSize(700,550);
		    this.setLocation(100,100);
        this.setResizable(true);
		    this.getContentPane().setLayout(null);
		    jPanel1.setLayout(null);
		    this.setTitle("Project Launch");
		    jPanel1.setBounds(new Rectangle(0, 32, 684, 104));
		    jPanel2.setLayout(null);
		    jPanel2.setBounds(new Rectangle(5, 155, 669, 93));
		    jPanel3.setLayout(null);
		    jPanel3.setBounds(new Rectangle(5, 274, 674, 60));
		    jPanel4.setLayout(null);
		    jPanel4.setBounds(new Rectangle(4, 356, 612, 54));
		    jLabel1.setText("Project Details");
		    jLabel1.setBounds(new Rectangle(11, 8, 128, 20));
		    jLabel2.setText("  Customer Details");
		    jLabel2.setBounds(new Rectangle(3, 130, 135, 25));
		    jLabel3.setText("Project Team");
		    jLabel3.setBounds(new Rectangle(2, 245, 125, 22));
		    jLabel4.setText("Project Schedule");
		    jLabel4.setBounds(new Rectangle(2, 329, 141, 24));
		    jButton1.setText("jButton1");
		    jButton1.setLabel(" Save");
		    jButton1.setBounds(new Rectangle(103, 436, 78, 31));
        jButton2.setText("jButton2");
        jButton2.setLabel("Cancel");
        jButton2.setBounds(new Rectangle(278, 438, 73, 33));
        jButton3.setText("jButton3");
        jButton3.setLabel("Exit");
        jButton3.setBounds(new Rectangle(456, 435, 72, 34));
        jLabel5.setText("Project Internal Number");
        jLabel5.setBounds(new Rectangle(18, 4, 138, 22));
        jLabel6.setText("Revision Number");
        jLabel6.setBounds(new Rectangle(18, 26, 118, 19));
        jLabel7.setText("Project Type");
        jLabel7.setBounds(new Rectangle(20, 43, 119, 24));
        jLabel8.setText("Classification");
        jLabel8.setBounds(new Rectangle(21, 67, 106, 24));
        jLabel9.setText("Project Initiation Date");
        jLabel9.setBounds(new Rectangle(392, 0, 128, 24));
        jLabel10.setText("Revision Initiation Date");
        jLabel10.setBounds(new Rectangle(393, 21, 131, 25));
        jTextField1.setBounds(new Rectangle(167, 1, 96, 19));
        jTextField2.setBounds(new Rectangle(167, 24, 97, 19));
        jTextField3.setBounds(new Rectangle(167, 47, 98, 18));
        jTextField4.setBounds(new Rectangle(167, 69, 97, 18));
        jTextField5.setBounds(new Rectangle(385, 49, 275, 18));
        jTextField6.setBounds(new Rectangle(386, 70, 277, 17));
        jLabel11.setText("Customer ID");
        jLabel11.setBounds(new Rectangle(21, 11, 96, 20));
        jLabel12.setText("Customer Project ID");
        jLabel12.setBounds(new Rectangle(20, 32, 129, 21));
        jLabel13.setText("Order Receipt Date");
        jLabel13.setBounds(new Rectangle(19, 62, 116, 21));
        jTextField7.setBounds(new Rectangle(156, 10, 105, 20));
        jTextField8.setBounds(new Rectangle(157, 35, 105, 20));
        jTextField9.setBounds(new Rectangle(372, 10, 282, 21));
        jTextField10.setBounds(new Rectangle(374, 38, 283, 20));
        jLabel14.setText("Project Manager");
        jLabel14.setBounds(new Rectangle(25, 1, 111, 21));
        jLabel15.setText("Project Leader");
        jLabel15.setBounds(new Rectangle(24, 25, 111, 23));
        jTextField11.setBounds(new Rectangle(154, 2, 103, 19));
        jTextField12.setBounds(new Rectangle(153, 26, 105, 20));
        jTextField13.setBounds(new Rectangle(382, 0, 280, 22));
        jTextField14.setBounds(new Rectangle(382, 26, 281, 21));
        jLabel16.setText("Schedule Start Date");
        jLabel16.setBounds(new Rectangle(28, 6, 119, 20));
        jLabel17.setText("Actual Start Date");
        jLabel17.setBounds(new Rectangle(30, 34, 109, 18));
        jTextField15.setBounds(new Rectangle(165, 34, 127, 19));
        jLabel18.setText("Schedule End Date");
        jLabel18.setBounds(new Rectangle(317, 3, 114, 23));
        jLabel19.setText("Actual End Date");
        jLabel19.setBounds(new Rectangle(319, 32, 112, 21));
        jTextField16.setBounds(new Rectangle(440, 33, 129, 24));
        jButton4.setText("jButton4");
        jButton4.setBounds(new Rectangle(272, 1, 25, 19));
        jButton5.setText("jButton5");
        jButton5.setBounds(new Rectangle(272, 24, 26, 19));
        jButton6.setText("jButton6");
        jButton6.setBounds(new Rectangle(272, 45, 27, 19));
        jButton7.setText("jButton7");
        jButton7.setBounds(new Rectangle(271, 67, 27, 21));
        jButton8.setText("jButton8");
        jButton8.setBounds(new Rectangle(270, 10, 25, 21));
        jButton9.setText("jButton9");
        jButton9.setBounds(new Rectangle(267, 4, 27, 19));
        jButton10.setText("jButton10");
        jButton10.setBounds(new Rectangle(267, 27, 27, 19));
        jButton11.setText("Use");
        jButton11.setBounds(new Rectangle(302, 1, 64, 20));
        jButton12.setText("Use");
        jButton12.setBounds(new Rectangle(302, 24, 67, 19));
        jButton13.setText("Use");
        jButton13.setBounds(new Rectangle(303, 45, 64, 19));
        jButton14.setText("Use");
        jButton14.setBounds(new Rectangle(303, 67, 66, 19));
        jButton15.setText("Use");
        jButton15.setBounds(new Rectangle(303, 9, 61, 20));
        jButton16.setText("Use");
        jButton16.setBounds(new Rectangle(303, 3, 64, 21));
        jButton17.setText("Use");
        jButton17.setBounds(new Rectangle(304, 26, 65, 20));
        jTextField17.setBounds(new Rectangle(529, 2, 116, 20));
        jTextField18.setBounds(new Rectangle(530, 24, 116, 20));
        jTextField19.setBounds(new Rectangle(159, 63, 104, 19));
        jTextField20.setBounds(new Rectangle(165, 9, 125, 21));
        jTextField21.setBounds(new Rectangle(439, 4, 129, 22));
    jLabel20.setText("CURRENT DATE AND TIME");
    jLabel20.setBounds(new Rectangle(290, 28, 163, 22));

    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(jLabel9, null);
    jPanel1.add(jLabel10, null);
    jPanel1.add(jTextField1, null);
    jPanel1.add(jTextField2, null);
    jPanel1.add(jTextField3, null);
    jPanel1.add(jTextField4, null);
    jPanel1.add(jTextField5, null);
    jPanel1.add(jTextField6, null);
    jPanel1.add(jButton4, null);
    jPanel1.add(jButton5, null);
    jPanel1.add(jButton6, null);
    jPanel1.add(jButton7, null);
    jPanel1.add(jButton11, null);
    jPanel1.add(jButton12, null);
    jPanel1.add(jButton13, null);
    jPanel1.add(jButton14, null);
    jPanel1.add(jTextField17, null);
    jPanel1.add(jTextField18, null);
    this.getContentPane().add(jPanel2, null);
        jPanel2.add(jLabel11, null);
        jPanel2.add(jLabel12, null);
        jPanel2.add(jLabel13, null);
        jPanel2.add(jTextField7, null);
        jPanel2.add(jTextField8, null);
        jPanel2.add(jTextField9, null);
        jPanel2.add(jTextField10, null);
        jPanel2.add(jButton8, null);
        jPanel2.add(jButton15, null);
        jPanel2.add(jTextField19, null);
        this.getContentPane().add(jPanel3, null);
        jPanel3.add(jLabel14, null);
        jPanel3.add(jLabel15, null);
        jPanel3.add(jTextField11, null);
        jPanel3.add(jTextField12, null);
        jPanel3.add(jTextField13, null);
        jPanel3.add(jTextField14, null);
        jPanel3.add(jButton9, null);
        jPanel3.add(jButton10, null);
        jPanel3.add(jButton16, null);
        jPanel3.add(jButton17, null);

        this.getContentPane().add(jPanel4, null);
        jPanel4.add(jLabel16, null);
        jPanel4.add(jLabel17, null);
        jPanel4.add(jTextField15, null);
        jPanel4.add(jLabel18, null);
        jPanel4.add(jLabel19, null);
        jPanel4.add(jTextField16, null);
        jPanel4.add(jTextField20, null);
        jPanel4.add(jTextField21, null);

        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton3, null);
    this.getContentPane().add(jLabel20, null);
    this.getContentPane().add(jLabel21, null);
        jButton5.addActionListener(this);
        jButton4.addActionListener(this);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton12.addActionListener(this);
        jButton11.addActionListener(this);
        jButton6.addActionListener(this);
        jButton7.addActionListener(this);
        jButton13.addActionListener(this);
        jButton14.addActionListener(this);
        jButton8.addActionListener(this);
        jButton15.addActionListener(this);
        jButton9.addActionListener(this);
        jButton16.addActionListener(this);
        jButton10.addActionListener(this);
        jButton17.addActionListener(this);

        jButton11.setEnabled(false);
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
        jButton14.setEnabled(false);
        jButton15.setEnabled(false);
        jButton16.setEnabled(false);
        jButton17.setEnabled(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField9.setEditable(false);
        jTextField10.setEditable(false);
        jTextField13.setEditable(false);
        jTextField14.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField19.setEditable(false);
        jTextField11.setEditable(false);
        jTextField12.setEditable(false);

// Center the window
        this.setVisible(true);
        }
  public void actionPerformed(ActionEvent ae)
    {
    try
       {
        stmt=con.createStatement();
        stmt1=con.createStatement();
        stmt2=con.createStatement();
        stmt3=con.createStatement();
        stmt4=con.createStatement();
        rs=stmt.executeQuery("select * from launch1");
        rs1=stmt1.executeQuery("select * from classification");
        rs2=stmt2.executeQuery("select * from customerdetails");
        rs3=stmt3.executeQuery("select * from projecttype");
        }
    catch (SQLException sqle)
        {
			  System.err.println(sqle.getMessage());
        }
     if(ae.getSource()== jButton4)
        {
        cdf=new CommonDoubleFrame("Project Revision Number And Project Initiation Date",
                 "   Project Internal  Number        |   Project Initiation Date",
                   "select distinct pid,pidt from launch1");
        l=cdf.ret();
        l2=cdf.rety();
        jButton11.setEnabled(true);
        }
     if(ae.getSource()== jButton11)
        {
        int x=0;
        cdf=new CommonDoubleFrame(x,"Project Revision Number And Project Initiation Date",
                 "   Project Internal  Number        |   Project Initiation Date",
                   "select distinct pid,pidt from launch1");
        l=cdf.ret();
        l2=cdf.rety();
        jTextField1.setText(""+cdf.s);
        jTextField17.setText(""+cdf.s2);
        }
     if(ae.getSource()== jButton7)
        {
        cf=new CFrame();
        l=cf.ret();
        l2=cf.rety();
        jButton14.setEnabled(true);
        }
     if(ae.getSource()== jButton14)
        {
        int x=0;
        cf=new CFrame(x);
        l=cf.ret();
        l2=cf.rety();
        jTextField4.setText(""+cf.s);
        jTextField6.setText(""+cf.s2);
        }
     if(ae.getSource()== jButton5)
        {
        cdfr=new CommonDoubleFrame("Revision Number And Revision Initiation Date",
                 "   Revision  Number         |   Revision Initiation Date",
                 "select rno,ridate from launch1 where pid="+jTextField1.getText());
        l=cdfr.ret();
        l2=cdfr.rety();
        jButton12.setEnabled(true);
        }
     if(ae.getSource() == jButton12)
        {
        int x=0;
        cdfr=new CommonDoubleFrame(x,"Revision Number And Revision Initiation Date",
                 "   Revision  Number         |   Revision Initiation Date",
                 "select rno,ridate from launch1 where pid="+jTextField1.getText());
        l=cdfr.ret();
        l2=cdfr.rety();
        jTextField2.setText(""+cdfr.s);
        jTextField18.setText(""+cdfr.s2);
        try
         {
         while(rs.next())
          {
          if(jTextField1.getText().equals(rs.getString("pid")) &&
                  jTextField2.getText().equals(rs.getString("rno")) )
           {
          jTextField3.setText(rs.getString("ptype"));
          jTextField4.setText(rs.getString("clid"));
          jTextField17.setText(rs.getString("pidt"));
          jTextField18.setText(rs.getString("ridate"));
          jTextField10.setText(rs.getString("piddes"));
          jTextField7.setText(rs.getString("cid"));
          jTextField8.setText(rs.getString("cpid"));
          jTextField19.setText(rs.getString("resdt"));
          jTextField11.setText(rs.getString("pmid"));
          jTextField13.setText(rs.getString("pmname"));
          jTextField12.setText(rs.getString("plid"));
          jTextField14.setText(rs.getString("plname"));
          jTextField20.setText(rs.getString("ssdt"));
          jTextField21.setText(rs.getString("sedt"));
          jTextField15.setText(rs.getString("asdt"));
          jTextField16.setText(rs.getString("aedt"));
            }
          }
         while(rs1.next())
            {
            if(jTextField4.getText().equals(rs1.getString("classid")))
              jTextField6.setText(rs1.getString("classdesc"));
            }
         while(rs2.next())
            {
            if(jTextField7.getText().equals(rs2.getString("cid")))
              jTextField9.setText(rs2.getString("ciddesc"));
            }
         while(rs3.next())
            {
            if(jTextField3.getText().equals(rs3.getString("projecttype")))
              jTextField5.setText(rs3.getString("projectdesc"));
            }

          }
        catch (SQLException sqle)
            {
			      System.err.println(sqle.getMessage());
		        }
        }
     if(ae.getSource()== jButton6)
        {
        pt=new PTypeFrame();
        l=pt.ret();
        l2=pt.rety();
        jButton13.setEnabled(true);
        }
     if(ae.getSource()== jButton13)
        {
        int x=0;
        pt=new PTypeFrame(x);
        l=pt.ret();
        l2=pt.rety();
        jTextField3.setText(""+pt.s);
        jTextField5.setText(""+pt.s2);
        }
     if(ae.getSource()== jButton8)
        {
        cd=new CDFrame();
        l= cd.ret1();
        l2=cd.ret2();
        l3=cd.ret3();
        l4=cd.ret4();
        l5=cd.ret5();
        jButton15.setEnabled(true);
        }
     if(ae.getSource()== jButton15)
        {
        int x=0;
        cd=new CDFrame(x);
        l= cd.ret1();
        l2=cd.ret2();
        l3=cd.ret3();
        l4=cd.ret4();
        l5=cd.ret5();
        jTextField7.setText(""+cd.s);
        jTextField9.setText(""+cd.s4);
        jTextField8.setText(""+cd.s2);
        jTextField10.setText(""+cd.s6);
        jTextField19.setText(""+cd.s8);
        }
     if(ae.getSource()== jButton9)
        {
        pm=new CommonDoubleFrame("Project Manager Details ",
               "   ProjectManagerID        |   ProjectManagerName",
               "select eid,username from usermaster where ua=1");
        l=pm.ret();
        l2=pm.rety();
        jButton16.setEnabled(true);
        }
     if(ae.getSource()== jButton16)
        {
        int x=0;
        pm=new CommonDoubleFrame(x,"Project Manager Details ",
               "   ProjectManagerID        |   ProjectManagerName",
               "select eid,username from usermaster where ua=1");
        l=pm.ret();
        l2=pm.rety();
        jTextField11.setText(""+pm.s);
        jTextField13.setText(""+pm.s2);
        }
     if(ae.getSource()== jButton10)
        {
        pl=new CommonDoubleFrame("Project Leader Details ",
               "   ProjectLeaderID                ProjectLeaderName",
               "select eid,username from usermaster where ua=2");

        l=pl.ret();
        l2=pl.rety();
        jButton17.setEnabled(true);
        }
     if(ae.getSource()== jButton17)
        {
        int x=0;
        pl=new CommonDoubleFrame(x,"Project Leader Details ",
               "   ProjectLeaderID                ProjectLeaderName",
               "select eid,username from usermaster where ua=2");
        l=pl.ret();
        l2=pl.rety();
        jTextField12.setText(""+pl.s);
        jTextField14.setText(""+pl.s2);
        }

     if(ae.getSource()== jButton1)
        {
        int flag=0;
          try
            {
            while(rs.next())
              {
              if( jTextField1.getText().equals(rs.getString("pid")))
                {
                stmt1.executeUpdate("insert into launch1 values ('"+jTextField1.getText()
                                  +"','"+jTextField17.getText()+"','"+jTextField2.getText()
                                  +"','"+jTextField18.getText()+"','"+jTextField3.getText()
                                  +"','"+jTextField4.getText()+"','"+jTextField7.getText()
                                  +"','"+jTextField8.getText()+"','"+jTextField5.getText()
                                  +"','"+jTextField19.getText()+"','"+jTextField11.getText()
                                  +"','"+jTextField12.getText()+"','"+jTextField13.getText()
                                  +"','"+jTextField14.getText()+"','"+jTextField20.getText()
                                  +"','"+jTextField21.getText()+"','"+jTextField15.getText()
                                  +"','"+jTextField16.getText()+"')");
                JOptionPane.showMessageDialog(null,"updated successfully");
                flag=1;
		jTextField1.setText("");
         jTextField2.setText("");
         jTextField3.setText("");
         jTextField4.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jTextField7.setText("");
         jTextField8.setText("");
         jTextField9.setText("");
         jTextField10.setText("");
         jTextField11.setText("");
         jTextField12.setText("");
         jTextField13.setText("");
         jTextField14.setText("");
         jTextField15.setText("");
         jTextField16.setText("");
         jTextField17.setText("");
         jTextField18.setText("");
         jTextField19.setText("");
         jTextField20.setText("");
         jTextField21.setText("");
         jButton11.setEnabled(false);
         jButton12.setEnabled(false);
         jButton13.setEnabled(false);
         jButton14.setEnabled(false);
         jButton15.setEnabled(false);
         jButton16.setEnabled(false);
         jButton17.setEnabled(false);
                }
              }
            if(flag==0)
              {
              if( jTextField1.getText().equals("") || jTextField2.getText().equals("")||
                  jTextField3.getText().equals("") || jTextField4.getText().equals("") ||
                  jTextField5.getText().equals("") ||jTextField6.getText().equals("") ||
                  jTextField7.getText().equals("") || jTextField8.getText().equals("") ||
                  jTextField9.getText().equals("") || jTextField10.getText().equals("") ||
                  jTextField11.getText().equals("") || jTextField12.getText().equals("") ||
                  jTextField13.getText().equals("") || jTextField14.getText().equals("") ||
                  jTextField15.getText().equals("") || jTextField16.getText().equals("") ||
                  jTextField17.getText().equals("") || jTextField18.getText().equals("")||
                  jTextField19.getText().equals("") || jTextField20.getText().equals("") ||
                  jTextField21.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"INFORMATION ADEQUATE");
               else
                {
              stmt1.executeUpdate("insert into launch1 values ('"+jTextField1.getText()
                                  +"','"+jTextField17.getText()+"','"+jTextField2.getText()
                                  +"','"+jTextField18.getText()+"','"+jTextField3.getText()
                                  +"','"+jTextField4.getText()+"','"+jTextField7.getText()
                                  +"','"+jTextField8.getText()+"','"+jTextField5.getText()
                                  +"','"+jTextField19.getText()+"','"+jTextField11.getText()
                                  +"','"+jTextField12.getText()+"','"+jTextField13.getText()
                                  +"','"+jTextField14.getText()+"','"+jTextField20.getText()
                                  +"','"+jTextField21.getText()+"','"+jTextField15.getText()
                                  +"','"+jTextField16.getText()+"')");
               JOptionPane.showMessageDialog(null,"SAVED SUCCESSFULLY");
		jTextField1.setText("");
         jTextField2.setText("");
         jTextField3.setText("");
         jTextField4.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jTextField7.setText("");
         jTextField8.setText("");
         jTextField9.setText("");
         jTextField10.setText("");
         jTextField11.setText("");
         jTextField12.setText("");
         jTextField13.setText("");
         jTextField14.setText("");
         jTextField15.setText("");
         jTextField16.setText("");
         jTextField17.setText("");
         jTextField18.setText("");
         jTextField19.setText("");
         jTextField20.setText("");
         jTextField21.setText("");
         jButton11.setEnabled(false);
         jButton12.setEnabled(false);
         jButton13.setEnabled(false);
         jButton14.setEnabled(false);
         jButton15.setEnabled(false);
         jButton16.setEnabled(false);
         jButton17.setEnabled(false);
                }
               }

            }

        catch (SQLException sqle)
            {
			      System.err.println(sqle.getMessage());
		        }
            //this.dispose();
       }
      if(ae.getSource() == jButton2)
        {
         jTextField1.setText("");
         jTextField2.setText("");
         jTextField3.setText("");
         jTextField4.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jTextField7.setText("");
         jTextField8.setText("");
         jTextField9.setText("");
         jTextField10.setText("");
         jTextField11.setText("");
         jTextField12.setText("");
         jTextField13.setText("");
         jTextField14.setText("");
         jTextField15.setText("");
         jTextField16.setText("");
         jTextField17.setText("");
         jTextField18.setText("");
         jTextField19.setText("");
         jTextField20.setText("");
         jTextField21.setText("");
         jButton11.setEnabled(false);
         jButton12.setEnabled(false);
         jButton13.setEnabled(false);
         jButton14.setEnabled(false);
         jButton15.setEnabled(false);
         jButton16.setEnabled(false);
         jButton17.setEnabled(false);
         }
      if(ae.getSource() == jButton3)
        {
         this.dispose();
        }
    }
  }


