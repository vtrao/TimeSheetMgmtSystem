import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.JFrame;
import java.io.*;

public class CommonDoubleFrame extends JFrame implements ActionListener
  {
  JButton b1;
  static int ix, iy;
  Object s,s2;
  public static String s1,s3;
  private Connection con;
  private ResultSet rs;
  private Statement stmt;
  private ResultSetMetaData rsmd;
  public JTable table;
  String query1;

public CommonDoubleFrame(int x,String construct,String label,String query)
    {
    super(construct);
    query1=query;
    this.setLocation(150,150);
    this.setResizable(false);
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
        b1=new JButton("OK");
        JPanel toppanel=new JPanel(new BorderLayout());
        JLabel x1 = new JLabel(label);

        toppanel.add ( x1 , BorderLayout.SOUTH );
        toppanel.add ( b1 , BorderLayout.CENTER );
        table =new JTable(4,4);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add( toppanel,BorderLayout.NORTH );
        c.add(table,BorderLayout.CENTER);
        c.add(b1,BorderLayout.SOUTH);
        getTable();
        setSize(300,200);
        //show();
        table.addMouseListener(new m());
        b1.addActionListener(this);
        }
  public CommonDoubleFrame(String construct,String label,String query)
    {
    super(construct);
    query1=query;
    this.setLocation(150,150);
    this.setResizable(false);
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
        b1=new JButton("OK");
        JPanel toppanel=new JPanel(new BorderLayout());
        JLabel x1 = new JLabel(label);

        toppanel.add ( x1 , BorderLayout.SOUTH );
        toppanel.add ( b1 , BorderLayout.CENTER );
        table =new JTable(4,4);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add( toppanel,BorderLayout.NORTH );
        c.add(table,BorderLayout.CENTER);
        c.add(b1,BorderLayout.SOUTH);
        getTable();
        setSize(300,200);
        show();
        table.addMouseListener(new m());
        b1.addActionListener(this);
      }
   class m extends MouseAdapter
      {
      public void mouseClicked(MouseEvent me)
        {
        iy=table.getSelectedColumn();
        ix=table.getSelectedRow();
        }
      }
   public void actionPerformed( ActionEvent e)
      {
      if ( e.getSource() == b1 )
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
        rs=stmt.executeQuery(query1);
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
            Container c=getContentPane();
            c.remove(1);
            c.add(scr,BorderLayout.CENTER);
            c.validate();
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
      final CommonDoubleFrame b=new CommonDoubleFrame("","","");
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