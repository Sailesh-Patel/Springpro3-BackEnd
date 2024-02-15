package com.LBG.jalal.buyerTest;

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
@Sql(scripts = { "classpath:estate-schema.sql",
		"classpath:estate-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class BuyerTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		new WebDriverWait(driver, Duration.ofSeconds(3));

	}

	@Test
	@Order(2)
	void testCreatebuyer() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);
		WebElement buyerButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(2)"));
		buyerButton.click();

		String buyerTitle = "Mr";
		WebElement title = this.driver.findElement(By.xpath("/html/body/div/div/div/div/fieldset/form/input[1]"));
		title.sendKeys(buyerTitle);

		String buyerFirstName = "Andrew";
		WebElement firstName = this.driver.findElement(By.xpath("/html/body/div/div/div/div/fieldset/form/input[2]"));
		firstName.sendKeys(buyerFirstName);

		String buyerSurname = "McCall";
		WebElement surname = this.driver.findElement(By.xpath("/html/body/div/div/div/div/fieldset/form/input[3]"));
		surname.sendKeys(buyerSurname);

		String buyerTel = "01234567998";
		WebElement tel = this.driver.findElement(By.xpath("/html/body/div/div/div/div/fieldset/form/input[4]"));
		tel.sendKeys(buyerTel);

		Thread.sleep(1000);
		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > div > div > fieldset > form > div > button"));
		submit.click();

		WebElement displaybuyers = this.driver.findElement(By.cssSelector("#root > div > div > div > button"));
		displaybuyers.click();
		Thread.sleep(1000);

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

	@Test
	@Order(1)
	void testGetbuyer() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);
		WebElement buyerButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(2)"));
		buyerButton.click();

		Thread.sleep(800);
		WebElement displayBuyers = this.driver.findElement(By.xpath("/html/body/div/div/div/div/button"));
		displayBuyers.click();

		WebElement resultTitle = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > p.card-title"));
		Assertions.assertEquals("Title: Mr", resultTitle.getText());

		WebElement resultFirstName = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > p:nth-child(2)"));
		Assertions.assertEquals("First Name: Piers", resultFirstName.getText());

		WebElement resultSurname = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > p:nth-child(3)"));
		Assertions.assertEquals("Surname: Barber", resultSurname.getText());

		WebElement resultTel = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > p:nth-child(4)"));
		Assertions.assertEquals("Tel: 01234568999", resultTel.getText());
	}

}
