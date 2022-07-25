package CodeStatesString;
import java.util.*;
public class hashsearch {
    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        HashMap<String, String> result = new HashMap<>();
        if(arr.length==0)
            return result;
        for(int i = 0;i<arr.length;i++){
            if(!result.containsKey(arr[i])){
                for(int j = 1;j<arr[i].length;j++){
                    result.put(arr[i][0],arr[i][j]);
                }
            }else
                continue;

        }
        return result;
    }
    public static void main(String[] args) {
        hashsearch g = new hashsearch();
        String[][] arr = new String[][]{
                {"some","like"},
                {"some","dislike"}
        };
        System.out.println(g.convertListToHashMap(arr));

    }
}
