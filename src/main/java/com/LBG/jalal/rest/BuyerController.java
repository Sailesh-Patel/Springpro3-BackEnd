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

import com.LBG.jalal.domain.Buyer;
import com.LBG.jalal.service.BuyerService;

@RestController
@RequestMapping("/buyer")
@CrossOrigin
public class BuyerController {

	private BuyerService service;

	public BuyerController(BuyerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")

	public ResponseEntity<Object> createBuyer(@RequestBody Buyer newBuyer) {
		return this.service.createBuyer(newBuyer);
	}

	@GetMapping("/display")
	public List<Buyer> displayBuyers() {
		return this.service.displayBuyers();
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteBuyer(@PathVariable int id) {
		return this.service.deleteBuyer(id);
	}

}
