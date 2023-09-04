package com.jsp.fifo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.fifo.dto.Fifo;
import com.jsp.fifo.service.Service;



@Controller
public class Controler {

	@Autowired
	Service service;

	@GetMapping("/")
	public String gotohome() {
		return "Home";
	}

	@GetMapping("/upload")
	public String gotoUpload() {
		return "Upload";
	}

	@PostMapping("/upload")
	public String handleFileUpload(Fifo fifo, @RequestParam("file") MultipartFile file, @RequestParam("email") String email,
			RedirectAttributes redirectAttributes) {
		
		
		return service.SaveandSend(fifo,file,email,redirectAttributes);

}
}