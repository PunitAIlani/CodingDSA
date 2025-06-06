/*
The 3-Sum Problem
Given an array of n integers, return all unique triplets [a,b,c] in the array such that a + b + c = 0.
Input: 
[-3, -1, 1, 0, 2, 10, -2, 8]

Output: 
[
 [-3, 1, 2],
 [-2, 0, 2],
 [-1, 0, 1]
]

Input: 
[-5, 3, 2, 0, 1, -1, -5, 3, 2]

Output: 
[
 [-5, 2, 3],  # the same triplet is not duplicated
 [-1, 0, 1]
]

*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        Main mObj = new Main();
        int[] arr = {-3,-1,1,0,2,10,-2,8};
        
        Set<List<Integer>> set = new HashSet<>();
        
        mObj.findThreeSum(set, arr);
        System.out.println(set);
        
        //arraylist consturctor takes the set and can build it to desired type Experimented
        List<List<Integer>> list = new ArrayList<>(set);
        System.out.println(list);
    }
    
    public void findThreeSum(Set<List<Integer>> set, int[] arr)
    {
        Arrays.sort(arr);
        
        int secondToLastIndex = arr.length -2;
        
        for(int i=0; i<secondToLastIndex; i++)
        {
            findTwoSum(i, set, arr);
        }
    }
    
    public void findTwoSum(int rootIndex, Set<List<Integer>> set, int[] arr)
    {
        int left = rootIndex + 1;
        int right = arr.length - 1;
        
        while(left<right)
        {
            int threeSum = arr[rootIndex] + arr[left] + arr[right];
            
            if(threeSum == 0)
            {
                set.add(Arrays.asList(arr[rootIndex], arr[left++], arr[right--]));
            }
            else if(threeSum < 0)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}