package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public int robotPath(int[][] room, int[] src, int[] dst) {
        // 문제개요
        // 장애물이 있는 room에서 최소경로를 찾아서 src에서 dst로 도착해야한다.
        // 주의 해야할 것
        // 왔던길을 어떻게 하면 다시 안가는가?
        // 장애물을 어떻게 피할 것인가?
        // 최소경로로 어떻게 갈 것인가?
        // 최소길이를 어떻게 기록할 것인가?
        // 위 네가지를 주의해서 풀어야한다.

        // 수도 코드
        // 1. 재귀함수를 호출한다.
        // 이때, '1'은 로봇의 출발위치에 다시 오지 않기 위해서 체크하는 것이다.
        room = tMap(room.length,room[0].length,1,src,room);

        // 2. 결과는 로봇이 room의 목적지에 왔을때, 이동횟수를 반환하면 된다.
        // 이때, -1을 하는 이유는 로봇이 출발위치에서 이동하지 않았는데, 다시오지 않게 하기위해
        // 1로 기록을 해놨기 때문이다.
        return room[dst[0]][dst[1]]-1;
    }
    public int[][] tMap(int M, int N, int time, int[] src, int[][] room){
        // 3. 현재 room에서 로봇위치를 나타낼것이다.
        int row = src[0];
        int col = src[1];

        // 4. 로봇이 room을 이탈할 경우 아무 작업도 하지 않게 그 레벨 재귀를 끝낸다.
        if(row<0||row>M-1||col<0||col>N-1){
            return room;
        }

        // 5. 로봇이 재방문하거나 최소경로인 곳을 가게 되면, 현재 step으로 바꾼다.
        // 여기서 최소경로인 곳이라는 것은, 목표 지점에 왔을때, 다른 재귀를 통해 온
        // 시간이 10이고, 최소경로가 8이면, 8로 변경되어야함을 의미한다.
        if(room[row][col]==0||room[row][col]>step){
            room[row][col]=step;
        }else{
            return room;
        }

        tMap(M,N,new int[]{row-1,col},step+1,room);//상
        tMap(M,N,new int[]{row+1,col},step+1,room);//상
        tMap(M,N,new int[]{row,col-1},step+1,room);//좌
        tMap(M,N,new int[]{row,col+1},step+1,room);//우

        return room;
    }
    public static void main(String[] args) {
        Solution test = new Solution();
        // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
        System.out.println(test.powerSet("jump"));
        System.out.println(test.powerSet("bca"));
        System.out.println(test.powerSet("7491"));
        System.out.println(test.powerSet("lion"));

    }
}
