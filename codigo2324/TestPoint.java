// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Ponto
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class TestPoint {
   public static void main(String[] args) {
      // E possivel chamar metodo estatico mesmo sem objectos criados
      Point.showNumPoints();   // Escreve npoints = 0

      Point p1 = new Point();      // p1 fica com (0,0)
      p1.show();
      Point p2 = new Point(42,13); // p2 fica com (42,13)
      p2.show();
      
      Point.showNumPoints();   // Escreve npoints = 2

      Point p3 = new Point(1,1);  // p3 fica com (1,1)
      Point p4 = new Point(1,1);  // p4 fica com (1,1)
      System.out.println(p3==p4); // escreve false, porque sao referências 
                                  // para objectos diferentes, embora tenham
                                  // o mesmo conteudo

      Point.showNumPoints();   // Escreve npoints = 4
   }
}
