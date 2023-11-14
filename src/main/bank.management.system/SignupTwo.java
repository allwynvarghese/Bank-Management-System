package main.bank.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;

    JRadioButton ySenior, nSenior, yExisting, nExisting;

    JComboBox <String> religionSel, categorySel, incomeSel, qualificationSel, occupationSel;

    JButton nextbtn;

    String formNo;

    SignupTwo(String formNo){
        this.formNo = formNo;
        //frame setup
        setLayout(null);
        setTitle("Sign up - Additional Details");
        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        //personal details label
        JLabel pdLabel = new JLabel("Page 2: Additional details");
        pdLabel.setBounds(290, 100,400,30);
        pdLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pdLabel);

        //religion label
        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(100, 160,200,20);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        add(religion);

        //religion combo box
        String[] religionVals = {"Others", "Hindu", "Islam", "Christianity", "Jain", "Sikh"};
        religionSel = new JComboBox<>(religionVals);
        religionSel.setBounds(250,160,500,20);
        religionSel.setFont(new Font("Raleway",Font.PLAIN, 14));
        religionSel.setBorder(new LineBorder(Color.BLACK));
        religionSel.setBackground(Color.WHITE);
        add(religionSel);

        //Category label
        JLabel category = new JLabel("Category : ");
        category.setBounds(100, 200,200,20);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        add(category);

        //category combo box
        String[] categoriesVal = {"General", "SC/ST", "OBC"};
        categorySel = new JComboBox<>(categoriesVal);
        categorySel.setBounds(250,200,500,20);
        categorySel.setFont(new Font("Raleway",Font.PLAIN, 14));
        categorySel.setBorder(new LineBorder(Color.BLACK));
        categorySel.setBackground(Color.WHITE);
        add(categorySel);

        //Income label
        JLabel income = new JLabel("Income : ");
        income.setBounds(100, 240,200,20);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        add(income);

        //Income Combo box
        String[] incomevals = {"<1,50,000", "<2,50,000", "<5,00,000", ">=5,00,000"};
        incomeSel = new JComboBox<>(incomevals);
        incomeSel.setBounds(250, 240, 500, 20);
        incomeSel.setFont(new Font("Raleway", Font.PLAIN, 14));
        incomeSel.setBorder(new LineBorder(Color.BLACK));
        incomeSel.setBackground(Color.WHITE);
        add(incomeSel);

        //Educational label
        JLabel educational = new JLabel("Educational");
        educational.setBounds(100, 300,200,20);
        educational.setFont(new Font("Raleway", Font.BOLD, 14));
        add(educational);

        //Qualification label
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setBounds(100, 320,200,20);
        qualification.setFont(new Font("Raleway", Font.BOLD, 14));
        add(qualification);

        //email text field
        String[] qualificationVals = {"SSC/HSC", "Diploma", "Graduate", "Post-Graduate", "PhD"};
        qualificationSel = new JComboBox<>(qualificationVals);
        qualificationSel.setBounds(250,320,500,20);
        qualificationSel.setFont(new Font("Raleway",Font.PLAIN, 14));
        qualificationSel.setBorder(new LineBorder(Color.BLACK));
        qualificationSel.setBackground(Color.WHITE);
        add(qualificationSel);

        //Occupation status label
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(100, 360,200,20);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        add(occupation);

        //Occupation dropdown
        String[] occupationVals = {"Salaried", "Self-employeed", "Unemployed", "Retired"};
        occupationSel = new JComboBox<>(occupationVals);
        occupationSel.setBounds(250,360,120, 30);
        occupationSel.setFont(new Font("Raleway",Font.PLAIN, 14));
        occupationSel.setBorder(new LineBorder(Color.BLACK));
        occupationSel.setBackground(Color.WHITE);
        add(occupationSel);

        //PAN label
        JLabel pan = new JLabel("PAN No. : ");
        pan.setBounds(100, 400,200,20);
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pan);

        //PAN text field
        panTextField = new JTextField();
        panTextField.setBounds(250,400,500,20);
        panTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        panTextField.setBorder(new LineBorder(Color.BLACK));
        add(panTextField);

        //Aadhar status label
        JLabel aadhar = new JLabel("Aadhar : ");
        aadhar.setBounds(100, 440,200,20);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadhar);

        //aadhar text field
        aadharTextField = new JTextField();
        aadharTextField.setBounds(250,440,500,20);
        aadharTextField.setFont(new Font("Raleway",Font.PLAIN, 14));
        aadharTextField.setBorder(new LineBorder(Color.BLACK));
        add(aadharTextField);

        //Senior Citizen label
        JLabel senior = new JLabel("Senior Citizen : ");
        senior.setBounds(100, 480,200,20);
        senior.setFont(new Font("Raleway", Font.BOLD, 14));
        add(senior);

        //Senior citizen selection radio button
        ySenior = new JRadioButton("Yes");
        ySenior.setBounds(250,480,120,30);
        ySenior.setFont(new Font("Raleway",Font.PLAIN, 14));
        add(ySenior);

        nSenior = new JRadioButton("No");
        nSenior.setBounds(350,480,120,30);
        nSenior.setFont(new Font("Raleway",Font.PLAIN, 14));
        add(nSenior);

        ButtonGroup seniorGrp = new ButtonGroup();
        seniorGrp.add(ySenior);
        seniorGrp.add(nSenior);

        //Existing account label
        JLabel existingAccount = new JLabel("Existing Account : ");
        existingAccount.setBounds(100, 520,200,20);
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 14));
        add(existingAccount);

        //Existing account selection
        yExisting= new JRadioButton("Yes");
        yExisting.setBounds(250,520,120,30);
        yExisting.setFont(new Font("Raleway",Font.PLAIN, 14));
        add(yExisting);

        nExisting= new JRadioButton("No");
        nExisting.setBounds(350,520,120,30);
        nExisting.setFont(new Font("Raleway",Font.PLAIN, 14));
        add(nExisting);

        ButtonGroup existingAccGrp = new ButtonGroup();
        existingAccGrp.add(yExisting);
        existingAccGrp.add(nExisting);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String sReligion = (String)religionSel.getSelectedItem();
        String sCategory = String.valueOf(categorySel.getSelectedItem());
        String sIncome = String.valueOf(incomeSel.getSelectedItem());
        String sQualification = String.valueOf(qualificationSel.getSelectedItem());
        String sOccupation = String.valueOf(occupationSel.getSelectedItem());
        String sPan = panTextField.getText();
        String sAadhar = aadharTextField.getText();
        String isSenior = (ySenior.isSelected())?"Yes":"No";
        String hasExistingAcc = (yExisting.isSelected())?"Yes":"No";

        try {
            if(panTextField.getText().equals("") && aadharTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "PAN no. and Aadhar No. are required!");
            }else {
                Com c = new Com();
                String query = "INSERT INTO SignupTwo values ('"+formNo+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sQualification+"','"+sOccupation+"','"+sPan+"','"+sAadhar+"','"+isSenior+"','"+hasExistingAcc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formNo).setVisible(true);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignupTwo(""));
    }
}
