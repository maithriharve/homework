public class RectangularRandomWalk extends Ball {
  
  public RectangularRandomWalk (int width, int height){
    super(width, height);
  }
  
  public void move(){ 
    int n = (int) ( Math.random() * 2 + 1);
    
    if (n == 1){
      super.move(); 
      xvelocity = 0;
      yvelocity+=((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
    }
    else {
      super.move();
      xvelocity+=((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      yvelocity = 0;
    }
  }
}
