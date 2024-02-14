package com.LBG.jalal.propertyTest;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:property/property-schema.sql",
		"classpath:property/property-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PropertyTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	private WebDriverWait wait;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test
	@Order(1)
	void testGetSeller() {
		this.driver.get("http://localhost:" + this.port);
		WebElement propertyButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(4)"));
		propertyButton.click();

		WebElement resultAddress = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[1]"));
		Assertions.assertEquals("Address: 123 Fake Street", resultAddress.getText());

		WebElement resultLocation = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[2]"));
		Assertions.assertEquals("Location: Fake City", resultLocation.getText());

		WebElement resultPrice = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[3]"));
		Assertions.assertEquals("Price: 120000", resultPrice.getText());

		WebElement resultPropertyType = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[4]"));
		Assertions.assertEquals("Type of Property: Detached", resultPropertyType.getText());

		WebElement resultBedrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[5]"));
		Assertions.assertEquals("No. of Bedrooms: 2", resultBedrooms.getText());

		WebElement resultBathrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[6]"));
		Assertions.assertEquals("No. of Bathrooms: 1", resultBathrooms.getText());

		WebElement resultGarden = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[7]"));
		Assertions.assertEquals("Garden: Yes", resultGarden.getText());

		WebElement resultStatus = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[8]"));
		Assertions.assertEquals("Status: For Sale", resultStatus.getText());
	}

}
