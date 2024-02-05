package com.LBG.jalal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.jalal.domain.Booking;
import com.LBG.jalal.dto.BookingDTO;
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

	public List<BookingDTO> displayBookings() {
		List<Booking> bookings = this.bookingRepo.findAll();

		List<BookingDTO> dtos = new ArrayList<>();

		for (Booking booking : bookings) {
			BookingDTO dto = new BookingDTO();

			dto.setId(booking.getId());
			dto.setBuyerName(booking.getBuyer().getFirstName() + " " + booking.getBuyer().getSurname());
			dto.setDate(booking.getDate());
			dto.setTime(booking.getTime());
			dto.setProperty(booking.getProperty().getId());

			dtos.add(dto);

		}

		return dtos;
	}

	public boolean deleteBooking(int id) {

		this.bookingRepo.deleteById(id);

		return !this.bookingRepo.existsById(id);

	}

}
