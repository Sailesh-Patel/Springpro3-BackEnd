package com.LBG.jalal.sellerTest;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:seller/seller-schema.sql",
		"classpath:seller/seller-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class SellerTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port; 
	
	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test
	@Order(1)
	void testGetSeller() {
		this.driver.get("http://localhost:" + this.port);
		WebElement sellerButton = this.driver.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(3)"));
		sellerButton.click();
		
		WebElement displaySellers = this.driver.findElement(By.id("getSellersButton"));
		displaySellers.click();
		
		WebElement result = this.driver.findElement(By.id("first-name"));
		Assertions.assertEquals("First Name: Liam", result.getText());
	}
		
	}

