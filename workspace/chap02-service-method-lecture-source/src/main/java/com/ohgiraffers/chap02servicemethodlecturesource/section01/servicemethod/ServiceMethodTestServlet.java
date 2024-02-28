package com.ohgiraffers.chap02servicemethodlecturesource.section01.servicemethod;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    /* 요청에 대한 처리와 응답에 대한 처리를 다루는 값들이 넘어온다. */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* 현재 사용 되는 프로토콜은 HTTP 프로토콜로, HttpServletRequest 타입이다.
        * HttpServletRequest는 ServletRequest를 상속 받아 구현했으며,
        * Http 프로토콜의 정보를 담고 있으므로 실제 사용 시에는 다운 캐스팅해서 사용해야 한다. */
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        /* 요청 받은 http 메소드가 어떤 메소드인지 판단한다. */
        String httpMethod = httpRequest.getMethod();
        System.out.println("httpMethod : " + httpMethod);

        if ("GET".equals(httpMethod)) {
            /* 다운 캐스팅한 변수명으로 작성 */
            doGet(httpRequest,httpResponse);
        } else if ("POST".equals(httpMethod)) {
            /* 다운 캐스팅한 변수명으로 작성 */
            doPost(httpRequest,httpResponse);
        }
    }

    /* Get 방식 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }
    
    /* Post 방식 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
