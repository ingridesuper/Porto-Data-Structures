// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Implementa o TAD Vector
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class Vector {
   // Atributos
   private double x, y;

   // Construtor
   Vector(double x0, double y0) {
      x = x0;
      y = y0;
   }

   //Conversao de um vector para String
   @Override 
   public String toString() {
      return "(" + x + "," + y + ")";
   }
   
   public Vector add(Vector v) {
      return new Vector(x + v.x, y + v.y);
   }

   public Vector sub(Vector v) {
      return new Vector(x - v.x, y - v.y);
   }

   public double magnitude() {
      return Math.sqrt(x*x + y*y);
   }

   public Vector scale(double c) {
      return new Vector(x*c,y*c);
   } 
}
