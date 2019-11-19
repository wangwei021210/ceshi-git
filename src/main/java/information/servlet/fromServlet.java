package information.servlet;


import information.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:邹顺
 * @data： 2019-06-05-21:41
 */
@WebServlet(name = "fromServlet")
public class fromServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Student student = new Student();
        request.setCharacterEncoding("utf-8");
        student.setS_account(request.getParameter("s_account"));
        student.setS_pwd(request.getParameter("S_pwd"));
        student.setS_phone(request.getParameter("S_phone"));
    }
}
