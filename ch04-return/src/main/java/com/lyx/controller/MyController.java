package com.lyx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyx.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Controller
public class MyController {

    /**
     * 处理器方法返回string--表示逻辑视图名称，需要配置视图解析器
     *
     * @param name
     * @param age
     * @return
     */

    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age) {
        System.out.println("doReturnView,name=" + name + " age=" + age);

        //可以自己手工添加数据到request作用域
        request.setAttribute("name", name);
        request.setAttribute("age", age);

        //show:逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }


    //处理器方法返回String,表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request, String name, Integer age) {
        System.out.println("doReturnView2,name=" + name + " age=" + age);

        //可以自己手工添加数据到request作用域
        request.setAttribute("name", name);
        request.setAttribute("age", age);

        //完整视图路径，项目不能配置视图解析器
        //框架对视图执行forward转发操作
        ///WEB-INF/view/WEB-INF/view/show.jsp.jsp
        return "/WEB-INF/view/show.jsp";
    }


    //处理器方法返回void，响应ajax请求
    //手工实现ajax,json数据：代码有重复的 1.java对象转为json 2.通过HttpServletResponse输出json数据
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws Exception {
        System.out.println("doReturnVoidAjax,name=" + name + " age=" + age);
        //处理ajax,使用json做数据的格式
        //service调用完成了，使用student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        //把结果的对象转为json格式的数据
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json==="+json);
        }

        //输出数据相应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
