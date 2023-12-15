package com.vsr.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.mail.service.MailService;

@RestController
public class MailController {
	@Autowired
	MailService service;

	@GetMapping("/send")
	public String sendEmail() {
		service.sendMail();
		return "Email sent successfully";
	}

	@GetMapping("/create/{name}/{fromAddress}/{toAddress}/{gmail}/{mobileNumber}")
	public String Create(@PathVariable(required = true) String name, @PathVariable(required = true) String fromAddress, @PathVariable(required = true) String toAddress, @PathVariable(required = true) String gmail,
			@PathVariable(required = true) long mobileNumber) {
		service.createOrder(name, fromAddress, toAddress, gmail, mobileNumber);
		return "Email sent successfully";
	}

}
