package com.LBG.jalal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.jalal.domain.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Integer> {

}
