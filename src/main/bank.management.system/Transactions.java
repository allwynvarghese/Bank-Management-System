package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStat, pinChange, fastCash, balanceEnq, exit;
    String pin;

    public Transactions(String pin){

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
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(210, 300,700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //Deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        //withdrawal button
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        //Fast cash button
        fastCash = new JButton("Fast cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        //Mini statement button
        miniStat = new JButton("mini statement");
        miniStat.setBounds(355, 450, 150, 30);
        miniStat.addActionListener(this);
        image.add(miniStat);

        //pin change button
        pinChange = new JButton("Change PIN");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        //Balance Enquiry button
        balanceEnq = new JButton("Check balance");
        balanceEnq.setBounds(355, 485, 150, 30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        //exit button
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == exit) System.exit(0);
        else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if (ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Transactions(""));
    }
}
