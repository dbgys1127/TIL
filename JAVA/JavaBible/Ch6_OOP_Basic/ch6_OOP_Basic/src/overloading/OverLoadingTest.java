package overloading;

public class OverLoadingTest {
    public static void main(String[] args) {
        OverLoadedMethod overLoadedMethod = new OverLoadedMethod();
        int[] a = {100, 200, 300};
        System.out.println("overLoadedMethod.add(3,3) = " + overLoadedMethod.add(3,3));
        System.out.println("overLoadedMethod.add(3L,3) = " + overLoadedMethod.add(3L,3));
        System.out.println("overLoadedMethod.add(3,3L) = " + overLoadedMethod.add(3,3L));
        System.out.println("overLoadedMethod.add(3L,3L) = " + overLoadedMethod.add(3L,3L));
        System.out.println("overLoadedMethod.add(a) = " + overLoadedMethod.add(a));
    }
}

class OverLoadedMethod {
    int add (int a, int b) {
        System.out.print("int add(int,int) - ");
        return a+b;
    }

    long add (long a, int b) {
        System.out.print("int add(long,int) - ");
        return a+b;
    }

    long add (int a, long b) {
        System.out.print("int add(int,long) - ");
        return a+b;
    }

    long add (long a, long b) {
        System.out.print("int add(long,long) - ");
        return a+b;
    }

    int add (int[] a) {
        System.out.print("int add(int[]) - ");
        int result =0;
        for (int i : a) {
            result+=i;
        }
        return result;
    }
}
