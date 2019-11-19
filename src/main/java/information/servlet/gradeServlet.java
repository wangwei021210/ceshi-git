package information.servlet;

import com.alibaba.fastjson.JSON;
import information.dao.DaoUtils;
import information.entity.Student;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.List;

/**
 * @author:邹顺
 * @data： 2019-06-05-15:08
 */
@WebServlet(name = "gradeServlet", urlPatterns = {"/gradeServlet"})
public class gradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
//        try {
//            pagesize = Integer.parseInt(limit);
//            page = Integer.parseInt(pages);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Student student = new Student();



        student.setS_account(request.getParameter("account"));
        student.setS_name(request.getParameter("name"));
        String page = request.getParameter("page");
        String pagesize = request.getParameter("limit");

        DaoUtils daoUtils = new DaoUtils();
        Integer i = daoUtils.getPage(student);
        List userList = daoUtils.selectGrade(student,Integer.parseInt(page),Integer.parseInt(pagesize));
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", i);
        result.put("data", userList);
        String jsonObject = JSON.toJSONString(result);
        PrintWriter pw = response.getWriter();
        pw.print(jsonObject);


    }
}
