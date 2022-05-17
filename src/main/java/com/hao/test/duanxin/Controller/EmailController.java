package com.hao.test.duanxin.Controller;

import com.hao.test.duanxin.utils.MailServiceUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Classname EmailController
 * @Description TODO  邮箱发送
 * @Author 86176
 * @Date 2021-12-17 15:28
 * @Version 1.0
 **/
@Controller
public class EmailController {

    @Resource
    private MailServiceUtils mailServiceUtils;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 发送验证码 redis存储验证码
     * @param recipient 被发送的邮箱账号
     * @return
     */
    @PostMapping("/sendEmail")
    @ResponseBody
    public String email(String recipient) {
        try {
            //生成6位随机数
            String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
            //发送邮箱
            mailServiceUtils.sendMail("lh1348114176@163.com", recipient, "验证码", code);
            //redis保存验证码,并设置3分钟过期时间
            redisTemplate.opsForValue().set(recipient, code,60*3, TimeUnit.SECONDS);
        } catch (Exception e) {
            return "邮箱发送失败！";
        }
        return "OK";
    }

    /**
     * 邮箱验证
     * @param recipient 被发送的邮箱账号
     * @param code 输入的验证码判断
     * @return
     */
    //验证验证码是否正确
    @PostMapping("/code")
    @ResponseBody
    public String yz(String recipient, String code) {
        //根据邮箱帐号取出验证码
        String o = (String) redisTemplate.opsForValue().get(recipient);
        if (o.equals(code)){
            return "验证码正确！";
        }
        return "验证码错误！";
    }

    @RequestMapping("/abc")
    public String abc() {
        return "QQemail";
    }
}