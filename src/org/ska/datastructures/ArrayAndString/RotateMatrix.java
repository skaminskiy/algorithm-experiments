package org.ska.datastructures.ArrayAndString;

public class RotateMatrix {
    public static void main(String[] args) {

        
        
        int[][] matrix = rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.println(" | ");
            }
            System.out.println("___");
        }
        

   }
    
    
    static int[][] rotate(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++) {
            
            //matrix[i][matrix[i].length-1] = matrix[i];
            
//            for (int j = 0; j < matrix[i].length; j++) {
//                sa1[i][j] = "new String value";
//            }
        }
        
        return matrix;
    }
}
