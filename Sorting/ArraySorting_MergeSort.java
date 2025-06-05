
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        
        Main mObj = new Main();
        int[] arr = {5,2,3,1,4};
        
        mObj.mergeSortArray(arr,0, arr.length-1);
        //Print Array using Helper function instead of explicit loop
        System.out.println(Arrays.toString(arr));
    }
    
    public static void mergeSortArray(int[] arr, int left, int right)
    {
        if(left>=right ) return;
        int mid =  left + (right - left) /2;
        mergeSortArray(arr, left, mid);
        mergeSortArray(arr, mid+1, right);
        merge(arr,left, mid , right);
    }
    
    public static void merge(int[] arr,int left, int mid, int right)
    {
        int length = right - left + 1;
        int[] B = new int[length];
        
        int idx1 = left;
        int idx2 = mid + 1;
        int idx = 0;
        while(idx1<=mid && idx2<=right)
        {
            if(arr[idx1]<=arr[idx2])
            {
                B[idx] = arr[idx1];
                idx++;
                idx1++;
            }
            else
            {
                B[idx] = arr[idx2];
                idx++;
                idx2++;
            }
        }
        
        while(idx1<=mid)
        {
            B[idx] = arr[idx1];
            idx++; 
            idx1++;
        }
        
        while(idx2<=right)
        {
            B[idx] = arr[idx2];
            idx++;
            idx2++;
        }
        
        for(int i =0,j=left; i<B.length; i++,j++)
        {
            arr[j] = B[i];
        }
    }
}