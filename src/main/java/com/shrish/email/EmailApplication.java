package com.shrish.email;

import com.shrish.email.bean.Mail;
import com.shrish.email.services.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) {

		Mail mail = new Mail();
		mail.setMailTo(Arrays.asList("abc@gmail.com", "def@gmail.com"));
		mail.setMailCc(Arrays.asList("ghi@gmail.com"));
		mail.setMailBcc(Arrays.asList("jkl@gmail.com"));
		mail.setAttachmentFileName("mno");
		mail.setAttachmentFilePath("Path to file");
		mail.setMailSubject("Spring Boot - Email Example");
		mail.setMailContent("This is a test email");

		ApplicationContext ctx = SpringApplication.run(EmailApplication.class, args);
		MailService mailService = (MailService) ctx.getBean("mailService");
		mailService.sendEmail(mail);

	}

}
