package com.cos.jwt.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class MyFilter3 implements Filter {
    // 토큰 : cos 이걸 만들어 줘야 함. 아이디와 패스워드가 정ㅅ당적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 그걸 응답을 해준다.
    // 요청할 때 마다 header에 Authorization에 value값으로 토큰을 가지고 오겠죠?
    // 그때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증만 하면 됨.(RSA,HS256)
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 토큰 : 코스 라는 토큰이 넘어오면 인증이 되게 하고 필터를 계속가게 하고, 아니면 컨트롤러에 진입을 못하게
        if(req.getMethod().equals("POST")){
            log.info("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            log.info(headerAuth);
            log.info("필터3");
            if (headerAuth.equals("cos")) {
                chain.doFilter(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }
        }
    }
}
