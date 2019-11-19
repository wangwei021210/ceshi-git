package information.servlet;


import information.dao.DaoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:邹顺
 * @data： 2019-06-08-14:11
 */
@WebServlet(name = "getServlet",urlPatterns = "/getServlet")
public class getServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        DaoUtils daoUtils = new DaoUtils();
        int i = daoUtils.getTeacher();
         request.getParameter("teacher");
    }
}
