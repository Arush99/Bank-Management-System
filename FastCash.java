import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JButton hund, fhund, th, twoth, fth, tth, back;
    String pinnumber;

    FastCash(String pinnumber) {

            this.pinnumber = pinnumber;
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 900, 900);
            add(image);

            JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
            text.setBounds(210, 300, 700, 35);
            text.setForeground(Color.white);
            text.setFont(new Font("System", Font.BOLD, 16));
            image.add(text);

            hund = new JButton("Rs 100");
            hund.setBounds(170, 415, 150, 30);
            hund.addActionListener(this);
            image.add(hund);

            fhund = new JButton("Rs 500");
            fhund.setBounds(355, 415, 150, 30);
            fhund.addActionListener(this);
            image.add(fhund);

            th = new JButton("Rs 1000");
            th.setBounds(170, 450, 150, 30);
            th.addActionListener(this);
            image.add(th);

            twoth = new JButton("Rs 2000");
            twoth.setBounds(355, 450, 150, 30);
            twoth.addActionListener(this);
            image.add(twoth);

            fth = new JButton("Rs 5000");
            fth.setBounds(170, 485, 150, 30);
            fth.addActionListener(this);
            image.add(fth);


            tth = new JButton("Rs 10000");
            tth.setBounds(355, 485, 150, 30);
            tth.addActionListener(this);
            image.add(tth);

            back = new JButton("BACK");
            back.setBounds(355, 520, 150, 30);
            back.addActionListener(this);
            image.add(back);

            setSize(900, 900);
            setLocation(300, 0);
            setUndecorated(true);
            setVisible(true);

        }

        public void actionPerformed (ActionEvent ae){
            if (ae.getSource() == back) {
                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            } else {
                String amount = ((JButton)ae.getSource()).getText().substring(3);
                Conn c = new Conn();

                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance=0;
                    while(rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs:" + amount + " Debited Successfully");


                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }


        public static void main (String args[]){
            new FastCash("");
        }

}
