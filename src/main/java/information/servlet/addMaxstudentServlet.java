package information.servlet;



import information.dao.DaoUtils;
import information.entity.Student;

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
 * @data： 2019-06-18-21:24
 */
@WebServlet(name = "addMaxstudentServlet", urlPatterns = "/addMaxstudentServlet")
public class addMaxstudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        Student student =(Student)session.getAttribute("student1");
        PrintWriter writer = response.getWriter();
        DaoUtils daoUtils = new DaoUtils();
        int id = 0;
        id = Integer.parseInt(request.getParameter("C_id"));


        int max = daoUtils.getMax(id);
        int maxstudent = daoUtils.getMaxstudent(id);
        if(maxstudent<max){
            daoUtils.addCid(id,student.getS_account());
            daoUtils.addMaxstduent(id);
        }else {
            writer.print("<script>alert('人数已达到最大值不可添加！！！！');</script>");
        }


    }
}
