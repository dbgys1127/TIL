package Ch9_Tree;
import java.util.Scanner;

class BinTreeTester {
    static Scanner stdIn = new Scanner(System.in);

    //--- 데이터(회원 번호＋이름) ---//
    static class Data {
        public static final int NO   = 1;    // 번호를 읽어 들일까요?
        public static final int NAME = 2;    // 이름을 읽어 들일까요?

        private Integer no;                // 회원번호(키값)
        private String  name;              // 이름

        //--- 키값 ---//
        Integer keyCode() {
            return no;
        }

        //--- 문자열 표현을 반환 ---//
        public String toString() {
            return name;
        }

        //--- 데이터를 읽어 들임 ---//
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호  ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름  ");
                name = stdIn.next();
            }
        }
    }

    //--- 메뉴 열거형 ---//
    enum Menu {
        ADD(      "삽입"),
        REMOVE(   "삭제"),
        SEARCH(   "검색"),
        PRINT(    "표시"),
        TERMINATE("종료");

        private final String message;        // 표시할 문자열

        static Menu MenuAt(int idx) {        // 순서가 idx번째인 열거를 반환
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {                // 생성자(constructor)
            message = string;
        }

        String getMessage() {                // 표시할 문자열을 반환
            return message;
        }
    }

    //--- 메뉴 선택 ---//
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values())
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // 메뉴
        Data data;                                // 추가용 데이터 참조
        Data ptr;                                 // 검색용 데이터 참조
        Data temp = new Data();                   // 입력용 데이터
        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()) {
                case ADD :              // 노드 삽입
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE :           // 노드 삭제
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH :           // 노드 검색
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.keyCode());
                    if (ptr != null)
                        System.out.println("그 번호의 이름은 " + ptr + "입니다.");
                    else
                        System.out.println("해당 데이터가 없습니다.");
                    break;

                case PRINT :            // 전체 노드를 키값의 오름차순으로 표시
                    tree.print();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
