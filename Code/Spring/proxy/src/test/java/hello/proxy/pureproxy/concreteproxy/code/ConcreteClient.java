package hello.proxy.pureproxy.concreteproxy.code;

public class ConcreteClient {
    private ConcreteLogic concreteLogic;

    public ConcreteClient(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }
    public void excute() {
        concreteLogic.operation();
    }
}
