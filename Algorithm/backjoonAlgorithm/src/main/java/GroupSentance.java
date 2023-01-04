import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupSentance {
    public static boolean groupChecker(String input){
        boolean [] check = new boolean[26];
        int prev = 0;
        for(int i=0;i<check.length;i++){
            check[i]=true;
        }
        for(int i=0;i<input.length();i++){
            if(prev!=input.charAt(i)){
                if(check[input.charAt(i)]){
                    check[input.charAt(i)]=false;
                    prev = input.charAt(i);
                }else{
                    return false;
                }
            }else{
                continue;
            }
        }
        return true;
    }

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count =0;

        for(int i=0;i<N;i++){
            if(groupChecker(br.readLine())){
                count++;
            }
        }
        System.out.print(count);
    }
}
