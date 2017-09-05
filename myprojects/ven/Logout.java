 package ven;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import java.awt.*;
import com.sun.java.swing.JFrame;
import java.io.*;

public class Logout extends JFrame implements ActionListener{
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JLabel jLabel1 = new JLabel();


  public Logout()
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    this.setSize(285,155);
    this.setLocation(350,250);
    this.setTitle("Log Out");
    jButton1.setText("Ok");
    jButton1.setBounds(new Rectangle(26, 70, 98, 37));
    jButton2.setText("Cancel");
    jButton2.setBounds(new Rectangle(147, 69, 105, 38));
    jLabel1.setText("Do U Want To LogOut ?");
    jLabel1.setBounds(new Rectangle(13, 0, 233, 52));
    this.getContentPane().setLayout(null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(jLabel1, null);
    jButton1.addActionListener(this);
    jButton2.addActionListener(this);
    show();
  }

  public void actionPerformed(ActionEvent e)
    {
    if(e.getSource() == jButton1)
      {
      System.exit(0);
      }
    if(e.getSource() == jButton2)
      {
      this.dispose();
      }
    }
}

