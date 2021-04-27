package com.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyController {

    /**
     * 逐个接收请求参数：
     *          要求：处理器（控制器）方法的形参名和请求中参数名必须一致
     *          同名的请求参数赋值给同名的形参
     *  框架接收请求参数
     *  1.使用request对象接收请求参数
     *    String strName = request.getParameter("name");
     *    String strAge = request.getParameter("age");
     *  2.springmvc框架通过DispatcherServlet调用MyController的doSome()方法时
     *    按名称对应，把接收的参数赋值给形参
     *    doSome(strName,Integer.valueOf(strAge))
     *    框架会提供类型转换的功能，把string转为int,long,float,double等类型
     *
     *  400状态码是客户端错误,表示提示请求参数过程中,发生的问题
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView doSome(String name,Integer age) {  //doGet()--service请求处理
        //可以在方法中直接使用name,age处理some.do请求了。相当于service调用处理完成了

        ModelAndView mv = new ModelAndView();

        mv.addObject("myname",name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        //返回mv
        return mv;
    }

    public void doPost(HttpServletRequest request){
        //request.setCharacterEncoding("utf-8");
    }

}
