// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Interface para o TAD Deque
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public interface MyDeque<T> {

   // Metodos que modificam o deque
   public void addFirst(T v); // Coloca um valor no inicio da fila
   public void addLast(T v);  // Coloca um valor no final da fila
   public T removeFirst();    // Retira e retorna o valor no inicio da fila
   public T removeLast();     // Retira e retorna o valor no final da fila

   // Metodos que acedem a informacao (sem modificar)
   public T first();          // Retorna valor no inicio da fila
   public T last();           // Retorna valor no final da fila
   public int size();         // Retorna quantidade de elementos na fila
   public boolean isEmpty();  // Indica se a fila esta vazia
}
