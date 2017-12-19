import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class RationalTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testRationalC() {
    
    Rational test = new RationalC(10,3);
    assertEquals("Numerator after construction of 10/3", 10, test.getNumerator());
    assertEquals("Denominator after construction of 10/3", 3, test.getDenominator());
    test = new RationalC(10,2);
    assertEquals("Numerator after construction of 10/2", 5, test.getNumerator());
    assertEquals("Denominator after construction of 10/2", 1, test.getDenominator());
    test = new RationalC(0,12);
    assertEquals("Numerator after construction of 0/12", 0, test.getNumerator());
    assertEquals("Denominator after construction of 0/12", 1, test.getDenominator());
    test = new RationalC(24,-18);
    assertEquals("Numerator after construction of 24/-18", -4, test.getNumerator());
    assertEquals("Denominator after construction of 24/-18", 3, test.getDenominator());
    test = new RationalC(10,2);
    assertEquals("Numerator after construction of 10/2", 5, test.getNumerator());
    assertEquals("Denominator after construction of 10/2", 1, test.getDenominator());
  }
  
  public void testCompareTo(){
    
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(3,5);
    Rational c = new RationalC(2,3);
    Rational d = new RationalC(30,50);
    Rational e = new RationalC(3,-5);

    assertTrue("compare 2/3, 3/5", a.compareTo(b) > 0);
    assertTrue("compare 3/5, 2/3", b.compareTo(a) < 0);
    assertTrue("compare 2/3, 2/3", a.compareTo(c) == 0);
    assertTrue("compare 3/5, 30/50", b.compareTo(d) == 0);
    assertTrue("compare 30/50, 3/5", d.compareTo(b) == 0);
    assertTrue("compare 3/5, -3/5", b.compareTo(e) > 0);
}
  
  public void testAdd(){
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(2,5);
    Rational c = new RationalC(1,3);
    Rational d = new RationalC(4,8);
    Rational e = new RationalC(1,1);
    Rational f = new RationalC(3,-5);
    
    assertEquals("1/1", (a.add(c)).toString());
    assertEquals("5/6", (c.add(d)).toString());
    assertEquals("-4/15", (c.add(f)).toString());
    
    ArrayList<Rational> list = new ArrayList<Rational>();
    
    for (int i = 1; i <= 9; i++){
      list.add(new RationalC(i, i+1));
    }

    Rational sum = new RationalC(0,1);
    for (int i = 0; i < list.size(); i++){
      sum = sum.add(list.get(i));
    }
  
     assertEquals("17819/2520", sum.toString());
  
  }
  
  public void testMultiply(){
    
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(2,5);
    Rational c = new RationalC(1,3);
    Rational d = new RationalC(4,8);
    Rational e = new RationalC(1,1);
    Rational f = new RationalC(3,-5);
    
    assertEquals("2/9", (a.multiply(c)).toString());
    assertEquals("1/6", (c.multiply(d)).toString());
    assertEquals("-1/5", (c.multiply(f)).toString());
    
    ArrayList<Rational> list = new ArrayList<Rational>();
    
    for (int i = 1; i <= 9; i++){
      list.add(new RationalC(i, i+1));
    }
    Rational product = new RationalC(1,1);
    for (int i = 0; i < list.size(); i++){
      product = product.multiply(list.get(i));
    }
    
    assertEquals("1/10", product.toString());
    
    
  }
  
  public void testEquals(){
    
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(2,5);
    Rational c = new RationalC(2,3);
    Rational d = new RationalC(-4,8);
    Rational e = new RationalC(-1,2);
    Rational f = new RationalC(3,-5);
    
    assertEquals(false, a.equals(b));
    assertEquals(true, a.equals(c));
    assertEquals(true, d.equals(e));
    assertEquals(false, c.equals(f));
    
    
  }
  

  
}
