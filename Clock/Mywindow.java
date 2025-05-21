package Clock;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
public class Mywindow extends JFrame{
    private JLabel heading;
    private JLabel clocklabel;
    private Font font =new Font("",Font.BOLD,35);

    Mywindow(){
        super.setTitle("Clock ");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.creategui();
        this.startclock();
        super.setVisible(true);


    }
    public void creategui(){
        heading=new JLabel("My Clock");
        clocklabel=new JLabel("Clock");
        heading.setFont(font);
        clocklabel.setFont(font);
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clocklabel);


    }
    public void startclock(){
        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LocalDateTime now =LocalDateTime.now();
                String date=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd || HH:mm:ss a"));
                    clocklabel.setText(date);
    
                
        
            }

        });
        timer.start();

    }
    
}
