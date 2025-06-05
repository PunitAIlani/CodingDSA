/*
Given a "k sorted array" return the fully sorted version of the sequence.

A "k sorted array" is a sequence whose elements are no more than k positions left or right from their position in the fully sorted sequence

Input: 
k = 2
[3, 4, 1, 2, 5]

Distances from final sorted position:
1: 2 positions right
2: 2 positions right
3: 2 positions left
4: 2 positions left
5: 0 positions away

Output: [1, 2, 3, 4, 5]
*/
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
class Main {
    public static void main(String[] args) {
        Main mObj = new Main();
        int k = 2;
        int[] arr = {3,4,1,2,5};
        mObj.sortArrayEffeciently(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sortArrayEffeciently(int[] arr, int k)
    {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<=k && i<arr.length; i++)
        {
            minHeap.add(arr[i]);
        }
        int index = 0;
        for(int i=k+1; i<arr.length; i++)
        {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        
        while(!minHeap.isEmpty())
        {
            arr[index++] = minHeap.poll();
        }
    }
    
}