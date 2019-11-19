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
 * @data： 2019-06-18-23:34
 */
@WebServlet(name = "updataStuServlet", urlPatterns = "/updataStuServlet")
public class updataStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        boolean bl = new DaoUtils().updateSpwd(oldPassword,password);
        if(bl == true ){
            response.getWriter().print("修改成功");
            request.getSession().removeAttribute("student1");
        }else{

            response.getWriter().print("<script>alert('原密码错误！！！！');</script>");

        }

    }
}
