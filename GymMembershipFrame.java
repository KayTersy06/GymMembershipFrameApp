package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.membership.Member;

/**
 *
 * @author kayte
 */
public class GymMembershipFrame extends JFrame{
    //panels
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel btnsPnl;
    private JPanel headingClientCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel personalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //combobox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //checkbox
    private JCheckBox personalTrainerChkBx;
    
    //buttongroup
    private ButtonGroup btnGrp;
    
    //textarea
    private JTextArea commentsArea;
    
    //scrollpane
    private JScrollPane scrollableTextArea;
    
    //private button
    private JButton registerBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JButton removeBtn;
    private JButton updateBtn;
    private JButton displayBtn;
    
    //list
    private ArrayList<Member> members;
    
    //construct the gui
    public GymMembershipFrame() {
        setTitle("Gym membership");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //create a list of members
        members = new ArrayList<>();
        
        //create panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        clientPnl = new JPanel(new GridLayout(4,1,1,1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Client details"));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPnl = new JPanel(new GridLayout(2,1,1,1));
        membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Contract options"));
        
        commentsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClientCombinedPnl = new JPanel(new BorderLayout());
        membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        headingLbl = new JLabel("Membership Form");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setForeground(Color.BLUE);
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLbl = new JLabel("Name:         ");
        surnameLbl = new JLabel("Surname:   ");
        idNoLbl = new JLabel("Id no:          ");
        genderLbl = new JLabel("Gender:     ");
        contractTypeLbl = new JLabel("Type of contract: ");
        personalTrainerLbl = new JLabel("Select the checkbox if you need a personal trainer ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);
        
        //create combobox
        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        
        //create radio buttons
        monthToMonthRadBtn = new JRadioButton("Month-to-month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");
        
        //create check box
        personalTrainerChkBx = new JCheckBox();
        
        //create button group
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRadBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);
        
        //create text area
        commentsArea = new JTextArea(20, 40);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Comments"));
        
        scrollableTextArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create button
        registerBtn = new JButton("REGISTER");
        registerBtn.addActionListener(new RegisterBtnListener());
        
        searchBtn = new JButton("SEARCH");
        
        removeBtn = new JButton("REMOVE");
        
        updateBtn = new JButton("UPDATE");
        
        displayBtn = new JButton("DISPLAY ALL");
        
        clearBtn = new JButton("CLEAR");
        clearBtn.addActionListener(new ClearBtnListener());
        
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(new ExitBtnListener());
        
        //add components to panels
        headingPnl.add(headingLbl); //-->first collective panel
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(genderComboBox);
        
        clientPnl.add(namePnl);
        clientPnl.add(surnamePnl);
        clientPnl.add(idNoPnl);
        clientPnl.add(genderPnl);
        
        headingClientCombinedPnl.add(headingPnl, BorderLayout.NORTH);
        headingClientCombinedPnl.add(clientPnl, BorderLayout.CENTER);
  
        contractsPnl.add(contractTypeLbl);
        contractsPnl.add(monthToMonthRadBtn);
        contractsPnl.add(sixMonthsRadBtn);
        contractsPnl.add(annualRadBtn);
        
        personalTrainerOptionPnl.add(personalTrainerLbl);
        personalTrainerOptionPnl.add(personalTrainerChkBx);
        
        membershipPnl.add(contractsPnl);
        membershipPnl.add(personalTrainerOptionPnl);
        
        commentsPnl.add(scrollableTextArea);
        
        membershipCommentsCombinedPnl.add(membershipPnl, BorderLayout.NORTH);
        membershipCommentsCombinedPnl.add(commentsPnl, BorderLayout.CENTER);
        
        btnsPnl.add(registerBtn);
        btnsPnl.add(searchBtn);
        btnsPnl.add(updateBtn);
        btnsPnl.add(removeBtn);
        btnsPnl.add(displayBtn);
        btnsPnl.add(clearBtn);
        btnsPnl.add(exitBtn);
        
        mainPnl.add(headingClientCombinedPnl, BorderLayout.NORTH);
        mainPnl.add(membershipCommentsCombinedPnl, BorderLayout.CENTER);
        mainPnl.add(btnsPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        pack();
        setVisible(true);
    }
    
    
    private class RegisterBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //read data
            String name = nameTxtFld.getText();
            String surname = surnameTxtFld.getText();
            String idNo = idNoTxtFld.getText();
            String gender = (String)genderComboBox.getSelectedItem();
            Boolean isPersonalTrainerSelected = personalTrainerChkBx.isSelected();
            String contractType = "Month-to-month";
            
            if(sixMonthsRadBtn.isSelected()){
                contractType = "Six months";
            }
            else{
                if(annualRadBtn.isSelected())
                {
                    contractType = "Annual";
                }
            }
            
            //create a member
            Member member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerSelected);
            
            //add the member to the list
            members.add(member);
            
            //add a confirmation message to the text area
            commentsArea.setText("The member has been successfully added");
        }
        
    }
    
    private class ClearBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //clear the fields
            nameTxtFld.setText("");
            surnameTxtFld.setText("");
            idNoTxtFld.setText("");
            personalTrainerChkBx.setSelected(false);
            btnGrp.clearSelection();
            commentsArea.setText("");
            
            //set focus back to the name text field
            nameTxtFld.setFocusable(true);
        }
        
    }
    
    private class ExitBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
        //exit
        
    }
}
