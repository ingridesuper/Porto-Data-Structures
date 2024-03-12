// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// TAD Ponto 2D (num plano) como falado nas primeiras aulas
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class Point {
   // Variavel estatica com nr pontos criados
   static int npoints = 0; 
   
   // Atributos
   int x;
   int y;

   // Construtor que recebe o conteudo a colocar nos atributos
   Point(int xvalue, int yvalue) {
      x = xvalue;
      y = yvalue;
      npoints++;
   }

   // Construtor padrao (sem argumentos)
   Point() { 
      x = 0;
      y = 0;
      npoints++;
   }
   
   // Metodo para mostrar o conteudo das variaveis x e y
   void show() {
      System.out.println("(" + x + "," + y + ")");
   }

   // mostra conteudo da variavel estatica
   static void showNumPoints() {
      System.out.println("npoints = " + npoints);
   }
}

