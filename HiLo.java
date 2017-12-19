/*
 * This program creates a guessing game for the user to play. The number is randomly generated
   and the user attempts to guess the number, but is given hints as to whether or not their 
   guess is higher or lower than the randomly generated number.
   
 * author: Maithri Harve
 * */

import java.util.*;
public class HiLo {
  public static void main (String[] args){
    Random rnd = new Random();
    int target = rnd.nextInt(1000) + 1; 
    
    System.out.println("Let's play a game!");
    System.out.println("I'm thinking of a number between 1 and 1000.");
    System.out.println("Try to guess what it is!");
    System.out.println("Enter a guess: ");
    
    int counter = 0;
    int userGuess = -1;
    
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner s2 = new Scanner(line);
      
      if (s2.hasNextInt()) {
        
        userGuess = s2.nextInt();
      }
      
      else {
        System.out.println("That's not a number, try again: ");
        counter++;
        continue;
      }
      
      if (userGuess < target){
        System.out.println("Too low!");
        System.out.println("Enter a guess: ");
        counter++;
      }
      else if (userGuess > target){
        System.out.println("Too high!");
        System.out.println("Enter a guess: ");
        counter++;
      }
      else {
        System.out.println("You guessed my number! It took you " + counter + " tries.");
        break;
      }
    }
  }
}
      