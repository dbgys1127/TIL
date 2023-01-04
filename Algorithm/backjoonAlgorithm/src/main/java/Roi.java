import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Roi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i=0;i<round;i++){
            int num = Integer.parseInt(st.nextToken());
            if((num==2)||(num==3)){
                count++;
            }else if(num==1){
                continue;
            }else if(((num%2)!=0)&&((num%3)!=0)){
                count++;
            }
        }
        System.out.print(count);
    }
}
