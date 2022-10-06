package com.iweb.bookstore.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.iweb.bookstore.entity.User;
import com.iweb.bookstore.service.LoginManagement;
import com.google.gson.Gson;
@WebServlet("/LoginAjax")
public class LoginAjax extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BufferedReader rd=request.getReader();
        StringBuffer stringBuffer=new StringBuffer("");

        String str="";
        while ((str=rd.readLine())!=null)
        {
            stringBuffer.append(str);
        }
        str=stringBuffer.toString();
        System.out.println(str);
        Gson gson=new Gson();
        User user=gson.fromJson(str,User.class);
        String name=user.getName();
        String pass=user.getPass();
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        if(LoginManagement.login(name,pass)){
            session.setAttribute("name",name);
            out.write(name);
        }
        else
            out.write("error");
    }
}
