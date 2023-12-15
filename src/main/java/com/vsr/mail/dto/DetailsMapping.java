package com.vsr.mail.dto;

import org.springframework.stereotype.Component;

import com.vsr.mail.model.Details;

@Component
public class DetailsMapping {

	public Details transformTo(String name, String fromAddress, String toAddress, String gmail, long mobileNumber) {
		Details details = new Details();
		details.setName(name);
		details.setFromAddress(fromAddress);
		details.setToAddress(toAddress);
		details.setGmail(gmail);
		details.setMobileNumber(mobileNumber);
		return details;
	}
	
	
}
