package information.servlet;


import information.dao.DaoUtils;
import information.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * @author:邹顺
 * @data： 2019-06-15-21:11
 */
@WebServlet(name = "addCourseServlet", urlPatterns = "/addCourseServlet")
public class addCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Course course = new Course();
        course.setName(request.getParameter("name"));
        course.setTime(request.getParameter("time"));
        course.setClassroom(request.getParameter("classroom"));
        course.setMax(Integer.parseInt(request.getParameter("max")));
        course.setMaxstudent(0);
        DaoUtils daoUtils = new DaoUtils();
        int t_id = daoUtils.getT_id(request.getParameter("T_name"));
        course.setT_id(t_id);
        if(t_id!=0)
            daoUtils.addCourse(course);
        else{
           response.getWriter().print("<script>alert('未存在该老师！');</script>");
        }





    }
}
