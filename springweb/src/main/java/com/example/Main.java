package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello world!");
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        

        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context,"HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet"); // Name of servlet can be any thing
        
        tomcat.start();
        tomcat.getServer().await();
    }
}