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
        Student student = new Student();
        Rtn rtn = new Rtn();
        
        student.setId(1);
        student.setName("Judy");
        
        rtn.setRtnNo(2);
        model.addAttribute("myStudent", student);
        model.addAttribute("myRtn", rtn);  // 使用不同的属性名

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName, String userPassword) {
        System.out.println("userName 為: " + userName);
        System.out.println("userPassword 為: " + userPassword);
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
