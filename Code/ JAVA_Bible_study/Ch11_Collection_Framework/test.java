package Ch11_Collection_Framework;
import java.util.*;
public class test {
    // naive solution: O(2^N)
    // 2 x 4 보드에 타일을 놓는 방법은 5가지다.
    // 각 타일을 a, b, c, d로 구분한다.
    // 아직 타일이 놓이지 않는 부분은 -로 표기한다.
    // 타일을 놓는 방법은 가장 왼쪽부터 세로로 놓거나 가로로 놓는 것으로 시작한다.
    // 1) 세로로 놓는 법
    //   2 | a - - -
    //   1 | a - - -
    //   ------------
    // 2) 가로로 놓는 법
    // 타일을 가로로 놓게 되면, 그 바로 아래에는 가로로 놓을 수 밖에 없다.
    //   2 | a a - -
    //   1 | b b - -
    //   ------------
    // 이때, 타일이 아직 놓이지 않은 부분은 사실 크기만 다를뿐 같은 종류의 문제라는 것을 알 수 있다.
    // 즉, 2 x 4 보드에 타일을 놓는 방법은 아래 두 가지 방법을 더한 결과와 같다.
    //  1) 2 x 3 보드에 타일을 놓는 방법
    //  2) 2 x 2 보드에 타일을 놓는 방법
    // 따라서 2 x n 타일 문제는 아래와 같이 재귀적으로 정의할 수 있다.
    // 주의: 재귀적 정의에는 항상 기초(base), 즉 더 이상 재귀적으로 정의할 수 없는(쪼갤 수 없는) 문제를 별도로 정의해야 한다.
//    public int tiling(int num) {
//     if (num <= 2) return num;
//     return tiling(num - 1) + tiling(num - 2);
//   }

    // dynamic with memoization: O(N)
    public int tiling(int num) {
        // 인덱스를 직관적으로 관리하기 위해
        // 앞 부분을 의미없는 데이터(dummy)로 채운다.
        ArrayList<Integer> memo = new ArrayList<>(Arrays.asList(0,1, 2));
        return aux(num, memo);
    };

    // 재귀를 위한 보조 함수(auxiliary function)을 선언)

    public int aux(int size, ArrayList<Integer> memo) {
        // 이미 해결한 문제는 풀지 않는다.
        if(memo.size() > size) return memo.get(size);
//    if (memo[size] !== undefined) return memo[size];
//    if (size <= 2) return memo[n];
        memo.add(aux(size - 1, memo) + aux(size - 2, memo));
        return memo.get(size);
//    memo[size] = aux(size - 1) + aux(size - 2);
//    return memo[size];
    }

    public static void main(String[] args) {
        test t =new test();
        t.tiling(10);
        System.out.println("t.tiling(10) = " + t.tiling(10));
    }
}
