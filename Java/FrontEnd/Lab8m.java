import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab8m extends JApplet {
  
  JLabel jlab;
  
  public void init() {
    try {
       SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {
     guiInit();
    }
  });
    } catch(Exception exc) {
      System.out.println("Can't create because of "+ exc);
    }
  }
      
    // Specify FlowLayout for the layout manager
  public void guiInit() {
    getContentPane().setLayout(new FlowLayout());
    
    // Give the frame an initial size
    setSize(390, 120);
    
    /* Terminate the program when the user closes the application
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); (Not used for online use) */
    
    // Make buttons
    JButton jbtnFirst = new JButton("First");
    JButton jbtnSecond = new JButton("Second");
    JButton jbtnThird = new JButton("Third");
    JButton jbtnFourth = new JButton("Fourth");
    JButton jbtnFifth = new JButton("Fifth");
    
    // Add action listeners
    jbtnFirst.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.BLUE);
    jlab.setText("Desires");
  }
});
    jbtnSecond.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.RED);
    jlab.setText("Anger");
  }
});
    jbtnThird.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.CYAN);
    jlab.setText("Greed");
  }
});
    jbtnFourth.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.PINK);
    jlab.setText("Attachment");
  }
});
    jbtnFifth.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.GREEN);
    jlab.setText("Ego");
  }
});
    
    // Add the buttons to the content pane
    getContentPane().add(jbtnFirst);
    getContentPane().add(jbtnSecond);
    getContentPane().add(jbtnThird);
    getContentPane().add(jbtnFourth);
    getContentPane().add(jbtnFifth);
    
    // Create a text-based label
    jlab = new JLabel("Press a button");
    
    // Add the laabel to the frame
    getContentPane().add(jlab);
    
    // Display the frame
    setVisible(true);
  }
  
  /* Handle button events (Alternative)
  public void actionPerformed(ActionEvent go) {
    
    if(go.getActionCommand().equals("First")) 
      jlab.setText("Desires"); 
    else if(go.getActionCommand().equals("Second")) 
      jlab.setText("Anger"); 
    else if(go.getActionCommand().equals("Third")) 
      jlab.setText("Greed"); 
    else if(go.getActionCommand().equals("Fourth")) 
      jlab.setText("Attachment"); 
                            else
                              jlab.setText("Ego");
                            } */
  
}