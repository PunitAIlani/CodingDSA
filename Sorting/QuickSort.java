/*
Quick sort
The algorithm complexity is based on pivot
A good pivot or an average pivot results into a O(nlog(n)) complexity, the best pivot is the median value of the search space
A bad pivot complexity is O(n^2) A bad pivot is smallest or the largest element, that results into a skew recurssion tree
*/

import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        Main mObj = new Main();
        int[] arr = {5,4,1,3,2};
        
        mObj.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void quickSort(int[] arr)
    {
         quickSortHelper(arr, 0, arr.length-1);
    }
    
    public static void quickSortHelper(int[] arr, int left,int right)
    {
        if(left>right) return;
        int pivotIndex = partition(arr, left, right);
        quickSortHelper(arr, left, pivotIndex -1);
        quickSortHelper(arr, pivotIndex + 1, right);
    }
    
    public static int partition(int[] arr, int left, int right)
    {
        int i = left -1;
        int pivot = arr[right];
        for(int j = left; j<right; j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,right);
        return i+1;
    }
    
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
}