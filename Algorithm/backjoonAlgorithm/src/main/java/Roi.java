import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Roi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [][] pan = new int[3][3];
        int std = 99;

        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(std!=0){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(pan[i][j]==std){
                        sb.append(std).append('\n').append(i+1).append(" ").append(j+1);
                        System.out.print(sb);
                        return;
                    }
                }
            }
            std--;
        }
    }
}
