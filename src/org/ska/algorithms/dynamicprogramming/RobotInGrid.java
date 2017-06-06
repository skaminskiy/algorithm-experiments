package org.ska.algorithms.dynamicprogramming;

public class RobotInGrid {
    
    public static int count = 0;
    
    public static void main(String[] args) {
        
        boolean[][] grid = new boolean[4][5];
        grid[1][1] = true;
        grid[2][2] = true;
        grid[3][3] = true;
        //grid[1][4] = true;
        
        grid[1][3] = true;
        
        System.out.println(go(grid, 0, 0, new boolean[4][5])); //true
        
        
        System.out.println(count);
    }

    static boolean go(boolean[][] grid, int rowIndex, int columnIndex, boolean[][] history) {

        if (grid.length <= rowIndex || grid[0].length <= columnIndex) {
            return false;
        }
        
        if (grid[rowIndex][columnIndex] == true) {
            return false;
        }
        
        if (history[rowIndex][columnIndex] == true) {
            return false;
        }
        
        System.out.println("row: " + rowIndex + " / column: " + columnIndex);
        
        count = count +1;
        

        
        if (grid.length == rowIndex + 1 && grid[0].length == columnIndex + 1) {
            //System.out.println("row: " + rowIndex + " / column: " + columnIndex);
            return true;
        }
        
        boolean down = go(grid, rowIndex + 1, columnIndex, history);
        boolean left = false;
        if (!down) {
            left = go(grid, rowIndex, columnIndex + 1, history);
        }
        
        if (down || left) {
            //System.out.println("row: " + rowIndex + " / column: " + columnIndex);
        } else {
            history[rowIndex][columnIndex] = true;
        }
        
        return down || left;
    }
    
    static boolean go2(boolean[][] grid, int rowIndex, int columnIndex) {

       
        
        for (int i = rowIndex; i >= 0; i--) {
            for (int j = columnIndex; j >= 0; j--) {
                
            }
        }
        
        return false;
    }
    
}
