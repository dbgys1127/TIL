package Ch9_Tree;
import java.util.*;
public class test {
    public String[] removeExtremes(String[] arr) {
        // 수도코드
        // 1. 공백을 입력받을 경우, null을 반환한다.
        if(arr.length==0)
            return null;
        // 2. 각 문자열의 길이를 저장할 정수형 배열을 만들자. 배열의 크기는 arr 배열의 크기 만큼으로 설정
        ArrayList<Integer> storageLen = new ArrayList<>();

        // 3. storageLen에는 arr[i]의 크기를 전부 저장하자. 반복문으로 크기를 전부 저장하자
        for(int i=0;i<arr.length;i++)
            storageLen.add(i,arr[i].length());

        // 4. max, min 변수를 선언한다. 이때, max와 min에는 최대길이가 아닌 최대길이가 있는 위치를 저장한다.
        int max = 0;
        int min = 20;
        int minIdx = 0;
        int maxIdx = 0;
        // 5-1. max인지 파악하기 위해 반복문을 돌리는데, arr[i].length()가 max보다 크면 바꾸는 방식으로 간다.
        // 5-2. 이때 길이가 중복인게 있다면, 나중에 위치에 있는 문자열의 인덱스를 저장해야한다.->조건을 max<"="arr[i].lenght()하면된다.
        for(int i=0;i<storageLen.size();i++){
            if(max<=storageLen.get(i)){
                max=storageLen.get(i);
                maxIdx = storageLen.indexOf(max);
            }
        }
        // 6-1. min인지 파악하기 위해 반복문을 돌리는데, arr[i].length()가 min보다 작으면 바꾸는 방식으로 간다.
        // 6-2. 이때 길이가 중복인게 있다면, 나중에 위치에 있는 문자열의 인덱스를 저장해야한다.->조건을 min>"="arr[i].length()하면된다.
        for(int i=0;i<storageLen.size();i++){
            if(min>=storageLen.get(i)){
                min=storageLen.get(i);
                minIdx = storageLen.indexOf(min);
            }
        }

        // 7. 이제 인자로 받은 배열의 중간을 삭제, 추가 할수있는 ArrayList를 만들어서 여기에 arr[i]들을 저장하자.
        ArrayList<String> preresult = new ArrayList<>(Arrays.asList(arr));

        // 8-1. min과 max 인덴스 값을 제거한다.
        // 8-2. 근데 이때 주의해야 할 것은 무언가 하나 제거하면, 제거한 자리뒤에 있는 것들이 한칸씩 앞으로 댕긴다는 것이다.
        // 8-3. 그럼 min과 max중 누가 앞에 있는지를 따져야 한다. 만약 min<max 이라면, max-1의 값을 제거 해야하고, 반대도 마찬가지다.
        // 8-4. 따라서 if문으로 먼저 시작한다.
        if(minIdx<maxIdx){
            preresult.remove(minIdx);
            preresult.remove(maxIdx-1);
        }else {
            preresult.remove(maxIdx);
            preresult.remove(minIdx-1);
        }
        // 9. 끝으로 ArrayList를 다시 배열로 만들어야한다.
        String [] result = new String[preresult.size()];
        for(int i =0; i<result.length;i++) {
            result[i] = preresult.get(i);
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        test t = new test();
        String[] output = t.removeExtremes(new String[]{"a", "c", "def"});
        System.out.println(output); // --> ["a"', "b"]
    }
}
