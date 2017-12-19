public class RandomWalkBall extends Ball{
  
  public RandomWalkBall (int width, int height){
    super(width, height);
  }
  
  public void move(){
    super.move();
    xvelocity-=((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
    yvelocity+=((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
  }
}
    