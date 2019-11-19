package information.servlet;//package com.information.servlet;
//
//import com.information.dao.DaoUtils;
//import com.information.entity.Student;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Date;
//
///**
// * @author:邹顺
// * @data： 2019-06-22-13:55
// */
//@WebServlet(name = "judgeServlet", urlPatterns = "/${Entity_name}")
//public class judgeServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Student student = (Student) session.getAttribute("student1");
//        boolean b = new DaoUtils().judgeCourse(student.getS_account());
//        if(b == true){
//
//        }else{
//
//        }
//    }
//}
