// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Progressoes aritmeticas (subclasse de Progression)
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class ArithmeticProgression extends Progression {
   protected long increment;

   // Por omissao cria progressao: 0, 1, 2, ...
   public ArithmeticProgression() { this(1, 0); }
   
   // Cria progressao: 0, stepsize, 2*stepsize,...
   public ArithmeticProgression(long stepsize) { this(stepsize, 0); }

   // Cria progressao com um dado incremento e um dado inicio
   public ArithmeticProgression(long stepsize, long start) {
      super(start);
      increment = stepsize;
   }
   
   protected void advance( ) {
      current += increment;
   }
}
