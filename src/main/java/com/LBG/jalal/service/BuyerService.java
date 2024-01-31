package com.LBG.jalal.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.jalal.domain.Buyer;
import com.LBG.jalal.repo.BuyerRepo;

@Service
public class BuyerService {

	private BuyerRepo buyerRepo;

	public BuyerService(BuyerRepo buyerRepo) {
		super();
		this.buyerRepo = buyerRepo;
	}

	public ResponseEntity<Object> createBuyer(Buyer newBuyer) {

		List<Buyer> buyers = this.buyerRepo.findAll();

		for (Buyer buyer : buyers) {
			if (newBuyer.getFirstname().equals(buyer.getFirstname())
					&& (newBuyer.getSurname().equals(buyer.getSurname()))) {
				return new ResponseEntity<Object>("Buyer Already Exists: ", HttpStatus.BAD_REQUEST);
			}

		}

		Buyer Created = this.buyerRepo.save(newBuyer);
		return ResponseEntity.ok(Created);

//		In React - Buyer returned successfully - Entity Created
	}

	public List<Buyer> displayBuyers() {
		return this.buyerRepo.findAll();

	}

	public boolean deleteBuyer(int id) {
		this.buyerRepo.deleteById(id);
		return !this.buyerRepo.existsById(id);

	}

}
