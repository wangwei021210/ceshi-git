package information.servlet;


import information.entity.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:邹顺
 * @data： 2019-06-22-0:07
 */
@WebServlet(name = "ReadimgServlet", urlPatterns = "/ReadimgServlet")
public class ReadimgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user1");
            File file = new File("F:\\img\\" + user.getImg());
            //通过ID获取图片
//        String id = request.getParameter("id");
//        User user = userDao.getUserById(id);
//        File file = new File("f:/test/" + user.getPhoto());
            if (file.exists()){
                FileInputStream in = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream();
                byte data[] = new byte[1024];
                int size = 0;
                size = in.read(data);
                while (size != -1){
                    out.write(data, 0, size);
                    size = in.read(data);
                }
                out.close();
                in.close();
            }

    }
}
