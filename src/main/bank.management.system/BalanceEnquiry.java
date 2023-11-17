package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;

    JButton backButton;

    int balance = 0;

    public BalanceEnquiry(String pin){
        this.pin = pin;

        //Frame setup
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

        //Balance enquiry page information label
        JLabel info = new JLabel("Your current balance is as below.");
        info.setBounds(200, 310,300,25);
        info.setFont(new Font("System", Font.BOLD, 16));
        info.setForeground(Color.WHITE);
        image.add(info);

        //Getting balance amount from the DB
        String bankQuery = "select * from Bank where pinNUm = '"+pin+"'";
        Com conn = new Com();
        try {
            ResultSet rs = conn.s.executeQuery(bankQuery);
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        //Balance display label
        JLabel balanceLabel = new JLabel("Rs. " + balance);
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setBounds(250, 400, 170, 25);
        balanceLabel.setFont(new Font("System", Font.BOLD, 16));
        image.add(balanceLabel);

        //Back button
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(355, 520, 150, 30);
        image.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backButton){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new BalanceEnquiry(""));
    }

}
