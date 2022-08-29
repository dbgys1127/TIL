package Ch11_Collection_Framework;
import java.util.*;
public class test {
    public int rotatedArraySearch(int[] rotated, int target) {
        // TODO:
        Arrays.sort(rotated);
        int idx = Arrays.binarySearch(rotated,target);
        return idx;
    }

    public static void main(String[] args) {
        test t =new test();
        int [] arr = new int []{4,5,6,0,1,2,3};
        System.out.println("t.tiling(10) = " + t.rotatedArraySearch(arr,2));
    }
}
