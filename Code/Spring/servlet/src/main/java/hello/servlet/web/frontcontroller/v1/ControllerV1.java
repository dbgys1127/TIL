package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    // 회원 등록, 조회, 리스트 조회를 모두 얘로 할꺼라서 interface로 만든다. -> 다형성 활용
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
