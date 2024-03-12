// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Multiplicacao de matriz por array
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Arrays;

class TestMatrixVectorProduct {
   public static void main(String[] args) {
      int[][]  a = {{1,2,3},{4,5,6}};
      int[]    u = {7,8,9};
      int[]    v = matrixVectorMult(a,u);
         
      System.out.println(Arrays.toString(v));
   }
   
   static int[] matrixVectorMult(int[][] a, int[] u) {
      int[] v = new int[a.length];
      for( int i = 0 ; i < v.length ; i++ ) {
         v[i] = 0;
         for( int j = 0 ; j < u.length ; j++ ) 
            v[i] += a[i][j] * u[j];
      }
      return v;
   }
}
