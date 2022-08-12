package Ch11_Collection_Framework;
import java.util.*;
public class test {


    public static void main(String[] args) {
        test t =new test();
        int arr[] = {1,2,43,100,100,21};
        for(int i=0;i<arr.length-1;i++){
            int swap =0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap++;
                    int tmp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
            if(swap==0)
                break;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
