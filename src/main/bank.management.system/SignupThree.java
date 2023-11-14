package main.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3;

    JCheckBox c1, c2,c3,c4,c5,c6,c7;

    JButton submit, cancel;

    String formNo;

    SignupThree(String formNo){

        this.formNo = formNo;

        //Frame properties
        setLayout(null);
        setTitle("Sign up - Additional details");
        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        //details label
        JLabel details = new JLabel("Page 3: Account details");
        details.setBounds(290, 50,400,30);
        details.setFont(new Font("Raleway", Font.BOLD, 20));
        add(details);

        //Account type label
        JLabel accType = new JLabel("Account Type :");
        accType.setBounds(100, 165,200,20);
        accType.setFont(new Font("Raleway", Font.BOLD, 17));
        add(accType);

        //Account type radio button
        r1 = new JRadioButton("Savings account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBounds(250, 160, 160, 30);
        add(r1);

        r2 = new JRadioButton("Current account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(420, 160, 160, 30);
        add(r2);

        r3 = new JRadioButton("Deposit account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBounds(590, 160, 160, 30);
        add(r3);

        ButtonGroup bgAccounts = new ButtonGroup();
        bgAccounts.add(r1);
        bgAccounts.add(r2);
        bgAccounts.add(r3);

        //Card number label
        JLabel cardNumLabel = new JLabel("Card Number :");
        cardNumLabel.setBounds(100, 250, 150, 20);
        cardNumLabel.setFont(new Font("Raleway", Font.BOLD, 17));
        add(cardNumLabel);

        //Card number display info
        JLabel cardNumInfo = new JLabel("(This is your card number)");
        cardNumInfo.setBounds(100,270, 200, 12);
        cardNumInfo.setFont(new Font("Raleway", Font.BOLD, 9));
        add(cardNumInfo);

        //Actual card number display
        JLabel cardNumDisp = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardNumDisp.setFont(new Font("Raleway", Font.BOLD, 14));
        cardNumDisp.setBounds(300, 250,300, 20);
        add(cardNumDisp);

        //Card PIN label
        JLabel cardPINLabel = new JLabel("Card PIN :");
        cardPINLabel.setBounds(100,320, 200, 20);
        cardPINLabel.setFont(new Font("Raleway", Font.BOLD, 17));
        add(cardPINLabel);

        //Card PIN display
        JLabel cardPINDisp = new JLabel("XXXX");
        cardPINDisp.setBounds(300,320,300,20);
        cardPINDisp.setFont(new Font("Raleway", Font.BOLD, 14));
        add(cardPINDisp);

        //services required label
        JLabel services = new JLabel("<html><u>Services required</u></html> ");
        services.setBounds(320, 390, 200, 20);
        services.setFont(new Font("Raleway", Font.BOLD, 17));
        add(services);

        //Internet banking checkbox
        c1 = new JCheckBox("Internet Banking");
        c1.setBackground(Color.WHITE);
        c1.setBounds(130, 450, 200, 20);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c1);

        //Mobile banking checkbox
        c2 = new JCheckBox("Mobile Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(550, 450, 200, 20);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c2);

        //SMS & Email checkbox
        c3 = new JCheckBox("SMS & Email alerts");
        c3.setBackground(Color.WHITE);
        c3.setBounds(130, 520, 200, 20);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c3);

        //ATM card checkbox
        c4 = new JCheckBox("ATM");
        c4.setBackground(Color.WHITE);
        c4.setBounds(550, 520, 200, 20);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c4);

        //cheque book checkbox
        c5 = new JCheckBox("Cheque required");
        c5.setBackground(Color.WHITE);
        c5.setBounds(130, 590, 200, 20);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c5);

        //e-statement checkbox
        c6 = new JCheckBox("E-statement required");
        c6.setBackground(Color.WHITE);
        c6.setBounds(550, 590, 200, 20);
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c6);

        //declaration checkbox
        c7 = new JCheckBox("I hearby declare that the above mention information is correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 650, 700, 20);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        add(c7);

        //Submit button
        submit = new JButton("Submit");
        submit.setBounds(500, 720, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.setContentAreaFilled(true);
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.addActionListener(this);
        add(submit);

        //Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 720, 120, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setContentAreaFilled(true);
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.addActionListener(this);
        add(cancel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignupThree(""));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String accountType =    r1.isSelected()?"Savings account":
                                    r2.isSelected()?"Current account":
                                    r3.isSelected()?"Deposit account":"";
            String cardNum = String.valueOf((long)Math.floor(Math.random()*99999999999L) + 5046000000000000L);
            String pinNo = String.valueOf((int)Math.floor(Math.random()*9999)+1);
            String services = "";
            services =  c1.isSelected()?services+" Internet banking":
                        c2.isSelected()?services+" Mobile banking":
                        c3.isSelected()?services+" Alerts":
                        c4.isSelected()?services+" ATM":
                        c5.isSelected()?services+" Cheque book":
                        c6.isSelected()?services+" E-state":
                        services;

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type should be selected");
                }else{
                    Com con = new Com();
                    String query = "insert into SignupThree values('"+formNo+"','"+accountType+"','"+cardNum+"','"+pinNo+"','"+services+"')";
                    String loginQuery = "insert into LoginData values('"+formNo+"','"+cardNum+"','"+pinNo+"')";
                    con.s.executeUpdate(query);
                    con.s.executeUpdate(loginQuery);
                    JOptionPane.showMessageDialog(null, "Card No. :" + cardNum + "\nPIN No. : "+ pinNo);
                    setVisible(false);
                }
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
        }
    }
}
