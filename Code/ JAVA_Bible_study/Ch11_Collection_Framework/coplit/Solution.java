package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int[] radixSort(int[] arr) {
        // TODO:
        // 계수정렬 먼저

        // 나머지 0~9를 그룹화 시킬수 있는 바구니 준비
        // Queue로 만들어야 같은 그룹에서 FIFO로 요소를 꺼내 데이터에 저장할 수 있다.
        Queue<Integer>[] bucket = new LinkedList[10];
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new LinkedList<>();
        }

        //나머지를 그룹화 시키기 위해 1, 10, 100으로 나누는 것을 반복할 껀데 그때 분모가 된다.
        int factor =1;

        // 정렬할 자릿수 크기 만큼 반복한다.
        // 그전에 자릿수를 구하기 위한 알고리즘이 필요하다.
        // 우선 최대값을 찾는다.
        int digit = findDigit(arr);

        // 구한 자릿수 만큼 반복하는 반복문을 만든다.
        for(int d = 0; d<digit;d++){
            for(int i=0;i<arr.length;i++){
                bucket[(arr[i]/factor)%10].add(arr[i]);
            }
            for(int i=0,j=0;i<bucket.length;i++){
                while(!bucket[i].isEmpty()){
                    arr[j++]=bucket[i].poll();
                }
            }
            factor*=10;
        }
        return arr;
    }
    public static int findDigit(int[] arr){
        int max =arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int digit = 0;
        while(max>0){
            max/=10;
            digit++;
        }
        return digit;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] arr = new int[]{28,193,239,81,62,72,38,26};
        int[] result = test.radixSort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }
}
