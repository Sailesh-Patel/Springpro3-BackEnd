package com.LBG.jalal.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.jalal.domain.Booking;
import com.LBG.jalal.repo.BookingRepo;

@Service
public class BookingService {

	private BookingRepo bookingRepo;

	public BookingService(BookingRepo bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}

	public ResponseEntity<Object> createBooking(Booking newBooking) {

		List<Booking> bookings = this.bookingRepo.findAll();
		for (Booking booking : bookings) {
			if (newBooking.getDate().equals(booking.getDate()) && (newBooking.getTime().equals(booking.getTime()))) {
				return new ResponseEntity<Object>("Booking already exists", HttpStatus.BAD_REQUEST);
			}
		}

		Booking created = this.bookingRepo.save(newBooking);
		return ResponseEntity.ok(created);
	}

	public List<Booking> displayBookings() {
		return this.bookingRepo.findAll();
	}

	public boolean deleteBooking(int id) {

		this.bookingRepo.deleteById(id);

		return !this.bookingRepo.existsById(id);

	}

}
