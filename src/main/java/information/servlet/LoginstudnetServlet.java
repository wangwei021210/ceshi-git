package information.servlet;



import information.dao.DaoUtils;
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
 * @data： 2019-06-16-1:17
 */
@WebServlet(name = "LoginstudnetServlet", urlPatterns = "/LoginstudnetServlet")
public class LoginstudnetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Student student = new Student();
        request.setCharacterEncoding("utf-8");
        student.setS_account(request.getParameter("account"));
        student.setS_pwd(request.getParameter("pwd"));


        DaoUtils daoUtils =  new DaoUtils();
        Student student1 = daoUtils.login(student);

        if(student1!=null){
            session.setAttribute("student1",student1);
            response.sendRedirect("main1.jsp");
        }
        else{
            request.setAttribute("message","账号密码错误");
            response.sendRedirect("Logins.jsp");
        }
    }
}

