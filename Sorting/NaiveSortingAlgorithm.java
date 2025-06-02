import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1, 4};
        
        Main mObj = new Main();
        //mObj.sortWithBubbleSort(arr);
        //System.out.println("Sorted Using Bubble sort "+Arrays.toString(arr));
        
        //mObj.sortWithInsertionSort(arr);
        //System.out.println("Sorted Using Insertion sort "+Arrays.toString(arr));
        
        mObj.sortWithSelectionSort(arr);
        System.out.println("Sorted using Selection sort "+Arrays.toString(arr));
        
    }
    
    public void sortWithBubbleSort(int[] arr)
    {
        for(int i=arr.length-1; i>=1; i--)
        {
            for(int j=1; j<=i; j++)
            {
                if(arr[j-1]>arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    
    public void sortWithInsertionSort(int[] arr)
    {
        for(int i=1; i<arr.length; i++)
        {
            int temp = arr[i];
            int j=i-1;
            for(; j>=0;j--)
            {
                if(temp>arr[j])
                {
                    arr[j+1] = arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
    
    public void sortWithSelectionSort(int[] arr)
    {
        for(int i=arr.length-1;i>=0; i--)
        {
            int index = 0;
            int j = 1;
            while(j<arr.length && j<=i)
            {
                if(arr[j]>arr[index])
                {
                    index = j;
                }
                j++;
            }
            int swapTemp = arr[i];
            arr[i] = arr[index];
            arr[index] = swapTemp;
        }
    }
    
}