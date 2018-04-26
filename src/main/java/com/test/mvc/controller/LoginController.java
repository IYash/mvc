package com.test.mvc.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.mvc.domain.AjaxResult;
import com.test.mvc.domain.Blog;
import com.test.mvc.service.IBlogService;
import com.test.mvc.service.ITransactionService;
import com.test.mvc.annotation.SysLog;
import com.test.mvc.domain.AjaxResult;
import com.test.mvc.domain.Blog;
import com.test.mvc.domain.Transaction;
import com.test.mvc.service.IBlogService;
import com.test.mvc.service.ITransactionService;
import com.test.mvc.service.impl.DefaultBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/9/5.
 */
@Controller
public class LoginController extends BaseController{
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ITransactionService transactionService;
    private DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/index.do")
    @ResponseBody
    public String index(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//CORS,jsonp下可以不需要
        System.out.println("+++++++++++++++++++++++++");
        return "callback({'login':'true'})";//jsonp
        //return "login";
    }
    //多个视图的使用，需要配合自定义视图解析器,可以根据返回的视图名找到对应的视图解析器
    @RequestMapping("/{template}")
    public String root(@PathVariable String template){
        System.out.println("+++++++++++++++++++++++++");
        if("jsp".equals(template)) return "login";
        return "index";
    }
    @RequestMapping("/page/login.do")
    @SysLog(operateArea = {"controller","loginController","login"})
    public String login(Model model, String username, String password, HttpServletRequest request){

        System.out.println(request.getRequestURL()+"------->"+ request.getRequestURI());

        Map params = request.getParameterMap();
        Set<String> keys = params.keySet();
        for (String param:keys
             ) {
            System.out.println(request.getParameter(param));
        }

        Blog blog=new Blog("hello aspect",new Date());
        blogService.addBlog(blog);
        System.out.println(blog.getId()+"=========================");
        /*int msgType=new Random().nextInt()%2;
        System.out.println(msgType);
        for (int i = -4;i<50;i++){
            msgType=i;
        Transaction transaction = new Transaction(msgType);
        transactionService.addTransaction(transaction);
        }*/
        model.addAttribute("username",username);
        model.addAttribute("dateTime",sdf.format(new Date()));
        return "test";
    }
    @RequestMapping("/page/delete.do")
    @ResponseBody
    public AjaxResult delete(Model model){
        AjaxResult result = new AjaxResult("ok");
        return result;
    }
    @RequestMapping("/page/update.do")
    @ResponseBody
    public void update(Model model, HttpServletResponse response) throws IOException {
        AjaxResult result = new AjaxResult("ok");
       response.getWriter().write(result.toJsonString());
    }
    @ModelAttribute
    public void doA(Model model){
        System.out.println("______________________");
    }

    @ResponseBody
    @RequestMapping("/page/delist.do")
    public AjaxResult delist(Model model,@RequestParam("ids") ArrayList<Integer> ids){
        AjaxResult result = new AjaxResult("ok");
        blogService.delistByIds(ids);
        return result;
    }
    @ResponseBody
    @RequestMapping("/page/delist_array.do")
    public AjaxResult delist_Array(Model model,@RequestParam("ids") int[] ids){
        AjaxResult result = new AjaxResult("ok");
        blogService.delistByArrayIds(ids);
        return result;
    }

    public static void main(String[] args) throws IOException {
        fileOpen();
        /*String delimiter="\\t";
        String line="你好\t世界\t手机号码\t黑名单类型";
        Pattern pattern = Pattern.compile(delimiter);
        System.out.println(line.contains("\t"));
        System.out.println(line.contains(delimiter));
        List<String> marks= new ArrayList();
        marks.addAll(Arrays.asList(new String[]{" ","\\t","|",","}));
        Iterator<String> its= marks.iterator();
        while(its.hasNext()){
            String it=its.next();
            System.out.println(it);
            if(delimiter.equals(it))
                its.remove();
        }
        for (String string:marks
             ) {
            if(line.contains(string)){
                System.out.println("==============");
            }else{
                System.out.println("--------------");
            }
        }*/
    }
    public static void fileOpen() throws IOException{
        String basePath="ams-node/";
        URL url = ClassLoader.getSystemResource(basePath);
        InputStream is = url.openStream();
        Reader r = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(r);
        String path;
        while ((path = br.readLine()) != null) {
            try {
                if (!path.endsWith(".json")) {
                    // pass no json file
                    continue;
                }
                String completePath = basePath + path;

            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        br.close();
        r.close();
    }
}
