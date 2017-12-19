import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlinkingBall extends Ball{
  
  private boolean blink;
  private final Color newColor;
  private int count;
  
  public BlinkingBall(int width, int height){
    super(width,height);
    
    newColor = color;
    blink = true;
    count = 0;
  }
  
  public void move(){
    super.move();
    
    if (blink && count == 5){
      color = new Color (0,0,0,0);
      blink = false;
      count = 0;
    }
    else {
      color = newColor;
      blink = true;
      count++;
    }
  }
}
    