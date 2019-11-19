package information.servlet;

import information.dao.DaoUtils;
import information.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:邹顺
 * @data： 2019-06-15-20:30
 */
@WebServlet(name = "addteacherServlet", urlPatterns = "/addteacherServlet")
public class addteacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        Teacher teacher = new Teacher();
        teacher.setT_account(request.getParameter("account"));
        teacher.setT_name(request.getParameter("name"));
        teacher.setT_pwd(request.getParameter("password"));
        teacher.setAge(Integer.parseInt(request.getParameter("age")));
        teacher.setSex(request.getParameter("sex"));
        teacher.setImg(request.getParameter("img"));
        teacher.setT_phone(request.getParameter("cellphone"));
        teacher.setT_email(request.getParameter("email"));

        DaoUtils daoUtils = new DaoUtils();
        boolean bl = daoUtils.addteacher(teacher);
        if(bl==false) {
            printWriter.print("<script>alert('添加失败！！！！');</script>");
        }

    }
}
