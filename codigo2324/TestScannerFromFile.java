// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao de Scanner a partir de um ficheiro
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;

public class TestScannerFromFile {
  public static void main (String args[]) {
    try {
      File file = new File("./example.txt");
      Scanner fileIn = new Scanner(file);
      while( fileIn.hasNextLine() )
      	System.out.println(fileIn.nextLine());
    }	 
    catch (IOException e) { // Mais sobre a instrucao catch noutra aula
      System.out.println("File not found");
    }
  }	
}
