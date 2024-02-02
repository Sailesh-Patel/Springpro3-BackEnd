package com.LBG.jalal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.jalal.domain.Property;
import com.LBG.jalal.repo.PropertyRepo;

@Service
public class PropertyService {

	private PropertyRepo propertyRepo;

	public PropertyService(PropertyRepo propertyRepo) {
		super();
		this.propertyRepo = propertyRepo;
	}

	public Property createProperty(Property newProperty) {
		return this.propertyRepo.save(newProperty);
	}

	public List<Property> displayProperties() {

		return this.propertyRepo.findAll();
	}

	public ResponseEntity<Property> updateProperty(int id, Property updatedProperty) {

		Optional<Property> found = this.propertyRepo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}

		Property existing = found.get();

		if (updatedProperty.getAddress() != null) {
			existing.setAddress(updatedProperty.getAddress());
		}

		if (updatedProperty.getTypeOfProperty() != null) {
			existing.setTypeOfProperty(updatedProperty.getTypeOfProperty());
		}

		if (updatedProperty.getBedrooms() != null) {
			existing.setBedrooms(updatedProperty.getBedrooms());
		}

		if (updatedProperty.getBathrooms() != null) {
			existing.setBathrooms(updatedProperty.getBathrooms());
		}

		if (updatedProperty.getGarden() != null) {
			existing.setGarden(updatedProperty.getGarden());
		}

		if (updatedProperty.getUploadImages() != null) {
			existing.setUploadImages(updatedProperty.getUploadImages());
		}

		if (updatedProperty.getPropertyStatus() != null) {
			existing.setPropertyStatus(updatedProperty.getPropertyStatus());
		}

		if (updatedProperty.getPrice() != null) {
			existing.setPrice(updatedProperty.getPrice());
		}

		Property updated = this.propertyRepo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public ResponseEntity<Property> displayProperty(int id) {

		Optional<Property> found = this.propertyRepo.findById(id);

		if (found.isEmpty()) {

			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}

		Property exsisitng = found.get();
		return ResponseEntity.ok(exsisitng);

	}

	public boolean deleteProperty(int id) {
		this.propertyRepo.deleteById(id);
		return !this.propertyRepo.existsById(id);

	}

}
