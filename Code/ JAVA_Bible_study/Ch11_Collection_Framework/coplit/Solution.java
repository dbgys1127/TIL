package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public String spiralTraversal(Character[][] matrix) {
        // TODO:
        String result = "";

        spiral(matrix,0,matrix[0].length-1,matrix.length-1,result);

        return result;
    }

    public static void spiral(Character[][] matrix, int init, int x, int y, String result){
        int endPoint = matrix.length/2;
        if(init>endPoint){
            return;
        }

        right(matrix,init,x,result); // 0,0 -> 0,3
        down(matrix,x,y,init,result); // 0,3 ->3,3
        left(matrix,x,y,init,result); // 3,3 -> 3,0
        up(matrix,y,init,result); // 3,0 ->1,0
        spiral(matrix,init+1,x-1,y-1,result);
    }
    public static void right(Character[][] matrix, int start,int end, String result){
        for(int i=start;i<=end;i++){
            result+=matrix[start][i];
        }
    }
    public static void left(Character[][] matrix, int start,int end,int a, String result){
        for(int i=end;i>=a;i--){
            result+=matrix[start][i];
        }
    }

    public static void down(Character[][] matrix, int start,int end,int a, String result){
        for(int i=a;i<end;i++){
            result+=matrix[i][start];
        }
    }
    public static void up(Character[][] matrix, int start,int end, String result){
        for(int i=start;i>=end;i--){
            result+=matrix[i][start];
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        System.out.println(test.spiralTraversal(matrix));
    }
}
