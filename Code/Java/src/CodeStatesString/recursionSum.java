package CodeStatesString;

public class recursionSum {
    public int arrSum(int[]arr){
        if(arr.length==0){
            return 0;
        }
        return arr[0]+arrSum(arr);
    }

    public static void main(String[] args) {
        recursionSum s = new recursionSum();
        int [] arr = {1,2,3,4,5};
        System.out.println(s.arrSum(arr));
    }
}
