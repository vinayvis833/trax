package com.trax.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

		 	@Autowired
		  	private JavaMailSender emailSender;
		 	
		    public void sendSimpleMessage( String to, String sub, String body) {
		    	
		        SimpleMailMessage message = new SimpleMailMessage(); 
		        message.setTo(to); 
		        message.setSubject(sub); 
		        message.setText(body);
		        emailSender.send(message);
		   }

}


