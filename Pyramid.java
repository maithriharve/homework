/*
 * This program asks the user for a number, then constructs a pyramid of asterisks with the requested number of levels.
 * 
 * author: Maithri Harve
 * */

import java.util.*;
public class Pyramid {
  public static void main (String[] args) {
    
    Scanner input = new Scanner (System.in);
    System.out.println("Enter the height of the pyramid: ");
    int height = input.nextInt();
    
    for(int i=0;i<height;i++) {
         for(int j=0;j<height-i;j++) {
             System.out.print(" ");
         }
        for(int k=0;k<=i;k++) {
            System.out.print("* ");
        }
        System.out.println();  
    }

  }
 }
