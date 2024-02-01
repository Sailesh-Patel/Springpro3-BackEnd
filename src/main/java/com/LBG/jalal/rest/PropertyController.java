package com.LBG.jalal.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.jalal.domain.Property;
import com.LBG.jalal.service.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {

	private PropertyService service;

	public PropertyController(PropertyService service) {
		super();
		this.service = service;
	}

//	create property
	@PostMapping("/create")
	public Property createProperty(@RequestBody Property newProperty) {
		return this.service.createProperty(newProperty);
	}

//	list all properties
	@GetMapping("/display")
	public List<Property> displayProperties() {
		return this.service.displayProperties();
	}

//	Update property
	@PatchMapping("/update/{id}")
	public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody Property updatedProperty) {
		return this.service.updateProperty(id, updatedProperty);
	}

	@GetMapping("/display/{id}")
	public ResponseEntity<Property> displayProperty(@PathVariable int id) {
		return this.service.displayProperty(id);
	}
}
