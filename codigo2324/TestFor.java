// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Instrucoes de Ciclo: for
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

class TestFor {
  public static void main(String[] args) {
    System.out.println("isPrime(19) = " + isPrime(19));
  } 

  public static boolean isPrime(int n) {
    for(int divisor = 2; divisor < n/2; divisor++) 
      if ( (n % divisor) == 0 ) 
        return false;        
    return true;
  }
}
