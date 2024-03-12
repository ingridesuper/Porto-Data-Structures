// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Vector
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------
public class TestVector {
   public static void main(String[] args) {
      Vector v1 = new Vector(3,2);
      Vector v2 = new Vector(1,4);

      Vector v3 = v1.add(v2);
      Vector v4 = v1.sub(v2);
      double  m = v1.magnitude();
      Vector v5 = v1.scale(2);
      
      System.out.println(v3);
      System.out.println(v4);
      System.out.printf("%.2f%n", m);
      System.out.println(v5);      
   }
}
