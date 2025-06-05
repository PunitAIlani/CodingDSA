/*
Given a list of intervals A, return a new list with each overlapping intervals merged.

Note On Equivalent Boundaries: If an end-point and start-point of 2 intervals are equivalent (ex: [10, 11], [11, 12]) then the intervals also overlap.

Input: [[1, 4], [1, 5]]

|--|--|--|--|--|--|--|--|--|--|--|--|--|--|

x========x
x===========x

Output: [1, 5]

|--|--|--|--|--|--|--|--|--|--|--|--|--|--|

x===========x

Explanation: The intervals [1, 4] and [1, 5] are overlapping, so they are merged to a single interval.
*/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
class Main {
    public static void main(String[] args) {
        Main mObj = new Main();
        int[][] arr = {{1,4}, {1,5}};
        
        int[][] mergedInterval = mObj.mergeIntervals(arr);
        
        for(int[] a: mergedInterval)
        {
            System.out.print(Arrays.toString(a)+" ");
        }
    }
    
    public static int[][] mergeIntervals(int[][] arr)
    {
        if(arr.length<=1) return arr;
        Arrays.sort(arr, new TwoDimesionalComparator());
        
        List<int[]> mergedIntervalsList = new ArrayList<>();
        int[] currentInterval = arr[0];
        
        for(int i=1; i<arr.length; i++)
        {
            int start = arr[i][0];
            int end = arr[i][1];
            
            if(start<=currentInterval[1])
            {
                currentInterval[1] = Math.max(end, currentInterval[1]);
            }
            else
            {
                mergedIntervalsList.add(currentInterval);
                currentInterval = new int[]{start, end};
            }
        }
        mergedIntervalsList.add(currentInterval);
        return convert2DArray(mergedIntervalsList);
    }
    
    public static int[][] convert2DArray(List<int[]> list)
    {
        if(list.size()==0) return new int[0][0];
        
        int[][] arr = new int[list.size()][list.get(0).length];
        for(int i=0; i<arr.length; i++)
        {
            arr[i] = list.get(i);
        }
       
        return arr;
    }
    
}
class TwoDimesionalComparator implements Comparator<int[]>{
    public int compare(int[] a, int[] b)
    {
        return a[0] - b[0];
    }
}