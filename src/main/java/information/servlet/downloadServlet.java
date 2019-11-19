package information.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author:邹顺
 * @data： 2019-06-09-11:52
 */
@WebServlet(name = "downloadServlet",urlPatterns = "/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取文件名
        String filename = request.getParameter("filename");
        //文件所在的文件夹
        String folder="/download/";
        //通知浏览器以下载的方式打开
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader(" -Disposition","attachment;filename="+filename);
        //通过文件输入流读取文件
        InputStream in=getServletContext().getResourceAsStream(folder+filename);
        OutputStream out=response.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }

    }
}
