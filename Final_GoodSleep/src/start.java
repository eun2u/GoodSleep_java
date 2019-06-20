import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;

public class start implements ActionListener {
   private main nmain;
   JFrame iFrame;
   JPanel iPaneLbl, temp, pane1;
   JButton login, newlogin;
   JLabel iName;
   JLabel loginname;
   JTextField text1;
   String idvalue ;
   
   JScrollPane scrollPane;
   BufferedImage img = null;

   public start() {

      iFrame = new JFrame("Good Sleep!!!");
      iFrame.setLayout(null);
      iFrame.setBounds(40, 40, 400, 300);
      iFrame.setResizable(false);

      iPaneLbl = new JPanel(null);
      iPaneLbl.setBounds(0, 0, 400, 60);
      iPaneLbl.setBackground(Color.black);
      iName = new JLabel("Good Sleep program!");
      iName.setBounds(95, 5, 400, 50);
      iName.setForeground(Color.white);
      iName.setFont(new Font("Helvitica", Font.BOLD, 20));
      iPaneLbl.add(iName);
      iFrame.add(iPaneLbl);
      //iFrame.setVisible(true);
      

      pane1 = new JPanel(null);
      pane1.setBounds(0,0,400,500);
      //pane1.setBackground(Color.yellow);

      login = new JButton("login");
      login.setBounds(140,170,100,25);
      login.addActionListener(this);
      //iFrame.add(login);
      

      newlogin = new JButton("가입하기");
      newlogin.setBounds(140,200,100,25);
      newlogin.addActionListener(this);
      //iFrame.add(newlogin);
      

      text1 = new JTextField();
      text1.setBounds(140,140,100,20);
      

      loginname = new JLabel("ID :");
      loginname.setBounds(110,140,70,20);
      
      
      //setContentPane(scrollPane);
      //iFrame.add(background);
      
      pane1.add(login);
      pane1.add(newlogin);
      pane1.add(text1);
      pane1.add(loginname);
      
      iFrame.add(pane1);
      iFrame.setVisible(true);
      
      

   }

   public static void main(String[] args) {
      //start startmenu = new start();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if(e.getSource()==login)
      {
         idvalue = text1.getText();
         idvalue = idvalue+".txt";
         //System.out.println(idvalue);
         File inputFile = new File(idvalue);
         if(inputFile.isFile())
         {
            //JOptionPane.showMessageDialog(null, "존재");
            //dispose();
            nmain.showSecondTest();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "해당 아이디가\n존재하지 않습니다.","오류 메세지",
                  JOptionPane.ERROR_MESSAGE);
         }

      }
      else if(e.getSource()==newlogin)
      {
         System.out.println("click newlogin");
         new makeNew();

      }

   }

   public void setMain(main nmain) {
      // TODO Auto-generated method stub
      this.nmain = nmain;

   }
   public String getFile()
   {
      return idvalue;
   }

}