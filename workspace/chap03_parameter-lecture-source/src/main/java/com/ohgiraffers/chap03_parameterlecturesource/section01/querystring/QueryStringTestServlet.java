package com.ohgiraffers.chap03_parameterlecturesource.section01.querystring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* 1번 jsp파일에 있는 태그(? 불러오기 */
@WebServlet("/querystring")
/* 2번 extends HttpServlet 해주기 */
public class QueryStringTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메소드를 추출해올 수 있다.
        * 인자로 input 태그에 지정한 name 속성 값을 문자열 형태로 전달한다.
        * 모든 input 태그의 값을 HashMap으로 관리하고 있으므로 원하는 값을 찾기 위해서는 key 역할을 하는 문자열이 필요하다. */
        String name = req.getParameter("name");
        System.out.println("이름 :" + name);

        /* getParameter 메소드는 반환 타입이 문자열이다. 다른 형식의 값이 필요하다면 parsing처리 한다. */
        int age =  Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        /* 날짜와 관련 된 부분도 parsing처리가 필요하다. */
        java.sql.Date birthday =  java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 :" + birthday) ;
    }
}
