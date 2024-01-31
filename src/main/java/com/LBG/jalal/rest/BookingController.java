package com.LBG.jalal.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.jalal.domain.Booking;
import com.LBG.jalal.service.BookingService;

@RestController
@RequestMapping("/booking")

public class BookingController {

	private BookingService service;

	public BookingController(BookingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createBooking(Booking newBooking) {
		return this.service.createBooking(newBooking);
	}

	@GetMapping("/display")
	public List<Booking> displayBookings() {
		return this.service.displayBookings();
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteBooking(int id) {
		return this.service.deleteBooking(id);
	}
}
