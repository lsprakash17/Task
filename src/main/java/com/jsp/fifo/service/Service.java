package com.jsp.fifo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.fifo.Repository.FifoRepo;
import com.jsp.fifo.dto.Fifo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	FifoRepo fifoRepo;
	
	public String SaveandSend(Fifo fifo,MultipartFile file, String email, RedirectAttributes redirectAttributes)
	{

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:/upload";
		}

		try {
			// Save the file to a database .
			byte[] files = new byte[file.getInputStream().available()];
			file.getInputStream().read(files);
			fifo.setFil(files);
			 
//			fifoRepo.save(fifo);
			
			// Save the file to a temporary location .
			byte[] fileBytes = file.getBytes();
			String fileName = file.getOriginalFilename();

			// Send an email with the uploaded file as an attachment.
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(email);
			helper.setSubject("File Attachment");
			helper.setText("Please find the attached file.");

			helper.addAttachment(fileName, new ByteArrayResource(fileBytes));

			javaMailSender.send(message);

			redirectAttributes.addFlashAttribute("message", "File uploaded and email sent successfully.");
		} catch (IOException | MessagingException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "Failed to upload file or send email.");
		}

		return "redirect:/upload";
	}
	}
