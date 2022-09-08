package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int[][] rotateMatrix(int[][] matrix, int K) {
        // TODO:
        // 문제개요
        // 정사각형 이차원 배열을 1회마다 90도씩 시계방향으로 꺽는 문제다.
        // 근데 여기서, 90씩 일정한 방향이면,
        // 4의 나머지에 따라 배열을 그룹화 할 수 있게된다.

        // 수도 코드
        if(matrix == null || matrix.length == 0) return matrix;
        // 1. K를 4로 나눈 나머지를 저장하는 변수를 만든다.
        int group = K%4;
        // 2. 행열을 구해주는 함수로 보낸후 거기서 받은 값으로 제출한다.
        return rotateRectangle(matrix,group);
    }
    public int[][] rotateRectangle(int[][]matrix,int group){
        int[][] resultMatrix = new int [matrix.length][matrix[0].length];

        switch(group){
            case 0: return matrix;
            case 1:
                for(int i=0;i<matrix.length;i++){
                    int k = matrix[0].length-1;
                    for(int j=0;j<matrix[0].length;j++){
                        resultMatrix[i][j]=matrix[k][i];
                        k--;
                    }
                }
                break;
            case 2:
                int l = matrix.length-1;
                for(int i=0;i<matrix.length;i++){
                    int k = matrix[0].length-1;
                    for(int j=0;j<matrix[0].length;j++){
                        resultMatrix[i][j]=matrix[l][k];
                        k--;
                    }
                    l--;
                }
                break;
            case 3:
                int q = matrix.length-1;
                for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix[0].length;j++){
                        resultMatrix[i][j]=matrix[j][q];
                    }
                    q--;
                }
                break;
        }
        return resultMatrix;
    }
    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K =121;
        int[][] result = test.rotateMatrix(matrix, K);
        for(int i=0;i<result.length;i++){
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}
