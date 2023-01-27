package selfstudy.DI.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    private void call(String message) {
        System.out.println("call: "+url+" message = "+message);
    }

    private void connect() {
        System.out.println("connect: "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @PreDestroy
    public void destroy() throws Exception {
        disConnect();
    }

    private void disConnect() {
        System.out.println("close = "+url);
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화연결메시지");
    }
}
