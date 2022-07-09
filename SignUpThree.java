import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton Submit, Cancel;
    String formno;

    SignUpThree(String formno) {

        this.formno = formno;
        setLayout(null);
        setSize(400, 350);

        /* For Writing Heading */

        JLabel l1 = new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Cursive", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Cursive", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        /* Coding For Radio buttons */
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recuuring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        add(r4);
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);


        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(100, 300, 200, 40);
        add(cardNumber);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3456");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 330, 400, 40);
        add(cardDetails);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Cursive", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);
        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 400, 300, 30);
        add(pinDetails);

        JLabel service = new JLabel("Services Required: ");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 400, 30);
        add(service);

        c1 = new JCheckBox("ATM Card");
        //c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox(" Internet Banking ");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);


        c4 = new JCheckBox("Mail & SMS Alert !");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I here by declare that all above statements are correct ");
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        Submit = new JButton("Submit");
        Submit.setBackground(Color.gray);
        Submit.setFont(new Font("Raleway", Font.BOLD, 12));
        Submit.setBounds(250, 720, 100, 30);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.gray);
        Cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        Cancel.setBounds(420, 720, 100, 30);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);


    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account ";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }
                Random random = new Random();

                String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040223300000000L);
                String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
                String facility = " ";
                if (c1.isSelected()) {
                    facility += " ATM Card";
                } else if (c2.isSelected()) {
                    facility += " Internet Banking";
                } else if (c3.isSelected()) {
                    facility += " Mobile Banking";
                } else if (c4.isSelected()) {
                    facility += " Mail and SMS alert";
                } else if (c5.isSelected()) {
                    facility += " Cheque Book";
                } else if (c6.isSelected()) {
                    facility += " E-Statement";
                }

                try {
                    if (accountType.equals("")) {
                        JOptionPane.showMessageDialog(null, "Account Type is required");
                    } /* Here Data base connection is required to setUp  */
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2= "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);


                    JOptionPane.showMessageDialog(null,"Card Number:" +cardnumber+ "\n Pin:" +pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (ae.getSource() == Cancel) {
                    setVisible(false);
                    new Login().setVisible(true);
            }


        }
    public static void main(String args[])
    {
        new SignUpThree("");

    }
    }



/*Please go to line no.171*/
