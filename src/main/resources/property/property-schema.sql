CREATE TABLE IF NOT EXISTS `property` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`address` VARCHAR(255),
	`location` VARCHAR(255),
	`price` INT,
	`type_of_property` VARCHAR(255),
	`bedrooms` INT,
	`bathrooms` INT,
	`garden` VARCHAR(255),
	`upload_images` VARCHAR(255),
	`property_status` VARCHAR(255)
	);