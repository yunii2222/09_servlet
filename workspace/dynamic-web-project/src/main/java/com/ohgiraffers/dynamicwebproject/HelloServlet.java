package com.ohgiraffers.dynamicwebproject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// /hello-servlet의 요청이 왔을 때 아래 class를 실행하겠다.
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hi";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}