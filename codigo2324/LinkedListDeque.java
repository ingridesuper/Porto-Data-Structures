// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Implementacao do TAD Deque usando lista duplamente ligada
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class LinkedListDeque<T> implements MyDeque<T> {
   private DoublyLinkedList<T> list;

   LinkedListDeque() { list = new DoublyLinkedList<T>();}
   
   public void addLast(T v)  { list.addLast(v); }
   public void addFirst(T v) { list.addFirst(v); }
   public T removeFirst() {
      T ans = list.getFirst();
      list.removeFirst();
      return ans;
   }
   public T removeLast() {
      T ans = list.getLast();
      list.removeLast();
      return ans;
   }
   public T first() { return list.getFirst();}
   public T last() { return list.getLast();}
   public int size() {return list.size();}
   public boolean isEmpty() {return list.isEmpty();}

   public String toString() {return list.toString();}
}
