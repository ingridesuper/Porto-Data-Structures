// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao de Scanner a partir do teclado
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class TestScannerFromKeyboard {
  public static void main (String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("Number of persons: ");

    int n = stdIn.nextInt();
    String[] names = new String[n];
    int[]    ages  = new int[n];

    for( int i = 0; i < n ; i++ ) {
      System.out.println("input name[space]age: ");
      names[i] = stdIn.next();
      ages[i]  = stdIn.nextInt();
    }

    for( int i = 0; i < n ; i++ )
      System.out.println("name: "+ names[i] + " age: " + ages[i]);
  }
}
