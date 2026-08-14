package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class HomeController {
    
    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam int num1 ,@RequestParam int num2, ModelAndView mv){
        System.out.println(num1);
        System.out.println(num2);
        int result = num1 +num2;
        mv.addObject("result",result);
        mv.setViewName("result");
        return mv;
    }
    // @RequestMapping("/add")
    // public String add(@RequestParam int num1 ,@RequestParam int num2, Model model){
    //     System.out.println(num1);
    //     System.out.println(num2);
    //     int result = num1 +num2;
    //     model.addAttribute("result", result);
    //     return "result";
    // }

    // @RequestMapping("/add")
    // public String add(HttpServletRequest req,HttpSession session){
    //     int num1 = Integer.parseInt(req.getParameter("num1"));
    //     int num2 = Integer.parseInt(req.getParameter("num2"));
    //     int result = num1 + num2;
    //     session.setAttribute("result", result);

    //     System.out.println(num1);
    //     System.out.println(num2);
    //     return "result.jsp";
    // }
}
