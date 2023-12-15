package com.vsr.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vsr.mail.dto.DetailsMapping;
import com.vsr.mail.model.Details;
import com.vsr.mail.repository.DetailsRepository;

@Service
public class MailService {
	
	@Autowired
	private DetailsRepository repo;
	
	@Autowired
	private DetailsMapping mapping;
	
	@Autowired
	private JavaMailSender mailSender;
		
	public void sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("no-reply@gmail.com");
		message.setTo("sreedharvsr228@gmail.com");
		message.setSubject("hello spring boot");
		message.setText("welocome to springBoot mail application");
		mailSender.send(message);
	}

	public void createOrder(String name, String fromAddress, String toAddress, String gmail, long mobileNumber) {
				Details details = repo.saveAndFlush(mapping.transformTo(name, fromAddress, toAddress, gmail, mobileNumber));
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(gmail);
				message.setSubject("Order details");
				message.setText(getBody(details));
				mailSender.send(message);
	}
	
	private String getBody(Details details) {
		String body = "Hi"+details.getName()+",\n"
				+ "Please find your order details below.\n"
				+ "\n"
				+ "\n"
				+ "'Order_Id' = "+details.getId()+",\n"
				+ "'User_Name' = "+details.getName()+",\n"
						+ "'gmail' = "+ details.getGmail()+",\n"
								+ "'Mobile_Number' = "+details.getMobileNumber()+",\n"
										+ "'From_Address' = "+details.getFromAddress()+",\n"
												+ "'To_Address' = "+details.getToAddress()+",\n"
														+ "'Distance' = "+details.getDistance()+",\n"
																+ "'Amount' = "+details.getDistance()*10+",\n"
																		+ "\n"
																		+ "\n"
																		+ "\n"
																		+ "\n"
																		+ "Thanks,\n"
																		+ "Sreedhar.";
				
				
		return body;
		
	}

}
