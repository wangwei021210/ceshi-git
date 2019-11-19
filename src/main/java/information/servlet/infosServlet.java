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
import java.io.PrintWriter;

/**
 * @author:邹顺
 * @data： 2019-06-18-22:24
 */
@WebServlet(name = "infosServlet", urlPatterns = "/infosServlet")
public class infosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");

        Student student = new Student();
        student.setS_account(request.getParameter("account"));
        student.setS_name(request.getParameter("nickname"));
        student.setS_email(request.getParameter("email"));
        student.setS_phone(request.getParameter("cellphone"));
        student.setS_sex(request.getParameter("sex"));
        student.setS_img(request.getParameter("avatar"));

        boolean bl = new DaoUtils().UpdateStudent(student);
        if(bl){
            PrintWriter printWriter = response.getWriter();
            printWriter.print("修改成功");
            session.setAttribute("student",student);
            response.sendRedirect("main1.jsp");

        }
        else {
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<script>alert('添加失败！！！！');</script>");
        }

    }
}
