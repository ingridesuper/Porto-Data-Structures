// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Instrucoes de Ciclo: while
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

class TestWhile {
   public static void main(String[] args) {
      System.out.println("isPrime(19) = " + isPrime(19));
   } 
   
   public static boolean isPrime(int n) {
      int divisor = 2;
      while (divisor*divisor <= n) {
         if ( (n % divisor) == 0 ) 
            return false;
         divisor++;
      }
      return true;
   }   
}
