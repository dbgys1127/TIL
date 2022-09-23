package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class UnCheckedAppTest {

    @Test
    void unchecked() {
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller.request())
                .isInstanceOf(Exception.class);
    }

    @Test
    void printEx() {
        Controller controller = new Controller();
        try {
            controller.request();
        } catch (Exception e) {
            // 로그를 출력 할떄 마지막 파라미터에 예외를 넣어주면 로그에 스택 트레이스를 출력할 수 있다.
            log.info("ex", e);
        }

    }

    static class Controller {
        Service service = new Service();

        public void request() {
            service.logic();
        }
    }


    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() {
            repository.call();
            networkClient.call();
        }

    }

    static class NetworkClient {
        public void call() {
            throw new RuntimeConnectException("연결실패");
        }
    }

    static class Repository {
        public void call(){
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSQLException(e);
                //앞서 받은 cause를 보관하고 있음, 여기 기존예외 꼭 넣어야 한다.
                // 안넣으면 뭐땜에 예외가 발생했는지 알 수 가 없다.
            }
        }
        public void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException {
        public RuntimeConnectException(String message) {
            super(message);
        }
    }

    static class RuntimeSQLException extends RuntimeException{
        public RuntimeSQLException(Throwable cause){
            super(cause);//cause가 예외에 원인을 넘겨줌
        }

    }
}
