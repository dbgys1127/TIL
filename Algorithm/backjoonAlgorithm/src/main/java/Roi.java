import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Roi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int round = Integer.parseInt(br.readLine());
        int [] src = new int[round];
        int [] std = new int[round];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<round;i++){
            src[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<round;i++){
            for(int j=0;j<round;j++){
                if(src[i]>src[j]){
                    std[i]++;
                }
            }
            sb.append(std[i]).append(" ");
        }
        System.out.print(sb);
    }
}
