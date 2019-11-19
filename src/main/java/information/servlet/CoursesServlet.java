package information.servlet;

import com.alibaba.fastjson.JSON;
import information.dao.DaoUtils;

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
 * @data： 2019-06-14-21:05
 */
@WebServlet(name = "CoursesServlet", urlPatterns = "/CoursesServlet")
public class CoursesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");

            String page = request.getParameter("page");
            String pagesize = request.getParameter("limit");

            DaoUtils daoUtils = new DaoUtils();
            Integer coursepage = daoUtils.getCoursepage(request.getParameter("name"), request.getParameter("T_name"));
            List list = daoUtils.getCourse(request.getParameter("name"), request.getParameter("T_name"), Integer.parseInt(page), Integer.parseInt(pagesize));
            Map<String,Object> result = new HashMap<String, Object>();
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", coursepage);
            result.put("data", list);

            String jsonObject = JSON.toJSONString(result);
            PrintWriter pw = response.getWriter();
            pw.print(jsonObject);

    }
}
