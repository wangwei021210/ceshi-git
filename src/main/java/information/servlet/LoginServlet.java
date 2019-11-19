package information.servlet;



import information.dao.DaoUtils;
import information.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:邹顺
 * @data： 2019-06-05-13:13
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        request.setCharacterEncoding("utf-8");
        user.setAccount(request.getParameter("account"));
        user.setPwd(request.getParameter("pwd"));


        DaoUtils daoUtils =  new DaoUtils();
        User user1 = daoUtils.login(user);

        if(user1!=null){
            session.setAttribute("user1",user1);
            response.sendRedirect("main.jsp");
        }
        else{
            request.setAttribute("message","账号密码错误");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
