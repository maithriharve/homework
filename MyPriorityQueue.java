import java.util.*;

/*
 * @author Maithri Harve
 * due date: 4/26/16
 * */

class MyPriorityQueue<E> implements PriorityQueueADT<E> {
   
   ArrayList<E> heap;
   Comparator<E> comparator;
      
   MyPriorityQueue(Comparator<E> comparator){
      this.comparator = comparator;
      heap = new ArrayList<E>();
   }
  
   
   public boolean add(E item){
      heap.add(item);
      siftUp(heap.size()-1);
      return true;
   }
   
   public E remove(){
      
      E item = heap.get(0);
      int index = heap.size()-1;
      heap.set(0, heap.get(index));
      heap.remove(index);
      this.siftDown(0);
      return item;
   }
   
   public boolean isEmpty(){
      return heap.size() == 0;
   }
   
   public String toString(){
      
      return heap.toString();
   }
   
   private void siftUp(int pos){
     
     int i = (pos - 1)/2;
     while (pos > 0 && (comparator.compare(heap.get(pos), heap.get(i))) == 1) {
       E item = heap.get(pos);
       E parent = heap.get(i);
       
       heap.set(pos, parent);
       heap.set(i, item);
       pos = i;
     }
     
   }  
   

         
   private void siftDown(int pos){

     while (pos > heap.size()){
       E item = heap.get(pos);
       E left = heap.get((2 * pos) + 1);
       E right = heap.get((2 * pos) + 2);

       if (comparator.compare(left, right) == 1){
         
         heap.set(pos, left);
         heap.set((2 * pos) + 1, item);
         pos = (2 * pos) + 1;
         
       }
       
       if (comparator.compare(left, right) == -1){
         
         heap.set(pos, right);
         heap.set((2 * pos) + 2, item);
         pos = (2 * pos) + 2;
         
       }
      }
   }
   
   
}