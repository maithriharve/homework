import java.util.*;
public class RadixSort {
  static class QArray extends LinkedQueue<String>{}
  
  public static void main(String[] args){
    
    String output = "";
    
    QArray[] alphabet = new QArray[26];
    
    for (int i = 0; i < 26; i++){
      alphabet[i] = new QArray();
    }
    
    LinkedQueue<String> master = new LinkedQueue<String>();
    
    Scanner input = new Scanner(System.in);
    
    while (input.hasNextLine()){
      String s = input.nextLine();
      master.enqueue(s);
    }
    
    for (int i = 6; i >= 0; i--){
      for (int j = 0; j<26; j++){
        alphabet[j].clear();
      }
      
      while (!master.isEmpty()){
        String s = master.dequeue();
        char c = s.charAt(i);
        int index = c - 'a';
        alphabet[index].enqueue(s);
      }
      
      for (int k = 0; k < 26; k++){
        master.append(alphabet[k]);
      }
      
    }
  
    while (!master.isEmpty()){
      output+=master.dequeue();
      output+= "\n";
    }
    
    System.out.println(output);
  }
}

      