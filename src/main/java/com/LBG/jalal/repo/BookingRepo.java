package com.LBG.jalal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.jalal.domain.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
