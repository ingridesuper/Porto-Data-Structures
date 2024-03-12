// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao de Scanner a partir de uma String
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class TestScannerFromString {
  public static void main (String[] args) {
    Scanner strIn = new Scanner("1 - 2 - 3 - 4 - 5");
    strIn.useDelimiter(" - ");
    while ( strIn.hasNextInt() ) {
      int n = strIn.nextInt();
      System.out.println(n);
    }
  }
}
