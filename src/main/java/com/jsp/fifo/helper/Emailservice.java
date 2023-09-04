package com.jsp.fifo.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Emailservice {

	    @Autowired
	    private JavaMailSender javaMailSender;

	    public void sendEmailWithAttachment(String to, String subject, String text, byte[] attachmentData, String attachmentName) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        try {
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text);
	            helper.addAttachment(attachmentName, new ByteArrayResource(attachmentData));
	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            // Handle email sending exception
	            e.printStackTrace();
	        }
	    }
	}


