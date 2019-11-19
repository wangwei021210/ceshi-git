package information.servlet;

import com.alibaba.fastjson.JSON;

import information.dao.DaoUtils;
import information.entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:邹顺
 * @data： 2019-06-08-21:29
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        try{

            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user1");
            response.setContentType("text/html;charset=utf-8");
//            创建DiskFileItemFactory工厂对象
            DiskFileItemFactory factory=new DiskFileItemFactory();
//            设置文件缓存目录，如果该文件夹不存在则创建一个
            File f=new File("F:\\img");
            if (!f.exists()){
                f.mkdirs();
            }
            factory.setRepository(f);
//            创建ServletFileUpload对象
            ServletFileUpload fileUpload=new ServletFileUpload(factory);
//            设置字符编码
            fileUpload.setHeaderEncoding("utf-8");
//            解析request，将form表单的各个字段封装为FileItem对象
            List<FileItem> fileItems = fileUpload.parseRequest(request);
//            获取字符流
            PrintWriter writer=response.getWriter();
//            遍历List集合
            for (FileItem fileItem:fileItems) {
//            判断是否为普通字段
                if (fileItem.isFormField()){
//                    获取字段名称
                    String name = fileItem.getFieldName();
                    if(name.equals("name")){
//                        如果字段值不为空
                        if (!fileItem.getString().equals("")){
                            String value=fileItem.getString("utf-8");
                            writer.print("上传者："+value+"<br />");
                        }
                    }
                }
                else {
                    //获取上传的文件名
                    String filename = fileItem.getName();
                    String name  = fileItem.getFieldName();
//                    处理上传文件
                    if(filename!=null&&filename!=""){
//                        D.randomUUID().toString()+"_"+filename;
//                        创建文件路径保持文件名唯一
////                        filename= UUI
//                        String filepath= "F:\\javaTest\\Student_informations\\web\\download\\" + filename;

                        String n = filename.substring(filename.lastIndexOf("."));
                        String m  = Long.toString(new Date().getTime());
                        filename = m+n;
                        new DaoUtils().Updateimg(user.getAccount(),filename);
                        System.out.println(filename);
                        name = "F:\\img\\" + filename;
                        //创建File对象
//                        File file=new File(filepath);
                        //创建文件夹
//                        file.getParentFile().mkdirs();
                        //创建文件
//                        file.createNewFile();
                        //获取上传文件流
                        InputStream in=fileItem.getInputStream();
//                        使用 FileOutputStream打开服务器端的上传文件
                        FileOutputStream out=new FileOutputStream(name);

                        Map<String,Object> result = new HashMap<String, Object>();
                        result.put("code", 0);
                        result.put("msg", "");
                        result.put("data",name);
                        result.put("img",filename);
                        String jsonObject = JSON.toJSONString(result);
                        PrintWriter pw = response.getWriter();
                        pw.print(jsonObject);


//                        流的对拷
                        byte[] bytes=new byte[1024];//每次读取一个字节
                        int len;
//                        开始读取上传文件的字节，并将其输出到服务器端的上传文件输出流中
                        while ((len=in.read(bytes))>0)
                            out.write(bytes,0,len);
                        in.close();
                        out.close();
                        fileItem.delete();
                    }
                }


            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}


