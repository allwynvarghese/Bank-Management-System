package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChangePin extends JFrame implements ActionListener {

    JTextField nPinText, rpinText;

    JButton changeButton, backButton;

    String pin;
    public ChangePin(String pin){

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
        JLabel info = new JLabel("Please enter your new PIN.");
        info.setForeground(Color.WHITE);
        info.setBounds(200,300,700,35);
        info.setFont(new Font("System", Font.BOLD, 16));
        image.add(info);

        //new PIN label
        JLabel npinLabel = new JLabel("New PIN: ");
        npinLabel.setBounds(180, 350, 150, 25);
        npinLabel.setFont(new Font("System", Font.BOLD, 13));
        npinLabel.setForeground(Color.WHITE);
        image.add(npinLabel);

        //new PIN Text field
        nPinText = new JTextField();
        nPinText.setBounds(330, 350, 170, 25);
        nPinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(nPinText);

        //re-enter new PIN label
        JLabel rpinLabel = new JLabel("Re-enter new PIN: ");
        rpinLabel.setBounds(180, 410, 150, 14);
        rpinLabel.setFont(new Font("System", Font.BOLD, 13));
        rpinLabel.setForeground(Color.WHITE);
        image.add(rpinLabel);

        //Re-enter PIN textbox
        rpinText = new JTextField();
        rpinText.setBounds(330, 400,170,25);
        rpinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(rpinText);

        //Change PIN button
        changeButton = new JButton("Confirm");
        changeButton.setBounds(355, 485, 150, 30);
        changeButton.addActionListener(this);
        image.add(changeButton);

        //back button
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(355, 520, 150, 30);
        image.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == changeButton){
            String nPin = nPinText.getText(), rPin = rpinText.getText();
            if(nPin.equals("") || rPin.equals("")) JOptionPane.showMessageDialog(null, "New PIN and Re-enter fields cannot be blank!");
            else if(!nPin.equals(rPin)) JOptionPane.showMessageDialog(null, "New PIN not matching!");
            else{

                Com conn = new Com();
                String pinUpdateBankQuery = "Update Bank set pinNum = '"+nPin+"' where pinNUm = '"+pin+"'";
                String pinUpdateLoginQuery = "Update LoginData set pinNUm = '"+nPin+"'where pinNUm = '"+pin+"' ";
                String pinUpdateSignUpQuery = "Update SignupThree set pinNum = '"+nPin+"'where pinNum = '"+pin+"' ";

                try {
                    conn.s.executeUpdate(pinUpdateBankQuery);
                    conn.s.executeUpdate(pinUpdateLoginQuery);
                    conn.s.executeUpdate(pinUpdateSignUpQuery);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                    setVisible(false);
                    new Transactions(nPin).setVisible(true);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new ChangePin(""));
    }

}
