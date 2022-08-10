package Ch11_Collection_Framework;
import java.util.*;
public class test {
    public String compressString(String str) {
        // TODO:
        // 문제개요
        // 문자열을 입력받아 연속되는 문자가 3번이상 반복되면
        // 1개로 압축시킨다. aaaaaabbccc->abbc
        // 1~2개는 압축이 안된다.
        // 빈 문자열은 빈문자열을 리턴한다.
        // 문자를 쪼개서 배열에 저장하고, 같은 것에 대한 카운트를 한다.

        // 수도코드
        // 1. 문자 배열을 만든다.
        char [] storage = new char [str.length()];
        String result ="";
        // 2. 카운트용 변수를 만든다.
        int count = 1;

        // 3. 빈문자열은 빈 문자로 반환
        if(str.length()==0)
            return "";

        // 4. 배열에 str을 char단위로 쪼게자
        for(int i=0;i<str.length();i++)
            storage[i]=str.charAt(i);

        String tmp ="";
        // 5. 압축과 관련된 반복문을 만든다.
        for(int i=1;i<storage.length;i++){
            tmp+=storage[i-1];
            if(storage[i-1]==storage[i]){
                ++count;
                if(i==storage.length-1){
                    result+=tmp+storage[i];
                }
            }else{
                if(count>=3){
                    result+=String.valueOf(count)+storage[i-1];
                    count=1;
                    tmp="";
                }else{
                    if(i==storage.length-1){
                        result+=storage[i];
                    }
                    result+=tmp;
                    count=1;
                    tmp="";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        test t =new test();
        System.out.println( t.compressString("EQTWVOQQQVDVRC"));
    }
}
