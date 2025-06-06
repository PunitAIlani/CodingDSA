/*
Given a 9x9 sudoku board, return true if it is valid, return false otherwise.

Note:
A sudoku board is valid if each respective row, column, & subgrid contain unique numerical values. A duplicate value in a row, column, or 3x3 subgrid invalidates the whole board.
0 denotes an empty cell
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] board = {{4,1,0,0,7,0,0,0,5}, {0,8,0,0,0,6,0,9,0}, {0,0,0,5,0,0,0,0,0}, {0,0,7,4,0,1,3,0,0},{5,3,0,0,0,0,0,1,2}, {0,0,4,3,0,8,7,0,0},{0,0,0,0,0,4,0,0,0},{0,9,0,8,0,0,0,7,0},{7,0,0,0,6,0,0,2,8}};
        
        boolean isValidSudoku = true;
        Map<String,Boolean> seen = new HashMap<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                int value = board[i][j];
                if(value==0) continue;
                String row = i + "(" + value + ")";
                String col = "(" + value + ")" + j;
                String grid = (i/3) + "(" + value +")" +(j/3);
                
                if(seen.containsKey(row) || seen.containsKey(col) || seen.containsKey(grid))
                {
                    isValidSudoku = false;
                    break;
                }
                else
                {
                    seen.put(row,true);
                    seen.put(col,true);
                    seen.put(grid,true);
                }
            }
            if(!isValidSudoku) break;
        }
        
        System.out.println("Sudoku is valid: "+isValidSudoku);
    }
}