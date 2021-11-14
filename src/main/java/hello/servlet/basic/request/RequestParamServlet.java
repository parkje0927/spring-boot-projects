package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * 2. 동일한 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&username=hello2&age=20
 * 파라미터 이름은 하나인데 값이 중복이면 어떻게 될까?
 * request.getParameter() 는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다.
 * 지금처럼 중복일 때는 request.getParameterValues() 를 사용해야 한다.
 * 만약 request.getParameter() 를 사용하면 첫 번째 값만 반환한다.
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        resp.getWriter().write("ok");
    }
}

/**
 * application/x-www-form-urlencoded 형식은 앞서 GET 에서 살펴본 쿼리 파라미터 형식과 같다.
 * 따라서 쿼리 파라미터 조회 메서드를 그대로 사용하면 된다.
 * 웹 브라우저 입장에서는,
 * 두 방식(http://localhost:8080/request-param?usernae=hello&age=20 과 form 으로 전달하는 방식)에 차이가 있지만,
 *
 * 서버 입장에서는,
 * 둘의 형식이 동일하므로 request.getParameter() 로 편리하게 구분없이 조회할 수 있다.
 */