package Ch11_Collection_Framework;
import java.util.*;
public class test {
    public int numberSearch(String str) {
        // TODO:
        // 문제개요
        // 입력받은 str에서 숫자들의 합이 분자가 된다.
        // 입력받은 str에서 숫자와 공백을 제외가 문자열의 길이를 분모로 한다.
        // 둘을 나눈 값을 리턴한다.

        // 수도코드
        // 1. 빈 문자열은 0을 리턴한다.
        if(str.length()==0)
            return 0;

        // 2. 분자는 어떻게 구할까?
        // 2-1.문자열을 charAt해서 그것이 아스키 코드 상 48<=x<=57 사이에 있는지 판단해서 그렇다면,
        // 2-2. sum 변수에 Character.getNumericValue(char)를 += 한다.
        int sum = 0;
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(48<=ch && ch<=57)
                sum += Character.getNumericValue(ch);
        }
        // 3-1. 숫자와 공백을 모두 문자열에서 뺀다.
        String resultStr = "";
        resultStr = str.replaceAll("[0-9]","");
        resultStr = resultStr.replaceAll(" ","");
        double strLen = resultStr.length();
        double result = sum/strLen;
        return (int)Math.round((result*10)/10.0);
    }

    public static void main(String[] args) {
        test t =new test();
        t.numberSearch("Sou2bgPJkS7Lp5r2j6jeWOts8X");
        System.out.println( t.numberSearch("Sou2bgPJkS7Lp5r2j6jeWOts8X"));
    }
}
