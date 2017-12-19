import java.util.*;
public class LinkedQueue<T> implements QueueADT<T> {
  
  class ListNode {
    T data;
    ListNode next;
    
    ListNode(T d, ListNode n){
      data = d;
      next = n;
    }
  }
  
  private ListNode front;
  private ListNode rear;
  
  LinkedQueue(){
    front = null;
    rear = null;
  }
  
  public void enqueue(T item){
    ListNode ol= rear; 
    rear = new ListNode(item, ol);
    rear.data = item;
    rear.next = null;
    if (isEmpty()) front = rear; 
    else ol.next = rear;
    
    
  }
  public T dequeue(){
    T item = front.data;
    front = front.next;
    
    return item;
  }
  public boolean isEmpty(){
    return front==null;
  }
  public void clear(){
    front = null;
    rear = front;
  }
  
  public void append(LinkedQueue<T> q){
    
    if(front==null){
      front = q.front;
    }
    else{
      rear.next = q.front;
    }
    if(q.front != null){
      rear = q.rear;
    }
    
  }
  
  public String toString(){
    List<T> list = new ArrayList<T>();
    ListNode p = front;
    while (p!=null){
      list.add(p.data);
      p=p.next;
    }
    return list.toString();
  }
  

    
  }
