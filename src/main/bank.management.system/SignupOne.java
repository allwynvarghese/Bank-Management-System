package main.bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupOne extends JFrame implements ActionListener {

    JTextField fNameTextField, lNameTextfield, emailTextfield, addrTextfield, countryTextField,
            cityTextfield, stateTextField, pincodeTextField;

    JRadioButton male, female, married, unmarried, others;

    JDateChooser dobChooser;

    JButton nextbtn;

    int randomNumber = getRandomNumber();
    SignupOne(){
        //frame setup
        setLayout(null);
        setTitle("ATM - Sign up");
        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        //Jlabels
        //form number generated randomly
        JLabel formNumber = new JLabel("Form No." + randomNumber);
        formNumber.setBounds(350, 40,400,38);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        add(formNumber);

        //personal details label
        JLabel pdLabel = new JLabel("Page 1: Personal details");
        pdLabel.setBounds(290, 100,400,30);
        pdLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pdLabel);

        //FirstName label
        JLabel fName = new JLabel("First name : ");
        fName.setBounds(100, 160,200,20);
        fName.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fName);

        //Firstname text field
        fNameTextField = new JTextField();
        fNameTextField.setBounds(250,160,500,20);
        fNameTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        fNameTextField.setBorder(new LineBorder(Color.BLACK));
        add(fNameTextField);

        //LastName label
        JLabel lName = new JLabel("Last name : ");
        lName.setBounds(100, 200,200,20);
        lName.setFont(new Font("Raleway", Font.BOLD, 14));
        add(lName);

        //last name text field
        lNameTextfield = new JTextField();
        lNameTextfield.setBounds(250,200,500,20);
        lNameTextfield.setFont(new Font("Raleway",Font.PLAIN, 14));
        lNameTextfield.setBorder(new LineBorder(Color.BLACK));
        add(lNameTextfield);

        //DoB label
        JLabel DoB = new JLabel("Date of birth : ");
        DoB.setBounds(100, 240,200,20);
        DoB.setFont(new Font("Raleway", Font.BOLD, 14));
        add(DoB);

        //DoB calender
        dobChooser = new JDateChooser();
        dobChooser.setBounds(250, 240, 500, 20);
        dobChooser.setForeground(Color.BLACK);
        dobChooser.setFont(new Font("Raleway", Font.PLAIN, 14));
        dobChooser.setBorder(new LineBorder(Color.BLACK));
        dobChooser.setForeground(Color.BLACK);
        add(dobChooser);

        //Gender label
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100, 280,200,20);
        gender.setFont(new Font("Raleway", Font.BOLD, 14));
        add(gender);

        //Gender radio buttons
        male = new JRadioButton("Male");
        male.setBounds(250,280, 120,30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(350, 280, 120,30);
        add(female);

        ButtonGroup genderRB = new ButtonGroup();
        genderRB.add(male);
        genderRB.add(female);

        //Email label
        JLabel email = new JLabel("Email : ");
        email.setBounds(100, 320,200,20);
        email.setFont(new Font("Raleway", Font.BOLD, 14));
        add(email);

        //email text field
        emailTextfield = new JTextField();
        emailTextfield.setBounds(250,320,500,20);
        emailTextfield.setFont(new Font("Raleway",Font.PLAIN, 14));
        emailTextfield.setBorder(new LineBorder(Color.BLACK));
        add(emailTextfield);

        //Marital status label
        JLabel ms = new JLabel("Marital status : ");
        ms.setBounds(100, 360,200,20);
        ms.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms);

        //Marital status radio button
        married = new JRadioButton("Married");
        married.setBounds(250,360,120, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(350,360,120, 30);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(480,360,120, 30);
        add(others);

        ButtonGroup msGroups = new ButtonGroup();
        msGroups.add(married);
        msGroups.add(unmarried);
        msGroups.add(others);

        //Address status label
        JLabel address = new JLabel("Address : ");
        address.setBounds(100, 400,200,20);
        address.setFont(new Font("Raleway", Font.BOLD, 14));
        add(address);

        //last name text field
        addrTextfield = new JTextField();
        addrTextfield.setBounds(250,400,500,20);
        addrTextfield.setFont(new Font("Raleway",Font.PLAIN, 14));
        addrTextfield.setBorder(new LineBorder(Color.BLACK));
        add(addrTextfield);

        //City status label
        JLabel city = new JLabel("City : ");
        city.setBounds(100, 440,200,20);
        city.setFont(new Font("Raleway", Font.BOLD, 14));
        add(city);

        //city text field
        cityTextfield = new JTextField();
        cityTextfield.setBounds(250,440,500,20);
        cityTextfield.setFont(new Font("Raleway",Font.PLAIN, 14));
        cityTextfield.setBorder(new LineBorder(Color.BLACK));
        add(cityTextfield);

        //State label
        JLabel state = new JLabel("State : ");
        state.setBounds(100, 480,200,20);
        state.setFont(new Font("Raleway", Font.BOLD, 14));
        add(state);

        //State text field
        stateTextField = new JTextField();
        stateTextField.setBounds(250,480,500,20);
        stateTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        stateTextField.setBorder(new LineBorder(Color.BLACK));
        add(stateTextField);

        //Country label
        JLabel country = new JLabel("Country : ");
        country.setBounds(100, 520,200,20);
        country.setFont(new Font("Raleway", Font.BOLD, 14));
        add(country);

        //country text field
        countryTextField= new JTextField();
        countryTextField.setBounds(250,520,500,20);
        countryTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        countryTextField.setBorder(new LineBorder(Color.BLACK));
        add(countryTextField);

        //Pincode label
        JLabel pincode = new JLabel("Pin code : ");
        pincode.setBounds(100, 560,200,20);
        pincode.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pincode);

        //Pin code text field
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(250,560,500,20);
        pincodeTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        pincodeTextField.setBorder(new LineBorder(Color.BLACK));
        add(pincodeTextField);

        //Next button
        nextbtn = new JButton("Next");
        nextbtn.setBounds(630, 650, 120, 40);
        nextbtn.setBackground(Color.BLACK);
        nextbtn.setForeground(Color.WHITE);
        nextbtn.setOpaque(true);
        nextbtn.setContentAreaFilled(true);
        nextbtn.setFocusPainted(false);
        nextbtn.setBorder(BorderFactory.createEmptyBorder());
        nextbtn.addActionListener(this);
        add(nextbtn);

        //Clear button - TDB

    }

    //Generates random number from 1 to 9999 for formNumber
    int getRandomNumber(){
        return (int)Math.floor(Math.random() * 9999) + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignupOne signUp = new SignupOne();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = String.valueOf(randomNumber);
        String fName = fNameTextField.getText();
        String lName = lNameTextfield.getText();
        String dob = ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText();
        String gender = male.isSelected()? "Male" : "Female";
        String email = emailTextfield.getText();
        String maritalState = married.isSelected()?"Married":unmarried.isSelected()?"Unmarried":"Other";
        String address = addrTextfield.getText();
        String city = cityTextfield.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        try {
            if(fName.equals("")){
                JOptionPane.showMessageDialog(null, "First Name is required");
            }else {
                Com c = new Com();
                String query = "INSERT INTO Signup values ('"+formNo+"','"+fName+"','"+lName+"','"+dob+"','"+gender+"','"+email+"','"+maritalState+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
