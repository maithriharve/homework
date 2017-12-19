public class SizeChangingBall extends Ball {
  
  public SizeChangingBall (int width, int height){
    super(width, height);
  }
 
  public void move(){
    super.move();
    diameter = (int)(50*Math.random())+50;
  }
}                