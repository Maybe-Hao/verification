package com.hao.test.duanxin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
//这里映射两个页面，index是手机验证码，email是邮箱验证码
//方便测试使用
@Controller
public class BaseController {


    @RequestMapping("/index")
    public String index(){
        System.out.println("Looking in the index controller.........");
        return "index";
    }

    @RequestMapping("/email")
    public String email(){
        System.out.println("Looking in the index controller.........");
        return "email";
    }
}