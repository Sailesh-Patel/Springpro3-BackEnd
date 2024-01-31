package com.LBG.jalal.service;

import org.springframework.stereotype.Service;

import com.LBG.jalal.repo.BuyerRepo;

@Service
public class BuyerService {

	private BuyerRepo buyerRepo;

	public BuyerService(BuyerRepo buyerRepo) {
		super();
		this.buyerRepo = buyerRepo;
	}

}
