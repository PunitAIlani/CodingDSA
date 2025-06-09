
import java.util.*;
class Main {
    public static void main(String[] args) {
       
        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        
        Main mObj = new Main();
        mObj.spiralTraversal(arr);
    }
    
    public void spiralTraversal(int[][] arr)
    {
        int top = 0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr[top].length-1;
        
        List<Integer> output = new ArrayList<>();
        while(top<=bottom && left<=right)
        {
            for(int col = left; col<=right; col++)
            {
                output.add(arr[top][col]);
            }
            top++;
            
            for(int row=top; row<=bottom; row++)
            {
                output.add(arr[row][right]);
            }
            right--;
            
            if(top<=bottom)
            {
                for(int col=right; col>=left; col--)
                {
                    output.add(arr[bottom][col]);
                }
                bottom--;
            }
            
            if(left<=right)
            {
                for(int row = bottom; row>=top; row--)
                {
                    output.add(arr[row][left]);
                }
                left++;
            }
        }
        
        System.out.println(output);
    }
}