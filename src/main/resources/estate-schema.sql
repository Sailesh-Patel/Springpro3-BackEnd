DROP TABLE if exists `booking`;
DROP TABLE if exists`property`;
DROP TABLE if exists `buyer`;
DROP TABLE if exists `seller`; 

	 
	 CREATE TABLE `buyer`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(255),
	`first_name` VARCHAR(255),
	`surname` VARCHAR(255),
	`tel` VARCHAR(255)
	);
	
	CREATE TABLE `seller`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(255),
	`first_name` VARCHAR(255),
	`surname` VARCHAR(255),
	`tel` VARCHAR(255)
	);
	
	CREATE TABLE `property` (
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
	
	CREATE TABLE `booking` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`date` DATE,
	`time` TIME,
	`property_id` INT,
	`buyer_id` INT,
	 FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
	 FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`)
	 );