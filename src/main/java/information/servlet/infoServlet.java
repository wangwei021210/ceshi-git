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
import java.io.PrintWriter;
/**
 * @author:邹顺
 * @data： 2019-06-09-21:37
 */
@WebServlet(name = "infoServlet", urlPatterns = "/infoServlet")
public class infoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");

        User user = new User();
        user.setAccount(request.getParameter("account"));
        user.setName(request.getParameter("nickname"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("cellphone"));
        user.setSex(request.getParameter("sex"));
        user.setImg(request.getParameter("avatar"));

        boolean bl = new DaoUtils().updateUser(user);
        if(bl){
            PrintWriter printWriter = response.getWriter();
            printWriter.print("修改成功");
            session.setAttribute("user1",user);
            response.sendRedirect("main.jsp");

        }
        else {
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<script>alert('添加失败！！！！');</script>");
        }

    }
}
