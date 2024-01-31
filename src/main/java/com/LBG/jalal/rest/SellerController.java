package com.LBG.jalal.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.jalal.domain.Seller;
import com.LBG.jalal.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	private SellerService service;

	public SellerController(SellerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createSeller(@RequestBody Seller newSeller) {
		return this.service.createSeller(newSeller);
	}

	@GetMapping("/display")
	public List<Seller> displaySellers() {
		return this.service.displaySellers();
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteSeller(@PathVariable int id) {
		return this.service.deleteSeller(id);
	}
}
