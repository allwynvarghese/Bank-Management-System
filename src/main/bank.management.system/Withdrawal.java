package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField withdrawalText;

    JButton withDrButton, backButton;

    String pin;
    public Withdrawal(String pin){

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

        //Enter amount label
        JLabel info = new JLabel("Please enter your withdrawal amount.");
        info.setForeground(Color.WHITE);
        info.setBounds(200,300,700,35);
        info.setFont(new Font("System", Font.BOLD, 16));
        image.add(info);

        //Deposit Text field
        withdrawalText = new JTextField();
        withdrawalText.setBounds(210, 350, 258, 25);
        withdrawalText.setFont(new Font("System", Font.BOLD, 16));
        image.add(withdrawalText);

        //Deposit button
        withDrButton = new JButton("Submit");
        withDrButton.setBounds(355, 485, 150, 30);
        withDrButton.addActionListener(this);
        image.add(withDrButton);

        //back button
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(355, 520, 150, 30);
        image.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withDrButton){
            String withDrAmt = withdrawalText.getText();
            Date date = new Date();

            if(!(withdrawalText.getText().equals(""))){

                try {
                    Com con = new Com();
                    String query = "insert into Bank values ('"+pin+"','"+date+"','withdrawal', '"+withDrAmt+"') ";

                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Amount Rs. "+ withDrAmt + " deposited successfully!");
                    setVisible(false);
                    new Transactions(pin);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Please enter a valid amount to withdraw.");
            }
        }else if(e.getSource() == backButton){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Withdrawal(""));
    }

}
