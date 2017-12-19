/*
  Ballworld
 
  A simple animation program which displays a set of bouncing balls.
  author: John Donaldson
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Ballworld extends JFrame // appears in a GUI window
   implements ActionListener { // responds to Timer events

   // program variables
   private ArrayList<Ball> ballList = new ArrayList<Ball>();
   private javax.swing.Timer timer= new javax.swing.Timer(50,this);
   private JPanel drawingPanel;
   
   // respond to timer events
   public void actionPerformed(ActionEvent e){
      drawingPanel.repaint();
      handleCollisions();
   }

   // constructor
   // sets up the GUI frame and then exits
   Ballworld() 
   {
      // Set the frame attributes
      setSize(1000,700);
      setLocation(50,50);
      setTitle("Ballworld");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
      
      // Get a reference to the frame's content pane
      Container contentPane = getContentPane();

      // Set up the GUI components within the frame
      JPanel buttonPanel = new JPanel(); // a panel for buttons at the bottom
      contentPane.add("South",buttonPanel); 
      
      // three buttons in the button panel
      JButton addButton = new JButton("Add Ball");
      buttonPanel.add(addButton);
      
      JButton addButton2 = new JButton("Add Curveball");
      buttonPanel.add(addButton2);
      
      JButton addButton3 = new JButton ("Add Color Changing Ball");
      buttonPanel.add(addButton3);
      
      JButton addButton4 = new JButton ("Add Size Changing Ball");
      buttonPanel.add(addButton4);
      
      JButton addButton5 = new JButton ("Add Random Walk Ball");
      buttonPanel.add(addButton5);
      
      
      JButton addButton7 = new JButton ("Add Blinking Ball");
      buttonPanel.add(addButton7);
            
      JButton clearButton = new JButton("Delete all Balls");
      buttonPanel.add(clearButton);
      
      JButton closeButton = new JButton("Close Window");
      buttonPanel.add(closeButton);

      // the drawing panel
      drawingPanel = new JPanel(){
         // this method describes how to draw the panel
         public void paintComponent(Graphics g){
            super.paintComponent(g); // redraw the panel
            for(Ball b : ballList){ // redraw the balls
               b.draw(g);
            }
         }
      };
      drawingPanel.setBackground(Color.lightGray);
      contentPane.add("Center",drawingPanel);
      
      // Set up the action listeners for the buttons
      addButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            Ball ball = new Ball(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(ball);
            // add it to the Ball list
            ballList.add(ball);
         }
      });
      
      addButton2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            CurveBall cball = new CurveBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(cball);
            // add it to the Ball list
            ballList.add(cball);
         }
      });
      
      addButton3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            ColorChangingBall ccball = new ColorChangingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(ccball);
            // add it to the Ball list
            ballList.add(ccball);
         }
      });
      
      addButton4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            SizeChangingBall scball = new SizeChangingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(scball);
            // add it to the Ball list
            ballList.add(scball);
         }
      });
      
      addButton5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            RandomWalkBall rwball = new RandomWalkBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(rwball);
            // add it to the Ball list
            ballList.add(rwball);
         }
      });

     
      addButton7.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // instantiate a Ball
            BlinkingBall bball = new BlinkingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(bball);
            // add it to the Ball list
            ballList.add(bball);
         }
      });
      
      
      clearButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            ballList.clear();
         }
      });
      
      closeButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            System.exit(0);
         }
      });
      
      setVisible(true); // make the frame visible on the screen
      timer.start();
   }
   
//   public void handleCollisions(){
//     
//     for (int i = 0; i < ballList.size()-1 ; i++){
//       Ball b1 = ballList.get(i);
//       Ball b2 = ballList.get(i+1);
//       
//       if (b1.intersect(b2)){
//         b1.collide(b2);
//       }
//       else return;
//     }
//   }
   
   public void handleCollisions(){
     for (int i = 0; i < ballList.size() - 1; i++){
       Ball b1 = ballList.get(i);
       
       for (int j = i+1; j < ballList.size(); j++){
         
         if (b1.intersect(ballList.get(j))){
           b1.collide(ballList.get(j));
         }
       }
     }
   }
     
   

   // the main method
   public static void main(String args[])
   {
      // instantiate the frame
      new Ballworld();
   }
   
}

