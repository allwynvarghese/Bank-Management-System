package main.bank.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        //image icon setup
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon Ii = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = Ii.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(i2);
        JLabel label = new JLabel(ic);
        label.setBounds(70,10,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);

        //Welcome label
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 50);
        text.setFont(new Font("Osward", Font.BOLD,38));
        add(text);

        //Card number JLabel
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(150, 120, 400, 50);
        cardNo.setFont(new Font("Raleway", Font.BOLD,25));
        add(cardNo);

        //Text field for card number
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 120, 300,50);
        cardTextField.setBorder(new LineBorder(Color.BLACK));
        add(cardTextField);

        //PIN JLabel
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(150, 180, 400, 50);
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        add(pin);

        //Text field for pin number
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 180, 300,50);
        pinTextField.setBorder(new LineBorder(Color.BLACK));
        add(pinTextField);

        //Login button
        login = new JButton("Login");
        login.setBounds(300, 250, 120, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setContentAreaFilled(true);
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        add(login);

        //Login button
        clear = new JButton("Clear");
        clear.setBounds(480, 250, 120, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setContentAreaFilled(true);
        clear.setFocusPainted(false);
        clear.setBorder(BorderFactory.createEmptyBorder());
        clear.addActionListener(this);
        add(clear);

        //Login button
        signup = new JButton("Sign Up");
        signup.setBounds(300, 300, 300, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setOpaque(true);
        signup.setContentAreaFilled(true);
        signup.setFocusPainted(false);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        add(signup);

        //Frame setup
        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){

        }else if(ae.getSource() == signup){

        }
        setVisible(false);
        new SignupOne().setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
