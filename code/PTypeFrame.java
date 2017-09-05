import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;


public class PTypeFrame extends JFrame implements ActionListener
  {
  Container c;
  static int ix, iy;
  Object s,s2;
  public static String s1,s3;
  private Connection con;
  private ResultSet rs;
  private Statement stmt,stmt2;
  private ResultSetMetaData rsmd;
  public JTable table;
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JButton jButton3 = new JButton();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
  JLabel jLabel3 = new JLabel("           Project Type             ");
  JLabel jLabel4 = new JLabel("             Project Description");
  JLabel jLabel5 = new JLabel("                       ");
  JLabel jLabel6 = new JLabel("                       ");
  JLabel jLabel7= new JLabel("               Project Description");
  JTextField jTextField3=new JTextField();
  JTextField jTextField4=new JTextField();

  public PTypeFrame(int x)
    {
    super("Project Type");
    this.setLocation(150,150);
    this.setResizable(false);

    jLabel1.setText("    Project Type                                ");
    jLabel1.setBounds(new Rectangle(0, 0, 90, 22));
    jButton5.setText("Ok");
    jButton5.setBounds(new Rectangle(338, 24, 73, 24));
    jButton4.setText("Cancel");
    jButton4.setBounds(new Rectangle(195, 24, 73, 24));
    jButton3.setText("Save");
    jButton3.setBounds(new Rectangle(58, 24, 71, 23));
    jButton3.setToolTipText(" New Project Types can be added using these Fields");

    jPanel1.setLayout(new FlowLayout(0,30,5));
    jPanel1.add(jLabel1);
    jPanel1.add(jLabel7);

    jPanel2.setLayout(new GridLayout(3,3));
    jPanel2.add(jLabel3);
    jPanel2.add(jLabel4);
    jPanel2.add(jLabel5);
    jPanel2.add(jTextField3);
    jPanel2.add(jTextField4);
    jPanel2.add(jLabel6);
    jPanel2.add(jButton3);
    jPanel2.add(jButton4);
    jPanel2.add(jButton5);
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
    table =new JTable(4,4);
    c=getContentPane();
    c.setLayout(new BorderLayout());
    c.add( jPanel1,BorderLayout.NORTH );
    c.add( table,BorderLayout.CENTER);
    c.add( jPanel2,BorderLayout.SOUTH);
    setSize(500,400);
    //show();
    jButton3.addActionListener(this);
    jButton4.addActionListener(this);
    jButton5.addActionListener(this);
    table.addMouseListener(new m());
    getTable();
    }
  public PTypeFrame()
    {
    super("Project Type");
    this.setLocation(150,150);
    this.setResizable(false);


    jLabel1.setText("    Project Type                   ");
    jLabel1.setBounds(new Rectangle(0, 0, 90, 22));
     jButton5.setText("Ok");
    jButton5.setBounds(new Rectangle(338, 24, 73, 24));
    jButton4.setText("Cancel");
    jButton4.setBounds(new Rectangle(195, 24, 73, 24));
    jButton3.setText("Save");
    jButton3.setBounds(new Rectangle(58, 24, 71, 23));
    jButton3.setToolTipText(" New Project Types can be added using these Fields");

    jPanel1.setLayout(new FlowLayout(0,30,5));
    jPanel1.add(jLabel1);
    jPanel1.add(jLabel7);

    jPanel2.setLayout(new GridLayout(3,3));
    jPanel2.add(jLabel3);
    jPanel2.add(jLabel4);
    jPanel2.add(jLabel5);
    jPanel2.add(jTextField3);
    jPanel2.add(jTextField4);
    jPanel2.add(jLabel6);
    jPanel2.add(jButton3);
    jPanel2.add(jButton4);
    jPanel2.add(jButton5);
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
    table =new JTable(4,4);
    c=getContentPane();
    c.setLayout(new BorderLayout());
    c.add( jPanel1,BorderLayout.NORTH );
    c.add( table,BorderLayout.CENTER);
    c.add( jPanel2,BorderLayout.SOUTH);
    setSize(500,400);
    getTable();
    show();
    jButton3.addActionListener(this);
    jButton4.addActionListener(this);
    jButton5.addActionListener(this);
    table.addMouseListener(new m());
    }
    class m extends MouseAdapter
      {
      public void mouseClicked(MouseEvent me)
        {
        iy=table.getSelectedColumn();
        ix=table.getSelectedRow();
        }
      }
  public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()== jButton3)
        {
        try
          {
          if( jTextField3.getText().equals("") || jTextField4.getText().equals(""))
            JOptionPane.showMessageDialog(null,"INFORMATION INADEQUATE");
          else
            {
            stmt2=con.createStatement();
            stmt2.executeUpdate("insert into projecttype ( projecttype , projectdesc ) values "+
                            " ( '"+jTextField3.getText()+"' "
                            +" ,'"+jTextField4.getText()+"')" );
            JOptionPane.showMessageDialog(null,"SAVED SUCESSFULLY!");
            }
          }
        catch (SQLException sqle)
           {
		  	   System.err.println(sqle.getMessage());
		       }
        jTextField3.setText("");
        jTextField4.setText("");
        }
       
      if(ae.getSource()== jButton4)
        {
        jTextField3.setText("");
        jTextField4.setText("");
        }
      if(ae.getSource()== jButton5)
        {
        this.dispose();
        }
     }
     public String rety()
      {
      int e=iy;
      if(iy==0)
        e=iy+1;
      else
        e=iy;
      s2=table.getValueAt(ix,e);
      s3=""+s2;
      return s3;
      }
  public String ret()
      {
      int e=iy;
      if(iy == 1)
         e=iy-1;
      else
        e=iy;
      s=table.getValueAt(ix,e);
      s1=""+s;
      return s1;
      }
   private void getTable()
      {
      try
        {
        stmt=con.createStatement();
        rs=stmt.executeQuery( "select  * from projecttype");
        displayResultSet(rs);
        }
      catch (SQLException sqle)
        {
		  	System.err.println(sqle.getMessage());
		    }
      }
    private void displayResultSet(ResultSet rs1) throws SQLException
      {
        boolean morerec=rs1.next();
        if(!morerec)
          {
          JOptionPane.showMessageDialog(this,"Result set Contain No Records");
          return;
          }
        Vector ch=new Vector();
        Vector rows=new Vector();
        try
          {
            ResultSetMetaData rsmd1=rs1.getMetaData();
            for(int i=1;i<=rsmd1.getColumnCount();++i)
              ch.addElement(rsmd1.getColumnName(i));
            do
              {
              rows.addElement(getNextRow(rs1,rsmd1));
              }while(rs.next());
            table=new JTable(rows,ch);
            JScrollPane scr=new JScrollPane(table);
            Container c1=getContentPane();
            c1.remove(1);
            c1.add(scr,BorderLayout.CENTER);
            c1.validate();
          }
        catch (SQLException sqle)
          {
			    System.err.println(sqle.getMessage());
		      }
      }
  private Vector getNextRow(ResultSet rs2,ResultSetMetaData rsmd2) throws SQLException
    {
    Vector currentrow=new Vector();
    for(int i=1;i<= rsmd2.getColumnCount();++i)
      {
      switch(rsmd2.getColumnType(i))
        {
        case Types.VARCHAR :
        case Types.CHAR :
        case Types.LONGVARCHAR :
                                  currentrow.addElement(rs2.getString(i));
                                    break;
        case Types.DATE :
        case Types.TIME :
                                  currentrow.addElement(rs2.getDate(i));
                                   currentrow.addElement(rs2.getTime(i));
                                   break;
        case Types.INTEGER :
                                  currentrow.addElement(new Long(rs2.getInt(i)));
                                  break;
        default :
                  System.out.println("type was"+rsmd2.getColumnTypeName(i));
         }
      }
       return currentrow;
    }
   public void shutDown()
    {
    try
      {
      con.close();
      }
    catch (SQLException sqle)
      {
			System.err.println(sqle.getMessage());
		  }
    }
   public static void main(String args[])
      {
      final PTypeFrame b=new PTypeFrame();
       b.addWindowListener(new WindowAdapter()
                                  {
                                  public void windowClosing(WindowEvent e)
                                          {
                                          b.shutDown();
                                          System.exit(0);
                                          }
                                  }
                          );
      }
}

