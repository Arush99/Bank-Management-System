import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinnumber;

 MiniStatement(String pinnumber){
     this.pinnumber=pinnumber;
     setTitle("MiniStatement");
     setLayout(null);
     JLabel mini = new JLabel();
     add(mini);

     setSize(400,600);
     setLocation(20,20);
     getContentPane().setBackground(Color.white);
     setVisible(true);

     JLabel bank = new JLabel("SBI Bank");
     bank.setBounds(150,20,100,20);
     add(bank);

     JLabel card = new JLabel();
     card.setBounds(20,80,300,20);
     add(card);

     JLabel balance = new JLabel();
     balance.setBounds(20,400,300,20);
     add(balance);


     try{
        // Build  databasse connection here
         Conn c= new Conn();
         ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "' ");
         while (rs.next()){
             card.setText("card number:" + rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+ rs.getString("cardnumber").substring(12));
         }
     }catch(Exception e){
         System.out.println(e);
     }
     try{
         Conn c= new Conn();
         ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "' ");
         while (rs.next()){
             mini.setText(mini.getText()+ "<html>" + rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
         }}
      catch(Exception e){
         System.out.println(e);
     }
     mini.setBounds(20,140,400,200);

 }
    public static void main(String[] args) {
     new MiniStatement("");

    }

}

