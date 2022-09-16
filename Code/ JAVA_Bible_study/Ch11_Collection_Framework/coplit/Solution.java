package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int[] insertionSort(int[] arr) {
        // TODO:
        int target = 1;
        int prev = 0;
        for(int i=1;i<arr.length;i++){
            arr=sort(arr,i-1,i);
        }
        return arr;
    }
    public int [] sort(int[] arr, int prev, int target){
        if(prev<0)
            return arr;

        // 비교 로직

        if(arr[prev]>arr[target]){
            int tmp = arr[prev];
            arr[prev]=arr[target];
            arr[target]=tmp;
        }
        sort(arr,prev-1,target-1);
        return arr;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] arr = new int[]{-11,-10,2,20,29};
        int[] result = test.insertionSort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }
}
