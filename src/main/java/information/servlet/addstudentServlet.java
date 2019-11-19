package information.servlet;


import information.dao.DaoUtils;
import information.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:邹顺
 * @data： 2019-06-12-21:47
 */
@WebServlet(name = "addstudentServlet", urlPatterns = "/addstudentServlet")
public class addstudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        Student student = new Student();
        student.setS_account(request.getParameter("account"));
        student.setS_name(request.getParameter("nickname"));
        student.setS_email(request.getParameter("email"));
        student.setS_phone(request.getParameter("cellphone"));
        student.setS_pwd(request.getParameter("password"));
        student.setS_sex(request.getParameter("sex"));
        student.setS_img(request.getParameter("avatar"));
        student.setCollege(request.getParameter("college"));
        student.setS_national(request.getParameter("national"));
        String classes = request.getParameter("classes");
        student.setClasses(Integer.parseInt(classes));

        boolean bl = new DaoUtils().addstudent(student);
        if(bl!=true){

            printWriter.print("<script>alert('添加失败！！！！');</script>");
        }

    }
}
