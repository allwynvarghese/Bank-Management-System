package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs500, rs1000, rs2000, rs3000, rs5000, rs10000, back;
    String pin;

    public FastCash(String pin){

        this.pin = pin;

        //Frame
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

        //Image
        ImageIcon iI = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = iI.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Text Jlabel
        JLabel text = new JLabel("Please select the fast cash amount");
        text.setBounds(190, 300,700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //Rs 500 button
        rs500 = new JButton("Rs. 500");
        rs500.setBounds(170, 415, 150, 30);
        rs500.addActionListener(this);
        image.add(rs500);

        //Rs 1000 button
        rs1000 = new JButton("Rs. 1000");
        rs1000.setBounds(355, 415, 150, 30);
        rs1000.addActionListener(this);
        image.add(rs1000);

        //Rs 2000 cash button
        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(170, 450, 150, 30);
        rs2000.addActionListener(this);
        image.add(rs2000);

        //Rs 3000 cash button
        rs3000 = new JButton("Rs. 3000");
        rs3000.setBounds(355, 450, 150, 30);
        rs3000.addActionListener(this);
        image.add(rs3000);

        //Rs 5000 cash button
        rs5000 = new JButton("Rs. 5000");
        rs5000.setBounds(170, 485, 150, 30);
        rs5000.addActionListener(this);
        image.add(rs5000);

        //Rs 10000 cash button
        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(355, 485, 150, 30);
        rs10000.addActionListener(this);
        image.add(rs10000);

        //back button
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //clicking on the back button takes you back to transaction page
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin);
        }else{
            int amount = Integer.parseInt(((JButton)ae.getSource()).getText().substring(4)); //getting the button text
            int balance = 0;
            Date date = new Date();
            Com com = new Com();
            String bankQuery = "select * from Bank where pinNUm = '"+pin+"'";
            try {
                ResultSet rs = com.s.executeQuery(bankQuery);
                while(rs.next()) {
                    if (rs.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance > amount){
                    String withdrawalQuery = "insert into Bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')";
                    com.s.executeUpdate(withdrawalQuery);
                    JOptionPane.showMessageDialog(null, "Amount Rs. "+amount+" has been debited from your account.");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "You have insufficient balance of Rs. "+balance+" in you account.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FastCash(""));
    }
}
