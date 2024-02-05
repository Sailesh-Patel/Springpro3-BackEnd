package com.LBG.jalal.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.jalal.domain.Booking;
import com.LBG.jalal.dto.BookingDTO;
import com.LBG.jalal.service.BookingService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/booking")
@CrossOrigin

public class BookingController {

	private BookingService service;

	public BookingController(BookingService service) {
		super();
		this.service = service;
	}

//	@PostMapping("/create")
//	public ResponseEntity<Booking> createBooking(@RequestBody Booking newBooking) {
//
//		return this.service.createBooking(newBooking);
//	}

	@PostMapping("/create")
	public ResponseEntity<Object> createBooking(@RequestBody Booking newBooking) {
		return this.service.createBooking(newBooking);
	}

	@GetMapping("/display")
	public List<BookingDTO> displayBookings() {
		return this.service.displayBookings();
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteBooking(@PathVariable int id) {
		return this.service.deleteBooking(id);
	}
}
