public class RationalC implements Rational {
  private int numerator;
  private int denominator;
  
  public RationalC(int n, int d){
    numerator = n;
    denominator = d; 
    
    int gcd = GCD(numerator, denominator);
    
    numerator /= gcd;
    denominator /= gcd;
    
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
    
    
    
    
    //reduce fraction here, redeclare numerator and denominator
  }
  
  public RationalC(int n){
    numerator = n;
    denominator = 1;
  }
  
  public int getNumerator(){
    return numerator;
  }
  public int getDenominator(){
    return denominator;
  }
  
  public Rational add(Rational other){
    
    int nthis = this.getNumerator();
    int dthis = this.getDenominator();
    int nother = other.getNumerator();
    int dother = other.getDenominator();
    
    int newNum = (nthis * dother) + (nother * dthis);
    int newDenom = dthis * dother;
    
  
    
    int gcd = GCD(newNum, newDenom);
    newNum /= gcd;
    newDenom /= gcd;
    
    RationalC newRational = new RationalC(newNum, newDenom);
    
    return newRational;
    
    
  }
  
  public Rational multiply(Rational other){
    
    int nthis = this.getNumerator();
    int dthis = this.getDenominator();
    int nother = other.getNumerator();
    int dother = other.getDenominator();
    
    int newNum = nthis * nother;
    int newDenom = dthis * dother;
    
    int gcd = GCD(newNum, newDenom);
    newNum/=gcd;
    newDenom/=gcd;
    
    RationalC newRational = new RationalC(newNum, newDenom);
    
    return newRational;
    
  }
  
  public int compareTo(Rational other){
    
    int nthis = this.getNumerator();
    int dthis = this.getDenominator();
    int nother = other.getNumerator();
    int dother = other.getDenominator();
    
    int product1 = nthis * dother;
    int product2 = dthis * nother;
    
    if (product1 > product2){
      return 1;
    }
    else if (product1 == product2){
      return 0;
    }
    else return -1;
  }
    
  public boolean equals(Object other){
    

    
    Rational temp = (Rational)other;
    
    if(numerator == temp.getNumerator() && denominator == temp.getDenominator())
      return true;
    else return false;
    
  }
  
  public int GCD(int a, int b) {
    if (b==0) return a;
    return GCD(b, a%b);
  }
  
//  public void reduce(int n, int d){
//    int largest = 0;
//    if (n < 0){
//      n = Math.abs(n);
//    }
//    else if (n > d){
//      largest = n;
//    }
//    else largest = d;
//    
//    int gcd = 0; 
//    
//    for (int i = largest; i >=2; i--){
//      if (n % i == 0 && d % i == 0){
//        gcd = i;
//        break;
//      }
//    }
//    if (gcd != 0){ 
//      n /= gcd;
//      d /= gcd;
//    }
//  }
    
  
  
  public String toString(){
    String s = numerator + "/" + denominator;
    return s;
  }
}


    