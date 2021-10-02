package com.shrish.email.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Mail {
    private List<String> mailTo;

    private List<String> mailCc;

    private List<String> mailBcc;

    private String mailSubject;

    private String mailContent;

    private String contentType;

    private String attachmentFileName;

    private String attachmentFilePath;

    public Mail() {
        contentType = "text/plain";
    }

    public Date getMailSendDate() {
        return new Date();
    }

}
