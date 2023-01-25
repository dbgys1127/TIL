import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Roi {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result =0;

        for(int i=1;i<N;i++){
            int one = i%10;
            int ten = (i%100-one)/10;
            int hund = i/100;
            int hap = i + hund+ten+one;
            if(hap==N){
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}
