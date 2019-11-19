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
 * @data： 2019-06-09-17:05
 */
@WebServlet(name = "updatapwdServlet", urlPatterns = "/updatapwdServlet")
public class updatapwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        boolean bl = new DaoUtils().updatepwd(oldPassword,password);
        if(bl == true ){
            response.getWriter().print("修改成功");
            request.getSession().removeAttribute("user1");
        }else{

            response.getWriter().print("<script>alert('原密码错误！！！！');</script>");

        }


    }
}
