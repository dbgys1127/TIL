package initialize;

/**
 * 초기화 블록
 * 1. 언제 사용 ? 인스턴스가 공통으로 갖고자 하는 변수의 특징이 있을때 사용,
 * 1.1.클래스 초기화 블럭 ->일렬번호 처럼 인스턴스마다 고유 번호를 주고 싶을떄
 * 1.2.인스턴스 초기화 블럭 -> 게임 케릭터 만들때 처럼 전부 레벨 1, 경험치 0으로 맞추고 싶을때
 *
 * 2. 초기화 순서
 * 2.1. 클래스 변수 초기화순서 :
 *
 * 3. 클래스 변수 초기화 순서는 한번만 수행, 인스턴스 초기화는 new로 생성될때 마다
 */
public class InitializeBlockTest {
    //클래스변수 초기화 1번째 cv =0 (기본값으로 초기화)
    //인스턴스 초기화 1번째 iv =0 (기본값으로 초기화)
    static int cv = 1; //클래스변수 초기화 2번째 cv =1 (명시적 초기화)
    int iv =10; //인스턴스 초기화 2번째 iv =10 (명시적 초기화)
    static {
        cv = 2;//클래스변수 초기화 3번째 cv =2 (클래스 초기화 블럭)
        System.out.println("block cv = "+cv);
    }
    {
        iv = 20;//인스턴스 초기화 3번째 iv =20 (인스턴스 초기화 블럭)
        System.out.println("block iv = "+iv);
    }

    public InitializeBlockTest() {
        System.out.println("생성자");//인스턴스 초기화 4번째 (생성자로 초기화)
    }

    public static void main(String[] args) {
        System.out.println("InitializeBlockTest ibt1 = new InitializeBlockTest();");
        InitializeBlockTest ibt1 = new InitializeBlockTest();
        System.out.println("InitializeBlockTest ibt2 = new InitializeBlockTest();");
        InitializeBlockTest ibt2 = new InitializeBlockTest();
    }
}
