ch04-return:处理器方法的返回值表示的处理结果
1.ModelAndView:有数据和视图，对视图执行forward
2.String:表示视图，可以逻辑名称，也可以是完整视图路径
3.void:不能表示数据，也不能表示视图
   在处理ajax的时候，可以使用void返回值 通过HttpServletResponse输出数据。相应ajax请求
   ajax请求服务器端返回的就是数据，没有视图
4.Object:例如string，integer，Map，List，Student等等都是对象
  对象有属性，属性就是数据。所以返回对象object表示数据，和视图无关
  可以使用对象表示的数据，相应ajax请求

  现在做ajax，主要使用json数据格式。实现步骤：
  1.加入处理json的工具库的依赖。springmvc默认使用jackson
  2.在springmvc配置文件中加入<mvc:annotation-driven>注解驱动。
   json = om.writeValueAsString(student);
  3.在处理器方法的上面加入@ResponseBody注解
          response.setContentType("application/json;charset=utf-8");
          PrintWriter pw = response.getWriter();
          pw.println(json);

  springmvc处理器方法返回object，可以转为json输出到浏览器，相应ajax的内部原理
  1.<mvc:annotation-driven>注解驱动
   注解驱动：完成java对象到json，xml，text，二进制等数据格式的转换
   HttpMessageConverter接口：消息转换器。
   功能：定义了java转为json，xml等数据格式的方法。这个接口有很多的实现类，这些实现了完成了
   java对象到xml、json到二进制数据的转换

   下面完成的方法是控制器类把结果输出给浏览器时使用的
   boolean canWrite(Class<?> var1, @Nullable MediaType var2);
   void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)

   1)canWrite作用检查处理器方法的返回值，能不能转为var2表示的数据格式。如果检查能转为json，canWrite返回true
     MediaType:表示数据格式的,例如json，xml等等