import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class tictac {
    JFrame frame = new JFrame("My Tic Tac Toe");
    JPanel displaypanel=new JPanel();
    JLabel heading=new JLabel("Tic Tac Toe");
    Font font=new Font("", Font.BOLD, 40);
    JButton [] buttons = new JButton[9];
    int activeplayer=0;
    int gameChance [] ={2,2,2,2,2,2,2,2,2};
    JButton button;
    int wps[][]={
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
    int winner=2;


    tictac() {
        System.out.println("Creating....");
        frame.setVisible(true);
        frame.setSize(800,800);
        ImageIcon icon = new ImageIcon("tictac\\img\\icons8-tic-tac-toe-100.png");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createGui();
    
    }
    public void createGui(){
        frame.setLayout(new BorderLayout());
        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(Color.BLUE);
        heading.setBackground(Color.CYAN);
        heading.setOpaque(true);
        frame.add(heading,BorderLayout.NORTH);
        JLabel cLabel=new JLabel("Made by Hrishabh");
        cLabel.setFont(font);
        cLabel.setHorizontalAlignment(JLabel.CENTER);
        cLabel.setBackground(Color.CYAN);
        cLabel.setForeground(Color.BLUE);
        cLabel.setOpaque(true);
        frame.add(cLabel,BorderLayout.SOUTH);
        displaypanel.setLayout(new GridLayout(3,3));
        for (int i=0;i<9;i++){
            JButton button = new JButton();
            button.setFont(font);
            button.setName(String.valueOf(i));
            displaypanel.add(button);
            button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton button=(JButton) e.getSource();
                String buttonindex=button.getName();
                System.out.println(buttonindex);
                int name=Integer.parseInt(buttonindex.trim());
                if (gameChance[name]==2){
                    if (activeplayer==1){
                        button.setIcon(new ImageIcon("tictac\\img\\icons8-cross-mark-100.png"));
                        gameChance[name]=activeplayer;
                        activeplayer=0;

                    }
                    else{
                        button.setIcon(new ImageIcon("tictac\\img\\icons8-keycap-digit-zero-100.png"));
                        gameChance[name]=activeplayer;
                        activeplayer=1;
                    }

                }
                else{
                    JOptionPane.showMessageDialog(button,"Position already occupied");
                }
                for (int [] temp:wps){
                    if ((gameChance[temp[0]]==gameChance[temp[1]])&& (gameChance[temp[1]]==gameChance[temp[2]]) && (gameChance[temp[2]]!=2) ){ 
                        winner=gameChance[temp[0]];
                        JOptionPane.showMessageDialog(null, "You Won");
                        int n=JOptionPane.showConfirmDialog(button, "Do you want to play more? ");
                        if (n==0){
                            frame.setVisible(false);
                            new tictac();
                        }else if (n==1) {
                            System.exit(123);

                            
                        }
                        else{

                        }
                        break;

                    }
                }




            }

            
        });
        }
        frame.add(displaypanel,BorderLayout.CENTER);
    }




    public static void main(String[] args) {
        System.out.println("Testing...");
        tictac tic = new tictac();
    }






    
}
