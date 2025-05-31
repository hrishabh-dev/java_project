import com.sun.source.doctree.SystemPropertyTree;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class loginform {
    JFrame frame = new JFrame("LoginForm");
    JPanel panel=new JPanel();
    JLabel heading = new JLabel("My first form");
    Font font= new Font("",Font.BOLD,30);
    JTextField namTextField;
    JPasswordField passwordField;
    JButton button1,button2;
    JLabel nameLabel;
    JLabel passwLabel;



    public loginform() {
        System.out.println("constructor is working...");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gui();




    }
    public void gui (){
        frame.setLayout(new BorderLayout());
        heading.setBackground(Color.CYAN);
        heading.setForeground(Color.BLUE);
        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);
        frame.add(heading,BorderLayout.NORTH);
        // jpanel working
        panel.setLayout(new GridLayout(3,2));
        nameLabel=new JLabel("Enter name");
        nameLabel.setFont(font);
        namTextField=new JTextField();
        namTextField.setFont(font);
        passwLabel= new JLabel("Enter password");
        passwLabel.setFont(font);
        passwordField=new JPasswordField();
        passwordField.setFont(font);
        button1=new JButton("Submit");
        button2=new JButton("Reset");
        panel.add(nameLabel);
        panel.add(namTextField);
        panel.add(passwLabel);
        panel.add(passwordField);
        panel.add(button1);
        panel.add(button2);
        frame.add(panel,BorderLayout.CENTER);
        //Event Handeling 
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                submitField();
                System.out.println("Form submitted");
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                clearFields();
                System.out.println("Form reset");
            }
            
        });








        
    }
    public void clearFields(){
        namTextField.setText("");
        passwordField.setText("");
    
    }
    public void submitField(){
        namTextField.setText("Submitted");
        passwordField.setText("");
    }

    
    public static void main(String[] args) {
        System.out.println("Testing...");
        new loginform();
        
    }


    
}
