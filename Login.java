import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener{
        JButton login, clear , sign;
        JTextField cardField;
        JPasswordField pinField;
        Login(){
            setTitle("SBI Banking system");
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sbi.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(10,15, 150,150);
            setLayout(null);
            add(label);

            JLabel text = new JLabel("Welcome to SBI ATM");
            text.setBounds(200,40, 400, 40);
            text.setFont(new Font("Osward", Font.BOLD, 38) );
            add(text);

            JLabel cardno = new JLabel("Card no:");
            cardno.setBounds(120,150, 150, 30);
            cardno.setFont(new Font("Raleway", Font.BOLD, 28) );
            add(cardno);

            cardField = new JTextField();
            cardField.setBounds(300,150,250,30);
            add(cardField);

            JLabel pin = new JLabel("PIN:");
            pin.setBounds(120,220, 400, 30);
            pin.setFont(new Font("Raleway", Font.BOLD, 28));
            add(pin);

            pinField = new JPasswordField();
            pinField.setBounds(300,220,250,30);
            add(pinField);

            login = new JButton("SIGN IN");
            login.setBounds(200,330,100,30);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);

            clear = new JButton("CLEAR ");
            clear.setBounds(350,330,100,30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
            add(clear);

            sign = new JButton("SIGN UP");
            sign.setBounds(280,380,100,30);
            sign.setBackground(Color.BLACK);
            sign.setForeground(Color.WHITE);
            sign.addActionListener(this);
            add(sign);

            getContentPane().setBackground(Color.white);
            setSize(800,500);
            setLocation(350,200);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == clear){
                cardField.setText("");
                pinField.setText("");
            }else if( ae.getSource() == login){
                Conn conn=new Conn();
                String cardnumber=cardField.getText();
                String pinnumber=pinField.getText();
                String query="select * from login where cardnumber ='"+cardnumber+"' and pin ='"+pinnumber+"'";
                try{
                    ResultSet rs =conn.s.executeQuery(query);
                        if(rs.next()){
                            setVisible(false);
                            new transaction(pinnumber).setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
                        }
                }catch(Exception e){
                        System.out.println(e);
                }
            }else if( ae.getSource() == sign){
               setVisible(false);
               new SignupOne().setVisible(true);
            }

        }
        public static void main(String[] args) {

            new Login();
        }
    }

