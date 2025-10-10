import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab5m extends JApplet {

JLabel jlab;

Lab5m() {

/* Specify FlowLayout for the layout manager */
getContentPane().setLayout(new FlowLayout());

/* Give the frame an initial size */
setSize(220, 90);

/* Terminate the program when the user closes the application
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); (Not for online use of course) */

/* Make two buttons */
JButton jbtnFirst = new JButton("First");
JButton jbtnSecond = new JButton("Second");

/* Add action listeners */
jbtnFirst.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.CYAN);
    jlab.setText("First button was pressed");
  }
});

jbtnSecond.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae) {
    getContentPane().setBackground(Color.ORANGE);
   jlab.setText("Second button was pressed");
  }
});

/* Add the buttons to the content pane */
getContentPane().add(jbtnFirst);
getContentPane().add(jbtnSecond);

/* Create a text-based label */
jlab = new JLabel("Press a button.");

/* Add the label to the frame */
getContentPane().add(jlab);

/* Display the frame */
setVisible(true);

 /* Handle button events (Alternate way) */
/* public void actionPerformed(ActionEvent ae) {
 
 if(ae.getActionCommand().equals("First"))
 jlab.setText("First button was pressed.");
 else
 jlab.setText("Second button was pressed."); */
}
}
