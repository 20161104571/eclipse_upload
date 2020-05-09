package com.imnu.SchoolBus.service;


public interface MailService {

    void sendHtmlMail(String to, String subject, String content);

}
