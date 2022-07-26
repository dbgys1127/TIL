package Ch3_SearchAlgorithm;
import java.util.Scanner;
public class SeqSearchSen {
    static int seqSearchSen(int[]a, int n, int key){
        int i=0;
        a[n]=key;

        while(true){
            if(a[i]==key)
                break;
            i++;
        }
        return i==n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수 : ");
        int num = stdIn.nextInt();
        int [] a = new int[num+1];

        for(int i=0;i<a.length;i++){
            System.out.print("a["+i+"] : ");
            a[i]=stdIn.nextInt();
        }
        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int result = seqSearchSen(a,num,key);

        if(result==-1)
            System.out.println("검색한 값이 없습니다.");
        else
            System.out.println("결과 : "+result);
    }
}
