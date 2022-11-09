package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.email.model.EmailResponse;
import com.example.email.service.EmailService;

@Controller

public class EmailController {
	@RequestMapping("/mail")
	public String welcome(){
		return "helooooo";
	}
	@Autowired
	EmailService emailService;

	@RequestMapping(value ="/sendemail",method= RequestMethod.POST)
	public ResponseEntity<?> sendMail(@RequestBody EmailResponse emailResponse){
		
		System.out.print(emailResponse);
	boolean result=this.emailService.sendEmail(emailResponse.getMessage(),emailResponse.getSubject(),emailResponse.getTo());
		if(result) {
			return ResponseEntity.ok("done dana done");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
		}
	}
}
