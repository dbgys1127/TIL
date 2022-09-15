package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int[] quickSort(int[] arr) {
        // TODO:
        return sort(arr,0,arr.length-1);
    }
    public int[] sort(int[] arr, int left, int right){
        if(left>=right){
            return arr;
        }

        int pivot=partition(arr,left,right);
        arr=sort(arr,left,pivot);
        arr=sort(arr,pivot+1,right);

        return arr;
    }
    public int partition(int[] arr, int left, int right){
        int lo = left-1;
        int hi = right+1;
        int pivot = arr[(left+right)/2];

        while(true){
            do{
                lo++;
            }while(arr[lo]<pivot);

            do{
                hi--;
            }while(arr[hi]>pivot);

            if(lo>=hi){
                return hi;
            }

            int temp = arr[lo];
            arr[lo]=arr[hi];
            arr[hi]=temp;
        }
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
