package selfstudy.DI.singleton;

public class SingletonService {
    // 1. static을 이용해서 클래스가 로딩될때 한번 생성되게 한다. / private를 이용해 외부에서 접근 못하게 막는다. / final을 이용해 수정을 못하게 한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 객체 인스턴스가 필요할 때 가져 갈 수 있게 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. private 로 기본 생성자를 선언해서 외부에서 new 키워드를 사용하지 못하게 한다.( 타클래스에서 인스턴스를 생성할 수 없게됨) 필요하면 2번 메소드를 사용해야함


    private SingletonService() {
    }
    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
}
