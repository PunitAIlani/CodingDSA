//count number of Inversions:
/*
Given an array A[], we call a pair of indices (i, j) an inversion provided that both i < j and A[i] > A[j] hold.

Count the number of inversions in the provided array.

Input: [3, 1, 2]
Output: 2
Explanation: The pairs (0, 1) and (0, 2) are inversions since they satisfy the provided definition. There are no other inversions in this array.
*/

/*
This can be solved using merge sort in O(n*log(n)) complexity
Invresion is a pair where Index i < j which means if we are sorting for ascending order then If I pick the 
element from right sub array then all the elements waiting in left sub array to be sorted forms a pair of inversion with this element from right.
*/

class Main {
    public static void main(String[] args) {
        Main mObj = new Main();
        int[] arr = {3,1,2};
        int count = mObj.countNoOfInversions(arr);
        System.out.println(count);
    }
    
    public static int countNoOfInversions(int[] arr)
    {
        return countNoOfInversionsHelper(arr, 0, arr.length-1);
    }
    
    public static int countNoOfInversionsHelper(int[] arr, int left, int right)
    {
        if(left>=right) return 0;
        int mid = left + (right - left) /2;
        int inversion = 0;
        inversion += countNoOfInversionsHelper(arr, left, mid);
        inversion += countNoOfInversionsHelper(arr, mid+1, right);
        inversion += merge(arr, left, mid, right);
        return inversion;
    }
    
    public static int merge(int[] arr, int left, int mid, int right)
    {
        int idx1 = left;
        int idx2 = mid + 1;
        int idx = 0;
        int[] B = new int[right-left+1];
        int inversions = 0;
        while(idx1<=mid && idx2<=right)
        {
            if(arr[idx1] <= arr[idx2]){
                B[idx] = arr[idx1];
                idx++;
                idx1++;
            }
            else
            {
                B[idx] = arr[idx2];
                idx++;
                idx2++;
                inversions += mid - idx1 + 1;
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
        for(int i = left; i<=right; i++)
        {
            arr[i] = B[i-left];
        }
        return inversions;
    }
}