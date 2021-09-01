package com.casestudy.BookingService.resource;

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

import com.casestudy.BookingService.models.Booking;
import com.casestudy.BookingService.service.BookingServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class BookingController {

	@Autowired
	private BookingServiceImpl bookingService;

	@PostMapping(value = "/add")
	public void addnew(@RequestBody Booking booking, BindingResult result) {
		bookingService.add(booking);
	}

	@GetMapping(value = "/getallbookings")
	public ResponseEntity<?> getAllBookings() {
		try {
			List<Booking> booking = bookingService.getAllBookings();
			return new ResponseEntity<>(booking, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
