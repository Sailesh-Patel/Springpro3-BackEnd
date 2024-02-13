DROP TABLE `buyer`;
DROP TABLE `property`;
DROP TABLE `booking`;
CREATE TABLE `booking` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`date` DATE,
	`time` TIME,
	`property_id` INT,
	 FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
	 FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`)
	 );