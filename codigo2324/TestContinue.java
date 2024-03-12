// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Instrucoes de Ciclo: continue
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

class TestContinue {
   public static void main(String[] args) {
      for (int i=1; i<=4; i++) {
         System.out.println("[antes] i = " + i);
         if (i > 2) continue;
         // Linha seguinte so sera executada quando i <= 2
         System.out.println("[depois] i = " + i); 
      }
   }
}
