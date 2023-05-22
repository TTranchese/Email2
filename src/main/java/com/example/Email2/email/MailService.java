package com.example.Email2.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailService {
	@Autowired
	private Environment environment;
	
	public void sendTo(String receiver, String subject, String text) throws MessagingException, IOException {
		Email emailSender = new Email("tommasotranchese.dev@gmail.com");
		Email emailReceiver = new Email(receiver);
		String formattedText = "<h1>Hello World!</h1>" +
				"<h2>You have a new message: </h2>" +
				"<img src='https://assets.gadgets360cdn.com/img/crypto/dogecoin-og-logo.png' alt='Alternative text' height='200'>" +
				"<h3>" + text + "</h3>";
		Content content = new Content("text/html", text);
		Mail mail = new Mail(emailSender, subject, emailReceiver, content);
		SendGrid sendGrid = new SendGrid(environment.getProperty("spring.sendgrid.api-key"));
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		Response response = sendGrid.api(request);
		response.getBody();
		
		
	}
}
