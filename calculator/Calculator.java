package calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
public class Calculator {

    int boardh=360;
    int boardw=540;


    Color customgray=new Color(212,212,210);
    Color customdgray=new Color(80,80,80);
    Color customBlack=new Color(0,0,0);
    Color customOrange=new Color(255,149,0);

    String[] buttonvalues={
        "AC","+/-","%","/",
        "7","8","9","x",
        "4","5","6","-",
        "1","2","3","+",
        "0",".","√","="
                
    };

    String [] rightSymbols={"/","x","-","+","="};
    String [] topSymbols={"AC","+/-","%"};
    


    JFrame frame= new JFrame("Calculator");
    JLabel displayLabel=new JLabel();
    JPanel displayPanel=new JPanel();
    JPanel buttonsPanel=new JPanel();
    //A-B , A+B , A*B , A/B
    String A="0";
    String operator=null;
    String B=null;
    

    @SuppressWarnings("Convert2Lambda")
    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardh,boardw);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel,BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);
        for (int i=0;i<buttonvalues.length;i++){
            JButton button=new JButton();
            String buttonValue=buttonvalues[i];
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonValue);
            if (Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(customgray);
                button.setForeground(customBlack);
                
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(customOrange);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(customdgray);
                button.setForeground(Color.white);
            }
            buttonsPanel.add(button);
            button.addActionListener(new ActionListener() {
                public  void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue=button.getText();
                    if(Arrays.asList(topSymbols).contains(buttonValue)){
                            if (buttonValue=="AC"){
                                clearAll();
                                displayLabel.setText("0");


                            }
                        }
                    if ("0123456789".contains(buttonValue)){
            
                        if (displayLabel.getText()=="0"){
                            displayLabel.setText(buttonValue);

                        }
                        else{
                        displayLabel.setText(displayLabel.getText()+buttonValue);
                        }
                    }
                    if (Arrays.asList(rightSymbols).contains(buttonValue)){
                        displayLabel.setText(displayLabel.getText()+buttonValue);
                    }

                }
                
            });


            
        }



        
    }
    void clearAll(){
        A="0";
        operator=null;
        B=null;

    }

    public static void main(String[] args) {
        new Calculator();
    }
    
}
