package com.LBG.jalal.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.jalal.domain.Seller;
import com.LBG.jalal.repo.SellerRepo;

@Service
public class SellerService {

	private SellerRepo sellerRepo;

	public SellerService(SellerRepo sellerRepo) {
		super();
		this.sellerRepo = sellerRepo;
	}

	public ResponseEntity<Object> createSeller(Seller newSeller) {

		List<Seller> sellers = this.sellerRepo.findAll();

		for (Seller seller : sellers) {
			if (newSeller.getFirstname().equals(seller.getFirstname())
					&& (newSeller.getSurname().equals(seller.getSurname()))) {
				return new ResponseEntity<Object>("Seller Already Exists: ", HttpStatus.BAD_REQUEST);
			}

		}

		Seller Created = this.sellerRepo.save(newSeller);
		return ResponseEntity.ok(Created);

//		In React - Seller returned successfully - Entity Created
	}

	public List<Seller> displaySellers() {
		return this.sellerRepo.findAll();

	}

	public boolean deleteSeller(int id) {
		this.sellerRepo.deleteById(id);
		return !this.sellerRepo.existsById(id);

	}

}
