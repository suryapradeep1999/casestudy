package com.casestudy.RegistrationService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.RegistrationService.models.Registration;
import com.casestudy.RegistrationService.service.RegistrationServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private RegistrationServiceImpl registrationService;

	@GetMapping(value = "/getallregistrations")
	public ResponseEntity<?> getAllRegistrations() {
		try {
			List<Registration> registration = registrationService.getAllRegistrations();
			return new ResponseEntity<>(registration, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/add")
	public void addnew(@RequestBody Registration registration, BindingResult result) {
		registrationService.add(registration);
	}
}
