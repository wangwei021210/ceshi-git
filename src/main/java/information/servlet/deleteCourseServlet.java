package information.servlet;


import information.dao.DaoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:邹顺
 * @data： 2019-06-18-19:32
 */
@WebServlet(name = "deleteCourseServlet", urlPatterns = "/deleteCourseServlet")
public class deleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String cId = request.getParameter("C_id");
        boolean bl = new DaoUtils().deleteCourse(Integer.parseInt(cId));
        PrintWriter writer = response.getWriter();
        if(bl!=true){
            writer.print("<script>alert('删除失败！！！！');</script>");
        }
    }
}
