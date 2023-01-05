import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Roi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] prime = new boolean[246913];
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count =0;
        prime[0]=prime[1]=true;

        for(int i=2;i<Math.sqrt(246912);i++){
            if(prime[i]==true){
                continue;
            }
            for(int j=i*i;j<246913;j+=i){
                prime[j]=true;
            }
        }

        while(n!=0){
            int m =2*n;
            for(int i=n;i<=m;i++){
                if(!prime[i]){
                    count++;
                }
            }
            sb.append(count).append('\n');
            count=0;
            n = Integer.parseInt(br.readLine());
        }
        System.out.print(sb);
    }
}
