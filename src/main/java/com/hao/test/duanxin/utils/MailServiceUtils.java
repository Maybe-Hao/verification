package com.hao.test.duanxin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class MailServiceUtils{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    /**
     * @param sender 发送人
     * @param recipient 接收人
     * @param subject 主题
     * @param content 内容
     */
    public void sendMail(String sender,String recipient, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText("您的验证码为: "+content+"  ,3分钟内有效，请及时输入。");
        try {
            mailSender.send(message); logger.info("邮件成功发送!");
        } catch (MailException e) {
            logger.error("发送邮件错误:",e);
        }
    }
}