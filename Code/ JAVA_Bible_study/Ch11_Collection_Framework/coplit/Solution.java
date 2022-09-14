package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int[] quickSort(int[] arr) {
        // TODO:
        // [5,4,3,2,1],0,4
        return pivot_sort(arr, 0,arr.length-1);
    }

    public int[] pivot_sort(int [] arr, int low, int high){
        if(low>=high){
            return arr;
        }

        int pivot = partition(arr,low,high);

        pivot_sort(arr,low,pivot-1);
        pivot_sort(arr,pivot+1,high);

        return arr;
    }

    public static int partition(int [] arr, int left, int right){
        int low = left; //0
        int high = right;//4 2
        int pivot = arr[left];//5 4

        while(low<high){

            while(arr[high]>pivot&&low<high){
                high--;
            }

            while(arr[low]<=pivot&&low<high){
                low++;
            }
            swap(arr,low,high);
        }
        swap(arr,left,low);

        return low;
    }

    public static int [] swap(int[]arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
        }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] arr = new int[]{5,3,8,9,2,4,7};
        int[] result = test.quickSort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }
}
