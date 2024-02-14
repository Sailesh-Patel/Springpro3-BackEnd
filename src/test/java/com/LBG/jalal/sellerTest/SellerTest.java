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
import org.openqa.selenium.support.ui.WebDriverWait;
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

	private WebDriverWait wait;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	}

	@Test
	@Order(2)
	void testCreateSeller() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);
		WebElement sellerButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(3)"));
		sellerButton.click();

		String sellerTitle = "Mr";
		WebElement title = this.driver.findElement(By.cssSelector("#sellersTitle"));
		title.sendKeys(sellerTitle);

		String sellerFirstName = "Andrew";
		WebElement firstName = this.driver.findElement(By.cssSelector("#sellersFirstName"));
		firstName.sendKeys(sellerFirstName);

		String sellerSurname = "McCall";
		WebElement surname = this.driver.findElement(By.cssSelector("#sellersSurname"));
		surname.sendKeys(sellerSurname);

		String sellerTel = "01234567998";
		WebElement tel = this.driver.findElement(By.cssSelector("#sellersTel"));
		tel.sendKeys(sellerTel);

		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > div > div > fieldset > form > div > button"));
		submit.click();

		Thread.sleep(500);
		WebElement displaySellers = this.driver.findElement(By.cssSelector("#root > div > div > div > button"));
		displaySellers.click();

//		this.driver.navigate().refresh();

//		WebElement displaySellers = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("getSellersButton")));
//		displaySellers.click();

		WebElement resultTitle = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p[1]"));
		Assertions.assertEquals("Title: Mr", resultTitle.getText());

		WebElement resultFirstName = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p[2]"));
		Assertions.assertEquals("First Name: Andrew", resultFirstName.getText());

		WebElement resultSurname = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p[3]"));
		Assertions.assertEquals("Surname: McCall", resultSurname.getText());

		WebElement resultTel = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p[4]"));
		Assertions.assertEquals("Tel: 01234567998", resultTel.getText());
	}

//	@Test
//	@Order(1)
//	void testGetSeller() {
//		this.driver.get("http://localhost:" + this.port);
//		WebElement sellerButton = this.driver
//				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(3)"));
//		sellerButton.click();
//
//		WebElement displaySellers = this.driver.findElement(By.cssSelector("#root > div > div > div > button"));
//		displaySellers.click();
//
//		WebElement resultTitle = this.driver.findElement(By.cssSelector(
//				"#root > div > div > div > div > div > div:nth-child(2) > div > div > div > p.card-title"));
//		Assertions.assertEquals("Title: Mr", resultTitle.getText());
//
//		WebElement resultFirstName = this.driver.findElement(By.cssSelector(
//				"#root > div > div > div > div > div > div:nth-child(2) > div > div > div > p:nth-child(2)"));
//		Assertions.assertEquals("First Name: Jordan", resultFirstName.getText());
//
//		WebElement resultSurname = this.driver.findElement(By.cssSelector(
//				"#root > div > div > div > div > div > div:nth-child(2) > div > div > div > p:nth-child(3)"));
//		Assertions.assertEquals("Surname: Harrison", resultSurname.getText());
//
//		WebElement resultTel = this.driver.findElement(By.cssSelector(
//				"#root > div > div > div > div > div > div:nth-child(2) > div > div > div > p:nth-child(4)"));
//		Assertions.assertEquals("Tel: 01234567999", resultTel.getText());
//	}

}
