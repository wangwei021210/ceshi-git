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
 * @data： 2019-06-08-12:04
 */
@WebServlet(name = "deleteTeacherServlet",urlPatterns = "/deleteTeacherServlet")
public class deleteTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String sId = request.getParameter("T_id");
        boolean bl = new DaoUtils().deletTeacher(sId);
        PrintWriter writer = response.getWriter();
        if(bl!=true){
            writer.print("<script>alert('删除失败！！！！');</script>");
        }
    }
}
