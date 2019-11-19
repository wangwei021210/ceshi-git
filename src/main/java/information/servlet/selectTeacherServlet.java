package information.servlet;

import com.alibaba.fastjson.JSON;
import information.dao.DaoUtils;
import information.entity.Teacher;


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
 * @data： 2019-06-06-21:35
 */
@WebServlet(name = "selectTeacherServlet",urlPatterns = "/selectTeacherServlet")
public class selectTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        Teacher teacher = new Teacher();
        String account = request.getParameter("account");
        teacher.setT_account(account);

        String pagesize = request.getParameter("limit");
        String page  = request.getParameter("page");
        DaoUtils daoUtils = new DaoUtils();
        Integer i = daoUtils.getPages(teacher);
        List list = daoUtils.Selecteacher(teacher,Integer.parseInt(page),Integer.parseInt(pagesize));
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",i);
        result.put("data", list);
        String jsonObject = JSON.toJSONString(result);
        PrintWriter pw = response.getWriter();
        pw.print(jsonObject);


    }
}
