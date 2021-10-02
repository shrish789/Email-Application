package com.shrish.email.services;

import com.shrish.email.bean.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setTo(mail.getMailTo().toArray(new String[0]));

            if (mail.getMailCc() != null) {
                mimeMessageHelper.setCc(mail.getMailCc().toArray(new String[0]));
            }

            if (mail.getMailBcc() != null) {
                mimeMessageHelper.setBcc(mail.getMailBcc().toArray(new String[0]));
            }

            if (mail.getMailSubject() != null) {
                mimeMessageHelper.setSubject(mail.getMailSubject());
            }

            if (mail.getMailContent() != null) {
                mimeMessageHelper.setText(mail.getMailContent());
            }

            if (mail.getAttachmentFileName() != null) {
                Resource resource = new ClassPathResource(mail.getAttachmentFilePath());
                System.out.println(resource);
                mimeMessageHelper.addAttachment(mail.getAttachmentFileName(), resource.getFile());
            }


            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}