package week_8_demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Smiley extends JPanel{
    private int centreX, centreY, offsetX, offsetY; 
    private int m1,m2,m3;
    private JToggleButton happyButton;
    private JToggleButton anotherButton;
    boolean happy=true;
    public Smiley()
    {
    	super();
        centreX=200;
        centreY=200;
        offsetX=40;
        offsetY=40;
        happyButton=new JToggleButton("Happy");
        add(happyButton);
        System.out.println("Happy button "+happyButton.getClass().getName());
//        happyButtonAction hb=new happyButtonAction();
        ActionListener f=new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(happy){
                        happyButton.setText("Sad");
                        happy=false;
                    }
                    else{
                        happyButton.setText("Happy");
                        happy=true;
                    }
                    repaint();
                }
        };
        happyButton.addActionListener(f);

        happyButton=new JToggleButton("Happy");
        ActionListener f2=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed  ");
            }
        };
        happyButton.addActionListener(f2);



        System.out.println("Happy button class"+happyButton.getClass().getName());
        
        anotherButton = new JToggleButton(" FOO");
        add(anotherButton);
      
      
    }
    public void paintComponent(Graphics gc) {
     gc.setColor(Color.red);
     gc.fillRect(0,0,500,500);
     gc.setColor(Color.yellow);
     gc.fillOval(offsetX,offsetY,centreX*2,centreY*2);
     gc.setColor(Color.black);
     gc.fillOval(offsetX+centreX/2,offsetY+(int)(centreY), 15,15);     
     gc.fillOval(offsetX+3*centreX/2,offsetY+(int)(centreY), 15,15);
    //Set smile
     if(happy)
       gc.drawArc(offsetX,m2,centreX*2,centreY*2,225,90);
    else
       gc.drawLine(150, 350, 350, 350); 
    }    
public static void main(String[] args) {
    new Thread(
            new Runnable() {
                public void run()
                { // do stuff
                    System.out.println(" Threaded");
                }
            }
    ).start();

	JFrame f = new JFrame();
	Smiley s=new Smiley();
	f.setLocation(200,200); 
	f.add(s);
	f.setMinimumSize(new Dimension(500,500));
    	f.pack();  
    	f.setVisible(true);       

}
//Inner class, can access the variables of the enclosing object
public class happyButtonAction implements ActionListener{
    public void actionPerformed(ActionEvent e) {
            if(happy){
                happyButton.setText("Sad");
                happy=false;
            }
            else{
                happyButton.setText("Happy");
                happy=true;
            }
            repaint();
    }

}


}
      
      