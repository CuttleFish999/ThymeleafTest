package com.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Controller
public class ThymeleafController {

    @Autowired
    private RtnService rtnService;

    @GetMapping("/home")
    public String home(Model model) {
        // 从数据库中获取 rtn 数据
        Rtn rtn = rtnService.getProductById(1);

        // 创建 Student 对象（这里假设 Student 类有对应的构造函数）
        Student student = new Student();
        student.setId(1);
        student.setName("Judy");

        // 将获取的 rtn 数据和 Student 对象添加到模型中
        model.addAttribute("myStudent", student);
        model.addAttribute("myRtn", rtn);
        
        return "login";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName, String userPassword,Model model) {
        System.out.println("userName 為: " + userName);
        System.out.println("userPassword 為: " + userPassword);
        Rtn rtn = rtnService.getProductById(1);
        model.addAttribute("myRtn", rtn);
        
        return "login";
    }

    @GetMapping("/Rtn/{rtnNo}")
    public String getProduct(@PathVariable Integer rtnNo, Model model) {
        Rtn rtn = rtnService.getProductById(rtnNo);
        
        if (rtn != null) {
            rtn.setRtnNo(1);
            model.addAttribute("myStudent", rtn);
            return "login";  // 这里返回 "login" 视图
        } else {
            return "notFound";  // 如果 rtn 为 null，返回 "notFound" 视图
        }
    }

}
