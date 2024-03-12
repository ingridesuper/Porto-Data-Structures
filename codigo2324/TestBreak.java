// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Instrucoes de Ciclo: break
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

class TestBreak {
   public static void main(String[] args) {
      for (int i=1; i<=2; i++) {
         for (int j=1; j<=10; j++) {
            if (j == 3) break;
            // Linha seguinte so sera executada quando j < 3
            System.out.println("ciclo j = " + j + " | i = " + i);
         }
         System.out.println("ciclo i = " + i);
      }
   }
}
