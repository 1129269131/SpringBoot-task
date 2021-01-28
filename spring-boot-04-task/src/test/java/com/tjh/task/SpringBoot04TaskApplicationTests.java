package com.tjh.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 任务-邮件任务
 */
@SpringBootTest
class SpringBoot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void testSimpleMailMessage() {
        //创建一个简单邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("标题");
        message.setText("邮件内容");

        message.setTo("1129269131@qq.com");
        message.setFrom("1129269131@qq.com");

        mailSender.send(message);
    }

    @Test
    void testMimeMessage() throws Exception {
        //创建一个复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("标题");
        helper.setText("<b style='color:red'>HTML内容</b>", true);

        helper.setTo("1129269131@qq.com");
        helper.setFrom("1129269131@qq.com");

        //上传文件
        helper.addAttachment("爱情与友情.jpg", new File("爱情与友情.jpg"));

        mailSender.send(mimeMessage);
    }

}
