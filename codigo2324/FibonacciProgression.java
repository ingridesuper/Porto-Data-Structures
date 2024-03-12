// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Sequencia de Fibonacci (subclasse de Progression)
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------


class FibonacciProgression extends Progression {
   protected long prev;

   // Por omissao cria fibonacci classico: 0, 1, 1, 2, 3, 5, ...
   public FibonacciProgression() { this(0, 1); }
   
   // Cria fibonacci com dois valores iniciais dados
   public FibonacciProgression(long first, long second) {
      super(first);
      prev = second - first; // valor ficticio antes do first
   }
   
   protected void advance( ) {
      long temp = prev + current;
      prev = current;
      current = temp;
   }
}
