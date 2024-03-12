// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de escrita formatada
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class TestOutput {
  public static void main (String[] args) {
     long n = 461012;
     System.out.printf("%d%n", n);      //  -->  "461012"
     System.out.printf("%8d%n", n);     //  -->  "\_\_461012"
     System.out.printf("%-8d%n", n);    //  -->  "461012\_\_" 
     System.out.printf("%08d%n", n);    //  -->  "00461012"

     double pi = Math.PI;
     System.out.printf("%f%n", pi);       // -->  "3.141593"
     System.out.printf("%.3f%n", pi);     // -->  "3.142"
     System.out.printf("%10.3f%n", pi);   // -->  "\_\_\_\_\_3.142"
     System.out.printf("%-10.3f%n", pi);  // -->  "3.142\_\_\_\_\_"
  }
}
