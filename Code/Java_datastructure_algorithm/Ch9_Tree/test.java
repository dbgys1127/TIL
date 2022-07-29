package Ch9_Tree;
import java.util.*;
public class test {
    public int removeExtremes(int[] stuff,int limit) {
        // TODO:
        // 문제개요
        // 짐을 싸야하는데, 박스에는 최대 2개 짐을 넣을 수 있고
        // 무게 제한도 있다.
        // 박스를 최소한 사용해서 짐을 싸라
        // stuff 배열에는 짐의 각각의 무게가
        // limit에는 한 박스에 담을 수 있는 무게 제한이 제시된다.
        // 위 조건에 맞게 박스를 싼 후 몇개의 박스을 썻는지 정수형 타입으로 반환 하라

        // 주의 사항
        //1. 짐의 개수 즉, stuff.length<=500000 다시 말해 stuff 인덱스는 최대 499999이다.
        //2. 박스의 무게제한은 항상 짐의 무게 중 최대값보다 크지않아 쪼겔 필요는 없다.
        //3-1-1. i  번째가 stuff의 모든 요소와 더한후 limit 보다 이하인지 파악하고 그중 가장 큰 합을 맞춘 짝꿍의 인덱스를 알아서
        //i와 그 인덱스를 짤라야한다.

        //수도코드
        //1. 해당하는 짐조합이 있는지 판단하는 기준이 필요
        //2. 배열을 ArrayList에 저장한다.->나중에 추가와 삭제를 편리하게 하기 위함이다.
        ArrayList<Integer> loadsList = new ArrayList<>();
        for(int i=0;i<stuff.length;i++)
            loadsList.add(i,stuff[i]);
        //2. 모든 요소간 합을 위해 중첩 반복문을 쓴다.
        for(int i=0;i<loadsList.size()-1;i++){
            //3. 요소간 합의 최대값과 그 인덱스를 저장할 변수가 필요하다.
            int max=0;
            int maxIdx=0;
            boolean TF=false;
            for(int j=i+1;j<loadsList.size();j++){
                //4. 요소간의 합이 limit이하인지 파악한다.
                int sumLoads = loadsList.get(i)+loadsList.get(j);
                if(sumLoads<=limit){
                    //5. 이때, max 보다 크면, 그 값과 인덱스를 기억한다.
                    if(max<sumLoads){
                        max=sumLoads;
                        maxIdx=j;
                        TF=true;
                    }
                }
            }
            //6. 원래, list에서 i와, j를 지우고, 맨처음에 짐의 무게범위를 넘는 집을 넣는다.
            // 여기 두면 한개도 없을때도 빼려고 한다.
            if(TF){
                loadsList.remove(i);
                loadsList.remove(maxIdx-1);
                loadsList.add(0,250);
            }
        }
        return loadsList.size();
    }

    public static void main(String[] args) {
        test t = new test();
        int output = t.removeExtremes(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output); // --> ["a"', "b"]
    }
}
