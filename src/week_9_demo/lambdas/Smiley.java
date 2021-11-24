package week_9_demo.lambdas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Sheet 4 task 3 Action Listeners for Swing
 */
public class Smiley extends JPanel{
    private int centreX, centreY, offsetX, offsetY; 
    private int m1,m2,m3;
    private ArrayList<JToggleButton> buttons;
    boolean happy=true;
    private Color background=Color.red;

    public Smiley()
    {
    	super();
        centreX=200;
        centreY=200;
        offsetX=40;
        offsetY=40;
        buttons= new ArrayList<>();
        JToggleButton aButton=new JToggleButton("Happy");
//Add to this JPanel
        add(aButton);
//Add to our stored list of buttons
        buttons.add(aButton);
        AddButton b = new AddButton();
        aButton.addActionListener(b);
/*********** ACTION LISTENER EXAMPLES **************/

        //Add an anonymous inner action listener for first button
        ActionListener f=new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(happy){
//Access the smiley attributes, since it is defined in a non static method
                        buttons.get(0).setText("Sad");
                        happy=false;
                    }
                    else{
                        buttons.get(0).setText("Happy");
                        happy=true;
                    }
                    repaint();
                }
        };
        ActionListener lambdaAction = e -> {
            if(happy){
                buttons.get(0).setText("Sad");
                happy=false;
            }
            else{
                buttons.get(0).setText("Happy");
                happy=true;
            }
            repaint();
        };
        aButton.addActionListener(f);
        //Add an local inner action listener for second and third button
        //Change Smiley to a fixed colour
        class LocalListener implements ActionListener{
            Color c;
            LocalListener(Color x){
                c=x;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                background=c;
                System.out.println(" LOCAL COLOUR = "+c);
                repaint();
            }
        }
        aButton=new JToggleButton("Colour");
        aButton.addActionListener(new LocalListener(Color.black));
        add(aButton);
        buttons.add(aButton);
        aButton=new JToggleButton("Colour");
        aButton.addActionListener(new LocalListener(Color.CYAN));
        add(aButton);
        buttons.add(aButton);

//Add a predefined inner class, this to add another button
//Doesnt work, need to repaints or something
        aButton=new JToggleButton("Add a button");
        aButton.addActionListener(new AddButton());
        add(aButton);

        System.out.println("Happy button class"+aButton.getClass().getName());
//Add one as a lambda
        buttons.get(0).addActionListener(lambdaAction);

    }




    public void paintComponent(Graphics gc) {
        gc.setColor(background);
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
public class AddButton implements ActionListener{
    int pos=1;
    public void actionPerformed(ActionEvent e) {
        JToggleButton aButton=new JToggleButton("Button "+pos++);
        add(aButton);
        buttons.add(aButton);
        repaint();
    }
}


}
      
      