package com.example.Email2.api;

import com.example.Email2.DTO.NotificationDTO;
import com.example.Email2.email.MailService;
import com.example.Email2.entities.Student;
import com.example.Email2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	private MailService mailService;
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestParam int id, @RequestBody NotificationDTO notificationDTO) {
		try {
			Optional<Student> student = studentService.getStudentById(id);
			if (student.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				mailService.sendTo(
						studentService.getStudentById(notificationDTO.getContactId()).get().getEmail(),
						notificationDTO.getTitle(),
						notificationDTO.getText()
				);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
