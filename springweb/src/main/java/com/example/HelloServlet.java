package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("I Service");
        // res.getWriter().println("Hello World!!!!");
        PrintWriter out =   res.getWriter();
        res.setContentType("text/html");
        out.println("<h1>Hello World</h1>");        
    }
    
}
