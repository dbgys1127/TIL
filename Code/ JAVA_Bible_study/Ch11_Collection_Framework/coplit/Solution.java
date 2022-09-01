package Ch11_Collection_Framework.coplit;

import java.util.*;

public class Solution {
    public ArrayList<String> powerSet(String str) {
        // TODO:
        // 문제개요
        // str의 문자열의 각 문자를 갖고 만들 수 있는 모든 부분집합을 리턴해라
        // 중복된 원소는 허용하지 않는다.
        // 부분집합의 원소 개수는 문자열에서 중복된 요소를 제거한 개수를 n이라고 하면
        // 2^n 이된다.

        // 수도코드
        // 1. str을 문자열 배열에 저장한다.
        String [] arr = str.split("");

        // 2. str의 문자를 중복없이 새로 저장한다.
        Set set = new HashSet();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        // 3. 결과를 담을 ArrayList를 만든다.
        ArrayList<String> storage = new ArrayList<>();

        // 4. set에 담기 문자들을 정렬한다.
        ArrayList<String> arrayList = new ArrayList(set);
        Collections.sort(arrayList);

        // 5. 재귀를 만들기 전에 set의 각 요소를 방문했는지 여부를 나타내는 배열을 만든다.
        boolean visited[] = new boolean[arrayList.size()];
        Arrays.fill(visited,false);

        int end = set.size();

        // 6. 재귀 함수에 인자를 전달하고, 재귀함수의 결과를 리턴한다.
        ArrayList<String> result = doPowerSet(arrayList, storage, visited, 0, end);
        Collections.sort(result);
        return  result;
    }
    // 7. 재귀 함수를 만든다.
    public static ArrayList<String> doPowerSet(ArrayList<String> arrayList,
                                               ArrayList<String> storage,boolean[] visited,int count, int end){

        if(count>=end){
            String str = "";
            for(int i=0;i<end;i++){
                if(visited[i]){
                    str+=arrayList.get(i);
                }
            }
            storage.add(str);
            return storage;
        }
        visited[count]=false;
        doPowerSet(arrayList,storage,visited,count+1,end);
        visited[count]=true;
        doPowerSet(arrayList,storage,visited,count+1,end);
        return storage;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
        System.out.println(test.powerSet("jump"));
        System.out.println(test.powerSet("bca"));
        System.out.println(test.powerSet("7491"));
        System.out.println(test.powerSet("lion"));

    }
}
