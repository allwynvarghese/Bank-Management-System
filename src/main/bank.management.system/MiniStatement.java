package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    int balance = 0;

    JButton doneButton;

    public MiniStatement(String pin){
        this.pin = pin;

        //frame setup
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        setTitle("Mini statement");
        setVisible(true);

        //Display bank's name
        JLabel bName = new JLabel("<html><u>Indian Bank</u></html>");
        bName.setBounds(150,20,100,20);
        bName.setFont(new Font("System", Font.BOLD, 16));
        add(bName);

        //getting dynamic data from the DB
        Com conn = new Com();

        //getting the card number
        String cardNumQuery = "select * from LoginData where pinNUm = '"+pin+"'";
        String cardN = "";
        try {
            ResultSet rs = conn.s.executeQuery(cardNumQuery);
            if(rs.next()){
                cardN = "XXXX-XXXX-XXXX-" + rs.getString("cardNum").substring(11,15);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        //Display card Number
        JLabel cardNum = new JLabel("Your card num: " + cardN);
        cardNum.setBounds(30,80, 300, 16);
        cardNum.setFont(new Font("System", Font.PLAIN, 14));
        add(cardNum);

        //Mini statement display
        JLabel mini = new JLabel();
        mini.setFont(new Font("System", Font.PLAIN, 14));
        mini.setBounds(20,150, 400, 300);
        add(mini);

        //Getting the mini statement
        String miniStQuery = "select * from Bank where pinNUm = '"+pin+"'";
        try {
            ResultSet rs = conn.s.executeQuery(miniStQuery);
            StringBuilder miniText = new StringBuilder("<html>"); // Start with HTML tag
            while (rs.next()) {
                miniText.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount"))
                        .append("<br><br>");
            }
            miniText.append("</html>"); // End with HTML tag
            mini.setText(miniText.toString());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        //Balance label
        JLabel bal = new JLabel("Your total balance is Rs. " + balance);
        bal.setFont(new Font("System", Font.PLAIN, 14));
        bal.setBounds(30, 500, 300, 16);
        add(bal);

        //Done button
        //Login button
        doneButton = new JButton("Done");
        doneButton.setBounds(120, 530, 130, 30);
        doneButton.setBackground(Color.BLACK);
        doneButton.setForeground(Color.WHITE);
        doneButton.setOpaque(true);
        doneButton.setContentAreaFilled(true);
        doneButton.setFocusPainted(false);
        doneButton.setBorder(BorderFactory.createEmptyBorder());
        doneButton.addActionListener(this);
        add(doneButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == doneButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new MiniStatement(""));
    }

}
