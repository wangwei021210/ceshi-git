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
import java.util.Map;

/**
 * @author:邹顺
 * @data： 2019-06-05-14:06
 */
@WebServlet(name = "selectstudentServlet"  ,urlPatterns =  "/selectstudentServlet")
public class selectstudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Student student = new Student();
//
        student.setS_account(request.getParameter("account"));
        student.setS_name(request.getParameter("name"));
        student.setS_national(request.getParameter("national"));
//        String classes = request.getParameter("classes");
//        if(classes!=null)
//            student.setClasses(Integer.parseInt(classes));
        student.setCollege(request.getParameter("college"));
        student.setS_sex(request.getParameter("sex"));

        String page = request.getParameter("page");
        String pagesize = request.getParameter("limit");


        Integer i =new DaoUtils().getPages(student);
        DaoUtils daoUtils = new DaoUtils();
        List list = daoUtils.Selecstudent(student, Integer.parseInt(page),Integer.parseInt(pagesize));
        Map<String,Object> result = new HashMap <String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", i);
        result.put("data", list);

        String jsonObject = JSON.toJSONString(result);
        PrintWriter pw = response.getWriter();
        pw.print(jsonObject);
    }
}
