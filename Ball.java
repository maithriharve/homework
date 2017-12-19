/*
 Ball -- represents one ball in the Ball World application
 
 author: John Donaldson
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball implements ActionListener
{
   // the Ball's properties
   private int canvasWidth, canvasHeight;
   private int xpos,ypos;
   protected double xvelocity,yvelocity;
   protected int diameter;
   protected Color color;

   // the Ball constructor
   // parameters are the width and height of the canvas
   public Ball(int width, int height){
      canvasWidth = width;
      canvasHeight = height;
      
      // the diameter is a random int between 50 and 100 
      diameter = (int)(50*Math.random())+50;
      
      // the velocity components 
      xvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      yvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      
      // the initial (x,y) position of the ball
      xpos=(int)(canvasWidth*Math.random());
      ypos=(int)(canvasHeight*Math.random());
      
      // pick a random color
      color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
   }

   // how the ball moves
   public void move(){
      int xmax = canvasWidth;
      int ymax = canvasHeight;
      
      // update the x position
      xpos+=xvelocity;
      // if past the right boundary, bounce back to the left
      if(xpos+diameter > xmax){
         xpos = xpos - 2*(xpos+diameter-xmax);
         xvelocity = -xvelocity;
      }
      // if past the left boundary, bounce back to the right
      if(xpos < 0){
         xpos = -xpos;
         xvelocity = -xvelocity;
      }
      
      // update the y position      
      ypos+=yvelocity;
      // if past the bottom boundary, bounce back up
      if(ypos+diameter > ymax){
         ypos = ypos - 2*(ypos+diameter-ymax);
         yvelocity = -yvelocity;
      }
      // if past the upper boundary, bounce back down
      if(ypos < 0){
         ypos = -ypos;
         yvelocity = -yvelocity;
      }
   }

   // how to draw this ball
   public void draw(Graphics g){
      g.setColor(color);
      g.fillOval(xpos,ypos,diameter,diameter);
   }
   
   public double distance(Ball other) {
     int xcenter = xpos + diameter/2;
     int ycenter = ypos + diameter/2;
     int xcenterother = other.xpos + diameter/2;
     int ycenterother = other.ypos + diameter/2;
     
     int deltax = xcenterother - xcenter;
     int deltay = ycenterother - ycenter;
     
     double square1 = Math.pow(deltax, 2);
     double square2 = Math.pow(deltay, 2);
     
     double distance = Math.sqrt(square1+square2);
     
     return distance;
   }
   
   public boolean intersect(Ball other){
     return this.distance(other) <= this.diameter/2+other.diameter/2;
   }
   
   public void collide (Ball other){
     double massthis = Math.pow(this.diameter, 2);
     double massother = Math.pow(other.diameter, 2);
     int xcenterother = other.xpos + (other.diameter)/2;
     int xcenter = this.xpos + (this.diameter)/2;
     int ycenterother = other.ypos + (other.diameter)/2;
     int ycenter = this.ypos + (this.diameter)/2;
     
     if (this == other){
       return;
     }
     else {
       
       double forcethis = (2*massother)/(massthis+massother)*((xcenterother - xcenter) * (other.xvelocity-this.xvelocity) + (ycenterother - ycenter) * 
                                                              (other.yvelocity - this.yvelocity))/(this.distance(other));
       this.xvelocity += forcethis * (xcenterother - xcenter)/(this.distance(other));
       this.yvelocity += forcethis * (ycenterother - ycenter)/(this.distance(other));
       
     }
   }
   


   // how the ball responds to a timer tick
   public void actionPerformed(ActionEvent e){
      move();
   }
   
}