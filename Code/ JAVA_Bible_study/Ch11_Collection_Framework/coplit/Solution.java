package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public String spiralTraversal(Character[][] matrix) {
        // TODO:
        StringBuilder result = new StringBuilder();

        spiral(matrix,0,matrix[0].length-1,matrix.length-1,result);

        return result.toString();
    }

    public static void spiral(Character[][] matrix, int init, int x, int y, StringBuilder result){
        int endPoint = matrix.length/2; // 1
        if(init>endPoint){  //init =1 > 1
            return;
        }

        right(matrix,init,x,result); // 0,0 -> 0,3
        down(matrix,x,y,init,result); // 0,3 ->3,3
        left(matrix,x,y,init,result); // 3,3 -> 3,0
        up(matrix,y,init,result); // 3,0 ->1,0
        spiral(matrix,init+1,x-1,y-1,result);
    }
    public static void right(Character[][] matrix, int start,int end, StringBuilder result){
        for(int i=start;i<=end;i++){
            result.append(matrix[start][i]);
        }
    }
    public static void left(Character[][] matrix, int start,int end,int a, StringBuilder result){
        for(int i=start;i>a&&a!= matrix.length/2;i--){
            result.append(matrix[end][i]);
        }
    }

    public static void down(Character[][] matrix, int start,int end,int a, StringBuilder result){
        for(int i=a+1;i<end;i++){
            result.append(matrix[i][start]);
        }
    }
    public static void up(Character[][] matrix, int start,int end, StringBuilder result){
        for(int i=start;i>end;i--){
            result.append(matrix[i][end]);
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        Character[][] matrix = new Character[][]{
//                {'A', 'B', 'C','D','E','F','G','H'},
//                {'R', 'S', 'T','U','V','W','X','I'},
//                {'Q', 'P', 'O','N','M','L','K','J'},
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        System.out.println(test.spiralTraversal(matrix));
    }
}
